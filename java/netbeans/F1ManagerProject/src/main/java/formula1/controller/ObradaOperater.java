/*
 * Ova klasa sadrži metode za obradu podataka entiteta Operater.
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
/**
 * Ova klasa sadrži metode za obradu podataka entiteta Operater. Nasljeđuje
 * apstraktnu klasu Obrada.
 *
 * @param <Operater> tip podataka entiteta Operater
 * @see formula1.controller.Obrada
 */
public class ObradaOperater extends Obrada<Operater> {

    /**
     * Čita sve zapise entiteta Operater iz baze podataka.
     *
     * @return lista svih entiteta Operater
     */
    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    /**
     * Provjerava pristupne podatke za autentikaciju operatera.
     *
     * @param email email operatera
     * @param lozinka lozinka operatera
     * @return Operater objekt ako su pristupni podaci valjani, inače null
     */
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

    /**
     * Provjerava valjanost podataka prilikom unosa novog entiteta Operater.
     *
     * @throws EdunovaException ako postoji već operater s istim emailom
     */
    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaEmail();
    }

    /**
     * Provjerava valjanost podataka prilikom promjene entiteta Operater.
     *
     * @throws EdunovaException ako su podaci nevaljani
     */
    @Override
    protected void kontrolaPromjena() throws EdunovaException {

    }

    /**
     * Provjerava valjanost podataka prilikom brisanja entiteta Operater.
     *
     * @throws EdunovaException ako su podaci nevaljani
     */
    @Override
    protected void kontrolaBrisanje() throws EdunovaException {

    }

    /**
     * Provjerava postoji li već operater s istim emailom.
     *
     * @throws EdunovaException ako postoji već operater s tim emailom
     */
    private void kontrolaEmail() throws EdunovaException {
        // Provjeri postoji li već operater s istim emailom
        List<Operater> mail = session.createQuery("from Operater o where o.email=:email", Operater.class)
                .setParameter("email", entitet.getEmail()).getResultList();

        if (!mail.isEmpty()) {
            throw new EdunovaException("Već postoji operater s tim emailom!");
        }
    }
}
