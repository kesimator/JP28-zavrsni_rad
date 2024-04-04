/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import formula1.model.Timovi;
import formula1.model.Vozaci;
import formula1.util.EdunovaException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Kesimator
 */
public class ObradaTimovi extends Obrada<Timovi> {

    @Override
    public List<Timovi> read() {
        return session.createQuery("from Timovi", Timovi.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaImeTima();
        kontrolaDrzavaSjedista();
        kontrolaVozaci();
        kontrolaGodinaUnosa();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if (!entitet.getVozaci().isEmpty()) {

            StringBuilder sb = new StringBuilder();
            sb.append("Tim se ne može obrisati jer ima vozače! (");

            for (Vozaci v : entitet.getVozaci()) {
                sb.append(v.getIme());
                sb.append(", ");
            }
            sb.append(") ");

            throw new EdunovaException(sb.toString());
        }
    }

    private void kontrolaImeTima() throws EdunovaException {
        var i = entitet.getIme_tima();
        if (i == null) {
            throw new EdunovaException("Ime tima mora biti definirano!");
        }
        if (i.isEmpty()) {
            throw new EdunovaException("Ime tima ne smije biti prazan!");
        }
    }

    private void kontrolaDrzavaSjedista() throws EdunovaException {
        var d = entitet.getDrzava_sjedista();
        if (d == null) {
            return;
        }
    }

    private void kontrolaVozaci() throws EdunovaException {
        var v = entitet.getVozaci();
        if (v == null) {
            throw new EdunovaException("Ime tima mora biti definirano!");
        }
        if (v.isEmpty()) {
            throw new EdunovaException("Ime tima ne smije biti prazan!");
        }
    }

    private void kontrolaGodinaUnosa() throws EdunovaException {
        var g = entitet.getGodina_osnutka();
        if (g == null) {
            throw new EdunovaException("Godina osnutka mora biti definirana!");
        }
        Calendar k = Calendar.getInstance();
        k.setTime(g);
        int year = k.get(Calendar.YEAR);
        if (year < 1904) {
            throw new EdunovaException("Godina osnutka ne može biti starija od 1904. godine!");
        }
    }

}
