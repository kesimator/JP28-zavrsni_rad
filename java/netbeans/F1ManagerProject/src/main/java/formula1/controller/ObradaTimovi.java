/*
 * Ova klasa sadrži metode za obradu podataka entiteta Timovi.
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
 * Ova klasa sadrži metode za obradu podataka entiteta Timovi. Nasljeđuje
 * apstraktnu klasu Obrada.
 *
 * @param <Timovi> tip podataka entiteta Timovi
 * @see formula1.controller.Obrada
 */
public class ObradaTimovi extends Obrada<Timovi> {

    /**
     * Konstruktor bez parametara.
     */
    public ObradaTimovi() {
        super();
    }

    /**
     * Konstruktor s parametrom.
     *
     * @param t objekt tipa Timovi
     */
    public ObradaTimovi(Timovi t) {
        super(t);
    }

    /**
     * Čita sve zapise entiteta Timovi iz baze podataka. Za svaki tim dohvaća i
     * popunjava listu vozača.
     *
     * @return lista svih entiteta Timovi
     */
    @Override
    public List<Timovi> read() {
        List<Timovi> lista = session.createQuery("from Timovi order by ime_tima", Timovi.class).list();
        for (Timovi tim : lista) {
            List<Vozaci> listaVozaca = session.createQuery(
                    "select v from Vozaci v where v.tim = :tim order by v.ime, v.prezime",
                    Vozaci.class)
                    .setParameter("tim", tim)
                    .list();
            tim.setVozaci(listaVozaca);
        }
        return lista;
    }

    /**
     * Provjerava valjanost podataka prilikom unosa novog entiteta Timovi.
     *
     * @throws EdunovaException ako su podaci nevaljani
     */
    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaImeTima();
        kontrolaGodinaUnosa();
        kontrolaDrzavaSjedista();
        kontrolaJedinstvenostiTimova();

        if (entitet.getId() == null) {
            kontrolaPostojanjaTimova();
        }
    }

    /**
     * Provjerava valjanost podataka prilikom promjene entiteta Timovi.
     *
     * @throws EdunovaException ako su podaci nevaljani
     */
    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        if (entitet.getId() != null) {
            kontrolaUnos();
        } else {
            kontrolaPromjena();
            kontrolaPostojanjaTimova();
            kontrolaJedinstvenostiTimova();
        }

    }

    /**
     * Provjerava valjanost podataka prilikom brisanja entiteta Timovi.
     *
     * @throws EdunovaException ako su podaci nevaljani
     */
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

    // Metoda koja provjerava valjanost unosa imena tima
    private void kontrolaImeTima() throws EdunovaException {
        var i = entitet.getIme_tima();
        if (i == null) {
            throw new EdunovaException("Ime tima mora biti definirano!");
        }
        if (i.isEmpty()) {
            throw new EdunovaException("Ime tima obavezno!");
        }
        if (i.equalsIgnoreCase("!Tomo ne zna igrati belu")) {
            entitet.setIme_tima("Tomo je majstor u beli");
        }
        if (i.length() > 30) {
            throw new EdunovaException("Ime tima ne smije biti duže od 30 znakova!");
        }
        entitet.setIme_tima(entitet.getIme_tima().toUpperCase());
    }

    // Metoda koja provjerava valjanost unosa godine osnutka
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

    // Metoda koja provjerava valjanost unosa države sjedišta
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

    // Metoda koja provjerava postojanje timova s istim imenom u bazi podataka
    private void kontrolaPostojanjaTimova() throws EdunovaException {
        List<Timovi> timovi = session.createQuery(
                "from Timovi t where t.ime_tima = :ime_tima", Timovi.class)
                .setParameter("ime_tima", entitet.getIme_tima())
                .getResultList();
        if (!timovi.isEmpty()) {
            throw new EdunovaException("Već postoji tim s istim imenom!");
        }
    }

    // Metoda koja provjerava jedinstvenost timova u bazi podataka
    private void kontrolaJedinstvenostiTimova() throws EdunovaException {
        String imeTima = entitet.getIme_tima();
        int godinaOsnutka = entitet.getGodina_osnutka();
        String drzavaSjedista = entitet.getDrzava_sjedista();
        List<Timovi> istiTimovi = session.createQuery(
                "SELECT t FROM Timovi t WHERE t.ime_tima = :imeTima "
                + "AND t.godina_osnutka = :godinaOsnutka "
                + "AND t.drzava_sjedista = :drzavaSjedista", Timovi.class)
                .setParameter("imeTima", imeTima)
                .setParameter("godinaOsnutka", godinaOsnutka)
                .setParameter("drzavaSjedista", drzavaSjedista)
                .getResultList();
        if (!istiTimovi.isEmpty()) {
            for (Timovi t : istiTimovi) {
                if (t.getId().equals(entitet.getId())) {
                    throw new EdunovaException("Već postoji tim s istim podacima!");
                }
            }
        }
    }

    // Metoda koja uklanja tim iz svih prvenstava u kojima sudjeluje
    public void ukloniIzPrvenstva(Timovi tim) throws EdunovaException {
        try {
            if (!tim.getPrvenstva().isEmpty()) {
                for (Prvenstva prvenstvo : tim.getPrvenstva()) {
                    prvenstvo.setTim(null);
                }
                tim.getPrvenstva().clear();
                session.getTransaction().begin();
                session.merge(tim);
                session.getTransaction().commit();
            } else {
                throw new EdunovaException("Tim nema osvojenih prvenstava!");
            }
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }

    // Metoda koja uklanja sve vozače iz tima
    public void ukloniSveVozaceIzTima(Timovi tim) throws EdunovaException {
        try {
            if (tim == null) {
                throw new EdunovaException("Tim nije definiran!");
            }
            List<Vozaci> vozaci = tim.getVozaci();
            for (Vozaci vozac : vozaci) {
                vozac.setTim(null);
            }
            vozaci.clear();
            session.getTransaction().begin();
            session.merge(tim);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }

    // Metoda koja uklanja vozača iz tima
    public void ukloniIzTima(Vozaci vozac) throws EdunovaException {
        if (vozac == null || vozac.getId() == null) {
            throw new EdunovaException("Vozač nije ispravno definiran!");
        }
        Timovi tim = vozac.getTim();
        if (tim == null) {
            throw new EdunovaException("Vozač nije dodijeljen timu!");
        }
        tim.getVozaci().remove(vozac);
        vozac.setTim(null);
        try {
            session.getTransaction().begin();
            session.merge(tim);
            session.merge(vozac);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }

    // Metoda koja dodaje vozača u tim
    public void dodajUTim(Vozaci vozac) throws EdunovaException {
        if (vozac == null || vozac.getId() == null) {
            throw new EdunovaException("Vozač nije ispravno definiran!");
        }
        vozac.setTim(entitet);
        entitet.getVozaci().add(vozac);
        try {
            session.getTransaction().begin();
            session.merge(entitet);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new EdunovaException("Greška prilikom ažuriranja baze podataka: " + ex.getMessage());
        }
    }

    // Metoda koja dohvaća sve timove s vozačima
    public List<Timovi> dohvatiTimoveSVozacima() {
        List<Timovi> timoviSVozacima = session.createQuery("SELECT DISTINCT v.tim FROM Vozaci v "
                + "WHERE v.tim IS NOT NULL", Timovi.class).getResultList();
        return timoviSVozacima;
    }
}
