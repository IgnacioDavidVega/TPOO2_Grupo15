package test;

import datos.Festival;
import datos.Plato;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestTomasCasco {

    public static void main(String[] args) {
        FestivalABM festivalABM = new FestivalABM();
        UnidadVentaABM uvABM = UnidadVentaABM.getInstance();
        PlatoABM platoABM = PlatoABM.getInstance();

        try {
            Festival festival = festivalABM.traer(2);
            System.out.println("Festival: " + festival);

            if (festival == null) {
                System.err.println("No existe el Festival de Navidad");
                return;
            }

            System.out.println("\n------------CASO DE USO: UNIDAD QUE MAS RECAUDÓ------------\n");
            UnidadVenta ganadora = uvABM.traerUnidadVentaMasRecaudadora(festival.getIdFestival());
            System.out.println(ganadora);

            if (ganadora != null) {
                Plato masVendido = platoABM.traerMasVendidoPorUnidadVenta(ganadora.getIdUnidadVenta());
                System.out.println("Plato mas vendido en esa unidad: " + masVendido);

                Plato masRedituable = platoABM.traerMasRedituablePorUnidadVenta(ganadora.getIdUnidadVenta());
                System.out.println("Plato mas redituable en esa unidad: " + masRedituable);
            }
        } catch (Exception e) {
            System.err.println("Error al ejecutar el caso de uso: " + e.getMessage());
        }
    }
}
