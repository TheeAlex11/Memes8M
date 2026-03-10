package com.iescastelar;

/**
 * Representa una puntuación obtenida por un usuario en el juego.
 */
public class Puntuacion implements Comparable<Puntuacion> {

    /** Nombre del usuario. */
    private String nombre;

    /** Puntuación obtenida. */
    private Integer puntos;

    /**
     * Constructor de Puntuacion.
     * @param nombre Nombre del usuario.
     * @param puntos Puntos obtenidos.
     */
    public Puntuacion(String nombre, Integer puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return nombre del usuario.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene los puntos obtenidos.
     * @return puntuación.
     */
    public Integer getPuntos() {
        return this.puntos;
    }

    /**
     * Compara esta puntuación con otra para ordenar de mayor a menor.
     * @param otra La otra puntuación a comparar.
     * @return valor negativo si esta puntuación es mayor.
     */
    @Override
    public int compareTo(Puntuacion otra) {
        return Integer.compare(otra.puntos, this.puntos);
    }

    @Override
    public String toString() {
        return nombre + "#" + puntos;
    }
}
