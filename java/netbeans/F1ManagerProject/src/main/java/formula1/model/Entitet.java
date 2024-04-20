package formula1.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Apstraktna klasa koja predstavlja entitet u sustavu Formula 1. Ova klasa
 * sadrži identifikator koji će biti naslijeđen od strane svih entiteta.
 */
@MappedSuperclass
public abstract class Entitet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Konstruktor bez argumenata.
     */
    public Entitet() {

    }

    /**
     * Konstruktor s identifikatorom.
     *
     * @param id identifikator entiteta
     */
    public Entitet(Integer id) {
        super();
        this.id = id;
    }

    /**
     * Metoda koja vraća identifikator entiteta.
     *
     * @return identifikator entiteta
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metoda koja postavlja identifikator entiteta.
     *
     * @param id identifikator entiteta
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
