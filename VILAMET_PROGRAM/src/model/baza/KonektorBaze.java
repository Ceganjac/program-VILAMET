package model.baza;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class KonektorBaze {

	// KLASA KOJE IMA ZADATAK DA USPOSTAVI KONEKCIJU SA BAZOM PODATAKA

	// parametri konekcije

	static String url; // putanja baze podataka
	static String korisnickoIme;// korisnicko ime
	static String lozinka; // lozinka

	public static void citanjePodKonekcije() throws IOException {
		Properties properties = new Properties();

		FileInputStream fis = new FileInputStream("lib/podaciBaze.properties");
		properties.load(fis); // iz fis-a u properties

		url = properties.getProperty("url");
		korisnickoIme = properties.getProperty("korisnickoIme");
		lozinka = properties.getProperty("lozinka");

	}

	// metoda koja kreira konekciju sa bazom
	public static Connection kreirenje_konekcije() {
		
		try {
			citanjePodKonekcije();
		}
		catch(Exception e) {
			System.out.println("Greska prilikom citanja parametara baze - konektor !");
		}

		try {
			Connection konekcija = DriverManager.getConnection(url, korisnickoIme, lozinka);
			System.out.println("Uspešna konekcija sa bazom - konektor !");
			return konekcija;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Neuspešna konekcija sa bazom - konektor !");
			return null;
		}

	}

}
