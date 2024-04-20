package formula1.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Util klasa koja omogućuje dobivanje Hibernate sesije.
 */
public class HibernateUtil {

    /**
     * Hibernate sesija.
     */
    private static Session session = null;

    /**
     * Privatni konstruktor koji inicijalizira Hibernate sesiju.
     */
    private HibernateUtil() {
        session = new Configuration().configure().buildSessionFactory().openSession();
    }

    /**
     * Metoda koja vraća Hibernate sesiju.
     *
     * @return Hibernate sesija
     */
    public static Session getSession() {
        if (session == null) {
            new HibernateUtil();
        }
        return session;
    }

}
