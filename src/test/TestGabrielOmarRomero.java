package test;

import java.util.List;

import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestGabrielOmarRomero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnidadVentaABM unidadABM = UnidadVentaABM.getInstance();
		
		/*
		try {
			int idUnidad1 = unidadABM.agregar("Burguer", null, 30, "FMBUQ12345", 2, 10);
			System.out.printf("Id unidad: %d", idUnidad1);
		}catch(Exception e){
			e.getMessage();
		}
		try {
			int idUnidad2 = unidadABM.agregar("Lupero", null, 20, "SAIUD87812", "ALM131", false);
			System.out.printf("Id unidad: %d", idUnidad2);
		}catch(Exception e){
			e.getMessage();
		}
		try {
			int idUnidad3 = unidadABM.agregar("Panchito", null, 25, "ABCDE19234", 2, 10);
			System.out.printf("Id unidad: %d", idUnidad3);
		}catch(Exception e){
			e.getMessage();
		}
		try {
			int idUnidad4 = unidadABM.agregar("Milanesita", null, 40, "JASUD12512", "ABC555", true);
			System.out.printf("Id unidad: %d", idUnidad4);
		}catch(Exception e){
			e.getMessage();
		}
		
		
		List<UnidadVenta> lista = unidadABM.traerUnidadVentaSuperficie(10);
		
		for(UnidadVenta u : lista) {
			if(u instanceof FoodTruck) {
				FoodTruck f = (FoodTruck)u;
				System.out.println(f);
			}
			if(u instanceof PuestoDesarmable) {
				PuestoDesarmable p = (PuestoDesarmable)u;
				System.out.println(p);
			}
		}
		
		*/
		
	}
	

}
