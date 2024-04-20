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
 * Glavna klasa Formula1 aplikacije. Inicijalizira ekran za početni prikaz i
 * obrađuje autorizaciju korisnika. Također sadrži metodu za generiranje heša
 * lozinke za početnu postavku korisnika.
 *
 * @author Kesimator
 */
public class Start {

    /**
     * Glavna metoda koja inicijalizira ekran za početni prikaz.
     *
     * @param args Argumenti naredbenog retka
     */
    public static void main(String[] args) {

        // new PocetniInsert();
        
        // Prikazuje ekran za početni prikaz
        new SplashScreen().setVisible(true);

//        lozinka();
    }

    /**
     * Metoda za generiranje hasha lozinke za početnu postavku korisnika.
     * Koristi se ova metoda za generiranje hasha lozinke za početne korisničke
     * račune. Generirani hash treba kopirati u bazu podataka za pohranu
     * lozinke.
     */
    private void lozinka() {    // Ako želim ponovno pustiti u bazu, samo dodam static i pozovem lozinka gore
        // Factory pattern
        Argon2 argon2 = Argon2Factory.create();

        // Generiranje hasha lozinke
        String hash = argon2.hash(10, 65536, 1, "formula1".toCharArray());

        // Stvaranje instance ObradaOperater za obradu podataka operatera
        ObradaOperater oo = new ObradaOperater();
        Operater o = new Operater();
        o.setIme("Marijan");
        o.setPrezime("Kešinović");
        o.setEmail("oper@edunova.hr");
        o.setUloga("Operater");
        o.setLozinka(hash); // Postavljanje generiranog hasha kao lozinke

        oo.setEntitet(o);

        try {
            oo.create(); // Spremanje podataka operatera u bazu podataka
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
