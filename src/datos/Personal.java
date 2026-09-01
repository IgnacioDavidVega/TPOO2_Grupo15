//Creacion de la clase Personal que es la clase padre de Cocinero y Cajero
package datos;

import java.time.LocalDate;

public abstract class Personal {
    protected int idPersonal;
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected LocalDate fechaNacimiento;
    protected LocalDate fechaIngreso;
    protected double sueldoBase;

    public Personal() {
    }

    public Personal(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
            double sueldoBase) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.sueldoBase = sueldoBase;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return "idPersonal=" + idPersonal + ", nombre=" + nombre + ", apellido=" + apellido
                + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso
                + ", sueldoBase=" + sueldoBase + "]";
    }
}
