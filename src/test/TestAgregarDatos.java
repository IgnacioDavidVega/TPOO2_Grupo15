package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.Cajero;
import datos.DetallePedido;
import datos.Festival;
import datos.Pedido;
import datos.Personal;
import datos.Plato;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PersonalABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestAgregarDatos {
    public static void main(String[] args) {
        // Inicializacion
        FestivalABM festivalABM = new FestivalABM();
        PlatoABM platoABM = PlatoABM.getInstance();
        PedidoABM pedidoABM = PedidoABM.getInstance();
        UnidadVentaABM uvABM = UnidadVentaABM.getInstance();
        PersonalABM personalABM = PersonalABM.getInstance();

        // Creacion
        Festival festival1 = null;
        UnidadVenta uv1 = null;
        Festival festival2 = null;
        UnidadVenta uv2 = null;
        UnidadVenta uv3 = null;

        Plato hamburguesa = null;
        Plato papasFritas = null;
        Plato aguaMineral = null;
        Plato pastaConCamarones = null;
        Plato asadoConPapasFritas = null;
        Plato ramenEspecial = null;
        
      //cdu tomás
        Festival festivalNavidad = null;
        UnidadVenta uvParrillaMiguel = null;
        UnidadVenta uvCafeLara = null;
        UnidadVenta uvHeladosMartin = null;
        Plato choripan = null, vacio = null;
        Plato latte = null, americano = null;
        Plato helado = null, cucurucho = null;

        try {
            int idFestival = festivalABM.agregar(
                    "Festival de Primavera",
                    "Primavera",
                    LocalDate.now(),
                    LocalDate.now().plusDays(3),
                    new HashSet<>());
            festival1 = festivalABM.traer(idFestival);
            System.out.println("Festival creado: " + festival1);
        } catch (Exception e) {
            System.err.println("Error al crear el festival: " + e.getMessage());
        }

        try {
            if (festival1 != null) {
                int idUnidadVenta = uvABM.agregar(
                        "El Chorigol",
                        null,
                        25,
                        "IGNVG12345",
                        festival1,
                        1,
                        30);
                uv1 = uvABM.traer(idUnidadVenta);
                System.out.println("Unidad de venta creada: " + uv1);
            }
        } catch (Exception e) {
            System.err.println("Error al crear la unidad de venta: " + e.getMessage());
        }

        try {
            if (festival1 != null) {
                int idUnidadVenta = uvABM.agregar(
                        "Mollejas El Pelita S.",
                        null, // responsableCargo
                        25, // superficie
                        "IGLRG12346", // código único
                        festival1,
                        "AA123BB", // patente
                        true // conexión eléctrica
                );
                uv2 = uvABM.traer(idUnidadVenta);
                System.out.println("FoodTruck creado: " + uv2);
            }
        } catch (Exception e) {
            System.err.println("Error al crear la unidad de venta: " + e.getMessage());
        }
        
        try {
            if (festival1 != null) {
                int idUnidadVenta = uvABM.agregar(
                        "Hamburguesas el Mago",
                        null,
                        25,
                        "LKASD81461",
                        festival1,
                        2,
                        60);
                uv3 = uvABM.traer(idUnidadVenta);
                System.out.println("Unidad de venta creada: " + uv3);
            }
        } catch (Exception e) {
            System.err.println("Error al crear la unidad de venta: " + e.getMessage());
        }

        try {
            if (uv1 != null) {
                int idPersonal = personalABM.agregar(
                        "Ignacio",
                        "Vega",
                        42366713,
                        LocalDate.of(2000, 1, 11),
                        LocalDate.now(),
                        1200,
                        uv1,
                        "Mañana",
                        1);;
                Personal ignacio = personalABM.traer(idPersonal);
                System.out.println("Personal creado: " + ignacio);
            }
        } catch (Exception e) {
            System.err.println("Error al crear a Ignacio Vega: " + e.getMessage());
        }

        try {
            if (uv1 != null) {
                int idPersonal = personalABM.agregar(
                        "Ricardo",
                        "Villalobos",
                        43092082,
                        LocalDate.of(2000, 12, 26),
                        LocalDate.now(),
                        1900,
                        uv1,
                        "Chef",
                        2000);
                Personal ricardo = personalABM.traer(idPersonal);
                System.out.println("Personal creado: " + ricardo);
            }
        } catch (Exception e) {
            System.err.println("Error al crear a Ricardo Villalobos: " + e.getMessage());
        }
        
        try {
            if (uv1 != null) {
                int idPersonal = personalABM.agregar(
                        "Jose",
                        "Rivadavia",
                        45015012,
                        LocalDate.of(2001, 1, 6),
                        LocalDate.now(),
                        1800,
                        uv1,
                        "Chef",
                        2100);
                Personal Jose = personalABM.traer(idPersonal);
                System.out.println("Personal creado: " + Jose);
            }
        } catch (Exception e) {
            System.err.println("Error al crear a Jose Rivadavia: " + e.getMessage());
        }
        
        try {
            if (uv3 != null) {
                int idPersonal = personalABM.agregar(
                        "Pablo",
                        "Ramirez",
                        34598712,
                        LocalDate.of(1990, 11, 16),
                        LocalDate.now(),
                        1700,
                        uv3,
                        "Chef",
                        2200);
                Personal Pablo = personalABM.traer(idPersonal);
                System.out.println("Personal creado: " + Pablo);
            }
        } catch (Exception e) {
            System.err.println("Error al crear a Jose Rivadavia: " + e.getMessage());
        }
        
        try {
            if (uv2 != null) {
                int idPersonal = personalABM.agregar(
                        "Agustin",
                        "Pino",
                        42312151,
                        LocalDate.of(1994, 3, 5),
                        LocalDate.now(),
                        1780,
                        uv2,
                        "Chef",
                        2280);
                Personal Agustin = personalABM.traer(idPersonal);
                System.out.println("Personal creado: " + Agustin);
            }
        } catch (Exception e) {
            System.err.println("Error al crear a Jose Rivadavia: " + e.getMessage());
        }
        
        // TOMAS
        try {
            if (festival1 != null) {
                int idU1 = uvABM.agregar("La Parrilla de Miguel", null, 20, "LAPAR00001", festival1, "aaa111", true);
                uvParrillaMiguel = uvABM.traer(idU1);

                int idU2 = uvABM.agregar("El Café de Lara", null, 30, "ELCAF00002", festival1, 3L, 60L);
                uvCafeLara = uvABM.traer(idU2);

                int idU3 = uvABM.agregar("Helados Martin", null, 20, "HELAD00003", festival1, "bbb222", true);
                uvHeladosMartin = uvABM.traer(idU3);

                System.out.println("Unidades de Tomas creadas: " + uvParrillaMiguel + " | " + uvCafeLara + " | " + uvHeladosMartin);
            }

        } catch (Exception e) {
            System.err.println("Error al crear las unidades de Tomas: " + e.getMessage());
        }

        try {

            choripan = platoABM.traer(platoABM.agregar("Choripan", 8000.0, 6000.0));
            vacio = platoABM.traer(platoABM.agregar("Vacio", 15000.0, 10000.0));
            latte = platoABM.traer(platoABM.agregar("Latte con medialunas", 10000.0, 2000.0));
            americano = platoABM.traer(platoABM.agregar("Americano", 4500.0, 1500.0));
            helado = platoABM.traer(platoABM.agregar("1/4 de helado", 10000.0, 5000.0));
            cucurucho = platoABM.traer(platoABM.agregar("Cucurucho", 15000.0, 9000.0));

        } catch (Exception e) {
            System.err.println("Error al crear los platos de Tomas: " + e.getMessage());

        }

        try {

            if (uvParrillaMiguel != null && uvCafeLara != null && uvHeladosMartin != null) {
                personalABM.agregar("Miguel", "Ramos", 111111, LocalDate.of(1988, 6, 14),
                        LocalDate.now().minusDays(5), 500000.0, uvParrillaMiguel, "Asado", 200000.0);
                personalABM.agregar("Luis", "Perez", 222222, LocalDate.of(1996, 11, 2),
                        LocalDate.now().minusDays(5), 500000.0, uvParrillaMiguel, "Tarde", 2);

                personalABM.agregar("Lara", "Sanchez", 333333, LocalDate.of(1992, 3, 27),
                        LocalDate.now().minusDays(5), 500000.0, uvCafeLara, "Barista", 250000.0);

                personalABM.agregar("Nahuel", "Dias", 444444, LocalDate.of(2001, 9, 19),
                        LocalDate.now().minusDays(5), 500000.0, uvCafeLara, "Tarde", 3);

                personalABM.agregar("Martin", "Gimenez", 555555, LocalDate.of(1985, 1, 8),
                        LocalDate.now().minusDays(5), 500000.0, uvHeladosMartin, "Helado", 150000.0);

                personalABM.agregar("Tomas", "Casco", 666666, LocalDate.of(1999, 7, 30),
                        LocalDate.now().minusDays(5), 500000.0, uvHeladosMartin, "Tarde", 4);
                
                System.out.println("Personal de Tomas cargado.");
            }

        } catch (Exception e) {

            System.err.println("Error al crear el personal de Tomas: " + e.getMessage());

        }

        try {
            if (festival1 != null && uvParrillaMiguel != null && uvCafeLara != null && uvHeladosMartin != null) {
                Set<DetallePedido> detalle1 = new HashSet<>();
                detalle1.add(new DetallePedido(choripan, 10));
                detalle1.add(new DetallePedido(vacio, 5));
                pedidoABM.agregar(LocalDate.now(), festival1, uvParrillaMiguel, detalle1);

                Set<DetallePedido> detalle2 = new HashSet<>();
                detalle2.add(new DetallePedido(latte, 10));
                detalle2.add(new DetallePedido(americano, 15));
                pedidoABM.agregar(LocalDate.now(), festival1, uvCafeLara, detalle2);

                Set<DetallePedido> detalle3 = new HashSet<>();
                detalle3.add(new DetallePedido(helado, 8));
                detalle3.add(new DetallePedido(cucurucho, 4));
                pedidoABM.agregar(LocalDate.now(), festival1, uvHeladosMartin, detalle3);

                System.out.println("Pedidos de Tomas cargados.");

            }

        } catch (Exception e) {

            System.err.println("Error al cargar los pedidos de Tomas: " + e.getMessage());
        }
        // TOMAS

    }


}
        
        
