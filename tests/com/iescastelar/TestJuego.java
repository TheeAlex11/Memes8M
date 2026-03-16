package com.iescastelar;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestJuego {

    @Test
    void puntuacionInicialEsCero() {

        List<Meme> memes = new ArrayList<>();
        List<Realidad> realidades = new ArrayList<>();
        Map<Integer, Integer> soluciones = new HashMap<>();

        Juego juego = new Juego(memes, realidades, soluciones);

        assertEquals(0, juego.getPuntuacion());
    }

    @Test
    void rankingSeMantieneSiNoHayCambio() {

        List<Meme> memes = new ArrayList<>();
        List<Realidad> realidades = new ArrayList<>();
        Map<Integer, Integer> soluciones = new HashMap<>();

        Juego juego = new Juego(memes, realidades, soluciones);

        List<Puntuacion> ranking = new ArrayList<>();
        ranking.add(new Puntuacion("Ana", 5));
        ranking.add(new Puntuacion("Luis", 4));
        ranking.add(new Puntuacion("Eva", 3));

        List<Puntuacion> resultado = juego.gestionarMejoresPuntuaciones(ranking);

        assertEquals(3, resultado.size());
    }

}
