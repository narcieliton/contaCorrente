package serviceImpl;

import bean.ContaCorrenteBean;
import entity.ContaCorrente;
import entity.Transacao;
import negocio.ContaCorrenteBO;
import negocio.TransacaoBO;
import service.TransacaoService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;

@Stateless
public class TransacaoServiceImpl implements TransacaoService {

    @Inject
    TransacaoBO transacaoBO;

    @Inject
    ContaCorrenteBO contaCorrenteBO;

    public Response efetuarTransacao(ContaCorrenteBean contaCorrenteBean) throws Exception {
        ContaCorrente conta = contaCorrenteBO.consultarPorId(contaCorrenteBean.getId());
        Transacao transacao = new Transacao();

        transacao.setValor(contaCorrenteBean.getValor());
        transacao.setDataTransacao(new Date());

        if(EnumTipoTransacao.DEPOSITO.getId() == contaCorrenteBean.getTipoTransacao()) {
            transacao.setTipoTransacao(EnumTipoTransacao.DEPOSITO.getId());
            conta.setSaldoConta(conta.getSaldoConta() + contaCorrenteBean.getValor());
        }
        else if(EnumTipoTransacao.SAQUE.getId() == contaCorrenteBean.getTipoTransacao()) {
            transacao.setTipoTransacao(EnumTipoTransacao.SAQUE.getId());

            verificarSaldoParaTransacaoSaque(contaCorrenteBean, conta);

        }
        transacao.setContaCorrente(conta);
        transacaoBO.salvar(transacao);

        if(EnumTipoTransacao.TRANSFERENCIA.getId() == contaCorrenteBean.getTipoTransacao()) {
            transacao.setTipoTransacao(EnumTipoTransacao.TRANSFERENCIA.getId());

            ContaCorrente contaDestinatarioTransferencia = contaCorrenteBO.consultarPorId(contaCorrenteBean.getIdDestinatarioTransferencia());

            if(contaDestinatarioTransferencia.getId() == conta.getId()){
                throw new Exception("Não pode transferência para a mesma conta");
            }
            else if ((conta.getSaldoConta() + conta.getLimiteConta()) >= (contaCorrenteBean.getValor() + ContaCorrente.valorTransferencia)) {
                conta.setSaldoConta(conta.getSaldoConta() - (contaCorrenteBean.getValor() + ContaCorrente.valorTransferencia));
                contaDestinatarioTransferencia.setSaldoConta(contaDestinatarioTransferencia.getSaldoConta() + contaCorrenteBean.getValor());

                Transacao transacaoTransferencia = new Transacao();

                transacao.setContaCorrente(conta);
                transacaoTransferencia.setContaCorrente(contaDestinatarioTransferencia);

                transacaoBO.salvarTransferencia(transacao, transacaoTransferencia);

            } else {
                throw new Exception("Saldo insuficiente.");
            }
        }
        return null;
    }
    private ContaCorrente verificarSaldoParaTransacaoSaque(ContaCorrenteBean bean, ContaCorrente conta) throws Exception {

        Calendar calendar = Calendar.getInstance();
        int mes = calendar.get(Calendar.MONTH);
        int ano = calendar.get(Calendar.YEAR);
        mes += 1;
        Long quantidade = transacaoBO.quantidadeSaqueMes(bean.getId(), EnumTipoTransacao.SAQUE.getId(), mes, ano);

        if(quantidade > 4){
            if ((conta.getSaldoConta() + conta.getLimiteConta() + ContaCorrente.valorSaque) >= bean.getValor()) {
                conta.setSaldoConta(conta.getSaldoConta() - (bean.getValor() + ContaCorrente.valorSaque));
            }
        }
        else if ((conta.getSaldoConta() + conta.getLimiteConta()) >= bean.getValor()) {
            conta.setSaldoConta(conta.getSaldoConta() - bean.getValor());
        } else {
            throw new Exception("Saldo insuficiente.");
        }
        return conta;
    }

}
