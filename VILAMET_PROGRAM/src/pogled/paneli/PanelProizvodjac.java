package pogled.paneli;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelProizvodjac extends JPanel {

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
	
	protected static JTable tblProizvodjac;

	/**
	 * Create the panel.
	 */
	public PanelProizvodjac() {

		JPanel pnlProizvodjac = new JPanel();
		pnlProizvodjac.setBackground(Color.WHITE);
		pnlProizvodjac.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		add(pnlProizvodjac);

		JLabel lblProizvodjacPregled = new JLabel("Преглед унетих произвођача");
		lblProizvodjacPregled.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblProizvodjacUnos = new JLabel("Унесите новог произвођача");
		lblProizvodjacUnos.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane jspProizvodjac = new JScrollPane();

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

		JLabel lblNoviAdresa = new JLabel("Адреса произвођача :");
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
		btnNoviIzbrisi.setForeground(Color.RED);
		btnNoviIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIzbrisi.setBackground(Color.WHITE);

		JLabel lblNoviUlica = new JLabel("Улица и број :");
		lblNoviUlica.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviUlica = new JTextField();
		txtNoviUlica.setColumns(10);

		JButton btnNoviDodaj = new JButton("Додај");
		btnNoviDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviDodaj.setBackground(new Color(0, 194, 0));
		
		// TABELA PROIZVOĐAČI
		
		tblProizvodjac = new JTable();
		tblProizvodjac.setFont(new Font("Arial", Font.PLAIN, 12));
		tblProizvodjac.setBackground(Color.WHITE);
		jspProizvodjac.setViewportView(tblProizvodjac);
		
		String[] kolone = { "ИД произвођача","Време креирања", "Име", "Презиме", "Место/Град", "Село", "Улица и број"};
		
		// kreiranje modela tabele
		
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Sve ćelije nisu editabilne
				return false;
			}
		};

		// postavljanje modela tabeli
		tblProizvodjac.setModel(model);
		model.setColumnIdentifiers(kolone);

		
		GroupLayout gl_pnlProizvodjacNovi = new GroupLayout(pnlProizvodjacNovi);
		gl_pnlProizvodjacNovi.setHorizontalGroup(
			gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNoviAdresa, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNoviMesto)
								.addComponent(lblNoviSelo, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNoviMesto, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNoviSelo, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNoviPrezime, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNoviIme, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNoviIme, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNoviPrezime, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
									.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
									.addComponent(lblNoviUlica, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(txtNoviUlica, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_pnlProizvodjacNovi.setVerticalGroup(
			gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.TRAILING)
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
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addComponent(lblNoviMesto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNoviSelo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(2)
							.addComponent(txtNoviMesto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(txtNoviSelo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNoviUlica, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjacNovi.createSequentialGroup()
							.addGap(7)
							.addComponent(txtNoviUlica, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_pnlProizvodjacNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		pnlProizvodjacNovi.setLayout(gl_pnlProizvodjacNovi);

		JButton btnProizvodjacIzbrisi = new JButton("Избриши произвођача");
		btnProizvodjacIzbrisi.setForeground(Color.RED);
		btnProizvodjacIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnProizvodjacIzbrisi.setBackground(Color.WHITE);
		GroupLayout gl_pnlProizvodjac = new GroupLayout(pnlProizvodjac);
		gl_pnlProizvodjac.setHorizontalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProizvodjacIzbrisi, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlProizvodjac.createSequentialGroup()
							.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
								.addComponent(jspProizvodjac, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnlProizvodjacNovi, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))))
					.addGap(293))
		);
		gl_pnlProizvodjac.setVerticalGroup(
			gl_pnlProizvodjac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjac.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProizvodjacPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProizvodjacUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlProizvodjac.createParallelGroup(Alignment.TRAILING)
						.addComponent(jspProizvodjac, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addComponent(pnlProizvodjacNovi, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
					.addGap(20)
					.addComponent(btnProizvodjacIzbrisi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(337))
		);
		gl_pnlProizvodjac.setAutoCreateGaps(true);
		gl_pnlProizvodjac.setAutoCreateContainerGaps(true);
		pnlProizvodjac.setLayout(gl_pnlProizvodjac);

	}

}
