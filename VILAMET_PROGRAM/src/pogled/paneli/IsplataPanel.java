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
import com.toedter.calendar.JDateChooser;

public class IsplataPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;

	protected JTable tblIsplata;
	private JTextField txtNovaMasa;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public IsplataPanel() {

		setPreferredSize(new Dimension(screenSirina - 300, screenVisina - 50));
		setBackground(Color.white);

		// pnlAmbalaza ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlIsplata = new JPanel();
		pnlIsplata.setBackground(Color.white);

		JLabel lblIsplataPregled = new JLabel("Преглед реализованих исплата");
		lblIsplataPregled.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblIsplataNova = new JLabel("Унесите нову исплату");
		lblIsplataNova.setFont(new Font("Arial", Font.PLAIN, 20));

		JScrollPane jspIsplata = new JScrollPane();

		/*
		 * jspProizvodjac.setPreferredSize(new Dimension(335,290));
		 * jspProizvodjac.setMaximumSize(new Dimension(335,290));
		 * jspProizvodjac.setMinimumSize(new Dimension(335,290));
		 */

		JPanel pnlIsplataNova = new JPanel();
		pnlIsplataNova.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlIsplataNova.setBackground(Color.WHITE);

		JButton btnNovaIsprazni = new JButton("Испразни поља");
		btnNovaIsprazni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * txtNoviIme.setText(""); txtNoviPrezime.setText(""); txtNoviMesto.setText("");
				 * txtNoviSelo.setText(""); txtNoviUlica.setText("");
				 */

			}
		});
		btnNovaIsprazni.setForeground(Color.RED);
		btnNovaIsprazni.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovaIsprazni.setBackground(Color.WHITE);

		JButton btnNovaDodaj = new JButton("Додај");
		btnNovaDodaj.addActionListener(new ActionListener() {
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
		btnNovaDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNovaDodaj.setBackground(new Color(153, 255, 153));

		// TABELA PROIZVOĐAČI

		tblIsplata = new JTable();

		// stavljanje boje koju će imati polja koja selektovana
		tblIsplata.setSelectionBackground(new Color(153, 255, 153));

		tblIsplata.setRowHeight(25);
		tblIsplata.setFont(new Font("Arial", Font.PLAIN, 12));
		tblIsplata.setBackground(Color.WHITE);

		// heder tabele
		JTableHeader heder = tblIsplata.getTableHeader();
		heder.setBackground(Color.LIGHT_GRAY);
		heder.setPreferredSize(new Dimension(heder.getWidth(), 30));

		// omogućava hover reda
		tblIsplata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tblIsplata.clearSelection();
			}
		});

		tblIsplata.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int indeksReda = tblIsplata.rowAtPoint(e.getPoint());
				if (indeksReda != -1) {
					tblIsplata.setRowSelectionInterval(indeksReda, indeksReda);
				}
			}
		});

		String[] kolone = { "Редни бр.", "ИД исплате", "Датум", "Износ", "Напомена", "Опције" };

		// inicijalizacija modela tabele

		model = new DefaultTableModel();

		// postavljanje modela tabeli
		tblIsplata.setModel(model);
		model.setColumnIdentifiers(kolone);

		// kako bi sve ćelije tabele bile needitabilne
		tblIsplata.setDefaultEditor(Object.class, null);

		// postavljanje CellRenderer-a i CellEditor-a
		tblIsplata.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
		tblIsplata.getColumnModel().getColumn(4).setCellEditor(new AmbalazaCellEditor(tblIsplata));

		// render za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < tblIsplata.getColumnCount() - 1; i++) {
			tblIsplata.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		jspIsplata.setViewportView(tblIsplata);

		// sistemi PDV
		String[] pdv = { "Газдинство у систему ПДВ-а", "Није обавезник ПДВ-а" };

		JLabel lblNovaDatum = new JLabel("Датум :");
		lblNovaDatum.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNovaIznos = new JLabel("Износ :");
		lblNovaIznos.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNovaMasa = new JTextField();
		txtNovaMasa.setToolTipText("");
		txtNovaMasa.setColumns(10);
		GroupLayout gl_pnlIsplata = new GroupLayout(pnlIsplata);
		gl_pnlIsplata.setHorizontalGroup(
			gl_pnlIsplata.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIsplata.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlIsplata.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlIsplata.createSequentialGroup()
							.addComponent(lblIsplataPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(357)
							.addComponent(lblIsplataNova, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlIsplata.createSequentialGroup()
							.addComponent(jspIsplata, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(pnlIsplataNova, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)))
					.addGap(317))
		);
		gl_pnlIsplata.setVerticalGroup(
			gl_pnlIsplata.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIsplata.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlIsplata.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIsplataPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIsplataNova, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlIsplata.createParallelGroup(Alignment.LEADING)
						.addComponent(jspIsplata, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlIsplataNova, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(561, Short.MAX_VALUE))
		);

		JLabel lblNovaNapomena = new JLabel("Напомена :");
		lblNovaNapomena.setFont(new Font("Arial", Font.PLAIN, 16));

		JDateChooser dtcNovaDatum = new JDateChooser();
		dtcNovaDatum.getCalendarButton().setBackground(Color.WHITE);
		dtcNovaDatum.setBackground(Color.WHITE);
		
		JTextArea txaNovaNapomena = new JTextArea();
		txaNovaNapomena.setLineWrap(true);
		txaNovaNapomena.setBackground(Color.WHITE);
		txaNovaNapomena.setBorder(BorderFactory.createLineBorder(Color.gray));
		GroupLayout gl_pnlIsplataNova = new GroupLayout(pnlIsplataNova);
		gl_pnlIsplataNova.setHorizontalGroup(
			gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIsplataNova.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlIsplataNova.createSequentialGroup()
							.addComponent(btnNovaIsprazni, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNovaDodaj, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlIsplataNova.createSequentialGroup()
							.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNovaIznos, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNovaNapomena, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNovaDatum, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNovaMasa, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
								.addComponent(dtcNovaDatum, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
								.addComponent(txaNovaNapomena))))
					.addContainerGap())
		);
		gl_pnlIsplataNova.setVerticalGroup(
			gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIsplataNova.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNovaDatum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(dtcNovaDatum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNovaIznos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNovaMasa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNovaNapomena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txaNovaNapomena, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_pnlIsplataNova.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovaIsprazni, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNovaDodaj, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		pnlIsplataNova.setLayout(gl_pnlIsplataNova);
		pnlIsplata.setLayout(gl_pnlIsplata);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlIsplata,
				GroupLayout.PREFERRED_SIZE, 1620, GroupLayout.PREFERRED_SIZE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlIsplata,
				GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE));
		setLayout(groupLayout);

	}

	public DefaultTableModel getModel() {
		return model;
	}
}
