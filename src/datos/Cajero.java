//Clase hija de Personal

package datos;

import java.time.LocalDate;

public class Cajero extends Personal {
    private String turnoTrabajo;
    private int numeroCaja;

    public Cajero() {
    }

    public Cajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
            double sueldoBase, UnidadVenta unidadVenta, String turnoTrabajo, int numeroCaja) {
        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, unidadVenta);
        this.turnoTrabajo = turnoTrabajo;
        this.numeroCaja = numeroCaja;
    }

    public String getTurnoTrabajo() {
        return turnoTrabajo;
    }

    public void setTurnoTrabajo(String turnoTrabajo) {
        this.turnoTrabajo = turnoTrabajo;
    }
    
    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    @Override
    public String toString() {
        return "Cajero [" + super.toString() + ", turnoTrabajo=" + turnoTrabajo + ", numeroCaja=" + numeroCaja + "]";
    }
}
