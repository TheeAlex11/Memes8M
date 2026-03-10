import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Clase principal del proyecto Memes 8M.
 */
public class Main {

    public static void main(String[] args) {

        try {
            GestorFicheros.comprobarFicherosDatos();
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            System.exit(1);
        }

        try {
            GestorFicheros.prepararResultados();
        } catch (Exception e) {
            System.err.println("❌ ERROR al preparar resultados: " + e.getMessage());
            System.exit(1);
        }

        List<Meme> memes;
        try {
            memes = GestorFicheros.leerMemes();
        } catch (Exception e) {
            System.err.println("❌ ERROR al leer memes: " + e.getMessage());
            System.exit(1);
            return;
        }

        List<Realidad> realidades;
        try {
            realidades = GestorFicheros.leerRealidades();
        } catch (Exception e) {
            System.err.println("❌ ERROR al leer realidades: " + e.getMessage());
            System.exit(1);
            return;
        }

        Map<Integer, Integer> soluciones;
        try {
            soluciones = GestorFicheros.leerSoluciones();
        } catch (Exception e) {
            System.err.println("❌ ERROR al leer soluciones: " + e.getMessage());
            System.exit(1);
            return;
        }

        Juego juego = new Juego(memes, realidades, soluciones);
        juego.jugar();

        List<Puntuacion> puntuaciones;
        try {
            puntuaciones = GestorFicheros.leerPuntuaciones();
        } catch (Exception e) {
            puntuaciones = new ArrayList<>();
        }

        puntuaciones = juego.gestionarMejoresPuntuaciones(puntuaciones);

        try {
            GestorFicheros.guardarPuntuaciones(puntuaciones);
        } catch (Exception e) {
            System.err.println("⚠️ No se pudieron guardar las puntuaciones.");
        }

        System.out.println("\n🏆 MEJORES PUNTUACIONES:");
        System.out.println("──────────────────────────────────────────");
        if (puntuaciones.isEmpty()) {
            System.out.println("   Aún no hay puntuaciones registradas.");
        } else {
            for (int i = 0; i < puntuaciones.size(); i++) {
                Puntuacion p = puntuaciones.get(i);
                System.out.println("  " + (i + 1) + ". " + p.getNombre() + " → " + p.getPuntos() + " puntos");
            }
        }

        System.out.println("\n👋 ¡Gracias por jugar! Feliz 8M 💜\n");
    }
}