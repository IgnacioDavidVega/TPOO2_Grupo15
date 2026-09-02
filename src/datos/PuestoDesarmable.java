package datos;

import java.util.Set;

public class PuestoDesarmable extends UnidadVenta{
	
	private long cantidadCarpas;
	private long tiempoMontaje;
	
	public PuestoDesarmable() {}
	
	public PuestoDesarmable(String nombreComercial, Personal responsableCargo, long superficie, String codigoUnico,
			Set<Plato> platos, Set<Personal> personal, long cantidadCarpas, long tiempoMontaje) {
		super(nombreComercial, responsableCargo, superficie, codigoUnico, platos, personal);
		this.cantidadCarpas = cantidadCarpas;
		this.tiempoMontaje = tiempoMontaje;
	}

	public long getCantidadCarpas() {
		return cantidadCarpas;
	}

	public void setCantidadCarpas(long cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}

	public long getTiempoMontaje() {
		return tiempoMontaje;
	}

	public void setTiempoMontaje(long tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable ["+ super.toString() +", cantidadCarpas=" + cantidadCarpas + ", tiempoMontaje=" + tiempoMontaje + "]";
	}
	
}
