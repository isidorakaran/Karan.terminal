package karan.obrada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import karan.Pomocno;
import karan.Start;

import karan.model.Pas;

public class Psi {
	private List<Pas> psi;
	private Start start;

	public Psi(Start start) {
		super();
		this.start = start;
		psi = new ArrayList<>();
		testPodaci();
	}

	public Psi(List<Pas> psi, Start start) {
		super();
		this.psi = psi;
		this.start = start;
		testPodaci();
	}

	private void testPodaci() {
		// if(Pomocno.DEV) {
psi.add(new Pas(1, false, "Bobi", "muški", 2, new BigDecimal(12.2), null));
	}
// }

	public void izbornik() {
		System.out.println("");
		System.out.println("Pas izbornik: ");
		System.out.println("Dostupne opcije: ");
		System.out.println("1.Pregled svih pasa");
		System.out.println("2.Unos novog psa");
		System.out.println("3.Promjena postojećeg psa");
		System.out.println("4.Brisanje psa");
		System.out.println("5.Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju za psa:", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			// unesiNovu();
			break;
		case 3:
			if (psi.size() == 0) {
				System.out.println("Nema psa kojeg bi mjenjali!");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if (psi.size() == 0) {
				System.out.println("Nema psa kojeg bi obrisali");
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
		int redniBr = Pomocno.unosBrojaRaspon("Odaberite psa kojeg želite obrisati: ", 1, psi.size());
		psi.remove(redniBr - 1);
		izbornik();
	}

	private void promjena() {
		pregled(false);
		int redniBr = Pomocno.unosBrojaRaspon("Unesite psa kojeg želite promjeniti", 1, psi.size());
		Pas p = psi.get(redniBr - 1);
		p.setMjesavina(Pomocno.unesiDaNe("Unesite je li pas mješanac ili ne:"));
		p.setIme(Pomocno.unosTeksta("Unesite ime psa:"));
		p.setPol(Pomocno.unosTeksta("Unesite pol psa:"));
		p.setDob(Pomocno.unesiCijeliBroj("Unesite koliko pas ima godina:"));
		p.setKilaza(Pomocno.unesiDecimalnuVrijednost("Unesite koliko pas ima kila:"));
		p.getTransakcije().clear();
		while (true) {

			start.getTransakcije().pregled(false);
			int i = Pomocno.unosBrojaRaspon("Unesite transakciju", 1, start.getTransakcije().getTransakcije().size());

			p.getTransakcije().add(start.getTransakcije().getTransakcije().get(i - 1));
			if (Pomocno.unosBrojaRaspon("0 za kraj dodavanja transakcije", 0, Integer.MAX_VALUE) == 0) {
				break;

			}
		}
		izbornik();
	}

	/*
	 * private void unesiNovu() { Transakcija t = new Transakcija();
	 * t.setSifra(Pomocno.unosBrojaRaspon("Unesi novu transakciju: ", 0,
	 * Integer.MAX_VALUE)); t.setDatum(Pomocno.unosDatuma("Unesi datum: "));
	 * t.setOpis(Pomocno.unosTeksta("Unesi opis transakcije: "));
	 * t.setNapomena(Pomocno.unosTeksta("Unesite napomenu vezanu za transakciju:"));
	 * start.getOsobe().pregled(false); int i =
	 * Pomocno.unosBrojaRaspon("Unesite osobu vezanu za transakciju", 1,
	 * start.getOsobe().getOsobe().size());
	 * t.setOsoba(start.getOsobe().getOsobe().get(i - 1));
	 * 
	 * transakcije.add(t); izbornik();
	 * 
	 * }
	 */

	private void pregled(boolean prikaziIzbornik) {
		System.out.println("*** Psi u aplikaciji ***");
		System.out.println("------------------");
		int redniBr = 1;
		for (Pas p : psi) {
			System.out.println(redniBr++ + ". " + p);
		}
		System.out.println("------------------");
		if (prikaziIzbornik) {
			izbornik();
		}
	}

	public List<Pas> getPsi() {
		return psi;
	}

	public void setPsi(List<Pas> psi) {
		this.psi = psi;
	}

}
