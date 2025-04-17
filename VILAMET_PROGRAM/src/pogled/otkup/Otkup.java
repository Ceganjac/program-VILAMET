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
import javax.swing.table.JTableHeader;
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
	private JTable tblStavkeLista;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtUlazniIzlaz;

	public Otkup() {
	
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		JPanel pnlOtkup = new JPanel();
		pnlOtkup.setBackground(Color.WHITE);
		pnlOtkup.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		pnlOtkup.setMaximumSize(new Dimension(screenSirina - 300, screenVisina));

		JButton btnNBSacuvaj = new JButton("Сачувај брање");
		btnNBSacuvaj.setBounds(765, 723, 384, 30);
		btnNBSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNBSacuvaj.setForeground(Color.BLACK);
		btnNBSacuvaj.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNBSacuvaj.setFocusable(false);
		btnNBSacuvaj.setBackground(new Color(0, 194, 0));

		JLabel lblOtkupNaslov = new JLabel("Откуп");
		lblOtkupNaslov.setBounds(120, 10, 209, 45);
		lblOtkupNaslov.setFont(new Font("Arial", Font.PLAIN, 26));

		JLabel lblOtkupDatum = new JLabel("Датум :");
		lblOtkupDatum.setBounds(120, 120, 145, 26);
		lblOtkupDatum.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblOtkupProiz = new JLabel("Произвођач :");
		lblOtkupProiz.setBounds(120, 80, 145, 26);
		lblOtkupProiz.setFont(new Font("Arial", Font.PLAIN, 16));

		JDateChooser dtcOtkupDatum = new JDateChooser();
		dtcOtkupDatum.setBounds(289, 120, 275, 26);
		dtcOtkupDatum.getCalendarButton().setBackground(Color.WHITE);
		dtcOtkupDatum.setBackground(Color.WHITE);

		JComboBox<String> cmbOtkupProiz = new JComboBox<String>();
		cmbOtkupProiz.setBounds(289, 80, 275, 26);
		cmbOtkupProiz.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbOtkupProiz.setBackground(Color.WHITE);

		JPanel pnlOtkupGlavni = new JPanel();
		pnlOtkupGlavni.setBounds(120, 174, 1033, 529);
		pnlOtkupGlavni.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlOtkupGlavni.setBackground(Color.WHITE);

		JPanel pnlGlavniIzlazni = new JPanel();
		pnlGlavniIzlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGlavniIzlazni.setBackground(Color.WHITE);
		
		// kreiranje naslova unutar linije panela
		TitledBorder naslovIzlazni = new TitledBorder("Нето, тара, износ");
		pnlGlavniIzlazni.setBorder(naslovIzlazni);

		JLabel lblIzlazniTara = new JLabel("Тара :");
		lblIzlazniTara.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniTara.setFont(new Font("Arial", Font.PLAIN, 16));

		txtIzlazniTara = new JTextField();
		txtIzlazniTara.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniTara.setEditable(false);
		txtIzlazniTara.setColumns(10);

		JLabel lblIzlazniNeto = new JLabel("Нето :");
		lblIzlazniNeto.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniNeto.setFont(new Font("Arial", Font.PLAIN, 16));

		txtIzlazniNeto = new JTextField();
		txtIzlazniNeto.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniNeto.setEditable(false);
		txtIzlazniNeto.setColumns(10);

		JLabel lblIzlazniIznos = new JLabel("Износ ставке :");
		lblIzlazniIznos.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniIznos.setFont(new Font("Arial", Font.PLAIN, 16));

		txtIzlazniIznos = new JTextField();
		txtIzlazniIznos.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniIznos.setEditable(false);
		txtIzlazniIznos.setColumns(10);

		JPanel pnlGlavniUlazni = new JPanel();
		pnlGlavniUlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGlavniUlazni.setBackground(Color.WHITE);
		
		// kreiranje naslova unutar linije panela
		TitledBorder naslovUlazni = new TitledBorder("Унос ставке");
		pnlGlavniUlazni.setBorder(naslovUlazni);

		JLabel lblUlazniProizvod = new JLabel("Производ :");
		lblUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox<String> cmbUlazniProizvod = new JComboBox<String>();
		cmbUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniProizvod.setBackground(Color.WHITE);

		JLabel lblUlazniCena = new JLabel("Цена  :");
		lblUlazniCena.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniCena = new JTextField();
		txtUlazniCena.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniCena.setColumns(10);

		JLabel lblUlazniUlaz = new JLabel("Улаз");
		lblUlazniUlaz.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniUlaz = new JTextField();
		txtUlazniUlaz.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniUlaz.setColumns(10);

		JLabel lblUlazniBruto = new JLabel("Бруто  :");
		lblUlazniBruto.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniBruto = new JTextField();
		txtUlazniBruto.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniBruto.setColumns(10);
		
		JLabel lblUlazniAmbalaza = new JLabel("Амбалажа");
		lblUlazniAmbalaza.setFont(new Font("Arial", Font.PLAIN, 16));
		
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
		btnNBIzracunaj.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNBIzracunaj.setFocusable(false);
		btnNBIzracunaj.setBackground(new Color(153, 255, 153));

		JButton btnUlazniIzbrisi = new JButton("Испразни поља");
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
		btnUlazniIzbrisi.setFont(new Font("Arial", Font.PLAIN, 15));
		btnUlazniIzbrisi.setFocusable(false);
		btnUlazniIzbrisi.setBackground(Color.WHITE);

		JScrollPane jspGlavniScroll = new JScrollPane();
		jspGlavniScroll.setBackground(Color.WHITE);

		// TABELA STAVKI
		
		tblStavkeLista = new JTable();
		tblStavkeLista.setBackground(Color.WHITE);
		jspGlavniScroll.setViewportView(tblStavkeLista);
		
		// heder tabele
		JTableHeader heder = tblStavkeLista.getTableHeader();
		heder.setBackground(Color.LIGHT_GRAY);
		heder.setPreferredSize(new Dimension(heder.getWidth(), 30));

		DefaultTableModel model = new DefaultTableModel();
		String kolone[] = { "ИД ставке", "Производ", "Улаз", "Маса амбалаже [kg]", "Бруто", "Тара", "Нето", "Цена/kg",
				"Износ" };
		// dodavanje modela
		tblStavkeLista.setModel(model);
		model.setColumnIdentifiers(kolone);

		JButton btnUlazniDodaj = new JButton("Додај ставку");
		btnUlazniDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUlazniDodaj.setForeground(Color.BLACK);
		btnUlazniDodaj.setFont(new Font("Arial", Font.PLAIN, 15));
		btnUlazniDodaj.setFocusable(false);
		btnUlazniDodaj.setBackground(new Color(153, 255, 153));
		
		JLabel lblUlazniIzlaz = new JLabel("Излаз");
		lblUlazniIzlaz.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtUlazniIzlaz = new JTextField();
		txtUlazniIzlaz.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniIzlaz.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlOtkup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(pnlOtkup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		pnlOtkup.setLayout(null);
		pnlOtkup.add(lblOtkupNaslov);
		pnlOtkup.add(lblOtkupProiz);
		pnlOtkup.add(cmbOtkupProiz);
		pnlOtkup.add(lblOtkupDatum);
		pnlOtkup.add(dtcOtkupDatum);
		pnlOtkup.add(pnlOtkupGlavni);
		GroupLayout gl_pnlGlavniUlazni = new GroupLayout(pnlGlavniUlazni);
		gl_pnlGlavniUlazni.setHorizontalGroup(
			gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(50)
					.addComponent(lblUlazniProizvod, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(cmbUlazniProizvod, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(52)
					.addComponent(lblUlazniAmbalaza, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(cmbUlazniAmbalaza, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(50)
					.addComponent(lblUlazniUlaz, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(txtUlazniUlaz, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(50)
					.addComponent(lblUlazniBruto, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(txtUlazniBruto, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(50)
					.addComponent(lblUlazniCena, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(txtUlazniCena, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(50)
					.addComponent(lblUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(txtUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlGlavniUlazni.setVerticalGroup(
			gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniProizvod, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbUlazniProizvod, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniAmbalaza, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbUlazniAmbalaza, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniUlaz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniUlaz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniBruto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniBruto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniCena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniCena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
		);
		pnlGlavniUlazni.setLayout(gl_pnlGlavniUlazni);
		GroupLayout gl_pnlGlavniIzlazni = new GroupLayout(pnlGlavniIzlazni);
		gl_pnlGlavniIzlazni.setHorizontalGroup(
			gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addComponent(lblIzlazniTara, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(txtIzlazniTara, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addComponent(lblIzlazniNeto, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(txtIzlazniNeto, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addComponent(lblIzlazniIznos, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtIzlazniIznos, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlGlavniIzlazni.setVerticalGroup(
			gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIzlazniTara, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addGap(3)
							.addComponent(txtIzlazniTara, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIzlazniNeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addGap(3)
							.addComponent(txtIzlazniNeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIzlazniIznos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIzlazniIznos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
		);
		pnlGlavniIzlazni.setLayout(gl_pnlGlavniIzlazni);
		GroupLayout gl_pnlOtkupGlavni = new GroupLayout(pnlOtkupGlavni);
		gl_pnlOtkupGlavni.setHorizontalGroup(
			gl_pnlOtkupGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupGlavni.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_pnlOtkupGlavni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlOtkupGlavni.createSequentialGroup()
							.addComponent(pnlGlavniUlazni, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addGroup(gl_pnlOtkupGlavni.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlGlavniIzlazni, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNBIzracunaj, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUlazniIzbrisi, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUlazniDodaj, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)))
						.addComponent(jspGlavniScroll, GroupLayout.PREFERRED_SIZE, 973, GroupLayout.PREFERRED_SIZE)))
		);
		gl_pnlOtkupGlavni.setVerticalGroup(
			gl_pnlOtkupGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupGlavni.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_pnlOtkupGlavni.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlGlavniUlazni, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlOtkupGlavni.createSequentialGroup()
							.addComponent(pnlGlavniIzlazni, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNBIzracunaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUlazniIzbrisi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUlazniDodaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(jspGlavniScroll, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
		);
		pnlOtkupGlavni.setLayout(gl_pnlOtkupGlavni);
		pnlOtkup.add(btnNBSacuvaj);
		
		JLabel lblOtkupOMesto = new JLabel("Откупно место");
		lblOtkupOMesto.setBounds(701, 86, 145, 24);
		pnlOtkup.add(lblOtkupOMesto);
		lblOtkupOMesto.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JComboBox<String> cmbOtkupOMesto = new JComboBox<String>();
		cmbOtkupOMesto.setBounds(878, 86, 275, 26);
		pnlOtkup.add(cmbOtkupOMesto);
		cmbOtkupOMesto.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbOtkupOMesto.setBackground(Color.WHITE);
		
		JLabel lblOtkupUIsplate = new JLabel("Услови исплате");
		lblOtkupUIsplate.setFont(new Font("Arial", Font.PLAIN, 16));
		lblOtkupUIsplate.setBounds(701, 121, 145, 26);
		pnlOtkup.add(lblOtkupUIsplate);
		
		JComboBox<String> cmbOtkupUIsplate = new JComboBox<String>();
		cmbOtkupUIsplate.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbOtkupUIsplate.setBackground(Color.WHITE);
		cmbOtkupUIsplate.setBounds(878, 125, 275, 26);
		pnlOtkup.add(cmbOtkupUIsplate);
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
