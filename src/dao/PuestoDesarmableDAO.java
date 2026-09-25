package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;
import datos.PuestoDesarmable;

public class PuestoDesarmableDAO {
	
	private static Session session;
	private Transaction tx;
	private static PuestoDesarmableDAO instancia = null;
	
	protected PuestoDesarmableDAO() {}
	
	public static PuestoDesarmableDAO getInstance() {
		if (instancia == null)
				instancia = new PuestoDesarmableDAO();
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
	
	public List<PuestoDesarmable> traerPuestosDesarmablesPorFestivalYTiempo(Festival festival, long min, long max){
		
		List<PuestoDesarmable> lista = null;
		
		try {
	        iniciaOperacion();
	        String hql = "from PuestoDesarmable p inner join fetch p.festival f " +
	                     "where f = :festival and p.tiempoMontaje between :min and :max";

	        lista = session.createQuery(hql, PuestoDesarmable.class).setParameter("festival", festival)
	                .setParameter("min", min).setParameter("max", max).getResultList();

	    } catch (HibernateException he) {
			
	    	manejaExcepcion(he);
			throw he;
		
	    } finally {
	        session.close();
	    }
		
		return lista;
	}
	
	
	
}
