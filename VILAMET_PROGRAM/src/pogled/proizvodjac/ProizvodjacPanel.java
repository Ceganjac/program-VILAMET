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
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ProizvodjacPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;

	protected JTable tblProizvodjac;
	private JTextField txtOsnovniBpg;
	private JTextField txtOsnovniPib;
	private JTextField txtOsnovniTRacun;
	private JTextField txtOsnovniTel;
	private JTextField txtOsnovniEmail;
	private JTextField txtAdresaMestoG;
	private JTextField txtAdresaSelo;
	private JTextField txtAdresaUlicaBr;
	private JTextField txtFizickoIme;
	private JTextField txtFizickoPrezime;
	private JTextField txtFizickoJmbg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtPravnoMaticni;

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
		jspProizvodjac.setBounds(117, 90, 1107, 370);

		/*
		 * jspProizvodjac.setPreferredSize(new Dimension(335,290));
		 * jspProizvodjac.setMaximumSize(new Dimension(335,290));
		 * jspProizvodjac.setMinimumSize(new Dimension(335,290));
		 */

		JPanel pnlProizvodjacNovi = new JPanel();
		pnlProizvodjacNovi.setBounds(117, 542, 1107, 335);
		pnlProizvodjacNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlProizvodjacNovi.setBackground(Color.WHITE);

		JButton btnNoviIzbrisi = new JButton("Испразни поља");
		btnNoviIzbrisi.setBounds(952, 281, 139, 39);
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
		btnNoviDodaj.setBounds(952, 232, 139, 39);
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
		pnlNoviOsnovni.setBounds(10, 10, 461, 261);
		pnlNoviOsnovni.setBackground(Color.WHITE);

		// linija sa naslovom - panel NoviOsnovni
		pnlNoviOsnovni.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), // ili neki drugi
																									// border
				"Основни подаци", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		pnlProizvodjacNovi.setLayout(null);
		pnlProizvodjacNovi.add(btnNoviIzbrisi);
		pnlProizvodjacNovi.add(btnNoviDodaj);
		pnlProizvodjacNovi.add(pnlNoviOsnovni);
		pnlNoviOsnovni.setLayout(null);

		JLabel lblOsnovniSpdv = new JLabel("Систем ПДВ-а :");
		lblOsnovniSpdv.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniSpdv.setBounds(28, 61, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniSpdv);

		JLabel lblOsnovniBpg = new JLabel("Број пољ. газдинства :");
		lblOsnovniBpg.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniBpg.setBounds(28, 25, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniBpg);

		JLabel lblOsnovniPib = new JLabel("ПИБ :");
		lblOsnovniPib.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniPib.setBounds(28, 97, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniPib);

		JLabel lblOsnovniTRacun = new JLabel("Текући рачун :");
		lblOsnovniTRacun.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniTRacun.setBounds(28, 133, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniTRacun);

		JLabel lblOsnovniTel = new JLabel("Телефон :");
		lblOsnovniTel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniTel.setBounds(28, 169, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniTel);

		JLabel lblOsnovniEmail = new JLabel("Email :");
		lblOsnovniEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOsnovniEmail.setBounds(28, 205, 170, 26);
		pnlNoviOsnovni.add(lblOsnovniEmail);

		txtOsnovniBpg = new JTextField();
		txtOsnovniBpg.setToolTipText("");
		txtOsnovniBpg.setColumns(10);
		txtOsnovniBpg.setBounds(229, 31, 194, 26);
		pnlNoviOsnovni.add(txtOsnovniBpg);

		txtOsnovniPib = new JTextField();
		txtOsnovniPib.setToolTipText("");
		txtOsnovniPib.setColumns(10);
		txtOsnovniPib.setBounds(229, 103, 194, 26);
		pnlNoviOsnovni.add(txtOsnovniPib);

		txtOsnovniTRacun = new JTextField();
		txtOsnovniTRacun.setToolTipText("");
		txtOsnovniTRacun.setColumns(10);
		txtOsnovniTRacun.setBounds(229, 139, 194, 26);
		pnlNoviOsnovni.add(txtOsnovniTRacun);

		txtOsnovniTel = new JTextField();
		txtOsnovniTel.setToolTipText("");
		txtOsnovniTel.setColumns(10);
		txtOsnovniTel.setBounds(229, 175, 194, 26);
		pnlNoviOsnovni.add(txtOsnovniTel);

		txtOsnovniEmail = new JTextField();
		txtOsnovniEmail.setToolTipText("");
		txtOsnovniEmail.setColumns(10);
		txtOsnovniEmail.setBounds(229, 211, 194, 26);
		pnlNoviOsnovni.add(txtOsnovniEmail);
		
		// sistemi PDV
		String[] pdv = {"Газдинство у систему ПДВ-а", "Није обавезник ПДВ-а"};
		
		JComboBox cmbSistemPdv = new JComboBox(pdv);
		cmbSistemPdv.setBounds(229, 66, 194, 26);
		pnlNoviOsnovni.add(cmbSistemPdv);
		
		add(pnlProizvodjac);
		pnlProizvodjac.setLayout(null);
		pnlProizvodjac.add(lblProizvodjacPregled);
		pnlProizvodjac.add(lblProizvodjacUnos);
		pnlProizvodjac.add(pnlProizvodjacNovi);

		JPanel pnlNoviAdresa = new JPanel();
		pnlNoviAdresa.setBorder(new TitledBorder(null, "\u0410\u0434\u0440\u0435\u0441\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNoviAdresa.setLayout(null);

		pnlNoviAdresa.setBackground(Color.WHITE);
		pnlNoviAdresa.setBounds(481, 10, 461, 151);
		pnlProizvodjacNovi.add(pnlNoviAdresa);

		JLabel lblAdresaSelo = new JLabel("Село:");
		lblAdresaSelo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAdresaSelo.setBounds(28, 60, 170, 26);
		pnlNoviAdresa.add(lblAdresaSelo);

		JLabel lblAdresaMestoG = new JLabel("Место/Град :");
		lblAdresaMestoG.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAdresaMestoG.setBounds(28, 25, 170, 26);
		pnlNoviAdresa.add(lblAdresaMestoG);

		JLabel lblAdresaUlicaBr = new JLabel("Улица и број :");
		lblAdresaUlicaBr.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAdresaUlicaBr.setBounds(28, 95, 170, 26);
		pnlNoviAdresa.add(lblAdresaUlicaBr);

		txtAdresaMestoG = new JTextField();
		txtAdresaMestoG.setToolTipText("");
		txtAdresaMestoG.setColumns(10);
		txtAdresaMestoG.setBounds(229, 25, 194, 26);
		pnlNoviAdresa.add(txtAdresaMestoG);

		txtAdresaSelo = new JTextField();
		txtAdresaSelo.setToolTipText("");
		txtAdresaSelo.setColumns(10);
		txtAdresaSelo.setBounds(229, 60, 194, 26);
		pnlNoviAdresa.add(txtAdresaSelo);

		txtAdresaUlicaBr = new JTextField();
		txtAdresaUlicaBr.setToolTipText("");
		txtAdresaUlicaBr.setColumns(10);
		txtAdresaUlicaBr.setBounds(229, 95, 194, 26);
		pnlNoviAdresa.add(txtAdresaUlicaBr);
		
		JLayeredPane lpnFizickoPravno = new JLayeredPane();
		lpnFizickoPravno.setBorder(new TitledBorder(null, "\u0424\u0438\u0437\u0438\u0447\u043A\u043E / \u041F\u0440\u0430\u0432\u043D\u043E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lpnFizickoPravno.setBounds(481, 171, 461, 153);
		pnlProizvodjacNovi.add(lpnFizickoPravno);
		lpnFizickoPravno.setLayout(new CardLayout(0, 0));
		
		JPanel pnlFizicko = new JPanel();
		pnlFizicko.setBorder(null);
		pnlFizicko.setBackground(Color.WHITE);
		lpnFizickoPravno.add(pnlFizicko, "pnlFizicko");
		pnlFizicko.setLayout(null);
		
		JLabel lblFizickoIme = new JLabel("Име :");
		lblFizickoIme.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFizickoIme.setBounds(23, 25, 170, 26);
		pnlFizicko.add(lblFizickoIme);
		
		JLabel lblFizickoPrezime = new JLabel("Презиме :");
		lblFizickoPrezime.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFizickoPrezime.setBounds(23, 60, 170, 26);
		pnlFizicko.add(lblFizickoPrezime);
		
		JLabel lblFizickoJmbg = new JLabel("ЈМБГ");
		lblFizickoJmbg.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFizickoJmbg.setBounds(23, 95, 170, 26);
		pnlFizicko.add(lblFizickoJmbg);
		
		txtFizickoIme = new JTextField();
		txtFizickoIme.setToolTipText("");
		txtFizickoIme.setColumns(10);
		txtFizickoIme.setBounds(230, 25, 194, 26);
		pnlFizicko.add(txtFizickoIme);
		
		txtFizickoPrezime = new JTextField();
		txtFizickoPrezime.setToolTipText("");
		txtFizickoPrezime.setColumns(10);
		txtFizickoPrezime.setBounds(230, 60, 194, 26);
		pnlFizicko.add(txtFizickoPrezime);
		
		txtFizickoJmbg = new JTextField();
		txtFizickoJmbg.setToolTipText("");
		txtFizickoJmbg.setColumns(10);
		txtFizickoJmbg.setBounds(230, 95, 194, 26);
		pnlFizicko.add(txtFizickoJmbg);
		
		JPanel pnlPravno = new JPanel();
		pnlPravno.setBackground(Color.WHITE);
		lpnFizickoPravno.add(pnlPravno, "pnlPravno");
		pnlPravno.setLayout(null);
		
		JLabel lblPravnoMaticni = new JLabel("Матични број :");
		lblPravnoMaticni.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPravnoMaticni.setBounds(10, 10, 170, 26);
		pnlPravno.add(lblPravnoMaticni);
		
		JLabel lblPravnoNaziv = new JLabel("Пун назив фирме :");
		lblPravnoNaziv.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPravnoNaziv.setBounds(10, 46, 170, 26);
		pnlPravno.add(lblPravnoNaziv);
		
		txtPravnoMaticni = new JTextField();
		txtPravnoMaticni.setToolTipText("");
		txtPravnoMaticni.setColumns(10);
		txtPravnoMaticni.setBounds(222, 16, 194, 26);
		pnlPravno.add(txtPravnoMaticni);
		
		JTextArea txaPravnoNaziv = new JTextArea();
		txaPravnoNaziv.setBackground(Color.LIGHT_GRAY);
		txaPravnoNaziv.setBounds(222, 54, 194, 55);
		pnlPravno.add(txaPravnoNaziv);
		
		JRadioButton rdbNoviFizicko = new JRadioButton("физичко лице");
		rdbNoviFizicko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) lpnFizickoPravno.getLayout();
				cl.show(lpnFizickoPravno, "pnlFizicko");
			}
		});
		buttonGroup.add(rdbNoviFizicko);
		rdbNoviFizicko.setBounds(20, 281, 105, 21);
		pnlProizvodjacNovi.add(rdbNoviFizicko);
		
		JRadioButton rdvNoviPravno = new JRadioButton("правно лице");
		rdvNoviPravno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) lpnFizickoPravno.getLayout();
				cl.show(lpnFizickoPravno, "pnlPravno");
			}
		});
		buttonGroup.add(rdvNoviPravno);
		rdvNoviPravno.setBounds(159, 281, 105, 21);
		pnlProizvodjacNovi.add(rdvNoviPravno);
		pnlProizvodjac.add(jspProizvodjac);

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
