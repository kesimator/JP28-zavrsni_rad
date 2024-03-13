package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Staze extends Entitet {

    @Column(nullable = false)
    private String ime_staze;
    private int duzina_staze;
    private String lokacija;
    private LocalTime rekord_staze;
    private Date godina_postavljanja;

    public Staze() {

    }

    public Staze(int id, String ime_staze, int duzina_staze, String lokacija, LocalTime rekord_staze,
            Date godina_postavljanja) {
        super(id);
        this.ime_staze = ime_staze;
        this.duzina_staze = duzina_staze;
        this.lokacija = lokacija;
        this.rekord_staze = rekord_staze;
        this.godina_postavljanja = godina_postavljanja;
    }

    public String getIme_staze() {
        return ime_staze;
    }

    public void setIme_staze(String ime_staze) {
        this.ime_staze = ime_staze;
    }

    public int getDuzina_staze() {
        return duzina_staze;
    }

    public void setDuzina_staze(int duzina_staze) {
        this.duzina_staze = duzina_staze;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public LocalTime getRekord_staze() {
        return rekord_staze;
    }

    public void setRekord_staze(LocalTime rekord_staze) {
        this.rekord_staze = rekord_staze;
    }

    public Date getGodina_postavljanja() {
        return godina_postavljanja;
    }

    public void setGodina_postavljanja(Date godina_postavljanja) {
        this.godina_postavljanja = godina_postavljanja;
    }

}
