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
		pnlGlavniIzlazni.setBounds(619, 22, 384, 218);
		pnlGlavniIzlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGlavniIzlazni.setBackground(Color.WHITE);
		
		// kreiranje naslova unutar linije panela
		TitledBorder naslovIzlazni = new TitledBorder("Нето, тара, износ");
		pnlGlavniIzlazni.setBorder(naslovIzlazni);

		JLabel lblIzlazniTara = new JLabel("Тара :");
		lblIzlazniTara.setBounds(30, 40, 71, 26);
		lblIzlazniTara.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniTara.setFont(new Font("Arial", Font.PLAIN, 16));

		txtIzlazniTara = new JTextField();
		txtIzlazniTara.setBounds(161, 43, 150, 26);
		txtIzlazniTara.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniTara.setEditable(false);
		txtIzlazniTara.setColumns(10);

		JLabel lblIzlazniNeto = new JLabel("Нето :");
		lblIzlazniNeto.setBounds(30, 80, 75, 26);
		lblIzlazniNeto.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniNeto.setFont(new Font("Arial", Font.PLAIN, 16));

		txtIzlazniNeto = new JTextField();
		txtIzlazniNeto.setBounds(160, 83, 150, 26);
		txtIzlazniNeto.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniNeto.setEditable(false);
		txtIzlazniNeto.setColumns(10);

		JLabel lblIzlazniIznos = new JLabel("Износ ставке :");
		lblIzlazniIznos.setBounds(30, 120, 109, 26);
		lblIzlazniIznos.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniIznos.setFont(new Font("Arial", Font.PLAIN, 16));

		txtIzlazniIznos = new JTextField();
		txtIzlazniIznos.setBounds(161, 120, 150, 26);
		txtIzlazniIznos.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniIznos.setEditable(false);
		txtIzlazniIznos.setColumns(10);

		JPanel pnlGlavniUlazni = new JPanel();
		pnlGlavniUlazni.setBounds(30, 22, 550, 338);
		pnlGlavniUlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGlavniUlazni.setBackground(Color.WHITE);
		
		// kreiranje naslova unutar linije panela
		TitledBorder naslovUlazni = new TitledBorder("Унос ставке");
		pnlGlavniUlazni.setBorder(naslovUlazni);

		JLabel lblUlazniProizvod = new JLabel("Производ :");
		lblUlazniProizvod.setBounds(56, 40, 116, 26);
		lblUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 16));

		JComboBox<String> cmbUlazniProizvod = new JComboBox<String>();
		cmbUlazniProizvod.setBounds(223, 40, 275, 26);
		cmbUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniProizvod.setBackground(Color.WHITE);

		JLabel lblUlazniCena = new JLabel("Цена  :");
		lblUlazniCena.setBounds(56, 220, 116, 26);
		lblUlazniCena.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniCena = new JTextField();
		txtUlazniCena.setBounds(223, 223, 275, 26);
		txtUlazniCena.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniCena.setColumns(10);

		JLabel lblUlazniUlaz = new JLabel("Улаз");
		lblUlazniUlaz.setBounds(56, 140, 116, 26);
		lblUlazniUlaz.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniUlaz = new JTextField();
		txtUlazniUlaz.setBounds(223, 140, 275, 26);
		txtUlazniUlaz.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniUlaz.setColumns(10);

		JLabel lblUlazniBruto = new JLabel("Бруто  :");
		lblUlazniBruto.setBounds(56, 180, 116, 26);
		lblUlazniBruto.setFont(new Font("Arial", Font.PLAIN, 16));

		txtUlazniBruto = new JTextField();
		txtUlazniBruto.setBounds(223, 183, 275, 26);
		txtUlazniBruto.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniBruto.setColumns(10);
		
		JLabel lblUlazniAmbalaza = new JLabel("Амбалажа");
		lblUlazniAmbalaza.setBounds(58, 80, 116, 26);
		lblUlazniAmbalaza.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JComboBox<String> cmbUlazniAmbalaza = new JComboBox<String>();
		cmbUlazniAmbalaza.setBounds(223, 80, 275, 26);
		cmbUlazniAmbalaza.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniAmbalaza.setBackground(Color.WHITE);

		JButton btnNBIzracunaj = new JButton("ИЗРАЧУНАЈ");
		btnNBIzracunaj.setBounds(619, 250, 384, 30);
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
		btnUlazniIzbrisi.setBounds(619, 290, 384, 30);
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
		jspGlavniScroll.setBounds(30, 386, 973, 104);
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
		btnUlazniDodaj.setBounds(619, 330, 384, 30);
		btnUlazniDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUlazniDodaj.setForeground(Color.BLACK);
		btnUlazniDodaj.setFont(new Font("Arial", Font.PLAIN, 15));
		btnUlazniDodaj.setFocusable(false);
		btnUlazniDodaj.setBackground(new Color(153, 255, 153));
		
		JLabel lblUlazniIzlaz = new JLabel("Излаз");
		lblUlazniIzlaz.setBounds(56, 260, 116, 26);
		lblUlazniIzlaz.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtUlazniIzlaz = new JTextField();
		txtUlazniIzlaz.setBounds(223, 263, 275, 26);
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
		pnlOtkupGlavni.setLayout(null);
		pnlOtkupGlavni.add(jspGlavniScroll);
		pnlOtkupGlavni.add(pnlGlavniUlazni);
		pnlGlavniUlazni.setLayout(null);
		pnlGlavniUlazni.add(lblUlazniCena);
		pnlGlavniUlazni.add(lblUlazniBruto);
		pnlGlavniUlazni.add(lblUlazniUlaz);
		pnlGlavniUlazni.add(lblUlazniIzlaz);
		pnlGlavniUlazni.add(lblUlazniAmbalaza);
		pnlGlavniUlazni.add(lblUlazniProizvod);
		pnlGlavniUlazni.add(txtUlazniIzlaz);
		pnlGlavniUlazni.add(txtUlazniBruto);
		pnlGlavniUlazni.add(txtUlazniCena);
		pnlGlavniUlazni.add(cmbUlazniProizvod);
		pnlGlavniUlazni.add(txtUlazniUlaz);
		pnlGlavniUlazni.add(cmbUlazniAmbalaza);
		pnlOtkupGlavni.add(pnlGlavniIzlazni);
		pnlGlavniIzlazni.setLayout(null);
		pnlGlavniIzlazni.add(lblIzlazniIznos);
		pnlGlavniIzlazni.add(lblIzlazniTara);
		pnlGlavniIzlazni.add(lblIzlazniNeto);
		pnlGlavniIzlazni.add(txtIzlazniTara);
		pnlGlavniIzlazni.add(txtIzlazniIznos);
		pnlGlavniIzlazni.add(txtIzlazniNeto);
		pnlOtkupGlavni.add(btnUlazniDodaj);
		pnlOtkupGlavni.add(btnUlazniIzbrisi);
		pnlOtkupGlavni.add(btnNBIzracunaj);
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
