package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Klasa koja predstavlja entitet prvenstva u sustavu Formula 1.
 */
@Entity
public class Prvenstva extends Entitet {

    @Column(nullable = false)
    private Integer sezona;
    @ManyToOne
    @JoinColumn(name = "vozac_id")
    private Vozaci vozac;
    @ManyToOne
    @JoinColumn(name = "tim_id")
    private Timovi tim;

    /**
     * Konstruktor bez argumenata.
     */
    public Prvenstva() {

    }

    /**
     * Konstruktor sa svim atributima.
     *
     * @param sezona sezona prvenstva
     * @param vozac vozač koji sudjeluje u prvenstvu
     * @param tim tim koji sudjeluje u prvenstvu
     * @param id identifikator prvenstva
     */
    public Prvenstva(Integer sezona, Vozaci vozac, Timovi tim, Integer id) {
        super(id);
        this.sezona = sezona;
        this.vozac = vozac;
        this.tim = tim;
    }

    /**
     * Metoda koja vraća sezonu prvenstva.
     *
     * @return sezona prvenstva
     */
    public Integer getSezona() {
        return sezona;
    }

    /**
     * Metoda koja postavlja sezonu prvenstva.
     *
     * @param sezona sezona prvenstva
     */
    public void setSezona(Integer sezona) {
        this.sezona = sezona;
    }

    /**
     * Metoda koja vraća vozača koji sudjeluje u prvenstvu.
     *
     * @return vozač koji sudjeluje u prvenstvu
     */
    public Vozaci getVozac() {
        return vozac;
    }

    /**
     * Metoda koja postavlja vozača koji sudjeluje u prvenstvu.
     *
     * @param vozac vozač koji sudjeluje u prvenstvu
     */
    public void setVozac(Vozaci vozac) {
        this.vozac = vozac;
    }

    /**
     * Metoda koja vraća tim koji sudjeluje u prvenstvu.
     *
     * @return tim koji sudjeluje u prvenstvu
     */
    public Timovi getTim() {
        return tim;
    }

    /**
     * Metoda koja postavlja tim koji sudjeluje u prvenstvu.
     *
     * @param tim tim koji sudjeluje u prvenstvu
     */
    public void setTim(Timovi tim) {
        this.tim = tim;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.valueOf(sezona);
    }
}
