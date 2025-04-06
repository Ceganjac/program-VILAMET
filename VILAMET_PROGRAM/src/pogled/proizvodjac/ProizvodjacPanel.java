package pogled.proizvodjac;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import pogled.CellRenderer;
import pomocni.ProizvodjacInitial;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;

public class ProizvodjacPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;

	protected JTable tblProizvodjac;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_9;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Create the panel.
	 */
	public ProizvodjacPanel() {

		JPanel pnlProizvodjac = new JPanel();
		pnlProizvodjac.setBounds(0, 0, 1630, 1095);
		pnlProizvodjac.setBackground(Color.WHITE);
		pnlProizvodjac.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		JLabel lblProizvodjacPregled = new JLabel("Преглед унетих произвођача");
		lblProizvodjacPregled.setBounds(117, 46, 349, 34);
		lblProizvodjacPregled.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblProizvodjacUnos = new JLabel("Унесите новог произвођача");
		lblProizvodjacUnos.setBounds(117, 496, 349, 34);
		lblProizvodjacUnos.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane jspProizvodjac = new JScrollPane();
		jspProizvodjac.setBounds(117, 90, 1079, 370);

		/*
		 * jspProizvodjac.setPreferredSize(new Dimension(335,290));
		 * jspProizvodjac.setMaximumSize(new Dimension(335,290));
		 * jspProizvodjac.setMinimumSize(new Dimension(335,290));
		 */

		JPanel pnlProizvodjacNovi = new JPanel();
		pnlProizvodjacNovi.setBounds(117, 542, 1334, 335);
		pnlProizvodjacNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlProizvodjacNovi.setBackground(Color.WHITE);

		JButton btnNoviIzbrisi = new JButton("Избриши");
		btnNoviIzbrisi.setBounds(1085, 271, 139, 39);
		btnNoviIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * txtNoviIme.setText(""); txtNoviPrezime.setText(""); txtNoviMesto.setText("");
				 * txtNoviSelo.setText(""); txtNoviUlica.setText("");
				 */

			}
		});
		btnNoviIzbrisi.setForeground(Color.RED);
		btnNoviIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIzbrisi.setBackground(Color.WHITE);

		JButton btnNoviDodaj = new JButton("Додај");
		btnNoviDodaj.setBounds(1242, 271, 139, 39);
		btnNoviDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String ime = txtNoviIme.getText(); String prezime = txtNoviPrezime.getText();
				 * String mestoGrad = txtNoviMesto.getText(); String selo =
				 * txtNoviSelo.getText(); String ulicaBroj = txtNoviUlica.getText();
				 * 
				 * ProizvodjacInitial.dodavanje(ime, prezime, mestoGrad, selo, ulicaBroj);
				 */

			}
		});
		btnNoviDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviDodaj.setBackground(new Color(0, 194, 0));

		// TABELA PROIZVOĐAČI

		tblProizvodjac = new JTable();

		// stavljanje boje koju će imati polja koja selektovana
		tblProizvodjac.setSelectionBackground(new Color(153, 255, 153));
		tblProizvodjac.setRowHeight(25);
		tblProizvodjac.setFont(new Font("Arial", Font.PLAIN, 12));
		tblProizvodjac.setBackground(Color.WHITE);

		// heder tabele
		JTableHeader heder = tblProizvodjac.getTableHeader();
		heder.setBackground(Color.LIGHT_GRAY);
		heder.setPreferredSize(new Dimension(heder.getWidth(), 30));

		// omogućava hover reda
		tblProizvodjac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tblProizvodjac.clearSelection();
			}
		});

		tblProizvodjac.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int indeksReda = tblProizvodjac.rowAtPoint(e.getPoint());
				if (indeksReda != -1) {
					tblProizvodjac.setRowSelectionInterval(indeksReda, indeksReda);
				}
			}
		});

		String[] kolone = { "Редни бр.", "ИД произвођача", "Име", "Презиме", "Место/Град", "Село", "Улица и број",
				"Опције" };

		// inicijalizacija modela tabele

		model = new DefaultTableModel();

		// postavljanje modela tabeli
		tblProizvodjac.setModel(model);
		model.setColumnIdentifiers(kolone);

		// kako bi sve ćelije tabele bile needitabilne
		tblProizvodjac.setDefaultEditor(Object.class, null);

		// postavljanje CellRenderer-a i CellEditor-a
		tblProizvodjac.getColumnModel().getColumn(7).setCellRenderer(new CellRenderer());
		tblProizvodjac.getColumnModel().getColumn(7).setCellEditor(new ProizvodjacCellEditor(tblProizvodjac));

		// render za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < tblProizvodjac.getColumnCount() - 1; i++) {
			tblProizvodjac.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		setLayout(null);

		jspProizvodjac.setViewportView(tblProizvodjac);

		JPanel pnlNoviOsnovni = new JPanel();
		pnlNoviOsnovni.setBounds(10, 24, 461, 300);
		pnlNoviOsnovni.setBackground(Color.WHITE);
		pnlNoviOsnovni.setBorder(
			    new TitledBorder(
			        BorderFactory.createLineBorder(Color.LIGHT_GRAY), // ili neki drugi border
			        "Основни подаци",
			        TitledBorder.LEADING,
			        TitledBorder.TOP,
			        null,
			        null
			    ));
		
		// kreiranje naslova unutar linije panela
		//TitledBorder naslovOsnovni = new TitledBorder();
		//pnlNoviOsnovni.setBorder(naslovOsnovni);

		pnlProizvodjacNovi.setLayout(null);
		pnlProizvodjacNovi.add(btnNoviIzbrisi);
		pnlProizvodjacNovi.add(btnNoviDodaj);
		pnlProizvodjacNovi.add(pnlNoviOsnovni);
		pnlNoviOsnovni.setLayout(null);

		JLabel lblOsnovniPBgp = new JLabel("Систем ПДВ-а :");
		lblOsnovniPBgp.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPBgp.setBounds(28, 61, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniPBgp);

		JLabel lblOsnovniPBgp_1 = new JLabel("Број пољ. газдинства :");
		lblOsnovniPBgp_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPBgp_1.setBounds(28, 25, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniPBgp_1);

		JLabel lblOsnovniPBgp_2 = new JLabel("ПИБ :");
		lblOsnovniPBgp_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPBgp_2.setBounds(28, 97, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniPBgp_2);

		JLabel lblOsnovniPBgp_3 = new JLabel("Текући рачун :");
		lblOsnovniPBgp_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPBgp_3.setBounds(28, 133, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniPBgp_3);

		JLabel lblOsnovniPBgp_4 = new JLabel("Телефон :");
		lblOsnovniPBgp_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPBgp_4.setBounds(28, 169, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniPBgp_4);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEmail.setBounds(28, 205, 170, 26);
		pnlNoviOsnovni.add(lblEmail);

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(229, 31, 194, 26);
		pnlNoviOsnovni.add(textField);

		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(229, 67, 194, 26);
		pnlNoviOsnovni.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBounds(229, 103, 194, 26);
		pnlNoviOsnovni.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		textField_3.setBounds(229, 139, 194, 26);
		pnlNoviOsnovni.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		textField_4.setBounds(229, 175, 194, 26);
		pnlNoviOsnovni.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setColumns(10);
		textField_5.setBounds(229, 211, 194, 26);
		pnlNoviOsnovni.add(textField_5);
		add(pnlProizvodjac);
		pnlProizvodjac.setLayout(null);
		pnlProizvodjac.add(lblProizvodjacPregled);
		pnlProizvodjac.add(lblProizvodjacUnos);
		pnlProizvodjac.add(pnlProizvodjacNovi);

		JPanel pnlNoviAdresa = new JPanel();
		pnlNoviAdresa.setLayout(null);

		// kreiranje naslova unutar linije panela za adresu
		TitledBorder naslovAdresa = new TitledBorder("Адреса");
		pnlNoviAdresa.setBorder(naslovAdresa);

		pnlNoviAdresa.setBackground(Color.WHITE);
		pnlNoviAdresa.setBounds(481, 24, 461, 137);
		pnlProizvodjacNovi.add(pnlNoviAdresa);

		JLabel lblOsnovniPBgp_5 = new JLabel("Село:");
		lblOsnovniPBgp_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPBgp_5.setBounds(28, 61, 170, 26);
		pnlNoviAdresa.add(lblOsnovniPBgp_5);

		JLabel lblOsnovniPBgp_1_1 = new JLabel("Место/Град :");
		lblOsnovniPBgp_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPBgp_1_1.setBounds(28, 25, 170, 26);
		pnlNoviAdresa.add(lblOsnovniPBgp_1_1);

		JLabel lblOsnovniPBgp_2_1 = new JLabel("Улица и број :");
		lblOsnovniPBgp_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPBgp_2_1.setBounds(28, 97, 170, 26);
		pnlNoviAdresa.add(lblOsnovniPBgp_2_1);

		textField_6 = new JTextField();
		textField_6.setToolTipText("");
		textField_6.setColumns(10);
		textField_6.setBounds(229, 31, 194, 26);
		pnlNoviAdresa.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setToolTipText("");
		textField_7.setColumns(10);
		textField_7.setBounds(229, 67, 194, 26);
		pnlNoviAdresa.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setToolTipText("");
		textField_8.setColumns(10);
		textField_8.setBounds(229, 103, 194, 26);
		pnlNoviAdresa.add(textField_8);
										
										JPanel pnlNoviAdresa_2 = new JPanel();
										pnlNoviAdresa_2.setLayout(null);
										pnlNoviAdresa_2.setBackground(Color.WHITE);
										pnlNoviAdresa_2.setBounds(952, 24, 461, 137);
										pnlProizvodjacNovi.add(pnlNoviAdresa_2);
										
										JLabel lblOsnovniPBgp_5_1 = new JLabel("Село:");
										lblOsnovniPBgp_5_1.setFont(new Font("Arial", Font.PLAIN, 16));
										lblOsnovniPBgp_5_1.setBounds(28, 61, 170, 26);
										pnlNoviAdresa_2.add(lblOsnovniPBgp_5_1);
										
										JLabel lblOsnovniPBgp_1_1_2 = new JLabel("Место/Град :");
										lblOsnovniPBgp_1_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
										lblOsnovniPBgp_1_1_2.setBounds(28, 25, 170, 26);
										pnlNoviAdresa_2.add(lblOsnovniPBgp_1_1_2);
										
										JLabel lblOsnovniPBgp_2_1_1 = new JLabel("Улица и број :");
										lblOsnovniPBgp_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
										lblOsnovniPBgp_2_1_1.setBounds(28, 97, 170, 26);
										pnlNoviAdresa_2.add(lblOsnovniPBgp_2_1_1);
										
										textField_10 = new JTextField();
										textField_10.setToolTipText("");
										textField_10.setColumns(10);
										textField_10.setBounds(229, 31, 194, 26);
										pnlNoviAdresa_2.add(textField_10);
										
										textField_11 = new JTextField();
										textField_11.setToolTipText("");
										textField_11.setColumns(10);
										textField_11.setBounds(229, 67, 194, 26);
										pnlNoviAdresa_2.add(textField_11);
										
										textField_12 = new JTextField();
										textField_12.setToolTipText("");
										textField_12.setColumns(10);
										textField_12.setBounds(229, 103, 194, 26);
										pnlNoviAdresa_2.add(textField_12);
										
										JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
										tabbedPane.setBounds(481, 171, 469, 137);
										pnlProizvodjacNovi.add(tabbedPane);
										
										JPanel panel = new JPanel();
										tabbedPane.addTab("New tab", null, panel, null);
										
										JPanel pnlNoviAdresa_2_1 = new JPanel();
										pnlNoviAdresa_2_1.setLayout(null);
										pnlNoviAdresa_2_1.setBackground(Color.WHITE);
										tabbedPane.addTab("New tab", null, pnlNoviAdresa_2_1, null);
										
										JLabel lblOsnovniPBgp_5_1_1 = new JLabel("Село:");
										lblOsnovniPBgp_5_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
										lblOsnovniPBgp_5_1_1.setBounds(28, 61, 170, 26);
										pnlNoviAdresa_2_1.add(lblOsnovniPBgp_5_1_1);
										
										JLabel lblOsnovniPBgp_1_1_2_1 = new JLabel("Место/Град :");
										lblOsnovniPBgp_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
										lblOsnovniPBgp_1_1_2_1.setBounds(28, 25, 170, 26);
										pnlNoviAdresa_2_1.add(lblOsnovniPBgp_1_1_2_1);
										
										JLabel lblOsnovniPBgp_2_1_1_1 = new JLabel("Улица и број :");
										lblOsnovniPBgp_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
										lblOsnovniPBgp_2_1_1_1.setBounds(28, 97, 170, 26);
										pnlNoviAdresa_2_1.add(lblOsnovniPBgp_2_1_1_1);
										
										textField_9 = new JTextField();
										textField_9.setToolTipText("");
										textField_9.setColumns(10);
										textField_9.setBounds(229, 31, 194, 26);
										pnlNoviAdresa_2_1.add(textField_9);
										
										textField_13 = new JTextField();
										textField_13.setToolTipText("");
										textField_13.setColumns(10);
										textField_13.setBounds(229, 67, 194, 26);
										pnlNoviAdresa_2_1.add(textField_13);
										
										textField_14 = new JTextField();
										textField_14.setToolTipText("");
										textField_14.setColumns(10);
										textField_14.setBounds(229, 103, 194, 26);
										pnlNoviAdresa_2_1.add(textField_14);
		pnlProizvodjac.add(jspProizvodjac);

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
