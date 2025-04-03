package pogled.proizvod;

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

	/**
	 * Create the panel.
	 */
	public ProizvodPanel() {

		JPanel pnlProizvod = new JPanel();
		pnlProizvod.setBackground(Color.WHITE);
		pnlProizvod.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		JLabel lblProizvodPregled = new JLabel("Преглед унетих производа");
		lblProizvodPregled.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblProizvodUnos = new JLabel("Унесите нови производ");
		lblProizvodUnos.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane jspProizvod = new JScrollPane();
		
		jspProizvod.setPreferredSize(new Dimension(335,290));
	
		JPanel pnlProizvodNovi = new JPanel();
		pnlProizvodNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlProizvodNovi.setBackground(Color.WHITE);

		JLabel lblNoviNaziv = new JLabel("Назив производа :");
		lblNoviNaziv.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviNaziv = new JTextField();
		txtNoviNaziv.setToolTipText("");
		txtNoviNaziv.setColumns(10);

		JButton btnNoviIzbrisi = new JButton("Избриши");
		btnNoviIzbrisi.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNoviIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNoviNaziv.setText("");
				txtNoviVrsta.setText("");

			}
		});
		btnNoviIzbrisi.setForeground(Color.RED);
		btnNoviIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIzbrisi.setBackground(Color.LIGHT_GRAY);

		JLabel lblNoviVrsta = new JLabel("Врста производа :");
		lblNoviVrsta.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviVrsta = new JTextField();
		txtNoviVrsta.setToolTipText("");
		txtNoviVrsta.setColumns(10);

		JButton btnNoviDodaj = new JButton("Додај");
		btnNoviDodaj.setBorder(new BevelBorder(BevelBorder.RAISED));
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
		btnNoviDodaj.setBackground(new Color(153,255,153));

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

		String[] kolone = {"Редни бр.","ИД производа", "Назив и врста", "Опције" };

		// inicijalizacija modela

		model = new DefaultTableModel();

		tblProizvod.setModel(model);
		model.setColumnIdentifiers(kolone);

		// kako bi sve ćelije tabele bile needitabilne
		tblProizvod.setDefaultEditor(Object.class, null);

		// postavljanje CellRenderer-a i CellEdotor-a
		tblProizvod.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer());
		tblProizvod.getColumnModel().getColumn(3).setCellEditor(new ProizvodCellEditor(tblProizvod));

		tblProizvod.getColumnModel().getColumn(3).setMaxWidth(75);
		tblProizvod.getColumnModel().getColumn(3).setMinWidth(75);

		// renderer za prikaz sadržaja tabele centrirano
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < tblProizvod.getColumnCount() - 1; i++) {
			tblProizvod.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		}

		GroupLayout gl_pnlProizvodNovi = new GroupLayout(pnlProizvodNovi);
		gl_pnlProizvodNovi.setHorizontalGroup(
			gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNoviVrsta, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNoviNaziv, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNoviDodaj, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(txtNoviNaziv)
						.addComponent(txtNoviVrsta))
					.addGap(22))
		);
		gl_pnlProizvodNovi.setVerticalGroup(
			gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNoviNaziv, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviNaziv, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
							.addGap(10)
							.addComponent(txtNoviVrsta, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodNovi.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNoviVrsta, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(65)
					.addGroup(gl_pnlProizvodNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(322, Short.MAX_VALUE))
		);
		pnlProizvodNovi.setLayout(gl_pnlProizvodNovi);

		jspProizvod.setViewportView(tblProizvod);
		GroupLayout gl_pnlProizvod = new GroupLayout(pnlProizvod);
		gl_pnlProizvod.setHorizontalGroup(
			gl_pnlProizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvod.createSequentialGroup()
					.addGroup(gl_pnlProizvod.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvod.createSequentialGroup()
							.addGap(120)
							.addComponent(jspProizvod, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE))
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
					.addGap(70)
					.addGroup(gl_pnlProizvod.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProizvodPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProizvodUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_pnlProizvod.createParallelGroup(Alignment.LEADING)
						.addComponent(jspProizvod, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlProizvodNovi, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)))
		);
		pnlProizvod.setLayout(gl_pnlProizvod);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlProizvod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(pnlProizvod, GroupLayout.PREFERRED_SIZE, 1085, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

	public DefaultTableModel vratiModel() {
		return model;
	}

	public JTable vratiTabelu() {
		return tblProizvod;
	}

}
