package karan.obrada;

import java.util.ArrayList;
import java.util.List;

import karan.Pomocno;
import karan.Start;
import karan.model.Osoba;
import karan.model.VrstaTransakcije;

public class VrsteTransakcije {
	private List<VrstaTransakcije> vrsteTransakcije;
	private Start start;

	public VrsteTransakcije(Start start) {
		super();
		this.start = start;
		vrsteTransakcije = new ArrayList<>();
		testPodaci();
	}

	private void testPodaci() {
vrsteTransakcije.add(new VrstaTransakcije(1, "ulaz"));
	}

	public VrsteTransakcije(List<VrstaTransakcije> vrsteTransakcije, Start start) {
		super();
		this.vrsteTransakcije = vrsteTransakcije;
		this.start = start;
	testPodaci();
	}

	public void izbornik() {
		System.out.println("");
		System.out.println("Vrste transakcije izbornik: ");
		System.out.println("Dostupne opcije: ");
		System.out.println("1.Pregled svih vrsta transakcije");
		System.out.println("2.Unos nove vrste transakcije");
		System.out.println("3.Promjena postojeće vrste transakcije");
		System.out.println("4.Brisanje vrste transakcije");
		System.out.println("5.Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju za vrstu transakcije:", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (vrsteTransakcije.size() == 0) {
				System.out.println("Nema vrste transakcije koju bi mjenjali!");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if (vrsteTransakcije.size() == 0) {
				System.out.println("Nema vrste transakcije koju bi obrisali");
				izbornik();
			} else {
				brisanje();
			}
		case 5:
			// povezati sa glavnim izbornikom u startu
		}
	}

	private void brisanje() {
		pregled(false);
		int redniBr = Pomocno.unosBrojaRaspon("Odaberite vrstu transakcije koju želite obrisati:", 1,
				vrsteTransakcije.size());
		vrsteTransakcije.remove(redniBr - 1);
		izbornik();

	}

	private void promjena() {
		pregled(false);
		int redniBr = Pomocno.unosBrojaRaspon("Unesite vrstu transakcije koju želite promjeniti", 1,
				vrsteTransakcije.size());
		VrstaTransakcije vt = vrsteTransakcije.get(redniBr - 1);
		vt.setNaziv(Pomocno.unosTeksta("Unesite naziv vrste transakcije: "));
		izbornik();
	}

	private void unosNovog() {
		vrsteTransakcije.add(unesiNovuVrstuTransakcije());
		izbornik();

	}

	private VrstaTransakcije unesiNovuVrstuTransakcije() {
		VrstaTransakcije vt = new VrstaTransakcije();
		vt.setSifra(Pomocno.unosBrojaRaspon("Unesi šifru vrste transakcije", 0, Integer.MAX_VALUE));
		vt.setNaziv(Pomocno.unosTeksta("Unesi naziv vrste transakcije: "));
		return vt;
	}

	public void pregled(boolean prikaziIzbornik) {
		System.out.println("*** Vrste transakcije u aplikaciji ***");
		System.out.println("------------------");
		int redniBr = 1;
		for (VrstaTransakcije vt : vrsteTransakcije) {
			System.out.println(redniBr++ + ". " + vt);
		}
		System.out.println("------------------");
		if (prikaziIzbornik) {
			izbornik();
		}
	}

	public List<VrstaTransakcije> getVrsteTransakcije() {
		return vrsteTransakcije;
	}

	public void setVrsteTransakcije(List<VrstaTransakcije> vrsteTransakcije) {
		this.vrsteTransakcije = vrsteTransakcije;
	}

}
