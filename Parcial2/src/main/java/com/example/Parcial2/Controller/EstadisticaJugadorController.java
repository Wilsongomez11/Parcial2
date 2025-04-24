package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.EstadisticaJugador;
import com.example.Parcial2.Service.EstadisticaJugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/estadisticas-jugadores")
public class EstadisticaJugadorController {

    private final EstadisticaJugadorService estadisticaJugadorService;

    public EstadisticaJugadorController(EstadisticaJugadorService estadisticaJugadorService) {
        this.estadisticaJugadorService = estadisticaJugadorService;
    }

    @GetMapping
    public List<EstadisticaJugador> getAllEstadisticas() {
        return estadisticaJugadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> getEstadisticaById(@PathVariable Long id) {
        Optional<EstadisticaJugador> estadistica = estadisticaJugadorService.findById(id);
        return estadistica.isPresent() ? ResponseEntity.ok(estadistica.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EstadisticaJugador> createEstadistica(@RequestBody EstadisticaJugador estadistica) {
        EstadisticaJugador newEstadistica = estadisticaJugadorService.save(estadistica);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEstadistica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> updateEstadistica(@PathVariable Long id, @RequestBody EstadisticaJugador estadistica) {
        Optional<EstadisticaJugador> existingEstadistica = estadisticaJugadorService.findById(id);
        if (existingEstadistica.isPresent()) {
            estadistica.setId_estadistica(id);
            EstadisticaJugador updatedEstadistica = estadisticaJugadorService.save(estadistica);
            return ResponseEntity.ok(updatedEstadistica);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadistica(@PathVariable Long id) {
        Optional<EstadisticaJugador> existingEstadistica = estadisticaJugadorService.findById(id);
        if (existingEstadistica.isPresent()) {
            estadisticaJugadorService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/total-goles/{id_equipo}")
    public Integer getTotalGolesPorEquipo(@PathVariable Long id_equipo) {
        return estadisticaJugadorService.totalGolesPorEquipo(id_equipo);
    }
}

