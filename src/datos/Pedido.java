package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Pedido {
    private int idPedido;
    private LocalDate fechaPedido;
    private Festival festival;
    private UnidadVenta unidadVenta;
    private Set<DetallePedido> detallesPedido = new HashSet<>(); // Nose si va asi, es para que noa arroje un error al
                                                                 // cargar un pedido

    public Pedido() {
    }

    public Pedido(LocalDate fechaPedido, Festival festival, UnidadVenta unidadVenta,
            Set<DetallePedido> detallesPedido) {
        super();
        this.fechaPedido = fechaPedido;
        this.festival = festival;
        this.unidadVenta = unidadVenta;
        this.detallesPedido = detallesPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public UnidadVenta getUnidadVenta() {
        return unidadVenta;
    }

    public void setUnidadVenta(UnidadVenta unidadVenta) {
        this.unidadVenta = unidadVenta;
    }

    public Set<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(Set<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", festival=" + festival
                + ", unidadVenta=" + unidadVenta + "]";
    }
    
}
