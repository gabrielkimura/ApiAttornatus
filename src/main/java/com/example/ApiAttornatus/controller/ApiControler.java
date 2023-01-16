package com.example.ApiAttornatus.controller;

import com.example.ApiAttornatus.model.Endereco;
import com.example.ApiAttornatus.model.Pessoa;
import com.example.ApiAttornatus.service.SqlService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiControler {

    @Autowired
    private SqlService ws;

    @PostConstruct
    public void run(){
        String nome = "Rogerio";
        String nascimento = "2022-08-13";

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setNascimento(nascimento);

        String logradouro = "Rua j";
        long cep = 17055522;
        int numero = 1272;
        String cidade = "bauru";
        boolean isPrincipal = true;

        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setCep(cep);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);
        endereco.setPrincipal(isPrincipal);

        ws.insertPessoaEndereco(pessoa, endereco);

        ws.getPessoa(452L);
    }
}
