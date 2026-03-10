

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemeTest {

    @Test
    void testGetId() {
        Meme meme = new Meme(1, "Los hombres cobran menos");
        assertEquals(1, meme.getId());
    }

    @Test
    void testGetTexto() {
        Meme meme = new Meme(2, "Las mujeres no trabajan");
        assertEquals("Las mujeres no trabajan", meme.getTexto());
    }

    @Test
    void testToString() {
        Meme meme = new Meme(3, "Bulo de prueba");
        assertEquals(" MEME #3: \"Bulo de prueba\"", meme.toString());
    }
}