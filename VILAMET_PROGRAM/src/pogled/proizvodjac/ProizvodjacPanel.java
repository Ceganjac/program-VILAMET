package pogled.proizvodjac;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

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

public class ProizvodjacPanel extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private JTextField txtNoviIme;
	private JTextField txtNoviPrezime;
	private JTextField txtNoviMesto;
	private JTextField txtNoviSelo;
	private JTextField txtNoviUlica;
	private DefaultTableModel model;

	protected JTable tblProizvodjac;

	/**
	 * Create the panel.
	 */
	public ProizvodjacPanel() {

		JPanel pnlProizvodjac = new JPanel();
		pnlProizvodjac.setBackground(Color.WHITE);
		pnlProizvodjac.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		add(pnlProizvodjac);

		JLabel lblProizvodjacPregled = new JLabel("Преглед унетих произвођача");
		lblProizvodjacPregled.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblProizvodjacUnos = new JLabel("Унесите новог произвођача");
		lblProizvodjacUnos.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane jspProizvodjac = new JScrollPane();
		
		/*jspProizvodjac.setPreferredSize(new Dimension(335,290));
		jspProizvodjac.setMaximumSize(new Dimension(335,290));
		jspProizvodjac.setMinimumSize(new Dimension(335,290));*/



		JPanel pnlProizvodjacNovi = new JPanel();
		pnlProizvodjacNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlProizvodjacNovi.setBackground(Color.WHITE);

		JLabel lblNoviIme = new JLabel("Име :");
		lblNoviIme.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviIme = new JTextField();
		txtNoviIme.setToolTipText("");
		txtNoviIme.setColumns(10);

		JLabel lblNoviPrezime = new JLabel("Презиме :");
		lblNoviPrezime.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviPrezime = new JTextField();
		txtNoviPrezime.setColumns(10);

		JLabel lblNoviAdresa = new JLabel("Адреса произвођача ");
		lblNoviAdresa.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblNoviMesto = new JLabel("Место / Град :");
		lblNoviMesto.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblNoviSelo = new JLabel("Село :");
		lblNoviSelo.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviMesto = new JTextField();
		txtNoviMesto.setColumns(10);

		txtNoviSelo = new JTextField();
		txtNoviSelo.setColumns(10);

		JButton btnNoviIzbrisi = new JButton("Избриши");
		btnNoviIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNoviIme.setText("");
				txtNoviPrezime.setText("");
				txtNoviMesto.setText("");
				txtNoviSelo.setText("");
				txtNoviUlica.setText("");
			
			}
		});
		btnNoviIzbrisi.setForeground(Color.RED);
		btnNoviIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIzbrisi.setBackground(Color.WHITE);

		JLabel lblNoviUlica = new JLabel("Улица и број :");
		lblNoviUlica.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviUlica = new JTextField();
		txtNoviUlica.setColumns(10);

		JButton btnNoviDodaj = new JButton("Додај");
		btnNoviDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ime = txtNoviIme.getText();
				String prezime = txtNoviPrezime.getText();
				String mestoGrad = txtNoviMesto.getText();
				String selo = txtNoviSelo.getText();
				String ulicaBroj = txtNoviUlica.getText();
				
				ProizvodjacInitial.dodavanje(ime, prezime, mestoGrad, selo, ulicaBroj);
				
				
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
		

		String[] kolone = { "Редни бр.","ИД произвођача", "Име", "Презиме", "Место/Град", "Село", "Улица и број", "Опције" };

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
		GroupLayout gl_pnlProizvodjacNovi = new GroupLayout(pnlProizvodjacNovi);
		gl_pnlProizvodjacNovi.setHorizontalGroup(
			gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNoviIme, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(txtNoviIme, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNoviPrezime, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(txtNoviPrezime, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNoviAdresa, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNoviMesto)
					.addGap(27)
					.addComponent(txtNoviMesto, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNoviSelo, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(txtNoviSelo, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNoviUlica, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(txtNoviUlica, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(30)
					.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlProizvodjacNovi.setVerticalGroup(
			gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviIme, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviIme, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviPrezime, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(2)
							.addComponent(txtNoviPrezime, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addComponent(lblNoviAdresa, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviMesto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(2)
							.addComponent(txtNoviMesto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviSelo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviSelo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviUlica, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviUlica, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
		);
		pnlProizvodjacNovi.setLayout(gl_pnlProizvodjacNovi);
		GroupLayout gl_pnlProizvodjac = new GroupLayout(pnlProizvodjac);
		gl_pnlProizvodjac.setHorizontalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodjac.createSequentialGroup()
							.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(305)
							.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjac.createSequentialGroup()
							.addComponent(jspProizvodjac, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(pnlProizvodjacNovi, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlProizvodjac.setVerticalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
						.addComponent(jspProizvodjac, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlProizvodjacNovi, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)))
		);
		pnlProizvodjac.setLayout(gl_pnlProizvodjac);

		
	}

	public DefaultTableModel getModel() {
		return model;
	}

	

}
