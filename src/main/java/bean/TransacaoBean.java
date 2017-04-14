package bean;

import java.io.Serializable;
import java.util.Date;

public class TransacaoBean implements Serializable {

    private Long idTransacao;
    private Long idPessoa;
    private Long idContaCorrente;
    private Long idPessoaTransferencia;
    private Double valor;
    private Integer tipoTransacao;
    private Date dataTransacao;

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdContaCorrente() {
        return idContaCorrente;
    }

    public void setIdContaCorrente(Long idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public Long getIdPessoaTransferencia() {
        return idPessoaTransferencia;
    }

    public void setIdPessoaTransferencia(Long idPessoaTransferencia) {
        this.idPessoaTransferencia = idPessoaTransferencia;
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

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
