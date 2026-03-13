import static org.junit.Assert.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import fuentes.GestorFicheros;
import org.junit.Test;

public class TestGestorFicheros {
    @Test
    public void testComprobarFicherosDatos() {
        // Comprobamos que no lanza excepción si los ficheros existen
        try {
            GestorFicheros.comprobarFicherosDatos();
        } catch (IOException e) {
            fail("No debería lanzar excepción si los ficheros existen");
        }
    }
        // Comprobamos que lanza excepción si falta algún fichero
        try {
            // Renombramos temporalmente un fichero para simular su ausencia
            Path path = Paths.get("datos/memes.txt");
            Path tempPath = Paths.get("datos/memes_temp.txt");
            Files.move(path, tempPath);

            GestorFicheros.comprobarFicherosDatos();
            fail("Debería lanzar excepción si falta un fichero");
        } catch (IOException e) {
            assertTrue(e.getMessage().contains("Falta el fichero"));
        } finally {
            // Restauramos el fichero renombrado
            try {
                Files.move(Paths.get("datos/memes_temp.txt"), Paths.get("datos/memes.txt"));
            } catch (IOException e) {
                // No hacemos nada, es solo para restaurar el estado original
            }
        }
        
        @Test
        public void testPrepararResultados() {
            // Comprobamos que crea el directorio y el fichero si no existen
            try {
                // Eliminamos el directorio de resultados si existe para probar la creación
                Path dir = Paths.get("resultados");
                if (Files.exists(dir)) {
                    Files.walk(dir)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                }

                GestorFicheros.prepararResultados();
                assertTrue(Files.exists(dir));
                assertTrue(Files.exists(Paths.get("resultados/mejores.txt")));
            } catch (IOException e) {
                fail("No debería lanzar excepción al preparar resultados");
            }
        }

        @Test
        public void testPrepararResultadosExistente() {
            // Comprobamos que no lanza excepción si el directorio y el fichero ya existen
            try {
                GestorFicheros.prepararResultados();
            } catch (IOException e) {
                fail("No debería lanzar excepción si el directorio y el fichero ya existen");
            }
        }

        @Test
        public void testLeerMemes() {
            // Comprobamos que lee correctamente el fichero de memes
            try {
                List<Meme> memes = GestorFicheros.leerMemes();
                assertNotNull(memes);
                assertFalse(memes.isEmpty());
                // Comprobamos el formato de los memes leídos
                for (Meme meme : memes) {
                    assertNotNull(meme.getId());
                    assertNotNull(meme.getTexto());
                }
            } catch (IOException e) {
                fail("No debería lanzar excepción al leer memes");
            }
        }

        @Test
        public void testLeerRealidades() {
            // Comprobamos que lee correctamente el fichero de realidades
            try {
                List<Realidad> realidades = GestorFicheros.leerRealidades();
                assertNotNull(realidades);
                assertFalse(realidades.isEmpty());
                // Comprobamos el formato de las realidades leídas
                for (Realidad realidad : realidades) {
                    assertNotNull(realidad.getId());
                    assertNotNull(realidad.getDescripcion());
                }
            } catch (IOException e) {
                fail("No debería lanzar excepción al leer realidades");
            }
        }
        
        @Test
        public void testLeerPuntuaciones() {
            // Comprobamos que lee correctamente el fichero de mejores puntuaciones
            try {
                List<Puntuacion> puntuaciones = GestorFicheros.leerPuntuaciones();
                assertNotNull(puntuaciones);
                // No es obligatorio que haya puntuaciones, pero si las hay, deben tener formato correcto
                for (Puntuacion puntuacion : puntuaciones) {
                    assertNotNull(puntuacion.getNombre());
                    assertTrue(puntuacion.getPuntos() >= 0);
                }
            } catch (IOException e) {
                fail("No debería lanzar excepción al leer puntuaciones");
            }
        }

        @Test
        public void testGuardarPuntuaciones() {
            try {
                // Creamos una lista de puntuaciones de prueba
                List<Puntuacion> puntuaciones = new ArrayList<>();
                puntuaciones.add(new Puntuacion("Jugador1", 100));
                puntuaciones.add(new Puntuacion("Jugador2", 150));

                // Guardamos las puntuaciones
                GestorFicheros.guardarPuntuaciones(puntuaciones);

                // Leemos las puntuaciones guardadas para verificar que se han guardado correctamente
                List<Puntuacion> puntuacionesLeidas = GestorFicheros.leerPuntuaciones();
                assertNotNull(puntuacionesLeidas);
                assertEquals(2, puntuacionesLeidas.size());
                assertEquals("Jugador1", puntuacionesLeidas.get(0).getNombre());
                assertEquals(100, puntuacionesLeidas.get(0).getPuntos());
                assertEquals("Jugador2", puntuacionesLeidas.get(1).getNombre());
                assertEquals(150, puntuacionesLeidas.get(1).getPuntos());
            } catch (IOException e) {
                fail("No debería lanzar excepción al guardar o leer puntuaciones");
            }
        }
}