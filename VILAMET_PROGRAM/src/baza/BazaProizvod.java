package baza;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;


import pogled.SistemGUI;
import pogled.paneli.PanelProizvodi;

public class BazaProizvod extends PanelProizvodi{
	
	// KLASA NAMENJENA RADU SA TABELOM PROIZVOD
	
	
		
	// METODA ZA ČITANJE IZ BAZE
		public static void citanje_baza()   {
			
			// model tabele proizvod iz Sistem_GUI
			DefaultTableModel model=  (DefaultTableModel) tblProizvodi.getModel();

			
			try {
				
				Connection konekcija = KonektorBaze.kreirenje_konekcije();  // uzimanje konekcije od klase Konektor_baze
				Statement izjava =  konekcija.createStatement();  // kreiranje statement-a
				ResultSet rezultat = izjava.executeQuery("SELECT * FROM baza_vilamet.pregled_proizvoda ;"); // izvršavanje upita
				
				while(rezultat.next()) {
					String red[] = {rezultat.getString(1), rezultat.getString(2) };
					model.addRow(red);
				} 
				
				System.out.println("Uspešna konekcija sa bazom - tabela proizvod!");
				konekcija.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Neuspešna konekcija sa bazom - tabela proizvod!");
			}
			
		}
		
	// METODA ZA UNOS PROIZVODA U BAZU
		public static void upis_baza(String naziv, String vrsta) {
			
			try {
				Connection konekcija = KonektorBaze.kreirenje_konekcije();
				String sql = "INSERT INTO sistem_maline.proizvod ( naziv, vrsta) VALUES ( ?, ?)";
				PreparedStatement pst = konekcija.prepareStatement(sql);
				
				pst.setString(1,naziv);
				pst.setString(2, vrsta);
				pst.executeUpdate();
				
				pst.close();
				konekcija.close();
				
				System.out.println("Uspešna konekcija sa bazom - tabela proizvod!");
				
				
			} catch (SQLException e) {
				System.out.println("Neuspešna konekcija sa bazom - tabela proizvod!");
				e.printStackTrace();
			}
			
			
		}

	// METODA ZA IZVLAČENJE NAZIVA I VRSTE
		public static String[] id_proizvod_baza() {
			
			try {
				
				Connection konekcija = KonektorBaze.kreirenje_konekcije();
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
				System.out.println("Uspešna konekcija sa bazom - tabela proizvod!");
				
				return proizvodi;
				
				
				
			} catch (SQLException e) {
				System.out.println("Neuspešna konekcija sa bazom - tabela proizvod!");
				e.printStackTrace();
			}
			
			return null;
		}
	
	// METODA ZA BRISANJE PROIZVODA IZ BAZE
		public static void brisanje_proizvoda(String IDProizvoda) {
			
			try {
				Connection konekcija = KonektorBaze.kreirenje_konekcije();
				String sql = "DELETE FROM sistem_maline.proizvod WHERE IDProizvoda = ?";
				PreparedStatement pst = konekcija.prepareStatement(sql);
				
				pst.setString(1, IDProizvoda);
				pst.executeUpdate();
				
				pst.close();
				konekcija.close();
				System.out.println("Uspešna konekcija sa bazom - tabela proizvod!");
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Neuspešna konekcija sa bazom - tabela proizvod!");

			}
			
			
		}
		
	// METODA ZA IZVLAČENJE ID-a PROIZVOD IZ PRIKAZA KOJI JE U padajucoj listi
		public static int izvlacenje_id(String id_proizvod) {
			
			char praznina = ' ';
			int indeks_znaka = id_proizvod.indexOf(praznina);
			int ID_proizvoda = Integer.parseInt(id_proizvod.substring(0,indeks_znaka));
			
			System.out.println("Id proizvoda je" + ID_proizvoda);
			
			return ID_proizvoda;
			
		}

		
		
}
		

