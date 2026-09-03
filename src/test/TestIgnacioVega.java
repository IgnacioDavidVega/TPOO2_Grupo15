package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import datos.Festival;
import datos.Personal;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;

public class TestIgnacioVega {

    public static void main(String[] args) {
        FestivalABM festivalABM = new FestivalABM();
        UnidadVentaABM unidadVentaABM = UnidadVentaABM.getInstance();
        PersonalABM personalABM = PersonalABM.getInstance();

        Festival festival = null;
        UnidadVenta unidadVenta = null;

        try {
            int idFestival = festivalABM.agregar(
                    "Festival de Ignacio Vega",
                    "Primavera",
                    LocalDate.now(),
                    LocalDate.now().plusDays(3),
                    new HashSet<>());
            festival = festivalABM.traer(idFestival);
            System.out.println("Festival creado: " + festival);
        } catch (Exception e) {
            System.err.println("Error al crear el festival: " + e.getMessage());
        }

        try {
            if (festival != null) {
                int idUnidadVenta = unidadVentaABM.agregar(
                        "Puesto de Ignacio",
                        null,
                        25L,
                        "IGNVG12345",
                        festival,
                        2L,
                        30L);
                unidadVenta = unidadVentaABM.traer(idUnidadVenta);
                System.out.println("Unidad de venta creada: " + unidadVenta);
            }
        } catch (Exception e) {
            System.err.println("Error al crear la unidad de venta: " + e.getMessage());
        }

        try {
            if (unidadVenta != null) {
                int idPersonal = personalABM.agregar(
                        "Ignacio",
                        "Vega",
                        789,
                        LocalDate.of(2003, 5, 15),
                        LocalDate.now(),
                        1200,
                        unidadVenta,
                        "Mañana");
                Personal ignacio = personalABM.traer(idPersonal);
                System.out.println("Personal creado: " + ignacio);
            }
        } catch (Exception e) {
            System.err.println("Error al crear a Ignacio Vega: " + e.getMessage());
        }

        try {
            if (festival != null) {
                System.out.println("\n------------PERSONAL DEL FESTIVAL------------\n");
                List<Personal> personalDelFestival = personalABM.traerPorFestival(festival.getIdFestival());

                for (Personal personal : personalDelFestival) {
                    System.out.println(personal);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al consultar el personal del festival: " + e.getMessage());
        }
    }
}
