package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cajero;
import datos.Pedido;
import datos.Plato;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PersonalABM;

public class TestBrianAvila {

    public static void main(String[] args) {
        FestivalABM festivalABM = new FestivalABM();
        PedidoABM pedidoABM = PedidoABM.getInstance();
        PersonalABM personalABM = PersonalABM.getInstance();

        // 1. Traer el plato más vendido del Festival
        try {
            long idFestival = 1L;
            Plato masVendido = festivalABM.traerPlatoMasVendido(idFestival);

            if (masVendido != null) {
                System.out.println("Plato más vendido: " + masVendido.getNombrePlato());
            } else {
                System.out.println("No hay ventas registradas para este festival.");
            }
        } catch (Exception e) {
            System.err.println("Error al traer el plato más vendido: " + e.getMessage());
        }

        // 2. Traer pedidos entre un rango de fechas
        try {
            LocalDate desde = LocalDate.now().minusDays(1);
            LocalDate hasta = LocalDate.now();

            List<Pedido> pedidos = pedidoABM.traerPorRangoFechas(desde, hasta);
            System.out.println("Cantidad de pedidos entre " + desde + " y " + hasta + ": " + pedidos.size());
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        } catch (Exception e) {
            System.err.println("Error al traer pedidos por rango de fechas: " + e.getMessage());
        }

        // 3. Traer el cajero más joven
        try {
            Cajero cajeroMasJoven = personalABM.traerCajeroMasJoven();

            if (cajeroMasJoven != null) {
                System.out.println("Cajero más joven: " + cajeroMasJoven.getNombre() + " " 
                        + cajeroMasJoven.getApellido() + " (Nacimiento: " 
                        + cajeroMasJoven.getFechaNacimiento() + ")");
            } else {
                System.out.println("No se encontraron cajeros registrados.");
            }
        } catch (Exception e) {
            System.err.println("Error al traer el cajero más joven: " + e.getMessage());
        }
    }
}
