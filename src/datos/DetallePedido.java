package datos;

public class DetallePedido {
    private long idDetalle;
    private Plato plato;
    private long cantidad;

    public DetallePedido() {
    }

    public DetallePedido(Plato plato, long cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "idDetalle=" + idDetalle + ", plato=" + plato + ", cantidad=" + cantidad + "]";
    }
}
