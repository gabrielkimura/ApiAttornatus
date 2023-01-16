package com.example.ApiAttornatus.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long codPessoa;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nascimento")
    private String nascimento;
    @OneToMany
    private List<Endereco> enderecos;


    public int getId() {
        return Math.toIntExact(codPessoa);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

}
