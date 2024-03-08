package formula1.model;

import java.util.Date;

public class Vozaci extends Entitet {

	private String ime;
	private String prezime;
	private String nacionalnost;
	private Date datum_rodenja;
	private int broj_pobjeda;
	private int broj_pole_positiona;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getNacionalnost() {
		return nacionalnost;
	}

	public void setNacionalnost(String nacionalnost) {
		this.nacionalnost = nacionalnost;
	}

	public Date getDatum_rodenja() {
		return datum_rodenja;
	}

	public void setDatum_rodenja(Date datum_rodenja) {
		this.datum_rodenja = datum_rodenja;
	}

	public int getBroj_pobjeda() {
		return broj_pobjeda;
	}

	public void setBroj_pobjeda(int broj_pobjeda) {
		this.broj_pobjeda = broj_pobjeda;
	}

	public int getBroj_pole_positiona() {
		return broj_pole_positiona;
	}

	public void setBroj_pole_positiona(int broj_pole_positiona) {
		this.broj_pole_positiona = broj_pole_positiona;
	}

}
