package com.example.Parcial2.Repository;

import com.example.Parcial2.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // Obtener todos los jugadores de un equipo específico
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :id_equipo", nativeQuery = true)
    List<Jugador> findByEquipo(Long id_equipo);

    // Obtener los jugadores que han marcado más numero de goles
    @Query(value = """
        SELECT j.* FROM jugador j
        JOIN estadistica_jugador e ON j.id_jugador = e.id_jugador
        GROUP BY j.id_jugador
        HAVING SUM(e.goles) > :goles
        """, nativeQuery = true)
    List<Jugador> findByGolesMayoresA(int goles);
}
