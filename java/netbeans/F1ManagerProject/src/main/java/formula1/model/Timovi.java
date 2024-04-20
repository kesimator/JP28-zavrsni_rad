package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja entitet tima u sustavu Formula 1.
 */
@Entity
public class Timovi extends Entitet {

    @Column(nullable = false)
    private String ime_tima;
    @Column(nullable = false)
    private String drzava_sjedista;
    @Column(nullable = false)
    private Integer godina_osnutka;
    @OneToMany(mappedBy = "tim")
    private List<Vozaci> vozaci = new ArrayList<>();
    @OneToMany(mappedBy = "tim")
    private List<Prvenstva> prvenstva = new ArrayList<>();

    /**
     * Konstruktor bez argumenata.
     */
    public Timovi() {

    }

    /**
     * Konstruktor sa svim atributima.
     *
     * @param id identifikator tima
     * @param ime_tima ime tima
     * @param drzava_sjedista država sjedišta tima
     * @param godina_osnutka godina osnutka tima
     * @param vozaci lista vozača tima
     * @param prvenstva lista prvenstava tima
     */
    public Timovi(Integer id, String ime_tima, String drzava_sjedista, Integer godina_osnutka, List<Vozaci> vozaci,
            List<Prvenstva> prvenstva) {
        super(id);
        this.ime_tima = ime_tima;
        this.drzava_sjedista = drzava_sjedista;
        this.godina_osnutka = godina_osnutka;
        this.vozaci = vozaci;
        this.prvenstva = prvenstva;
    }

    /**
     * Metoda koja vraća ime tima.
     *
     * @return ime tima
     */
    public String getIme_tima() {
        return ime_tima;
    }

    /**
     * Metoda koja postavlja ime tima.
     *
     * @param ime_tima ime tima
     */
    public void setIme_tima(String ime_tima) {
        this.ime_tima = ime_tima;
    }

    /**
     * Metoda koja vraća državu sjedišta tima.
     *
     * @return država sjedišta tima
     */
    public String getDrzava_sjedista() {
        return drzava_sjedista;
    }

    /**
     * Metoda koja postavlja državu sjedišta tima.
     *
     * @param drzava_sjedista država sjedišta tima
     */
    public void setDrzava_sjedista(String drzava_sjedista) {
        this.drzava_sjedista = drzava_sjedista;
    }

    /**
     * Metoda koja vraća godinu osnutka tima.
     *
     * @return godina osnutka tima
     */
    public Integer getGodina_osnutka() {
        return godina_osnutka;
    }

    /**
     * Metoda koja postavlja godinu osnutka tima.
     *
     * @param godina_osnutka godina osnutka tima
     */
    public void setGodina_osnutka(Integer godina_osnutka) {
        this.godina_osnutka = godina_osnutka;
    }

    /**
     * Metoda koja vraća listu vozača tima.
     *
     * @return lista vozača tima
     */
    public List<Vozaci> getVozaci() {
        return vozaci;
    }

    /**
     * Metoda koja postavlja listu vozača tima.
     *
     * @param vozaci lista vozača tima
     */
    public void setVozaci(List<Vozaci> vozaci) {
        this.vozaci = vozaci;
    }

    /**
     * Metoda koja vraća listu prvenstava tima.
     *
     * @return lista prvenstava tima
     */
    public List<Prvenstva> getPrvenstva() {
        return prvenstva;
    }

    /**
     * Metoda koja postavlja listu prvenstava tima.
     *
     * @param prvenstva lista prvenstava tima
     */
    public void setPrvenstva(List<Prvenstva> prvenstva) {
        this.prvenstva = prvenstva;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ime_tima;
    }

}
