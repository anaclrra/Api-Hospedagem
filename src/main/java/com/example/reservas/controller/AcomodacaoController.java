package com.example.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservas.domain.acomodacao.Acomodacao;
import com.example.reservas.repository.AcomodacaoRepository;

@RestController
@RequestMapping("/acomodacao")
public class AcomodacaoController {
    
    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    @GetMapping
    public List<Acomodacao> getAllAccommodations() {
        return acomodacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acomodacao> getAccommodationById(@PathVariable Long id) {
        return acomodacaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping
    public Acomodacao createAccommodation(@RequestBody Acomodacao acomodacao) {
        return acomodacaoRepository.save(acomodacao);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Acomodacao> updateAccommodation(@PathVariable Long id, @RequestBody Acomodacao acomodacaoDetails) {
        Acomodacao acomodacaoLocal = acomodacaoRepository.findById(
            acomodacaoDetails.getNome()).get();
            

            acomodacaoLocal.setNome(acomodacaoDetails.getNome());
    
            return ResponseEntity.ok(acomodacaoLocal);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccommodation(@PathVariable Long id) {
        return acomodacaoRepository.findById(id)
                .map(acomodacao -> {
                    acomodacaoRepository.delete(acomodacao);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
