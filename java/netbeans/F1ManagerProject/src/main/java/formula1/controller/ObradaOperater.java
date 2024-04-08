/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import formula1.model.Operater;
import formula1.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Kesimator
 */
public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    public Operater autoriziraj(String email, String lozinka) {
        Operater o;

        try {
            o = session.createQuery("from Operater o where o.email=:email", Operater.class)
                    .setParameter("email", email).getSingleResult();

            Argon2 argon2 = Argon2Factory.create();

            return argon2.verify(o.getLozinka(), lozinka.toCharArray()) ? o : null;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaEmail();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {

    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {

    }

    private void kontrolaEmail() throws EdunovaException {
        // Provjeri postoji li već operater s istim emailom
        List<Operater> mail = session.createQuery("from Operater o where o.email=:email", Operater.class)
                .setParameter("email", entitet.getEmail()).getResultList();

        if (!mail.isEmpty()) {
            throw new EdunovaException("Već postoji operater s tim emailom!");
        }
    }

}