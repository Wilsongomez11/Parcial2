package com.example.Parcial2.Service;

import com.example.Parcial2.Model.Jugador;
import com.example.Parcial2.Repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> findById(Long id) {
        return jugadorRepository.findById(id);
    }

    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void delete(Long id) {
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> findByEquipo(Long id_equipo) {
        return jugadorRepository.findByEquipo(id_equipo);
    }

    public List<Jugador> findByGolesMayoresA(int goles) {
        return jugadorRepository.findByGolesMayoresA(goles);
    }
}
