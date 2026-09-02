package test;

import org.hibernate.Session;
import dao.HibernateUtil;

public class testConexion {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
        System.out.println("Test de conexion OK");
    }
}
