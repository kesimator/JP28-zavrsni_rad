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
//    @ManyToMany
//    private List<Vozaci> vozaci;

    public Timovi() {

    }

    public Timovi(Integer id, String ime_tima, String drzava_sjedista, Date godina_osnutka) {
        super(id);
        this.ime_tima = ime_tima;
        this.drzava_sjedista = drzava_sjedista;
        this.godina_osnutka = godina_osnutka;
//        this.vozaci = vozaci;
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

//    public List<Vozaci> getVozaci() {
//        return vozaci;
//    }
//
//    public void setVozaci(List<Vozaci> vozaci) {
//        this.vozaci = vozaci;
//    }

}
