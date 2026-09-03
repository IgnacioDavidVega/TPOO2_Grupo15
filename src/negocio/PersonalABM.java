package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.PersonalDAO;
import datos.Cajero;
import datos.Cocinero;
import datos.Personal;
import datos.UnidadVenta;

public class PersonalABM {
    private static PersonalABM instancia = null; // Patrón Singleton

    PersonalDAO dao = PersonalDAO.getInstance();
    
    protected PersonalABM() {
    }

    public static PersonalABM getInstance() {
        if (instancia == null)
            instancia = new PersonalABM();
        return instancia;
    }

    public Personal traer(int idPersonal) {
        return PersonalDAO.getInstance().traer(idPersonal);
    }

    public List<Personal> traer() {
        return PersonalDAO.getInstance().traer();
    }
    
    public int agregar(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, double sueldoBase, UnidadVenta unidadVenta, String turnoTrabajo) {
    	Personal p = new Cajero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, unidadVenta, turnoTrabajo);
    	return dao.agregar(p);
    }
    
    public int agregar(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, double sueldoBase, UnidadVenta unidadVenta, String especialidadCulinaria, double plusCategoria) {
    	Personal p = new Cocinero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, unidadVenta, especialidadCulinaria, plusCategoria);
    	return dao.agregar(p);
    }
    
}
