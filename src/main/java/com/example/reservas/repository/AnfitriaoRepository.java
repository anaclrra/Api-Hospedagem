package com.example.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservas.domain.anfitriao.Anfitriao;

public interface AnfitriaoRepository extends JpaRepository<Anfitriao, Long> {
    
}
