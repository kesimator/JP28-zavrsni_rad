package formula1.model;

import java.util.Date;

public class Utrke extends Entitet {

	private Staze staza;
	private Sezone sezona;
	private Date datum_i_vrijeme;

	public Utrke() {

	}

	public Utrke(int id, Staze staza, Sezone sezona, Date datum_i_vrijeme) {
		super(id);
		this.staza = staza;
		this.sezona = sezona;
		this.datum_i_vrijeme = datum_i_vrijeme;
	}

	public Staze getStaza() {
		return staza;
	}

	public void setStaza(Staze staza) {
		this.staza = staza;
	}

	public Sezone getSezona() {
		return sezona;
	}

	public void setSezona(Sezone sezona) {
		this.sezona = sezona;
	}

	public Date getDatum_i_vrijeme() {
		return datum_i_vrijeme;
	}

	public void setDatum_i_vrijeme(Date datum_i_vrijeme) {
		this.datum_i_vrijeme = datum_i_vrijeme;
	}

}
