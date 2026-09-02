package datos;

public class DetallePedido {
    private long idDetalle;
    private Plato plato;
    private Pedido pedido;
    private long cantidad;

    public DetallePedido() {
    }

    public DetallePedido(Plato plato, long cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }

    public long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "idDetalle=" + idDetalle + ", plato=" + plato + ", cantidad=" + cantidad + "]";
    }
}
