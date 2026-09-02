package negocio;

import java.util.List;
import dao.PersonalDAO;
import datos.Personal;

public class PersonalABM {
    private static PersonalABM instancia = null; // Patrón Singleton

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
}
