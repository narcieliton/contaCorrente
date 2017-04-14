package bean;

import java.io.Serializable;

public class ContaCorrenteBean implements Serializable {

    private Long id;
    private Long idDestinatarioTransferencia;
    private Double saldo;
    private Double limite;
    private Double valor;
    private Integer tipoTransacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDestinatarioTransferencia() {
        return idDestinatarioTransferencia;
    }

    public void setIdDestinatarioTransferencia(Long idDestinatarioTransferencia) {
        this.idDestinatarioTransferencia = idDestinatarioTransferencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(Integer tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
