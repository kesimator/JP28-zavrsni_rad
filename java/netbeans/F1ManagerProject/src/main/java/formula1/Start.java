/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package formula1;

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
import java.util.Date;
import java.util.List;
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

        


        


    }
    
    private void lozinka() {
        // factory pattern
//        Argon2 argon2 = Argon2Factory.create();
//        
//        String hash = argon2.hash(10, 65536, 1, "lozinka".toCharArray());
//        
//        ObradaOperater oo = new ObradaOperater();
//        Operater o = new Operater();
//        o.setIme("Marijan");
//        o.setPrezime("Kešinović");
//        o.setEmail("oper@edunova.hr");
//        o.setUloga("Operater");
//        o.setLozinka(hash);
//        
//        oo.setEntitet(o);
//        
//        try {
//            oo.create();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    private void Testiranje() {
        
        //        ObradaTimovi ot = new ObradaTimovi();
//        
//        
//        Date datum = new Date(47,07,15);
//        
//        Timovi t = new Timovi();
//        t.setIme_tima("Prvi preko kontrola");
//        t.setGodina_osnutka(datum);
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
//        Date datum = new Date(95,05,15);
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
}

