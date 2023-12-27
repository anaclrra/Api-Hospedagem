package com.example.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservas.domain.Hospede.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    
}
