/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.model;

import jakarta.persistence.ManyToOne;

/**
 *
 * @author Kesimator
 */
public class RezultatiUtrke extends Entitet {

    @ManyToOne
    private Utrke utrka;

    @ManyToOne
    private Vozaci vozac;

    private Integer bodovi;

    public RezultatiUtrke() {
    }

    public RezultatiUtrke(Utrke utrka, Vozaci vozac, Integer bodovi, Integer id) {
        super(id);
        this.utrka = utrka;
        this.vozac = vozac;
        this.bodovi = bodovi;
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

    public Integer getBodovi() {
        return bodovi;
    }

    public void setBodovi(Integer bodovi) {
        this.bodovi = bodovi;
    }

}
