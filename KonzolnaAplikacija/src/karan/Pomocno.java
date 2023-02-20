package karan;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pomocno {
	public static Scanner ulaz;
	public static boolean DEV;

	public static int unosBrojaRaspon(String poruka, int min, int max) {
		int i;
		while (true) {
			try {
				System.out.println(poruka);
				i = Integer.parseInt(ulaz.nextLine());
				if (i < min || i > max) {
					System.out.println("Broj mora biti izmeđe " + min + " i " + max);
					continue;
				}
				return i;
			} catch (Exception e) {
				System.out.println("Niste unijeli broj");

			}

		}

	}

	public static String unosTeksta(String poruka) {
		String s;
		while (true) {
			System.out.println(poruka);
			s = ulaz.nextLine();
			if (s.trim().isEmpty()) {
				System.out.println("Obavezan unos!");
				continue;
			}
			return s;
		}
	}

	public static boolean unesiDaNe(String poruka) {
		boolean daNe = false;
		do {
			System.out.println(poruka);
			String s = ulaz.nextLine();
			if (s.equals("da")) {
				daNe = true;
				break;
			}
			if (s.equals("ne")) {
				daNe = false;
				break;
			}
			System.out.println("Neispravan unos!");

		} while (true);
		return daNe;
	}

	public static int unesiCijeliBroj(String poruka) {
		while (true) {
			try {
				System.out.println(poruka);
				return Integer.parseInt(ulaz.nextLine());
			} catch (Exception e) {
				System.out.println("Neispravan unos!");
			}
		}
	}

	public static BigDecimal unesiDecimalnuVrijednost(String poruka) {
		System.out.println(poruka);
		String s = ulaz.nextLine();
		return new BigDecimal(s);
	}

	public static Date unosDatuma(String poruka) {
		System.out.println(poruka);
		String date = ulaz.nextLine();
		Date dateFinal;
		while (true) {
			try {
				dateFinal = new SimpleDateFormat("dd.MM.yyyy.").parse(date);
				return dateFinal;
			} catch (Exception e) {
				System.out.println("Pogrešan unos datuma!");
			}
		}
	}
}
