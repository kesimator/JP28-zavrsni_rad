/*
 * Apstraktna klasa za upravljanje CRUD operacijama i poslovnom logikom za entitete.
 * @param <T> Tip entiteta koji proširuje klasu Entitet.
 * @author Kesimator
 */
package formula1.controller;

import formula1.model.Entitet;
import formula1.util.EdunovaException;
import formula1.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Kesimator
 */
/**
 * Apstraktna klasa koja predstavlja kontroler za entitete, pružajući metode za
 * CRUD operacije i validaciju.
 *
 * @param <T> Tip entiteta koji proširuje klasu Entitet.
 * @author Kesimator
 */
public abstract class Obrada<T extends Entitet> {

    // Instanca entiteta koja će se manipulirati.
    protected T entitet;

    // Hibernate sesija.
    protected Session session;

    /**
     * Dohvaća listu entiteta iz baze podataka.
     *
     * @return Lista entiteta.
     */
    public abstract List<T> read();

    /**
     * Vrši validaciju prije umetanja novog entiteta u bazu podataka.
     *
     * @throws EdunovaException ako validacija ne uspije.
     */
    protected abstract void kontrolaUnos() throws EdunovaException;

    /**
     * Vrši validaciju prije ažuriranja postojećeg entiteta u bazi podataka.
     *
     * @throws EdunovaException ako validacija ne uspije.
     */
    protected abstract void kontrolaPromjena() throws EdunovaException;

    /**
     * Vrši validaciju prije brisanja postojećeg entiteta iz baze podataka.
     *
     * @throws EdunovaException ako validacija ne uspije.
     */
    protected abstract void kontrolaBrisanje() throws EdunovaException;

    /**
     * Zadani konstruktor.
     */
    public Obrada() {
        session = HibernateUtil.getSession();
    }

    /**
     * Konstruktor s parametrom entiteta.
     *
     * @param entitet Instanca entiteta s kojom se radi.
     */
    public Obrada(T entitet) {
        this();
        this.entitet = entitet;
    }

    /**
     * Umeće novi entitet u bazu podataka.
     *
     * @throws EdunovaException ako validacija ne uspije ili je entitet null.
     */
    public void create() throws EdunovaException {
        kontrolaNull();
        kontrolaUnos();
        persist();
    }

    /**
     * Ažurira postojeći entitet u bazi podataka.
     *
     * @throws EdunovaException ako validacija ne uspije ili je entitet null.
     */
    public void update() throws EdunovaException {
        kontrolaNull();
        kontrolaPromjena();
        persist();
    }

    /**
     * Briše postojeći entitet iz baze podataka.
     *
     * @throws EdunovaException ako validacija ne uspije ili je entitet null.
     */
    public void delete() throws EdunovaException {
        kontrolaNull();
        kontrolaBrisanje();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }

    /**
     * Sprema promjene u bazi podataka.
     */
    private void persist() {
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }

    /**
     * Provjerava je li instanca entiteta null.
     *
     * @throws EdunovaException ako je instanca entiteta null.
     */
    private void kontrolaNull() throws EdunovaException {
        if (entitet == null) {
            throw new EdunovaException("Entitet je null!");
        }
    }

    /**
     * Getter metoda za dohvaćanje instance trenutnog entiteta.
     *
     * @return Trenutna instanca entiteta.
     */
    public T getEntitet() {
        return entitet;
    }

    /**
     * Postavlja trenutnu instancu entiteta.
     *
     * @param entitet Nova instanca entiteta.
     */
    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

    /**
     * Osvježava trenutni entitet u bazi podataka.
     */
    public void refresh() {
        if (entitet != null) {
            session.refresh(entitet);
        }
    }
}
