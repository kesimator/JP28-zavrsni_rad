package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "tim_id")
    private Timovi tim;

    public Vozaci() {

    }

    public Vozaci(Integer id, String ime, String prezime, String nacionalnost, Date datum_rodenja, Timovi tim) {
        super(id);
        this.ime = ime;
        this.prezime = prezime;
        this.nacionalnost = nacionalnost;
        this.datum_rodenja = datum_rodenja;
        this.tim = tim;
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

    public Timovi getTim() {
        return tim;
    }

    public void setTim(Timovi tim) {
        this.tim = tim;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;

//        StringBuilder sb = new StringBuilder();
//
//        if (getIme() != null && getPrezime() != null) {
//            sb.append(getIme()).append(" ").append(getPrezime());
//        } else {
//            sb.append("Nepostojeće ime i prezime, ");
//        }
//
//        if (getTim() != null && getTim().getIme_tima() != null && !getTim().getIme_tima().isEmpty()) {
//            sb.append(" [");
//            sb.append(getTim().getIme_tima());
//            sb.append("]");
//        }
//        return sb.toString();
    }

}
