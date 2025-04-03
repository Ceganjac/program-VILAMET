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
		btnNBSacuvaj.setBounds(825, 723, 328, 30);
		btnNBSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNBSacuvaj.setForeground(Color.BLACK);
		btnNBSacuvaj.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNBSacuvaj.setFocusable(false);
		btnNBSacuvaj.setBackground(new Color(0, 194, 0));

		JLabel lblNBNaslov = new JLabel("Откуп");
		lblNBNaslov.setBounds(120, 10, 209, 45);
		lblNBNaslov.setFont(new Font("Arial", Font.PLAIN, 24));

		JLabel lblNBDatum = new JLabel("Датум :");
		lblNBDatum.setBounds(120, 121, 135, 24);
		lblNBDatum.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNBProiz = new JLabel("Произвођач :");
		lblNBProiz.setBounds(120, 86, 135, 24);
		lblNBProiz.setFont(new Font("Arial", Font.PLAIN, 14));

		JDateChooser dtcNBDatum = new JDateChooser();
		dtcNBDatum.setBounds(260, 121, 250, 24);
		dtcNBDatum.getCalendarButton().setBackground(Color.WHITE);
		dtcNBDatum.setBackground(Color.WHITE);

		JComboBox<String> cmbNBProiz = new JComboBox<String>();
		cmbNBProiz.setBounds(259, 87, 250, 24);
		cmbNBProiz.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbNBProiz.setBackground(Color.WHITE);

		JPanel pnlNBGlavni = new JPanel();
		pnlNBGlavni.setBounds(120, 174, 1033, 529);
		pnlNBGlavni.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlNBGlavni.setBackground(Color.WHITE);

		JPanel pnlNBIzlazni = new JPanel();
		pnlNBIzlazni.setBounds(619, 22, 384, 218);
		pnlNBIzlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNBIzlazni.setBackground(Color.WHITE);
		
		// kreiranje naslova unutar linije panela
		TitledBorder naslovIzlazni = new TitledBorder("Нето, тара, износ");
		pnlNBIzlazni.setBorder(naslovIzlazni);

		JLabel lblIzlazniTara = new JLabel("Тара :");
		lblIzlazniTara.setBounds(24, 43, 71, 24);
		lblIzlazniTara.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniTara.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtIzlazniTara = new JTextField();
		txtIzlazniTara.setBounds(135, 43, 129, 24);
		txtIzlazniTara.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniTara.setEditable(false);
		txtIzlazniTara.setColumns(10);

		JLabel lblIzlazniNeto = new JLabel("Нето :");
		lblIzlazniNeto.setBounds(20, 77, 75, 26);
		lblIzlazniNeto.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniNeto.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtIzlazniNeto = new JTextField();
		txtIzlazniNeto.setBounds(135, 74, 129, 24);
		txtIzlazniNeto.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniNeto.setEditable(false);
		txtIzlazniNeto.setColumns(10);

		JLabel lblIzlazniIznos = new JLabel("Износ ставке :");
		lblIzlazniIznos.setBounds(20, 111, 109, 21);
		lblIzlazniIznos.setHorizontalAlignment(SwingConstants.LEFT);
		lblIzlazniIznos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtIzlazniIznos = new JTextField();
		txtIzlazniIznos.setBounds(135, 108, 129, 24);
		txtIzlazniIznos.setHorizontalAlignment(SwingConstants.CENTER);
		txtIzlazniIznos.setEditable(false);
		txtIzlazniIznos.setColumns(10);

		JPanel pnlNBUlazni = new JPanel();
		pnlNBUlazni.setBounds(30, 22, 550, 338);
		pnlNBUlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNBUlazni.setBackground(Color.WHITE);
		
		// kreiranje naslova unutar linije panela
		TitledBorder naslovUlazni = new TitledBorder("Унос ставке");
		pnlNBUlazni.setBorder(naslovUlazni);

		JLabel lblUlazniProizvod = new JLabel("Производ :");
		lblUlazniProizvod.setBounds(56, 46, 114, 24);
		lblUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 14));

		JComboBox<String> cmbUlazniProizvod = new JComboBox<String>();
		cmbUlazniProizvod.setBounds(223, 46, 250, 24);
		cmbUlazniProizvod.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniProizvod.setBackground(Color.WHITE);

		JLabel lblUlazniCena = new JLabel("Цена  :");
		lblUlazniCena.setBounds(56, 203, 114, 24);
		lblUlazniCena.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtUlazniCena = new JTextField();
		txtUlazniCena.setBounds(223, 203, 250, 24);
		txtUlazniCena.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniCena.setColumns(10);

		JLabel lblUlazniUlaz = new JLabel("Улаз");
		lblUlazniUlaz.setBounds(56, 142, 114, 24);
		lblUlazniUlaz.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtUlazniUlaz = new JTextField();
		txtUlazniUlaz.setBounds(223, 145, 250, 24);
		txtUlazniUlaz.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniUlaz.setEditable(false);
		txtUlazniUlaz.setColumns(10);

		JLabel lblUlazniBruto = new JLabel("Бруто  :");
		lblUlazniBruto.setBounds(56, 172, 114, 24);
		lblUlazniBruto.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtUlazniBruto = new JTextField();
		txtUlazniBruto.setBounds(223, 174, 250, 24);
		txtUlazniBruto.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniBruto.setColumns(10);
		
		JLabel lblUlazniAmbalaza = new JLabel("Амбалажа");
		lblUlazniAmbalaza.setBounds(58, 77, 112, 24);
		lblUlazniAmbalaza.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JComboBox<String> cmbUlazniAmbalaza = new JComboBox<String>();
		cmbUlazniAmbalaza.setBounds(223, 78, 250, 24);
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
		btnNBIzracunaj.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNBIzracunaj.setFocusable(false);
		btnNBIzracunaj.setBackground(new Color(153, 255, 153));

		JButton btnUlazniIzbrisi = new JButton("ИЗБРИШИ");
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
		btnUlazniIzbrisi.setFont(new Font("Arial", Font.BOLD, 12));
		btnUlazniIzbrisi.setFocusable(false);
		btnUlazniIzbrisi.setBackground(Color.WHITE);

		JScrollPane jspNBscroll = new JScrollPane();
		jspNBscroll.setBounds(30, 386, 973, 104);
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
		btnUlazniDodaj.setBounds(619, 330, 384, 30);
		btnUlazniDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUlazniDodaj.setForeground(Color.BLACK);
		btnUlazniDodaj.setFont(new Font("Arial", Font.PLAIN, 12));
		btnUlazniDodaj.setFocusable(false);
		btnUlazniDodaj.setBackground(new Color(153, 255, 153));
		
		JLabel lblUlazniIzlaz = new JLabel("Излаз");
		lblUlazniIzlaz.setBounds(56, 233, 114, 24);
		lblUlazniIzlaz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtUlazniIzlaz = new JTextField();
		txtUlazniIzlaz.setBounds(223, 236, 250, 24);
		txtUlazniIzlaz.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniIzlaz.setColumns(10);
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
		pnlNB.setLayout(null);
		pnlNB.add(lblNBNaslov);
		pnlNB.add(lblNBProiz);
		pnlNB.add(cmbNBProiz);
		pnlNB.add(lblNBDatum);
		pnlNB.add(dtcNBDatum);
		pnlNB.add(pnlNBGlavni);
		pnlNBGlavni.setLayout(null);
		pnlNBGlavni.add(jspNBscroll);
		pnlNBGlavni.add(pnlNBUlazni);
		pnlNBUlazni.setLayout(null);
		pnlNBUlazni.add(lblUlazniCena);
		pnlNBUlazni.add(lblUlazniBruto);
		pnlNBUlazni.add(lblUlazniUlaz);
		pnlNBUlazni.add(lblUlazniIzlaz);
		pnlNBUlazni.add(lblUlazniAmbalaza);
		pnlNBUlazni.add(lblUlazniProizvod);
		pnlNBUlazni.add(txtUlazniIzlaz);
		pnlNBUlazni.add(txtUlazniBruto);
		pnlNBUlazni.add(txtUlazniCena);
		pnlNBUlazni.add(cmbUlazniProizvod);
		pnlNBUlazni.add(txtUlazniUlaz);
		pnlNBUlazni.add(cmbUlazniAmbalaza);
		pnlNBGlavni.add(pnlNBIzlazni);
		pnlNBIzlazni.setLayout(null);
		pnlNBIzlazni.add(lblIzlazniIznos);
		pnlNBIzlazni.add(lblIzlazniTara);
		pnlNBIzlazni.add(lblIzlazniNeto);
		pnlNBIzlazni.add(txtIzlazniTara);
		pnlNBIzlazni.add(txtIzlazniIznos);
		pnlNBIzlazni.add(txtIzlazniNeto);
		pnlNBGlavni.add(btnUlazniDodaj);
		pnlNBGlavni.add(btnUlazniIzbrisi);
		pnlNBGlavni.add(btnNBIzracunaj);
		pnlNB.add(btnNBSacuvaj);
		
		JLabel lblUlazniOMesto = new JLabel("Откупно место");
		lblUlazniOMesto.setBounds(764, 86, 135, 24);
		pnlNB.add(lblUlazniOMesto);
		lblUlazniOMesto.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JComboBox<String> cmbUlazniOMesto = new JComboBox<String>();
		cmbUlazniOMesto.setBounds(903, 86, 250, 22);
		pnlNB.add(cmbUlazniOMesto);
		cmbUlazniOMesto.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniOMesto.setBackground(Color.WHITE);
		
		JLabel lblOtkupUsloviPl = new JLabel("Услови исплате");
		lblOtkupUsloviPl.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOtkupUsloviPl.setBounds(764, 121, 135, 24);
		pnlNB.add(lblOtkupUsloviPl);
		
		JComboBox<String> cmbUlazniOMesto_1 = new JComboBox<String>();
		cmbUlazniOMesto_1.setFont(new Font("Arial", Font.PLAIN, 12));
		cmbUlazniOMesto_1.setBackground(Color.WHITE);
		cmbUlazniOMesto_1.setBounds(903, 125, 250, 22);
		pnlNB.add(cmbUlazniOMesto_1);
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
