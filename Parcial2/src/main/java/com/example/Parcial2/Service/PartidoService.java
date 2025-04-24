package com.example.Parcial2.Service;

import com.example.Parcial2.Model.Partido;
import com.example.Parcial2.Repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public List<Partido> findAll() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> findById(Long id) {
        return partidoRepository.findById(id);
    }

    public Partido save(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void delete(Long id) {
        partidoRepository.deleteById(id);
    }

    public List<Object[]> obtenerResultadosPartidos() {
        return partidoRepository.obtenerResultadosPartidos();
    }
}
