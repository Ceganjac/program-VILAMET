package model.baza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.entiteti.Proizvod;
import pogled.proizvod.PanelProizvod;

public class BazaProizvod {

	// KLASA NAMENJENA RADU SA TABELOM PROIZVOD

	// METODA ZA ČITANJE IZ BAZE

	List<String[]> lista = new ArrayList<String[]>();

	public List<String[]> citanjeSvih() {

		String sql = "SELECT * FROM baza_vilamet.pregled_proizvoda;";
		lista.clear();

		// Korišćenje try-with-resources za automatsko zatvaranje konekcije i
		// statement-a
		try (Connection konekcija = KonektorBaze.kreirenje_konekcije();
				Statement izjava = konekcija.createStatement()) {

			ResultSet rezultat = izjava.executeQuery(sql); // Izvršavanje upita i dobijanje ResultSet-a
			while (rezultat.next()) {
				String red[] = { rezultat.getString(1), rezultat.getString(2) };
				lista.add(red);
			}
			System.out.println("Uspešna konekcija sa bazom - tabela proizvod - citanjeSvih !");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvod - citanjeSvih ! ");
		}
		return lista;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// METODA ZA UNOS PROIZVODA U BAZU
	public static void dodavanje(Proizvod proizvod) {

		try {
			Connection konekcija = KonektorBaze.kreirenje_konekcije();
			String sql = "INSERT INTO baza_vilamet.proizvod ( naziv, vrsta) VALUES ( ?, ?)";
			PreparedStatement pst = konekcija.prepareStatement(sql);

			pst.setString(1, proizvod.getNaziv());
			pst.setString(2, proizvod.getVrsta());
			pst.executeUpdate();

			pst.close();
			konekcija.close();

			System.out.println("Uspešna konekcija sa bazom - tabela proizvod - upis !");

		} catch (SQLException e) {
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvod - upis !!");
			e.printStackTrace();
		}

	}

	// METODA ZA IZVLAČENJE NAZIVA I VRSTE
	public static String[] idProizvodaBaza() {

		try {

			Connection konekcija = KonektorBaze.kreirenje_konekcije();
			Statement stm = konekcija.createStatement();
			String sql = "SELECT IDProizvoda, proizvod FROM pregled_proizvoda; ";

			ResultSet rezultat = stm.executeQuery(sql);
			String[] proizvodi = new String[100];
			int i = 0; // brojac
			String proizvod;

			while (rezultat.next()) {
				proizvod = rezultat.getString(1) + " | " + rezultat.getString(2);
				proizvodi[i++] = proizvod;
			}

			stm.close(); // zatvaranje statement-a
			konekcija.close();
			System.out.println("Uspešna konekcija sa bazom - tabela proizvod !");

			return proizvodi;

		} catch (SQLException e) {
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvod  !");
			e.printStackTrace();
		}

		return null;
	}

	// METODA ZA BRISANJE PROIZVODA IZ BAZE
	public static void brisanje(String id) {
		
		System.out.println("Indeks: "+id);

		try {
			Connection konekcija = KonektorBaze.kreirenje_konekcije();
			String sql = "DELETE FROM baza_vilamet.proizvod WHERE id = ?";
			PreparedStatement pst = konekcija.prepareStatement(sql);

			pst.setString(1, id);
			pst.executeUpdate();

			pst.close();
			konekcija.close();
			System.out.println("Uspešna konekcija sa bazom - tabela proizvod - brisanje !");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvod! - brisanje ");

		}

	}

	// METODA ZA IZVLAČENJE ID-a PROIZVOD IZ PRIKAZA KOJI JE U padajucoj listi
	public static int izvlacenjeID(String id_proizvod) {

		char praznina = ' ';
		int indeks_znaka = id_proizvod.indexOf(praznina);
		int ID_proizvoda = Integer.parseInt(id_proizvod.substring(0, indeks_znaka));

		System.out.println("Id proizvoda je" + ID_proizvoda);

		return ID_proizvoda;

	}
	
	

}
