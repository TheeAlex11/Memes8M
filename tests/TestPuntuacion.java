import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PuntuacionTest {

    @Test
    void getNombre_debeRetornarElNombre() {
        Puntuacion p = new Puntuacion("Alejandro", 8);
        assertEquals("Alejandro", p.getNombre());
    }

    @Test
    void getPuntos_debeRetornarLosPuntos() {
        Puntuacion p = new Puntuacion("Alejandro", 8);
        assertEquals(8, p.getPuntos());
    }

    @Test
    void compareTo_puntuacionMayorDebeIrPrimero() {
        Puntuacion mayor = new Puntuacion("Alejandro", 10);
        Puntuacion menor = new Puntuacion("Vicente", 5);
        assertTrue(mayor.compareTo(menor) < 0);
    }

    @Test
    void compareTo_puntuacionesIgualesDebenDarCero() {
        Puntuacion p1 = new Puntuacion("Alejandro", 5);
        Puntuacion p2 = new Puntuacion("Vicente", 5);
        assertEquals(0, p1.compareTo(p2));
    }

    @Test
    void toString_debeRetornarNombreYPuntosConAlmohadilla() {
        Puntuacion p = new Puntuacion("Alejandro", 8);
        assertEquals("Alejandro#8", p.toString());
    }
}