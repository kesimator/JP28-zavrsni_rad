/*
 * Ova klasa sadrži metode za obradu podataka entiteta Prvenstva.
 */
package formula1.controller;

import formula1.model.Prvenstva;
import formula1.model.Timovi;
import formula1.model.Vozaci;
import formula1.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Kesimator
 */
/**
 * Ova klasa sadrži metode za obradu podataka entiteta Prvenstva. Nasljeđuje
 * apstraktnu klasu Obrada.
 *
 * @param <Prvenstva> tip podataka entiteta Prvenstva
 * @see formula1.controller.Obrada
 */
public class ObradaPrvenstva extends Obrada<Prvenstva> {

    /**
     * Konstruktor bez parametara.
     */
    public ObradaPrvenstva() {
        super();
    }

    /**
     * Konstruktor s parametrom.
     *
     * @param p objekt tipa Prvenstva
     */
    public ObradaPrvenstva(Prvenstva p) {
        super(p);
    }

    /**
     * Čita sve zapise entiteta Prvenstva iz baze podataka.
     *
     * @return lista svih entiteta Prvenstva
     */
    @Override
    public List<Prvenstva> read() {
        return session.createQuery("from Prvenstva", Prvenstva.class).list();
    }

    /**
     * Čita sve vozače koji sudjeluju u prvenstvima.
     *
     * @return lista svih vozača u prvenstvima
     */
    public List<Vozaci> readVozaci() {
        return session.createQuery("select p.vozac from Prvenstva p", Vozaci.class).list();
    }

    /**
     * Čita sve timove koji sudjeluju u prvenstvima.
     *
     * @return lista svih timova u prvenstvima
     */
    public List<Timovi> readTimovi() {
        return session.createQuery("select p.tim from Prvenstva p", Timovi.class).list();
    }

    /**
     * Provjerava valjanost podataka prilikom unosa novog entiteta Prvenstva.
     *
     * @throws EdunovaException ako su podaci nevaljani
     */
    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaSezona();
    }

    /**
     * Provjerava valjanost podataka prilikom promjene entiteta Prvenstva.
     *
     * @throws EdunovaException ako su podaci nevaljani
     */
    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        kontrolaUnos();
    }

    /**
     * Provjerava valjanost podataka prilikom brisanja entiteta Prvenstva.
     *
     * @throws EdunovaException ako su podaci nevaljani
     */
    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if (entitet.getVozac() != null) {
            throw new EdunovaException("Vozač je povezan s prvenstvom!\nMolim prvo ukloniti vozača iz prvenstva!");
        }
        if (entitet.getTim() != null) {
            throw new EdunovaException("Tim je povezan s prvenstvom!\nMolim prvo ukloniti tim iz prvenstva!");
        }
    }

    // Metoda koja provjerava valjanost unosa sezone
    private void kontrolaSezona() throws EdunovaException {
        var s = entitet.getSezona();
        if (s == null) {
            throw new EdunovaException("Sezona mora biti definirana!\n(broj između 1950 i 2023)");
        }
        if (s < 1950 || s > 2023) {
            throw new EdunovaException("Sezona mora biti unutar raspona od 1950. godine do 2023. godine!");
        }

        // Provjera postojanja sezone u bazi
        if (sezonaPostoji(s)) {
            throw new EdunovaException("Već postoji sezona s navedenom godinom!");
        }
    }

    // Metoda koja provjerava postojanje sezone u bazi
    private boolean sezonaPostoji(int sezona) {
        List<Prvenstva> svaPrvenstva = read();
        for (Prvenstva p : svaPrvenstva) {
            if (p.getSezona() == sezona) {
                return true;
            }
        }
        return false;
    }

    /**
     * Dodaje vozača u prvenstvo.
     *
     * @param vozac vozač koji se dodaje u prvenstvo
     * @throws EdunovaException ako se dogodi greška prilikom ažuriranja baze
     * podataka
     */
    public void dodajVozaca(Vozaci vozac) throws EdunovaException {
        // Provjeri je li vozač ispravno definiran
        if (vozac == null || vozac.getId() == null) {
            throw new EdunovaException("Vozač nije ispravno definiran!");
        }

        // Postavi prvenstvo vozaču
        vozac.getPrvenstva().add(entitet);

        // Postavi vozača i sezonu prvenstva
        entitet.setVozac(vozac);

        try {
            // Ažuriraj promjene u bazi podataka
            session.getTransaction().begin();
            session.merge(entitet); // Ažuriraj prvenstvo
            session.getTransaction().commit();
        } catch (Exception ex) {
            // U slučaju greške, poništi transakciju
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }

    // Metoda koja uklanja vozača iz prvenstva
    public void ukloniIzPrvenstva(Vozaci vozac, Integer sezona) throws EdunovaException {
        if (vozac == null || vozac.getId() == null || sezona == null) {
            throw new EdunovaException("Vozač ili sezona nisu ispravno definirani!");
        }

        // Pronađi prvenstvo za zadatog vozača i odabranu sezonu
        Prvenstva prvenstvo = session.createQuery(
                "SELECT p FROM Prvenstva p WHERE p.vozac = :vozac AND p.sezona = :sezona", Prvenstva.class)
                .setParameter("vozac", vozac)
                .setParameter("sezona", sezona)
                .getSingleResult();

        // Ukloni vozača iz pronađenog prvenstva
        prvenstvo.setVozac(null);

        try {
            // Ažuriraj promjene u bazi podataka
            session.getTransaction().begin();
            session.merge(prvenstvo); // Ažuriraj prvenstvo
            session.getTransaction().commit();
        } catch (Exception ex) {
            // U slučaju greške, poništi transakciju
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }

    /**
     * Dodaje tim u prvenstvo.
     *
     * @param tim tim koji se dodaje u prvenstvo
     * @throws EdunovaException ako se dogodi greška prilikom ažuriranja baze
     * podataka
     */
    public void dodajTim(Timovi tim) throws EdunovaException {
        // Provjeri je li tim ispravno definiran
        if (tim == null || tim.getId() == null) {
            throw new EdunovaException("Tim nije ispravno definiran!");
        }

        // Postavi prvenstvo timu
        tim.getPrvenstva().add(entitet);

        // Postavi tim i sezonu prvenstva
        entitet.setTim(tim);

        try {
            // Ažuriraj promjene u bazi podataka
            session.getTransaction().begin();
            session.merge(entitet); // Ažuriraj prvenstvo
            session.getTransaction().commit();
        } catch (Exception ex) {
            // U slučaju greške, poništi transakciju
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }

    // Metoda koja uklanja tim iz prvenstva
    public void ukloniIzPrvenstva(Timovi tim, Integer sezona) throws EdunovaException {
        if (tim == null || tim.getId() == null || sezona == null) {
            throw new EdunovaException("Tim ili sezona nisu ispravno definirani!");
        }

        // Pronađi prvenstvo za zadati tim i odabranu sezonu
        Prvenstva prvenstvo = session.createQuery(
                "SELECT p FROM Prvenstva p WHERE p.tim = :tim AND p.sezona = :sezona", Prvenstva.class)
                .setParameter("tim", tim)
                .setParameter("sezona", sezona)
                .getSingleResult();

        // Ukloni tim iz pronađenog prvenstva
        prvenstvo.setTim(null);

        try {
            // Ažuriraj promjene u bazi podataka
            session.getTransaction().begin();
            session.merge(prvenstvo); // Ažuriraj prvenstvo
            session.getTransaction().commit();
        } catch (Exception ex) {
            // U slučaju greške, poništi transakciju
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }
}
