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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField txtOsnovniBpg;
	private JTextField txtOsnovniPib;
	private JTextField txtOsnovniTekuci;
	private JTextField txtOsnovniTelefon;
	private JTextField txtOsnovniMejl;
	private JTextField txtAdresaMestoG;
	private JTextField txtAdresaSelo;
	private JTextField txtAdresaUlicaBr;
	private JTextField txtFizickoIme;
	private JTextField txtFizickoPrezime;
	private JTextField txtFizickoJmbg;

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

		// PANEL FIZIČKA LICA

		JPanel pnlPrFizicko = new JPanel();
		pnlPrFizicko.setBackground(Color.WHITE);
		pnlPrFizicko.setBorder(null);
		tpnProizvodjacPr.addTab("Физичка лица", null, pnlPrFizicko, null);
		tpnProizvodjacPr.setBackgroundAt(0, Color.WHITE);

		// jspScrollPane
		JScrollPane jspFizicko = new JScrollPane();
		pnlPrFizicko.add(jspFizicko);

		// Tabela Fizička lica
		tblFizicko = new JTable();
		tblFizicko.setSelectionBackground(new Color(153, 255, 153));
		tblFizicko.setRowHeight(25);
		tblFizicko.setFont(new Font("Arial", Font.PLAIN, 14));
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
		GroupLayout gl_pnlPrFizicko = new GroupLayout(pnlPrFizicko);
		gl_pnlPrFizicko.setHorizontalGroup(gl_pnlPrFizicko.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPrFizicko.createSequentialGroup().addGap(40)
						.addGroup(gl_pnlPrFizicko.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 434,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jspFizicko, GroupLayout.PREFERRED_SIZE, 1128, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(37, Short.MAX_VALUE)));
		gl_pnlPrFizicko.setVerticalGroup(gl_pnlPrFizicko.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPrFizicko.createSequentialGroup().addGap(40)
						.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGap(25)
						.addComponent(jspFizicko, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(150, Short.MAX_VALUE)));
		pnlPrFizicko.setLayout(gl_pnlPrFizicko);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		 * PANEL PRAVNA LICA
		 */

		JPanel pnlPrPravno = new JPanel();
		pnlPrPravno.setBackground(Color.WHITE);
		tpnProizvodjacPr.addTab("Правна лица", null, pnlPrPravno, null);

		JScrollPane jspPravno = new JScrollPane();

		JLabel lblProizvodjacPregled_1 = new JLabel("Преглед унетих произвођача - правна лица");
		lblProizvodjacPregled_1.setFont(new Font("Arial", Font.PLAIN, 20));
		GroupLayout gl_pnlPrPravno = new GroupLayout(pnlPrPravno);
		gl_pnlPrPravno
				.setHorizontalGroup(gl_pnlPrPravno.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlPrPravno.createSequentialGroup().addGap(40)
								.addGroup(gl_pnlPrPravno.createParallelGroup(Alignment.LEADING)
										.addComponent(jspPravno, GroupLayout.PREFERRED_SIZE, 1128,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProizvodjacPregled_1, GroupLayout.PREFERRED_SIZE, 434,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(37, Short.MAX_VALUE)));
		gl_pnlPrPravno.setVerticalGroup(gl_pnlPrPravno.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlPrPravno
				.createSequentialGroup().addGap(40)
				.addComponent(lblProizvodjacPregled_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(25).addComponent(jspPravno, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(150, Short.MAX_VALUE)));

		// Tabela pravno lice
		tblPravno = new JTable();
		tblPravno.setSelectionBackground(new Color(153, 255, 153));
		tblPravno.setRowHeight(25);
		tblPravno.setFont(new Font("Arial", Font.PLAIN, 14));
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

		// okruživanje tabele sa jspPravno
		jspPravno.setViewportView(tblPravno);

		pnlPrPravno.setLayout(gl_pnlPrPravno);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel pnlPrNovi = new JPanel();
		pnlPrNovi.setBackground(Color.WHITE);
		pnlPrNovi.setBorder(null);
		tpnProizvodjacPr.addTab("Унос новог", null, pnlPrNovi, null);

		JLabel lblProizvodjacUnos = new JLabel("Унесите новог произвођача");
		lblProizvodjacUnos.setFont(new Font("Arial", Font.PLAIN, 20));

		JPanel pnlAdresa = new JPanel();
		pnlAdresa.setBorder(
				new TitledBorder(new LineBorder(new Color(192, 192, 192)), "\u0410\u0434\u0440\u0435\u0441\u0430",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlAdresa.setBackground(Color.WHITE);

		JLabel lblAdresaMestoG = new JLabel("Место/Град :");
		lblAdresaMestoG.setFont(new Font("Arial", Font.PLAIN, 16));

		txtAdresaMestoG = new JTextField();
		txtAdresaMestoG.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAdresaMestoG.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdresaMestoG.setToolTipText("");
		txtAdresaMestoG.setColumns(10);

		JLabel lblAdresaSelo = new JLabel("Село:");
		lblAdresaSelo.setFont(new Font("Arial", Font.PLAIN, 16));

		txtAdresaSelo = new JTextField();
		txtAdresaSelo.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAdresaSelo.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdresaSelo.setToolTipText("");
		txtAdresaSelo.setColumns(10);

		JLabel lblAdresaUlicaBr = new JLabel("Улица и број :");
		lblAdresaUlicaBr.setFont(new Font("Arial", Font.PLAIN, 16));

		txtAdresaUlicaBr = new JTextField();
		txtAdresaUlicaBr.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAdresaUlicaBr.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdresaUlicaBr.setToolTipText("");
		txtAdresaUlicaBr.setColumns(10);
		GroupLayout gl_pnlAdresa = new GroupLayout(pnlAdresa);
		gl_pnlAdresa.setHorizontalGroup(
			gl_pnlAdresa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdresa.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlAdresa.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlAdresa.createSequentialGroup()
							.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(txtAdresaMestoG, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAdresa.createSequentialGroup()
							.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtAdresaSelo, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAdresa.createSequentialGroup()
							.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
					.addGap(32))
		);
		gl_pnlAdresa.setVerticalGroup(
			gl_pnlAdresa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdresa.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAdresaMestoG, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAdresaSelo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
		);
		pnlAdresa.setLayout(gl_pnlAdresa);

		JLayeredPane lpnFizickoPravno = new JLayeredPane();
		lpnFizickoPravno.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)),
				"\u0424\u0438\u0437\u0438\u0447\u043A\u043E / \u041F\u0440\u0430\u0432\u043D\u043E",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lpnFizickoPravno.setLayout(new CardLayout(0, 0));

		JPanel pnlOsnovni = new JPanel();
		pnlOsnovni.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)),
				"\u041E\u0441\u043D\u043E\u0432\u043D\u0438 \u043F\u043E\u0434\u0430\u0446\u0438", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlOsnovni.setBackground(Color.WHITE);

		JLabel lblOsnovniBpg = new JLabel("Број пољ. газдинства :");
		lblOsnovniBpg.setFont(new Font("Arial", Font.PLAIN, 16));

		txtOsnovniBpg = new JTextField();
		txtOsnovniBpg.setFont(new Font("Arial", Font.PLAIN, 14));
		txtOsnovniBpg.setHorizontalAlignment(SwingConstants.CENTER);
		txtOsnovniBpg.setToolTipText("");
		txtOsnovniBpg.setColumns(10);

		JLabel lblOsnovniSpdv = new JLabel("Систем ПДВ-а :");
		lblOsnovniSpdv.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox cmbOsnovniSPdv = new JComboBox(new Object[] {});
		cmbOsnovniSPdv.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbOsnovniSPdv.setBackground(Color.WHITE);

		JLabel lblOsnovniPib = new JLabel("ПИБ :");
		lblOsnovniPib.setFont(new Font("Arial", Font.PLAIN, 16));

		txtOsnovniPib = new JTextField();
		txtOsnovniPib.setFont(new Font("Arial", Font.PLAIN, 14));
		txtOsnovniPib.setHorizontalAlignment(SwingConstants.CENTER);
		txtOsnovniPib.setToolTipText("");
		txtOsnovniPib.setColumns(10);

		JLabel lblOsnovniTRacun = new JLabel("Текући рачун :");
		lblOsnovniTRacun.setFont(new Font("Arial", Font.PLAIN, 16));

		txtOsnovniTekuci = new JTextField();
		txtOsnovniTekuci.setFont(new Font("Arial", Font.PLAIN, 14));
		txtOsnovniTekuci.setHorizontalAlignment(SwingConstants.CENTER);
		txtOsnovniTekuci.setToolTipText("");
		txtOsnovniTekuci.setColumns(10);

		JLabel lblOsnovniTel = new JLabel("Телефон :");
		lblOsnovniTel.setFont(new Font("Arial", Font.PLAIN, 16));

		txtOsnovniTelefon = new JTextField();
		txtOsnovniTelefon.setFont(new Font("Arial", Font.PLAIN, 14));
		txtOsnovniTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		txtOsnovniTelefon.setToolTipText("");
		txtOsnovniTelefon.setColumns(10);

		JLabel lblOsnovniEmail = new JLabel("Мејл :");
		lblOsnovniEmail.setFont(new Font("Arial", Font.PLAIN, 16));

		txtOsnovniMejl = new JTextField();
		txtOsnovniMejl.setFont(new Font("Arial", Font.PLAIN, 14));
		txtOsnovniMejl.setHorizontalAlignment(SwingConstants.CENTER);
		txtOsnovniMejl.setToolTipText("");
		txtOsnovniMejl.setColumns(10);
		GroupLayout gl_pnlOsnovni = new GroupLayout(pnlOsnovni);
		gl_pnlOsnovni.setHorizontalGroup(gl_pnlOsnovni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOsnovni.createSequentialGroup().addGap(30)
						.addGroup(gl_pnlOsnovni.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_pnlOsnovni.createSequentialGroup()
										.addComponent(lblOsnovniTel, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(txtOsnovniTelefon))
								.addGroup(gl_pnlOsnovni.createSequentialGroup()
										.addComponent(lblOsnovniEmail, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(txtOsnovniMejl, 220, 220, 220))
								.addGroup(gl_pnlOsnovni.createSequentialGroup()
										.addComponent(lblOsnovniSpdv, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(cmbOsnovniSPdv, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlOsnovni.createSequentialGroup()
										.addComponent(lblOsnovniPib, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(txtOsnovniPib))
								.addGroup(gl_pnlOsnovni.createSequentialGroup()
										.addComponent(lblOsnovniBpg, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(txtOsnovniBpg, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlOsnovni.createSequentialGroup()
										.addComponent(lblOsnovniTRacun, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(txtOsnovniTekuci, GroupLayout.PREFERRED_SIZE, 220,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(30)));
		gl_pnlOsnovni.setVerticalGroup(gl_pnlOsnovni.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlOsnovni
				.createSequentialGroup().addGap(30)
				.addGroup(gl_pnlOsnovni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOsnovniBpg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOsnovniBpg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_pnlOsnovni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOsnovniSpdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbOsnovniSPdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_pnlOsnovni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOsnovniPib, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOsnovniPib, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_pnlOsnovni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOsnovniTRacun, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOsnovniTekuci, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_pnlOsnovni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOsnovniTel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOsnovniTelefon, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_pnlOsnovni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOsnovniEmail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOsnovniMejl, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(3)));
		pnlOsnovni.setLayout(gl_pnlOsnovni);

		JButton btnNoviDodaj = new JButton("Додај");
		btnNoviDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNoviDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviDodaj.setBackground((new Color(153, 255, 153)));

		JButton btnNoviIsprazni = new JButton("Испразни поља");
		btnNoviIsprazni.setForeground(Color.RED);
		btnNoviIsprazni.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIsprazni.setBackground(Color.WHITE);

		JRadioButton rdbNoviFizicko = new JRadioButton("физичко лице");
		rdbNoviFizicko.setBackground(Color.WHITE);

		JRadioButton rdvNoviPravno = new JRadioButton("правно лице");
		rdvNoviPravno.setBackground(Color.WHITE);
		GroupLayout gl_pnlPrNovi = new GroupLayout(pnlPrNovi);
		gl_pnlPrNovi.setHorizontalGroup(
			gl_pnlPrNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPrNovi.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlPrNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlPrNovi.createSequentialGroup()
							.addComponent(pnlOsnovni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_pnlPrNovi.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlPrNovi.createSequentialGroup()
									.addGap(2)
									.addComponent(rdbNoviFizicko, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addComponent(rdvNoviPravno, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlPrNovi.createSequentialGroup()
									.addGap(20)
									.addGroup(gl_pnlPrNovi.createParallelGroup(Alignment.LEADING)
										.addComponent(lpnFizickoPravno, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_pnlPrNovi.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_pnlPrNovi.createSequentialGroup()
												.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
												.addGap(50)
												.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
											.addComponent(pnlAdresa, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE))))))
						.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(185, Short.MAX_VALUE))
		);
		gl_pnlPrNovi.setVerticalGroup(
			gl_pnlPrNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPrNovi.createSequentialGroup()
					.addGap(40)
					.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addGroup(gl_pnlPrNovi.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_pnlPrNovi.createSequentialGroup()
							.addComponent(lpnFizickoPravno, 0, 160, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(pnlAdresa, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlOsnovni, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_pnlPrNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(204)
					.addGroup(gl_pnlPrNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbNoviFizicko)
						.addComponent(rdvNoviPravno)))
		);

		JPanel pnlFizicko = new JPanel();
		pnlFizicko.setBackground(Color.WHITE);
		lpnFizickoPravno.add(pnlFizicko, "name_41249653235500");
		
		JLabel lblFizickoIme = new JLabel("Име :");
		lblFizickoIme.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtFizickoIme = new JTextField();
		txtFizickoIme.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFizickoIme.setToolTipText("");
		txtFizickoIme.setHorizontalAlignment(SwingConstants.CENTER);
		txtFizickoIme.setColumns(10);
		
		JLabel lblFizickoPrezime = new JLabel("Презиме :");
		lblFizickoPrezime.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtFizickoPrezime = new JTextField();
		txtFizickoPrezime.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFizickoPrezime.setToolTipText("");
		txtFizickoPrezime.setHorizontalAlignment(SwingConstants.CENTER);
		txtFizickoPrezime.setColumns(10);
		
		JLabel lblFizickoJmbg = new JLabel("ЈМБГ :");
		lblFizickoJmbg.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtFizickoJmbg = new JTextField();
		txtFizickoJmbg.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFizickoJmbg.setToolTipText("");
		txtFizickoJmbg.setHorizontalAlignment(SwingConstants.CENTER);
		txtFizickoJmbg.setColumns(10);
		GroupLayout gl_pnlFizicko = new GroupLayout(pnlFizicko);
		gl_pnlFizicko.setHorizontalGroup(
			gl_pnlFizicko.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFizicko.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlFizicko.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlFizicko.createSequentialGroup()
							.addComponent(lblFizickoJmbg, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtFizickoJmbg, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlFizicko.createSequentialGroup()
							.addComponent(lblFizickoPrezime, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtFizickoPrezime, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlFizicko.createSequentialGroup()
							.addComponent(lblFizickoIme, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtFizickoIme, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_pnlFizicko.setVerticalGroup(
			gl_pnlFizicko.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlFizicko.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlFizicko.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFizickoIme, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFizickoIme, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlFizicko.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFizickoPrezime, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFizickoPrezime, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlFizicko.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFizickoJmbg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFizickoJmbg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		pnlFizicko.setLayout(gl_pnlFizicko);

		JPanel pnlPravno = new JPanel();
		pnlPravno.setBackground(Color.WHITE);
		lpnFizickoPravno.add(pnlPravno, "name_41270937055600");
		GroupLayout gl_pnlPravno = new GroupLayout(pnlPravno);
		gl_pnlPravno.setHorizontalGroup(
			gl_pnlPravno.createParallelGroup(Alignment.LEADING)
				.addGap(0, 470, Short.MAX_VALUE)
		);
		gl_pnlPravno.setVerticalGroup(
			gl_pnlPravno.createParallelGroup(Alignment.LEADING)
				.addGap(0, 116, Short.MAX_VALUE)
		);
		pnlPravno.setLayout(gl_pnlPravno);
		pnlPrNovi.setLayout(gl_pnlPrNovi);
		pnlProizvodjac.setLayout(gl_pnlProizvodjac);
		add(pnlProizvodjac, "name_1784826073300");

	}

	public DefaultTableModel getModel() {
		return modelFizicko;
	}
}
