package ostalo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;	



	public class IDalgoritmi {
	

	static LocalDate poslednji_upis = citanje_datuma();
	static LocalDate trenutni_datum = LocalDate.now();
	static int redni_broj = citanje_redni();
	
		
	/*// MAIN METODA
	public static void main(String args[]) {
		
		upis_datuma();
		
		
	}*/
	
	// GLAVNI ALGORITAM 
	public static String id_algoritam() {
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("ddMMyy");
		String datum = trenutni_datum.format(formater);
		
		//provera da li je prošao dan
		if(!trenutni_datum.equals(poslednji_upis)) {
			redni_broj = 0; // resetovanje rednog broja
			upis_datuma();  // upis datuma poslednjeg upisa
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
			
		} catch (FileNotFoundException e) {
			System.out.println("Greška prilikom čitanja fajla !");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		int brojK = Integer.parseInt(broj);
		
		return brojK;
		
	}
	

	// METODA ZA UPIS DATUMA 
	public static void upis_datuma() {
		
		try {
			FileWriter upisivac = new FileWriter("poslednji_datum.txt");
			BufferedWriter bafer = new BufferedWriter(upisivac);
			
			bafer.write("" + LocalDate.now());
			bafer.close();
			
			System.out.println("Uspešan upis datuma poslednjeg upisa u fajl !");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Greška prilikom upisa u fajl !");
		}
		
		
	}

	// METODA ZA CITANJE DATUMA
	public static LocalDate citanje_datuma() {
		
		LocalDate datum = null;
		
		try {
			FileReader citac = new FileReader("poslednji_datum.txt");
			BufferedReader bafer = new BufferedReader(citac);
			
			datum = LocalDate.parse(bafer.readLine());
			bafer.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Greška prilikom čitanja fajla !");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return datum;
		
	}
	
	
	
}
