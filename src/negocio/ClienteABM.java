package negocio;

import java.util.List;
import dao.PersonalDAO;
import datos.Personal;

public class ClienteABM {
    private static ClienteABM instancia = null; // Patrón Singleton

    protected ClienteABM() {
    }

    public static ClienteABM getInstance() {
        if (instancia == null)
            instancia = new ClienteABM();
        return instancia;
    }

    public Personal traer(int idPersonal) {
        return PersonalDAO.getInstance().traer(idPersonal);
    }

    public List<Personal> traer() {
        return PersonalDAO.getInstance().traer();
    }
}
