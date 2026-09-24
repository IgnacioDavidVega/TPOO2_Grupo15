package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cocinero;
import datos.Festival;

public class CocineroDAO {

	private static Session session;
	private Transaction tx;
	private static CocineroDAO instancia = null;
	
	protected CocineroDAO() {}
	
	public static CocineroDAO getInstance() {
		if (instancia == null)
				instancia = new CocineroDAO();
			return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public List<Cocinero> traerCocineroPorFestivalYEspecialidad(Festival festival, String especialidadCulinaria){
    	
    	List<Cocinero> lista = null;
		
		try {
	        iniciaOperacion();
	        String hql = "from Cocinero c inner join fetch c.unidadVenta u inner join fetch u.festival f " +
                    "where f = :festival and c.especialidadCulinaria = :especialidadCulinaria";

	        lista = session.createQuery(hql, Cocinero.class).setParameter("festival", festival)
	                .setParameter("especialidadCulinaria", especialidadCulinaria).getResultList();

	    } catch (HibernateException he) {
			
	    	manejaExcepcion(he);
			throw he;
		
	    } finally {
	        session.close();
	    }
		
		return lista;
    }
}
