package com.example.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservas.domain.acomodacao.Acomodacao;

public interface AcomodacaoRepository extends JpaRepository<Acomodacao, Long> {
    
}
