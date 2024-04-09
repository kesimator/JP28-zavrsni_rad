/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.util;

import com.github.javafaker.Faker;
import formula1.model.Prvenstva;
import formula1.model.Timovi;
import formula1.model.Vozaci;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
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
            t.setDrzava_sjedista(faker.country().capital().toUpperCase());
            t.setGodina_osnutka(faker.number().numberBetween(1904, 2020));

            session.persist(t);
            timovi.add(t);
        }
    }

    private void kreirajVozace() {
        List<Timovi> sviTimovi = session.createQuery("FROM Timovi", Timovi.class).getResultList(); // Dohvaćanje svih timova iz baze
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
            LocalDate min = trenutno.minusYears(60); // Maksimalna dob je 60 godina
            LocalDate max = trenutno.minusYears(18); // Minimalna dob je 18 godina

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
