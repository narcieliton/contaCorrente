package serviceImpl;

import bean.ContaCorrenteBean;
import bean.PessoaBean;
import entity.ContaCorrente;
import entity.Pessoa;
import negocio.PessoaBO;
import service.PessoaService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless
public class PessoaServiceImpl implements PessoaService {


    @Inject
    PessoaBO pessoaBO;

    public PessoaBean consultarCpf(String cpf) {

        Pessoa pessoa =  pessoaBO.consultar(cpf);
        PessoaBean pessoaBean = new PessoaBean();

        if(pessoa != null) {
            pessoaBean.setIdPessoa(pessoa.getId());
            pessoaBean.setNome(pessoa.getNome());
            pessoaBean.setCpf(pessoa.getCpf());
            pessoaBean.setEmail(pessoa.getEmail());
            pessoaBean.setTelefone(pessoa.getTelefone());
            pessoaBean.setEndereco(pessoa.getEndereco());
            pessoaBean.setDataCadastro(pessoa.getDataDeCadastro());
            pessoaBean.setDataNascimento(pessoa.getDataDeNascimento());

            ContaCorrenteBean contaCorrenteBean = new ContaCorrenteBean();

            contaCorrenteBean.setId(pessoa.getContaCorrente().getId());
            contaCorrenteBean.setSaldo(pessoa.getContaCorrente().getSaldoConta());
            contaCorrenteBean.setLimite(pessoa.getContaCorrente().getLimiteConta());

            pessoaBean.setContaCorrenteBean(contaCorrenteBean);
        }
        else{
            pessoaBean.setCpf(cpf);
        }

        return pessoaBean;

    }

    public void salvar(PessoaBean bean){

        pessoaBO.salvar(popularEntidade(bean));

    }

    private Pessoa popularEntidade(PessoaBean bean){

        Pessoa pessoa = new Pessoa();

        pessoa.setCpf(bean.getCpf());
        pessoa.setNome(bean.getNome());
        pessoa.setEmail(bean.getEmail());
        pessoa.setTelefone(bean.getTelefone());
        pessoa.setEndereco(bean.getEndereco());
        pessoa.setDataDeCadastro(new Date());
        pessoa.setDataDeNascimento(bean.getDataNascimento());

        ContaCorrente contaCorrente = new ContaCorrente();

        contaCorrente.setLimiteConta(200.00);
        contaCorrente.setSaldoConta(0.0);

        pessoa.setContaCorrente(contaCorrente);


        return pessoa;
    }

}
