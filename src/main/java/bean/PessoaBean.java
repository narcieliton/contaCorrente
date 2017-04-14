package bean;

import java.io.Serializable;
import java.util.Date;

public class PessoaBean implements Serializable {

    private Long idPessoa;
    private Long idConta;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private Date dataNascimento;
    private Date dataCadastro;

    private ContaCorrenteBean contaCorrenteBean;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ContaCorrenteBean getContaCorrenteBean() {
        return contaCorrenteBean;
    }

    public void setContaCorrenteBean(ContaCorrenteBean contaCorrenteBean) {
        this.contaCorrenteBean = contaCorrenteBean;
    }
}
