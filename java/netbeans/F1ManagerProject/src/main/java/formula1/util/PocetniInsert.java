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
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Kesimator
 */
public class PocetniInsert {

    private static final int BROJ_VOZACA = 20;
    private static final int BROJ_TIMOVA = 10;
    private static final int BROJ_SEZONA = 70;
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

        session.getTransaction().commit();

    }

    private void kreirajVozace() {
        Vozaci v;
        for (int i = 0; i < BROJ_VOZACA; i++) {
            v = new Vozaci();
            v.setIme(faker.name().firstName());
            v.setPrezime(faker.name().lastName());
            v.setDatum_rodenja(faker.date().birthday(18, 40));
            v.setNacionalnost(faker.nation().nationality());
            v.setBroj_pobjeda(faker.number().numberBetween(0, 300));
            v.setBroj_pole_positiona(faker.number().numberBetween(0, 500));
            session.persist(v);
            vozaci.add(v);
        }
    }

    private void kreirajTimove() {
        Timovi t;
        for(int i=0;i<BROJ_TIMOVA;i++) {
            t=new Timovi();
            t.setIme_tima(faker.team().name());
            t.setDrzava_sjedista(faker.country().capital());
            t.setGodina_osnutka(faker.date().birthday(20, 120));
            t.setVozac(vozaci.get(faker.number().numberBetween(2, 2)));
            session.persist(t);
            timovi.add(t);
        }
    }

}
