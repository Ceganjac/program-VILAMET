package pogled;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;

import pogled.proizvod.ProizvodPanel;
import pogled.proizvodjac.ProizvodjacPanel;
import pogled.ambalaza.AmbalazaPanel;
import pogled.otkup.OtkupPanel;
import pogled.otkupni_list.OtkupniListPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class Vilamet extends JFrame {

	private static Vilamet frame = null;

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	// deklaracija panela

	private static OtkupPanel otkupPanel;
	private static OtkupniListPanel branjePanel;
	private static ProizvodjacPanel proizvodjacPanel;
	private static ProizvodPanel proizvodPanel;
	private static AmbalazaPanel ambalazaPanel;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private static JPanel glavni;
	private static CardLayout clPaneli;

	public Vilamet() {

		setTitle("ВИЛАМЕТ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vilamet.class.getResource("/pogled/slike/logo_donji.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,screenSirina,screenVisina);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		setContentPane(contentPane);

		// Početni panel
		PocetniPanel pocetni = new PocetniPanel(cardLayout, contentPane);
		contentPane.add(pocetni, "pocetni");

		// Glavni panel sa meni i centralnim delom

		glavni = new GradientPanel();
		glavni.setBackground(new Color(255, 255, 255));
		contentPane.add(glavni, "glavni");

		// Layered panel (središnji deo)
		JLayeredPane paneli = new JLayeredPane();
		paneli.setSize(screenSirina-250, screenVisina-100);


		clPaneli = new CardLayout();
		paneli.setLayout(clPaneli);

		// Meni panel (samo unutar glavnog dela)
		// meni panelu prosleđuje cardLayot od "paneli" i "paneli"
		MeniPanel meni = new MeniPanel((CardLayout) paneli.getLayout(), paneli);
		meni.setPreferredSize(new Dimension(300, screenVisina));

		// Dodavanje panela u LayeredPane

		// panelOtkup - 1
		otkupPanel = new OtkupPanel();
		paneli.add(otkupPanel, "PanelNB");

		// panelBranje - 2
		branjePanel = new OtkupniListPanel();
		paneli.add(branjePanel, "PanelBranje");

		// panelProizvodjac - 3
		proizvodjacPanel = new ProizvodjacPanel();
		paneli.add(proizvodjacPanel, "PanelProizvodjaci");

		// panelProizvod - 4
		proizvodPanel = new ProizvodPanel();
		paneli.add(proizvodPanel, "PanelProizvod");
		
		// panelAmbalaza - 5
		ambalazaPanel = new AmbalazaPanel();
		paneli.add(ambalazaPanel,"AmbalazaPanel");
		GroupLayout gl_glavni = new GroupLayout(glavni);
		gl_glavni.setHorizontalGroup(
			gl_glavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_glavni.createSequentialGroup()
					.addComponent(meni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(paneli, GroupLayout.PREFERRED_SIZE, 1683, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_glavni.setVerticalGroup(
			gl_glavni.createParallelGroup(Alignment.LEADING)
				.addComponent(meni, GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
				.addGroup(gl_glavni.createSequentialGroup()
					.addGap(60)
					.addComponent(paneli, GroupLayout.PREFERRED_SIZE, 1030, Short.MAX_VALUE))
		);
		glavni.setLayout(gl_glavni);

		// prikaz početnog panela

		cardLayout.show(contentPane, "pocetni");
	}

	////////////////////////////////////////////////////////////////////////////////////////

	public static Vilamet getVilamet() {
		if (frame == null) {
			frame = new Vilamet();
		}
		return frame;
	}

	public static JPanel getGlavni() {
		return glavni;
	}

	public static OtkupPanel getOtkupPanel() {
		return otkupPanel;
	}

	public static OtkupniListPanel getBranjePanel() {
		return branjePanel;
	}

	public static ProizvodjacPanel getProizvodjacPanel() {
		return proizvodjacPanel;
	}

	public static ProizvodPanel getProizvodPanel() {
		return proizvodPanel;
	}

	public static AmbalazaPanel getAmbalazaPanel() {
		return ambalazaPanel;
	}

	
	// vraćanje layout-a koji prisutan na layered pane paneli
	public static CardLayout getClPaneli() {
		return clPaneli;
	}
}
