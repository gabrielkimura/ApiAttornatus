package com.example.ApiAttornatus.repository;

import com.example.ApiAttornatus.model.Endereco;
import com.example.ApiAttornatus.model.Pessoa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("endereco")
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco>findEnderecoPessoa(Pessoa pessoa);
}
