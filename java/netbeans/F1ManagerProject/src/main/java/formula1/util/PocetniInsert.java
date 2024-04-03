/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.util;

import com.github.javafaker.Faker;
import formula1.model.Prvenstva;
import formula1.model.Timovi;
import formula1.model.Vozaci;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Kesimator
 */
public class PocetniInsert {

    private static final int BROJ_TIMOVA = 70;
    private static final int BROJ_VOZACA = 500;

    private Faker faker;
    private Session session;
    private List<Timovi> timovi;
    private List<Vozaci> vozaci;

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

    private void kreirajTimove() {
        // Koristimo set za spremanje imena kako bi se automatski eliminirali duplikati
        Set<String> imenaTimova = new HashSet<>();
        for (int i = 0; i < BROJ_TIMOVA; i++) {
            Timovi t = new Timovi();

            String imeTima;
            do {
                imeTima = faker.dragonBall().character().toUpperCase(); // Generiranje nasumičnog imena tima
            } while (imenaTimova.contains(imeTima)); // Provjera je li ime već korišteno
            imenaTimova.add(imeTima); // Dodavanje imena u set kako bi se spriječilo ponavljanje

            t.setIme_tima(imeTima);
            t.setDrzava_sjedista(faker.country().capital());
            t.setGodina_osnutka(faker.date().birthday(20, 120));

            session.persist(t);
            timovi.add(t);
        }
    }

    private void kreirajVozace() {
        List<Timovi> sviTimovi = session.createQuery("FROM Timovi", Timovi.class).getResultList(); // Dohvaćanje svih timova iz baze
        int brojTimova = sviTimovi.size();
        for (int i = 0; i < BROJ_VOZACA; i++) {
            Vozaci v = new Vozaci();
            v.setIme(faker.dune().character());
            v.setPrezime(faker.name().lastName());
            v.setDatum_rodenja(faker.date().birthday(18, 60));
            v.setNacionalnost(faker.nation().nationality());

            Timovi randomTim = sviTimovi.get(faker.random().nextInt(brojTimova));
            v.setTim(randomTim);

            vozaci.add(v);
            session.persist(v);
        }
    }

    private void kreirajPrvenstva() {
        Calendar kalendar = Calendar.getInstance();
        kalendar.add(Calendar.YEAR, -74);

        for (int i = 0; i < 74; i++) {
            Prvenstva p = new Prvenstva();

            p.setSezona(kalendar.getTime());
            p.setVozac(vozaci.get(faker.random().nextInt(vozaci.size())));
            p.setTim(timovi.get(faker.random().nextInt(timovi.size())));

            session.persist(p);

            kalendar.add(Calendar.YEAR, 1); // Dodaj jednu godinu na kalendar za sljedeće prvenstvo
        }
    }

}
