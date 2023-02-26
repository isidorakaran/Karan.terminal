package karan.obrada;

import java.util.ArrayList;
import java.util.List;

import karan.Pomocno;
import karan.Start;
import karan.model.Osoba;
import karan.model.Transakcija;
import karan.model.VrstaTransakcije;

public class Transakcije {
	private List<Transakcija> transakcije;
	private Start start;

	public Transakcije(Start start) {
		super();
		this.start = start;
		transakcije = new ArrayList<>();
		testPodaci();
	}

	public Transakcije(List<Transakcija> transakcije, Start start) {
		super();
		this.transakcije = transakcije;
		this.start = start;
		testPodaci();
	}

	private void testPodaci() {
		// if(Pomocno.DEV) {
		transakcije.add(new Transakcija(1,null, "opis neki", "neka napomena",
				new Osoba(1, "Pero", "Perić", "email", "broj"), new VrstaTransakcije(1, "Ulaz")));

	}
	// }

	public void izbornik() {
		System.out.println("");
		System.out.println("Transakcija izbornik: ");
		System.out.println("Dostupne opcije: ");
		System.out.println("1.Pregled svih transakcija");
		System.out.println("2.Unos nove transakcije");
		System.out.println("3.Promjena postojeće transakcije");
		System.out.println("4.Brisanje transakcije");
		System.out.println("5.Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju za transakciju:", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unesiNovu();
			break;
		case 3:
			if (transakcije.size() == 0) {
				System.out.println("Nema transakcije koju bi mjenjali!");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if (transakcije.size() == 0) {
				System.out.println("Nema transakcije koju bi obrisali");
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
		int redniBr = Pomocno.unosBrojaRaspon("Odaberite transakciju koju želite obrisali: ", 1, transakcije.size());
		transakcije.remove(redniBr - 1);
		izbornik();
	}

	private void promjena() {
		pregled(false);
		int redniBr = Pomocno.unosBrojaRaspon("Unesite transakciju koju želite promjeniti", 1, transakcije.size());
		Transakcija t = transakcije.get(redniBr - 1);
		t.setDatum(Pomocno.unosDatuma("dd.mm.yyyy."));
		t.setOpis(Pomocno.unosTeksta("Unesite opis transakcije"));
		t.setNapomena(Pomocno.unosTeksta("Unesite napomenu za transakciju:"));
		start.getOsobe().pregled(false);
		int i = Pomocno.unosBrojaRaspon("Unesite koja osoba učestvuje u transakciji", 1,
				start.getOsobe().getOsobe().size());
		t.setOsoba(start.getOsobe().getOsobe().get(i - 1));
		start.getVrsteTransakcije().pregled(false);
		int j = Pomocno.unosBrojaRaspon("Unesite vrstu transakcije: ", 1,
				start.getVrsteTransakcije().getVrsteTransakcije().size());
		t.setVrstaTransakcije(start.getVrsteTransakcije().getVrsteTransakcije().get(i - 1));
		izbornik();

	}

	private void unesiNovu() {
		Transakcija t = new Transakcija();
		t.setSifra(Pomocno.unosBrojaRaspon("Unesi novu transakciju: ", 0, Integer.MAX_VALUE));
		t.setDatum(Pomocno.unosDatuma("Unesi datum: "));
		t.setOpis(Pomocno.unosTeksta("Unesi opis transakcije: "));
		t.setNapomena(Pomocno.unosTeksta("Unesite napomenu vezanu za transakciju:"));
		start.getOsobe().pregled(false);
		int i = Pomocno.unosBrojaRaspon("Unesite osobu vezanu za transakciju", 1, start.getOsobe().getOsobe().size());
		t.setOsoba(start.getOsobe().getOsobe().get(i - 1));

		transakcije.add(t);
		izbornik();

	}

	public void pregled(boolean prikaziIzbornik) {
		System.out.println("*** Transakcije u aplikaciji ***");
		System.out.println("------------------");
		int redniBr = 1;
		for (Transakcija t : transakcije) {
			System.out.println(redniBr++ + ". " + t);
		}
		System.out.println("------------------");
		if (prikaziIzbornik) {
			izbornik();
		}
	}

	public List<Transakcija> getTransakcije() {
		return transakcije;
	}

	public void setTransakcije(List<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}

}
