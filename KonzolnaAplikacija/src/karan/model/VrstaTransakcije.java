package karan.model;

public class VrstaTransakcije extends Entitet{
	private String naziv;

	public VrstaTransakcije() {
		super();
	}

	public VrstaTransakcije(int sifra, String naziv) {
		super(sifra);
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	

}
