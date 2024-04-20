/*
 * Ova klasa se koristi za obradu podataka o vozačima u sustavu Formula 1.
 * Omogućuje čitanje, unos, promjenu i brisanje podataka o vozačima, kao i dodatne funkcionalnosti.
 */
package formula1.controller;

import formula1.model.Prvenstva;
import formula1.model.Timovi;
import formula1.model.Vozaci;
import formula1.util.EdunovaException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 *
 * @author Kesimator
 */
/**
 * Ova klasa se koristi za obradu podataka o vozačima u sustavu Formula 1.
 */
public class ObradaVozaci extends Obrada<Vozaci> {

    /**
     * Konstruktor klase ObradaVozaci bez parametara.
     */
    public ObradaVozaci() {
        super();
    }

    /**
     * Konstruktor klase ObradaVozaci s parametrom vozila.
     *
     * @param v Vozac za obradu
     */
    public ObradaVozaci(Vozaci v) {
        super(v);
    }

    /**
     * Metoda za čitanje svih vozača iz baze podataka.
     *
     * @return Lista vozača
     */
    @Override
    public List<Vozaci> read() {
        List<Vozaci> lista = session.createQuery("from Vozaci order by ime, prezime", Vozaci.class).list();
        return lista;
    }

    /**
     * Metoda za čitanje vozača koji zadovoljavaju određeni uvjet pretraživanja.
     *
     * @param uvjet Uvjet pretraživanja
     * @return Lista vozača koji zadovoljavaju uvjet pretraživanja
     */
    public List<Vozaci> read(String uvjet) {
        if (uvjet.isEmpty()) {
            return session.createQuery("from Vozaci order by ime, prezime", Vozaci.class).list();
        }
        return session.createQuery("from Vozaci where upper(ime) like :uvjet "
                + "or upper(prezime) like :uvjet "
                + "or upper(nacionalnost) like :uvjet "
                + "order by ime, prezime", Vozaci.class)
                .setParameter("uvjet", "%" + uvjet.toUpperCase() + "%")
                .list();
    }

    /**
     * Metoda za dohvaćanje vozača koji nemaju dodijeljen tim.
     *
     * @param uvjet Uvjet pretraživanja
     * @return Lista vozača bez dodijeljenog tima
     */
    public List<Vozaci> dohvatiVozaceBezTima(String uvjet) {
        if (uvjet == null || uvjet.isEmpty()) {
            return session.createQuery("SELECT v FROM Vozaci v WHERE v.tim IS NULL", Vozaci.class).getResultList();
        } else {
            return session.createQuery("SELECT v FROM Vozaci v WHERE v.tim IS NULL AND (upper(v.ime) LIKE :uvjet OR upper(v.prezime) LIKE :uvjet)", Vozaci.class)
                    .setParameter("uvjet", "%" + uvjet.toUpperCase() + "%")
                    .getResultList();
        }
    }

    /**
     * Metoda za dohvaćanje vozača koji su dodijeljeni nekom timu.
     *
     * @return Lista vozača u timu
     */
    public List<Vozaci> dohvatiVozaceUTimu() {
        return session.createQuery("SELECT v FROM Vozaci v WHERE v.tim IS NOT NULL", Vozaci.class).getResultList();
    }

    /**
     * Metoda za kontrolu ispravnosti unosa podataka o vozaču.
     *
     * @throws EdunovaException
     */
    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaDatumRodenja();
        kontrolaNacionalnost();
        kontrolaJedinstvenostiVozaca();
        if (entitet.getId() == null) {
            entitet.setTim(null);
        }
    }

    /**
     * Metoda za kontrolu ispravnosti promjene podataka o vozaču.
     *
     * @throws EdunovaException
     */
    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        if (entitet.getId() != null) {
            kontrolaUnos();
        } else {
            kontrolaPromjena();
        }
    }

    /**
     * Metoda za kontrolu ispravnosti brisanja podataka o vozaču.
     *
     * @throws EdunovaException
     */
    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if (!entitet.getPrvenstva().isEmpty()) {
            throw new EdunovaException("Vozač sudjeluje u nekom prvenstvu i ne može biti obrisan!");
        }

        Timovi tim = entitet.getTim();
        if (tim != null) {
            throw new EdunovaException("Vozač je povezan s timom i ne može biti obrisan!\n[" + tim.getIme_tima() + "]");
        }
    }

    /**
     * Metoda za provjeru ispravnosti unesenog imena vozača.
     *
     * @throws EdunovaException
     */
    private void kontrolaIme() throws EdunovaException {
        var i = entitet.getIme();
        if (i == null) {
            throw new EdunovaException("Ime vozača mora biti definirano!");
        }
        if (i.isEmpty()) {
            throw new EdunovaException("Ime vozača obavezno!");
        }
        if (!i.matches("[a-zA-ZčćžšđČĆŽŠĐ ]+")) {
            throw new EdunovaException("Ime vozača ne smije sadržavati brojeve ni posebne znakove!");
        }
        if (i.length() > 20) {
            throw new EdunovaException("Ime vozača ne smije biti duže od 20 znakova!");
        }
        entitet.setIme(entitet.getIme().toUpperCase());
    }

    /**
     * Metoda za provjeru ispravnosti unesenog prezimena vozača.
     *
     * @throws EdunovaException
     */
    private void kontrolaPrezime() throws EdunovaException {
        var p = entitet.getPrezime();
        if (p == null) {
            throw new EdunovaException("Prezime vozača mora biti definirano!");
        }
        if (p.isEmpty()) {
            throw new EdunovaException("Prezime vozača obavezno!");
        }
        if (!p.matches("[a-zA-ZčćžšđČĆŽŠĐ ]+")) {
            throw new EdunovaException("Prezime vozača ne smije sadržavati brojeve ni posebne znakove!");
        }
        if (p.length() > 50) {
            throw new EdunovaException("Prezime vozača ne smije biti duže od 50 znakova!");
        }
        entitet.setPrezime(entitet.getPrezime().toUpperCase());
    }

    /**
     * Metoda za provjeru ispravnosti unesene nacionalnosti vozača.
     *
     * @throws EdunovaException
     */
    private void kontrolaNacionalnost() throws EdunovaException {
        var n = entitet.getNacionalnost();
        if (n == null) {
            throw new EdunovaException("Nacionalnost vozača mora biti definirano!");
        }
        if (n.isEmpty()) {
            throw new EdunovaException("Nacionalnost vozača obavezno!");
        }
        if (!n.matches("[a-zA-ZčćžšđČĆŽŠĐ ]+")) {
            throw new EdunovaException("Nacionalnost vozača ne smije sadržavati brojeve ni posebne znakove!");
        }
        if (n.length() > 30) {
            throw new EdunovaException("Nacionalnost vozača ne smije biti duže od 30 znakova!");
        }
        entitet.setNacionalnost(entitet.getNacionalnost().toUpperCase());
    }

    /**
     * Metoda za provjeru ispravnosti unesenog datuma rođenja vozača.
     *
     * @throws EdunovaException
     */
    private void kontrolaDatumRodenja() throws EdunovaException {
        var dr = entitet.getDatum_rodenja();
        if (dr == null) {
            throw new EdunovaException("Datum rođenja mora biti definiran!\nUnijeti datum u formatu mm.DD.yyyy.");
        }

        // Trenutni datum
        LocalDate danas = LocalDate.now();

        // Računanje razlike u godinama između datuma rođenja i danas
        int godine = Period.between(dr, danas).getYears();

        // Provjera uvjeta
        if (godine < 18 || godine > 60) {
            throw new EdunovaException("Vozač ne može biti mlađi od 18 godina ili stariji od 60 godina!");
        }

    }

    /**
     * Metoda za provjeru jedinstvenosti vozača prema osobnim podacima.
     *
     * @throws EdunovaException
     */
    private void kontrolaJedinstvenostiVozaca() throws EdunovaException {
        String ime = entitet.getIme();
        String prezime = entitet.getPrezime();
        LocalDate datum_rodenja = entitet.getDatum_rodenja();
        String nacionalnost = entitet.getNacionalnost();

        // Provjera postoji li već vozač s istim osobnim podacima
        List<Vozaci> istiVozaci = session.createQuery(
                "SELECT v FROM Vozaci v WHERE v.ime = :ime "
                + "AND v.prezime = :prezime "
                + "AND v.datum_rodenja = :datum_rodenja "
                + "AND v.nacionalnost = :nacionalnost", Vozaci.class)
                .setParameter("ime", ime)
                .setParameter("prezime", prezime)
                .setParameter("datum_rodenja", datum_rodenja)
                .setParameter("nacionalnost", nacionalnost)
                .getResultList();

        // Ako postoji vozač s istim osobnim podacima, baci iznimku
        if (!istiVozaci.isEmpty()) {
            throw new EdunovaException("Već postoji vozač s istim osobnim podacima!");
        }
    }

    /**
     * Metoda za uklanjanje vozača iz tima.
     *
     * @param vozac Vozač koji se uklanja iz tima
     * @throws EdunovaException
     */
    public void ukloniIzTima(Vozaci vozac) throws EdunovaException {
        if (vozac == null || vozac.getId() == null) {
            throw new EdunovaException("Vozač nije ispravno definiran!");
        }

        // Provjera postoji li vozač u timu
        Timovi tim = vozac.getTim();
        if (tim == null) {
            throw new EdunovaException("Vozač nije dodijeljen timu!");
        }

        // Ukloni vozača iz tima
        tim.getVozaci().remove(vozac);
        vozac.setTim(null);

        try {
            // Ažuriraj promjene u bazi podataka
            session.getTransaction().begin();
            session.merge(tim); // Ažuriraj tim
            session.merge(vozac); // Ažuriraj vozača
            session.getTransaction().commit();
        } catch (Exception ex) {
            // U slučaju greške, poništi transakciju
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }

    /**
     * Metoda za provjeru je li vozač sudionik nekog prvenstva.
     *
     * @param vozac Vozač čija se sudionost u prvenstvu provjerava
     * @return true ako vozač nije sudionik prvenstva, inače baca iznimku
     * @throws EdunovaException
     */
    public boolean provjeriVozaca(Vozaci vozac) throws EdunovaException {
        // Provjeri je li vozač u nekom prvenstvu
        if (!vozac.getPrvenstva().isEmpty()) {
            throw new EdunovaException("Vozač sudjeluje u nekom prvenstvu.");
        }

        // Vozač nije u timu niti u prvenstvu, vraćamo true
        return true;
    }

    /**
     * Metoda za uklanjanje vozača iz svih prvenstava kojima pripada.
     *
     * @param vozac Vozač čiji se uklanjanje iz prvenstava provodi
     * @throws EdunovaException
     */
    public void ukloniIzPrvenstva(Vozaci vozac) throws EdunovaException {
        try {
            // Ukloni vozača iz svih prvenstava u kojima sudjeluje
            if (!vozac.getPrvenstva().isEmpty()) {
                for (Prvenstva prvenstvo : vozac.getPrvenstva()) {
                    prvenstvo.setVozac(null);
                }
                vozac.getPrvenstva().clear(); // Očisti listu prvenstava

                // Ažuriraj promjene u bazi podataka
                session.getTransaction().begin();
                session.merge(vozac); // Ažuriraj vozača
                session.getTransaction().commit();
            } else {
                throw new EdunovaException("Vozač nema osvojenih prvenstava!");
            }
        } catch (Exception ex) {
            // U slučaju greške, poništi transakciju
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }
}
