package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {
    private String codigo;
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fechaHora;

    public CitaMedica(String codigo, Paciente paciente, Doctor doctor, LocalDateTime fechaHora) {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("El doctor es obligatorio");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora son obligatorias");
        }
        this.codigo = codigo;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
    }

    public String getCodigo() { return codigo; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}