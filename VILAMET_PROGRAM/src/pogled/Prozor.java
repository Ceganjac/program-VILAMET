package pogled;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pogled.paneli.PanelPocetni;
import pogled.paneli.PanelNB;
import java.awt.CardLayout;

public class Prozor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prozor frame = new Prozor();
					frame.setVisible(true);
					frame.setExtendedState(frame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prozor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		CardLayout cl = new CardLayout();
		contentPane.setLayout(cl);

		// DODAVANJE POČETNOG PANELA
		PanelPocetni pp = new PanelPocetni(cl, contentPane);
		contentPane.add(pp, "pp");

		// DODAVANJE NB PANELA
		PanelNB pnb = new PanelNB();
		contentPane.add(pnb, "pnb");
		
		// Prikazi pocetni panel kao inicijalni

	}

}
