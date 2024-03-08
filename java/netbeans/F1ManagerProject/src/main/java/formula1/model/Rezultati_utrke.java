package formula1.model;

import jakarta.persistence.Entity;
import java.time.LocalTime;

@Entity
public class Rezultati_utrke extends Entitet {

    private Utrke utrka;
    private Vozaci vozac;
    private Timovi tim;
    private int pozicija;
    private LocalTime najbrzi_krug;

    public Rezultati_utrke() {

    }

    public Rezultati_utrke(int id, Utrke utrka, Vozaci vozac, Timovi tim, int pozicija, LocalTime najbrzi_krug) {
        super(id);
        this.utrka = utrka;
        this.vozac = vozac;
        this.tim = tim;
        this.pozicija = pozicija;
        this.najbrzi_krug = najbrzi_krug;
    }

    public Utrke getUtrka() {
        return utrka;
    }

    public void setUtrka(Utrke utrka) {
        this.utrka = utrka;
    }

    public Vozaci getVozac() {
        return vozac;
    }

    public void setVozac(Vozaci vozac) {
        this.vozac = vozac;
    }

    public Timovi getTim() {
        return tim;
    }

    public void setTim(Timovi tim) {
        this.tim = tim;
    }

    public int getPozicija() {
        return pozicija;
    }

    public void setPozicija(int pozicija) {
        this.pozicija = pozicija;
    }

    public LocalTime getNajbrzi_krug() {
        return najbrzi_krug;
    }

    public void setNajbrzi_krug(LocalTime najbrzi_krug) {
        this.najbrzi_krug = najbrzi_krug;
    }

}
