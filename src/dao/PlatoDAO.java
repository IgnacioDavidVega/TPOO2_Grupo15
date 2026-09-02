package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Plato;

public class PlatoDAO {
    private static Session session;
    private Transaction tx;
    private static PlatoDAO instancia = null; // Patron Singleton

    protected PlatoDAO() {
    }

    public static PlatoDAO getInstance() {
        if (instancia == null)
            instancia = new PlatoDAO();
        return instancia;
    }

    protected void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    protected void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

}
