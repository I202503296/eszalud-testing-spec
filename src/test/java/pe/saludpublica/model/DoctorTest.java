package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("76543210", "Carlos", "Mendoza", "CMP12345", "Cardiología");

        assertNotNull(doctor);
        assertEquals("76543210", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Mendoza", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("Cardiología", doctor.getEspecialidad());
    }
}