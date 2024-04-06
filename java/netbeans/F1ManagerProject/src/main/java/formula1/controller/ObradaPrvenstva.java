/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import formula1.model.Prvenstva;
import formula1.util.EdunovaException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kesimator
 */
public class ObradaPrvenstva extends Obrada<Prvenstva> {

    public ObradaPrvenstva() {
        super();
    }

    public ObradaPrvenstva(Prvenstva p) {
        super(p);
    }

    @Override
    public List<Prvenstva> read() {
        return session.createQuery("from Prvenstva", Prvenstva.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaSezona();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {

    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if (entitet.getTim() != null) {
            throw new EdunovaException("Tim je povezan s prvenstvom i ne može biti obrisan!");
        }
        if (entitet.getVozac() != null) {
            throw new EdunovaException("Vozač je povezan s prvenstvom i ne može biti obrisan!");
        }
    }

    private void kontrolaSezona() throws EdunovaException {
        var s = entitet.getSezona();
        if (s == null) {
            throw new EdunovaException("Sezona mora biti definirana!");
        }

        Calendar sss = Calendar.getInstance();
        int zadnja = sss.get(Calendar.YEAR);

        Calendar ss = Calendar.getInstance();
        ss.setTime(s);
        int prva = ss.get(Calendar.YEAR);

        if (prva < 1904) {
            throw new EdunovaException("Sezona ne smije biti starija od 1904. godine!");
        }
        if (prva > zadnja) {
            throw new EdunovaException("Sezona ne smije biti novija od trenutne godine!");
        }

        var prije = new Date();
        prije.setYear(04);

        var danas = new Date();

        if (s.before(prije)) {
            throw new EdunovaException("Sezona ne smije biti starija od 1904. godine!");
        }
        if (s.after(danas)) {
            throw new EdunovaException("Sezona ne smije biti novija od trenutne godine!");
        }

    }

}
