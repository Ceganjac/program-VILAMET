package pogled.paneli;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import kontroler.ProizvodKontroler;
import model.baza.ProizvodBaza;
import pogled.CellRenderer;
import pogled.Obavestenje;
import pogled.TipObavestenja;
import pogled.celleditor.ProizvodCellEditor;
import pomocni.ProizvodInitial;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class ProizvodPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private JTextField txtNoviNaziv;
	private JTextField txtNoviVrsta;
	private JTable tblProizvod;
	private DefaultTableModel model;
	private JTextField txtNoviKlasa;
	private JTextField txtNoviCena;

	/**
	 * Create the panel.
	 */
	public ProizvodPanel() {

		setPreferredSize(new Dimension(screenSirina - 300, screenVisina - 50));
		setBackground(Color.white);

		// pnlProizvod ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlProizvod = new JPanel();
		pnlProizvod.setBackground(Color.white);

		JLabel lblProizvodPregled = new JLabel("Преглед унетих производа");
		lblProizvodPregled.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblProizvodUnos = new JLabel("Унесите нови производ");
		lblProizvodUnos.setFont(new Font("Arial", Font.PLAIN, 20));

		JScrollPane jspProizvod = new JScrollPane();

		jspProizvod.setPreferredSize(new Dimension(335, 290));

		JPanel pnlProizvodNovi = new JPanel();
		pnlProizvodNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlProizvodNovi.setBackground(Color.WHITE);

		JLabel lblNoviNaziv = new JLabel("Назив :");
		lblNoviNaziv.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNoviNaziv = new JTextField();
		txtNoviNaziv.setToolTipText("");
		txtNoviNaziv.setColumns(10);

		JButton btnNoviIsprazni = new JButton("Испразни поља");
		btnNoviIsprazni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNoviNaziv.setText("");
				txtNoviVrsta.setText("");

			}
		});
		btnNoviIsprazni.setForeground(Color.RED);
		btnNoviIsprazni.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIsprazni.setBackground(Color.WHITE);

		JLabel lblNoviVrsta = new JLabel("Сорта :");
		lblNoviVrsta.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNoviVrsta = new JTextField();
		txtNoviVrsta.setToolTipText("");
		txtNoviVrsta.setColumns(10);

		JButton btnNoviDodaj = new JButton("Додај");

		// Dodavnje novog proizvoda
		btnNoviDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String naziv = null;
				String vrsta = null;

				if (txtNoviNaziv.getText().equals("")) {
					Obavestenje.prikaziPoruku("Назив производа није унет !", TipObavestenja.UPOZORENJE);
					return;
				} else {
					naziv = txtNoviNaziv.getText();
				}

				//////////////////////////////

				if (txtNoviVrsta.getText().equals("")) {
					Obavestenje.prikaziPoruku("Врста производа није унет !", TipObavestenja.UPOZORENJE);
					return;
				} else {
					vrsta = txtNoviVrsta.getText();
				}

				//////////////////////////////

				ProizvodInitial.dodavanje(naziv, vrsta);

			}
		});
		btnNoviDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviDodaj.setBackground(new Color(153, 255, 153));

		// TABELA PROIZVODA
		tblProizvod = new JTable();
		tblProizvod.setSelectionBackground(new Color(153, 255, 153));
		tblProizvod.setRowHeight(25);

		// heder tabele
		JTableHeader heder = tblProizvod.getTableHeader();
		heder.setBackground(Color.LIGHT_GRAY);
		heder.setPreferredSize(new Dimension(heder.getWidth(), 30));

		// omogućava hover reda
		tblProizvod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tblProizvod.clearSelection();
			}
		});
		tblProizvod.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int indeksReda = tblProizvod.rowAtPoint(e.getPoint()); // Dobijamo indeks reda ispod miša
				if (indeksReda != -1) {
					tblProizvod.setRowSelectionInterval(indeksReda, indeksReda); // Selektujemo red
				}

			}
		});

		String[] kolone = { "Редни бр.", "ИД производа", "Назив", "Сорта","Класа","Цена", "Опције" };

		// inicijalizacija modela

		model = new DefaultTableModel();

		tblProizvod.setModel(model);
		model.setColumnIdentifiers(kolone);

		// kako bi sve ćelije tabele bile needitabilne
		tblProizvod.setDefaultEditor(Object.class, null);

		// postavljanje CellRenderer-a i CellEdotor-a
		tblProizvod.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
		tblProizvod.getColumnModel().getColumn(4).setCellEditor(new ProizvodCellEditor(tblProizvod));

		tblProizvod.getColumnModel().getColumn(4).setMaxWidth(75);
		tblProizvod.getColumnModel().getColumn(4).setMinWidth(75);

		// renderer za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		for (int i = 0; i < tblProizvod.getColumnCount() - 1; i++) {
			tblProizvod.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		}

		jspProizvod.setViewportView(tblProizvod);
		GroupLayout gl_pnlProizvod = new GroupLayout(pnlProizvod);
		gl_pnlProizvod.setHorizontalGroup(
			gl_pnlProizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvod.createSequentialGroup()
					.addGroup(gl_pnlProizvod.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvod.createSequentialGroup()
							.addGap(120)
							.addComponent(jspProizvod, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvod.createSequentialGroup()
							.addGap(121)
							.addComponent(lblProizvodPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_pnlProizvod.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProizvodUnos, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlProizvodNovi, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addGap(440))
		);
		gl_pnlProizvod.setVerticalGroup(
			gl_pnlProizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvod.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlProizvod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProizvodPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProizvodUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlProizvod.createParallelGroup(Alignment.LEADING)
						.addComponent(jspProizvod, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlProizvodNovi, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)))
		);

		JLabel lblNoviKlasa = new JLabel("Класа (квалитет) :");
		lblNoviKlasa.setFont(new Font("Arial", Font.PLAIN, 16));

		txtNoviKlasa = new JTextField();
		txtNoviKlasa.setToolTipText("");
		txtNoviKlasa.setColumns(10);
		
		JLabel lblNoviCena = new JLabel("Цена :");
		lblNoviCena.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNoviCena = new JTextField();
		txtNoviCena.setToolTipText("");
		txtNoviCena.setColumns(10);
		GroupLayout gl_pnlProizvodNovi = new GroupLayout(pnlProizvodNovi);
		gl_pnlProizvodNovi.setHorizontalGroup(
			gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
							.addComponent(lblNoviKlasa, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(txtNoviKlasa, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
							.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNoviVrsta, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNoviNaziv, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNoviNaziv)
								.addComponent(txtNoviVrsta, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
						.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
							.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNoviCena, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
							.addGap(25)
							.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNoviCena, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))))
					.addGap(26))
		);
		gl_pnlProizvodNovi.setVerticalGroup(
			gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviNaziv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviNaziv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviVrsta, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviVrsta, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviKlasa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviKlasa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviCena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviCena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviIsprazni, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
		);
		pnlProizvodNovi.setLayout(gl_pnlProizvodNovi);
		pnlProizvod.setLayout(gl_pnlProizvod);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlProizvod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlProizvod, GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		setLayout(groupLayout);

	}

	public DefaultTableModel vratiModel() {
		return model;
	}

	public JTable vratiTabelu() {
		return tblProizvod;
	}
}
