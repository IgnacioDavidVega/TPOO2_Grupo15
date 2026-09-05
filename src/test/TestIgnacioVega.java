package test;

import java.util.List;

import datos.Festival;
import datos.Personal;
import negocio.FestivalABM;
import negocio.PersonalABM;

public class TestIgnacioVega {

    public static void main(String[] args) {
        FestivalABM festivalABM = new FestivalABM();
        PersonalABM personalABM = PersonalABM.getInstance();

        try {
            Festival festival1 = festivalABM.traer(1);

            if (festival1 == null) {
                System.err.println("No existe el festival Festival de Primavera");
                return;
            }

            if (festival1 != null) {
                System.out.println(
                        "\n------------LISTADO DE PERSONAL DEL FESTIVAL " + festival1.getNombre() + "------------\n");
                List<Personal> personalDelFestival = personalABM.traerPorFestival(festival1.getIdFestival());
                int contador = 0;
                for (Personal personal : personalDelFestival) {
                    System.out.println(personal);
                    contador = (contador + 1);
                }
                System.out.println("\nTOTAL DE PERSONAL EN EL FESTIVAL " + festival1.getNombre() + ": " + contador);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar el personal del festival: " + e.getMessage());
        }
    }
}
