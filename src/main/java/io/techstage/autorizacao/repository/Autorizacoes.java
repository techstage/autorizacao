package io.techstage.autorizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.techstage.autorizacao.model.Autorizacao;

public interface Autorizacoes extends JpaRepository<Autorizacao, Long> {
  
}