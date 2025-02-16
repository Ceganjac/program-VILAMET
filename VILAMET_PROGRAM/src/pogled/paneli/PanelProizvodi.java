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
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class PanelProizvodi extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private JTextField txtNoviNaziv;
	private JTextField txtNoviVrsta;
	protected static JTable tblProizvodi;

	/**
	 * Create the panel.
	 */
	public PanelProizvodi() {

		JPanel pnlProizvodi = new JPanel();
		pnlProizvodi.setBackground(Color.WHITE);
		pnlProizvodi.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		add(pnlProizvodi);

		JLabel lblProizvodiPregled = new JLabel("Преглед унетих производа");
		lblProizvodiPregled.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lblProizvodiUnos = new JLabel("Унесите нови производ");
		lblProizvodiUnos.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane jspProizvodi = new JScrollPane();

		JPanel pnlProizvodiNovi = new JPanel();
		pnlProizvodiNovi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlProizvodiNovi.setBackground(Color.WHITE);

		JLabel lblNoviNaziv = new JLabel("Назив производа :");
		lblNoviNaziv.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviNaziv = new JTextField();
		txtNoviNaziv.setToolTipText("");
		txtNoviNaziv.setColumns(10);

		JButton btnNoviIzbrisi = new JButton("Избриши");
		btnNoviIzbrisi.setForeground(Color.RED);
		btnNoviIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviIzbrisi.setBackground(Color.WHITE);

		JLabel lblNoviVrsta = new JLabel("Врста производа :");
		lblNoviVrsta.setFont(new Font("Arial", Font.PLAIN, 14));

		txtNoviVrsta = new JTextField();
		txtNoviVrsta.setToolTipText("");
		txtNoviVrsta.setColumns(10);

		JButton btnNoviDodaj = new JButton("Додај");
		btnNoviDodaj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNoviDodaj.setBackground(new Color(0, 194, 0));
		
		// TABELA PROIZVODA
		
		tblProizvodi = new JTable();
		
		String[] kolone = {"ИД производа", "Назив и врста"};

		
		// kreiranje modela
		
		DefaultTableModel model_tabele_proizvod = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Sve ćelije nisu editabilne
				return false;
			}
		};
		tblProizvodi.setModel(model_tabele_proizvod);
		model_tabele_proizvod.setColumnIdentifiers(kolone);
		//String[] proba = {"1","malina-polka"};
		//model_tabele_proizvod.addRow(proba);

		
		GroupLayout gl_pnlProizvodiNovi = new GroupLayout(pnlProizvodiNovi);
		gl_pnlProizvodiNovi.setHorizontalGroup(
			gl_pnlProizvodiNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodiNovi.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_pnlProizvodiNovi.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlProizvodiNovi.createSequentialGroup()
							.addComponent(lblNoviNaziv)
							.addGap(33))
						.addGroup(gl_pnlProizvodiNovi.createSequentialGroup()
							.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(Alignment.LEADING, gl_pnlProizvodiNovi.createSequentialGroup()
							.addComponent(lblNoviVrsta, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(33)))
					.addGroup(gl_pnlProizvodiNovi.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNoviDodaj, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(txtNoviNaziv)
						.addComponent(txtNoviVrsta))
					.addGap(22))
		);
		gl_pnlProizvodiNovi.setVerticalGroup(
			gl_pnlProizvodiNovi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodiNovi.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_pnlProizvodiNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNoviNaziv, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoviNaziv, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pnlProizvodiNovi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlProizvodiNovi.createSequentialGroup()
							.addGap(10)
							.addComponent(txtNoviVrsta, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlProizvodiNovi.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNoviVrsta, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(65)
					.addGroup(gl_pnlProizvodiNovi.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNoviDodaj, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoviIzbrisi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		pnlProizvodiNovi.setLayout(gl_pnlProizvodiNovi);

		JButton btnProizvodiIzbrisi = new JButton("Избриши производ\r\n");
		btnProizvodiIzbrisi.setForeground(Color.RED);
		btnProizvodiIzbrisi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnProizvodiIzbrisi.setBackground(Color.WHITE);

		GroupLayout gl_pnlProizvodi = new GroupLayout(pnlProizvodi);
		gl_pnlProizvodi.setHorizontalGroup(
			gl_pnlProizvodi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodi.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlProizvodi.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProizvodiIzbrisi, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlProizvodi.createSequentialGroup()
							.addGroup(gl_pnlProizvodi.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProizvodiPregled, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
								.addComponent(jspProizvodi, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addGroup(gl_pnlProizvodi.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pnlProizvodiNovi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblProizvodiUnos, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
							.addGap(216)))
					.addContainerGap())
		);
		gl_pnlProizvodi.setVerticalGroup(
			gl_pnlProizvodi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlProizvodi.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_pnlProizvodi.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProizvodiUnos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProizvodiPregled, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_pnlProizvodi.createParallelGroup(Alignment.TRAILING)
						.addComponent(jspProizvodi, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(pnlProizvodiNovi, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
					.addGap(20)
					.addComponent(btnProizvodiIzbrisi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(352))
		);
		
		jspProizvodi.setViewportView(tblProizvodi);
		gl_pnlProizvodi.setAutoCreateGaps(true);
		gl_pnlProizvodi.setAutoCreateContainerGaps(true);
		pnlProizvodi.setLayout(gl_pnlProizvodi);

	}

}
