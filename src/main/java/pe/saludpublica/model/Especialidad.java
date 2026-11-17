package pe.saludpublica.model;

public class Especialidad {
    private String codigo;
    private String nombre;

    public Especialidad(String codigo, String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
}