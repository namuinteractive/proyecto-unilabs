import com.unilabs.agenda.Reunion;
import com.unilabs.agenda.Contacto;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReunionTest {
    @Test
    public void agregarContacto() {
        Reunion reunion = new Reunion("Reunion de trabajo", "2024-12-31", new ArrayList<>(), "10:00");
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = reunion.agregarContacto(contacto);
        assertEquals("Contacto agregado a la reunion", resultado);
        assertTrue(reunion.getIntegrantesReunion().contains(contacto));
    }

    @Test
    public void eliminarContacto() {
        Reunion reunion = new Reunion("Reunion de trabajo", "2024-12-31", new ArrayList<>(), "10:00");
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        reunion.agregarContacto(contacto);
        String resultado = reunion.eliminarContacto(contacto);
        assertEquals("Contacto eliminado de la reunion", resultado);
        assertFalse(reunion.getIntegrantesReunion().contains(contacto));
    }

    @Test
    public void eliminarContactoNoExistente() {
        Reunion reunion = new Reunion("Reunion de trabajo", "2024-12-31", new ArrayList<>(), "10:00");
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = reunion.eliminarContacto(contacto);
        assertEquals("El contacto no pertenece a la reunion", resultado);
    }
}
