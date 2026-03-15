import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Contiene la lógica principal del juego de memes 8M.
 * <p>
 * Gestiona las rondas, la puntuación del jugador y la interacción
 * con el usuario durante la partida.
 * </p>
 */
public class Juego {

    /** Número de memes que se muestran en cada partida. */
    private static final Integer TOTAL_RONDAS = 5;

    /** Número máximo de mejores puntuaciones almacenadas. */
    private static final Integer MAX_MEJORES = 3;

    /** Lista de memes disponibles. */
    private List<Meme> memes;

    /** Lista de realidades disponibles. */
    private List<Realidad> realidades;

    /** Mapa de soluciones: meme_id -&gt; realidad_id correcta. */
    private Map<Integer, Integer> soluciones;

    /** Puntuación actual del jugador. */
    private Integer puntuacion;

    /** Scanner para leer la entrada del usuario. */
    private Scanner scanner;

    /**
     * Constructor de Juego.
     *
     * @param memes     lista de memes cargados.
     * @param realidades lista de realidades cargadas.
     * @param soluciones mapa de soluciones cargado.
     */
    public Juego(List<Meme> memes, List<Realidad> realidades, Map<Integer, Integer> soluciones) {
        this.memes = memes;
        this.realidades = realidades;
        this.soluciones = soluciones;
        this.puntuacion = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia y gestiona la partida completa.
     * <p>
     * Selecciona memes al azar (sin repetición), muestra las realidades,
     * recoge la respuesta del usuario y actualiza la puntuación.
     * </p>
     */
    public void jugar() {
        System.out.println("\n------------------------------------------");
        System.out.println("--       BIENVENIDA AL JUEGO 8M         ║");
        System.out.println("-- Desmiente los bulos con datos reales     ║");
        System.out.println("---------------------------------------------╝\n");

        List<Meme> memesBarajados = new ArrayList<>(memes);
        Collections.shuffle(memesBarajados, new Random());
        List<Meme> memesPartida = memesBarajados.subList(0, Math.min(TOTAL_RONDAS, memesBarajados.size()));

        for (int ronda = 1; ronda <= memesPartida.size(); ronda++) {
            Meme meme = memesPartida.get(ronda - 1);
            System.out.println("──────────────────────────────────────────");
            System.out.println("🔹 Ronda " + ronda + " de " + TOTAL_RONDAS);
            System.out.println(meme);
            System.out.println("\n¿Qué dato REAL desmiente este bulo?\n");

            List<Realidad> realidadesBarajadas = new ArrayList<>(realidades);
            Collections.shuffle(realidadesBarajadas, new Random());

            for (int i = 0; i < realidadesBarajadas.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + realidadesBarajadas.get(i).getTexto());
                System.out.println("     [Fuente: " + realidadesBarajadas.get(i).getFuente() + "]");
                System.out.println();
            }

            Integer respuesta = pedirRespuesta(realidadesBarajadas.size());
            Realidad elegida = realidadesBarajadas.get(respuesta - 1);
           Integer realidadCorrecta = soluciones.get(meme.getId());

            if (elegida.getId() == realidadCorrecta) {
                puntuacion++;
                System.out.println("V ¡Correcto! Has ganado un punto.");
            } else {
                Realidad correcta = buscarRealidadPorId(realidadCorrecta);
                System.out.println("X Incorrecto. La respuesta correcta era:");
                if (correcta != null) {
                    System.out.println("   " + correcta.getTexto());
                    System.out.println("   [Fuente: " + correcta.getFuente() + "]");
                }
            }

            System.out.println("\n Marcador: " + puntuacion + " / " + ronda);
        }

        System.out.println("\n══════════════════════════════════════════");
        System.out.println("🏁 FIN DE LA PARTIDA");
        System.out.println("   Puntuación final: " + puntuacion + " / " + TOTAL_RONDAS);
        System.out.println("══════════════════════════════════════════\n");
    }

    /**
     * Pide al usuario que introduzca un número de respuesta válido.
     *
     * @param max Número máximo de opciones disponibles.
     * @return número elegido por el usuario (1..max).
     */
    private Integer pedirRespuesta(Integer max) {
        Integer respuesta = -1;
        while (respuesta < 1 || respuesta > max) {
            System.out.print("Introduce el número de tu respuesta (1-" + max + "): ");
            try {
                respuesta = Integer.parseInt(scanner.nextLine().trim());
                if (respuesta < 1 || respuesta > max) {
                    System.out.println("Por favor, introduce un número entre 1 y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número.");
            }
        }
        return respuesta;
    }

    /**
     * Busca una realidad por su identificador.
     *
     * @param id Identificador de la realidad.
     * @return el objeto {@link Realidad} correspondiente, o null si no se encuentra.
     */
    private Realidad buscarRealidadPorId(Integer id) {
        for (Realidad r : realidades) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    /**
     * Gestiona el registro de la puntuación del usuario si se encuentra entre las mejores.
     *
     * @param puntuacionesActuales lista de puntuaciones almacenadas previamente.
     * @return lista actualizada de puntuaciones (máximo {@code MAX_MEJORES} entradas).
     */
    public List<Puntuacion> gestionarMejoresPuntuaciones(List<Puntuacion> puntuacionesActuales) {
        Boolean entrarEnRanking = false;

        if (puntuacionesActuales.size() < MAX_MEJORES) {
            entrarEnRanking = true;
        } else {
            Puntuacion peor = puntuacionesActuales.get(puntuacionesActuales.size() - 1);
            if (puntuacion > peor.getPuntos()) {
                entrarEnRanking = true;
            }
        }

        if (entrarEnRanking) {
            System.out.println(" ¡Enhorabuena! Tu puntuación está entre las mejores.");
            System.out.print("Introduce tu nombre: ");
            String nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) nombre = "Anónima";

            puntuacionesActuales.add(new Puntuacion(nombre, puntuacion));
            Collections.sort(puntuacionesActuales);

            if (puntuacionesActuales.size() > MAX_MEJORES) {
                puntuacionesActuales = puntuacionesActuales.subList(0, MAX_MEJORES);
                puntuacionesActuales = new ArrayList<>(puntuacionesActuales);
            }
        }

        return puntuacionesActuales;
    }

    /**
     * Obtiene la puntuación alcanzada en la partida.
     *
     * @return puntuación del jugador.
     */
    public Integer getPuntuacion() {
        return puntuacion;
    }
}
