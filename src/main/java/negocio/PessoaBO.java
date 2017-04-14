package negocio;

import entity.Pessoa;
import jpa.Transactional;
import repository.Pessoas;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PessoaBO {

    @Inject
    private Pessoas pessoas;

    @Transactional
    public Pessoa consultar(String cpf){
        return pessoas.consultar(cpf);
    }

    @Transactional
    public void salvar(Pessoa pessoa){

      pessoas.guardar(pessoa);
    }
}
