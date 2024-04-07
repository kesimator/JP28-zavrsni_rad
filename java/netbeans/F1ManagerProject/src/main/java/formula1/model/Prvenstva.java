/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Kesimator
 */
@Entity
public class Prvenstva extends Entitet {

    @Column(nullable = false)
    private Integer sezona;
    @ManyToOne
    @JoinColumn(name = "vozac_id")
    private Vozaci vozac;
    @ManyToOne
    @JoinColumn(name = "tim_id")
    private Timovi tim;

    public Prvenstva() {

    }

    public Prvenstva(Integer sezona, Vozaci vozac, Timovi tim, Integer id) {
        super(id);
        this.sezona = sezona;
        this.vozac = vozac;
        this.tim = tim;
    }

    public Integer getSezona() {
        return sezona;
    }

    public void setSezona(Integer sezona) {
        this.sezona = sezona;
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

}
