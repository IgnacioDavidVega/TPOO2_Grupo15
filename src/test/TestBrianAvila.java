package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.Cajero;
import datos.DetallePedido;
import datos.Festival;
import datos.Pedido;
import datos.Plato;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PersonalABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestBrianAvila {

    public static void main(String[] args) {
        FestivalABM festivalABM = new FestivalABM();
        PlatoABM platoABM = PlatoABM.getInstance();
        PedidoABM pedidoABM = PedidoABM.getInstance();
        UnidadVentaABM uvABM = UnidadVentaABM.getInstance();
        PersonalABM personalABM = PersonalABM.getInstance();

        Festival festival = null;
        UnidadVenta puesto = null;
        Plato burger = null;
        Plato papas = null;

        // Primer CDU: Traer el plato más vendido del Festival
        try {
            long idFestival = festivalABM.agregar("Lollapalooza 2026", "Predio Hipódromo", LocalDate.now(), LocalDate.now().plusDays(3), new HashSet<>());
            festival = festivalABM.traer(idFestival);
        } catch (Exception e) {
            System.err.println("Error al dar de alta el festival: " + e.getMessage());
        }

        try {
            if (festival != null) {
                int idUV = uvABM.agregar("Puesto de Burritos", null, 25L, "LOLAP12345", festival, 2L, 30L);
                puesto = uvABM.traer(idUV);
            }
        } catch (Exception e) {
            System.err.println("Error al dar de alta la unidad de venta: " + e.getMessage());
        }

        try {
            int idBurger = platoABM.agregar("Burger Simple", 8500.0, 3200.0);
            int idPapas = platoABM.agregar("Papas Cheddar", 4500.0, 1500.0);

            burger = platoABM.traer(idBurger);
            papas = platoABM.traer(idPapas);
        } catch (Exception e) {
            System.err.println("Error al agregar platos: " + e.getMessage());
        }

        try {
            if (festival != null && puesto != null && burger != null && papas != null) {
                Set<DetallePedido> detallesCliente1 = new HashSet<>();
                detallesCliente1.add(new DetallePedido(burger, 3));
                detallesCliente1.add(new DetallePedido(papas, 1));
                pedidoABM.agregar(LocalDate.now(), festival, puesto, detallesCliente1);

                Set<DetallePedido> detallesCliente2 = new HashSet<>();
                detallesCliente2.add(new DetallePedido(burger, 2));
                pedidoABM.agregar(LocalDate.now(), festival, puesto, detallesCliente2);
            }
        } catch (Exception e) {
            System.err.println("Error al registrar los pedidos: " + e.getMessage());
        }

        try {
            if (festival != null) {
                Plato masVendido = festivalABM.traerPlatoMasVendido(festival.getIdFestival());

                if (masVendido != null) {
                    System.out.println("Plato más vendido en " + festival.getNombre() + ": " + masVendido.getNombrePlato());
                } else {
                    System.out.println("No hay ventas registradas para este festival.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }

        // Segundo CDU: Traer pedidos entre fechas.
        try {
            LocalDate desde = LocalDate.now().minusDays(1);
            LocalDate hasta = LocalDate.now();

            List<Pedido> pedidos = pedidoABM.traerPorRangoFechas(desde, hasta);
            System.out.println("Cantidad de pedidos entre fechas: " + pedidos.size());
        } catch (Exception e) {
            System.err.println("Error al traer pedidos por fechas: " + e.getMessage());
        }

        // Tercer CDU: Traer al cajero más joven.
        try {
            if (puesto != null) {
                personalABM.agregar("Ivan", "Maldonado", 123457, LocalDate.of(1998, 3, 15), LocalDate.now(), 450000.0, puesto, "Tarde");
                personalABM.agregar("Facundo", "Blanco", 123456, LocalDate.of(2004, 11, 20), LocalDate.now(), 450000.0, puesto, "Mañana");
            }
            Cajero cajeroMasJoven = personalABM.traerCajeroMasJoven();

            if (cajeroMasJoven != null) {
                System.out.println("Cajero más joven: " + cajeroMasJoven.getNombre() + " " 
                        + cajeroMasJoven.getApellido() + " (Fecha de Nacimiento: " 
                        + cajeroMasJoven.getFechaNacimiento() + ")");
            } else {
                System.out.println("No se encontraron cajeros registrados.");
            }
        } catch (Exception e) {
            System.err.println("Error en la consulta de personal: " + e.getMessage());
        }
    }
}
