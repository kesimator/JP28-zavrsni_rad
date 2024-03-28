package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Sezone extends Entitet {

    @Column(nullable = false)
    private Date godina;
    //@JoinColumn(nullable = false)
    @ManyToMany
    @JoinTable(
            name = "sezona_vozaci",
            joinColumns = @JoinColumn(name = "sezona_id"),
            inverseJoinColumns = @JoinColumn(name = "vozaci_id")
    )
    private List<Vozaci> vozac;
    @ManyToMany
    private List<Timovi> timovi;
    @Column(nullable = false)
    private Integer broj_utrka;

    public Sezone() {

    }

    public Sezone(Integer id, Date godina, List<Vozaci> vozac, List<Timovi> timovi, Integer broj_utrka) {
        super(id);
        this.godina = godina;
        this.vozac = vozac;
        this.broj_utrka = broj_utrka;
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

    public List<Timovi> getTimovi() {
        return timovi;
    }

    public void setTimovi(List<Timovi> timovi) {
        this.timovi = timovi;
    }

    public Integer getBroj_utrka() {
        return broj_utrka;
    }

    public void setBroj_utrka(Integer broj_utrka) {
        this.broj_utrka = broj_utrka;
    }

}
