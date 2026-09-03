package test;

import java.time.LocalDate;
import java.util.HashSet;

import datos.Festival;
import datos.Personal;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;

public class TestGabrielOmarRomero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Crear Festival
		//2. Crear UnidadVenta
		//3. Crear Personal
		//4. Crear Plato
		//5. Crear Pedido
		
		FestivalABM festivalABM = new FestivalABM();
		Festival festival = null;
		
		try {
			int idFestival = festivalABM.agregar("Festival de Verano", "Verano", LocalDate.of(2026, 1, 24), LocalDate.of(2026, 2, 1), new HashSet<>());
			System.out.printf("Id Festival: %d", idFestival);
			festival = festivalABM.traer(idFestival);
		    System.out.println(festival);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		UnidadVentaABM unidadVentaABM = UnidadVentaABM.getInstance();
		UnidadVenta unidad1=null;
		UnidadVenta unidad2=null;
		
	    try {
	    	int idUnidadVenta = unidadVentaABM.agregar("Exquisito", null, 20, "QWERT09876", festival, 2, 10);
	    	System.out.printf("Id UnidadVenta: %d", idUnidadVenta);
			unidad1 = unidadVentaABM.traer(idUnidadVenta);
		    System.out.println(unidad1);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    try {
	    	int idUnidadVenta = unidadVentaABM.agregar("El Buen Sabor", null, 30, "ABCDE12345", festival, "ABC123", true);
	    	System.out.printf("Id UnidadVenta: %d", idUnidadVenta);
			unidad2 = unidadVentaABM.traer(idUnidadVenta);
		    System.out.println(unidad2);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    PersonalABM personalABM = PersonalABM.getInstance();
	    Personal personal = null;
	    
	    try {
	    	int idPersonal = personalABM.agregar("Gabriel", "Romero", 123, LocalDate.of(2003, 2, 1), LocalDate.of(2026, 1, 24), 500, unidad1, "Mañana");
	    	System.out.printf("Id UnidadVenta: %d", idPersonal);
	    	personal = personalABM.traer(idPersonal);
		    System.out.println(personal);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    try {
	    	int idPersonal = personalABM.agregar("Brian", "Avila", 321, LocalDate.of(2003, 12, 5), LocalDate.of(2026, 1, 24), 1000, unidad2, "Cocina Argentina", 300);
	    	System.out.printf("Id UnidadVenta: %d", idPersonal);
	    	personal = personalABM.traer(idPersonal);
		    System.out.println(personal);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    
	}
	

}
