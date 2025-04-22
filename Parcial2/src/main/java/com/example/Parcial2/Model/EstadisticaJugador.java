package com.example.Parcial2.Model;

import jakarta.persistence.*;

@Entity
public class EstadisticaJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estadistica;

    private int minutos_jugados;
    private int goles;
    private int asistencias;
    private int tarjetas_amarillas;
    private int tarjetas_rojas;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;

    public EstadisticaJugador() {
    }

    public EstadisticaJugador(Long id_estadistica, int minutos_jugados, int goles, int asistencias, int tarjetas_amarillas, int tarjetas_rojas, Jugador jugador, Partido partido) {
        this.id_estadistica = id_estadistica;
        this.minutos_jugados = minutos_jugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjetas_amarillas = tarjetas_amarillas;
        this.tarjetas_rojas = tarjetas_rojas;
        this.jugador = jugador;
        this.partido = partido;
    }

    public Long getId_estadistica() {
        return id_estadistica;
    }

    public void setId_estadistica(Long id_estadistica) {
        this.id_estadistica = id_estadistica;
    }

    public int getMinutos_jugados() {
        return minutos_jugados;
    }

    public void setMinutos_jugados(int minutos_jugados) {
        this.minutos_jugados = minutos_jugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getTarjetas_amarillas() {
        return tarjetas_amarillas;
    }

    public void setTarjetas_amarillas(int tarjetas_amarillas) {
        this.tarjetas_amarillas = tarjetas_amarillas;
    }

    public int getTarjetas_rojas() {
        return tarjetas_rojas;
    }

    public void setTarjetas_rojas(int tarjetas_rojas) {
        this.tarjetas_rojas = tarjetas_rojas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "EstadisticaJugador{" +
                "id_estadistica=" + id_estadistica +
                ", minutos_jugados=" + minutos_jugados +
                ", goles=" + goles +
                ", asistencias=" + asistencias +
                ", tarjetas_amarillas=" + tarjetas_amarillas +
                ", tarjetas_rojas=" + tarjetas_rojas +
                ", jugador=" + jugador +
                ", partido=" + partido +
                '}';
    }
}
