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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
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

		setPreferredSize(new Dimension(screenSirina - 300, screenVisina-50));
		setBackground(Color.white);
		
		// pnlProizvodjac ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlProizvodjac = new JPanel();
		pnlProizvodjac.setBackground(Color.white);
		/*heder.setBackground(Color.LIGHT_GRAY);
		heder.setPreferredSize(new Dimension(heder.getWidth(), 30));*/

		String[] kolone = { "Редни бр.", "ИД произвођача", "Име", "Презиме", "Место/Град", "Село", "Улица и број",
				"Опције" };

		// inicijalizacija modela tabele

		model = new DefaultTableModel();
		model.setColumnIdentifiers(kolone);

		// render za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
/*
		for (int i = 0; i < tblProizvodjac.getColumnCount() - 1; i++) {
			tblProizvodjac.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}*/
		
		// sistemi PDV
		String[] pdv = {"Газдинство у систему ПДВ-а", "Није обавезник ПДВ-а"};
		setLayout(new CardLayout(0, 0));
		
		JTabbedPane tpnProizvodjacT = new JTabbedPane(JTabbedPane.TOP);
		tpnProizvodjacT.setForeground(new Color(0, 0, 0));
		tpnProizvodjacT.setBorder(null);
		GroupLayout gl_pnlProizvodjac = new GroupLayout(pnlProizvodjac);
		gl_pnlProizvodjac.setHorizontalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(120)
					.addComponent(tpnProizvodjacT, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		gl_pnlProizvodjac.setVerticalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(40)
					.addComponent(tpnProizvodjacT, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(380, Short.MAX_VALUE))
		);
		
		JPanel pnlTPregled = new JPanel();
		pnlTPregled.setBorder(null);
		tpnProizvodjacT.addTab("Преглед", null, pnlTPregled, null);
		
		table = new JTable();
		table.setSelectionBackground(new Color(153, 255, 153));
		table.setRowHeight(25);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		
		JLabel lblProizvodjacPregled = new JLabel("Преглед унетих произвођача");
		lblProizvodjacPregled.setOpaque(true);
		lblProizvodjacPregled.setFont(new Font("Arial", Font.PLAIN, 20));
		GroupLayout gl_pnlTPregled = new GroupLayout(pnlTPregled);
		gl_pnlTPregled.setHorizontalGroup(
			gl_pnlTPregled.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTPregled.createSequentialGroup()
					.addGroup(gl_pnlTPregled.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlTPregled.createSequentialGroup()
							.addGap(50)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1098, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlTPregled.createSequentialGroup()
							.addGap(50)
							.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlTPregled.setVerticalGroup(
			gl_pnlTPregled.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTPregled.createSequentialGroup()
					.addGap(50)
					.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		pnlTPregled.setLayout(gl_pnlTPregled);
		
		JPanel pnlTNovi = new JPanel();
		pnlTNovi.setBorder(null);
		tpnProizvodjacT.addTab("Унос новог", null, pnlTNovi, null);
		
		JLabel lblProizvodjacUnos = new JLabel("Унесите новог произвођача");
		lblProizvodjacUnos.setOpaque(true);
		lblProizvodjacUnos.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JPanel pnlNoviGlavni = new JPanel();
		pnlNoviGlavni.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlNoviGlavni.setBackground(Color.WHITE);
		
		JPanel pnlGlavniOsnovni = new JPanel();
		pnlGlavniOsnovni.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), // ili neki drugi
																											// border
						"Основни подаци", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGlavniOsnovni.setBackground(Color.WHITE);
		
		JLabel lblOsnovniBpg = new JLabel("Број пољ. газдинства :");
		lblOsnovniBpg.setFont(new Font("Arial", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		
		JLabel lblOsnovniSpdv = new JLabel("Систем ПДВ-а :");
		lblOsnovniSpdv.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JComboBox cmbSistemPdv = new JComboBox(new Object[]{});
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
				.addGap(0, 450, Short.MAX_VALUE)
				.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_pnlGlavniOsnovni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGlavniOsnovni.createSequentialGroup()
							.addComponent(lblOsnovniBpg, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
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
				.addGap(0, 300, Short.MAX_VALUE)
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
		lpnFizickoPravno.setBorder(new TitledBorder(null, "\u0424\u0438\u0437\u0438\u0447\u043A\u043E / \u041F\u0440\u0430\u0432\u043D\u043E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lpnFizickoPravno.setLayout(new CardLayout(0, 0));
		
		JPanel pnlGlavniAdresa = new JPanel();
		pnlGlavniAdresa.setBorder(new TitledBorder(null, "\u0410\u0434\u0440\u0435\u0441\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		gl_pnlGlavniAdresa.setHorizontalGroup(
			gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addGroup(gl_pnlGlavniAdresa.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGlavniAdresa.createSequentialGroup()
							.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniAdresa.createSequentialGroup()
							.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniAdresa.createSequentialGroup()
							.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlGlavniAdresa.setVerticalGroup(
			gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
				.addGap(0, 140, Short.MAX_VALUE)
				.addGroup(gl_pnlGlavniAdresa.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlGlavniAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
		);
		pnlGlavniAdresa.setLayout(gl_pnlGlavniAdresa);
		GroupLayout gl_pnlNoviGlavni = new GroupLayout(pnlNoviGlavni);
		gl_pnlNoviGlavni.setHorizontalGroup(
			gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
					.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
							.addGap(8)
							.addComponent(pnlGlavniOsnovni, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbNoviFizicko, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(rdvNoviPravno, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING)
						.addComponent(lpnFizickoPravno, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlGlavniAdresa, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
					.addGap(178))
		);
		gl_pnlNoviGlavni.setVerticalGroup(
			gl_pnlNoviGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_pnlNoviGlavni.createSequentialGroup()
							.addGap(0)
							.addComponent(pnlGlavniAdresa, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(lpnFizickoPravno, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlGlavniOsnovni, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlNoviGlavni.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbNoviFizicko)
						.addComponent(rdvNoviPravno))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		pnlNoviGlavni.setLayout(gl_pnlNoviGlavni);
		
		JButton btnNoviDodaj = new JButton("Додај");
		btnNoviDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviDodaj.setBackground(new Color(0, 194, 0));
		
		JButton btnNoviIzbrisi = new JButton("Испразни поља");
		btnNoviIzbrisi.setForeground(Color.RED);
		btnNoviIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIzbrisi.setBackground(Color.WHITE);
		GroupLayout gl_pnlTNovi = new GroupLayout(pnlTNovi);
		gl_pnlTNovi.setHorizontalGroup(
			gl_pnlTNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTNovi.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_pnlTNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlTNovi.createSequentialGroup()
							.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlNoviGlavni, GroupLayout.PREFERRED_SIZE, 991, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_pnlTNovi.setVerticalGroup(
			gl_pnlTNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTNovi.createSequentialGroup()
					.addGap(50)
					.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(pnlNoviGlavni, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlTNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		pnlTNovi.setLayout(gl_pnlTNovi);
		pnlProizvodjac.setLayout(gl_pnlProizvodjac);
		add(pnlProizvodjac, "name_1784826073300");

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
