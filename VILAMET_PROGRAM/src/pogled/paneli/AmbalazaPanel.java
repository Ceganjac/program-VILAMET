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
import pogled.celleditor.AmbalazaCellEditor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;


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
	private JTextField txtNoviUkupanBr;

	/**
	 * Create the panel.
	 */
	public AmbalazaPanel() {

		setPreferredSize(new Dimension(screenSirina - 300, screenVisina - 50));
		setBackground(Color.white);

		// pnlAmbalaza ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlAmbalaza = new JPanel();
		pnlAmbalaza.setBackground(Color.white);

		JLabel lblAmbalazaPregled = new JLabel("Преглед унетих врста амбалаже");
		lblAmbalazaPregled.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblAmbalazaNova = new JLabel("Унесите новог типа амбалаже");
		lblAmbalazaNova.setFont(new Font("Arial", Font.PLAIN, 20));


		/*
		 * jspProizvodjac.setPreferredSize(new Dimension(335,290));
		 * jspProizvodjac.setMaximumSize(new Dimension(335,290));
		 * jspProizvodjac.setMinimumSize(new Dimension(335,290));
		 */

		JPanel pnlAmbalazaNova = new JPanel();
		pnlAmbalazaNova.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlAmbalazaNova.setBackground(Color.WHITE);

		JButton btnNoviIsprazni = new JButton("Испразни поља");
		btnNoviIsprazni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * txtNoviIme.setText(""); txtNoviPrezime.setText(""); txtNoviMesto.setText("");
				 * txtNoviSelo.setText(""); txtNoviUlica.setText("");
				 */

			}
		});
		btnNoviIsprazni.setForeground(Color.RED);
		btnNoviIsprazni.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIsprazni.setBackground(Color.WHITE);

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
		btnNoviDodaj.setBackground(new Color(153, 255, 153));
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// TABELA AMBALAŽA

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

		String[] kolone = { "Редни бр.", "ИД амбалаже", "Назив", "Маса", "Укупан бр.", "Лагер", "Опције" };

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

		// okruživanje tabele sa JscrollPane
		JScrollPane jspAmbalaza = new JScrollPane();
		jspAmbalaza.setViewportView(tblAmbalaza);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////


		// sistemi PDV
		String[] pdv = { "Газдинство у систему ПДВ-а", "Није обавезник ПДВ-а" };

		JLabel lblNovaNaziv = new JLabel("Назив :");
		lblNovaNaziv.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNovaMasa = new JLabel("Маса :");
		lblNovaMasa.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNovaNaziv = new JTextField();
		txtNovaNaziv.setHorizontalAlignment(SwingConstants.CENTER);
		txtNovaNaziv.setToolTipText("");
		txtNovaNaziv.setColumns(10);

		txtNovaMasa = new JTextField();
		txtNovaMasa.setHorizontalAlignment(SwingConstants.CENTER);
		txtNovaMasa.setToolTipText("");
		txtNovaMasa.setColumns(10);
		GroupLayout gl_pnlAmbalaza = new GroupLayout(pnlAmbalaza);
		gl_pnlAmbalaza.setHorizontalGroup(
			gl_pnlAmbalaza.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAmbalaza.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlAmbalaza.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAmbalaza.createSequentialGroup()
							.addComponent(lblAmbalazaPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(357)
							.addComponent(lblAmbalazaNova, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAmbalaza.createSequentialGroup()
							.addComponent(jspAmbalaza, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(pnlAmbalazaNova, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)))
					.addGap(297))
		);
		gl_pnlAmbalaza.setVerticalGroup(
			gl_pnlAmbalaza.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAmbalaza.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlAmbalaza.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAmbalazaPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmbalazaNova, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlAmbalaza.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlAmbalazaNova, 0, 0, Short.MAX_VALUE)
						.addComponent(jspAmbalaza, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(501, Short.MAX_VALUE))
		);

		JLabel lblNoviUBroj = new JLabel("Укупан број :");
		lblNoviUBroj.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNoviUkupanBr = new JTextField();
		txtNoviUkupanBr.setHorizontalAlignment(SwingConstants.CENTER);
		txtNoviUkupanBr.setToolTipText("");
		txtNoviUkupanBr.setColumns(10);
		GroupLayout gl_pnlAmbalazaNova = new GroupLayout(pnlAmbalazaNova);
		gl_pnlAmbalazaNova.setHorizontalGroup(
			gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
							.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
							.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
							.addComponent(lblNovaNaziv, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtNovaNaziv, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
							.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNovaMasa, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNoviUBroj, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNoviUkupanBr, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNovaMasa, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
					.addGap(30))
		);
		gl_pnlAmbalazaNova.setVerticalGroup(
			gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAmbalazaNova.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNovaNaziv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNovaNaziv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNovaMasa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNovaMasa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviUBroj, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviUkupanBr, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_pnlAmbalazaNova.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(208, Short.MAX_VALUE))
		);
		pnlAmbalazaNova.setLayout(gl_pnlAmbalazaNova);
		pnlAmbalaza.setLayout(gl_pnlAmbalaza);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlAmbalaza,
				GroupLayout.PREFERRED_SIZE, 1620, GroupLayout.PREFERRED_SIZE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlAmbalaza,
				GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE));
		setLayout(groupLayout);

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
