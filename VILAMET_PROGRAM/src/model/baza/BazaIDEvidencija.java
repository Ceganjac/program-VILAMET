package model.baza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;

public class BazaIDEvidencija {

	// METODA ZA UPIS DATUMA POSLEDNJEG UPISA BRANJA
	public static void upis_datuma(LocalDate datum) {

		try {

			Connection konekcija = KonektorBaze.kreirenje_konekcije(); // uzimanje konekcije od klase Konektor_baze
			String sql = "UPDATE sistem_maline.id_evidencija SET poslednji_datum=? WHERE ID=1"; // izgled sql upita

			PreparedStatement pst = konekcija.prepareStatement(sql);

			pst.setDate(1, java.sql.Date.valueOf(datum));
			pst.executeUpdate();

			System.out.println("Uspešan update poslednjeg datuma - tabela id_evidencija !");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Neuspešan update poslednjeg datuma - tabela id_evidencija!");
		}

	}

	// METODA ZA ČITANJE DATUMA POSLEDNJEG UPISA BRANJA
	public static LocalDate citanje_datuma() {
		LocalDate datum = null;

		try {

			Connection konekcija = KonektorBaze.kreirenje_konekcije(); // uzimanje konekcije od klase Konektor_baze
			String sql = "SELECT poslednji_datum FROM sistem_maline.id_evidencija WHERE ID=1";
			Statement izjava = konekcija.createStatement();

			ResultSet rezultat = izjava.executeQuery(sql);

			while (rezultat.next()) {
				datum = LocalDate.parse(rezultat.getString(1));
			}
			System.out.println("Uspešno čitanje poslednjeg datuma - tabela id_evidencija !");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Neuspešno čitanje poslednjeg datuma - tabela id_evidencija !");
		}

		return datum;

	}

	// METODA ZA UPIS REDNOG BROJA
	public static void upis_redni(int redni_br) {
		try {

			Connection konekcija = KonektorBaze.kreirenje_konekcije(); // uzimanje konekcije od klase Konektor_baze
			String sql = "UPDATE sistem_maline.id_evidencija SET redni_broj=? WHERE ID=1"; // izgled sql upita
			PreparedStatement pst = konekcija.prepareStatement(sql);

			pst.setInt(1, redni_br);
			pst.executeUpdate();

			System.out.println("Uspešan update poslednjeg rednog broja - tabela id_evidencija !");


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Neuspešan update poslednjeg datuma - tabela id_evidencija!");
		}
	}
	
	// METODA ZA ČITANJE REDNOG BROJA
	public static int citanje_redni() {
		int redni_br = 0;

		try {

			Connection konekcija = KonektorBaze.kreirenje_konekcije(); // uzimanje konekcije od klase Konektor_baze
			String sql = "SELECT redni_broj FROM sistem_maline.id_evidencija WHERE ID=1";
			Statement izjava = konekcija.createStatement();

			ResultSet rezultat = izjava.executeQuery(sql);

			while (rezultat.next()) {
				redni_br = Integer.parseInt(rezultat.getString(1));
			}
			System.out.println("Uspešno čitanje poslednjeg rednog broja - tabela id_evidencija !");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Neuspešno čitanje poslednjeg rednog broja - tabela id_evidencija !");
		}

		return redni_br;
	}
	
	
	// TESTIRANJE
	public static void main(String args[]) {

		int redni_br = citanje_redni();
		System.out.println("Poslednji redni broj je: " + redni_br);

	}

}
