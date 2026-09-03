package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Personal;

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

    public int agregar(Personal objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Personal objeto) throws HibernateException {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminar(Personal objeto) throws HibernateException {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public Personal traerDNI(int dni) {
        Personal objeto = null;

        try {
            iniciaOperacion();
            String hql = "from Personal p where p.dni = :dni";
            objeto = (Personal) session.createQuery(hql).setParameter("dni", dni).uniqueResult();

        } finally {
            session.close();
        }

        return objeto;
    }

    // Consulta para saber cuantas personas trabajan en un festival especifico
    public List<Personal> traerPorFestival(long idFestival) throws HibernateException {
        List<Personal> lista = null;

        try {
            iniciaOperacion();

            String hql = "select p " +
                    "from Personal p " +
                    "join p.unidadVenta u " +
                    "join u.festival f " +
                    "where f.idFestival = :idFestival";

            lista = session.createQuery(hql, Personal.class)
                    .setParameter("idFestival", idFestival)
                    .getResultList();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }

        return lista;
    }

}
