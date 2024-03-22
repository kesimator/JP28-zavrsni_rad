package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Sezone extends Entitet {

    @Column(nullable = false)
    private Date godina;
    //@JoinColumn(nullable = false)
    @ManyToMany
    private List<Vozaci> vozac;
    @ManyToMany
    private List<Staze> staze;
    @ManyToMany
    private List<Timovi> timovi;

    public Sezone() {

    }

    public Sezone(Integer id, Date godina, List<Vozaci> vozac, List<Staze> staze, List<Timovi> timovi) {
        super(id);
        this.godina = godina;
        //this.vozac = vozac;
        //this.staze = staze;
    }

    public Date getGodina() {
        return godina;
    }

    public void setGodina(Date godina) {
        this.godina = godina;
    }

    public List<Vozaci> getVozac() {
        return vozac;
    }

    public void setVozac(List<Vozaci> vozac) {
        this.vozac = vozac;
    }

    public List<Staze> getStaze() {
        return staze;
    }

    public void setStaze(List<Staze> staze) {
        this.staze = staze;
    }

    public List<Timovi> getTimovi() {
        return timovi;
    }

    public void setTimovi(List<Timovi> timovi) {
        this.timovi = timovi;
    }

}
