package datos;

public class Plato {
    private int idPlato;
    private String nombrePlato;
    private double precioVenta;
    private double costoProduccion;

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

    @Override
    public String toString() {
        return "idPlato=" + idPlato + ", nombrePlato=" + nombrePlato + ", precioVenta=" + precioVenta
                + ", costoProduccion=" + costoProduccion + "]";
    }
}
