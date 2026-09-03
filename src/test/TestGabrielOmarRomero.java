package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import datos.Festival;
import datos.FoodTruck;
import datos.Personal;
import datos.PuestoDesarmable;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;

public class TestGabrielOmarRomero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
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
		
		festival = festivalABM.traer(1);
		
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
	    
	    unidad1 = unidadVentaABM.traer(1);
	    
	    try {
	    	int idUnidadVenta = unidadVentaABM.agregar("El Buen Sabor", null, 30, "ABCDE12345", festival, "ABC123", true);
	    	System.out.printf("Id UnidadVenta: %d", idUnidadVenta);
			unidad2 = unidadVentaABM.traer(idUnidadVenta);
		    System.out.println(unidad2);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    unidad2 = unidadVentaABM.traer(2);
	    
	    PersonalABM personalABM = PersonalABM.getInstance();
	    Personal personal = null;
	    Personal personal2 = null;
	    Personal personal3 = null;
	    Personal personal4 = null;
	    
	    try {
	    	int idPersonal = personalABM.agregar("Gabriel", "Romero", 123, LocalDate.of(2003, 2, 1), LocalDate.of(2026, 1, 24), 500, unidad1, "Mañana");
	    	System.out.printf("Id Personal: %d", idPersonal);
	    	personal = personalABM.traer(idPersonal);
		    System.out.println(personal);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    try {
	    	int idPersonal = personalABM.agregar("Brian", "Avila", 321, LocalDate.of(2003, 12, 5), LocalDate.of(2026, 1, 24), 1000, unidad2, "Cocina Argentina", 300);
	    	System.out.printf("Id Personal: %d", idPersonal);
	    	personal2 = personalABM.traer(idPersonal);
		    System.out.println(personal2);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    try {
	    	int idPersonal = personalABM.agregar("Martin", "Perez", 456, LocalDate.of(2003, 6, 21), LocalDate.of(2026, 1, 24), 1500, unidad1, "Noche");
	    	System.out.printf("Id Personal: %d", idPersonal);
	    	personal3 = personalABM.traer(idPersonal);
		    System.out.println(personal3);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    
	    try {
	    	int idPersonal = personalABM.agregar("Agustin", "Lopez", 331, LocalDate.of(2004, 11, 10), LocalDate.of(2026, 1, 24), 2000, unidad1, "Parrilla", 400);
	    	System.out.printf("Id Personal: %d", idPersonal);
	    	personal4 = personalABM.traer(idPersonal);
		    System.out.println(personal4);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    
	    System.out.println("\n------------UNIDAD SEGUN SUPERFICIE------------\n");
	    
	    try {
	    	List<UnidadVenta> lista = unidadVentaABM.traerUnidadVentaSuperficie(21);
	    	for (UnidadVenta u : lista) {
	    		if(u instanceof FoodTruck) {
	    			FoodTruck f = (FoodTruck) u;
	    			System.out.println(f);
	    		}else if(u instanceof PuestoDesarmable){
	    			PuestoDesarmable p = (PuestoDesarmable) u;
		    		System.out.println(p);
	    		}
	    	} 
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    
	    System.out.println("\n------------UNIDAD + PERSONAL------------\n");
	    
	    try {
	    	UnidadVenta u = unidadVentaABM.traerUnidadVentaYPersonal(1);
	    	
	    	System.out.println(u);
	    	System.out.println("\n");
	    	for(Personal p : u.getPersonal()){
	    		System.out.println(p);
	    	}
	    		
	    	 
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    System.out.println("\n------------SEGUN EL DNI DE UN EMPLEADO DEL PERSONAL QUIERO SABER EN QUE UNIDAD TRABAJA------------\n");
	    
	    try {
	    	UnidadVenta u = unidadVentaABM.traerUnidadVentaDni(123);
	    	System.out.println(u);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    try {
	    	UnidadVenta u = unidadVentaABM.traerUnidadVentaDni(999999999);
	    	System.out.println(u);
	    }catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    
	}
	

}
