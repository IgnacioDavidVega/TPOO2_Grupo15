//Clase hija de Personal

package datos;

import java.time.LocalDate;

public class Cajero extends Personal {
    private String turnoTrabajo;

    public Cajero() {
    }

    public Cajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
            double sueldoBase, int idPersonal, String turnoTrabajo) {
        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
        this.idPersonal = idPersonal;
        this.turnoTrabajo = turnoTrabajo;
    }

    public String getTurnoTrabajo() {
        return turnoTrabajo;
    }

    public void setTurnoTrabajo(String turnoTrabajo) {
        this.turnoTrabajo = turnoTrabajo;
    }

    @Override
    public String toString() {
        return "Cajero [" + super.toString() + ", turnoTrabajo=" + turnoTrabajo + "]";
    }
}
