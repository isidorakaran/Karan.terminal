package karan.model;

import java.util.Date;

public class Transakcija extends Entitet{
private Date datum;
private String opis;
private String napomena;
private Osoba osoba;
private VrstaTransakcije vrstaTransakcije;

public Transakcija() {
	super();
}
public Transakcija(int sifra, Date datum, String opis, String napomena, Osoba osoba,
		VrstaTransakcije vrstaTransakcije) {
	super(sifra);
	this.datum = datum;
	this.opis = opis;
	this.napomena = napomena;
	this.osoba = osoba;
	this.vrstaTransakcije = vrstaTransakcije;
}
public Date getDatum() {
	return datum;
}
public void setDatum(Date datum) {
	this.datum = datum;
}
public String getOpis() {
	return opis;
}
public void setOpis(String opis) {
	this.opis = opis;
}
public String getNapomena() {
	return napomena;
}
public void setNapomena(String napomena) {
	this.napomena = napomena;
}
public Osoba getOsoba() {
	return osoba;
}
public void setOsoba(Osoba osoba) {
	this.osoba = osoba;
}
public VrstaTransakcije getVrstaTransakcije() {
	return vrstaTransakcije;
}
public void setVrstaTransakcije(VrstaTransakcije vrstaTransakcije) {
	this.vrstaTransakcije = vrstaTransakcije;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return datum + opis + napomena;
	}

}
