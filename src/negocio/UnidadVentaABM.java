package negocio;

import java.util.HashSet;
import java.util.List;

import dao.UnidadVentaDao;
import datos.Festival;
import datos.FoodTruck;
import datos.Personal;
import datos.Plato;
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

	private boolean codigoUnicoValido(String codigo) {
		boolean valido = false;
		if (codigo!=null) {
			valido = codigo.matches("[A-Z]{5}[0-9]{5}");
		}
		return valido;
	}
	
	public int agregar(String nombreComercial, Personal responsableCargo, long superficie, String codigoUnico, Festival festival, String patente, boolean conexionElectrica) throws Exception {
		
		if (superficie<=0) {
			throw new Exception("Superficie Invalida, deber ser mayor a 0");
		}
		
		if(!codigoUnicoValido(codigoUnico)) {
			throw new Exception("Codigo Invalido, 5 letras mayus y 5 numeros");
		}
		
		if(dao.traer(codigoUnico)!=null) {
			throw new Exception("Codigo Invalido, ya esta en uso");
		}
		
		UnidadVenta u = new FoodTruck(nombreComercial, responsableCargo, superficie, codigoUnico, festival, new HashSet<>(), new HashSet<>(), new HashSet<>(), patente, conexionElectrica);
		return dao.agregar(u);
	}
	
	public int agregar(String nombreComercial, Personal responsableCargo, long superficie, String codigoUnico, Festival festival, long cantidadCarpas, long tiempoMontaje) throws Exception {
		
		if (superficie<=0) {
			throw new Exception("Superficie Invalida, deber ser mayor a 0");
		}
		
		if(tiempoMontaje<=0) {
			throw new Exception("Tiempo Invalida, deber ser mayor a 0");
		}
		
		if(!codigoUnicoValido(codigoUnico)) {
			throw new Exception("Codigo Invalido, 5 letras mayus y 5 numeros");
		}
		
		if(dao.traer(codigoUnico)!=null) {
			throw new Exception("Codigo Invalido, ya esta en uso");
		}
		
		UnidadVenta u = new PuestoDesarmable(nombreComercial, responsableCargo, superficie, codigoUnico, festival, new HashSet<>(), new HashSet<>(), new HashSet<>(), cantidadCarpas, tiempoMontaje);
		return dao.agregar(u);
	}
	
	public void modificar(UnidadVenta u) {
		dao.actualizar(u);
	}

	public void eliminar(long idUnidadVenta) {
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
	
	public List<UnidadVenta> traerUnidadVentaSuperficie(long superficie){
		return dao.traerUnidadVentaSuperficie(superficie);
	}
	
	public boolean agregarPersonal(long idUnidadVenta, Personal personal) {
		return dao.agregarPersonal(idUnidadVenta, personal);
	}
	
	public boolean agregarPlato(long idUnidadVenta, Plato plato) {
		return dao.agregarPlato(idUnidadVenta, plato);
	}
	
}
