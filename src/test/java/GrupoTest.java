import com.unilabs.agenda.Modal.Grupo;
import com.unilabs.agenda.Modal.Contacto;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {
    @Test
    public void agregarContacto() {
        Grupo grupo = new Grupo("Amigos", new ArrayList<>(), "Social");
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = grupo.agregarContacto(contacto);
        assertEquals("Contacto agregado al grupo", resultado);
        assertTrue(grupo.getIntegrantes().contains(contacto));
    }

    @Test
    public void agregarContactoGrupoLleno() {
        Grupo grupo = new Grupo("Amigos", new ArrayList<>(), "Social");
        for (int i = 0; i < 5; i++) {
            grupo.agregarContacto(new Contacto("Contacto " + i, "123456789" + i, "Alias " + i, "Calle " + i, "contacto" + i + "@example.com"));
        }
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = grupo.agregarContacto(contacto);
        assertEquals("El grupo ya tiene 5 contactos", resultado);
        assertFalse(grupo.getIntegrantes().contains(contacto));
    }

    @Test
    public void eliminarContacto() {
        Grupo grupo = new Grupo("Amigos", new ArrayList<>(), "Social");
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        grupo.agregarContacto(contacto);
        String resultado = grupo.eliminarContacto(contacto);
        assertEquals("Contacto eliminado del grupo", resultado);
        assertFalse(grupo.getIntegrantes().contains(contacto));
    }

    @Test
    public void eliminarContactoNoExistente() {
        Grupo grupo = new Grupo("Amigos", new ArrayList<>(), "Social");
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = grupo.eliminarContacto(contacto);
        assertEquals("El contacto no pertenece al grupo", resultado);
    }
}
