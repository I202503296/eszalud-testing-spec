package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {
    private String codigo;
    private Paciente paciente;
    private Doctor doctor;
    private Especialidad especialidad;
    private LocalDateTime fechaHora;
    private EstadoCita estado;

    public CitaMedica(String codigo, Paciente paciente, Doctor doctor, Especialidad especialidad, LocalDateTime fechaHora, EstadoCita estado) {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("El doctor es obligatorio");
        }
        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora son obligatorias");
        }

        this.codigo = codigo;
        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        // CIT-006 y CIT-007: Si llega null, es PROGRAMADA; si no, guarda el estado recibido.
        this.estado = (estado == null) ? EstadoCita.PROGRAMADA : estado;
    }

    public String getCodigo() { return codigo; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public Especialidad getEspecialidad() { return especialidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public EstadoCita getEstado() { return estado; }
}