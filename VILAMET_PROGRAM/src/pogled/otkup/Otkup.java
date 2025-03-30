package pogled.otkup;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import pogled.GradientPanel;
import pogled.Obavestenje;
import pogled.TipObavestenja;
import pomocni.StavkaInitial;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;

public class Otkup extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUlazniCena;
	private JTextField txtUlazniUlaz;
	private JTextField txtUlazniBruto;
	private JTextField txtIzlazniTara;
	private JTextField txtIzlazniNeto;
	private JTextField txtIzlazniIznos;

	/**
	 * Create the panel.
	 */
	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;
	private JTable tblNBStavke;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtUlazniIzlaz;

	public Otkup() {
	
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		JPanel pnlNB = new JPanel();
		pnlNB.setBackground(Color.WHITE);
		pnlNB.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		pnlNB.setMaximumSize(new Dimension(screenSirina - 300, screenVisina));

		JButton btnNBSacuvaj = new JButton("Сачувај брање");
		btnNBSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNBSacuvaj.setForeground(Color.BLACK);
		btnNBSacuvaj.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNBSacuvaj.setFocusable(false);
		btnNBSacuvaj.setBackground(new Color(0, 194, 0));

		JLabel lblNBNaslov = new JLabel("Ново Брање");
		lblNBNaslov.setFont(new Font("Arial", Font.PLAIN, 24));

		JLabel lblNBDatum = new JLabel("Датум :");
		lblNBDatum.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNBProiz = new JLabel("Произвођач :");
		lblNBProiz.setFont(new Font("Arial", Font.PLAIN, 14));

		JDateChooser dtcNBDatum = new JDateChooser();
		dtcNBDatum.getCalendarButton().setBackground(Color.WHITE);
		dtcNBDatum.setBackground(Color.WHITE);

		JComboBox<String> cmbNBProiz = new JComboBox<String>();
		cmbNBProiz.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbNBProiz.setBackground(Color.WHITE);

		JPanel pnlNBGlavni = new JPanel();
		pnlNBGlavni.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlNBGlavni.setBackground(Color.WHITE);

		JPanel pnlNBIzlazni = new JPanel();
		pnlNBIzlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNBIzlazni.setBackground(Color.WHITE);

		JLabel lblIzlazniTara = new JLabel("Тара :");
		lblIzlazniTara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIzlazniTara.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtIzlazniTara = new JTextField();
		txtIzlazniTara.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniTara.setEditable(false);
		txtIzlazniTara.setColumns(10);

		JLabel lblIzlazniNeto = new JLabel("Нето :");
		lblIzlazniNeto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIzlazniNeto.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtIzlazniNeto = new JTextField();
		txtIzlazniNeto.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniNeto.setEditable(false);
		txtIzlazniNeto.setColumns(10);

		JLabel lblIzlazniIznos = new JLabel("Износ ставке :");
		lblIzlazniIznos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIzlazniIznos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtIzlazniIznos = new JTextField();
		txtIzlazniIznos.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniIznos.setEditable(false);
		txtIzlazniIznos.setColumns(10);

		JPanel pnlNBUlazni = new JPanel();
		pnlNBUlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNBUlazni.setBackground(Color.WHITE);

		JLabel lblUlazniProizvod = new JLabel("Производ :");
		lblUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 14));

		JComboBox<String> cmbUlazniProizvod = new JComboBox<String>();
		cmbUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniProizvod.setBackground(Color.WHITE);

		JLabel lblUlazniCena = new JLabel("Цена  :");
		lblUlazniCena.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtUlazniCena = new JTextField();
		txtUlazniCena.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniCena.setColumns(10);

		JLabel lblUlazniUlaz = new JLabel("Улаз");
		lblUlazniUlaz.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtUlazniUlaz = new JTextField();
		txtUlazniUlaz.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniUlaz.setEditable(false);
		txtUlazniUlaz.setColumns(10);

		JLabel lblUlazniBruto = new JLabel("Бруто  :");
		lblUlazniBruto.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtUlazniBruto = new JTextField();
		txtUlazniBruto.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniBruto.setColumns(10);

		JLabel lblUlazniTekst = new JLabel("Унесите ставку брања\r\n");
		lblUlazniTekst.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblUlazniAmbalaza = new JLabel("Амбалажа");
		lblUlazniAmbalaza.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JComboBox<String> cmbUlazniAmbalaza = new JComboBox<String>();
		cmbUlazniAmbalaza.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniAmbalaza.setBackground(Color.WHITE);

		JButton btnNBIzracunaj = new JButton("ИЗРАЧУНАЈ");
		btnNBIzracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				///////////////////////////////////////////////////////////////////////////////////////////////////

				// OBRADA IZRAČUNAJ

				// validacija radio dugmića

				/*if (rdbUlazni04.isSelected() == false & rdbUlazni05.isSelected() == false
						& rdbUlazniMasa.isSelected() == false) {
					Obavestenje.prikaziPoruku("Не можете израчунати параметре, маса гајбица није изабрана !",
							TipObavestenja.UPOZORENJE);
				}*/

				// validacija bruta, cene i polja za ulaz za radio04 i radio05

				/*if (rdbUlazni04.isSelected()) {
					if (txtUlazniUlaz.getText().equals("") || txtUlazniBruto.getText().equals("")
							|| txtUlazniCena.getText().equals("")) {
						Obavestenje.prikaziPoruku("Нисте унели све податке !", TipObavestenja.UPOZORENJE);

						return;
					}
				}*/

				/*if (rdbUlazni05.isSelected()) {
					if (txtUlazniUlaz.getText().equals("") || txtUlazniBruto.getText().equals("")
							|| txtUlazniCena.getText().equals("")) {
						Obavestenje.prikaziPoruku("Нисте унели све податке !", TipObavestenja.UPOZORENJE);

						return;
					}
				}*/

				/*if (rdbUlazniMasa.isSelected() == true) {
					if (txtUlazniMasa.getText().equals("") || txtUlazniUlaz.getText().equals("")
							|| txtUlazniBruto.getText().equals("") || txtUlazniCena.getText().equals("")) {
						Obavestenje.prikaziPoruku("Нисте унели све податке !", TipObavestenja.UPOZORENJE);

						return;

					}

				}*/
				/////////////////////////////////////////////////////////////////////////////////////

				// deklaracija promenljivih
				int ulaz;
				float bruto;
				float cena;
				float masa;

				// inicijalizacija promenljivih

				bruto = Float.valueOf(txtUlazniBruto.getText());
				cena = Float.valueOf(txtUlazniCena.getText());
				ulaz = Integer.valueOf(txtUlazniUlaz.getText());
				masa = vratiMasu();

				StavkaInitial.izracunajStavku(ulaz, masa, bruto, cena);

			}

		});
		///////////////////////////////////////////////////////////////////////////////////////////////////

		btnNBIzracunaj.setForeground(Color.BLACK);
		btnNBIzracunaj.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNBIzracunaj.setFocusable(false);
		btnNBIzracunaj.setBackground(new Color(153, 255, 153));

		JButton btnUlazniIzbrisi = new JButton("ИЗБРИШИ");
		btnUlazniIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ulazni
				txtUlazniUlaz.setText("");
				txtUlazniBruto.setText("");
				txtUlazniCena.setText("");

				// izlazni
				txtIzlazniNeto.setText("");
				txtIzlazniTara.setText("");
				txtIzlazniIznos.setText("");

			}
		});
		btnUlazniIzbrisi.setForeground(Color.RED);
		btnUlazniIzbrisi.setFont(new Font("Arial", Font.BOLD, 12));
		btnUlazniIzbrisi.setFocusable(false);
		btnUlazniIzbrisi.setBackground(Color.WHITE);

		JScrollPane jspNBscroll = new JScrollPane();
		jspNBscroll.setBackground(Color.WHITE);

		tblNBStavke = new JTable();
		tblNBStavke.setBackground(Color.WHITE);
		jspNBscroll.setViewportView(tblNBStavke);

		DefaultTableModel model = new DefaultTableModel();
		String kolone[] = { "ИД ставке", "Производ", "Улаз", "Маса амбалаже [kg]", "Бруто", "Тара", "Нето", "Цена/kg",
				"Износ" };
		// dodavanje modela
		tblNBStavke.setModel(model);
		model.setColumnIdentifiers(kolone);

		JButton btnUlazniDodaj = new JButton("Додај ставку");
		btnUlazniDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUlazniDodaj.setForeground(Color.BLACK);
		btnUlazniDodaj.setFont(new Font("Arial", Font.PLAIN, 12));
		btnUlazniDodaj.setFocusable(false);
		btnUlazniDodaj.setBackground(new Color(153, 255, 153));
		
		JLabel lblUlazniIzlaz = new JLabel("Излаз");
		lblUlazniIzlaz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtUlazniIzlaz = new JTextField();
		txtUlazniIzlaz.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniIzlaz.setColumns(10);
		
		JLabel lblUlazniOMesto = new JLabel("Откупно место");
		lblUlazniOMesto.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JComboBox<String> cmbUlazniOMesto = new JComboBox<String>();
		cmbUlazniOMesto.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniOMesto.setBackground(Color.WHITE);
		GroupLayout gl_pnlNBUlazni = new GroupLayout(pnlNBUlazni);
		gl_pnlNBUlazni.setHorizontalGroup(
			gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNBUlazni.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniTekst, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_pnlNBUlazni.createSequentialGroup()
								.addComponent(lblUlazniOMesto, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cmbUlazniOMesto, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_pnlNBUlazni.createSequentialGroup()
								.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblUlazniProizvod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblUlazniAmbalaza, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblUlazniCena, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblUlazniBruto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblUlazniUlaz, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
									.addComponent(lblUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
								.addGap(55)
								.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtUlazniIzlaz)
									.addGroup(Alignment.TRAILING, gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtUlazniUlaz, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
										.addComponent(txtUlazniBruto, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
										.addComponent(txtUlazniCena, Alignment.TRAILING))
									.addComponent(cmbUlazniAmbalaza, 0, 286, Short.MAX_VALUE)
									.addComponent(cmbUlazniProizvod, 0, 286, Short.MAX_VALUE)))))
					.addGap(58))
		);
		gl_pnlNBUlazni.setVerticalGroup(
			gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNBUlazni.createSequentialGroup()
					.addComponent(lblUlazniTekst)
					.addGap(19)
					.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNBUlazni.createSequentialGroup()
							.addComponent(lblUlazniProizvod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUlazniAmbalaza, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUlazniOMesto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(lblUlazniUlaz, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblUlazniBruto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(lblUlazniCena, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNBUlazni.createSequentialGroup()
							.addComponent(cmbUlazniProizvod, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(cmbUlazniAmbalaza, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cmbUlazniOMesto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(txtUlazniUlaz, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtUlazniBruto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtUlazniCena, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		pnlNBUlazni.setLayout(gl_pnlNBUlazni);
		GroupLayout gl_pnlNBIzlazni = new GroupLayout(pnlNBIzlazni);
		gl_pnlNBIzlazni.setHorizontalGroup(
			gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
					.addGap(12)
					.addComponent(lblIzlazniTara, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtIzlazniTara, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
					.addGap(26)
					.addComponent(lblIzlazniNeto, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtIzlazniNeto, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
					.addGap(8)
					.addComponent(lblIzlazniIznos, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(txtIzlazniIznos, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlNBIzlazni.setVerticalGroup(
			gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIzlazniTara, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIzlazniTara, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIzlazniNeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
							.addGap(4)
							.addComponent(txtIzlazniNeto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addGroup(gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
							.addGap(2)
							.addComponent(lblIzlazniIznos, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtIzlazniIznos, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
		);
		pnlNBIzlazni.setLayout(gl_pnlNBIzlazni);
		GroupLayout gl_pnlNBGlavni = new GroupLayout(pnlNBGlavni);
		gl_pnlNBGlavni.setHorizontalGroup(
			gl_pnlNBGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNBGlavni.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_pnlNBGlavni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNBGlavni.createSequentialGroup()
							.addComponent(pnlNBUlazni, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addGroup(gl_pnlNBGlavni.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlNBIzlazni, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNBIzracunaj, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUlazniIzbrisi, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUlazniDodaj, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)))
						.addComponent(jspNBscroll, GroupLayout.PREFERRED_SIZE, 1304, GroupLayout.PREFERRED_SIZE)))
		);
		gl_pnlNBGlavni.setVerticalGroup(
			gl_pnlNBGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNBGlavni.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_pnlNBGlavni.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlNBUlazni, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNBGlavni.createSequentialGroup()
							.addComponent(pnlNBIzlazni, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNBIzracunaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUlazniIzbrisi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUlazniDodaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(jspNBscroll, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
		);
		pnlNBGlavni.setLayout(gl_pnlNBGlavni);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlNB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(pnlNB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_pnlNB = new GroupLayout(pnlNB);
		gl_pnlNB.setHorizontalGroup(
			gl_pnlNB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNB.createSequentialGroup()
					.addGap(120)
					.addComponent(lblNBNaslov, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlNB.createSequentialGroup()
					.addGap(120)
					.addComponent(lblNBProiz, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cmbNBProiz, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlNB.createSequentialGroup()
					.addGap(120)
					.addComponent(lblNBDatum, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(dtcNBDatum, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlNB.createSequentialGroup()
					.addGap(120)
					.addComponent(pnlNBGlavni, GroupLayout.PREFERRED_SIZE, 1224, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlNB.createSequentialGroup()
					.addGap(856)
					.addComponent(btnNBSacuvaj, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlNB.setVerticalGroup(
			gl_pnlNB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNB.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNBNaslov, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_pnlNB.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNBProiz, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNB.createSequentialGroup()
							.addGap(1)
							.addComponent(cmbNBProiz, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_pnlNB.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNBDatum, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(dtcNBDatum, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(pnlNBGlavni, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnNBSacuvaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		pnlNB.setLayout(gl_pnlNB);
		setLayout(groupLayout);

	

	}
			
		
	// funkcija koja vraća izabranu masu ambalaže
	public float vratiMasu() {
		
		return (float) 0.5;
	}

	public JTextField getTxtIzlazniTara() {
		return txtIzlazniTara;
	}

	public JTextField getTxtIzlazniNeto() {
		return txtIzlazniNeto;
	}

	public JTextField getTxtIzlazniIznos() {
		return txtIzlazniIznos;
	}
			}	
