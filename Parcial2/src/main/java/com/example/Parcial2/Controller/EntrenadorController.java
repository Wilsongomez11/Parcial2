package com.example.Parcial2.Controller;

import org.springframework.http.HttpStatus;
import com.example.Parcial2.Model.Entrenador;
import com.example.Parcial2.Service.EntrenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public List<Entrenador> getAllEntrenadores() {
        return entrenadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getEntrenadorById(@PathVariable Long id) {
        Optional<Entrenador> entrenador = entrenadorService.findById(id);
        return entrenador.isPresent() ? ResponseEntity.ok(entrenador.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Entrenador> createEntrenador(@RequestBody Entrenador entrenador) {
        Entrenador newEntrenador = entrenadorService.save(entrenador);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> updateEntrenador(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        Optional<Entrenador> existingEntrenador = entrenadorService.findById(id);
        if (existingEntrenador.isPresent()) {
            entrenador.setId_entrenador(id);
            Entrenador updatedEntrenador = entrenadorService.save(entrenador);
            return ResponseEntity.ok(updatedEntrenador);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Long id) {
        Optional<Entrenador> existingEntrenador = entrenadorService.findById(id);
        if (existingEntrenador.isPresent()) {
            entrenadorService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

