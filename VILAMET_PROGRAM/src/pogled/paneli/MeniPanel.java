package pogled.paneli;

import javax.swing.JPanel;

import pomocni.ProizvodInitial;
import pomocni.ProizvodjacInitial;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import pogled.GradientPanel;
import pogled.Vilamet;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MeniPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenVisina = screenSize.height;

	/**
	 * Create the panel.
	 */

	public MeniPanel(CardLayout cl, JLayeredPane paneli) {

		setPreferredSize(new Dimension(300, screenVisina));
		
		// dolazak do labele za nazive u klasi NaziviPanel
		NaziviPanel pnlNazivi = Vilamet.getNaziviPanel();

		///////////////////////////////////////////////////////////////////////////////////

		
		// Dugme Otkupni listovi	
		JPanel pnlMeni = new GradientPanel();
		pnlMeni.setPreferredSize(new Dimension(300, screenVisina));

		JButton btnMeniOtkupniL = new JButton("Откупни листови");
		btnMeniOtkupniL.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeniOtkupniL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniOtkupniL.setContentAreaFilled(true);
				btnMeniOtkupniL.setBackground(new Color(102, 255, 102));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniOtkupniL.setContentAreaFilled(false);
			}
		});
		btnMeniOtkupniL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//pnlNazivi.postaviNaziv("Otkupni listovi");
				cl.show(paneli, "OtkupniListPanel");
				

			}
		});
		btnMeniOtkupniL.setIconTextGap(30);
		btnMeniOtkupniL.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/lista.png")));
		btnMeniOtkupniL.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMeniOtkupniL.setForeground(Color.BLACK);
		btnMeniOtkupniL.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnMeniOtkupniL.setFocusable(false);
		btnMeniOtkupniL.setContentAreaFilled(false);
		btnMeniOtkupniL.setBorderPainted(false);
		btnMeniOtkupniL.setBackground(Color.WHITE);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Dugme Proizvodjac
		JButton btnMeniProizvodjac = new JButton("Произвођачи");
		btnMeniProizvodjac.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeniProizvodjac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniProizvodjac.setContentAreaFilled(true);
				btnMeniProizvodjac.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniProizvodjac.setContentAreaFilled(false);
			}
		});
		btnMeniProizvodjac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(paneli, "ProizvodjacPanel");
				try {
					ProizvodjacInitial.prikazSvih();
				} catch (Exception e1) {
					System.out.println("Greska prilikom prikaza proizvodjaca - MeniPanel");
				}

			}
		});
		btnMeniProizvodjac.setIconTextGap(30);
		btnMeniProizvodjac.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/ljudi.png")));
		btnMeniProizvodjac.setForeground(Color.BLACK);
		btnMeniProizvodjac.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnMeniProizvodjac.setFocusable(false);
		btnMeniProizvodjac.setContentAreaFilled(false);
		btnMeniProizvodjac.setBorderPainted(false);
		btnMeniProizvodjac.setBackground(Color.WHITE);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Dugme Proizvod
		JButton btnMeniProizvod = new JButton("Производи");
		btnMeniProizvod.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeniProizvod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniProizvod.setContentAreaFilled(true);
				btnMeniProizvod.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniProizvod.setContentAreaFilled(false);
			}
		});
		btnMeniProizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ProizvodInitial.prikazSvih();

				} catch (Exception e1) {
					System.out.println("Greska prilikom prikaza proizvoda - MeniPanel");
					e1.printStackTrace();
				}

				cl.show(paneli, "ProizvodPanel");

			}
		});
		btnMeniProizvod.setIconTextGap(30);
		btnMeniProizvod.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/proizvod.png")));
		btnMeniProizvod.setForeground(Color.BLACK);
		btnMeniProizvod.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnMeniProizvod.setFocusable(false);
		btnMeniProizvod.setContentAreaFilled(false);
		btnMeniProizvod.setBorderPainted(false);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Dugme Otkup
		JButton btnMeniOtkup = new JButton("Откуп");
		btnMeniOtkup.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeniOtkup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniOtkup.setContentAreaFilled(true);
				btnMeniOtkup.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniOtkup.setContentAreaFilled(false);
			}
		});
		btnMeniOtkup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(paneli, "OtkupPanel");
			}
		});
		btnMeniOtkup.setIconTextGap(30);
		btnMeniOtkup.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/plus.png")));
		btnMeniOtkup.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMeniOtkup.setForeground(Color.BLACK);
		btnMeniOtkup.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnMeniOtkup.setFocusable(false);
		btnMeniOtkup.setContentAreaFilled(false);
		btnMeniOtkup.setBorderPainted(false);
		btnMeniOtkup.setBackground(Color.WHITE);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Dugme Ambalaza
		JButton btnMeniAmbalaza = new JButton("Амбалажа");
		btnMeniAmbalaza.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeniAmbalaza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniAmbalaza.setContentAreaFilled(true);
				btnMeniAmbalaza.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniAmbalaza.setContentAreaFilled(false);
			}
		});
		btnMeniAmbalaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(paneli, "AmbalazaPanel");
			}
		});
		btnMeniAmbalaza.setIconTextGap(30);
		btnMeniAmbalaza.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/ambalaza.png")));
		btnMeniAmbalaza.setForeground(Color.BLACK);
		btnMeniAmbalaza.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnMeniAmbalaza.setFocusable(false);
		btnMeniAmbalaza.setContentAreaFilled(false);
		btnMeniAmbalaza.setBorderPainted(false);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Dugme Otkupno mesto
		JButton btnMeniOtkupnoM = new JButton("Откупна места");
		btnMeniOtkupnoM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeniOtkupnoM.setContentAreaFilled(true);
				btnMeniOtkupnoM.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMeniOtkupnoM.setContentAreaFilled(false);
			}
		});
		btnMeniOtkupnoM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(paneli, "OtkupnoMestoPanel");

			}
		});
		btnMeniOtkupnoM.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeniOtkupnoM.setIconTextGap(30);
		btnMeniOtkupnoM.setIcon(new ImageIcon(MeniPanel.class.getResource("/pogled/slike/lokacija.png")));
		btnMeniOtkupnoM.setForeground(Color.BLACK);
		btnMeniOtkupnoM.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		btnMeniOtkupnoM.setFocusable(false);
		btnMeniOtkupnoM.setContentAreaFilled(false);
		btnMeniOtkupnoM.setBorderPainted(false);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		GroupLayout gl_pnlMeni = new GroupLayout(pnlMeni);
		gl_pnlMeni.setHorizontalGroup(gl_pnlMeni.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlMeni
				.createSequentialGroup().addGap(25)
				.addGroup(gl_pnlMeni.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnMeniProizvod, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 250,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMeniOtkup, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMeniOtkupniL, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMeniProizvodjac, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMeniAmbalaza, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMeniOtkupnoM, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(25, Short.MAX_VALUE)));
		gl_pnlMeni.setVerticalGroup(gl_pnlMeni.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlMeni
				.createSequentialGroup().addGap(100)
				.addComponent(btnMeniOtkup, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(10)
				.addComponent(btnMeniOtkupniL, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(10)
				.addComponent(btnMeniProizvodjac, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(10)
				.addComponent(btnMeniProizvod, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(10)
				.addComponent(btnMeniAmbalaza, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(9)
				.addComponent(btnMeniOtkupnoM, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(721, Short.MAX_VALUE)));
		pnlMeni.setLayout(gl_pnlMeni);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlMeni, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlMeni, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
