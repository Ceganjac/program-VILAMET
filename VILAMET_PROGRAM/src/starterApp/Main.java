package starterApp;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import kontroler.PocetniPrikazKontroler;

import pogled.OkvirPrikaza;

public class Main {
	
	// TREBA PROMENITI PRISTUP INSTANCIRANJA GUI KLASA TAKO DA SE ONE INSTANCIRAJU OD STRANE ODGOVARAJUĆEG KONTROLERA AKO NISU
	// INSTANCIRANE A AKO JESU DA SE KORISTI VEĆ INSTANCIRAN OBJEKAT
	// KORISTITI HasMap-e
	// GUI KLASE NE TREBA DA INSTANCIRA GUIManager

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
			
		PocetniPrikazKontroler ppk = new PocetniPrikazKontroler();
		ppk.pocetniPrikaz();
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
