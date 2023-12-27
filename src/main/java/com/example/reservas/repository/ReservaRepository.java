package com.example.reservas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservas.domain.Reserva.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    List<Reserva> findByGuestIdAndEndDateAfter(Long guestId, LocalDate currentDate);
}
