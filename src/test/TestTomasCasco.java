package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import datos.DetallePedido;
import datos.Festival;
import datos.Plato;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PersonalABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestTomasCasco {

    public static void main(String[] args) {
        FestivalABM festivalABM = new FestivalABM();
        UnidadVentaABM uvABM = UnidadVentaABM.getInstance();
        PlatoABM platoABM = PlatoABM.getInstance();
        PersonalABM personalABM = PersonalABM.getInstance();
        PedidoABM pedidoABM = PedidoABM.getInstance();

        Festival festival = null;
        UnidadVenta unidad1 = null; 
        UnidadVenta unidad2 = null; 
        UnidadVenta unidad3 = null; 

        Plato choripan = null, vacio = null;
        Plato latte = null, americano = null;
        Plato helado = null, cucurucho = null;

        // crear el festival
        try {
            long idFestival = festivalABM.agregar("Festival de Navidad", "Verano",
                    LocalDate.of(2025, 12, 24), LocalDate.of(2025, 12, 26), new HashSet<>());
            festival = festivalABM.traer(idFestival);
            System.out.println("Festival creado: " + festival);
        } catch (Exception e) {
            System.err.println("Error al crear el festival: " + e.getMessage());
        }

        // crear las 3 unidades de venta
        try {
            if (festival != null) {
                int idU1 = uvABM.agregar("La Parrilla de Miguel", null, 20, "LAPAR00001", festival, "aaa111", true);
                unidad1 = uvABM.traer(idU1);

                int idU2 = uvABM.agregar("El Café de Lara", null, 30, "ELCAF00002", festival, 3L, 60L);
                unidad2 = uvABM.traer(idU2);

                int idU3 = uvABM.agregar("Helados Martin", null, 20, "HELAD00003", festival, "bbb222", true);
                unidad3 = uvABM.traer(idU3);

                System.out.println("Unidades creadas: " + unidad1 + " | " + unidad2 + " | " + unidad3);
            }
        } catch (Exception e) {
            System.err.println("Error al crear las unidades de venta: " + e.getMessage());
        }

        // crear platos
        try {
            choripan = platoABM.traer(platoABM.agregar("Choripan", 8000.0, 6000.0));
            vacio = platoABM.traer(platoABM.agregar("Vacio", 15000.0, 10000.0));

            latte = platoABM.traer(platoABM.agregar("Latte con medialunas", 10000.0, 2000.0));
            americano = platoABM.traer(platoABM.agregar("Americano", 4500.0, 1500.0));

            helado = platoABM.traer(platoABM.agregar("1/4 de helado", 10000.0, 5000.0));
            cucurucho = platoABM.traer(platoABM.agregar("Cucurucho", 15000.0, 9000.0));
        } catch (Exception e) {
            System.err.println("Error al crear los platos: " + e.getMessage());
        }

        // asignar platos a cada UV
        try {
            if (unidad1 != null && unidad2 != null && unidad3 != null) {
                uvABM.agregarPlato(unidad1.getIdUnidadVenta(), choripan);
                uvABM.agregarPlato(unidad1.getIdUnidadVenta(), vacio);

                uvABM.agregarPlato(unidad2.getIdUnidadVenta(), latte);
                uvABM.agregarPlato(unidad2.getIdUnidadVenta(), americano);

                uvABM.agregarPlato(unidad3.getIdUnidadVenta(), helado);
                uvABM.agregarPlato(unidad3.getIdUnidadVenta(), cucurucho);

                System.out.println("Platos asignados correctamente");
            }
        } catch (Exception e) {
            System.err.println("Error al asignar platos a las unidades: " + e.getMessage());
        }

        // crear empleados
        try {
            if (unidad1 != null && unidad2 != null && unidad3 != null) {
                
                personalABM.agregar("Miguel", "Ramos", 111111, LocalDate.of(1988, 6, 14),
                        LocalDate.now().minusDays(5), 500000.0, unidad1, "Asado", 200000.0); // cocinero
                personalABM.agregar("Luis", "Perez", 222222, LocalDate.of(1996, 11, 2),
                        LocalDate.now().minusDays(5), 500000.0, unidad1, "Tarde"); // cajero

               
                personalABM.agregar("Lara", "Sanchez", 333333, LocalDate.of(1992, 3, 27), LocalDate.now().minusDays(5), 500000.0, unidad2, "Barista", 250000.0); 
                personalABM.agregar("Nahuel", "Dias", 444444, LocalDate.of(2001, 9, 19), LocalDate.now().minusDays(5), 500000.0, unidad2, "Tarde"); 

             
                personalABM.agregar("Martin", "Gimenez", 555555, LocalDate.of(1985, 1, 8), LocalDate.now().minusDays(5), 500000.0, unidad3, "Helado", 150000.0); 
                personalABM.agregar("Tomas", "Casco", 666666, LocalDate.of(1999, 7, 30), LocalDate.now().minusDays(5), 500000.0, unidad3, "Tarde"); 

                System.out.println("Personal cargado exitosamente");
            }
        } catch (Exception e) {
            System.err.println("Error al crear el personal: " + e.getMessage());
        }

        // crear pedidos
        try {
            if (festival != null && unidad1 != null && unidad2 != null && unidad3 != null) {
                
                Set<DetallePedido> detalle1 = new HashSet<>();
                detalle1.add(new DetallePedido(choripan, 10));
                detalle1.add(new DetallePedido(vacio, 5));
                pedidoABM.agregar(LocalDate.of(2025, 12, 24), festival, unidad1, detalle1);

                
                Set<DetallePedido> detalle2 = new HashSet<>();
                detalle2.add(new DetallePedido(latte, 10));
                detalle2.add(new DetallePedido(americano, 15));
                pedidoABM.agregar(LocalDate.of(2025, 12, 24), festival, unidad2, detalle2);

                
                Set<DetallePedido> detalle3 = new HashSet<>();
                detalle3.add(new DetallePedido(helado, 8));
                detalle3.add(new DetallePedido(cucurucho, 4));
                pedidoABM.agregar(LocalDate.of(2025, 12, 24), festival, unidad3, detalle3);

                System.out.println("Pedidos cargados exitosamente");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar los pedidos: " + e.getMessage());
        }

        // CASO DE USO: mostrar la unidad que mas recaudo, su plato mas vendido y su plato mas redituable
        try {
            if (festival != null) {
                UnidadVenta ganadora = uvABM.traerUnidadVentaMasRecaudadora(festival.getIdFestival());
                System.out.println("\n------------CASO DE USO: UNIDAD QUE MAS RECAUDO------------\n");
                System.out.println(ganadora);

                if (ganadora != null) {
                    Plato masVendido = platoABM.traerMasVendidoPorUnidadVenta(ganadora.getIdUnidadVenta());
                    System.out.println("Plato mas vendido en esa unidad: " + masVendido);

                    Plato masRedituable = platoABM.traerMasRedituablePorUnidadVenta(ganadora.getIdUnidadVenta());
                    System.out.println("Plato mas redituable en esa unidad: " + masRedituable);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al ejecutar el caso de uso: " + e.getMessage());
        }
    }
}