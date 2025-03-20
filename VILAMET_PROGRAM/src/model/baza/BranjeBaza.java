package model.baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import pomocni.SistemGUI;

public class BranjeBaza extends SistemGUI {

	// KLASA NAMENJENA RADU SA TABELOM branje

	List<String[]> lista = new ArrayList<String[]>();

	public void citanjeSvih() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void citanjeId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje(String id, LocalDate datum, int ulaz1, int ulaz2, double bruto, double tara, double neto,
			double cena, double iznos, int id_proiz, int id_proizvoda) {

		Tabela_branja.getModel();

		try {
			// kreiranje konekcije
			Connection konekcija = KonektorBaze.kreirenje_konekcije();

			// SQL upit sa PreparedStatement
			String sql = "INSERT INTO `branje` (`IDbranja`, `Datum`, `Ulaz 0.4`, `Ulaz 0.5`, `Bruto`, `Tara`, `Neto`, `Cena`, `Iznos`,`IDproizvodjaca`,`IDProizvoda` ) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// kreiranje stejtmenta
			PreparedStatement izjava = konekcija.prepareStatement(sql);

			// Postavljanje parametara
			izjava.setString(1, id);

			if (datum == null) {
				throw new IllegalArgumentException("Datum ne može biti null");
			}

			izjava.setDate(2, java.sql.Date.valueOf(datum)); // Pretvara LocalDate u java.sql.Date

			izjava.setInt(3, ulaz1);
			izjava.setInt(4, ulaz2);
			izjava.setDouble(5, bruto);
			izjava.setDouble(6, tara);
			izjava.setDouble(7, neto);
			izjava.setDouble(8, cena);
			izjava.setDouble(9, iznos);
			izjava.setInt(10, id_proiz);
			izjava.setInt(11, id_proizvoda);

			// Izvršavanje upita
			izjava.executeUpdate();

			// Zatvaranje resursa
			izjava.close();
			konekcija.close();

			// obrada greške za korisnika

			System.out.println("Uspešna konekcija sa bazom - tabela branja - upis !");

		} catch (

		SQLException e) {
			System.out.println("Neuspešna konekcija sa bazom - tabela branja - upis !");

			e.printStackTrace();
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String id_broj) {

		try {
			// kreiranje konekcije
			Connection konekcija = KonektorBaze.kreirenje_konekcije();

			// kreiranje sql upita
			String sql = "DELETE FROM sistem_maline.branje WHERE branje.IDbranja = ?";

			// kreiranje prepared stejtmenta
			PreparedStatement izjava = konekcija.prepareStatement(sql);

			// postavljanje parametra
			izjava.setString(1, id_broj);

			// izvršavenje upita
			izjava.executeUpdate();

			// zatvaranje konekcije
			izjava.close();
			konekcija.close();

			System.out.println("Uspešna konekcija sa bazom - tabela branja - brisanje !");

		} catch (SQLException e) {
			System.out.println("Neuspešna konekcija sa bazom - tabela branja - brisanje!");
			e.printStackTrace();
		}

	}

}
