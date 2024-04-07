/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package formula1;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import formula1.controller.ObradaOperater;
import formula1.controller.ObradaPrvenstva;
import formula1.controller.ObradaTimovi;
import formula1.controller.ObradaVozaci;
import formula1.model.Operater;
import formula1.model.Prvenstva;
import formula1.model.Timovi;
import formula1.model.Vozaci;
import formula1.util.EdunovaException;
import formula1.util.HibernateUtil;
import formula1.util.PocetniInsert;
import formula1.view.Autorizacija;
import formula1.view.SplashScreen;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kesimator
 */
public class Start {

    public static void main(String[] args) {

        // HibernateUtil.getSession();
        // new PocetniInsert();
        // System.out.println(new Gson().toJson(new ObradaTimovi().read()));
         new SplashScreen().setVisible(true);

        
        
        
        
//        lozinka();

//        ObradaOperater oo = new ObradaOperater();
//
//        Operater o = oo.autoriziraj("oper@edunova.hr", "formula1");
//
//        System.out.println(o == null ? "Neispravno" : o.getIme());
    }

    private void lozinka() {    // Ako želim ponovno pustiti u bazu, samo dodam static i pozovem lozinka gore
        // factory pattern
        Argon2 argon2 = Argon2Factory.create();

        String hash = argon2.hash(10, 65536, 1, "formula1".toCharArray());

        ObradaOperater oo = new ObradaOperater();
        Operater o = new Operater();
        o.setIme("Marijan");
        o.setPrezime("Kešinović");
        o.setEmail("oper@edunova.hr");
        o.setUloga("Operater");
        o.setLozinka(hash);

        oo.setEntitet(o);

        try {
            oo.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Testiranje() {

//        ObradaTimovi ot = new ObradaTimovi();
//        

//        
//        Timovi t = new Timovi();
//        t.setIme_tima("Prvi preko kontrola");
//        t.setGodina_osnutka(1990);
//        t.setDrzava_sjedista("EDUNOVA");
//        
//        
//        ot.setEntitet(t);
//        
//        try {
//            ot.create();
//        } catch (EdunovaException ex) {
//            System.out.println(ex.getPoruka());
//        }
//        List<Timovi> timovi = new ObradaTimovi().read();
//        
//        Timovi zadnjiTim = timovi.get(timovi.size()-1);
//
//        ObradaTimovi ot = new ObradaTimovi(zadnjiTim);
//        
//        try {
//            ot.delete();
//        } catch (EdunovaException ex) {
//            ex.printStackTrace();
//        }
//        ObradaVozaci ov = new ObradaVozaci();
//        
//        LocalDate datum = LocalDate.of(1995,2,19);
//                
//        Vozaci v = new Vozaci();
//        v.setIme("Mika");
//        v.setPrezime("Hakkinen");
//        v.setNacionalnost("Finac");
//        v.setDatum_rodenja(datum);
//        
//        
//        ov.setEntitet(v);
//        
//        try {
//            ov.create();
//        } catch (EdunovaException ex) {
//            ex.printStackTrace();
//        }
//        List<Vozaci> vozaci = new ObradaVozaci().read();
//        
//        Vozaci zadnjiVozac = vozaci.get(vozaci.size()-1);
//
//        ObradaVozaci ov = new ObradaVozaci(zadnjiVozac);
//        
//        try {
//            ov.delete();
//        } catch (EdunovaException ex) {
//            ex.printStackTrace();
//        }
//                ObradaPrvenstva op = new ObradaPrvenstva();
//        
//        Date datum = new Date(50,06,10);
//        
//        Prvenstva p = new Prvenstva();
//        p.setSezona(datum);
//        
//        op.setEntitet(p);
//        
//        try {
//            op.create();
//        } catch (EdunovaException ex) {
//            ex.printStackTrace();
//        }
//                List<Prvenstva> prvenstva = new ObradaPrvenstva().read();
//        
//        Prvenstva zadnji = prvenstva.get(prvenstva.size()-1);
//        
//        ObradaPrvenstva op = new ObradaPrvenstva(zadnji);
//        
//        try {
//            op.delete();
//        } catch (EdunovaException ex) {
//            ex.printStackTrace();
//        }
    }
    
    private void Faker() {
                
        
        Faker faker = new Faker();
        Set<String> uniqueFirstNames = new HashSet<>();
        Set<String> uniqueLastNames = new HashSet<>();

        // Generiraj 1000 lažnih imena
        for (int i = 0; i < 1000; i++) {
            String firstName = faker.ancient().titan();
            String lastName = faker.company().name();
            uniqueFirstNames.add(firstName);
            uniqueLastNames.add(lastName);
        }

        System.out.println("Broj jedinstvenih imena: " + uniqueFirstNames.size());
        System.out.println("Broj jedinstvenih prezimena: " + uniqueLastNames.size());
        
         System.out.println("\nNekoliko primjera imena:");
        int count = 0;
        for (String firstName : uniqueFirstNames) {
            System.out.println(firstName);
            count++;
            if (count == 100) { // ispiši samo prvih 100 imena
                break;
            }
        }
    }
}
