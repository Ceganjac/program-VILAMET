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

	private static NBPanel nbPanel;
	private static BranjePanel branjePanel;
	private static ProizvodjacPanel proizvodjacPanel;
	private static ProizvodPanel proizvodPanel;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private static JPanel glavni;

	public Vilamet() {

		setTitle("ВИЛАМЕТ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vilamet.class.getResource("/pogled/slike/logo_donji.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		setContentPane(contentPane);

		// Početni panel
		PocetniPanel pocetni = new PocetniPanel(cardLayout, contentPane);
		contentPane.add(pocetni, "pocetni");

		// Glavni panel sa meni i centralnim delom

		glavni = new JPanel(new BorderLayout());
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

		nbPanel = new NBPanel();
		paneli.add(nbPanel, "PanelNB");

		// panelBranje - 2

		branjePanel = new BranjePanel();
		FlowLayout flowLayout_2 = (FlowLayout) branjePanel.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		paneli.add(branjePanel, "PanelBranje");

		// panelProizvodjac - 3

		proizvodjacPanel = new ProizvodjacPanel();
		
		paneli.add(proizvodjacPanel, "PanelProizvodjaci");

		// panelProizvod - 4

		proizvodPanel = new ProizvodPanel();
		
		paneli.add(proizvodPanel, "PanelProizvod");

		// prikaz početnog panela

		cardLayout.show(contentPane, "pocetni");
	}

	////////////////////////////////////////////////////////////////////////////////////////

	public static Vilamet vratiVilamet() {
		if (frame == null) {
			frame = new Vilamet();
		}
		return frame;
	}

	public static JPanel vratiGlavni() {
		return glavni;
	}

	public static NBPanel getNbPanel() {
		return nbPanel;
	}

	public static BranjePanel getBranjePanel() {
		return branjePanel;
	}

	public static ProizvodjacPanel getProizvodjacPanel() {
		return proizvodjacPanel;
	}

	public static ProizvodPanel getProizvodPanel() {
		return proizvodPanel;
	}

	////////////////////////////////////////////////////////////////////////////////////////

}
