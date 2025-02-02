package pogled;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import pogled.paneli.PanelPocetni;
import pogled.paneli.PanelNB;
import pogled.paneli.PanelBranja;
import pogled.paneli.PanelProizvodjaci;
import pogled.paneli.PanelProizvodi;
import pogled.paneli.MeniPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Prozor extends JFrame {

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {

				Prozor frame = new Prozor();
				frame.setVisible(true);
				frame.setSize(screenSize);
				frame.setExtendedState(MAXIMIZED_BOTH);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Prozor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		setContentPane(contentPane);

		// Početni panel
		PanelPocetni pocetni = new PanelPocetni(cardLayout, contentPane);
		contentPane.add(pocetni, "pocetni");

		// Glavni panel sa meni i centralnim delom
		JPanel glavni = new JPanel(new BorderLayout());
		contentPane.add(glavni, "glavni");

		// Meni panel (samo unutar glavnog dela)
		MeniPanel meni = new MeniPanel();
		meni.setPreferredSize(new Dimension(300, screenVisina)); // Fiksna širina za meni
		glavni.add(meni, BorderLayout.WEST);

		// Layered panel (središnji deo)
		JLayeredPane paneli = new JLayeredPane();
		paneli.setLayout(new CardLayout());
		glavni.add(paneli, BorderLayout.CENTER);

		// Dodavanje panela u LayeredPane
		paneli.add(new PanelProizvodi(), "proizvodi");
		paneli.add(new PanelNB(), "novoBranje");
		paneli.add(new PanelBranja(), "branja");
		paneli.add(new PanelProizvodjaci(), "proizvodjaci");

		// Prikaz početnog panela
		cardLayout.show(contentPane, "pocetni");
	}
}
