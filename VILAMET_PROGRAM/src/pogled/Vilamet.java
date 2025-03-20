package pogled;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;

import pogled.proizvod.ProizvodPanel;
import pogled.proizvodjac.ProizvodjacPanel;
import pogled.branje.BranjePanel;
import pogled.panelNB.NBPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Vilamet extends JFrame {

	private static Vilamet frame = null;

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	// deklaracija panela

	private NBPanel panelNB;
	private BranjePanel panelBranje;
	private static ProizvodjacPanel panelProizvodjac;
	private static ProizvodPanel panelProizvod;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;

	public Vilamet() {

		setTitle("ВИЛАМЕТ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vilamet.class.getResource("/pogled/slike/logo_donji.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		setContentPane(contentPane);

		// Početni panel
		PocetniPanel pocetni = new PocetniPanel(cardLayout, contentPane);
		contentPane.add(pocetni, "pocetni");

		// Glavni panel sa meni i centralnim delom
		JPanel glavni = new JPanel(new BorderLayout());
		contentPane.add(glavni, "glavni");

		// Layered panel (središnji deo)
		JLayeredPane paneli = new JLayeredPane();

		paneli.setLayout(new CardLayout());
		glavni.add(paneli, BorderLayout.CENTER);

		// Meni panel (samo unutar glavnog dela)
		// meni panelu prosleđuje cardLayot od "paneli" i "paneli"
		MeniPanel meni = new MeniPanel((CardLayout) paneli.getLayout(), paneli);
		meni.setPreferredSize(new Dimension(300, screenVisina)); // Fiksna širina za meni
		glavni.add(meni, BorderLayout.WEST);

		// Dodavanje panela u LayeredPane

		// panelNB - 1

		panelNB = new NBPanel();
		paneli.add(panelNB, "PanelNB");

		// panelBranje - 2

		panelBranje = new BranjePanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelBranje.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		paneli.add(panelBranje, "PanelBranje");

		// panelProizvodjac - 3

		panelProizvodjac = new ProizvodjacPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelProizvodjac.getLayout();
		flowLayout_1.setHgap(0);
		flowLayout_1.setVgap(0);
		paneli.add(panelProizvodjac, "PanelProizvodjaci");

		// panelProizvod - 4

		panelProizvod = new ProizvodPanel();
		FlowLayout flowLayout = (FlowLayout) panelProizvod.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		paneli.add(panelProizvod, "PanelProizvod");

		// prikaz početnog panela

		cardLayout.show(contentPane, "pocetni");
	}

	public JPanel vratiPanelNB() {
		return panelNB;
	}

	public JPanel vratiPanelBranje() {
		return panelBranje;
	}

	public static  JPanel vratiPanelProizvodjac() {
		return panelProizvodjac;
	}

	public static JPanel vratiPanelProizvod() {
		return panelProizvod;
	}

	public static Vilamet vratiFrame() {
		if (frame == null) {
			frame = new Vilamet();
		}
		return frame;
	}

}
