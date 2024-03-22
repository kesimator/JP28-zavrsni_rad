package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.Date;

@Entity
public class Vozaci extends Entitet {

    @Column(nullable = false)
    private String ime;
    @Column(nullable = false)
    private String prezime;
    @Column(nullable = false)
    private String nacionalnost;
    @Column(nullable = false)
    private Date datum_rodenja;
    @Column(nullable = true)
    private Integer broj_pobjeda;
    @Column(nullable = true)
    private Integer broj_pole_positiona;
    @Column(columnDefinition = "boolean")
    private boolean glavni;

    public Vozaci() {

    }

    public Vozaci(Integer id, String ime, String prezime, String nacionalnost, Date datum_rodenja, Integer broj_pobjeda,
            Integer broj_pole_positiona, boolean glavni) {
        super(id);
        this.ime = ime;
        this.prezime = prezime;
        this.nacionalnost = nacionalnost;
        this.datum_rodenja = datum_rodenja;
        this.broj_pobjeda = broj_pobjeda;
        this.broj_pole_positiona = broj_pole_positiona;
        this.glavni = glavni;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getNacionalnost() {
        return nacionalnost;
    }

    public void setNacionalnost(String nacionalnost) {
        this.nacionalnost = nacionalnost;
    }

    public Date getDatum_rodenja() {
        return datum_rodenja;
    }

    public void setDatum_rodenja(Date datum_rodenja) {
        this.datum_rodenja = datum_rodenja;
    }

    public Integer getBroj_pobjeda() {
        return broj_pobjeda;
    }

    public void setBroj_pobjeda(Integer broj_pobjeda) {
        this.broj_pobjeda = broj_pobjeda;
    }

    public Integer getBroj_pole_positiona() {
        return broj_pole_positiona;
    }

    public void setBroj_pole_positiona(Integer broj_pole_positiona) {
        this.broj_pole_positiona = broj_pole_positiona;
    }

    public boolean isGlavni() {
        return glavni;
    }

    public void setGlavni(boolean glavni) {
        this.glavni = glavni;
    }

}
