package pe.saludpublica.model;

public class Paciente {
    private String documento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        if (documento == null) {
            throw new IllegalArgumentException("El documento no puede ser nulo");
        }
        if (nombres == null) {
            throw new IllegalArgumentException("Los nombres no pueden ser nulos");
        }
        if (apellidos == null) {
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos");
        }
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getDocumento() { return documento; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Paciente paciente = (Paciente) obj;
        return documento.equals(paciente.documento);
    }

    @Override
    public int hashCode() {
        return documento.hashCode();
    }
}