package formula1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja entitet vozača u sustavu Formula 1.
 */
@Entity
public class Vozaci extends Entitet {

    @Column(nullable = false)
    private String ime;
    @Column(nullable = false)
    private String prezime;
    @Column(nullable = false)
    private String nacionalnost;
    @Column(nullable = false)
    private LocalDate datum_rodenja;
    @ManyToOne
    @JoinColumn(name = "tim_id")
    private Timovi tim;
    @OneToMany(mappedBy = "vozac")
    private List<Prvenstva> prvenstva = new ArrayList<>();

    /**
     * Konstruktor bez argumenata.
     */
    public Vozaci() {

    }

    /**
     * Konstruktor sa svim atributima.
     *
     * @param id identifikator vozača
     * @param ime ime vozača
     * @param prezime prezime vozača
     * @param nacionalnost nacionalnost vozača
     * @param datum_rodenja datum rođenja vozača
     * @param tim tim za koji vozač vozi
     * @param prvenstva lista prvenstava u kojima je vozač sudjelovao
     */
    public Vozaci(Integer id, String ime, String prezime, String nacionalnost, LocalDate datum_rodenja, Timovi tim,
            List<Prvenstva> prvenstva) {
        super(id);
        this.ime = ime;
        this.prezime = prezime;
        this.nacionalnost = nacionalnost;
        this.datum_rodenja = datum_rodenja;
        this.tim = tim;
        this.prvenstva = prvenstva;
    }

    /**
     * Metoda koja vraća ime vozača.
     *
     * @return ime vozača
     */
    public String getIme() {
        return ime;
    }

    /**
     * Metoda koja postavlja ime vozača.
     *
     * @param ime ime vozača
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Metoda koja vraća prezime vozača.
     *
     * @return prezime vozača
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Metoda koja postavlja prezime vozača.
     *
     * @param prezime prezime vozača
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Metoda koja vraća nacionalnost vozača.
     *
     * @return nacionalnost vozača
     */
    public String getNacionalnost() {
        return nacionalnost;
    }

    /**
     * Metoda koja postavlja nacionalnost vozača.
     *
     * @param nacionalnost nacionalnost vozača
     */
    public void setNacionalnost(String nacionalnost) {
        this.nacionalnost = nacionalnost;
    }

    /**
     * Metoda koja vraća datum rođenja vozača.
     *
     * @return datum rođenja vozača
     */
    public LocalDate getDatum_rodenja() {
        return datum_rodenja;
    }

    /**
     * Metoda koja postavlja datum rođenja vozača.
     *
     * @param datum_rodenja datum rođenja vozača
     */
    public void setDatum_rodenja(LocalDate datum_rodenja) {
        this.datum_rodenja = datum_rodenja;
    }

    /**
     * Metoda koja vraća tim za koji vozač vozi.
     *
     * @return tim za koji vozač vozi
     */
    public Timovi getTim() {
        return tim;
    }

    /**
     * Metoda koja postavlja tim za koji vozač vozi.
     *
     * @param tim tim za koji vozač vozi
     */
    public void setTim(Timovi tim) {
        this.tim = tim;
    }

    /**
     * Metoda koja vraća listu prvenstava u kojima je vozač sudjelovao.
     *
     * @return lista prvenstava vozača
     */
    public List<Prvenstva> getPrvenstva() {
        return prvenstva;
    }

    /**
     * Metoda koja postavlja listu prvenstava u kojima je vozač sudjelovao.
     *
     * @param prvenstva lista prvenstava vozača
     */
    public void setPrvenstva(List<Prvenstva> prvenstva) {
        this.prvenstva = prvenstva;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (getIme() != null && getPrezime() != null) {
            sb.append(getIme()).append(" ").append(getPrezime());
        } else {
            sb.append("Nepostojeće ime i prezime, ");
        }

        if (getTim() != null && getTim().getIme_tima() != null && !getTim().getIme_tima().isEmpty()) {
            sb.append(" [");
            sb.append(getTim().getIme_tima());
            sb.append("]");
        }
        return sb.toString();
    }

}
