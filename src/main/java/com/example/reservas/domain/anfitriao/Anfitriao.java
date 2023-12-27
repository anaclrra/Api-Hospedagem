package com.example.reservas.domain.anfitriao;

import java.util.List;

import com.example.reservas.domain.acomodacao.Acomodacao;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "anfitriao")    
@Table(name = "anfitriao")     
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Anfitriao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String nome;
    
    private String nacionalidade;

    @OneToMany(mappedBy = "anfitriao")
    private List<Acomodacao> acomodacao;
}
