package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Jugador;
import com.example.Parcial2.Service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getJugadorById(@PathVariable Long id) {
        Optional<Jugador> jugador = jugadorService.findById(id);
        return jugador.isPresent() ? ResponseEntity.ok(jugador.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Jugador> createJugador(@RequestBody Jugador jugador) {
        Jugador newJugador = jugadorService.save(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(newJugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> updateJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
        Optional<Jugador> existingJugador = jugadorService.findById(id);
        if (existingJugador.isPresent()) {
            jugador.setId_jugador(id);
            Jugador updatedJugador = jugadorService.save(jugador);
            return ResponseEntity.ok(updatedJugador);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJugador(@PathVariable Long id) {
        Optional<Jugador> existingJugador = jugadorService.findById(id);
        if (existingJugador.isPresent()) {
            jugadorService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/equipo/{id_equipo}")
    public List<Jugador> getJugadoresByEquipo(@PathVariable Long id_equipo) {
        return jugadorService.findByEquipo(id_equipo);
    }

    @GetMapping("/goles/{goles}")
    public List<Jugador> getJugadoresByGoles(@PathVariable int goles) {
        return jugadorService.findByGolesMayoresA(goles);
    }
}

