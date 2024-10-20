package baza;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import glavni.Sistem_GUI;

public class Baza_proizvodjaci extends Sistem_GUI {
	
	// KLASA NAMENJENA RADU SA TABELOM PROIZVODJACI
	
	
	
	// METODA ZA ČITANJE IZ BAZE
	public static void citanje_baza() {
		
		DefaultTableModel model=  (DefaultTableModel) Tabela_proizvodjaci.getModel();
		
		try {
			// kreiranje konekcije
			Connection konekcija = Konektor_baze.kreirenje_konekcije();
			
			// kreiranje stetmenta
			Statement izjava = konekcija.createStatement();
			
			// kreiranje upita
			String sql = "SELECT * FROM sistem_maline.proizvodjac";
			
			// izvršavanje upita
			ResultSet rezultat = izjava.executeQuery(sql);
			
			while(rezultat.next()) {
				
				String red[] = {rezultat.getString(1), rezultat.getString(2), rezultat.getString(3), 
						rezultat.getString(4), rezultat.getString(5), rezultat.getString(6), rezultat.getString(7) };
				model.addRow(red);
				 
			} 
			
            System.out.println("Uspešna konekcija sa bazom - tabela proizvođaci!");

			konekcija.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvođaci");
		}
		
	}

	
	// METODA ZA UPIS U BAZU
	public static void upis_baza(String ime, String prezime, String mesto, String ulica, String broj ) {
		
		try {
			Connection konekcija = Konektor_baze.kreirenje_konekcije();
			
			String sql = "INSERT INTO `proizvodjac` (ime, prezime, mesto, ulica, broj) VALUES (?,?,?,?,?) ";
			
			PreparedStatement izjava = konekcija.prepareStatement(sql);
			
			izjava.setString(1, ime);
			izjava.setString(2, prezime);
			izjava.setString(3, mesto);
			izjava.setString(4, ulica);
			izjava.setString(5, broj);
			
			izjava.executeUpdate();
			
            System.out.println("Uspešna konekcija sa bazom - tabela proizvođaci!");
			
			izjava.close();
			konekcija.close();
			
			
			
		} catch (SQLException e) {
            System.out.println("Neuspešna konekcija sa bazom - tabela proizvođaci!");
			e.printStackTrace();
		}
		
		
		
	}
	

	// METODA ZA BRISANJE JEDNOG PROIZVOĐAČA
	public static void brisanje_proizvodjaca (int id) {
		
		String idS = ""+ id;
		
		try {
			Connection konekcija = Konektor_baze.kreirenje_konekcije();
			String sql = "DELETE FROM sistem_maline.proizvodjac WHERE IDproizvodjaca = ?";
			PreparedStatement izjava = konekcija.prepareStatement(sql);
			
			izjava.setString(1, idS);
			izjava.executeUpdate();
			
			izjava.close();
			konekcija.close();
			
            System.out.println("Uspešna konekcija sa bazom - tabela proizvođaci!");

			
		} catch (SQLException e) {
            System.out.println("Neuspešna konekcija sa bazom - tabela proizvođaci!");
			e.printStackTrace();
		}
		
		
	}

	// METODA ZA IZVLAČENJE IMENA PROIZVOĐAČA
	public static String[] prikaz_imena() {
		

		
		try  {
			
			// kreiranje konekcije
			Connection konekcija = Konektor_baze.kreirenje_konekcije();
			
			
			// kreiranje stetmenta
			Statement izjava = konekcija.createStatement();
			
			// kreiranje upita
			String sql = "SELECT IDproizvodjaca, ime, prezime FROM sistem_maline.proizvodjac";
			
			// izvršavanje upita
			ResultSet rezultat = izjava.executeQuery(sql);
			
			String proizvodjaci[] = new String[1000];
			int i = 0;
			while(rezultat.next()) {
				
				String id_ime_prezime = rezultat.getString(1) +" | "+ rezultat.getString(2) + " "+ rezultat.getString(3) ;
				proizvodjaci[i++] = id_ime_prezime;
				 
			} 
			
				
            System.out.println("Uspešna konekcija sa bazom - tabela proizvođači!");
			konekcija.close();
			
			return proizvodjaci;

			
		} catch (SQLException e) {
			
		
			e.printStackTrace();
			System.out.println("Neuspešna konekcija sa bazom - tabela proizvođači");
			return null;
		}
		
	}
		
	
	// METODA ZA IZVLAČENJE ID-a PROIZVODJACA iz stringa 
	public static int izdvajanje_id (String id_ime_prezime) {
		
		char znak = ' ';
		int indeks_znaka = id_ime_prezime.indexOf(znak);
		String idS = id_ime_prezime.substring(0,indeks_znaka);
		int id = Integer.parseInt(idS);
		
		System.out.println(id);
		return id;
	} 


	
	
	
	
	
	}





	

