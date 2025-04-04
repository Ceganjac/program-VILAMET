package pogled;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				// Fiksiranje skaliranja
				System.setProperty("sun.java2d.uiScale", "1.0");

				// Uzimanje dimenzija ekrana
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

				// Look & Feel
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}

				Vilamet frame = new Vilamet();
				frame.setSize(screenSize);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
