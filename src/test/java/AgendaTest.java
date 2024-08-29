import com.unilabs.agenda.Contacto;
import com.unilabs.agenda.Reunion;
import com.unilabs.agenda.Grupo;
import com.unilabs.agenda.Agenda;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AgendaTest {
    @Test
    public void agregarContacto() {
        Agenda agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = agenda.agregarContacto(contacto);
        assertEquals("Contacto agregado", resultado);
        assertTrue(agenda.getListaContactos().contains(contacto));
    }

    @Test
    public void agregarContactoDuplicado() {
        Agenda agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        agenda.agregarContacto(contacto);
        String resultado = agenda.agregarContacto(contacto);
        assertEquals("El contacto ya existe", resultado);
    }

    @Test
    public void eliminarContacto() {
        Agenda agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        agenda.agregarContacto(contacto);
        String resultado = agenda.eliminarContacto(contacto);
        assertEquals("Contacto eliminado", resultado);
        assertFalse(agenda.getListaContactos().contains(contacto));
    }

    @Test
    public void eliminarContactoNoExistente() {
        Agenda agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = agenda.eliminarContacto(contacto);
        assertEquals("El contacto no existe", resultado);
    }

    @Test
    public void agregarGrupo() {
        Agenda agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Grupo grupo = new Grupo("Amigos", new ArrayList<>(), "Social");
        String resultado = agenda.agregarGrupo(grupo);
        assertEquals("Grupo agregado", resultado);
        assertTrue(agenda.getListaGrupos().contains(grupo));
    }

    @Test
    public void eliminarGrupo() {
        Agenda agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Grupo grupo = new Grupo("Amigos", new ArrayList<>(), "Social");
        agenda.agregarGrupo(grupo);
        String resultado = agenda.eliminarGrupo(grupo);
        assertEquals("Grupo eliminado", resultado);
        assertFalse(agenda.getListaGrupos().contains(grupo));
    }

    @Test
    public void agregarReunion() {
        Agenda agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Reunion reunion = new Reunion("Reunion de trabajo", "2024-12-31", new ArrayList<>(), "10:00");
        String resultado = agenda.agregarReunion(reunion);
        assertEquals("Reunion agregada", resultado);
        assertTrue(agenda.getListaReuniones().contains(reunion));
    }

    @Test
    public void eliminarReunion() {
        Agenda agenda = new Agenda(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Reunion reunion = new Reunion("Reunion de trabajo", "2024-12-31", new ArrayList<>(), "10:00");
        agenda.agregarReunion(reunion);
        String resultado = agenda.eliminarReunion(reunion);
        assertEquals("Reunion eliminada", resultado);
        assertFalse(agenda.getListaReuniones().contains(reunion));
    }
}
