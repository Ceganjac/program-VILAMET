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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.CardLayout;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class ProizvodjacPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelFizicko;
	private DefaultTableModel modelPravno;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tblFizicko;
	private JTable tblPravno;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public ProizvodjacPanel() {

		setPreferredSize(new Dimension(screenSirina - 300, screenVisina - 50));
		setBackground(Color.white);

		// pnlProizvodjac ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlProizvodjac = new JPanel();
		pnlProizvodjac.setBackground(Color.white);
		/*
		 * heder.setBackground(Color.LIGHT_GRAY); heder.setPreferredSize(new
		 * Dimension(heder.getWidth(), 30));
		 */

		/*
		 * Sistem PDV
		 */
		String[] pdv = { "Газдинство у систему ПДВ-а", "Није обавезник ПДВ-а" };
		setLayout(new CardLayout(0, 0));

		JTabbedPane tpnProizvodjacPr = new JTabbedPane(JTabbedPane.TOP);
		tpnProizvodjacPr.setBackground(Color.WHITE);
		tpnProizvodjacPr.setForeground(new Color(0, 0, 0));
		tpnProizvodjacPr.setBorder(null);
		GroupLayout gl_pnlProizvodjac = new GroupLayout(pnlProizvodjac);
		gl_pnlProizvodjac.setHorizontalGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup().addGap(120)
						.addComponent(tpnProizvodjacPr, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(300, Short.MAX_VALUE)));
		gl_pnlProizvodjac.setVerticalGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup().addGap(40)
						.addComponent(tpnProizvodjacPr, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(380, Short.MAX_VALUE)));

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * PANEL FIZIČKA LICA
		 */

		JPanel pnlTFizicka = new JPanel();
		pnlTFizicka.setBackground(Color.WHITE);
		pnlTFizicka.setBorder(null);
		tpnProizvodjacPr.addTab("Физичка лица", null, pnlTFizicka, null);
		tpnProizvodjacPr.setBackgroundAt(0, Color.WHITE);

		// jspScrollPane
		JScrollPane jspFizicko = new JScrollPane();
		pnlTFizicka.add(jspFizicko);

		// Tabela Fizička lica
		tblFizicko = new JTable();
		tblFizicko.setSelectionBackground(new Color(153, 255, 153));
		tblFizicko.setRowHeight(25);
		tblFizicko.setFont(new Font("Arial", Font.PLAIN, 12));
		tblFizicko.setBackground(Color.WHITE);

		// heder tabele tblFizicko
		JTableHeader hederF = tblFizicko.getTableHeader();
		hederF.setBackground(Color.LIGHT_GRAY);
		hederF.setPreferredSize(new Dimension(hederF.getWidth(), 30));

		// Inicijalizacija modela tabele
		String[] koloneF = { "Редни бр.", "ИД ", "Име", "Презиме", "ЈМБГ", "БПГ", "ПДВ", "Текући рачун", "ПИБ",
				"Tелефон", "Е-пошта", "Опције" };
		modelFizicko = new DefaultTableModel();
		modelFizicko.setColumnIdentifiers(koloneF);
		tblFizicko.setModel(modelFizicko);

		// render za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRendererF = new DefaultTableCellRenderer();
		centerRendererF.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < tblFizicko.getColumnCount() - 1; i++) {
			tblFizicko.getColumnModel().getColumn(i).setCellRenderer(centerRendererF);
		}

		jspFizicko.setViewportView(tblFizicko);

		JLabel lblProizvodjacPregled = new JLabel("Преглед унетих произвођача - физичка лица");
		lblProizvodjacPregled.setFont(new Font("Arial", Font.PLAIN, 20));
		GroupLayout gl_pnlTFizicka = new GroupLayout(pnlTFizicka);
		gl_pnlTFizicka.setHorizontalGroup(gl_pnlTFizicka.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTFizicka.createSequentialGroup().addGap(30)
						.addGroup(gl_pnlTFizicka.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 434,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jspFizicko, GroupLayout.PREFERRED_SIZE, 1128, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(37, Short.MAX_VALUE)));
		gl_pnlTFizicka.setVerticalGroup(gl_pnlTFizicka.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTFizicka.createSequentialGroup().addGap(50)
						.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGap(25)
						.addComponent(jspFizicko, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(165, Short.MAX_VALUE)));
		pnlTFizicka.setLayout(gl_pnlTFizicka);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		 * PANEL PRAVNA LICA
		 */

		JPanel pnlTPravna = new JPanel();
		pnlTPravna.setBackground(Color.WHITE);
		tpnProizvodjacPr.addTab("Правна лица", null, pnlTPravna, null);

		JScrollPane jspPravno = new JScrollPane();

		JLabel lblProizvodjacPregled_1 = new JLabel("Преглед унетих произвођача - правна лица");
		lblProizvodjacPregled_1.setFont(new Font("Arial", Font.PLAIN, 20));
		GroupLayout gl_pnlTPravna = new GroupLayout(pnlTPravna);
		gl_pnlTPravna
				.setHorizontalGroup(gl_pnlTPravna.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlTPravna.createSequentialGroup().addGap(30)
								.addGroup(gl_pnlTPravna.createParallelGroup(Alignment.LEADING)
										.addComponent(jspPravno, GroupLayout.PREFERRED_SIZE, 1128,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProizvodjacPregled_1, GroupLayout.PREFERRED_SIZE, 434,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(37, Short.MAX_VALUE)));
		gl_pnlTPravna.setVerticalGroup(gl_pnlTPravna.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlTPravna
				.createSequentialGroup().addGap(50)
				.addComponent(lblProizvodjacPregled_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(25).addComponent(jspPravno, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(165, Short.MAX_VALUE)));

		// Tabela pravno lice
		tblPravno = new JTable();
		tblPravno.setSelectionBackground(new Color(153, 255, 153));
		tblPravno.setRowHeight(25);
		tblPravno.setFont(new Font("Arial", Font.PLAIN, 12));
		tblPravno.setBackground(Color.WHITE);

		// heder tabele tblpRAVNO
		JTableHeader hederP = tblPravno.getTableHeader();
		hederP.setBackground(Color.LIGHT_GRAY);
		hederP.setPreferredSize(new Dimension(hederP.getWidth(), 30));

		// Inicijalizacija modela tabele
		String[] koloneP = { "Редни бр.", "ИД ", "Назив", "Матични бр.", "БПГ", "ПДВ", "Текући рачун", "ПИБ", "Tелефон",
				"Е-пошта", "Опције" };
		modelPravno = new DefaultTableModel();
		modelPravno.setColumnIdentifiers(koloneP);
		tblPravno.setModel(modelPravno);

		// render za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRendererP = new DefaultTableCellRenderer();
		centerRendererP.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < tblFizicko.getColumnCount() - 1; i++) {
			tblFizicko.getColumnModel().getColumn(i).setCellRenderer(centerRendererP);
		}

		jspPravno.setViewportView(tblPravno);
		pnlTPravna.setLayout(gl_pnlTPravna);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel pnlTNovi = new JPanel();
		pnlTNovi.setBackground(Color.WHITE);
		pnlTNovi.setBorder(null);
		tpnProizvodjacPr.addTab("Унос новог", null, pnlTNovi, null);

		JLabel lblProizvodjacUnos = new JLabel("Унесите новог произвођача");
		lblProizvodjacUnos.setFont(new Font("Arial", Font.PLAIN, 18));

		JPanel pnlNoviGlavni = new JPanel();
		pnlNoviGlavni.setBorder(null);
		pnlNoviGlavni.setBackground(Color.WHITE);

		JPanel pnlGlavniOsnovni = new JPanel();
		pnlGlavniOsnovni.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)),
				"\u041E\u0441\u043D\u043E\u0432\u043D\u0438 \u043F\u043E\u0434\u0430\u0446\u0438", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlGlavniOsnovni.setBackground(Color.WHITE);

		JLabel lblOsnovniBpg = new JLabel("Број пољ. газдинства :");
		lblOsnovniBpg.setFont(new Font("Arial", Font.PLAIN, 16));

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);

		JLabel lblOsnovniSpdv = new JLabel("Систем ПДВ-а :");
		lblOsnovniSpdv.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox cmbSistemPdv = new JComboBox(new Object[] {});
		cmbSistemPdv.setBackground(Color.WHITE);

		JLabel lblOsnovniPib = new JLabel("ПИБ :");
		lblOsnovniPib.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);

		JLabel lblOsnovniTRacun = new JLabel("Текући рачун :");
		lblOsnovniTRacun.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setColumns(10);

		JLabel lblOsnovniTel = new JLabel("Телефон :");
		lblOsnovniTel.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setColumns(10);

		JLabel lblOsnovniEmail = new JLabel("Email :");
		lblOsnovniEmail.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		GroupLayout gl_pnlGlavniOsnovni = new GroupLayout(pnlGlavniOsnovni);
		gl_pnlGlavniOsnovni.setHorizontalGroup(
			gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniBpg, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniSpdv, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(cmbSistemPdv, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniPib, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniTRacun, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniTel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniEmail, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlGlavniOsnovni.setVerticalGroup(
			gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniBpg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniSpdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addGap(5)
							.addComponent(cmbSistemPdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addGroup(gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniPib, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniTRacun, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniTel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOsnovniEmail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
		);
		pnlGlavniOsnovni.setLayout(gl_pnlGlavniOsnovni);

		JRadioButton rdbNoviFizicko = new JRadioButton("физичко лице");
		rdbNoviFizicko.setBackground(Color.WHITE);

		JRadioButton rdvNoviPravno = new JRadioButton("правно лице");
		rdvNoviPravno.setBackground(Color.WHITE);

		JLayeredPane lpnFizickoPravno = new JLayeredPane();
		lpnFizickoPravno.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)),
				"\u0424\u0438\u0437\u0438\u0447\u043A\u043E / \u041F\u0440\u0430\u0432\u043D\u043E",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lpnFizickoPravno.setLayout(new CardLayout(0, 0));

		JPanel pnlGlavniAdresa = new JPanel();
		pnlGlavniAdresa.setBorder(
				new TitledBorder(new LineBorder(new Color(192, 192, 192)), "\u0410\u0434\u0440\u0435\u0441\u0430",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlGlavniAdresa.setBackground(Color.WHITE);

		JLabel lblAdresaMestoG = new JLabel("Место/Град :");
		lblAdresaMestoG.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setColumns(10);

		JLabel lblAdresaSelo = new JLabel("Село:");
		lblAdresaSelo.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_6 = new JTextField();
		textField_6.setToolTipText("");
		textField_6.setColumns(10);

		JLabel lblAdresaUlicaBr = new JLabel("Улица и број :");
		lblAdresaUlicaBr.setFont(new Font("Arial", Font.PLAIN, 16));

		textField_7 = new JTextField();
		textField_7.setToolTipText("");
		textField_7.setColumns(10);
		GroupLayout gl_pnlGlavniAdresa = new GroupLayout(pnlGlavniAdresa);
		gl_pnlGlavniAdresa.setHorizontalGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addGroup(gl_pnlGlavniAdresa.createSequentialGroup().addGap(30).addGroup(gl_pnlGlavniAdresa
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGlavniAdresa.createSequentialGroup()
								.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 170,
										GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniAdresa.createSequentialGroup()
								.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 170,
										GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniAdresa.createSequentialGroup()
								.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 170,
										GroupLayout.PREFERRED_SIZE)
								.addGap(20).addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 194,
										GroupLayout.PREFERRED_SIZE)))));
		gl_pnlGlavniAdresa.setVerticalGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
				.addGap(0, 140, Short.MAX_VALUE)
				.addGroup(gl_pnlGlavniAdresa.createSequentialGroup().addGap(10)
						.addGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE))));
		pnlGlavniAdresa.setLayout(gl_pnlGlavniAdresa);
		
				JButton btnNoviDodaj = new JButton("Додај");
				btnNoviDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
				btnNoviDodaj.setBackground(new Color(0, 194, 0));
		
				JButton btnNoviIzbrisi = new JButton("Испразни поља");
				btnNoviIzbrisi.setForeground(Color.RED);
				btnNoviIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
				btnNoviIzbrisi.setBackground(Color.WHITE);
		GroupLayout gl_pnlNoviGlavni = new GroupLayout(pnlNoviGlavni);
		gl_pnlNoviGlavni.setHorizontalGroup(
			gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlNoviGlavni.createSequentialGroup()
					.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlGlavniOsnovni, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbNoviFizicko, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rdvNoviPravno, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
							.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlNoviGlavni.createSequentialGroup()
							.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnlGlavniAdresa, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
								.addComponent(lpnFizickoPravno, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
							.addGap(44))))
		);
		gl_pnlNoviGlavni.setVerticalGroup(
			gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
					.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
							.addComponent(pnlGlavniAdresa, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(lpnFizickoPravno, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlGlavniOsnovni, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbNoviFizicko)
								.addComponent(rdvNoviPravno)))
						.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		pnlNoviGlavni.setLayout(gl_pnlNoviGlavni);
		GroupLayout gl_pnlTNovi = new GroupLayout(pnlTNovi);
		gl_pnlTNovi.setHorizontalGroup(
			gl_pnlTNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTNovi.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlTNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlNoviGlavni, GroupLayout.PREFERRED_SIZE, 991, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		gl_pnlTNovi.setVerticalGroup(
			gl_pnlTNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTNovi.createSequentialGroup()
					.addGap(50)
					.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(pnlNoviGlavni, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		pnlTNovi.setLayout(gl_pnlTNovi);
		pnlProizvodjac.setLayout(gl_pnlProizvodjac);
		add(pnlProizvodjac, "name_1784826073300");

	}

	public DefaultTableModel getModel() {
		return modelFizicko;
	}
}
