/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import formula1.model.Timovi;
import formula1.model.Vozaci;
import formula1.util.EdunovaException;
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

        List<Timovi> lista = session.createQuery("from Timovi order by ime_tima", Timovi.class).list();

        return lista;
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaImeTima();
        kontrolaDrzavaSjedista();
        kontrolaGodinaUnosa();
        kontrolaPostojanjaTimova();
//        kontrolaPostojanjaVozacaUTimu();
//        kontrolaPostojanjaVozaca();
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
        entitet.setIme_tima(entitet.getIme_tima().toUpperCase());
    }

    private void kontrolaDrzavaSjedista() throws EdunovaException {
        var d = entitet.getDrzava_sjedista();
        if (d == null) {
            throw new EdunovaException("Država sjedišta mora biti definirano!");
        }
        if (d.isEmpty()) {
            throw new EdunovaException("Država sjedišta ne smije biti prazno!");
        }
        entitet.setDrzava_sjedista(entitet.getDrzava_sjedista().toUpperCase());
    }

    private void kontrolaGodinaUnosa() throws EdunovaException {
        var g = entitet.getGodina_osnutka();
        if (g == null) {
            throw new EdunovaException("Godina osnutka mora biti definirana!");
        }
        if (g < 1904 || g > 2020) {
            throw new EdunovaException("Godina osnutka mora biti unutar raspona od 1904. godine do 2020. godine!");
        }
    }

    private void kontrolaPostojanjaTimova() throws EdunovaException {
        List<Timovi> timovi = session.createQuery("from Timovi t where t.ime_tima = :ime_tima", Timovi.class)
                .setParameter("ime_tima", entitet.getIme_tima())
                .getResultList();
        if (!timovi.isEmpty()) {
            throw new EdunovaException("Već postoji tim s istim imenom!");
        }
    }

//    private void kontrolaPostojanjaVozacaUTimu() throws EdunovaException {
//        List<Vozaci> vozaciUTimu = session.createQuery("from Vozaci v where v.tim = :tim", Vozaci.class)
//                .setParameter("tim", entitet)
//                .getResultList();
//        if (!vozaciUTimu.isEmpty()) {
//            throw new EdunovaException("Vozač je već dodijeljen timu!");
//        }
//    }
//    private void kontrolaPostojanjaVozaca() throws EdunovaException {
//        List<Vozaci> vozaci = entitet.getVozaci();
//
//        // Iteriramo kroz listu vozača
//        for (Vozaci vozac : vozaci) {
//            String ime = vozac.getIme();
//            String prezime = vozac.getPrezime();
//            
//            List<Vozaci> postojeciVozaci = session.createQuery(
//                    "from Vozaci v where v.ime = :ime and v.prezime = :prezime", Vozaci.class)
//                    .setParameter("ime", ime)
//                    .setParameter("prezime", prezime)
//                    .getResultList();
//            
//            if (!postojeciVozaci.isEmpty()) {   // provjeriti !
//                throw new EdunovaException("Vozač s navedenim imenom i prezimenom ne postoji!");
//            }
//        }
//        
//    }
}
