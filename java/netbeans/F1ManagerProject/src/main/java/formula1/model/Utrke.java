package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Utrke extends Entitet {

    @JoinColumn(nullable = false)
    @ManyToOne
    private Staze staza;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Sezone sezona;
    @Column(nullable = false)
    private Date datum_i_vrijeme;

    public Utrke() {

    }

    public Utrke(Integer id, Staze staza, Sezone sezona, Date datum_i_vrijeme) {
        super(id);
        this.staza = staza;
        this.sezona = sezona;
        this.datum_i_vrijeme = datum_i_vrijeme;
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

}
