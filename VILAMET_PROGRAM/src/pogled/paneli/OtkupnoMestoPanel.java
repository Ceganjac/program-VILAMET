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

public class OtkupnoMestoPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;

	protected JTable tblAmbalaza;
	private JTextField txtNovоNaziv;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public OtkupnoMestoPanel() {

		setPreferredSize(new Dimension(screenSirina - 300, screenVisina-50));
		setBackground(Color.white);

		// pnlAmbalaza ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlOtkupnoM = new JPanel();
		pnlOtkupnoM.setBackground(Color.white);

		JLabel lblOtkupnoMPregled = new JLabel("Преглед откупних места\t");
		lblOtkupnoMPregled.setBackground(Color.LIGHT_GRAY);
		lblOtkupnoMPregled.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblOtkupnoMNovo = new JLabel("Унесите ново откупно место");
		lblOtkupnoMNovo.setFont(new Font("Arial", Font.PLAIN, 20));

		JScrollPane jspOtkupnoMesto = new JScrollPane();

		/*
		 * jspProizvodjac.setPreferredSize(new Dimension(335,290));
		 * jspProizvodjac.setMaximumSize(new Dimension(335,290));
		 * jspProizvodjac.setMinimumSize(new Dimension(335,290));
		 */

		JPanel pnlOtkupnoMestoNovo = new JPanel();
		pnlOtkupnoMestoNovo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlOtkupnoMestoNovo.setBackground(Color.WHITE);

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

		String[] kolone = { "Редни бр.", "ИД откупног м.", "Назив", "Место/Град","Село","Улица и бр.", "Опције" };

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

		jspOtkupnoMesto.setViewportView(tblAmbalaza);

		// sistemi PDV
		String[] pdv = { "Газдинство у систему ПДВ-а", "Није обавезник ПДВ-а" };

		JLabel lblNovоNaziv = new JLabel("Назив :");
		lblNovоNaziv.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNovоNaziv = new JTextField();
		txtNovоNaziv.setToolTipText("");
		txtNovоNaziv.setColumns(10);
		GroupLayout gl_pnlOtkupnoM = new GroupLayout(pnlOtkupnoM);
		gl_pnlOtkupnoM.setHorizontalGroup(
			gl_pnlOtkupnoM.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupnoM.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlOtkupnoM.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlOtkupnoM.createSequentialGroup()
							.addComponent(lblOtkupnoMPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(357)
							.addComponent(lblOtkupnoMNovo, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlOtkupnoM.createSequentialGroup()
							.addComponent(jspOtkupnoMesto, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(pnlOtkupnoMestoNovo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(256))
		);
		gl_pnlOtkupnoM.setVerticalGroup(
			gl_pnlOtkupnoM.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupnoM.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlOtkupnoM.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOtkupnoMPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOtkupnoMNovo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlOtkupnoM.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlOtkupnoMestoNovo, 0, 0, Short.MAX_VALUE)
						.addComponent(jspOtkupnoMesto, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(501, Short.MAX_VALUE))
		);
		
		JPanel pnlNovоAdresa = new JPanel();
		pnlNovоAdresa.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "\u0410\u0434\u0440\u0435\u0441\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlNovоAdresa.setBackground(Color.WHITE);
		
		JLabel lblAdresaMestoG = new JLabel("Место/Град :");
		lblAdresaMestoG.setFont(new Font("Arial", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		
		JLabel lblAdresaSelo = new JLabel("Село:");
		lblAdresaSelo.setFont(new Font("Arial", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		
		JLabel lblAdresaUlicaBr = new JLabel("Улица и број :");
		lblAdresaUlicaBr.setFont(new Font("Arial", Font.PLAIN, 16));
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		GroupLayout gl_pnlNovоAdresa = new GroupLayout(pnlNovоAdresa);
		gl_pnlNovоAdresa.setHorizontalGroup(
			gl_pnlNovоAdresa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNovоAdresa.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlNovоAdresa.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNovоAdresa.createSequentialGroup()
							.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNovоAdresa.createSequentialGroup()
							.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNovоAdresa.createSequentialGroup()
							.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlNovоAdresa.setVerticalGroup(
			gl_pnlNovоAdresa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNovоAdresa.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pnlNovоAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaMestoG, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlNovоAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaSelo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlNovоAdresa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresaUlicaBr, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
		);
		pnlNovоAdresa.setLayout(gl_pnlNovоAdresa);
		GroupLayout gl_pnlOtkupnoMestoNovo = new GroupLayout(pnlOtkupnoMestoNovo);
		gl_pnlOtkupnoMestoNovo.setHorizontalGroup(
			gl_pnlOtkupnoMestoNovo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupnoMestoNovo.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlOtkupnoMestoNovo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlOtkupnoMestoNovo.createSequentialGroup()
							.addComponent(lblNovоNaziv, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtNovоNaziv, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlOtkupnoMestoNovo.createParallelGroup(Alignment.LEADING, false)
							.addGroup(Alignment.TRAILING, gl_pnlOtkupnoMestoNovo.createSequentialGroup()
								.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
							.addComponent(pnlNovоAdresa, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_pnlOtkupnoMestoNovo.setVerticalGroup(
			gl_pnlOtkupnoMestoNovo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupnoMestoNovo.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlOtkupnoMestoNovo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNovоNaziv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNovоNaziv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(pnlNovоAdresa, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addGroup(gl_pnlOtkupnoMestoNovo.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlOtkupnoMestoNovo.setLayout(gl_pnlOtkupnoMestoNovo);
		pnlOtkupnoM.setLayout(gl_pnlOtkupnoM);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlOtkupnoM, GroupLayout.PREFERRED_SIZE, 1620, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlOtkupnoM, GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE)
		);
		setLayout(groupLayout);

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
