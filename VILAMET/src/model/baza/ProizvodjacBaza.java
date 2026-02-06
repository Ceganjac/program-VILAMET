package model.baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.domen.Proizvodjac;
import pogled.paneli.ProizvodPanel;
import pogled.paneli.ProizvodjacPanel;

public class ProizvodjacBaza extends ProizvodjacPanel {

	// KLASA NAMENJENA RADU SA TABELOM proizvodjac

	List<String[]> lista = new ArrayList<String[]>();

	public List<String[]> citanjeSvih() {

		// model tabele proizvod iz Sistem_GUI

		try {
			// kreiranje konekcije
			Connection konekcija = KonektorBaze.kreirenje_konekcije();

			// kreiranje stetmenta
			Statement izjava = konekcija.createStatement();

			// kreiranje upita
			String sql = "SELECT * FROM baza_vilamet.proizvodjac";

			// izvršavanje upita
			ResultSet rezultat = izjava.executeQuery(sql);

			while (rezultat.next()) {

				String red[] = { rezultat.getString(1), rezultat.getString(3), rezultat.getString(4),
						rezultat.getString(5), rezultat.getString(6), rezultat.getString(7) };
				lista.add(red);
			}

			System.out.println("Uspešna konekcija sa bazom - tabela proizvodjac - citanjeSvih!");
			konekcija.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvodjac - citanjeSvih!");
		}
		return lista;

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void citanjeId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje(Proizvodjac proizvodjac) {

		try {
			Connection konekcija = KonektorBaze.kreirenje_konekcije();

			String sql = "INSERT INTO baza_vilamet.`proizvodjac` (ime, prezime,`mesto_grad`, selo, ulica_broj) VALUES (?,?,?,?,?) ";

			PreparedStatement izjava = konekcija.prepareStatement(sql);

			izjava.setString(1, proizvodjac.getIme());
			izjava.setString(2, proizvodjac.getPrezime());
			izjava.setString(3, proizvodjac.getMestoGrad());
			izjava.setString(4, proizvodjac.getSelo());
			izjava.setString(5, proizvodjac.getUlicaBroj());

			izjava.executeUpdate();

			System.out.println("Uspešna konekcija sa bazom - tabela proizvodjac - upis !");

			izjava.close();
			konekcija.close();

		} catch (SQLException e) {
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvodjac - upis !");
			e.printStackTrace();
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String id) {


		try {
			Connection konekcija = KonektorBaze.kreirenje_konekcije();
			String sql = "DELETE FROM baza_vilamet.proizvodjac WHERE id = ?";
			PreparedStatement izjava = konekcija.prepareStatement(sql);

			izjava.setString(1, id);
			izjava.executeUpdate();

			izjava.close();
			konekcija.close();

			System.out.println("Uspešna konekcija sa bazom - tabela proizvodjac - brisanje !");

		} catch (SQLException e) {
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvodjac - brisanje !");
			e.printStackTrace();
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// METODA ZA IZVLAČENJE IMENA PROIZVOĐAČA
	public String[] prikazImena() {

		try {

			// kreiranje konekcije
			Connection konekcija = KonektorBaze.kreirenje_konekcije();

			// kreiranje stetmenta
			Statement izjava = konekcija.createStatement();

			// kreiranje upita
			String sql = "SELECT IDproizvodjaca, ime, prezime FROM baza_vilamet.proizvodjac";

			// izvršavanje upita
			ResultSet rezultat = izjava.executeQuery(sql);

			String proizvodjaci[] = new String[1000];
			int i = 0;
			while (rezultat.next()) {

				String id_ime_prezime = rezultat.getString(1) + " | " + rezultat.getString(2) + " "
						+ rezultat.getString(3);
				proizvodjaci[i++] = id_ime_prezime;

			}

			System.out.println("Uspešna konekcija sa bazom - tabela proizvodjac - prikazImena!");
			konekcija.close();

			return proizvodjaci;

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvodjac - prikazImena");
			String niz[] = new String[0];
			return niz;
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// METODA ZA IZVLAČENJE ID-a PROIZVODJACA iz stringa
	public int izdvajanjeID(String id_ime_prezime) {

		char znak = ' ';
		int indeks_znaka = id_ime_prezime.indexOf(znak);
		String idS = id_ime_prezime.substring(0, indeks_znaka);
		int id = Integer.parseInt(idS);

		System.out.println(id);
		return id;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
