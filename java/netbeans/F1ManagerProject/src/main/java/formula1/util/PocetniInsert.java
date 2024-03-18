/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.util;

import com.github.javafaker.Faker;
import formula1.model.Rezultati_utrke;
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
import java.util.List;
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
    private List<Rezultati_utrke> rezultati_utrke;
    
    public PocetniInsert() {
        
        faker = new Faker();
        session = HibernateUtil.getSession();
        vozaci = new ArrayList<>();
        timovi = new ArrayList<>();
        sezone = new ArrayList<>();
        staze = new ArrayList<>();
        utrke = new ArrayList<>();
        rezultati_utrke = new ArrayList<>();
        
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
            v.setBroj_pobjeda(faker.number().numberBetween(0, 300));
            v.setBroj_pole_positiona(faker.number().numberBetween(0, 500));
            vozaci.add(v);
            session.persist(v);
        }
    }
    
    private void kreirajTimove() {
        Timovi t;
        for (int i = 0; i < BROJ_TIMOVA; i++) {
            t = new Timovi();
            t.setIme_tima(faker.dragonBall().character().toUpperCase());
            t.setDrzava_sjedista(faker.country().capital());
            t.setGodina_osnutka(faker.date().birthday(20, 120));
            // t.setVozac(vozaci.get(faker.number().numberBetween(0, BROJ_VOZACA-1)));
            // t.setMax_vozaca(faker.number().numberBetween(3, 7));

            //List<Vozaci> v = new ArrayList<>();
            List<Vozaci> shuffledVozaci = new ArrayList<>(vozaci);
            Collections.shuffle(shuffledVozaci);
            List<Vozaci> v = shuffledVozaci.subList(0, faker.number().numberBetween(3, 7));
            for (int j = 0; j < 7; j++) {
                Vozaci vozac = shuffledVozaci.get(j);
                if (j < 2) {
                    vozac.setGlavni(true);
                } else {
                    vozac.setGlavni(false);
                }
                //v.add(vozac);
            }
            t.setVozaci(v);
            
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
            //String rekordStaze = String.format("d%:%02d.%03d", minute, sekunde, milisekunde);
            //LocalTime rekordStaze = LocalTime.of(sati, minute, sekunde, milisekunde * 1_000_000);
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

//            List<Vozaci> v = new ArrayList<>();
//            for (int j = 0; j < BROJ_VOZACA; j++) {
//                v.add(vozaci.get(faker.random().nextInt(15, BROJ_VOZACA - 1)));
//            }
//            int ukupanBrojVozaca = 0; // Inicijalizacija ukupnog broja vozača
////            // Izračunaj maksimalni broj vozača za trenutnu sezonu
////            int maxBrojVozaca = Math.min(BROJ_VOZACA - ukupanBrojVozaca, 50); // Maksimalno 50 vozača ili manje ako je 
////            // preostalo manje od 50 vozača
////            int brojVozaca = faker.number().numberBetween(15, maxBrojVozaca);
////            ukupanBrojVozaca += brojVozaca; // Dodaj broj vozača za trenutnu sezonu u ukupan broj vozača
////
////            // Provjeri je li ukupan broj vozača premašio limit
////            if (ukupanBrojVozaca > BROJ_VOZACA) {
////                brojVozaca = Math.max(BROJ_VOZACA - (ukupanBrojVozaca - brojVozaca), 15); // Ako je premašen limit, postavi broj vozača na preostali broj vozača do limita ili 15, ovisno o tome koji je manji
////                ukupanBrojVozaca = BROJ_VOZACA; // Postavi ukupan broj vozača na maksimalni limit
////            }
//
//            int brojVozaca = faker.number().numberBetween(15, 50); // Generiramo broj vozača za trenutnu sezonu
//            // Ako dodavanje ovih vozača premašuje ukupan broj vozača, ograničavamo broj vozača
//            if (ukupanBrojVozaca + brojVozaca > BROJ_VOZACA) {
//                brojVozaca = BROJ_VOZACA - ukupanBrojVozaca;
//            }
            List<Vozaci> shuffledVozaci = new ArrayList<>(vozaci);
            Collections.shuffle(shuffledVozaci);
            List<Vozaci> v = shuffledVozaci.subList(0, faker.number().numberBetween(15, 50));
            s.setVozac(v);

//            List<Timovi> t = new ArrayList<>();
//            for (int k = 0; k < BROJ_TIMOVA; k++) {
//                t.add(timovi.get(faker.random().nextInt(3, BROJ_TIMOVA - 1)));
//            }
            List<Timovi> shuffledTimovi = new ArrayList<>(timovi);
            Collections.shuffle(shuffledTimovi);
            List<Timovi> t = shuffledTimovi.subList(0, faker.number().numberBetween(3, BROJ_TIMOVA - 1));
            s.setTimovi(t);
            
            List<Staze> shuffledStaze = new ArrayList<>(staze);
            Collections.shuffle(shuffledStaze);
            List<Staze> s1 = shuffledStaze.subList(0, faker.number().numberBetween(7, 22));
            s.setStaze(s1);

//            ukupanBrojVozaca += brojVozaca; // Dodajemo broj vozača trenutnoj sezonu na ukupan broj vozača
            session.persist(s);
            sezone.add(s);
        }
    }
    
//    private void kreirajUtrke() {
//        Utrke u;
//        for (int i = 0; i < BROJ_UTRKA; i++) {
//            u = new Utrke();
//            
//            List<Staze> shuffledStaze = new ArrayList<>(staze);
//            Collections.shuffle(shuffledStaze);
//            List<Staze> st = shuffledStaze.subList(0, faker.number().numberBetween(7, 22));
//            u.setStaza(st);
//            
//            List<Sezone> shuffledSezone = new ArrayList<>(sezone);
//            Collections.shuffle(shuffledSezone);
//            List<Sezone> se = shuffledSezone.subList(0, faker.number().numberBetween(1, BROJ_SEZONA));
//            u.setSezona(se);
//            
//            session.persist(u);
//            utrke.add(u);
//        }
//    }
}
