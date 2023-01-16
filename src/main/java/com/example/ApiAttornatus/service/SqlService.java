package com.example.ApiAttornatus.service;

import com.example.ApiAttornatus.repository.EnderecoRepository;
import com.example.ApiAttornatus.repository.PessoaRepository;
import com.example.ApiAttornatus.model.Endereco;
import com.example.ApiAttornatus.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class SqlService {

    @Autowired
    private final PessoaRepository pessoaRepository;
    @Autowired
    private final EnderecoRepository enderecoRepository;

    public SqlService(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @RequestMapping(value = "/cadastrarPessoa", method = RequestMethod.POST)
    public String insertPessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);

        return pessoa.toString();
    }
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas;
        pessoas = pessoaRepository.findAll();

        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Pessoa>> getNome(@RequestParam("name") String nome){
        List<Pessoa> pessoas;
        pessoas = pessoaRepository.findByNomeContains(nome);

        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping(path = "/{codPessoa}")
    public String getPessoa(@PathVariable Long id){
        Pessoa pessoa;
        pessoa = pessoaRepository.findById(id).get();
        List<Endereco> enderecos;
        enderecos = enderecoRepository.findEnderecoPessoa(pessoa);

        return enderecos.toString();
    }

    @PutMapping(value = "/{codPessoa}")
    public ResponseEntity<Pessoa> update(@PathVariable long id, @RequestBody Pessoa newPessoa){
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setNome(newPessoa.getNome());
            pessoa.setNascimento(newPessoa.getNascimento());
            Pessoa pessoaUpdated = pessoaRepository.save(pessoa);
            return ResponseEntity.ok().body(pessoaUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{codPessoa}")
    public ResponseEntity<Pessoa> delete(@PathVariable long id){
        try{
            pessoaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{codEndereco}", method = RequestMethod.POST)
    public String insertEndereco(@PathVariable("codPessoa") long id, Endereco endereco){
            Pessoa pessoa = pessoaRepository.findById(id).get();
            endereco.setPessoa(pessoa);
            enderecoRepository.save(endereco);
            return endereco.toString();
    }

    @RequestMapping
    public String insertPessoaEndereco(Pessoa pessoa, Endereco endereco){
        insertPessoa(pessoa);
        insertEndereco(pessoa.getId(), endereco);

        return endereco.toString() + pessoa;
    }
}
