package pogled.paneli;

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
import pogled.celleditor.ProizvodjacCellEditor;
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

		setPreferredSize(new Dimension(screenSirina - 300, screenVisina-50));
		setBackground(Color.white);
		
		// pnlProizvodjac ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlProizvodjac = new JPanel();
		pnlProizvodjac.setBackground(Color.white);

		JLabel lblProizvodjacPregled = new JLabel("Преглед унетих произвођача");
		lblProizvodjacPregled.setFont(new Font("Arial", Font.PLAIN, 20));
		lblProizvodjacPregled.setOpaque(true);

		JLabel lblProizvodjacUnos = new JLabel("Унесите новог произвођача");
		lblProizvodjacUnos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblProizvodjacUnos.setOpaque(true);

		JScrollPane jspProizvodjac = new JScrollPane();

		/*
		 * jspProizvodjac.setPreferredSize(new Dimension(335,290));
		 * jspProizvodjac.setMaximumSize(new Dimension(335,290));
		 * jspProizvodjac.setMinimumSize(new Dimension(335,290));
		 */

		JPanel pnlProizvodjacNovi = new JPanel();
		pnlProizvodjacNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlProizvodjacNovi.setBackground(Color.WHITE);

		JButton btnNoviIzbrisi = new JButton("Испразни поља");
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

		jspProizvodjac.setViewportView(tblProizvodjac);

		JPanel pnlNoviOsnovni = new JPanel();
		pnlNoviOsnovni.setBackground(Color.WHITE);

		// linija sa naslovom - panel NoviOsnovni
		pnlNoviOsnovni.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), // ili neki drugi
																									// border
				"Основни подаци", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblOsnovniSpdv = new JLabel("Систем ПДВ-а :");
		lblOsnovniSpdv.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblOsnovniBpg = new JLabel("Број пољ. газдинства :");
		lblOsnovniBpg.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblOsnovniPib = new JLabel("ПИБ :");
		lblOsnovniPib.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblOsnovniTRacun = new JLabel("Текући рачун :");
		lblOsnovniTRacun.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblOsnovniTel = new JLabel("Телефон :");
		lblOsnovniTel.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblOsnovniEmail = new JLabel("Email :");
		lblOsnovniEmail.setFont(new Font("Arial", Font.PLAIN, 16));

		txtOsnovniBpg = new JTextField();
		txtOsnovniBpg.setToolTipText("");
		txtOsnovniBpg.setColumns(10);

		txtOsnovniPib = new JTextField();
		txtOsnovniPib.setToolTipText("");
		txtOsnovniPib.setColumns(10);

		txtOsnovniTRacun = new JTextField();
		txtOsnovniTRacun.setToolTipText("");
		txtOsnovniTRacun.setColumns(10);

		txtOsnovniTel = new JTextField();
		txtOsnovniTel.setToolTipText("");
		txtOsnovniTel.setColumns(10);

		txtOsnovniEmail = new JTextField();
		txtOsnovniEmail.setToolTipText("");
		txtOsnovniEmail.setColumns(10);
		
		// sistemi PDV
		String[] pdv = {"Газдинство у систему ПДВ-а", "Није обавезник ПДВ-а"};
		
		JComboBox cmbSistemPdv = new JComboBox(pdv);
		cmbSistemPdv.setBackground(Color.WHITE);

		JPanel pnlNoviAdresa = new JPanel();
		pnlNoviAdresa.setBorder(new TitledBorder(null, "\u0410\u0434\u0440\u0435\u0441\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		pnlNoviAdresa.setBackground(Color.WHITE);

		JLabel lblAdresaSelo = new JLabel("Село:");
		lblAdresaSelo.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblAdresaMestoG = new JLabel("Место/Град :");
		lblAdresaMestoG.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblAdresaUlicaBr = new JLabel("Улица и број :");
		lblAdresaUlicaBr.setFont(new Font("Arial", Font.PLAIN, 16));

		txtAdresaMestoG = new JTextField();
		txtAdresaMestoG.setToolTipText("");
		txtAdresaMestoG.setColumns(10);

		txtAdresaSelo = new JTextField();
		txtAdresaSelo.setToolTipText("");
		txtAdresaSelo.setColumns(10);

		txtAdresaUlicaBr = new JTextField();
		txtAdresaUlicaBr.setToolTipText("");
		txtAdresaUlicaBr.setColumns(10);
		
		JLayeredPane lpnFizickoPravno = new JLayeredPane();
		lpnFizickoPravno.setBorder(new TitledBorder(null, "\u0424\u0438\u0437\u0438\u0447\u043A\u043E / \u041F\u0440\u0430\u0432\u043D\u043E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel pnlFizicko = new JPanel();
		pnlFizicko.setBorder(null);
		pnlFizicko.setBackground(Color.WHITE);
		
		JLabel lblFizickoIme = new JLabel("Име :");
		lblFizickoIme.setBounds(20, 10, 170, 26);
		lblFizickoIme.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblFizickoPrezime = new JLabel("Презиме :");
		lblFizickoPrezime.setBounds(22, 45, 170, 26);
		lblFizickoPrezime.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblFizickoJmbg = new JLabel("ЈМБГ");
		lblFizickoJmbg.setBounds(20, 80, 170, 26);
		lblFizickoJmbg.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtFizickoIme = new JTextField();
		txtFizickoIme.setBounds(220, 83, 194, 26);
		txtFizickoIme.setToolTipText("");
		txtFizickoIme.setColumns(10);
		
		txtFizickoPrezime = new JTextField();
		txtFizickoPrezime.setBounds(220, 48, 194, 26);
		txtFizickoPrezime.setToolTipText("");
		txtFizickoPrezime.setColumns(10);
		
		txtFizickoJmbg = new JTextField();
		txtFizickoJmbg.setBounds(220, 10, 194, 26);
		txtFizickoJmbg.setToolTipText("");
		txtFizickoJmbg.setColumns(10);
		
		JPanel pnlPravno = new JPanel();
		pnlPravno.setBackground(Color.WHITE);
		
		JLabel lblPravnoMaticni = new JLabel("Матични број :");
		lblPravnoMaticni.setBounds(10, 16, 170, 26);
		lblPravnoMaticni.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblPravnoNaziv = new JLabel("Пун назив фирме :");
		lblPravnoNaziv.setBounds(10, 58, 170, 26);
		lblPravnoNaziv.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtPravnoMaticni = new JTextField();
		txtPravnoMaticni.setBounds(222, 22, 194, 26);
		txtPravnoMaticni.setToolTipText("");
		txtPravnoMaticni.setColumns(10);
		
		JTextArea txaPravnoNaziv = new JTextArea();
		txaPravnoNaziv.setBounds(222, 66, 194, 46);
		txaPravnoNaziv.setBackground(new Color(152, 251, 152));
		
		JRadioButton rdbNoviFizicko = new JRadioButton("физичко лице");
		rdbNoviFizicko.setBackground(Color.WHITE);
		rdbNoviFizicko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) lpnFizickoPravno.getLayout();
				cl.show(lpnFizickoPravno, "pnlFizicko");
			}
		});
		buttonGroup.add(rdbNoviFizicko);
		
		JRadioButton rdvNoviPravno = new JRadioButton("правно лице");
		rdvNoviPravno.setBackground(Color.WHITE);
		rdvNoviPravno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) lpnFizickoPravno.getLayout();
				cl.show(lpnFizickoPravno, "pnlPravno");
			}
		});
		buttonGroup.add(rdvNoviPravno);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlProizvodjac, GroupLayout.PREFERRED_SIZE, 1620, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlProizvodjac, GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE)
		);
		GroupLayout gl_pnlProizvodjac = new GroupLayout(pnlProizvodjac);
		gl_pnlProizvodjac.setHorizontalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblProizvodjacPregled, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addComponent(jspProizvodjac, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
						.addComponent(lblProizvodjacUnos, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(403, Short.MAX_VALUE))
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(120)
					.addComponent(pnlProizvodjacNovi, GroupLayout.PREFERRED_SIZE, 1107, Short.MAX_VALUE)
					.addGap(416))
		);
		gl_pnlProizvodjac.setVerticalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(40)
					.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(jspProizvodjac, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(pnlProizvodjacNovi, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addGap(208))
		);
		GroupLayout gl_pnlProizvodjacNovi = new GroupLayout(pnlProizvodjacNovi);
		gl_pnlProizvodjacNovi.setHorizontalGroup(
			gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(8)
							.addComponent(pnlNoviOsnovni, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbNoviFizicko, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(rdvNoviPravno, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lpnFizickoPravno, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addComponent(pnlNoviAdresa, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
					.addGap(33))
		);
		gl_pnlProizvodjacNovi.setVerticalGroup(
			gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(0)
							.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
									.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addGap(21)
									.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addComponent(pnlNoviAdresa, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(lpnFizickoPravno, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlNoviOsnovni, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbNoviFizicko)
						.addComponent(rdvNoviPravno))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		lpnFizickoPravno.setLayout(new CardLayout(0, 0));
		lpnFizickoPravno.add(pnlFizicko, "pnlFizicko");
		pnlFizicko.setLayout(null);
		pnlFizicko.add(lblFizickoIme);
		pnlFizicko.add(lblFizickoPrezime);
		pnlFizicko.add(lblFizickoJmbg);
		pnlFizicko.add(txtFizickoJmbg);
		pnlFizicko.add(txtFizickoPrezime);
		pnlFizicko.add(txtFizickoIme);
		lpnFizickoPravno.add(pnlPravno, "pnlPravno");
		pnlPravno.setLayout(null);
		pnlPravno.add(lblPravnoMaticni);
		pnlPravno.add(txtPravnoMaticni);
		pnlPravno.add(lblPravnoNaziv);
		pnlPravno.add(txaPravnoNaziv);
		GroupLayout gl_pnlNoviAdresa = new GroupLayout(pnlNoviAdresa);
		gl_pnlNoviAdresa.setHorizontalGroup(
			gl_pnlNoviAdresa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNoviAdresa.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlNoviAdresa.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNoviAdresa.createSequentialGroup()
							.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtAdresaMestoG, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNoviAdresa.createSequentialGroup()
							.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtAdresaSelo, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNoviAdresa.createSequentialGroup()
							.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlNoviAdresa.setVerticalGroup(
			gl_pnlNoviAdresa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNoviAdresa.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pnlNoviAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAdresaMestoG, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlNoviAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAdresaSelo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlNoviAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
		);
		pnlNoviAdresa.setLayout(gl_pnlNoviAdresa);
		GroupLayout gl_pnlNoviOsnovni = new GroupLayout(pnlNoviOsnovni);
		gl_pnlNoviOsnovni.setHorizontalGroup(
			gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniBpg, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(txtOsnovniBpg, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniSpdv, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(cmbSistemPdv, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniPib, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(txtOsnovniPib, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniTRacun, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(txtOsnovniTRacun, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniTel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(txtOsnovniTel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniEmail, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(txtOsnovniEmail, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlNoviOsnovni.setVerticalGroup(
			gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniBpg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(txtOsnovniBpg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniSpdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addGap(5)
							.addComponent(cmbSistemPdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addGroup(gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniPib, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(txtOsnovniPib, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniTRacun, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(txtOsnovniTRacun, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniTel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(txtOsnovniTel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_pnlNoviOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniEmail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNoviOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(txtOsnovniEmail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
		);
		pnlNoviOsnovni.setLayout(gl_pnlNoviOsnovni);
		pnlProizvodjacNovi.setLayout(gl_pnlProizvodjacNovi);
		pnlProizvodjac.setLayout(gl_pnlProizvodjac);
		setLayout(groupLayout);

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
