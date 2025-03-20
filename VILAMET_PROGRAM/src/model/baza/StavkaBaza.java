package model.baza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entiteti.Proizvod;

public class StavkaBaza {
	
	// KLASA NAMENJENA RADU SA TABELOM stavka_branja

	List<String[]> lista = new ArrayList<String[]>();

	public List<String[]> citanjeSvih() {
		return lista;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void citanjeId() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void dodavanje(Proizvod proizvod) {

		try {
			Connection konekcija = KonektorBaze.kreirenje_konekcije();
			String sql = "INSERT INTO baza_vilamet.stavka_branja ( naziv, vrsta) VALUES ( ?, ?)";
			PreparedStatement pst = konekcija.prepareStatement(sql);

			pst.setString(1, proizvod.getNaziv());
			pst.setString(2, proizvod.getVrsta());
			pst.executeUpdate();

			pst.close();
			konekcija.close();

			System.out.println("Uspešna konekcija sa bazom - tabela stavka_branja - upis !");

		} catch (SQLException e) {
			System.out.println("Neuspešna konekcija sa bazom - tabela stavka_branja - upis !!");
			e.printStackTrace();
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void izmena() {

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void brisanje(String id) {

		System.out.println("Indeks: " + id);

		try {
			Connection konekcija = KonektorBaze.kreirenje_konekcije();
			String sql = "DELETE FROM baza_vilamet.stavka_branja WHERE id = ?";
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
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
