package formula1.model;

import java.util.List;

public class Sezone extends Entitet {

	private int godina;
	private Vozaci vozac;
	private List<Staze> staze;

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public Vozaci getVozac() {
		return vozac;
	}

	public void setVozac(Vozaci vozac) {
		this.vozac = vozac;
	}

	public List<Staze> getStaze() {
		return staze;
	}

	public void setStaze(List<Staze> staze) {
		this.staze = staze;
	}

}
