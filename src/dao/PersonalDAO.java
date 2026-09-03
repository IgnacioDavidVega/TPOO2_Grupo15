package dao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.FoodTruck;
import datos.Personal;
import datos.PuestoDesarmable;
import datos.UnidadVenta;

public class PersonalDAO {

    private static Session session;
    private Transaction tx;
    private static PersonalDAO instancia = null; // Patron Singleton

    protected PersonalDAO() {
    }

    public static PersonalDAO getInstance() {
        if (instancia == null)
            instancia = new PersonalDAO();
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

    public Personal traer(int idPersonal) {
        Personal objeto = null;

        try {
            iniciaOperacion();
            objeto = (Personal) session.createQuery("from Personal p where p.idPersonal=:idPersonal")
                    .setParameter("idPersonal", idPersonal).uniqueResult();
        } finally {
            session.close();
        }

        return objeto;
    }

    public List<Personal> traer() throws HibernateException {
        List<Personal> lista = null;

        try {
            iniciaOperacion();
            lista = session.createQuery("from Personal", Personal.class).list();
        } finally {
            session.close();
        }
        return lista;
    }
    
}
