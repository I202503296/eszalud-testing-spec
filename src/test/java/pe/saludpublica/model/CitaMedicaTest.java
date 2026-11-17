package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        // 1. Preparamos los datos
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        Doctor doctor = new Doctor("76543210", "Carlos", "Mendoza", "CMP12345", "Cardiología");
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 10, 30);

        // 2. Creamos la cita
        CitaMedica cita = new CitaMedica("CITA-001", paciente, doctor, fechaHora);

        // 3. Verificamos
        assertNotNull(cita);
        assertEquals("CITA-001", cita.getCodigo());
        assertEquals(paciente, cita.getPaciente());
        assertEquals(doctor, cita.getDoctor());
        assertEquals(fechaHora, cita.getFechaHora());
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        Doctor doctor = new Doctor("76543210", "Carlos", "Mendoza", "CMP12345", "Cardiología");
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 10, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", null, doctor, fechaHora)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 10, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", paciente, null, fechaHora)
        );
    }
}