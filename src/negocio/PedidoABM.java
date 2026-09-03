package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.PedidoDAO;
import datos.DetallePedido;
import datos.Festival;
import datos.Pedido;
import datos.UnidadVenta;

public class PedidoABM {
    private static PedidoABM instancia = null;
    private PedidoDAO dao = PedidoDAO.getInstance();

    protected PedidoABM() {
    }

    public static PedidoABM getInstance() {
        if (instancia == null) {
            instancia = new PedidoABM();
        }
        return instancia;
    }

    public Pedido traer(int idPedido) {
        return dao.traer(idPedido);
    }

    public int agregar(LocalDate fechaPedido, Festival festival, UnidadVenta unidadVenta, Set<DetallePedido> detallesPedido) throws Exception {
        if (fechaPedido == null) {
            throw new Exception("ERROR: La fecha del pedido no puede ser nula.");
        }
        if (festival == null) {
            throw new Exception("ERROR: Debe asignar un festival al pedido.");
        }
        if (unidadVenta == null) {
            throw new Exception("ERROR: Debe asignar una unidad de venta al pedido.");
        }

        Pedido p = new Pedido(fechaPedido, festival, unidadVenta, detallesPedido);

        if (detallesPedido != null) {
            for (DetallePedido dp : detallesPedido) {
                dp.setPedido(p);
            }
        }

        return dao.agregar(p);
    }

    public void modificar(Pedido p) throws Exception {
        if (dao.traer(p.getIdPedido()) == null) {
            throw new Exception("ERROR: No existe un pedido con el ID: " + p.getIdPedido());
        }
        dao.actualizar(p);
    }

    public void eliminar(int idPedido) throws Exception {
        Pedido p = dao.traer(idPedido);
        if (p == null) {
            throw new Exception("ERROR: No existe un pedido con el ID: " + idPedido);
        }
        dao.eliminar(p);
    }

    public List<Pedido> traer() {
        return dao.traer();
    }

    public List<Pedido> traerPorFestival(Festival festival) {
        return dao.traerPorFestival(festival);
    }
}
