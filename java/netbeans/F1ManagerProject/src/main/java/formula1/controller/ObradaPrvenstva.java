/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import formula1.model.Prvenstva;
import formula1.util.EdunovaException;
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
        kontrolaUnos(); // Je li potrebno?
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if (entitet.getVozac() != null) {
            throw new EdunovaException("Vozač je povezan s prvenstvom! Molim prvo ukloniti vozača iz prvenstva!");
        }
        if (entitet.getTim() != null) {
            throw new EdunovaException("Tim je povezan s prvenstvom!\nMolim prvo ukloniti tim iz prvenstva!");
        }

    }

    private void kontrolaSezona() throws EdunovaException {
        var s = entitet.getSezona();
        if (s == null) {
            throw new EdunovaException("Sezona mora biti definirana!\n(broj između 1950 i 2023)");
        }
        if (s < 1950 || s > 2023) {
            throw new EdunovaException("Sezona mora biti unutar raspona od 1950. godine do 2023. godine!");
        }

        // Provjera postojanja sezone u bazi
        if (sezonaPostoji(s)) {
            throw new EdunovaException("Već postoji sezona s navedenom godinom!");
        }
    }

    // Metoda koja provjerava postojanje sezone u bazi
    private boolean sezonaPostoji(int sezona) {
        List<Prvenstva> svaPrvenstva = read();
        for (Prvenstva p : svaPrvenstva) {
            if (p.getSezona() == sezona) {
                return true;
            }
        }
        return false;
    }
}
