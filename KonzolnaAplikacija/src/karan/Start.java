package karan;

import java.util.Scanner;

import karan.obrada.Osobe;
import karan.obrada.Psi;
import karan.obrada.Transakcije;
import karan.obrada.VrsteTransakcije;

public class Start {
private Osobe osobe;
private Transakcije transakcije;
private VrsteTransakcije vrsteTransakcije;
private Psi psi;

public Start() {
	Pomocno.ulaz = new Scanner(System.in);
	osobe = new Osobe(this);
	transakcije=new Transakcije(this);
	vrsteTransakcije= new VrsteTransakcije(this);
	psi=new Psi(this);
	
	pozdravnaPoruka();
	glavniIzbornik();
}


public void glavniIzbornik() {
	System.out.println("");
	System.out.println("**GLAVNI IZBORNIK**");
	System.out.println("Dostupne opcije");
	System.out.println("1. Osoba");
	System.out.println("2. Vrsta transakcije");
	System.out.println("3. Transakcije");
	System.out.println("4.Psi");
	System.out.println("5. Izlaz iz programa");
	odabirGlavnogIzbornika();
	pozdravnaPoruka();
}

private void odabirGlavnogIzbornika() {
switch(Pomocno.unosBrojaRaspon("Odaberi opciju", 1, 4)) {
case 1:
	osobe.izbornik();
case 2:
	vrsteTransakcije.izbornik();
case 3:
	transakcije.izbornik();
case 4:
	psi.izbornik();
case 5:
	System.out.println("Doviđenja");
	break;
}
}

private void pozdravnaPoruka() {
	System.out.println("Dobrodošli u Azil za pse terminal aplikaciju");

}


public Osobe getOsobe() {
	return osobe;
}


public void setOsobe(Osobe osobe) {
	this.osobe = osobe;
}

public Transakcije getTransakcije() {
	return transakcije;
}

public void setTransakcije(Transakcije transakcije) {
	this.transakcije=transakcije;
}


public VrsteTransakcije getVrsteTransakcije() {
	return vrsteTransakcije;
}


public void setVrsteTransakcije(VrsteTransakcije vrsteTransakcije) {
	this.vrsteTransakcije = vrsteTransakcije;
}
public Psi getPsi() {
	return psi;
}
public void setPsi(Psi psi) {
	this.psi=psi;
}
public static void main(String[] args) {
	if (args.length == 1) {
		Pomocno.DEV = true;
	} else {
		Pomocno.DEV = false;
	}
	new Start();
}

}
