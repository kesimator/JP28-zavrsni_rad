/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import formula1.model.Timovi;
import formula1.model.Vozaci;
import formula1.util.EdunovaException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 *
 * @author Kesimator
 */
public class ObradaVozaci extends Obrada<Vozaci> {
    
    public ObradaVozaci() {
        super();
    }
    
    public ObradaVozaci(Vozaci v) {
        super(v);
    }
    
    @Override
    public List<Vozaci> read() {
        
        List<Vozaci> lista = session.createQuery("from Vozaci order by ime, prezime", Vozaci.class).list();
        
        return lista;
    }
    
    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaNacionalnost();
        kontrolaDatumRodenja();
        kontrolaPostojanjaTima();
        kontrolaPostojanjaVozaca();
    }
    
    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        kontrolaUnos();
    }
    
    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        Timovi tim = entitet.getTim();
        if (tim != null) {
            throw new EdunovaException("Vozač je povezan s timom i ne može biti obrisan! [" + tim.getIme_tima() + "]");
        }
    }
    
    private void kontrolaIme() throws EdunovaException {
        var i = entitet.getIme();
        if (i == null) {
            throw new EdunovaException("Ime vozača mora biti definirano!");
        }
        if (i.isEmpty()) {
            throw new EdunovaException("Ime vozača obavezno!");
        }
        entitet.setIme(entitet.getIme().toUpperCase());
    }
    
    private void kontrolaPrezime() throws EdunovaException {
        var p = entitet.getPrezime();
        if (p == null) {
            throw new EdunovaException("Prezime vozača mora biti definirano!");
        }
        if (p.isEmpty()) {
            throw new EdunovaException("Prezime vozača obavezno!");
        }
        entitet.setPrezime(entitet.getPrezime().toUpperCase());
    }
    
    private void kontrolaNacionalnost() throws EdunovaException {
        var n = entitet.getNacionalnost();
        if (n == null) {
            throw new EdunovaException("Nacionalnost vozača mora biti definirano!");
        }
        if (n.isEmpty()) {
            throw new EdunovaException("Nacionalnost vozača obavezno!");
        }
        entitet.setNacionalnost(entitet.getNacionalnost().toUpperCase());
    }
    
    private void kontrolaDatumRodenja() throws EdunovaException {
        var dr = entitet.getDatum_rodenja();
        if (dr == null) {
            throw new EdunovaException("Datum rođenja mora biti definiran!");
        }

        // Trenutni datum
        LocalDate danas = LocalDate.now();

        // Računanje razlike u godinama između datuma rođenja i danas
        int godine = Period.between(dr, danas).getYears();

        // Provjera uvjeta
        if (godine < 18 || godine > 60) {
            throw new EdunovaException("Vozač ne može biti mlađi od 18 godina ili stariji od 60 godina!");
        }
        
    }
    
    private void kontrolaPostojanjaTima() throws EdunovaException {
        Timovi tim = entitet.getTim();
        if (tim == null) {
            throw new EdunovaException("Vozač mora biti dodijeljen postojećem timu!");
        }
    }
    
    private void kontrolaPostojanjaVozaca() throws EdunovaException {
        Vozaci vozac = entitet;
        Timovi tim = entitet.getTim();
        if (tim != null && tim.getVozaci().contains(vozac)) {
            throw new EdunovaException("Vozač već pripada tom timu!");
        }
    }
    
}
