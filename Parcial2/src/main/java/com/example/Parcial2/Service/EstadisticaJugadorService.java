package com.example.Parcial2.Service;

import com.example.Parcial2.Model.EstadisticaJugador;
import com.example.Parcial2.Repository.EstadisticaJugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaJugadorService {
    private final EstadisticaJugadorRepository estadisticaRepository;

    public EstadisticaJugadorService(EstadisticaJugadorRepository estadisticaRepository) {
        this.estadisticaRepository = estadisticaRepository;
    }

    public List<EstadisticaJugador> findAll() {
        return estadisticaRepository.findAll();
    }

    public Optional<EstadisticaJugador> findById(Long id) {
        return estadisticaRepository.findById(id);
    }

    public EstadisticaJugador save(EstadisticaJugador estadistica) {
        return estadisticaRepository.save(estadistica);
    }

    public void delete(Long id) {
        estadisticaRepository.deleteById(id);
    }

    public Integer totalGolesPorEquipo(Long id_equipo) {
        return estadisticaRepository.totalGolesPorEquipo(id_equipo);
    }
}
