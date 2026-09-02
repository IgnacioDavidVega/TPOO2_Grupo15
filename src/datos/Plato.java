package datos;

import java.util.HashSet;
import java.util.Set;

public class Plato {
    private int idPlato;
    private String nombrePlato;
    private double precioVenta;
    private double costoProduccion;
    private Set<DetallePedido> detalles = new HashSet<>();

    public Plato() {
    }

    public Plato(String nombrePlato, double precioVenta, double costoProduccion) {
        super();
        this.nombrePlato = nombrePlato;
        this.precioVenta = precioVenta;
        this.costoProduccion = costoProduccion;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    public void setCostoProduccion(double costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    public Set<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "idPlato=" + idPlato + ", nombrePlato=" + nombrePlato + ", precioVenta=" + precioVenta
                + ", costoProduccion=" + costoProduccion + "]";
    }
}
