/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.util;

import com.github.javafaker.Faker;
import formula1.model.Sezone;
import formula1.model.Staze;
import formula1.model.Timovi;
import formula1.model.Utrke;
import formula1.model.Vozaci;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Kesimator
 */
public class PocetniInsert {

    private static final int BROJ_VOZACA = 1000;
    private static final int BROJ_TIMOVA = 70;
    private static final int BROJ_SEZONA = 74;
    private static final int BROJ_STAZA = 80;
    private static final int BROJ_UTRKA = 1500;

    private Faker faker;
    private Session session;
    private List<Vozaci> vozaci;
    private List<Timovi> timovi;
    private List<Sezone> sezone;
    private List<Staze> staze;
    private List<Utrke> utrke;

    public PocetniInsert() {

        faker = new Faker();
        session = HibernateUtil.getSession();
        vozaci = new ArrayList<>();
        timovi = new ArrayList<>();
        sezone = new ArrayList<>();
        staze = new ArrayList<>();
        utrke = new ArrayList<>();

        session.getTransaction().begin();
        kreirajVozace();
        kreirajTimove();
        kreirajStaze();
        kreirajSezone();
        // kreirajUtrke();

        session.getTransaction().commit();

    }

    private void kreirajVozace() {
        Vozaci v;
        for (int i = 0; i < BROJ_VOZACA; i++) {
            v = new Vozaci();
            v.setIme(faker.dune().character());
            v.setPrezime(faker.name().lastName());
            v.setDatum_rodenja(faker.date().birthday(18, 60));
            v.setNacionalnost(faker.nation().nationality());
            vozaci.add(v);
            session.persist(v);
        }
    }

    private void kreirajTimove() {
        Timovi t;
        // Koristimo set za spremanje imena kako bi se automatski eliminirali duplikati
        Set<String> imenaTimova = new HashSet<>();
        for (int i = 0; i < BROJ_TIMOVA; i++) {
            t = new Timovi();

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

    private void kreirajStaze() {
        Staze s;
        for (int i = 0; i < BROJ_STAZA; i++) {
            s = new Staze();
            s.setIme_staze(faker.rickAndMorty().quote());
            s.setDuzina_staze(faker.number().numberBetween(3100, 7500));
            s.setLokacija(faker.country().name());

            int sati = faker.number().numberBetween(0, 0);
            int minute = faker.number().numberBetween(1, 1);
            int sekunde = faker.number().numberBetween(5, 45);
            int milisekunde = faker.number().numberBetween(20, 990);
            LocalTime rekordStaze = LocalTime.of(sati, minute, sekunde, milisekunde * 1_000_000);
            s.setRekord_staze(rekordStaze);

            s.setGodina_postavljanja(faker.date().birthday(2, 52));

            session.persist(s);
            staze.add(s);
        }
    }

    private void kreirajSezone() {
        Sezone s;
        Calendar kalendar = Calendar.getInstance();
        for (int i = 0; i < BROJ_SEZONA; i++) {
            s = new Sezone();
            kalendar.add(Calendar.YEAR, -1);
            Date godinaSezone = kalendar.getTime();
            s.setGodina(godinaSezone);
            s.setBroj_utrka(faker.number().numberBetween(7, 23));

            List<Vozaci> shuffledVozaci = new ArrayList<>(vozaci);
            Collections.shuffle(shuffledVozaci);
            List<Vozaci> v = shuffledVozaci.subList(0, faker.number().numberBetween(15, 50));
            s.setVozac(v);

            List<Timovi> shuffledTimovi = new ArrayList<>(timovi);
            Collections.shuffle(shuffledTimovi);
            List<Timovi> t = shuffledTimovi.subList(0, faker.number().numberBetween(5, 13));
            s.setTimovi(t);


            session.persist(s);
            sezone.add(s);
        }
    }

    private Date generirajDatumIVrijemeUtrke(Date godinaSezone1, int godinaSezone) {
        Calendar calendar = Calendar.getInstance();
        // Postavi kalendar na prvi dan godine
        calendar.set(godinaSezone, Calendar.JANUARY, 1);
        // Pronađi prvi nedjeljni datum u godini
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        // Dodaj broj tjedana koji je prošao od 1950. godine
        int brojTjedanaOdPocetka = 0;
        for (int godina = 1950; godina < godinaSezone; godina++) {
            brojTjedanaOdPocetka += calendar.getActualMaximum(Calendar.WEEK_OF_YEAR);
        }
        int redniBrojUtrke = 0;
        // Dodaj broj tjedana za trenutnu sezonu
        calendar.add(Calendar.WEEK_OF_YEAR, brojTjedanaOdPocetka + redniBrojUtrke - 1); // -1 jer se brojanje tjedana počinje od 1
        // Provjeri da li je datum između ožujka i listopada
        while (calendar.get(Calendar.MONTH) < Calendar.MARCH || calendar.get(Calendar.MONTH) > Calendar.OCTOBER) {
            // Ako nije, dodaj jedan tjedan
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
        }
        // Generiraj slučajno vrijeme između 14:00 i 17:00 sati
        Random random = new Random();
        int sat = random.nextInt(4) + 14; // Slučajni sat između 14 i 17
        // Postavi vrijeme u kalendar
        calendar.set(Calendar.HOUR_OF_DAY, sat);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        // Vrati datum kao rezultat
        return calendar.getTime();
    }

//    private Sezone findSeasonByYear(int year) {
//        for (Sezone season : sezone) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(season.getGodina());
//            int seasonYear = calendar.get(Calendar.YEAR);
//            if (seasonYear == year) {
//                return season;
//            }
//        }
//        return null; // Ako ne pronađemo sezonu za određenu godinu, vraćamo null
//    }
    
    
//    private void kreirajUtrke() {
//        Utrke u;
// 
//
//                    // Generiraj datum i vrijeme utrke
//                    Date godinaSezone = s.getGodina();
//                    Date datumIVrijemeUtrke = generirajDatumIVrijemeUtrke(godinaSezone, i);
//                    u.setDatum_i_vrijeme(datumIVrijemeUtrke);
//
//                    session.persist(u);
//                    utrke.add(u);
//
//            }
//        }
//
//    }
}
