package pogled;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;

import pogled.paneli.AmbalazaPanel;
import pogled.paneli.MeniPanel;
import pogled.paneli.OtkupPanel;
import pogled.paneli.OtkupniListPanel;
import pogled.paneli.OtkupnoMestoPanel;
import pogled.paneli.OtplataPanel;
import pogled.paneli.NaziviPanel;
import pogled.paneli.PocetniPanel;
import pogled.paneli.ProizvodPanel;
import pogled.paneli.ProizvodjacPanel;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class OkvirPrikaza extends JFrame {

	private static OkvirPrikaza frame = null;

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	// deklaracija panela

	private static NaziviPanel naziviPanel;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private static JPanel glavni;
	private static CardLayout clPaneli;

	/**
	 * Create the panel.
	 */

	public OkvirPrikaza() {

		setTitle("ВИЛАМЕТ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OkvirPrikaza.class.getResource("/pogled/slike/logo donji.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(screenSirina-200, screenVisina-150));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		setContentPane(contentPane);

		// Početni panel
		PocetniPanel pocetni = new PocetniPanel(cardLayout, contentPane);
		contentPane.add(pocetni, "pocetni");

		// Glavni panel sa menijom i centralnim delom
		glavni = new JPanel();
		glavni.setBackground(Color.DARK_GRAY);
		contentPane.add(glavni, "glavni");

		// Layered panel (središnji deo)
		JLayeredPane paneli = new JLayeredPane();
		paneli.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		clPaneli = new CardLayout();
		paneli.setLayout(clPaneli);

		// Meni panel (samo unutar glavnog dela)
		// meni panelu prosleđuje cardLayot od "paneli" i "paneli"
		MeniPanel meni = new MeniPanel((CardLayout) paneli.getLayout(), paneli);

		
		////////////////////////////////////////////////////////////////////////////////////////

		// Panel za nazive
		naziviPanel = new NaziviPanel();
		GroupLayout gl_glavni = new GroupLayout(glavni);
		gl_glavni.setHorizontalGroup(
			gl_glavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_glavni.createSequentialGroup()
					.addComponent(meni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_glavni.createParallelGroup(Alignment.LEADING)
						.addComponent(paneli, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(naziviPanel, GroupLayout.PREFERRED_SIZE, 1620, GroupLayout.PREFERRED_SIZE)))
		);
		gl_glavni.setVerticalGroup(
			gl_glavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_glavni.createSequentialGroup()
					.addComponent(naziviPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(paneli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(meni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		glavni.setLayout(gl_glavni);

		// prikaz početnog panela

		cardLayout.show(contentPane, "pocetni");
	}

	////////////////////////////////////////////////////////////////////////////////////////

	public static OkvirPrikaza getVilamet() {
		if (frame == null) {
			frame = new OkvirPrikaza();
		}
		return frame;
	}

	public static JPanel getGlavni() {
		return glavni;
	}


	public JPanel getContentPane() {
		return contentPane;
	}

	// vraćanje layout-a koji prisutan na layered pane paneli
	public  CardLayout getCLPaneli() {
		return clPaneli;
	}

	public static NaziviPanel getNaziviPanel() {
		return naziviPanel;
	}

	public static void setNaziviPanel(NaziviPanel naziviPanel) {
		OkvirPrikaza.naziviPanel = naziviPanel;
	}

}
