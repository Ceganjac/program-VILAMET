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
	static int redni_broj = BazaIDEvidencija.citanje_redni();
	
	
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
		BazaIDEvidencija.upis_redni(redni_broj);
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
	
	
	

	
	
	
}
