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

        Plato hamburguesa = null;
        Plato papasFritas = null;
        Plato aguaMineral = null;
        Plato pastaConCamarones = null;
        Plato asadoConPapasFritas = null;
        Plato ramenEspecial = null;

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
                        "Puesto de Ignacio",
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
                        "Food Truck de Ignacio",
                        null, // responsableCargo
                        25, // superficie
                        "IGNVG12346", // código único
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
            if (uv1 != null) {
                int idPersonal = personalABM.agregar(
                        "Ignacio",
                        "Vega",
                        42366713,
                        LocalDate.of(2000, 1, 11),
                        LocalDate.now(),
                        1200,
                        uv1,
                        "Mañana");
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
    }
}
