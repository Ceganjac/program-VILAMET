package pogled.ambalaza;

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

public class AmbalazaPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;

	protected JTable tblAmbalaza;
	private JTextField txtNovaNaziv;
	private JTextField txtNovaMasa;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public AmbalazaPanel() {

		JPanel pnlProizvodjac = new JPanel();
		pnlProizvodjac.setBackground(Color.WHITE);
		pnlProizvodjac.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		JLabel lblAmbalazaPregled = new JLabel("Преглед унетих врста амбалаже");
		lblAmbalazaPregled.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblAmbalazaNova = new JLabel("Унесите новог типа амбалаже");
		lblAmbalazaNova.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane jspAmbalaza = new JScrollPane();

		/*
		 * jspProizvodjac.setPreferredSize(new Dimension(335,290));
		 * jspProizvodjac.setMaximumSize(new Dimension(335,290));
		 * jspProizvodjac.setMinimumSize(new Dimension(335,290));
		 */

		JPanel pnlAmbalazaNova = new JPanel();
		pnlAmbalazaNova.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlAmbalazaNova.setBackground(Color.WHITE);

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

		tblAmbalaza = new JTable();

		// stavljanje boje koju će imati polja koja selektovana
		tblAmbalaza.setSelectionBackground(new Color(153, 255, 153));
		tblAmbalaza.setRowHeight(25);
		tblAmbalaza.setFont(new Font("Arial", Font.PLAIN, 12));
		tblAmbalaza.setBackground(Color.WHITE);

		// heder tabele
		JTableHeader heder = tblAmbalaza.getTableHeader();
		heder.setBackground(Color.LIGHT_GRAY);
		heder.setPreferredSize(new Dimension(heder.getWidth(), 30));

		// omogućava hover reda
		tblAmbalaza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tblAmbalaza.clearSelection();
			}
		});

		tblAmbalaza.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int indeksReda = tblAmbalaza.rowAtPoint(e.getPoint());
				if (indeksReda != -1) {
					tblAmbalaza.setRowSelectionInterval(indeksReda, indeksReda);
				}
			}
		});

		String[] kolone = { "Редни бр.", "ИД амбалаже", "Назив", "Маса", "Опције" };

		// inicijalizacija modela tabele

		model = new DefaultTableModel();

		// postavljanje modela tabeli
		tblAmbalaza.setModel(model);
		model.setColumnIdentifiers(kolone);

		// kako bi sve ćelije tabele bile needitabilne
		tblAmbalaza.setDefaultEditor(Object.class, null);

		// postavljanje CellRenderer-a i CellEditor-a
		tblAmbalaza.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
		tblAmbalaza.getColumnModel().getColumn(4).setCellEditor(new AmbalazaCellEditor(tblAmbalaza));

		// render za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < tblAmbalaza.getColumnCount() - 1; i++) {
			tblAmbalaza.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		jspAmbalaza.setViewportView(tblAmbalaza);

		// sistemi PDV
		String[] pdv = { "Газдинство у систему ПДВ-а", "Није обавезник ПДВ-а" };

		JLabel lblNovaNaziv = new JLabel("Назив :");
		lblNovaNaziv.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNovaMasa = new JLabel("Маса :");
		lblNovaMasa.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNovaNaziv = new JTextField();
		txtNovaNaziv.setToolTipText("");
		txtNovaNaziv.setColumns(10);

		txtNovaMasa = new JTextField();
		txtNovaMasa.setToolTipText("");
		txtNovaMasa.setColumns(10);
		GroupLayout gl_pnlProizvodjac = new GroupLayout(pnlProizvodjac);
		gl_pnlProizvodjac.setHorizontalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(117)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodjac.createSequentialGroup()
							.addComponent(lblAmbalazaPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(357)
							.addComponent(lblAmbalazaNova, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjac.createSequentialGroup()
							.addComponent(jspAmbalaza, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(pnlAmbalazaNova, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlProizvodjac.setVerticalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAmbalazaPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmbalazaNova, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlAmbalazaNova, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jspAmbalaza, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)))
		);
		GroupLayout gl_pnlAmbalazaNova = new GroupLayout(pnlAmbalazaNova);
		gl_pnlAmbalazaNova.setHorizontalGroup(
			gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
							.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
							.addComponent(lblNovaNaziv, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(txtNovaNaziv, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
							.addComponent(lblNovaMasa, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(txtNovaMasa, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);
		gl_pnlAmbalazaNova.setVerticalGroup(
			gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNovaNaziv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNovaNaziv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNovaMasa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNovaMasa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(189, Short.MAX_VALUE))
		);
		pnlAmbalazaNova.setLayout(gl_pnlAmbalazaNova);
		pnlProizvodjac.setLayout(gl_pnlProizvodjac);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlProizvodjac,
				GroupLayout.PREFERRED_SIZE, 1630, GroupLayout.PREFERRED_SIZE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlProizvodjac,
				GroupLayout.PREFERRED_SIZE, 1095, GroupLayout.PREFERRED_SIZE));
		setLayout(groupLayout);

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
