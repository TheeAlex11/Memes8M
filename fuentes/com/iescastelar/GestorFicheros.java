package com.iescastelar;

import java.nio.file.*;
import java.io.*;
import java.util.*;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Gestiona todas las operaciones de lectura y escritura de ficheros del proyecto.
 * <p>
 * Se encarga de leer memes (TXT), realidades (JSON), soluciones (XML)
 * y gestionar el fichero de mejores puntuaciones (TXT).
 * </p>
 */
public class GestorFicheros {

    /** Fichero de memes (TXT) */
    private static final String MEMES = "datos/memes.txt";

    /** Fichero de realidades (JSON) */
    private static final String REALIDADES = "datos/realidades.json";

    /** Fichero de soluciones (XML) */
    private static final String SOLUCIONES = "datos/soluciones.xml";

    /** Fichero de mejores puntuaciones (TXT) */
    private static final String RESULTADOS = "resultados/mejores.txt";

    /**
     * Comprueba que existen los ficheros de datos obligatorios.
     * <p>
     * Si falta alguno, lanza una excepción indicando cuál.
     * </p>
     *
     * @throws IOException si falta algún fichero.
     */
    public static void comprobarFicherosDatos() throws IOException {
        String[] archivos = {MEMES, REALIDADES, SOLUCIONES};

        for (String archivo : archivos) {
            if (!Files.exists(Paths.get(archivo))) {
                throw new IOException("Falta el fichero: " + archivo);
            }
        }
    }

    /**
     * Crea el directorio de resultados y el fichero de mejores puntuaciones si no existen.
     *
     * @throws IOException si no se puede crear el directorio o el fichero.
     */
    public static void prepararResultados() throws IOException {
        Path dir = Paths.get("resultados");

        if (!Files.exists(dir)) {
            Files.createDirectory(dir);
        }

        Path file = Paths.get(RESULTADOS);
        if (!Files.exists(file)) {
            Files.createFile(file);
        }
    }

    /**
     * Lee el fichero de memes TXT y devuelve una lista de objetos {@link Meme}.
     * <p>
     * Formato esperado: {@code id#texto}
     * </p>
     *
     * @return lista de memes.
     * @throws IOException si no se puede leer el fichero.
     */
    public static List<Meme> leerMemes() throws IOException {
        List<Meme> memes = new ArrayList<>();

        for (String linea : Files.readAllLines(Paths.get(MEMES))) {
            String[] partes = linea.split("#");
            if (partes.length == 2) {
                memes.add(new Meme(Integer.parseInt(partes[0].trim()), partes[1].trim()));
            }
        }

        return memes;
    }

    /**
     * Lee el fichero de realidades JSON y devuelve una lista de objetos {@link Realidad}.
     * <p>
     * Cada realidad tiene id, texto, fuente y url de referencia.
     * </p>
     *
     * @return lista de realidades.
     * @throws IOException si no se puede leer el fichero.
     */
    public static List<Realidad> leerRealidades() throws IOException {
        List<Realidad> lista = new ArrayList<>();

        String texto = new String(Files.readAllBytes(Paths.get(REALIDADES)));
        JSONArray array = new JSONArray(texto);

        for (int indice = 0; indice < array.length(); indice++) {
            JSONObject objeto = array.getJSONObject(indice);
            lista.add(new Realidad(
                    objeto.getInt("id"),
                    objeto.getString("texto"),
                    objeto.getString("fuente"),
                    objeto.getString("url")
            ));
        }

        return lista;
    }

    /**
     * Lee el fichero XML de soluciones y devuelve un mapa meme_id -> realidad_id.
     * <p>
     * Permite relacionar cada meme con la realidad correcta.
     * </p>
     *
     * @return mapa con las soluciones.
     * @throws Exception si no se puede parsear el XML.
     */
    public static Map<Integer, Integer> leerSoluciones() throws Exception {
        Map<Integer, Integer> mapa = new HashMap<>();

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File(SOLUCIONES));

        NodeList lista = doc.getElementsByTagName("solucion");

        for (int indice = 0; indice < lista.getLength(); indice++) {
            Element elemento = (Element) lista.item(indice);
           Integer meme = Integer.parseInt(elemento.getElementsByTagName("meme_id").item(0).getTextContent().trim());
            Integer realidad = Integer.parseInt(elemento.getElementsByTagName("realidad_id").item(0).getTextContent().trim());
            mapa.put(meme, realidad);
        }

        return mapa;
    }

    /**
     * Lee el fichero de mejores puntuaciones TXT y devuelve la lista de {@link Puntuacion}.
     * <p>
     * Formato esperado: {@code nombre#puntos}
     * </p>
     *
     * @return lista de puntuaciones.
     * @throws IOException si no se puede leer el fichero.
     */
    public static List<Puntuacion> leerPuntuaciones() throws IOException {
        List<Puntuacion> lista = new ArrayList<>();

        for (String linea : Files.readAllLines(Paths.get(RESULTADOS))) {
            if (linea.isBlank()) continue;
            String[] partes = linea.split("#");
            if (partes.length == 2) {
                lista.add(new Puntuacion(partes[0].trim(), Integer.parseInt(partes[1].trim())));
            }
        }

        return lista;
    }

    /**
     * Guarda la lista completa de puntuaciones en el fichero de resultados (sobrescribe el fichero).
     *
     * @param lista lista de puntuaciones a guardar.
     * @throws IOException si no se puede escribir el fichero.
     */
    public static void guardarPuntuaciones(List<Puntuacion> lista) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (Puntuacion puntuacion : lista) {
            lineas.add(puntuacion.toString());
        }
        Files.write(Paths.get(RESULTADOS), lineas);
    }
}