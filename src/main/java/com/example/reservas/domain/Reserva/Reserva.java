package com.example.reservas.domain.Reserva;

import java.time.LocalDate;

import com.example.reservas.domain.Hospede.Hospede;
import com.example.reservas.domain.acomodacao.Acomodacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "reserva")    
@Table(name = "reserva")    
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="data_inicio")
    private LocalDate dataInicio;
    @Column(name="data_fim")
    @NotBlank
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "acomodacao_id")
    @NotBlank
    private Acomodacao acomodacao;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

}
