package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Festival;
import datos.Pedido;

public class PedidoDAO {

    private static Session session;
    private Transaction tx;
    private static PedidoDAO instancia = null; // Patron Singleton

    protected PedidoDAO() {
    }

    public static PedidoDAO getInstance() {
        if (instancia == null)
            instancia = new PedidoDAO();
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

    public Pedido traer(int idPedido) throws HibernateException {
        Pedido objeto = null;
        try {
            iniciaOperacion();
            objeto = (Pedido) session.get(Pedido.class, idPedido);
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return objeto;
    }

    public int agregar(Pedido objeto) throws HibernateException {
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

    public void actualizar(Pedido objeto) throws HibernateException {
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

    public void eliminar(Pedido objeto) throws HibernateException {
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

    public List<Pedido> traer() throws HibernateException {
        List<Pedido> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Pedido p order by p.fechaPedido desc", Pedido.class).list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return lista;
    }

    public List<Pedido> traerPorFestival(Festival festival) throws HibernateException {
        List<Pedido> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Pedido p where p.festival.idFestival = :idFestival", Pedido.class)
                    .setParameter("idFestival", festival.getIdFestival())
                    .list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return lista;
    }
}
