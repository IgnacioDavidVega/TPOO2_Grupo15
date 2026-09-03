package datos;

import java.util.Set;

public abstract class UnidadVenta {
	
	protected long idUnidadVenta;
	protected String nombreComercial;
	protected Personal responsableCargo;
	protected long superficie;
	protected String codigoUnico;
	protected Festival festival;
	protected Set<Plato> platos;
	protected Set<Personal> personal;
	protected Set<Pedido> pedidos;
	
	public UnidadVenta() {}

	public UnidadVenta(String nombreComercial, Personal responsableCargo, long superficie, String codigoUnico, 
			Festival festival, Set<Plato> platos, Set<Personal> personal, Set<Pedido> pedidos) {
		super();
		this.nombreComercial = nombreComercial;
		this.responsableCargo = responsableCargo;
		this.superficie = superficie;
		this.codigoUnico = codigoUnico;
		this.festival = festival;
		this.platos = platos;
		this.personal = personal;
		this.pedidos = pedidos;
	}

	public long getIdUnidadVenta() {
		return idUnidadVenta;
	}

	protected void setIdUnidadVenta(long idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Personal getResponsableCargo() {
		return responsableCargo;
	}

	public void setResponsableCargo(Personal responsableCargo) {
		this.responsableCargo = responsableCargo;
	}

	public long getSuperficie() {
		return superficie;
	}

	public void setSuperficie(long superficie) {
		this.superficie = superficie;
	}

	public String getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Set<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}

	public Set<Personal> getPersonal() {
		return personal;
	}

	public void setPersonal(Set<Personal> personal) {
		this.personal = personal;
	}
	
	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "UnidadVenta [idUnidadVenta=" + idUnidadVenta + ", nombreComercial=" + nombreComercial
				+ ", responsableCargo=" + responsableCargo + ", superficie=" + superficie + " m2" + ", codigoUnico="
				+ codigoUnico + "]";
	}
	
}
