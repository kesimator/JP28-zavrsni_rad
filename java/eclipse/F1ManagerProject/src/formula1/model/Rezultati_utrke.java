package formula1.model;

import java.time.LocalTime;

public class Rezultati_utrke extends Entitet {

	private Utrke utrka;
	private Vozaci vozac;
	private Timovi tim;
	private int pozicija;
	private LocalTime najbrzi_krug;

	public Utrke getUtrka() {
		return utrka;
	}

	public void setUtrka(Utrke utrka) {
		this.utrka = utrka;
	}

	public Vozaci getVozac() {
		return vozac;
	}

	public void setVozac(Vozaci vozac) {
		this.vozac = vozac;
	}

	public Timovi getTim() {
		return tim;
	}

	public void setTim(Timovi tim) {
		this.tim = tim;
	}

	public int getPozicija() {
		return pozicija;
	}

	public void setPozicija(int pozicija) {
		this.pozicija = pozicija;
	}

	public LocalTime getNajbrzi_krug() {
		return najbrzi_krug;
	}

	public void setNajbrzi_krug(LocalTime najbrzi_krug) {
		this.najbrzi_krug = najbrzi_krug;
	}

}
