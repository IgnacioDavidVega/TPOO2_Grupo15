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

    public Plato traer(int idPlato) throws HibernateException {
        Plato objeto = null;
        try {
            iniciaOperacion();
            objeto = (Plato) session.get(Plato.class, idPlato);
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return objeto;
    }

    public Plato traer(String nombre) throws HibernateException {
        Plato objeto = null;
        try {
            iniciaOperacion();
            objeto = (Plato) session.createQuery("from Plato p where p.nombre = :nombre")
                    .setParameter("nombre", nombre)
                    .uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return objeto;
    }

    public int agregar(Plato objeto) throws HibernateException {
        int id = 0;
        try {
            iniciaOperacion();
            id = (Integer) session.save(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Plato objeto) throws HibernateException {
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

    public void eliminar(Plato objeto) throws HibernateException {
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

    @SuppressWarnings("unchecked")
    public List<Plato> traer() throws HibernateException {
        List<Plato> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Plato p order by p.nombre asc").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return lista;
    }
}