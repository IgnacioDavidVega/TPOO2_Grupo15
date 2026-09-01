//Clase hija de Personal

package datos;

import java.time.LocalDate;

public class Cocinero extends Personal {
    private String especialidadCulinaria;
    private double plusCategoria;

    public Cocinero() {
    }

    public Cocinero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
            double sueldoBase, int idPersonal, String especialidadCulinaria, double plusCategoria) {
        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
        this.idPersonal = idPersonal;
        this.especialidadCulinaria = especialidadCulinaria;
        this.plusCategoria = plusCategoria;
    }

    public String getEspecialidadCulinaria() {
        return especialidadCulinaria;
    }

    public void setEspecialidadCulinaria(String especialidadCulinaria) {
        this.especialidadCulinaria = especialidadCulinaria;
    }

    public double getPlusCategoria() {
        return plusCategoria;
    }

    public void setPlusCategoria(double plusCategoria) {
        this.plusCategoria = plusCategoria;
    }

    @Override
    public String toString() {
        return "Cocinero [" + super.toString() + ", especialidadCulinaria=" + especialidadCulinaria
                + ", plusCategoria=" + plusCategoria + "]";
    }
}
