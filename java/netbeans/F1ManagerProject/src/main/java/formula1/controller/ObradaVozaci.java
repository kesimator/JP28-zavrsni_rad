/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class ObradaVozaci extends Obrada<Vozaci> {

    public ObradaVozaci() {
        super();
    }

    public ObradaVozaci(Vozaci v) {
        super(v);
    }

    @Override
    public List<Vozaci> read() {

        List<Vozaci> lista = session.createQuery("from Vozaci order by ime, prezime", Vozaci.class).list();

        return lista;
    }

    public List<Vozaci> read(String uvjet) {

        // Ako je uvjet prazan, vrati sve vozače
        if (uvjet.isEmpty()) {
            return session.createQuery("from Vozaci order by ime, prezime", Vozaci.class).list();
        }

        // Inače, vrati vozače koji zadovoljavaju uvjet pretraživanja
        return session.createQuery("from Vozaci where upper(ime) like :uvjet "
                + "or upper(prezime) like :uvjet "
                + "or upper(nacionalnost) like :uvjet "
                + "order by ime, prezime", Vozaci.class)
                .setParameter("uvjet", "%" + uvjet.toUpperCase() + "%")
                .list();
    }

    public List<Vozaci> dohvatiVozaceBezTima(String uvjet) {
        if (uvjet == null || uvjet.isEmpty()) {
            // Ako je uvjet prazan, vrati sve vozače koji nemaju dodijeljen tim
            return session.createQuery("SELECT v FROM Vozaci v WHERE v.tim IS NULL", Vozaci.class).getResultList();
        } else {
            // Inače, vrati vozače koji nemaju dodijeljen tim i koji zadovoljavaju uvjet pretraživanja
            return session.createQuery("SELECT v FROM Vozaci v WHERE v.tim IS NULL AND (upper(v.ime) LIKE :uvjet OR upper(v.prezime) LIKE :uvjet)", Vozaci.class)
                    .setParameter("uvjet", "%" + uvjet.toUpperCase() + "%")
                    .getResultList();
        }
    }

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

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        if (entitet.getId() != null) {
            // Ako je postavljen identifikator, mijenja se postojeći vozač
            kontrolaUnos(); // Provjeri kontrole kao za unos novog vozača
        } else {
            // Inače, dodaje se novi vozač
            kontrolaPromjena(); // Provjeri kontrole kao za promjenu postojećeg vozača
        }
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if (!entitet.getPrvenstva().isEmpty()) {
            throw new EdunovaException("Vozač sudjeluje u nekom prvenstvu i ne može biti obrisan!");
        }

        Timovi tim = entitet.getTim();
        if (tim != null) {
            throw new EdunovaException("Vozač je povezan s timom i ne može biti obrisan!\n[" + tim.getIme_tima() + "]");
        }
        // Provjeri povezanost vozača s timom i ukloni vozača iz tima prije brisanja
        // ukloniIzTima(entitet);
    }

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

    private void kontrolaPostojanjaTima() throws EdunovaException {
        Timovi tim = entitet.getTim();
        if (tim == null) {
            throw new EdunovaException("Vozač mora biti dodijeljen postojećem timu!");
        }
    }

    private void kontrolaPostojanjaVozaca() throws EdunovaException {
        Vozaci vozac = entitet;
        Timovi tim = entitet.getTim();
        if (tim != null && tim.getVozaci().contains(vozac)) {
            throw new EdunovaException("Vozač već pripada tom timu!");
        }
    }

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

    private void kontrolaGodina() throws EdunovaException {
        var dr = entitet.getDatum_rodenja();
        if (dr == null) {
            throw new EdunovaException("Datum rođenja mora biti definiran!");
        }

        // Provjerite ispravnost formata datuma
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
            String dt = dr.format(formatter); // Pretvaranje datuma u oblik teksta
            LocalDate.parse(dt, formatter);
        } catch (DateTimeParseException ex) {
            throw new EdunovaException("Neispravan format datuma. Unijeti datum u formatu dd.MM.yyyy.");
        }

        // Trenutni datum
        LocalDate danas = LocalDate.now();

        // Računanje razlike u godinama između datuma rođenja i danas
        long godine = ChronoUnit.YEARS.between(dr, danas);

        // Provjera uvjeta
        if (godine < 18 || godine > 60) {
            throw new EdunovaException("Vozač ne može biti mlađi od 18 godina ili stariji od 60 godina!");
        }
    }

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
    }

    public boolean provjeriVozaca(Vozaci vozac) throws EdunovaException {
        // Provjeri je li vozač u nekom prvenstvu
        if (!vozac.getPrvenstva().isEmpty()) {
            throw new EdunovaException("Vozač sudjeluje u nekom prvenstvu.");
        }

        // Vozač nije u timu niti u prvenstvu, vraćamo true
        return true;
    }

    public void ukloniIzPrvenstva(Vozaci vozac) throws EdunovaException {
        // Ukloni vozača iz svih prvenstava u kojima sudjeluje
        if (!vozac.getPrvenstva().isEmpty()) {
            for (Prvenstva prvenstvo : vozac.getPrvenstva()) {
                prvenstvo.setVozac(null);
            }
            vozac.getPrvenstva().clear(); // Očisti listu prvenstava
        } else {
            throw new EdunovaException("Vozač nema osvojenih prvenstava!");
        }
    }
}
