/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import formula1.model.Vozaci;
import formula1.util.EdunovaException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Kesimator
 */
public class ObradaVozaci extends Obrada<Vozaci> {

    @Override
    public List<Vozaci> read() {
        return session.createQuery("from Vozaci", Vozaci.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaNacionalnost();
        kontrolaDatumRodenja();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {

    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {

    }

    private void kontrolaIme() throws EdunovaException {
        var i = entitet.getIme();
        if (i == null) {
            throw new EdunovaException("Ime vozača mora biti definirano!");
        }
        if (i.isEmpty()) {
            throw new EdunovaException("Ime vozača ne smije biti prazno!");
        }
    }

    private void kontrolaPrezime() throws EdunovaException {
        var p = entitet.getPrezime();
        if (p == null) {
            throw new EdunovaException("Prezime vozača mora biti definirano!");
        }
        if (p.isEmpty()) {
            throw new EdunovaException("Prezime vozača ne smije biti prazno!");
        }
    }

    private void kontrolaNacionalnost() throws EdunovaException {
        var n = entitet.getNacionalnost();
        if (n == null) {
            throw new EdunovaException("Nacionalnost vozača mora biti definirano!");
        }
        if (n.isEmpty()) {
            throw new EdunovaException("Nacionalnost vozača ne smije biti prazna!");
        }
    }

    private void kontrolaDatumRodenja() throws EdunovaException {
        var dr = entitet.getDatum_rodenja();
        if (dr == null) {
            throw new EdunovaException("Datum rođenja mora biti definiran!");
        }
        Calendar r = Calendar.getInstance();
        r.setTime(dr);
        Calendar s = Calendar.getInstance();
        s.add(Calendar.YEAR, -60);
        Calendar o = Calendar.getInstance();
        o.add(Calendar.YEAR, -18);

        if (r.after(s) || r.after(o)) {
            throw new EdunovaException("Vozač ne može biti stariji od 60 godina ili mlađi od 18 godina!");
        }
    }

}
