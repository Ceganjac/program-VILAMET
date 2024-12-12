package baza;

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

	// TESTIRANJE
	public static void main(String args[]) {

		LocalDate datum = LocalDate.parse("2024-11-12");
		BazaIDEvidencija.upis_datuma(datum);
		
		datum = BazaIDEvidencija.citanje_datuma();
		System.out.println("TRENUTAN DATUM: "+datum);

	}

}
