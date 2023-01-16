package com.example.ApiAttornatus.repository;

import com.example.ApiAttornatus.model.Pessoa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("pessoa")
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
   List<Pessoa> findByNomeContains(String nome);
}
