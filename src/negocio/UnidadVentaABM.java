package negocio;

import java.util.HashSet;
import java.util.List;

import dao.UnidadVentaDao;
import datos.FoodTruck;
import datos.Personal;
import datos.PuestoDesarmable;
import datos.UnidadVenta;

public class UnidadVentaABM {
	
	private static UnidadVentaABM instancia = null;
	UnidadVentaDao dao = new UnidadVentaDao();
	protected UnidadVentaABM() {}
	
	public static UnidadVentaABM getInstance() {
		if (instancia == null)
		instancia = new UnidadVentaABM();
		return instancia;
	}
	
	public UnidadVenta traer(long idUnidadVenta) {
		return UnidadVentaDao.getInstance().traer(idUnidadVenta);
	}

	public int agregar(String nombreComercial, Personal responsableCargo, long superficie, String codigoUnico, String patente, boolean conexionElectrica) {
		// Pendiente implementar lógica de negocio
		UnidadVenta u = new FoodTruck(nombreComercial, responsableCargo, superficie, codigoUnico, new HashSet<>(), new HashSet<>(), patente, conexionElectrica);
		return dao.agregar(u);
	}
	
	public int agregar(String nombreComercial, Personal responsableCargo, long superficie, String codigoUnico, long cantidadCarpas, long tiempoMontaje) {
		// Pendiente implementar lógica de negocio
		UnidadVenta u = new PuestoDesarmable(nombreComercial, responsableCargo, superficie, codigoUnico, new HashSet<>(), new HashSet<>(), cantidadCarpas, tiempoMontaje);
		return dao.agregar(u);
	}

	public void modificar(UnidadVenta u) {
		// Pendiente implementar lógica de negocio
		dao.actualizar(u);
	}

	public void eliminar(long idUnidadVenta) {
		// Pendiente implementar lógica de negocio
		UnidadVenta u = dao.traer(idUnidadVenta);
		dao.eliminar(u);
	}

	public List<UnidadVenta> traer() {
		return dao.traer();
	}
	
	public UnidadVenta traerUnidadVentaYPlatos(long idUnidadVenta) {
		return dao.traerUnidadVentaYPlatos(idUnidadVenta);
	}
	
	public UnidadVenta traerUnidadVentaYPersonal(long idUnidadVenta) {
		return dao.traerUnidadVentaYPersonal(idUnidadVenta);
	}
	
}
