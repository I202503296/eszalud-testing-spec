package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("ESP01", "Cardiología");

        assertNotNull(especialidad);
        assertEquals("ESP01", especialidad.getCodigo());
        assertEquals("Cardiología", especialidad.getNombre());
    }
}