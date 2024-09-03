import com.unilabs.agenda.Modal.Contacto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactoTest {
    @Test
    public void crearContacto() {
        Contacto contacto = new Contacto();
        String resultado = contacto.CrearContacto("Juan", "1234567890", "Tulio", "Calle 20", "juan@g.com");

        assertEquals("contacto{nombre='Juan', telefono='1234567890', alias='Tulio', direccion='Calle 20', email='juan@g.com", resultado);
    }

    @Test
    public void eliminarContacto() {
        Contacto contacto = new Contacto("Juan", "1234567890", "Tulio", "Calle 20", "juan@g.com");
        String resultado = contacto.eliminarContacto(contacto);
        assertEquals("Contacto borrado", resultado);
    }

    @Test
    public void eliminarContactoNoExistente() {
        Contacto contacto1 = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        Contacto contacto2 = new Contacto("Pedro", "9876543210", "Pedrito", "Calle 2", "pedro@example.com");
        String resultado = contacto1.eliminarContacto(contacto2);
        assertEquals("No existe el contacto", resultado);
    }

    @Test
    public void actualizarContacto() {
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = contacto.actualizarContacto(contacto, "Juanito", "9876543210", "Juan", "Calle 2", "juanito@example.com");
        assertEquals("Contacto actualizado", resultado);
        assertEquals("Juanito", contacto.getNombre());
        assertEquals("9876543210", contacto.getTelefono());
        assertEquals("Juan", contacto.getAlias());
        assertEquals("Calle 2", contacto.getDireccion());
        assertEquals("juanito@example.com", contacto.getEmail());
    }

    @Test
    public void actualizarContactoNoExistente() {
        Contacto contacto1 = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        Contacto contacto2 = new Contacto("Pedro", "9876543210", "Pedrito", "Calle 2", "pedro@example.com");
        String resultado = contacto1.actualizarContacto(contacto2, "Pedrito", "1111111111", "Pedro", "Calle 3", "pedrito@example.com");
        assertEquals("No existe el contacto", resultado);
    }

    @Test
    public void crearContactoDuplicado() {
        Contacto contacto = new Contacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        String resultado = contacto.CrearContacto("Juan", "1234567890", "Juanito", "Calle 1", "juan@example.com");
        assertEquals("el contacto ya existe", resultado);
    }
}
