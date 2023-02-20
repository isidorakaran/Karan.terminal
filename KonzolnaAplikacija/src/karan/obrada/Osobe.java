package karan.obrada;

import java.util.ArrayList;
import java.util.List;

import karan.Pomocno;
import karan.Start;
import karan.model.Osoba;

public class Osobe {
	private List<Osoba> osobe;
	private Start start;

	public Osobe(Start start) {
		super();
		this.start = start;
		osobe = new ArrayList<>();
		testPodaci();
	}

	public Osobe(List<Osoba> osobe, Start start) {
		super();
		this.osobe = osobe;
		this.start = start;
		testPodaci();
	}

	private void testPodaci() {
		//if(Pomocno.DEV) {
		osobe.add(new Osoba(1, "Ana", "Anić", "anaanic@hotmail.com", "+387665456998"));
	}
	 //}

	public void izbornik() {
		System.out.println("");
		System.out.println("Osoba izbornik: ");
		System.out.println("Dostupne opcije: ");
		System.out.println("1.Pregled svih osoba");
		System.out.println("2.Unos nove osobe");
		System.out.println("3.Promjena postojeće osobe");
		System.out.println("4.Brisanje osobe");
		System.out.println("5.Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju za osobu:", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (osobe.size() == 0) {
				System.out.println("Nema osobe koju bi mjenjali!");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if (osobe.size() == 0) {
				System.out.println("Nema osobe koju bi obrisali");
				izbornik();
			} else {
				brisanje();
			}
		case 5:
			start.glavniIzbornik();
		}
	}

	private void brisanje() {
		pregled(false);
		int redniBr = Pomocno.unosBrojaRaspon("Odaberite osobu koju želite obrisali: ", 1, osobe.size());
		osobe.remove(redniBr - 1);
		izbornik();
	}

	private void promjena() {
		pregled(false);
		int redniBr = Pomocno.unosBrojaRaspon("Unesite osobu koju želite promjeniti", 1, osobe.size());
		Osoba o = osobe.get(redniBr - 1);
		o.setIme(Pomocno.unosTeksta("Unesite ime osobe: "));
		o.setPrezime(Pomocno.unosTeksta("Unesite prezime osobe"));
		o.setEmail(Pomocno.unosTeksta("Unesite e-mail osobe: "));
		o.setBrojTelefona(Pomocno.unosTeksta("Unesite broj telefona osobe: "));
		izbornik();

	}

	private void unosNovog() {
		osobe.add(unesiNovuOsobu());
		izbornik();

	}

	private Osoba unesiNovuOsobu() {
		Osoba o = new Osoba();
		o.setSifra(Pomocno.unosBrojaRaspon("Unesite šifru osobe: ", 0, Integer.MAX_VALUE));
		o.setIme(Pomocno.unosTeksta("Unesite ime osobe: "));
		o.setPrezime(Pomocno.unosTeksta("Unesite prezime osobe: "));
		o.setEmail(Pomocno.unosTeksta("Unesite e-mail osobe: "));
		o.setBrojTelefona(Pomocno.unosTeksta("Unesite broj telefona osobe:"));
		return o;

	}

	public void pregled(boolean prikaziIzbornik) {
		System.out.println("*** Osobe u aplikaciji ***");
		System.out.println("------------------");
		int redniBr = 1;
		for (Osoba o : osobe) {
			System.out.println(redniBr++ + ". " + o);
		}
		System.out.println("------------------");
		if (prikaziIzbornik) {
			izbornik();
		}
	}

	public List<Osoba> getOsobe() {
		return osobe;
	}

	public void setOsobe(List<Osoba> osobe) {
		this.osobe = osobe;
	}

}
