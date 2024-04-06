/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import formula1.model.Vozaci;
import formula1.util.EdunovaException;
import java.util.Calendar;
import java.util.Date;
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

        List<Vozaci> lista = session.createQuery("from Vozaci", Vozaci.class).list();

        return lista;
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
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if (entitet.getTim() != null) {
            throw new EdunovaException("Vozač je povezan s timom i ne može biti obrisan!");
        }
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
        Calendar ss = Calendar.getInstance();
        ss.add(Calendar.YEAR, -60);
        Calendar oo = Calendar.getInstance();
        oo.add(Calendar.YEAR, -18);

        if (r.after(ss) || r.after(oo)) {
            throw new EdunovaException("Vozač ne može biti stariji od 60 godina ili mlađi od 18 godina!");
        }

        var s = new Date();
        s.setYear(s.getYear() - 60);
        var o = new Date();
        o.setYear(o.getYear() - 18);

        if (dr.before(s) || dr.after(o)) {
            throw new EdunovaException("Vozač ne može biti stariji od 60 godina ili mlađi od 18 godina!");
        }

    }

}
