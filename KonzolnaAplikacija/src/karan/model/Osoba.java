package karan.model;

public class Osoba extends Entitet {
	private String ime;
	private String prezime;
	private String email;
	private String brojTelefona;

	public Osoba() {
		super();
	}

	public Osoba(int sifra, String ime, String prezime, String email, String brojTelefona) {
		super(sifra);
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.brojTelefona = brojTelefona;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

}
