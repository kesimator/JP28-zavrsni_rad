package formula1.view;

/**
 * Sučelje koje definira osnovne metode za upravljanje prikazom u aplikaciji
 * Formula 1 Manager.
 */
public interface EdunovaViewSucelje {

    /**
     * Metoda za učitavanje podataka koji će se prikazati.
     */
    void ucitaj();

    /**
     * Metoda za popunjavanje modela podacima.
     */
    void popuniModel();

    /**
     * Metoda za popunjavanje prikaza podacima.
     */
    void popuniView();

}
