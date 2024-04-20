package formula1.util;

import formula1.model.Operater;

/**
 * Klasa koja sadrži korisne alate i konstante za upravljanje aplikacijom
 * Formula 1 Manager.
 */
public class Alati {

    /**
     * Naziv aplikacije.
     */
    public static final String NAZIV_APP = "Formula 1 Manager APP";

    /**
     * Trenutni operater koji je prijavljen u aplikaciju.
     */
    public static Operater OPERATER;

    /**
     * Metoda koja vraća informacije o trenutnom operateru.
     *
     * @return informacije o trenutnom operateru (ime, prezime i uloga)
     */
    public static String getOperater() {
        if (OPERATER != null) {
            return OPERATER.getIme() + " " + OPERATER.getPrezime() + " (" + OPERATER.getUloga() + ")";
        } else {
            return "Nema prijavljenog operatera!";
        }
    }

}
