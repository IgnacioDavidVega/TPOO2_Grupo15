package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.FestivalDao;
import datos.Festival;
import datos.UnidadVenta;

public class FestivalABM {
	FestivalDao dao = new FestivalDao();

	public Festival traer(long idFestival) {
		return dao.traer(idFestival);
	}

	public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Set<UnidadVenta> unidadesVenta) throws Exception {
		if(dao.traer(nombre) != null)throw new Exception("ERROR ya existe festival con nombre: " + nombre);
		Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin, unidadesVenta);
		return dao.agregar(f);
	}

	public void modificar(Festival f) {
		dao.actualizar(f);
	}

	public void eliminar(long idFestival) {

		Festival f = dao.traer(idFestival);
		dao.eliminar(f);
	}

	public List<Festival> traerPorTemporada(String temporada) {
		return dao.traerPorTemporada(temporada);
	}
}

