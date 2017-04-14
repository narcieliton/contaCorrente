package serviceImpl;

public enum  EnumTipoTransacao {

    DEPOSITO(1, "Deposito"),
    SAQUE(2, "Saque"),
    TRANSFERENCIA(3, "Transferência");

    private Integer id;
    private String descricao;

    EnumTipoTransacao(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
