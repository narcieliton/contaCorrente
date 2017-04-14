package negocio;

import entity.ContaCorrente;
import jpa.Transactional;
import repository.Contas;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ContaCorrenteBO {

    @Inject
    private Contas contas;

    @Transactional
    public ContaCorrente consultarPorId(Long id){
        return contas.consultarPorId(id);
    }

    @Transactional
    public void salvar(ContaCorrente contaCorrente){
        contas.guardar(contaCorrente);
    }
}
