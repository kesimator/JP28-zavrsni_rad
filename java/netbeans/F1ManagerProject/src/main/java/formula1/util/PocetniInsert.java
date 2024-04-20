package formula1.util;

import com.github.javafaker.Faker;
import formula1.model.Prvenstva;
import formula1.model.Timovi;
import formula1.model.Vozaci;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.hibernate.Session;

/**
 * Klasa za unos početnih podataka u bazu podataka aplikacije Formula 1 Manager.
 */
public class PocetniInsert {

    /**
     * Broj timova koji će biti generirani prilikom unosa početnih podataka.
     */
    private static final int BROJ_TIMOVA = 70;

    /**
     * Broj vozača koji će biti generirani prilikom unosa početnih podataka.
     */
    private static final int BROJ_VOZACA = 500;

    private Faker faker;
    private Session session;
    private List<Timovi> timovi;
    private List<Vozaci> vozaci;

    /**
     * Konstruktor klase `PocetniInsert` koji izvršava unos početnih podataka.
     */
    public PocetniInsert() {
        faker = new Faker();
        session = HibernateUtil.getSession();
        timovi = new ArrayList<>();
        vozaci = new ArrayList<>();

        session.getTransaction().begin();
        kreirajTimove();
        kreirajVozace();
        kreirajPrvenstva();
        session.getTransaction().commit();
    }

    /**
     * Metoda za kreiranje timova i spremanje u bazu podataka.
     */
    private void kreirajTimove() {
        Set<String> imenaTimova = new HashSet<>();
        for (int i = 0; i < BROJ_TIMOVA; i++) {
            Timovi t = new Timovi();

            String imeTima;
            do {
                imeTima = faker.dragonBall().character().toUpperCase();
            } while (imenaTimova.contains(imeTima));
            imenaTimova.add(imeTima);

            t.setIme_tima(imeTima);
            t.setDrzava_sjedista(faker.country().capital().toUpperCase());
            t.setGodina_osnutka(faker.number().numberBetween(1904, 2020));

            session.persist(t);
            timovi.add(t);
        }
    }

    /**
     * Metoda za kreiranje vozača i spremanje u bazu podataka.
     */
    private void kreirajVozace() {
        List<Timovi> sviTimovi = session.createQuery("FROM Timovi", Timovi.class).getResultList();
        int brojTimova = sviTimovi.size();

        Set<String> prvo = new HashSet<>();

        for (int i = 0; i < BROJ_VOZACA; i++) {
            Vozaci v = new Vozaci();

            String ime;
            do {
                ime = faker.name().firstName().toUpperCase();
            } while (!prvo.add(ime));

            v.setIme(ime);
            v.setPrezime(faker.name().lastName().toUpperCase());

            LocalDate trenutno = LocalDate.now();
            LocalDate min = trenutno.minusYears(60);
            LocalDate max = trenutno.minusYears(18);

            long mini = min.toEpochDay();
            long maxi = max.toEpochDay();

            long randomDateEpochDay = ThreadLocalRandom.current().nextLong(mini, maxi + 1);
            LocalDate nasumicno = LocalDate.ofEpochDay(randomDateEpochDay);

            v.setDatum_rodenja(nasumicno);
            v.setNacionalnost(faker.nation().nationality().toUpperCase());

            Timovi randomTim = sviTimovi.get(faker.random().nextInt(brojTimova));
            v.setTim(randomTim);

            vozaci.add(v);
            session.persist(v);
        }
    }

    /**
     * Metoda za kreiranje prvenstava i spremanje u bazu podataka.
     */
    private void kreirajPrvenstva() {
        for (int i = 1950; i <= 2023; i++) {
            Prvenstva p = new Prvenstva();

            p.setSezona(i);
            p.setVozac(vozaci.get(faker.random().nextInt(vozaci.size())));
            p.setTim(timovi.get(faker.random().nextInt(timovi.size())));

            session.persist(p);
        }
    }
}
