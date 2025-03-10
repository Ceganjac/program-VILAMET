package pogled;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {
	
	// UZIMANJE DIMENZIJA EKRANA
		static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenSirina = screenSize.width;
		int screenVisina = screenSize.height;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {

				Vilamet frame = new Vilamet();
				frame.setVisible(true);
				frame.setSize(screenSize);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
