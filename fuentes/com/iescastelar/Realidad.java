/**
 * Representa un dato real que desmiente un meme sobre igualdad de género.
 */
public class Realidad {

    /** Identificador único de la realidad. */
    private Integer id;

    /** Texto con el dato real que desmiente el bulo. */
    private String texto;

    /** Fuente oficial de la que proviene el dato. */
    private String fuente;

    /** URL de la fuente oficial. */
    private String url;

    /**
     * Constructor de Realidad.
     * @param id Identificador.
     * @param texto Texto con el dato real.
     * @param fuente Nombre de la fuente oficial.
     * @param url Enlace a la fuente oficial.
     */
    public Realidad(Integer id, String texto, String fuente, String url) {
        this.id = id;
        this.texto = texto;
        this.fuente = fuente;
        this.url = url;
    }

    /**
     * Obtiene el identificador de la realidad.
     * @return id de la realidad.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Obtiene el texto del dato real.
     * @return texto de la realidad.
     */
    public String getTexto() {
        return this.texto;
    }

    /**
     * Obtiene la fuente oficial del dato.
     * @return nombre de la fuente.
     */
    public String getFuente() {
        return this.fuente;
    }

    /**
     * Obtiene la URL de la fuente oficial.
     * @return URL de la fuente.
     */
    public String getUrl() {
        return this.url;
    }

    @Override
    public String toString() {
        return this.texto + "\n   [Fuente: " + fuente + "]";
    }
}
