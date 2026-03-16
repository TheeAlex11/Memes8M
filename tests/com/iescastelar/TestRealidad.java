package com.iescastelar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRealidad {

    // test para comprobar que el constructor funciona bien
    @Test
    public void testConstructor() {
        Realidad r = new Realidad(1, "texto de prueba", "fuente", "http://fuente.com");
        assertNotNull(r);
    }

    // compruebo que getId devuelve el id
    @Test
    public void testGetId() {
        Realidad r = new Realidad(1, "texto de prueba", "fuente", "http://fuente.com");
        assertEquals(1, r.getId());
    }

    // test del getTexto
    @Test
    public void testGetTexto() {
        Realidad r = new Realidad(1, "texto de prueba", "fuente", "http://fuente.com");
        assertEquals("texto de prueba", r.getTexto());
    }

    @Test
    public void testGetFuente() {
        Realidad r = new Realidad(1, "texto de prueba", "fuente", "http://fuente.com");
        assertEquals("fuente", r.getFuente());
    }

    // este test comprueba la url
    @Test
    public void testGetUrl() {
        Realidad r = new Realidad(1, "texto de prueba", "fuente", "http://fuente.com");
        assertEquals("http://fuente.com", r.getUrl());
    }

    // toString
    @Test
    public void testToString() {
        Realidad r = new Realidad(1, "texto de prueba", "fuente", "http://fuente.com");
        String resultado = r.toString();
        // compruebo que no es null
        assertNotNull(resultado);
    }

    @Test
    public void testToString2() {
        Realidad r = new Realidad(1, "texto de prueba", "fuente", "http://fuente.com");
        String resultado = r.toString();
        assertTrue(resultado.contains("texto de prueba"));
    }

    // otro test del tostring para comprobar que sale la fuente tambien
    @Test
    public void testToString3() {
        Realidad r = new Realidad(1, "texto de prueba", "fuente", "http://fuente.com");
        assertEquals("texto de prueba\n   [Fuente: fuente]", r.toString());
    }
}