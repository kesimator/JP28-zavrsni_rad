package formula1.util;

/**
 * Posebna vrsta iznimke koja se može koristiti u aplikaciji Formula 1 Manager.
 */
public class EdunovaException extends Exception {

    /**
     * Poruka koja opisuje iznimku.
     */
    private String poruka;

    /**
     * Konstruktor koji prima poruku iznimke.
     *
     * @param poruka poruka iznimke
     */
    public EdunovaException(String poruka) {
        super(poruka);
        this.poruka = poruka;
    }

    /**
     * Metoda koja vraća poruku iznimke.
     *
     * @return poruka iznimke
     */
    public String getPoruka() {
        return poruka;
    }

}
