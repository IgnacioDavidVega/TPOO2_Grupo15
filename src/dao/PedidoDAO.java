package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

}
