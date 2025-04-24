package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Equipo;
import com.example.Parcial2.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<Equipo> getAllEquipos() {
        return equipoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoService.findById(id);
        return equipo.isPresent() ? ResponseEntity.ok(equipo.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
        Equipo newEquipo = equipoService.save(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEquipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        Optional<Equipo> existingEquipo = equipoService.findById(id);
        if (existingEquipo.isPresent()) {
            equipo.setId_equipo(id);
            Equipo updatedEquipo = equipoService.save(equipo);
            return ResponseEntity.ok(updatedEquipo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        Optional<Equipo> existingEquipo = equipoService.findById(id);
        if (existingEquipo.isPresent()) {
            equipoService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
