package com.example.Parcial2.Repository;

import com.example.Parcial2.Model.EstadisticaJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadisticaJugadorRepository extends JpaRepository<EstadisticaJugador, Long> {

    // Obtener número total de goles marcados por un equipo en todos sus partidos
    @Query(value = """
        SELECT SUM(ej.goles)
        FROM estadistica_jugador ej
        JOIN jugador j ON ej.id_jugador = j.id_jugador
        WHERE j.id_equipo = :id_equipo
        """, nativeQuery = true)
    Integer totalGolesPorEquipo(Long id_equipo);
}
