package kontroleri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;	
import baza.BazaIDEvidencija;


	public class IDalgoritmi {
	

	static LocalDate poslednji_upis = BazaIDEvidencija.citanje_datuma();
	static LocalDate trenutni_datum = LocalDate.now();
	static int redni_broj = citanje_redni();
	
	
	/*
	 NEOPHODNA IZMENA METODA ZA UPIS I ČITANJE rednog_broja
	 */
	
		
	
	// ALGORITAM ZA KREIRANJE ID branja 
	public static String id_algoritam() {
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("ddMMyy");
		String datum = trenutni_datum.format(formater);
		
		//provera da li je prošao dan
		if(!trenutni_datum.equals(poslednji_upis)) {
			redni_broj = 0; // resetovanje rednog broja
			BazaIDEvidencija.upis_datuma(trenutni_datum);  // upis datuma poslednjeg upisa
		}
		
		redni_broj++;
		upis_redni();
		String redni = String.valueOf(redni_broj);
		
		
		
		// u zavisnosti od toga da li je broj 1-cifren, 2-cifren ili 3-cifren 
		
		// ako je broj jednocifren
		if(redni_broj/ 10 == 0) {
			String redni1 = "00" + String.valueOf(redni_broj);
			return datum + "/" + redni1; 
		}
		
		// ako je broj dvocifren
		if(redni_broj/ 100 == 0) {
			String redni1 = "0" + String.valueOf(redni_broj);
			return datum + "/" + redni1; 
		}
		
		
		return 	datum + "/" + redni;
		
		
	}
	
	// METODA ZA UPIS REDNOG BROJA U txt FAJL
	public static void upis_redni() {
		
		try {
			FileWriter upisivac = new FileWriter("redni_broj.txt");
			BufferedWriter bafer = new BufferedWriter(upisivac);
			bafer.write(""+redni_broj);
			
			System.out.println("Uspešan upis u ID fajl !");
			bafer.close();
			

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Greška prilikom upisa u fajl !");
		}
		
	}
	
	// METODA ZA CITANJE REDNOG BROJA  IZ txt FAJLA
	public static int citanje_redni()  {
		
		String broj = null;
		
		try {
			FileReader citac = new FileReader("redni_broj.txt");
			BufferedReader bafer = new BufferedReader(citac);
			broj = bafer.readLine();
			
			bafer.close();
			
		}catch (FileNotFoundException e) {
	        System.out.println("Greška: Fajl 'redni_broj.txt' nije pronađen!");
	    } catch (NumberFormatException e) {
	        System.out.println("Greška: Sadržaj fajla nije broj koji se može konvertovati!");
	    } catch (IOException e) {
	        System.out.println("Greška prilikom čitanja fajla!");
	        e.printStackTrace();
	    }
		
		int brojK = Integer.parseInt(broj);
		
		return brojK;
		
	}
	

	
	
	
}
