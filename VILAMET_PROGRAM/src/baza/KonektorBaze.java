package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KonektorBaze {
	
	// KLASA KOJE IMA ZADATAK DA USPOSTAVI KONEKCIJU SA BAZOM PODATAKA
	
	// parametri konekcije
	
	static String url = "jdbc:mysql://localhost:3306/sistem_maline";  //putanja baze podataka
	static String korisnicko_ime = "root";  // korisnicko ime
	static String sifra = "";
	
	// metoda koja kreira konekciju sa bazom
	public static  Connection kreirenje_konekcije(){
		
		try {
			Connection konekcija = DriverManager.getConnection(url, korisnicko_ime,sifra);
			System.out.println("Uspešna konekcija sa bazom sistem_maline !");
			return konekcija;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Neuspešna konekcija sa bazom sistem_maline !");
			return null;
		}  	
		
		
		
		
	}
	
	

}
