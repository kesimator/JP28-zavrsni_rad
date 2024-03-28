package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Utrke extends Entitet {

//    @JoinColumn(nullable = false)
    @ManyToOne
    private Staze staza;
//    @JoinColumn(nullable = false)
    @ManyToOne
    private Sezone sezona;
    @Column(nullable = false)
    private Date datum_i_vrijeme;
    @Column(nullable = false)
    private Integer broj_vozaca;

    private Integer redni_broj_utrke;

//    @ManyToOne
//    @JoinColumn(name = "pobjednik_id")
//    private Vozaci pobjednik;

    public Utrke() {

    }

    public Utrke(Integer id, Date datum_i_vrijeme, Integer broj_vozaca, Integer redni_broj_utrke, Sezone sezona, Staze staza) {
        super(id);
        this.staza = staza;
        this.sezona = sezona;
        this.datum_i_vrijeme = datum_i_vrijeme;
        this.broj_vozaca = broj_vozaca;
        this.redni_broj_utrke = redni_broj_utrke;
//        this.pobjednik = pobjednik;
    }

    public Staze getStaza() {
        return staza;
    }

    public void setStaza(Staze staza) {
        this.staza = staza;
    }

    public Sezone getSezona() {
        return sezona;
    }

    public void setSezona(Sezone sezona) {
        this.sezona = sezona;
    }

    public Date getDatum_i_vrijeme() {
        return datum_i_vrijeme;
    }

    public void setDatum_i_vrijeme(Date datum_i_vrijeme) {
        this.datum_i_vrijeme = datum_i_vrijeme;
    }

    public Integer getBroj_vozaca() {
        return broj_vozaca;
    }

    public void setBroj_vozaca(Integer broj_vozaca) {
        this.broj_vozaca = broj_vozaca;
    }

    public Integer getRedni_broj_utrke() {
        return redni_broj_utrke;
    }

    public void setRedni_broj_utrke(Integer redni_broj_utrke) {
        this.redni_broj_utrke = redni_broj_utrke;
    }

//    public Vozaci getPobjednik() {
//        return pobjednik;
//    }
//
//    public void setPobjednik(Vozaci pobjednik) {
//        this.pobjednik = pobjednik;
//    }

}
