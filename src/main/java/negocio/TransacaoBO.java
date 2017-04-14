package negocio;

import entity.Transacao;
import jpa.Transactional;
import repository.Transacoes;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TransacaoBO  {

    @Inject
    private Transacoes transacoes;

    @Transactional
    public void salvar(Transacao transacao){
        transacoes.salvar(transacao);
    }

    @Transactional
    public void salvarTransferencia(Transacao transacao, Transacao transacaoTransferencia){
        transacoes.salvarTransferencia(transacao, transacaoTransferencia);
    }

   @Transactional
    public Long quantidadeSaqueMes(Long idContaCorrente, Integer tipoTransacao, Integer mes, Integer ano){
        return transacoes.quantidadeSaqueMes(idContaCorrente, tipoTransacao, mes, ano);
   }

}
