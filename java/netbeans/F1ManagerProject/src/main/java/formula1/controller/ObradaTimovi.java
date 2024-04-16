/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class ObradaTimovi extends Obrada<Timovi> {

    public ObradaTimovi() {
        super();
    }

    public ObradaTimovi(Timovi t) {
        super(t);
    }

    @Override
    public List<Timovi> read() {

        // Dohvaćanje liste timova sortirane po imenu tima
        List<Timovi> listaTimova = session.createQuery("from Timovi order by ime_tima", Timovi.class).list();

        // Za svaki tim dohvati i popuni listu vozača
        for (Timovi tim : listaTimova) {
            // Dohvaćanje liste vozača za trenutni tim, sortirane po imenu i prezimenu
            List<Vozaci> listaVozaca = session.createQuery(
                    "select v from Vozaci v where v.tim = :tim order by v.ime, v.prezime",
                    Vozaci.class)
                    .setParameter("tim", tim)
                    .list();
            // Postavljanje sortirane liste vozača u atribut tima
            tim.setVozaci(listaVozaca);
        }

        return listaTimova;
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaImeTima();
        kontrolaGodinaUnosa();
        kontrolaDrzavaSjedista();
        kontrolaJedinstvenostiTimova();

        if (entitet.getId() == null) { // Ako je id entiteta null, znači da se radi o unosu novog tima
            kontrolaPostojanjaTimova();
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
            kontrolaPostojanjaTimova();
        kontrolaJedinstvenostiTimova();
        }
        
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if (!entitet.getPrvenstva().isEmpty()) {
            throw new EdunovaException("Tim sudjeluje u nekom prvenstvu i ne može biti obrisan!");
        }
        if (!entitet.getVozaci().isEmpty()) {

            StringBuilder sb = new StringBuilder();
            sb.append("Tim se ne može obrisati jer ima vozače!\n");

            for (Vozaci v : entitet.getVozaci()) {
                sb.append(v.getIme()).append(" ").append(v.getPrezime());
                sb.append(",\n");
            }
            sb.delete(sb.length() - 2, sb.length());

            throw new EdunovaException(sb.toString());
        }
    }

    private void kontrolaImeTima() throws EdunovaException {
        var i = entitet.getIme_tima();
        if (i == null) {
            throw new EdunovaException("Ime tima mora biti definirano!");
        }
        if (i.isEmpty()) {
            throw new EdunovaException("Ime tima obavezno!");
        }
        if (i.length() > 30) {
            throw new EdunovaException("Ime tima ne smije biti duže od 30 znakova!");
        }
        entitet.setIme_tima(entitet.getIme_tima().toUpperCase());
    }

    private void kontrolaGodinaUnosa() throws EdunovaException {
        var g = entitet.getGodina_osnutka();
        if (g == null) {
            throw new EdunovaException("Godina osnutka mora biti definirana!\n"
                    + "(broj između 1904 i 2020)");
        }
        if (g < 1904 || g > 2020) {
            throw new EdunovaException("Godina osnutka mora biti unutar raspona od 1904. godine do 2020. godine!");
        }
    }

    private void kontrolaDrzavaSjedista() throws EdunovaException {
        var d = entitet.getDrzava_sjedista();
        if (d == null) {
            throw new EdunovaException("Država sjedišta mora biti definirano!");
        }
        if (d.isEmpty()) {
            throw new EdunovaException("Država sjedišta obavezno!");
        }
        if (!d.matches("[a-zA-ZčćžšđČĆŽŠĐ '-]+")) {
            throw new EdunovaException("Država sjedišta ne smije sadržavati brojeve ni posebne znakove!");
        }
        if (d.length() > 30) {
            throw new EdunovaException("Država sjedišta ne smije biti duže od 30 znakova!");
        }
        entitet.setDrzava_sjedista(entitet.getDrzava_sjedista().toUpperCase());
    }

    private void kontrolaPostojanjaTimova() throws EdunovaException {
        List<Timovi> timovi = session.createQuery(
                "from Timovi t where t.ime_tima = :ime_tima", Timovi.class)
                .setParameter("ime_tima", entitet.getIme_tima())
                .getResultList();
        if (!timovi.isEmpty()) {
            throw new EdunovaException("Već postoji tim s istim imenom!");
        }
    }

    private void kontrolaJedinstvenostiTimova() throws EdunovaException {
        String imeTima = entitet.getIme_tima();
        int godinaOsnutka = entitet.getGodina_osnutka();
        String drzavaSjedista = entitet.getDrzava_sjedista();

        // Provjera postoji li već tim s istim osobnim podacima
        List<Timovi> istiTimovi = session.createQuery(
                "SELECT t FROM Timovi t WHERE t.ime_tima = :imeTima "
                + "AND t.godina_osnutka = :godinaOsnutka "
                + "AND t.drzava_sjedista = :drzavaSjedista", Timovi.class)
                .setParameter("imeTima", imeTima)
                .setParameter("godinaOsnutka", godinaOsnutka)
                .setParameter("drzavaSjedista", drzavaSjedista)
                .getResultList();

        /// Ako postoji tim s istim osobnim podacima, provjeri je li to trenutni tim
        if (!istiTimovi.isEmpty()) {
            for (Timovi t : istiTimovi) {
                // Ako id trenutnog tima nije jednak id-u tima iz baze, tada je to drugi tim s istim podacima
                if (t.getId().equals(entitet.getId())) {
                    throw new EdunovaException("Već postoji tim s istim podacima!");
                }
            }
        }
    }

    public void ukloniIzPrvenstva(Timovi tim) throws EdunovaException {
        // Ukloni vozača iz svih prvenstava koja sudjeluje
        if (!tim.getPrvenstva().isEmpty()) {
            for (Prvenstva prvenstvo : tim.getPrvenstva()) {
                prvenstvo.setTim(null);
            }
            tim.getPrvenstva().clear(); // Očisti listu prvenstava
        } else {
            throw new EdunovaException("Tim nema osvojenih prvenstava!");
        }
    }

    public void ukloniSveVozaceIzTima(Timovi tim) throws EdunovaException {
        // Provjeri je li tim null
        if (tim == null) {
            throw new EdunovaException("Tim nije definiran!");
        }

        // Dohvati sve vozače iz tima
        List<Vozaci> vozaci = tim.getVozaci();

        // Iteriraj kroz sve vozače i ukloni ih iz tima
        for (Vozaci vozac : vozaci) {
            // Postavi tim vozača na null kako bi ga uklonili iz tima
            vozac.setTim(null);
        }

        vozaci.clear();
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

    public void dodajUTim(Vozaci vozac) throws EdunovaException {
        // Provjeri je li vozač ispravno definiran
        if (vozac == null || vozac.getId() == null) {
            throw new EdunovaException("Vozač nije ispravno definiran!");
        }

        // Postavi tim vozaču
        vozac.setTim(entitet);

        // Dodaj vozača u listu vozača tima
        entitet.getVozaci().add(vozac);
    }
}
