package com.iescastelar;

/**
 * Representa un meme con un bulo sobre igualdad de género.
 */
public class Meme {

    /** Identificador único del meme. */
    private Integer id;

    /** Texto del bulo que contiene el meme. */
    private String texto;

    /**
     * Constructor de Meme.
     * @param id Identificador del meme.
     * @param texto Texto del bulo.
     */
    public Meme(Integer id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    /**
     * Obtiene el identificador del meme.
     * @return id del meme.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Obtiene el texto del bulo.
     * @return texto del meme.
     */
    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return " MEME #" + id + ": \"" + texto + "\"";
    }
}
