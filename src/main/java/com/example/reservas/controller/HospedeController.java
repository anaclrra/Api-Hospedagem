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

import com.example.reservas.domain.Hospede.Hospede;
import com.example.reservas.repository.HospedeRepository;


@RestController
@RequestMapping("/hospede")
public class HospedeController {
    @Autowired
    private HospedeRepository hospedeRepository;

    @GetMapping
    public List<Hospede> getAllGuests() {
        return hospedeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> getGuestById(@PathVariable Long id) {
        return hospedeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping
    public Hospede createGuest(@RequestBody Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospede> updateGuest(@PathVariable Long id, @RequestBody Hospede hospedeDetails) {
        
        Hospede hospedeLocal = hospedeRepository.findById(
            hospedeDetails.getNome()).get();
            

            hospedeLocal.setNome(hospedeDetails.getNome());
    
        return ResponseEntity.ok(hospedeLocal);
    
                
    }

}
