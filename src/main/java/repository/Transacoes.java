package repository;

import entity.Transacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class Transacoes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public void salvar(Transacao transacao) {
        manager.merge(transacao);
    }

    public void salvarTransferencia(Transacao transacao, Transacao transacaoTransferencia) {
        manager.merge(transacaoTransferencia);
        manager.merge(transacao);
    }

    public Long quantidadeSaqueMes(Long idContaCorrente, Integer tipoTransacao, Integer mes, Integer ano){
        StringBuilder sb = new StringBuilder();

        sb.append("select count(*) from Transacao t ");
        sb.append(" where extract(MONTH from t.dataTransacao) = :mes " );
        sb.append(" and extract(YEAR from t.dataTransacao) = :ano " );
        sb.append(" and t.tipoTransacao = :tipoTransacao" );
        sb.append(" and t.contaCorrente.id = :idContaCorrente" );
        return  manager.createQuery(sb.toString(), Long.class).setParameter("mes", mes)
                .setParameter("ano", ano).setParameter("tipoTransacao", tipoTransacao).setParameter("idContaCorrente", idContaCorrente).getSingleResult();
    }
}
