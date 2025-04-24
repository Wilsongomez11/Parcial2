package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Partido;
import com.example.Parcial2.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @GetMapping
    public List<Partido> getAllPartidos() {
        return partidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getPartidoById(@PathVariable Long id) {
        Optional<Partido> partido = partidoService.findById(id);
        return partido.isPresent() ? ResponseEntity.ok(partido.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Partido> createPartido(@RequestBody Partido partido) {
        Partido newPartido = partidoService.save(partido);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPartido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> updatePartido(@PathVariable Long id, @RequestBody Partido partido) {
        Optional<Partido> existingPartido = partidoService.findById(id);
        if (existingPartido.isPresent()) {
            partido.setId_partido(id);
            Partido updatedPartido = partidoService.save(partido);
            return ResponseEntity.ok(updatedPartido);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Long id) {
        Optional<Partido> existingPartido = partidoService.findById(id);
        if (existingPartido.isPresent()) {
            partidoService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/resultados")
    public List<Object[]> getResultadosPartidos() {
        return partidoService.obtenerResultadosPartidos();
    }
}
