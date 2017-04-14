package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(generator = "PESSOA_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "PESSOA_SEQ", allocationSize = 1)
    @Column(name = "PESSOA_ID")
    private Long id;

    @Column(name = "NOME", length = 80)
    private String nome;

    @Column(name = "CPF", length = 11, unique = true)
    private String cpf;

    @Column(name = "EMAIL", length = 80)
    private String email;

    @Column(name = "TELEFONE", length = 11)
    private String telefone;

    @Column(name = "ENDERECO", length = 40)
    private String endereco;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_DE_CADASTRO")
    private Date dataDeCadastro;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_DE_NASCIMENTO")
    private Date dataDeNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_conta")
    private ContaCorrente contaCorrente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        return id != null ? id.equals(pessoa.id) : pessoa.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}


