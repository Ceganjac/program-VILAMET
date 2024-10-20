package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import glavni.Sistem_GUI;

public class Baza_branja extends Sistem_GUI{
	
	
		
	// METODA ZA CITANJE PODATAKA IZ BAZE
		public static void citanje_baza()  {
	
		
		DefaultTableModel model =  (DefaultTableModel) Tabela_branja.getModel();

		
		// pravimo konekciju sa bazom
		
		try  {
			Connection konekcija = Konektor_baze.kreirenje_konekcije();
            
          //kreiranje stejtmenta
    		Statement izjava = konekcija.createStatement();
    		
    		//izvrsavanje upita
    		ResultSet rezultat = izjava.executeQuery("SELECT * FROM sistem_maline.pregled_branja_1");
    		
    		while(rezultat.next()) {
    			
    			// formatiranje datuma
    			LocalDate datum = LocalDate.parse(rezultat.getString(2));
    			DateTimeFormatter formter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    			String formatiran_datum = datum.format(formter);
    			
    			// fromatiranje iznosa
    			Double iznos = Double.parseDouble(rezultat.getString(9));
    			DecimalFormat df = new DecimalFormat("###,###.00");
    			String formatiran_iznos = df.format(iznos);
    			
    			
    			///////////////////////////////////////////////////////////////////////////////////
    			
    			String branje[] = {rezultat.getString(1), formatiran_datum, rezultat.getString(3), rezultat.getString(4), rezultat.getString(5),
    			rezultat.getString(6), rezultat.getString(7), rezultat.getString(8), formatiran_iznos, rezultat.getString(10), rezultat.getString(11),
    			rezultat.getString(12)
    			 };
    			if(branje != null) {
    	    		model.addRow(branje);

    			}
    		}
    		
    		
            System.out.println("Uspešna konekcija sa bazom - tabela branja !");

    		konekcija.close();
        } catch (SQLException e) {
            System.out.println("Neuspešna konekcija sa bazom - tabela branja !" + e.getMessage());
            
        }
		
		
	
		
	}

	 
		// METODA ZA UPIS PODATAKA U BAZU
		public static void upis_baza(String id, LocalDate datum, int ulaz1, int ulaz2, double bruto, 
				double tara, double neto, double cena, double iznos, int id_proiz, int id_proizvoda) {
			
			Tabela_branja.getModel();
			
			try {
				// kreiranje konekcije
				Connection konekcija = Konektor_baze.kreirenje_konekcije();
				
				// SQL upit sa PreparedStatement
		        String sql = "INSERT INTO `branje` (`IDbranja`, `Datum`, `Ulaz 0.4`, `Ulaz 0.5`, `Bruto`, `Tara`, `Neto`, `Cena`, `Iznos`,`IDproizvodjaca`,`IDProizvoda` ) " +
		                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        
				// kreiranje stejtmenta
				PreparedStatement izjava = konekcija.prepareStatement(sql);
				
				
				// Postavljanje parametara
		        izjava.setString(1, id);
		        izjava.setDate(2, java.sql.Date.valueOf(datum));  // Pretvara LocalDate u java.sql.Date
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
		        JOptionPane.showMessageDialog(null, "Подаци су успешно сачувани !", "Обавештење",
						JOptionPane.INFORMATION_MESSAGE);
		        
		        System.out.println("Uspešna konekcija sa bazom - tabela branja !");

				
			} catch (SQLException e) {
				System.out.println("Neuspešna konekcija sa bazom - tabela branja !");
				
				// obrada greške za korisnika
				JOptionPane.showMessageDialog(null, "Брање није сачувано, грешка у конекцији са базом !",
						"Грешка ", JOptionPane.ERROR_MESSAGE);
			
				e.printStackTrace();
			}
			
	}
	
		// METODA ZA BRISANJE REDA IZ BAZE - tabela branje
		public static void brisanje_reda_branje(String id_broj) {
			
			try {
				// kreiranje konekcije 
				Connection konekcija = Konektor_baze.kreirenje_konekcije();
				
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
				
				System.out.println("Uspešna konekcija sa bazom - tabela branja !");

				
				
				
			} catch (SQLException e) {
				System.out.println("Neuspešna konekcija sa bazom - tabela branja !");
				e.printStackTrace();
			}
			
		}
		
		
	
	

}
