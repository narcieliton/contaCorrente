package bean;

import java.io.Serializable;

public class TipoTransacaoBean implements Serializable {

    private Integer codigo;
    private String descricacao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }
}
