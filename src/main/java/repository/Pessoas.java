package repository;

import entity.Pessoa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.Serializable;

public class Pessoas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public void guardar(Pessoa pessoa) {
             manager.merge(pessoa);

    }

    public Pessoa consultar(String cpf) {
        try {
            StringBuilder hq = new StringBuilder();
            hq.append("from Pessoa where cpf =:cpf");

            return manager.createQuery(hq.toString(), Pessoa.class).setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
