package datos;

import java.time.LocalDate;
import java.util.Set;

public class Festival {
	
	private long idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Set<UnidadVenta> unidadesVenta;
	
	public Festival(){}
	
	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			Set<UnidadVenta> unidadesVenta) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.unidadesVenta = unidadesVenta;
	}

	public long getIdFestival() {
		return idFestival;
	}

	protected void setIdFestival(long idFestival) {
		this.idFestival = idFestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Set<UnidadVenta> getUnidadesVenta() {
		return unidadesVenta;
	}

	public void setUnidadesVenta(Set<UnidadVenta> unidadesVenta) {
		this.unidadesVenta = unidadesVenta;
	}

	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
}