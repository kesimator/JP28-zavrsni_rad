package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Timovi extends Entitet {

    @Column(nullable = false)
    private String ime_tima;
    @Column(nullable = true)
    private String drzava_sjedista;
    @Column(nullable = false)
    private Date godina_osnutka;
//    @JoinColumn(nullable = false)
//    @ManyToOne
//    private Vozaci vozac;
    // private int max_vozaca;
    @ManyToMany
    private List<Vozaci> vozaci;

    public Timovi() {

    }

    public Timovi(Integer id, String ime_tima, String drzava_sjedista, Date godina_osnutka, List<Vozaci> vozaci) {
        super(id);
        this.ime_tima = ime_tima;
        this.drzava_sjedista = drzava_sjedista;
        this.godina_osnutka = godina_osnutka;
        // this.vozac = vozac;
        // this.max_vozaca = max_vozaca;
        this.vozaci = vozaci;
    }

    public String getIme_tima() {
        return ime_tima;
    }

    public void setIme_tima(String ime_tima) {
        this.ime_tima = ime_tima;
    }

    public String getDrzava_sjedista() {
        return drzava_sjedista;
    }

    public void setDrzava_sjedista(String drzava_sjedista) {
        this.drzava_sjedista = drzava_sjedista;
    }

    public Date getGodina_osnutka() {
        return godina_osnutka;
    }

    public void setGodina_osnutka(Date godina_osnutka) {
        this.godina_osnutka = godina_osnutka;
    }

//    public Vozaci getVozac() {
//        return vozac;
//    }
//
//    public void setVozac(Vozaci vozac) {
//        this.vozac = vozac;
//    }
//    public Integer getMax_vozaca() {
//        return max_vozaca;
//    }
//
//    public void setMax_vozaca(Integer max_vozaca) {
//        this.max_vozaca = max_vozaca;
//    }
    public List<Vozaci> getVozaci() {
        return vozaci;
    }

    public void setVozaci(List<Vozaci> vozaci) {
        this.vozaci = vozaci;
    }

}
