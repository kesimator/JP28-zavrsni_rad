package formula1.model;

import jakarta.persistence.Entity;

/**
 * Klasa koja predstavlja entitet operatera u sustavu.
 */
@Entity
public class Operater extends Entitet {

    private String ime;
    private String prezime;
    private String email;
    private String uloga;
    private String lozinka;

    /**
     * Metoda koja vraća ime operatera.
     *
     * @return ime operatera
     */
    public String getIme() {
        return ime;
    }

    /**
     * Metoda koja postavlja ime operatera.
     *
     * @param ime ime operatera
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Metoda koja vraća prezime operatera.
     *
     * @return prezime operatera
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Metoda koja postavlja prezime operatera.
     *
     * @param prezime prezime operatera
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Metoda koja vraća email operatera.
     *
     * @return email operatera
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metoda koja postavlja email operatera.
     *
     * @param email email operatera
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metoda koja vraća ulogu operatera.
     *
     * @return uloga operatera
     */
    public String getUloga() {
        return uloga;
    }

    /**
     * Metoda koja postavlja ulogu operatera.
     *
     * @param uloga uloga operatera
     */
    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    /**
     * Metoda koja vraća lozinku operatera.
     *
     * @return lozinka operatera
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * Metoda koja postavlja lozinku operatera.
     *
     * @param lozinka lozinka operatera
     */
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

}
