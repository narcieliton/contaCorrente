package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ContaCorrente implements Serializable{

    public final static Double valorTransferencia = 1.75;
    public final static Double valorSaque = 3.90;

    @Id
    @GeneratedValue(generator = "CONTA_CORRENTE_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CONTA_CORRENTE_SEQ", sequenceName = "CONTA_CORRENTE_SEQ", allocationSize = 1)
    @Column(name = "CONTA_CORRENTE_ID")
    private Long id;

    @Column(name = "SALDO_CONTA")
    private Double saldoConta;

    @Column(name = "LIMITE_CONTA")
    private Double limiteConta;

    @OneToOne
    @JoinColumn(name = "conta_pessoa")
    private Pessoa pessoa;

    @OneToMany(mappedBy = "contaCorrente", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Transacao> listaTransacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public Double getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(Double limiteConta) {
        this.limiteConta = limiteConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Transacao> getListaTransacao() {
        return listaTransacao;
    }

    public void setListaTransacao(List<Transacao> listaTransacao) {
        this.listaTransacao = listaTransacao;
    }
}
