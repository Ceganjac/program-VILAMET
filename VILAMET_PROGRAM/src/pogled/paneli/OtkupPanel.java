package pogled.paneli;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import pogled.GradientPanel;
import pogled.Obavestenje;
import pogled.PozadinaPanel;
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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class OtkupPanel extends JPanel {

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
	private JTextField txtIzlazniIznosPdv;
	private JTextField txtIzlazniUkupno;
	private JTextField txtUlazniBrutoCena;
	private JTextField txtUlazniPdv;

	public OtkupPanel() {

		setPreferredSize(new Dimension(screenSirina - 300, screenVisina - 50));

		// pnlOtkup ne mora da ima postavljenu dimenziju zbog grou layout-a
		JPanel pnlOtkup = new JPanel();
		pnlOtkup.setBorder(null);
		pnlOtkup.setBackground(Color.WHITE);

		JButton btnNBSacuvaj = new JButton("Сачувај брање");
		btnNBSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNBSacuvaj.setForeground(Color.BLACK);
		btnNBSacuvaj.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNBSacuvaj.setFocusable(false);
		btnNBSacuvaj.setBackground(new Color(0, 194, 0));

		JLabel lblOtkupDatum = new JLabel("Датум :");
		lblOtkupDatum.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblOtkupProiz = new JLabel("Произвођач :");
		lblOtkupProiz.setFont(new Font("Arial", Font.PLAIN, 16));

		JDateChooser dtcOtkupDatum = new JDateChooser();
		dtcOtkupDatum.getCalendarButton().setBackground(Color.WHITE);
		dtcOtkupDatum.setBackground(Color.WHITE);

		JComboBox<String> cmbOtkupProiz = new JComboBox<String>();
		cmbOtkupProiz.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbOtkupProiz.setBackground(Color.WHITE);

		// Panel OtkupGlavni sa tittled border
		JPanel pnlOtkupGlavni = new JPanel();
		pnlOtkupGlavni.setBorder(new LineBorder(Color.GRAY));
		pnlOtkupGlavni.setOpaque(false);
		pnlOtkupGlavni.setBackground(Color.WHITE);

		JPanel pnlGlavniIzlazni = new JPanel();
		pnlGlavniIzlazni.setBackground(Color.WHITE);
		pnlGlavniIzlazni.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "\u0422\u0430\u0440\u0430, \u041D\u0435\u0442\u043E, \u0418\u0437\u043D\u043E\u0441", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));


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

		// Panel GlavnuUlazni
		JPanel pnlGlavniUlazni = new JPanel();
		pnlGlavniUlazni.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "\u0423\u043D\u043E\u0441 \u0441\u0442\u0430\u0432\u043A\u0435", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlGlavniUlazni.setBackground(Color.WHITE);

		JLabel lblUlazniProizvod = new JLabel("Производ :");
		lblUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox<String> cmbUlazniProizvod = new JComboBox<String>();
		cmbUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbUlazniProizvod.setBackground(Color.WHITE);

		JLabel lblUlazniCena = new JLabel("Нето цена :");
		lblUlazniCena.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniCena = new JTextField();
		txtUlazniCena.setEditable(false);
		txtUlazniCena.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniCena.setColumns(10);

		JLabel lblUlazniUlaz = new JLabel("Улаз");
		lblUlazniUlaz.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniUlaz = new JTextField();
		txtUlazniUlaz.setFont(new Font("Tahoma", Font.PLAIN, 12));
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

		JButton btnUlazniIzracunaj = new JButton("ИЗРАЧУНАЈ");
		btnUlazniIzracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				///////////////////////////////////////////////////////////////////////////////////////////////////

				// OBRADA IZRAČUNAJ

				// validacija radio dugmića

				/*
				 * if (rdbUlazni04.isSelected() == false & rdbUlazni05.isSelected() == false &
				 * rdbUlazniMasa.isSelected() == false) { Obavestenje.
				 * prikaziPoruku("Не можете израчунати параметре, маса гајбица није изабрана !",
				 * TipObavestenja.UPOZORENJE); }
				 */

				// validacija bruta, cene i polja za ulaz za radio04 i radio05

				/*
				 * if (rdbUlazni04.isSelected()) { if (txtUlazniUlaz.getText().equals("") ||
				 * txtUlazniBruto.getText().equals("") || txtUlazniCena.getText().equals("")) {
				 * Obavestenje.prikaziPoruku("Нисте унели све податке !",
				 * TipObavestenja.UPOZORENJE);
				 * 
				 * return; } }
				 */

				/*
				 * if (rdbUlazni05.isSelected()) { if (txtUlazniUlaz.getText().equals("") ||
				 * txtUlazniBruto.getText().equals("") || txtUlazniCena.getText().equals("")) {
				 * Obavestenje.prikaziPoruku("Нисте унели све податке !",
				 * TipObavestenja.UPOZORENJE);
				 * 
				 * return; } }
				 */

				/*
				 * if (rdbUlazniMasa.isSelected() == true) { if
				 * (txtUlazniMasa.getText().equals("") || txtUlazniUlaz.getText().equals("") ||
				 * txtUlazniBruto.getText().equals("") || txtUlazniCena.getText().equals("")) {
				 * Obavestenje.prikaziPoruku("Нисте унели све податке !",
				 * TipObavestenja.UPOZORENJE);
				 * 
				 * return;
				 * 
				 * }
				 * 
				 * }
				 */
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

		btnUlazniIzracunaj.setForeground(Color.BLACK);
		btnUlazniIzracunaj.setFont(new Font("Arial", Font.PLAIN, 15));
		btnUlazniIzracunaj.setFocusable(false);
		btnUlazniIzracunaj.setBackground(new Color(153, 255, 153));

		JButton btnUlazniIsprazni = new JButton("Испразни поља");
		btnUlazniIsprazni.addActionListener(new ActionListener() {
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
		btnUlazniIsprazni.setForeground(Color.RED);
		btnUlazniIsprazni.setFont(new Font("Arial", Font.PLAIN, 15));
		btnUlazniIsprazni.setFocusable(false);
		btnUlazniIsprazni.setBackground(Color.WHITE);

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
		String kolone[] = { "Примљено", "Издато", "Бруто", "Тара", "Нето", "Цена(kg)", "ПДВ(%)", "Бруто цена",
				"Износ ПДВ-а", "Износ", "Укупна накнада" };
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
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup()
						.addComponent(pnlOtkup, GroupLayout.PREFERRED_SIZE, 1620, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(374, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlOtkup, GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(225, Short.MAX_VALUE)));

		JLabel lblUlazniBrutoCena = new JLabel("Бруто цена :");
		lblUlazniBrutoCena.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniBrutoCena = new JTextField();
		txtUlazniBrutoCena.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniBrutoCena.setEditable(false);
		txtUlazniBrutoCena.setColumns(10);

		JLabel lblUlazniPdv = new JLabel("ПДВ (%) :");
		lblUlazniPdv.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniPdv = new JTextField();
		txtUlazniPdv.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniPdv.setEditable(false);
		txtUlazniPdv.setColumns(10);
		GroupLayout gl_pnlGlavniUlazni = new GroupLayout(pnlGlavniUlazni);
		gl_pnlGlavniUlazni.setHorizontalGroup(
			gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUlazniPdv, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUlazniCena, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUlazniBruto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUlazniProizvod, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(lblUlazniAmbalaza, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(lblUlazniUlaz, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUlazniBrutoCena, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUlazniIzlaz, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cmbUlazniProizvod, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtUlazniIzlaz, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_pnlGlavniUlazni.createSequentialGroup()
							.addComponent(txtUlazniBrutoCena)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(txtUlazniPdv, Alignment.TRAILING)
						.addComponent(txtUlazniCena, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(txtUlazniUlaz, Alignment.TRAILING)
						.addComponent(cmbUlazniAmbalaza, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtUlazniBruto, Alignment.TRAILING))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_pnlGlavniUlazni.setVerticalGroup(
			gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUlazniProizvod, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbUlazniProizvod, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniAmbalaza, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbUlazniAmbalaza, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniUlaz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniUlaz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUlazniBruto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniBruto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(txtUlazniCena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUlazniCena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUlazniPdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniPdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_pnlGlavniUlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
							.addComponent(lblUlazniBrutoCena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniUlazni.createSequentialGroup()
							.addComponent(txtUlazniBrutoCena, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtUlazniIzlaz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(30))
		);
		pnlGlavniUlazni.setLayout(gl_pnlGlavniUlazni);

		JLabel lblIzlazniIznosPdv = new JLabel("Износ ПДВ-а :");
		lblIzlazniIznosPdv.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniIznosPdv.setFont(new Font("Arial", Font.PLAIN, 16));

		txtIzlazniIznosPdv = new JTextField();
		txtIzlazniIznosPdv.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniIznosPdv.setEditable(false);
		txtIzlazniIznosPdv.setColumns(10);

		JLabel lblIzlazniUkupno = new JLabel("Укупна накнада :");
		lblIzlazniUkupno.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniUkupno.setFont(new Font("Arial", Font.PLAIN, 16));

		txtIzlazniUkupno = new JTextField();
		txtIzlazniUkupno.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniUkupno.setEditable(false);
		txtIzlazniUkupno.setColumns(10);
		GroupLayout gl_pnlGlavniIzlazni = new GroupLayout(pnlGlavniIzlazni);
		gl_pnlGlavniIzlazni.setHorizontalGroup(
			gl_pnlGlavniIzlazni.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblIzlazniUkupno, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
							.addComponent(lblIzlazniIznosPdv, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblIzlazniNeto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblIzlazniTara, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addComponent(lblIzlazniIznos, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtIzlazniUkupno)
						.addComponent(txtIzlazniIznosPdv)
						.addComponent(txtIzlazniTara, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addComponent(txtIzlazniNeto, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addComponent(txtIzlazniIznos, 220, 220, Short.MAX_VALUE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_pnlGlavniIzlazni.setVerticalGroup(
			gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addComponent(lblIzlazniTara, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblIzlazniNeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblIzlazniIznos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addComponent(txtIzlazniTara, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtIzlazniNeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtIzlazniIznos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblIzlazniIznosPdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlGlavniIzlazni.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIzlazniUkupno, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIzlazniUkupno, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlGlavniIzlazni.createSequentialGroup()
							.addGap(2)
							.addComponent(txtIzlazniIznosPdv, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		pnlGlavniIzlazni.setLayout(gl_pnlGlavniIzlazni);
		GroupLayout gl_pnlOtkupGlavni = new GroupLayout(pnlOtkupGlavni);
		gl_pnlOtkupGlavni.setHorizontalGroup(
			gl_pnlOtkupGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupGlavni.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlOtkupGlavni.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(jspGlavniScroll, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_pnlOtkupGlavni.createSequentialGroup()
							.addComponent(pnlGlavniUlazni, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addGroup(gl_pnlOtkupGlavni.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnUlazniDodaj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnUlazniIzracunaj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlGlavniIzlazni, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnUlazniIsprazni, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_pnlOtkupGlavni.setVerticalGroup(
			gl_pnlOtkupGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkupGlavni.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pnlOtkupGlavni.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_pnlOtkupGlavni.createSequentialGroup()
							.addComponent(pnlGlavniIzlazni, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUlazniIzracunaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUlazniIsprazni, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUlazniDodaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlGlavniUlazni, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(jspGlavniScroll, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		pnlOtkupGlavni.setLayout(gl_pnlOtkupGlavni);

		JLabel lblOtkupOMesto = new JLabel("Откупно место");
		lblOtkupOMesto.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox<String> cmbOtkupOMesto = new JComboBox<String>();
		cmbOtkupOMesto.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbOtkupOMesto.setBackground(Color.WHITE);

		JLabel lblOtkupUIsplate = new JLabel("Услови исплате");
		lblOtkupUIsplate.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox<String> cmbOtkupUIsplate = new JComboBox<String>();
		cmbOtkupUIsplate.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbOtkupUIsplate.setBackground(Color.WHITE);
		GroupLayout gl_pnlOtkup = new GroupLayout(pnlOtkup);
		gl_pnlOtkup.setHorizontalGroup(
			gl_pnlOtkup.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlOtkup.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_pnlOtkup.createSequentialGroup()
							.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_pnlOtkup.createSequentialGroup()
									.addComponent(lblOtkupProiz, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addGap(24))
								.addGroup(gl_pnlOtkup.createSequentialGroup()
									.addComponent(lblOtkupDatum, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbOtkupProiz, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(dtcOtkupDatum, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_pnlOtkup.createSequentialGroup()
									.addComponent(lblOtkupOMesto, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(cmbOtkupOMesto, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlOtkup.createSequentialGroup()
									.addComponent(lblOtkupUIsplate, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(cmbOtkupUIsplate, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnNBSacuvaj, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlOtkupGlavni, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(379, Short.MAX_VALUE))
		);
		gl_pnlOtkup.setVerticalGroup(
			gl_pnlOtkup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOtkup.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlOtkup.createSequentialGroup()
							.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOtkupProiz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbOtkupProiz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlOtkup.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(dtcOtkupDatum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblOtkupDatum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlOtkup.createSequentialGroup()
							.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOtkupOMesto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbOtkupOMesto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnlOtkup.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlOtkup.createSequentialGroup()
									.addGap(10)
									.addComponent(lblOtkupUIsplate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlOtkup.createSequentialGroup()
									.addGap(10)
									.addComponent(cmbOtkupUIsplate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))))
					.addGap(32)
					.addComponent(pnlOtkupGlavni, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnNBSacuvaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(255))
		);
		pnlOtkup.setLayout(gl_pnlOtkup);
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
