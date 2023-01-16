package com.example.ApiAttornatus.model;

import jakarta.persistence.*;



@NamedQuery(
        name="Endereco.findEnderecoPessoa",
        query="SELECT e FROM Endereco e WHERE e.pessoa = ?1"
)
@Entity
@Table(name = "Endereco")
public class Endereco {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long codEndereco;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "cep")
    private long cep;
    @Column(name = "numero")
    private int numero;
    @Column(name = "cidade")
    private String cidade;

    @Column(name = "principal")
    private boolean principal;

    @ManyToOne
    private Pessoa pessoa;

    public Endereco() {
    }

    public long getId() {
        return codEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
}
