/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.List;

/**
 *
 * @author Kesimator
 */
@Entity
public class Sezona_Vozaci_Timovi extends Entitet {
    
    @Column(nullable = false)
    private List<Vozaci> vozaci;
    @Column(nullable = false)
    private List<Timovi> timovi;
    @Column(nullable = false)
    private List<Sezone> sezone;

    public Sezona_Vozaci_Timovi() {
        
    }
    
    

    public Sezona_Vozaci_Timovi(List<Vozaci> vozaci, List<Timovi> timovi, List<Sezone> sezone, Integer id) {
        super(id);
        this.vozaci = vozaci;
        this.timovi = timovi;
        this.sezone = sezone;
    }
    
    

    public List<Vozaci> getVozaci() {
        return vozaci;
    }

    public void setVozaci(List<Vozaci> vozaci) {
        this.vozaci = vozaci;
    }

    public List<Timovi> getTimovi() {
        return timovi;
    }

    public void setTimovi(List<Timovi> timovi) {
        this.timovi = timovi;
    }

    public List<Sezone> getSezone() {
        return sezone;
    }

    public void setSezone(List<Sezone> sezone) {
        this.sezone = sezone;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

