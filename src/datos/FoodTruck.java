package datos;

import java.util.Set;

public class FoodTruck extends UnidadVenta{
	
	private String patente;
	private boolean conexionElectrica;
	
	public FoodTruck() {}
	
	public FoodTruck(String nombreComercial, Personal responsableCargo, long superficie, String codigoUnico, Festival festival, 
			Set<Plato> platos, Set<Personal> personal, Set<Pedido> pedidos, String patente, boolean conexionElectrica) {
		super(nombreComercial, responsableCargo, superficie, codigoUnico, festival, platos, personal, pedidos);
		this.patente = patente;
		this.conexionElectrica = conexionElectrica;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isConexionElectrica() {
		return conexionElectrica;
	}

	public void setConexionElectrica(boolean conexionElectrica) {
		this.conexionElectrica = conexionElectrica;
	}

	@Override
	public String toString() {
		return "FoodTruck ["+ super.toString() +", patente=" + patente + ", conexionElectrica=" + conexionElectrica + "]";
	}
	
}
