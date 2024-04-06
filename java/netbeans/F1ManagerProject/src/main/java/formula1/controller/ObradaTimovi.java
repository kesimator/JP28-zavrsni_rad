/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import formula1.model.Timovi;
import formula1.model.Vozaci;
import formula1.util.EdunovaException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kesimator
 */
public class ObradaTimovi extends Obrada<Timovi> {

    public ObradaTimovi() {
        super();
    }

    public ObradaTimovi(Timovi t) {
        super(t);
    }

    @Override
    public List<Timovi> read() {
        return session.createQuery("from Timovi", Timovi.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaImeTima();
        kontrolaDrzavaSjedista();
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
            sb.delete(sb.length() - 2, sb.length());
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
            throw new EdunovaException("Ime tima ne smije biti prazno!");
        }
    }

    private void kontrolaDrzavaSjedista() throws EdunovaException {
        var d = entitet.getDrzava_sjedista();
        if (d == null) {
        }
    }

    private void kontrolaGodinaUnosa() throws EdunovaException {
        var g = entitet.getGodina_osnutka();
        if (g == null) {
            throw new EdunovaException("Godina osnutka mora biti definirana!");
        }
        Calendar kk = Calendar.getInstance();
        int trenutna = kk.get(Calendar.YEAR);

        Calendar k = Calendar.getInstance();
        k.setTime(g);
        int year = k.get(Calendar.YEAR);

        if (year < 1904) {
            throw new EdunovaException("Godina osnutka ne smije biti starija od 1904. godine!");
        }
        if (year > trenutna) {
            throw new EdunovaException("Godina osnutka ne smije biti novija od trenutne godine!");
        }

        var prije = new Date();
        prije.setYear(04);

        var danas = new Date();

        if (g.before(prije)) {
            throw new EdunovaException("Godina osnutka ne može biti starija od 1904. godine!");
        }
        if (g.after(danas) || g.getYear() == danas.getYear()) {
            throw new EdunovaException("Godina osnutka ne smije biti novija od trenutne godine!");
        }
    }

}
