package test;

import java.util.List;

import datos.Cocinero;
import datos.PuestoDesarmable;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;

public class TestGabrielOmarRomero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnidadVentaABM unidadVentaABM = UnidadVentaABM.getInstance();
		PersonalABM personalABM = PersonalABM.getInstance();
		
		
		try {
			List<PuestoDesarmable> lista = unidadVentaABM.traerPuestosDesarmablesPorFestivalYTiempo(1, 30, 60);
			System.out.println("\n-----PUESTOS DESARMABLES ENTRE UN RANGO DE TIEMPO-----\n");
			for(PuestoDesarmable p : lista) {
				System.out.println(p);
				System.out.println("Perteneciente al Festival: "+ p.getFestival());
				System.out.println("\n");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<Cocinero> lista = personalABM.traerCocineroPorFestivalYEspecialidad(1, "chef");
			System.out.println("\n-----COCINEROS SEGUN SU ESPECIALIDAD-----\n");
			for(Cocinero c : lista) {
				System.out.println(c);
				System.out.println("De la Unidad de Venta: " + c.getUnidadVenta());
				System.out.println("Perteneciente al Festival: " + c.getUnidadVenta().getFestival());
				System.out.println("\n");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
			
	}
	

}
