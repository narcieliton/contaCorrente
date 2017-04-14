package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transacao implements Serializable {

    @Id
    @GeneratedValue(generator = "TRANSACAO_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TRANSACAO_SEQ", sequenceName = "TRANSACAO_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataTransacao;

    @Column
    private Double valor;

    @Column
    private Integer tipoTransacao;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "contaCorrente_transacao")
    private ContaCorrente contaCorrente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Integer getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(Integer tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transacao transacao = (Transacao) o;

        return id != null ? id.equals(transacao.id) : transacao.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
