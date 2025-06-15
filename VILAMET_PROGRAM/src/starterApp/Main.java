package starterApp;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

import pogled.GuiMenadzer;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				// Fiksiranje skaliranja
				System.setProperty("sun.java2d.uiScale", "1.0");
				//System.setProperty("sun.java2d.dpiaware", "true");
				
				// Uzimanje dimenzija ekrana
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int screenSirina = (int) screenSize.getWidth()-200;	
				int screenVisina = (int) screenSize.getHeight()-150;
				
				GuiMenadzer frame = new GuiMenadzer();
				frame.setSize(screenSirina, screenVisina);
				frame.setLocationRelativeTo(null); // Centriranje prozora
				frame.setVisible(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
