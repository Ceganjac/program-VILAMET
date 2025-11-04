package starterApp;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

import pogled.GuiMenadzer;

public class Main {
	
	// TREBA PROMENITI PRISTUP INSTANCIRANJA GUI KLASA TAKO DA SE ONE INSTANCIRAJU OD STRANE ODGOVARAJUĆEG KONTROLERA AKO NISU
	// INSTANCIRANE A AKO JESU DA SE KORISTI VEĆ INSTANCIRAN OBJEKAT
	// KORISTITI HasMap-e
	// GUI KLASE NE TREBA DA INSTANCIRA GUIManager

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				// Fiksiranje skaliranja
				System.setProperty("sun.java2d.uiScale", "1.0");
				//System.setProperty("sun.java2d.dpiaware", "true");
				
				// Uzimanje dimenzija ekrana
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int screenSirina = (int) screenSize.getWidth();	
				int screenVisina = (int) screenSize.getHeight();
				
				GuiMenadzer frame = new GuiMenadzer();
				frame.setSize(screenSirina-200, screenVisina-150);
				frame.setLocationRelativeTo(null); // Centriranje prozora
				frame.setVisible(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
