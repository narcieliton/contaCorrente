package repository;

import entity.ContaCorrente;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.Serializable;

public class Contas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public void guardar(ContaCorrente contaCorrente) {
             manager.merge(contaCorrente);

    }

    public ContaCorrente consultarPorId(Long id) {
        try {
            StringBuilder hq = new StringBuilder();
            hq.append("from ContaCorrente where id =:id");

            return manager.createQuery(hq.toString(), ContaCorrente.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
