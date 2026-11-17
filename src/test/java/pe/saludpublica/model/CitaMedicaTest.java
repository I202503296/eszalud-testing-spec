package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
    Doctor doctor = new Doctor("76543210", "Carlos", "Mendoza", "CMP12345", "Cardiología");
    Especialidad especialidad = new Especialidad("ESP01", "Cardiología");
    LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 10, 30);

    @Test
    @DisplayName("CIT-001 y CIT-008: Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaHora, EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("CITA-001", cita.getCodigo());
        assertEquals(paciente, cita.getPaciente());
        assertEquals(doctor, cita.getDoctor());
        assertEquals(especialidad, cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-002: Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", null, doctor, especialidad, fechaHora, EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-003: Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", paciente, null, especialidad, fechaHora, EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-004: Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", paciente, doctor, null, fechaHora, EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-005: Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDate() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", paciente, doctor, especialidad, null, EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-006: Crear cita con estado null aplica comportamiento predeterminado")
    void shouldApplyDefaultStatusWhenNull() {
        CitaMedica cita = new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaHora, null);
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-007: Crear cita con un estado válido lo conserva")
    void shouldKeepValidStatus() {
        CitaMedica cita = new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaHora, EstadoCita.ATENDIDA);
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}