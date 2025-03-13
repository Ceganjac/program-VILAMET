package pogled.panelNB;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import pogled.GradientPanel;
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

import model.logika.Kalkulacija;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;

public class PanelNB extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUlazniCena;
	private JTextField txtUlazniMasa;
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

	public PanelNB() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(screenSirina - 300, screenVisina));

		JPanel pnlNB = new JPanel();
		pnlNB.setBackground(Color.WHITE);
		pnlNB.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		add(pnlNB);

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

		GroupLayout gl_pnlNB = new GroupLayout(pnlNB);
		gl_pnlNB.setHorizontalGroup(
			gl_pnlNB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNB.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_pnlNB.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNB.createSequentialGroup()
							.addComponent(lblNBDatum, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dtcNBDatum, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNBNaslov, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlNB.createSequentialGroup()
							.addComponent(lblNBProiz, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbNBProiz, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNB.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnNBSacuvaj, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
							.addComponent(pnlNBGlavni, GroupLayout.PREFERRED_SIZE, 1005, Short.MAX_VALUE)))
					.addGap(111))
		);
		gl_pnlNB.setVerticalGroup(
			gl_pnlNB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNB.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNBNaslov, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlNB.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNBProiz, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbNBProiz, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlNB.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNBDatum, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(dtcNBDatum, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(pnlNBGlavni, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNBSacuvaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(151, Short.MAX_VALUE))
		);

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

		GroupLayout gl_pnlNBIzlazni = new GroupLayout(pnlNBIzlazni);
		gl_pnlNBIzlazni.setHorizontalGroup(gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNBIzlazni.createSequentialGroup().addGap(8).addGroup(gl_pnlNBIzlazni
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNBIzlazni.createSequentialGroup().addGap(4)
								.addComponent(lblIzlazniTara, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE).addGap(18)
								.addComponent(txtIzlazniTara, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
								.addComponent(lblIzlazniNeto, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE).addGap(22)
								.addComponent(txtIzlazniNeto, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
								.addComponent(lblIzlazniIznos, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addGap(22)
								.addComponent(txtIzlazniIznos, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
						.addGap(60)));
		gl_pnlNBIzlazni.setVerticalGroup(gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlNBIzlazni
				.createSequentialGroup().addGap(28)
				.addGroup(gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
								.addComponent(lblIzlazniTara, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE).addGap(21))
						.addGroup(gl_pnlNBIzlazni.createSequentialGroup()
								.addComponent(txtIzlazniTara, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)))
				.addGroup(gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(txtIzlazniNeto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIzlazniNeto, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 26,
								Short.MAX_VALUE))
				.addGroup(gl_pnlNBIzlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNBIzlazni.createSequentialGroup().addGap(20)
								.addComponent(lblIzlazniIznos, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
								.addGap(73))
						.addGroup(gl_pnlNBIzlazni
								.createSequentialGroup().addGap(18).addComponent(txtIzlazniIznos,
										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		pnlNBIzlazni.setLayout(gl_pnlNBIzlazni);

		JPanel pnlNBUlazni = new JPanel();
		pnlNBUlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNBUlazni.setBackground(Color.WHITE);

		JRadioButton rdbUlazni05 = new JRadioButton("0.5 kg");
		rdbUlazni05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUlazniMasa.setEditable(false);
				txtUlazniUlaz.setEditable(true);
			}
		});
		buttonGroup.add(rdbUlazni05);
		rdbUlazni05.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbUlazni05.setBackground(Color.WHITE);

		JRadioButton rdbUlazniMasa = new JRadioButton("унеси масу амбалаже");
		rdbUlazniMasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUlazniMasa.setEditable(true);
				txtUlazniUlaz.setEditable(true);
			}
		});
		buttonGroup.add(rdbUlazniMasa);
		rdbUlazniMasa.setToolTipText("Izaberi");
		rdbUlazniMasa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbUlazniMasa.setBackground(Color.WHITE);

		JRadioButton rdbUlazni04 = new JRadioButton("0.4 kg");

		rdbUlazni04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbUlazni04.isSelected() == true) {
					txtUlazniMasa.setEditable(false);
					txtUlazniUlaz.setEditable(true);
				}
			}
		});
		buttonGroup.add(rdbUlazni04);
		rdbUlazni04.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbUlazni04.setBackground(Color.WHITE);

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

		JLabel lblUlazniMasa = new JLabel("Маса амбалаже (kg) :");
		lblUlazniMasa.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtUlazniMasa = new JTextField();
		txtUlazniMasa.setHorizontalAlignment(SwingConstants.CENTER);
		txtUlazniMasa.setEditable(false);
		txtUlazniMasa.setColumns(10);

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
		GroupLayout gl_pnlNBUlazni = new GroupLayout(pnlNBUlazni);
		gl_pnlNBUlazni.setHorizontalGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlNBUlazni
				.createSequentialGroup().addGap(54)
				.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNBUlazni.createSequentialGroup()
								.addComponent(lblUlazniTekst, GroupLayout.PREFERRED_SIZE, 284,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_pnlNBUlazni.createSequentialGroup()
								.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_pnlNBUlazni.createSequentialGroup()
												.addComponent(rdbUlazni05, GroupLayout.DEFAULT_SIZE, 82,
														Short.MAX_VALUE)
												.addGap(296))
										.addGroup(gl_pnlNBUlazni.createSequentialGroup()
												.addComponent(rdbUlazni04, GroupLayout.DEFAULT_SIZE, 70,
														Short.MAX_VALUE)
												.addGap(308))
										.addGroup(gl_pnlNBUlazni.createSequentialGroup()
												.addComponent(lblUlazniProizvod, GroupLayout.DEFAULT_SIZE, 82,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(cmbUlazniProizvod, GroupLayout.PREFERRED_SIZE, 286,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pnlNBUlazni.createSequentialGroup()
												.addComponent(lblUlazniCena, GroupLayout.DEFAULT_SIZE, 180,
														Short.MAX_VALUE)
												.addGap(18).addComponent(txtUlazniCena, GroupLayout.DEFAULT_SIZE, 180,
														Short.MAX_VALUE))
										.addGroup(gl_pnlNBUlazni.createSequentialGroup()
												.addComponent(lblUlazniMasa, GroupLayout.DEFAULT_SIZE, 180,
														Short.MAX_VALUE)
												.addGap(18).addComponent(txtUlazniMasa, GroupLayout.DEFAULT_SIZE, 180,
														Short.MAX_VALUE))
										.addComponent(rdbUlazniMasa, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 170,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_pnlNBUlazni.createSequentialGroup()
												.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_pnlNBUlazni.createSequentialGroup()
																.addComponent(lblUlazniBruto, GroupLayout.DEFAULT_SIZE,
																		180, Short.MAX_VALUE)
																.addGap(18))
														.addGroup(gl_pnlNBUlazni.createSequentialGroup()
																.addComponent(lblUlazniUlaz, GroupLayout.PREFERRED_SIZE,
																		163, GroupLayout.PREFERRED_SIZE)
																.addGap(35)))
												.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
														.addComponent(txtUlazniUlaz, GroupLayout.DEFAULT_SIZE, 180,
																Short.MAX_VALUE)
														.addComponent(txtUlazniBruto, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
								.addGap(68)))));
		gl_pnlNBUlazni.setVerticalGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlNBUlazni
				.createSequentialGroup().addContainerGap().addComponent(lblUlazniTekst).addGap(9)
				.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUlazniProizvod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbUlazniProizvod, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(rdbUlazni04, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(rdbUlazni05, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(rdbUlazniMasa, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUlazniMasa, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUlazniMasa, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNBUlazni.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblUlazniUlaz, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNBUlazni.createSequentialGroup().addGap(13).addComponent(txtUlazniUlaz,
								GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUlazniBruto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniBruto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(7)
				.addGroup(gl_pnlNBUlazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUlazniCena, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUlazniCena, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(130)));
		pnlNBUlazni.setLayout(gl_pnlNBUlazni);

		JButton btnNBIzracunaj = new JButton("ИЗРАЧУНАЈ");
		btnNBIzracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				///////////////////////////////////////////////////////////////////////////////////////////////////

				// OBRADA IZRAČUNAJ

				// validacija radio dugmića

				if (rdbUlazni04.isSelected() == false & rdbUlazni05.isSelected() == false
						& rdbUlazniMasa.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Не можете израчунати параметре, маса гајбица није изабрана !",
							"Грешка ", JOptionPane.ERROR_MESSAGE);
				}

				// validacija bruta, cene i polja za ulaz za radio04 i radio05

				if (rdbUlazni04.isSelected()) {
					if (txtUlazniUlaz.getText().equals("") || txtUlazniBruto.getText().equals("")
							|| txtUlazniCena.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Нисте унели све податке !", "Грешка ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				if (rdbUlazni05.isSelected()) {
					if (txtUlazniUlaz.getText().equals("") || txtUlazniBruto.getText().equals("")
							|| txtUlazniCena.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Нисте унели све податке !", "Грешка ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				if (rdbUlazniMasa.isSelected() == true) {
					if (txtUlazniMasa.getText().equals("") || txtUlazniUlaz.getText().equals("")
							|| txtUlazniBruto.getText().equals("") || txtUlazniCena.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Нисте унели све податке !", "Грешка ",
								JOptionPane.ERROR_MESSAGE);
						return;

					}

				}

				// deklaracija promenljivih
				int ulaz;
				float bruto;
				float cena;
				float masa;

				float tara;
				float neto;
				float iznos;

				// pravljenje formatera za numeričke vrednosti
				DecimalFormatSymbols simboli = new DecimalFormatSymbols(Locale.getDefault());
				simboli.setDecimalSeparator('.');
				simboli.setGroupingSeparator(',');
				DecimalFormat df = new DecimalFormat("#,###.00", simboli);

				// inicijalizacija promenljivih

				bruto = Float.valueOf(txtUlazniBruto.getText());
				cena = Float.valueOf(txtUlazniCena.getText());
				ulaz = Integer.valueOf(txtUlazniUlaz.getText());

				Kalkulacija k = new Kalkulacija();

				//////////////////////////////////////////////////////////////////////////////////////////////////////
				// AKO JE MASA AMBALAŽE 0.4

				if (rdbUlazni04.isSelected() == true) {
					masa = (float) 0.4;
					k.kalkulacija(ulaz, masa, bruto, cena);

					tara = k.getTara();
					neto = k.getNeto();
					iznos = k.getIznos();

					txtIzlazniTara.setText("" + df.format(tara));
					txtIzlazniNeto.setText("" + df.format(neto));
					txtIzlazniIznos.setText("" + df.format(iznos));

				}

				//////////////////////////////////////////////////////////////////////////////////////////////////////
				// AKO JE MASA AMBALAŽE 0.5

				if (rdbUlazni05.isSelected() == true) {
					masa = (float) 0.5;
					k.kalkulacija(ulaz, masa, bruto, cena);

					tara = k.getTara();
					neto = k.getNeto();
					iznos = k.getIznos();

					txtIzlazniTara.setText("" + df.format(tara));
					txtIzlazniNeto.setText("" + df.format(neto));
					txtIzlazniIznos.setText("" + df.format(iznos));

				}

				//////////////////////////////////////////////////////////////////////////////////////////////////////
				// AKO MASU AMBALAŽE UNOSI KORISNIK

				if (rdbUlazniMasa.isSelected() == true) {
					masa = Float.valueOf(txtUlazniMasa.getText());
					k.kalkulacija(ulaz, masa, bruto, cena);

					tara = k.getTara();
					neto = k.getNeto();
					iznos = k.getIznos();

					txtIzlazniTara.setText("" + df.format(tara));
					txtIzlazniNeto.setText("" + df.format(neto));
					txtIzlazniIznos.setText("" + df.format(iznos));

					;
				}

			}

			///////////////////////////////////////////////////////////////////////////////////////////////////

		});
		btnNBIzracunaj.setForeground(Color.BLACK);
		btnNBIzracunaj.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNBIzracunaj.setFocusable(false);
		btnNBIzracunaj.setBackground(new Color(153, 255, 153));

		JButton btnUlazniIzbrisi = new JButton("ИЗБРИШИ");
		btnUlazniIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ulazni
				txtUlazniMasa.setText("");
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
		GroupLayout gl_pnlNBGlavni = new GroupLayout(pnlNBGlavni);
		gl_pnlNBGlavni.setHorizontalGroup(
			gl_pnlNBGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlNBGlavni.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_pnlNBGlavni.createParallelGroup(Alignment.TRAILING)
						.addComponent(jspNBscroll, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
						.addGroup(gl_pnlNBGlavni.createSequentialGroup()
							.addComponent(pnlNBUlazni, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
							.addGap(45)
							.addGroup(gl_pnlNBGlavni.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnUlazniDodaj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnUlazniIzbrisi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNBIzracunaj, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlNBIzlazni, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(54))
		);
		gl_pnlNBGlavni.setVerticalGroup(
			gl_pnlNBGlavni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNBGlavni.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_pnlNBGlavni.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlNBGlavni.createSequentialGroup()
							.addComponent(pnlNBIzlazni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNBIzracunaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnUlazniIzbrisi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUlazniDodaj, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlNBUlazni, 0, 0, Short.MAX_VALUE))
					.addGap(26)
					.addComponent(jspNBscroll, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		pnlNBGlavni.setLayout(gl_pnlNBGlavni);

		
		pnlNB.setLayout(gl_pnlNB);

	}
}
