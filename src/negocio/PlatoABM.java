package negocio;

import java.util.List;
import dao.PlatoDAO;
import datos.Plato;

public class PlatoABM {
    private static PlatoABM instancia = null; 
    private PlatoDAO dao = PlatoDAO.getInstance();

    protected PlatoABM() {
    }

    public static PlatoABM getInstance() {
        if (instancia == null) {
            instancia = new PlatoABM();
        }
        return instancia;
    }

    public Plato traer(int idPlato) {
        return dao.traer(idPlato);
    }

    public Plato traer(String nombrePlato) {
        return dao.traer(nombrePlato);
    }

    public int agregar(String nombrePlato, double precioVenta, double costoProduccion) throws Exception {
        if (nombrePlato == null || nombrePlato.trim().isEmpty()) {
            throw new Exception("ERROR: El nombre del plato no puede estar vacío.");
        }
        if (precioVenta <= 0) {
            throw new Exception("ERROR: El precio de venta debe ser mayor a cero.");
        }
        if (costoProduccion <= 0) {
            throw new Exception("ERROR: El costo de producción debe ser mayor a cero.");
        }
        if (precioVenta <= costoProduccion) {
            throw new Exception("ERROR: El precio de venta debe ser mayor al costo de producción.");
        }
        if (dao.traer(nombrePlato) != null) {
            throw new Exception("ERROR: Ya existe un plato con el nombre: " + nombrePlato);
        }

        Plato p = new Plato(nombrePlato, precioVenta, costoProduccion);
        return dao.agregar(p);
    }

    public void modificar(Plato p) throws Exception {
        if (p == null) {
            throw new Exception("ERROR: El plato a modificar no puede ser nulo.");
        }
        if (dao.traer(p.getIdPlato()) == null) {
            throw new Exception("ERROR: No existe un plato con el ID: " + p.getIdPlato());
        }
        dao.actualizar(p);
    }

    public void eliminar(int idPlato) throws Exception {
        Plato p = dao.traer(idPlato);
        if (p == null) {
            throw new Exception("ERROR: No existe un plato con el ID: " + idPlato);
        }
        dao.eliminar(p);
    }

    public List<Plato> traer() {
        return dao.traer();
    }
}