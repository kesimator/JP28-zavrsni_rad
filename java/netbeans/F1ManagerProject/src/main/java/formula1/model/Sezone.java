package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;

@Entity
public class Sezone extends Entitet {

    @Column(nullable = false)
    private int godina;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Vozaci vozac;
    //private List<Staze> staze;

    public Sezone() {

    }

    public Sezone(int id, int godina, Vozaci vozac, List<Staze> staze) {
        super(id);
        this.godina = godina;
        this.vozac = vozac;
        //this.staze = staze;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public Vozaci getVozac() {
        return vozac;
    }

    public void setVozac(Vozaci vozac) {
        this.vozac = vozac;
    }

//    public List<Staze> getStaze() {
//        return staze;
//    }
//
//    public void setStaze(List<Staze> staze) {
//        this.staze = staze;
//    }

}
