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

    private static final int BROJ_VOZACA = 100;
    private static final int BROJ_TIMOVA = 20;
    private static final int BROJ_SEZONA = 74;
    private static final int BROJ_STAZA = 300;
    private static final int BROJ_UTRKA = 2000;

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
        kreirajSezone();

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
            List<Vozaci> v = shuffledVozaci.subList(0, faker.number().numberBetween(2, 6));
            for (int j = 0; j < 7; j++) {
                Vozaci vozac = shuffledVozaci.get(j);
                if (j < 2) {
                    vozac.setGlavni(true);
                } else {
                    vozac.setGlavni(false);
                }
                v.add(vozac);
            }
            t.setVozaci(v);

            session.persist(t);
            timovi.add(t);
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

            session.persist(s);
        }
    }

}
