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

public class PanelProizvodjaci extends JPanel {

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

	/**
	 * Create the panel.
	 */
	public PanelProizvodjaci() {

		JPanel pnlProizvodjaci = new JPanel();
		pnlProizvodjaci.setBackground(Color.WHITE);
		pnlProizvodjaci.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		add(pnlProizvodjaci);

		JLabel lblProizvodjaciPregled = new JLabel("Преглед унетих произвођача");
		lblProizvodjaciPregled.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblProizvodjaciUnos = new JLabel("Унесите новог произвођача");
		lblProizvodjaciUnos.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane jspProizvodjaci = new JScrollPane();

		JPanel pnlProizvodjaciNovi = new JPanel();
		pnlProizvodjaciNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlProizvodjaciNovi.setBackground(Color.WHITE);

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
		
		JTable tblProizvodjaci = new JTable();
		tblProizvodjaci.setShowVerticalLines(false);
		tblProizvodjaci.setFont(new Font("Arial", Font.PLAIN, 12));
		tblProizvodjaci.setBackground(Color.WHITE);
		jspProizvodjaci.setViewportView(tblProizvodjaci);
		
		String[] kolone = { "ИД произвођача", "Име", "Презиме", "Место/Град", "Село", "Улица и број"};
		
		// kreiranje modela tabele
		
		DefaultTableModel model = new DefaultTableModel();

		// postavljanje modela tabeli
		tblProizvodjaci.setModel(model);
		model.setColumnIdentifiers(kolone);

		
		GroupLayout gl_pnlProizvodjaciNovi = new GroupLayout(pnlProizvodjaciNovi);
		gl_pnlProizvodjaciNovi.setHorizontalGroup(
			gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
					.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNoviAdresa, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNoviMesto)
								.addComponent(lblNoviSelo, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNoviMesto, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNoviSelo, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNoviPrezime, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNoviIme, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNoviIme, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNoviPrezime, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
									.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
									.addComponent(lblNoviUlica, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(txtNoviUlica, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_pnlProizvodjaciNovi.setVerticalGroup(
			gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNoviIme, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviIme, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviPrezime, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addGap(2)
							.addComponent(txtNoviPrezime, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addComponent(lblNoviAdresa, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addComponent(lblNoviMesto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNoviSelo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addGap(2)
							.addComponent(txtNoviMesto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(txtNoviSelo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNoviUlica, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodjaciNovi.createSequentialGroup()
							.addGap(7)
							.addComponent(txtNoviUlica, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_pnlProizvodjaciNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		pnlProizvodjaciNovi.setLayout(gl_pnlProizvodjaciNovi);

		JButton btnProizvodjaciIzbrisi = new JButton("Избриши произвођача");
		btnProizvodjaciIzbrisi.setForeground(Color.RED);
		btnProizvodjaciIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnProizvodjaciIzbrisi.setBackground(Color.WHITE);
		GroupLayout gl_pnlProizvodjaci = new GroupLayout(pnlProizvodjaci);
		gl_pnlProizvodjaci.setHorizontalGroup(
			gl_pnlProizvodjaci.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjaci.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlProizvodjaci.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProizvodjaciIzbrisi, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlProizvodjaci.createSequentialGroup()
							.addGroup(gl_pnlProizvodjaci.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProizvodjaciPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
								.addComponent(jspProizvodjaci, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_pnlProizvodjaci.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlProizvodjaciNovi, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProizvodjaciUnos, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))))
					.addGap(328))
		);
		gl_pnlProizvodjaci.setVerticalGroup(
			gl_pnlProizvodjaci.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodjaci.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_pnlProizvodjaci.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProizvodjaciPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProizvodjaciUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlProizvodjaci.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlProizvodjaciNovi, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addComponent(jspProizvodjaci, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
					.addGap(20)
					.addComponent(btnProizvodjaciIzbrisi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(337))
		);
		gl_pnlProizvodjaci.setAutoCreateGaps(true);
		gl_pnlProizvodjaci.setAutoCreateContainerGaps(true);
		pnlProizvodjaci.setLayout(gl_pnlProizvodjaci);

	}

}
