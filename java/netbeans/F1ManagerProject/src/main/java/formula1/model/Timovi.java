package formula1.model;

public class Timovi extends Entitet {

	private String ime_tima;
	private String drzava_sjedista;
	private int godina_osnutka;
	private Vozaci vozac;

	public Timovi() {

	}

	public Timovi(int id, String ime_tima, String drzava_sjedista, int godina_osnutka, Vozaci vozac) {
		super(id);
		this.ime_tima = ime_tima;
		this.drzava_sjedista = drzava_sjedista;
		this.godina_osnutka = godina_osnutka;
		this.vozac = vozac;
	}

	public String getIme_tima() {
		return ime_tima;
	}

	public void setIme_tima(String ime_tima) {
		this.ime_tima = ime_tima;
	}

	public String getDrzava_sjedista() {
		return drzava_sjedista;
	}

	public void setDrzava_sjedista(String drzava_sjedista) {
		this.drzava_sjedista = drzava_sjedista;
	}

	public int getGodina_osnutka() {
		return godina_osnutka;
	}

	public void setGodina_osnutka(int godina_osnutka) {
		this.godina_osnutka = godina_osnutka;
	}

	public Vozaci getVozac() {
		return vozac;
	}

	public void setVozac(Vozaci vozac) {
		this.vozac = vozac;
	}

}
