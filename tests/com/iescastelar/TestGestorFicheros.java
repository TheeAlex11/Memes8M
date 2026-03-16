package com.iescastelar;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestGestorFicheros {
    @Test
    public void testComprobarFicherosDatos() {
        try {
            GestorFicheros.comprobarFicherosDatos();
        } catch (IOException excepcion) {
            fail("Faltan ficheros de datos: " + excepcion.getMessage());
        }
    }

    @Test
    public void testPrepararResultados() {
        try {
            GestorFicheros.prepararResultados();
            assertTrue(Files.exists(Paths.get("resultados/mejores.txt")));
        } catch (IOException excepcion) {
            fail("No se pudo preparar el directorio de resultados: " + excepcion.getMessage());
        }
    }

    @Test
    public void testGuardarPuntuacion() {
        List<Puntuacion> puntuaciones = List.of(
            new Puntuacion("Alice", 150),
            new Puntuacion("Bob", 120),
            new Puntuacion("Charlie", 90)
        );
        try {
            GestorFicheros.guardarPuntuaciones(puntuaciones);
            String contenido = new String(Files.readAllBytes(Paths.get("resultados/mejores.txt")));
            assertTrue(contenido.contains("Alice#150"));
            assertTrue(contenido.contains("Bob#120"));
            assertTrue(contenido.contains("Charlie#90"));
        } catch (IOException excepcion) {
            fail("No se pudo guardar la puntuación: " + excepcion.getMessage());
        }
    }
}
