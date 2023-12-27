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

import com.example.reservas.domain.anfitriao.Anfitriao;
import com.example.reservas.repository.AnfitriaoRepository;

@RestController
@RequestMapping("/anfitriao")
public class AnfitriaoController {
    
    @Autowired
    private AnfitriaoRepository anfitriaoRepository;

    @GetMapping
    public List<Anfitriao> getAllAnfitriao() {
        return anfitriaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anfitriao> getAnfitriaoId(@PathVariable Long id) {
        return anfitriaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping
    public Anfitriao createAnfitriao(@RequestBody Anfitriao anfitriao) {
        return anfitriaoRepository.save(anfitriao);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Anfitriao> updateAnfitriao(@PathVariable Long id, @RequestBody Anfitriao anfitriaoDetails) {
        return anfitriaoRepository.findById(id)
                .map(anfitriao -> {
                    anfitriao.setNome(anfitriaoDetails.getNome());
                    anfitriao.setNacionalidade(anfitriaoDetails.getNacionalidade());
                    return ResponseEntity.ok(anfitriaoRepository.save(anfitriao));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnfitriao(@PathVariable Long id) {
        return anfitriaoRepository.findById(id)
                .map(anfitriao -> {
                    anfitriaoRepository.delete(anfitriao);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
