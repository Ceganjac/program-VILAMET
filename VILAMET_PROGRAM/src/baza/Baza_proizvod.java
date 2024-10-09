package baza;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import glavni.Sistem_GUI;

public class Baza_proizvod extends Sistem_GUI{
	
	// KLASA NAMENJENA RADU SA TABELOM PROIZVOD
	
	
		static String url = "jdbc:mysql://localhost:3306/sistem_maline";  //putanja baze podataka
		static String korisnicko_ime = "root";  // korisnicko ime
		static String sifra = "";
		
	// METODA ZA ČITANJE IZ BAZE
		public static void citanje_baza()   {
			
			// model tabele proizvod iz Sistem_GUI
			DefaultTableModel model=  (DefaultTableModel) Tabela_proizvod.getModel();

			
			try {
				
				
				
				Connection konekcija = DriverManager.getConnection(url, korisnicko_ime,sifra);  // kreiranje konekcije
				Statement izjava =  konekcija.createStatement();  // kreiranje statement-a
				ResultSet rezultat = izjava.executeQuery("SELECT * FROM sistem_maline.pregled_proizvoda ;"); // izvršavanje upita
				
				while(rezultat.next()) {
					String red[] = {rezultat.getString(1), rezultat.getString(2) };
					model.addRow(red);
				} 
				
				System.out.println("USPEŠNA konekcija sa tabelom Proizvod - citanje iz baze !");
				konekcija.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("NEUSPEŠNA konekcija sa tabelom Proizvod - citanje iz baze !");
			}
			
		}
		
	// METODA ZA UNOS PROIZVODA U BAZU
		public static void upis_baza(String naziv, String vrsta) {
			
			try {
				Connection konekcija = DriverManager.getConnection(url, korisnicko_ime, sifra);
				String sql = "INSERT INTO sistem_maline.proizvod ( naziv, vrsta) VALUES ( ?, ?)";
				PreparedStatement pst = konekcija.prepareStatement(sql);
				
				pst.setString(1,naziv);
				pst.setString(2, vrsta);
				pst.executeUpdate();
				
				pst.close();
				konekcija.close();
				
				System.out.println("USPEŠNA konekcija sa tabelom Proizvod - unos novog proizvoda !");
				
				
			} catch (SQLException e) {
				System.out.println("NEUSPEŠNA konekcija sa tabelom Proizvod - unos novog proizvoda !");
				e.printStackTrace();
			}
			
			
		}

	// METODA ZA IZVLAČENJE NAZIVA I VRSTE
		public static String[] id_proizvod_baza() {
			
			try {
				
				Connection konekcija = DriverManager.getConnection(url, korisnicko_ime, sifra);
				Statement stm = konekcija.createStatement();
				String sql = "SELECT IDProizvoda, proizvod FROM pregled_proizvoda; ";
				
				ResultSet rezultat = stm.executeQuery(sql);
				String[] proizvodi = new String[100];
				int i = 0;  // brojac
				String proizvod;
				
				while(rezultat.next()) {
					 proizvod = rezultat.getString(1) + " | " + rezultat.getString(2);
					 proizvodi[i++] = proizvod;
				} 
				
				stm.close();  // zatvaranje statement-a
				konekcija.close();
				System.out.println("USPEŠNA konekcija sa tabelom Proizvod - izvlacenje naziva i vrste !");
				
				return proizvodi;
				
				
				
			} catch (SQLException e) {
				System.out.println("NEUSPEŠNA konekcija sa tabelom Proizvod - izvlacenje naziva i vrste !");
				e.printStackTrace();
			}
			
			return null;
		}
	
	// METODA ZA BRISANJE PROIZVODA IZ BAZE
		public static void brisanje_proizvoda(String IDProizvoda) {
			
			try {
				Connection konekcija = DriverManager.getConnection(url, korisnicko_ime, sifra);
				String sql = "DELETE FROM sistem_maline.proizvod WHERE IDProizvoda = ?";
				PreparedStatement pst = konekcija.prepareStatement(sql);
				
				pst.setString(1, IDProizvoda);
				pst.executeUpdate();
				
				pst.close();
				konekcija.close();
				System.out.println("USPEŠNA konekcija sa tabelom Proizvod - brisanje !");
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("NEUSPEŠNA konekcija sa tabelom Proizvod - brisanje !");

			}
			
			
		}
}
		

