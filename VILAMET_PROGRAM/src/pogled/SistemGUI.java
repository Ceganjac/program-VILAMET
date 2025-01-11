
package pogled;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import baza.BazaBranja;
import baza.BazaProizvod;
import baza.BazaProizvodjaci;
import baza.KonektorBaze;
import logika.IDalgoritmi;
import logika.Kalkulacija;
import logika.ObradaCuvanja;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;

// PROVERA PROMENA

@SuppressWarnings("serial")
public class SistemGUI extends JFrame {

	private JPanel contentPane;
	/* private */ protected static JTable Tabela_branja;
	protected static JTextField textField_ulaz1;
	protected static JTextField textField_ulaz2;
	protected static JTextField textField_Bruto;
	protected static JTextField textField_Cena;
	protected static JTextField textField_Tara;
	protected static JTextField textField_Neto;
	protected static JTextField textField_Iznos;
	private ButtonGroup bg = new ButtonGroup();
	protected static JDateChooser datum;
	protected static JTable Tabela_proizvodjaci;
	private JTextField textField_ime_pr;
	private JTextField textField_prezime_pr;
	private JTextField textField_mesto_pr;
	private JTextField textField_ulica_pr;
	private JTextField textField_broj_pr;
	private JTextField textField_nazivProizvoda;
	/* private */ protected static JTable Tabela_proizvod;
	private JTextField textField_vrstaProizvoda;

	// PADAJUĆI MENIJI

	static JComboBox<String> padajuci_proizvodjaci = new JComboBox<String>();
	static JComboBox<String> padajuci_proizvod = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemGUI frame = new SistemGUI();

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SistemGUI() {
		setResizable(false);
		setTitle("ВИЛАМЕТ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SistemGUI.class.getResource("/slike/malina.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		setBounds(100, 100, 1250, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane TabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		TabbedPanel.setBounds(-11, -58, 1261, 679);
		contentPane.add(TabbedPanel);

		JPanel Pocetni_Panel = new JPanel();
		TabbedPanel.addTab("New tab", null, Pocetni_Panel, null);

		JPanel Panel_NB = new JPanel();
		Panel_NB.setBackground(Color.WHITE);
		TabbedPanel.addTab("New tab", null, Panel_NB, null);
		Panel_NB.setLayout(null);

		padajuci_proizvodjaci.setBackground(Color.WHITE);
		padajuci_proizvodjaci.setFont(new Font("Arial", Font.PLAIN, 12));
		padajuci_proizvodjaci.setBounds(488, 184, 174, 24);
		Panel_NB.add(padajuci_proizvodjaci);

		/////////////////////////////////////////////////////////////////////////////////////////////////
		// kako bi se proizvođači videli u padajcui_proizvodjaci
		String[] imena_proizvodjaca = new String[1000];

		try {
			imena_proizvodjaca = BazaProizvodjaci.prikaz_imena();

			for (int i = 0; i < imena_proizvodjaca.length; i++) {
				padajuci_proizvodjaci.addItem(imena_proizvodjaca[i]);
			}
		} catch (Exception g) {
			System.out.println("Greska prilikom citanja imena proizvodjaca iz baze u padajuci - SistemGUI");
			// System.out.println(g);
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////////////////////////////////
		// kako bi proizvodi bili vidljivi u ComboBox-u
		String[] proizvodi = new String[100];

		try {
			proizvodi = BazaProizvod.id_proizvod_baza();

			for (int i = 0; i < proizvodi.length; i++) {
				padajuci_proizvod.addItem(proizvodi[i]);
			}

		} catch (Exception g) {
			System.out.println("Greska prilikom citanja naziva proizvoda iz baze u padajuci - SistemGUI");
			// System.out.println(g);
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////

		JPanel Meni_Panel_NB = new GradientPanel();
		Meni_Panel_NB.setLayout(null);
		Meni_Panel_NB.setBackground(Color.WHITE);
		Meni_Panel_NB.setBounds(0, 33, 266, 619);
		Panel_NB.add(Meni_Panel_NB);

		JButton Dugme_pregled_branja = new JButton("Преглед брања");
		Dugme_pregled_branja.setForeground(Color.BLACK);
		Dugme_pregled_branja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_pregled_branja.setContentAreaFilled(true);
				Dugme_pregled_branja.setBackground(new Color(102, 255, 102));
			}

			public void mouseExited(MouseEvent e) {
				Dugme_pregled_branja.setContentAreaFilled(false);
			}

		});
		Dugme_pregled_branja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TabbedPanel.setSelectedIndex(2);

				/////////////////////////////////////////////////////////////////////////////////////////////////
				// CITANJE IZ BAZE U TABELU

				BazaBranja.citanje_baza();

				/////////////////////////////////////////////////////////////////////////////////////////////////

			}
		});
		Dugme_pregled_branja.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_pregled_branja.setBackground(Color.WHITE);
		Dugme_pregled_branja.setBounds(0, 130, 266, 39);
		Dugme_pregled_branja.setContentAreaFilled(false); // uklanjanje pozadine
		Dugme_pregled_branja.setBorderPainted(false); // uklanjanje ivica
		Dugme_pregled_branja.setFocusable(false); // uklanjanje fokusiranja
		ImageIcon ikonuca_pb = new ImageIcon(getClass().getResource("/slike/lista.png"));
		Dugme_pregled_branja.setHorizontalTextPosition(SwingConstants.RIGHT);
		Dugme_pregled_branja.setIconTextGap(20);

		Dugme_pregled_branja.setIcon(ikonuca_pb);

		Meni_Panel_NB.add(Dugme_pregled_branja);

		JButton Dugme_proizvodjaci = new JButton("Произвођачи");
		Dugme_proizvodjaci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_proizvodjaci.setContentAreaFilled(true);
				Dugme_proizvodjaci.setBackground(new Color(102, 255, 102));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				Dugme_proizvodjaci.setContentAreaFilled(false);

			}

		});
		Dugme_proizvodjaci.setForeground(Color.BLACK);
		Dugme_proizvodjaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabbedPanel.setSelectedIndex(3);

				BazaProizvodjaci.citanje_baza();
			}
		});
		Dugme_proizvodjaci.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_proizvodjaci.setBackground(Color.WHITE);
		Dugme_proizvodjaci.setBounds(0, 179, 266, 39);
		Dugme_proizvodjaci.setContentAreaFilled(false);
		Dugme_proizvodjaci.setBorderPainted(false);
		Dugme_proizvodjaci.setFocusable(false);
		ImageIcon ikonica_proizvodjaci = new ImageIcon(getClass().getResource("/slike/ljudi.png"));
		Dugme_proizvodjaci.setIcon(ikonica_proizvodjaci);
		Dugme_proizvodjaci.setIconTextGap(30);

		Meni_Panel_NB.add(Dugme_proizvodjaci);

		JButton Dugme_proizvod = new JButton("Производи");
		Dugme_proizvod.setIcon(new ImageIcon(SistemGUI.class.getResource("/slike/proizvod.png")));
		Dugme_proizvod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_proizvod.setContentAreaFilled(true);
				Dugme_proizvod.setBackground(new Color(102, 255, 102));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Dugme_proizvod.setContentAreaFilled(false);
			}
		});
		Dugme_proizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					BazaProizvod.citanje_baza();
				} catch (Exception greska) {
					System.out.println("Greska prilikom citanja proizvoda iz baze u tabelu - SistemGUI");
				}

				TabbedPanel.setSelectedIndex(4);
			}
		});
		Dugme_proizvod.setForeground(Color.BLACK);
		Dugme_proizvod.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_proizvod.setContentAreaFilled(false);
		Dugme_proizvod.setBorderPainted(false);
		Dugme_proizvod.setFocusable(false);
		Dugme_proizvod.setBounds(0, 228, 266, 39);
		Dugme_proizvod.setIconTextGap(50);

		Meni_Panel_NB.add(Dugme_proizvod);

		JLabel Label_Naslov_NB = new JLabel("Ново Брање");
		Label_Naslov_NB.setFont(new Font("Arial", Font.PLAIN, 24));
		Label_Naslov_NB.setBounds(332, 50, 209, 45);
		Panel_NB.add(Label_Naslov_NB);

		JLabel Label_Tekst_NB = new JLabel("Унесите параметре брања са леве стране");
		Label_Tekst_NB.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_Tekst_NB.setBounds(382, 105, 329, 28);
		Panel_NB.add(Label_Tekst_NB);

		JPanel Panel_Ulazni = new JPanel();
		Panel_Ulazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Ulazni.setBackground(Color.WHITE);
		Panel_Ulazni.setBounds(382, 231, 400, 315);
		Panel_NB.add(Panel_Ulazni);
		Panel_Ulazni.setLayout(null);

		JRadioButton Radio_1 = new JRadioButton("0.4 kg");
		JRadioButton Radio_2 = new JRadioButton("0.5 kg");
		JRadioButton Radio_3 = new JRadioButton("0.4 и 0.5 kg");

		Radio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Radio_1.isSelected() == true) {
					textField_ulaz1.setEditable(true);
					textField_ulaz2.setEditable(false);

				}

			}
		});
		Radio_1.setBackground(Color.WHITE);
		Radio_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Radio_1.setBounds(22, 59, 103, 21);
		Panel_Ulazni.add(Radio_1);

		Radio_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Radio_2.isSelected() == true) {
					textField_ulaz1.setEditable(false);
					textField_ulaz2.setEditable(true);
				}

			}
		});
		Radio_2.setBackground(Color.WHITE);
		Radio_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Radio_2.setBounds(127, 59, 103, 21);
		Panel_Ulazni.add(Radio_2);

		Radio_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Radio_3.isSelected() == true) {
					textField_ulaz1.setEditable(true);
					textField_ulaz2.setEditable(true);
				}

			}
		});
		Radio_3.setBackground(Color.WHITE);
		Radio_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Radio_3.setToolTipText("Izaberi");
		Radio_3.setBounds(225, 59, 103, 21);
		Panel_Ulazni.add(Radio_3);

		bg.add(Radio_1);
		bg.add(Radio_2);
		bg.add(Radio_3);

		JLabel Label_ = new JLabel("Број гајбица од 0.4 kg :");
		Label_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_.setBounds(22, 110, 163, 24);
		Panel_Ulazni.add(Label_);

		JLabel Label_Ulaz_1_1_2 = new JLabel("Број гајбица од 0.5 kg :");
		Label_Ulaz_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_Ulaz_1_1_2.setBounds(22, 147, 163, 24);
		Panel_Ulazni.add(Label_Ulaz_1_1_2);

		textField_ulaz1 = new JTextField();
		textField_ulaz1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		textField_ulaz1.setEditable(false);
		textField_ulaz1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_ulaz1.setColumns(10);
		textField_ulaz1.setBounds(202, 113, 103, 24);
		Panel_Ulazni.add(textField_ulaz1);

		textField_ulaz2 = new JTextField();
		textField_ulaz2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		textField_ulaz2.setEditable(false);
		textField_ulaz2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_ulaz2.setColumns(10);
		textField_ulaz2.setBounds(202, 147, 103, 24);

		Panel_Ulazni.add(textField_ulaz2);

		JLabel Label_Bruto = new JLabel("Бруто  :");
		Label_Bruto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_Bruto.setBounds(22, 196, 61, 24);
		Panel_Ulazni.add(Label_Bruto);

		JLabel Label_Cena = new JLabel("Цена  :");
		Label_Cena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_Cena.setBounds(22, 230, 61, 24);
		Panel_Ulazni.add(Label_Cena);

		textField_Bruto = new JTextField();
		textField_Bruto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '.') {
					e.consume();
				}
			}
		});
		textField_Bruto.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Bruto.setColumns(10);
		textField_Bruto.setBounds(118, 199, 103, 24);
		Panel_Ulazni.add(textField_Bruto);

		textField_Cena = new JTextField();
		textField_Cena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '.') {
					e.consume();
				}
			}
		});
		textField_Cena.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Cena.setColumns(10);
		textField_Cena.setBounds(118, 233, 103, 24);
		Panel_Ulazni.add(textField_Cena);

		JLabel Label_proizvod = new JLabel("Производ :");
		Label_proizvod.setBounds(10, 10, 118, 24);
		Panel_Ulazni.add(Label_proizvod);
		Label_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		padajuci_proizvod.setBounds(107, 11, 174, 24);
		Panel_Ulazni.add(padajuci_proizvod);

		padajuci_proizvod.setBackground(Color.WHITE);
		padajuci_proizvod.setFont(new Font("Arial", Font.PLAIN, 12));

		JPanel Panel_Izlazni = new JPanel();
		Panel_Izlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Izlazni.setBackground(Color.WHITE);
		Panel_Izlazni.setBounds(877, 231, 276, 218);
		Panel_NB.add(Panel_Izlazni);
		Panel_Izlazni.setLayout(null);

		JLabel Label_Tara = new JLabel("Тара :");
		Label_Tara.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Tara.setBounds(10, 24, 100, 24);
		Label_Tara.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Panel_Izlazni.add(Label_Tara);

		JLabel Label_Neto = new JLabel("Нето :");
		Label_Neto.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Neto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_Neto.setBounds(10, 72, 100, 24);
		Panel_Izlazni.add(Label_Neto);

		JLabel Label_Iznos = new JLabel("Износ брања :");
		Label_Iznos.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Iznos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_Iznos.setBounds(10, 116, 100, 24);
		Panel_Izlazni.add(Label_Iznos);

		textField_Tara = new JTextField();
		textField_Tara.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Tara.setEditable(false);
		textField_Tara.setColumns(10);
		textField_Tara.setBounds(132, 27, 103, 24);
		Panel_Izlazni.add(textField_Tara);

		textField_Neto = new JTextField();
		textField_Neto.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Neto.setEditable(false);
		textField_Neto.setColumns(10);
		textField_Neto.setBounds(132, 75, 103, 24);
		Panel_Izlazni.add(textField_Neto);

		textField_Iznos = new JTextField();
		textField_Iznos.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Iznos.setEditable(false);
		textField_Iznos.setColumns(10);
		textField_Iznos.setBounds(132, 121, 103, 24);
		Panel_Izlazni.add(textField_Iznos);

		JButton Dugme_Izracunaj = new JButton("ИЗРАЧУНАЈ");
		Dugme_Izracunaj.setFocusable(false);
		Dugme_Izracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////////////////////////////////////////////////////////////////////////////

				// OBRADA IZRAČUNAJ

				// validacija radio dugmića

				if (Radio_1.isSelected() == false & Radio_2.isSelected() == false & Radio_3.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Не можете израчунати параметре, маса гајбица није изабрана !",
							"Грешка ", JOptionPane.ERROR_MESSAGE);
				}

				// validacija ostalih polja

				if (Radio_1.isSelected() == true || Radio_2.isSelected() == true) {
					if (textField_Bruto.getText().equals("") || textField_Cena.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Нисте унели све податке !", "Грешка ",
								JOptionPane.ERROR_MESSAGE);

					}

				}

				if (Radio_3.isSelected() == true) {
					if (textField_ulaz1.getText().equals("") || textField_ulaz2.getText().equals("")
							|| textField_Bruto.getText().equals("") || textField_Cena.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Нисте унели све податке !", "Грешка ",
								JOptionPane.ERROR_MESSAGE);

					}

				}

				// deklaracija promenljivih
				int ulaz;
				double bruto;
				double cena;
				int ulaz_1;
				int ulaz_2;

				double tara;
				double neto;
				double iznos;

				// pravljenje formatera za numeričke vrednosti
				DecimalFormatSymbols simboli = new DecimalFormatSymbols(Locale.getDefault());
				simboli.setDecimalSeparator('.');
				simboli.setGroupingSeparator(',');
				DecimalFormat df = new DecimalFormat("#,###.00", simboli);

				// inicijalizacija promenljivih

				bruto = Double.valueOf(textField_Bruto.getText());

				cena = Double.valueOf(textField_Cena.getText());

				Kalkulacija k = new Kalkulacija();

				if (Radio_1.isSelected() == true) {
					ulaz = Integer.valueOf(textField_ulaz1.getText());
					k.kalkulacija1(ulaz, bruto, cena);

					tara = k.getTara();
					neto = k.getNeto();
					iznos = k.getIznos();

					textField_Tara.setText("" + df.format(tara));
					textField_Neto.setText("" + df.format(neto));
					textField_Iznos.setText("" + df.format(iznos));

				}

				if (Radio_2.isSelected() == true) {
					ulaz = Integer.valueOf(textField_ulaz2.getText());
					k.kalkulacija2(ulaz, bruto, cena);

					tara = k.getTara();
					neto = k.getNeto();
					iznos = k.getIznos();

					textField_Tara.setText("" + df.format(tara));
					textField_Neto.setText("" + df.format(neto));
					textField_Iznos.setText("" + df.format(iznos));

				}

				if (Radio_3.isSelected() == true) {
					ulaz_1 = Integer.valueOf(textField_ulaz1.getText());
					ulaz_2 = Integer.valueOf(textField_ulaz2.getText());
					k.kalkulacija3(ulaz_1, ulaz_2, bruto, cena);

					tara = k.getTara();
					neto = k.getNeto();
					iznos = k.getIznos();

					textField_Tara.setText("" + df.format(tara));
					textField_Neto.setText("" + df.format(neto));
					textField_Iznos.setText("" + df.format(iznos));

				}

			}

			//////////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////////////

		});
		Dugme_Izracunaj.setBackground(new Color(153, 255, 153));
		Dugme_Izracunaj.setForeground(new Color(0, 0, 0));
		Dugme_Izracunaj.setFont(new Font("Arial", Font.PLAIN, 12));
		Dugme_Izracunaj.setBounds(968, 469, 185, 36);
		Panel_NB.add(Dugme_Izracunaj);

		JButton Dugme_Sacuvaj = new JButton("САЧУВАЈ");
		Dugme_Sacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				// OBRADA ČUVANJA

				// provera radio dugmića
				if (Radio_1.isSelected() == false && Radio_2.isSelected() == false && Radio_3.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Не можете сачувати брање, маса гајбица није изабрана !",
							"Грешка ", JOptionPane.ERROR_MESSAGE);
					return;

				}
				if (datum.getDate() == null || datum.getDateFormatString() == null
						|| datum.getDateFormatString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Не можете сачувати брање, датум није изабран!", "Грешка",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// uzimanje vrednosti

				LocalDate datumK = datum.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
				System.out.println(datumK);

				/*
				 * DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				 * String formatiran_datum = datumK.format(formater);
				 */

				String bruto = textField_Bruto.getText();
				String tara = textField_Tara.getText();
				String neto = textField_Neto.getText();
				String cena = textField_Cena.getText();
				String iznos = textField_Iznos.getText();

				// uzimanje id-a proizvodjaca - šaljemo vrednost padajuci_proizvodjaci u
				// ObradaCuvanja

				// uzimanje id-a proizvoda - šaljemo vrednost padajuci_proizvod u ObradaCuvanja

				int radio;

				// AKO JE SELEKTOVAN Radio_1

				if (Radio_1.isSelected() == true) {

					radio = 1;
					String ulaz1 = textField_ulaz1.getText();
					String ulaz2 = "0";
					try {
						ObradaCuvanja.obrada_cuvanja(radio, datumK, ulaz1, ulaz2, bruto, tara, neto, cena, iznos,
								padajuci_proizvodjaci, padajuci_proizvod);

					} catch (Exception greska) {
						/*
						 * JOptionPane.showMessageDialog(null, "Грешка приликом чувања података !",
						 * "Грешка ", JOptionPane.ERROR_MESSAGE);
						 * 
						 * greska.printStackTrace();
						 */

					}
				}

				// AKO JE SELEKTOVAN Radio_2

				if (Radio_2.isSelected() == true) {

					radio = 2;
					String ulaz2 = textField_ulaz2.getText();
					String ulaz1 = "0";

					try {
						ObradaCuvanja.obrada_cuvanja(radio, datumK, ulaz1, ulaz2, bruto, tara, neto, cena, iznos,
								padajuci_proizvodjaci, padajuci_proizvod);

					} catch (Exception greska) {
						/*
						 * JOptionPane.showMessageDialog(null, "Грешка приликом чувања података !",
						 * "Грешка ", JOptionPane.ERROR_MESSAGE); greska.printStackTrace();
						 */
					}

				}

				// AKO JE SELEKTOVAN Radio_3

				if (Radio_3.isSelected() == true) {

					radio = 3;
					String ulaz1 = textField_ulaz1.getText();
					String ulaz2 = textField_ulaz2.getText();

					try {
						ObradaCuvanja.obrada_cuvanja(radio, datumK, ulaz1, ulaz2, bruto, tara, neto, cena, iznos,
								padajuci_proizvodjaci, padajuci_proizvod);

					} catch (Exception greska) {
						/*
						 * JOptionPane.showMessageDialog(null, "Грешка приликом чувања података !",
						 * "Грешка ", JOptionPane.ERROR_MESSAGE); greska.printStackTrace();
						 */
					}

				}
			}
		});

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Dugme_Sacuvaj.setForeground(Color.BLACK);
		Dugme_Sacuvaj.setFont(new Font("Arial", Font.PLAIN, 12));
		Dugme_Sacuvaj.setBackground(new Color(0, 194, 0));
		Dugme_Sacuvaj.setBounds(968, 515, 185, 36);
		Dugme_Sacuvaj.setFocusable(false);
		Panel_NB.add(Dugme_Sacuvaj);

		JButton Dugme_Izbrisi = new JButton("ИЗБРИШИ");
		Dugme_Izbrisi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// datum.setDate(null);
				textField_ulaz1.setText(null);
				textField_ulaz2.setText(null);
				textField_Bruto.setText(null);
				textField_Cena.setText(null);
				textField_Tara.setText(null);
				textField_Neto.setText(null);
				textField_Iznos.setText(null);

			}
		});
		Dugme_Izbrisi.setForeground(Color.RED);
		Dugme_Izbrisi.setFont(new Font("Arial", Font.BOLD, 12));
		Dugme_Izbrisi.setBackground(Color.WHITE);
		Dugme_Izbrisi.setBounds(968, 561, 185, 36);
		Dugme_Izbrisi.setFocusable(false);
		Panel_NB.add(Dugme_Izbrisi);

		JLabel Label_proizvodjac = new JLabel("Произвођач :");
		Label_proizvodjac.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_proizvodjac.setBounds(382, 183, 118, 24);
		Panel_NB.add(Label_proizvodjac);

		JLabel Label_Datum = new JLabel("Датум :");
		Label_Datum.setBounds(382, 153, 61, 24);
		Panel_NB.add(Label_Datum);
		Label_Datum.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// KREIRANJE Date Chooser-a

		datum = new JDateChooser();
		datum.setBounds(488, 153, 174, 24);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////

		// PRILAGOĐAVANJE IZGLEDA KALENDARA

		datum.setBackground(Color.WHITE);
		datum.getCalendarButton().setBackground(Color.WHITE);
		

		// Dobijanje JCalendar objekta iz JDateChooser
		JCalendar calendar = datum.getJCalendar();
		JPanel dayPanel = calendar.getDayChooser().getDayPanel();
	
		// Promena boje svih dugmadi (datuma)
		for (int i = 0; i < dayPanel.getComponentCount(); i++) {
			Component comp = dayPanel.getComponent(i);

			if (comp instanceof JButton) {
				JButton button = (JButton) comp;
				button.setBackground(Color.WHITE); // Pozadina za sve datume
				button.setForeground(Color.BLUE); // Tekst za sve datume
			}
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////////////

		Panel_NB.add(datum);

		JPanel Panel_Branja = new JPanel();
		Panel_Branja.setBackground(Color.WHITE);
		TabbedPanel.addTab("New tab", null, Panel_Branja, null);
		Panel_Branja.setLayout(null);

		JScrollPane scrollPanel1 = new JScrollPane();
		scrollPanel1.setBounds(29, 156, 1181, 328);
		Panel_Branja.add(scrollPanel1);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// TABELA BRANJA

		Tabela_branja = new JTable();
		Tabela_branja.setShowVerticalLines(false);
		Tabela_branja.setFont(new Font("Arial", Font.PLAIN, 12));
		Tabela_branja.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPanel1.setViewportView(Tabela_branja);

		// Kreiraj prilagođeni DefaultTableModel

		DefaultTableModel model_tabele_branje = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Sve ćelije nisu editabilne
				return false;
			}
		};

		String[] kolone = { "Идентф. број", "Датум", "Улаз 0.4", "Улаз 0.5", "Бруто", "Тара", "Нето", "Цена", "Износ",
				"Производ", "ИД произвођача", "Произвођач" };

		model_tabele_branje.setColumnIdentifiers(kolone);

		// Poveži model sa JTable
		Tabela_branja.setModel(model_tabele_branje);

		// Kreiranje renderer-a za centriranje teksta - KORISTI SE ZA SVE TABELE

		DefaultTableCellRenderer centar_render = new DefaultTableCellRenderer();
		centar_render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		// Postavljanje renderer-a za sve kolone
		for (int i = 0; i < Tabela_branja.getColumnCount(); i++) {
			Tabela_branja.getColumnModel().getColumn(i).setCellRenderer(centar_render);
		}

		Tabela_branja.setBackground(Color.WHITE);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel Label_Naslov_TB = new JLabel("Преглед сачуваних брања");
		Label_Naslov_TB.setFont(new Font("Arial", Font.PLAIN, 20));
		Label_Naslov_TB.setHorizontalAlignment(SwingConstants.LEFT);
		Label_Naslov_TB.setBounds(29, 73, 349, 34);
		Panel_Branja.add(Label_Naslov_TB);

		JButton Dugme_Nazad = new JButton("Назад");
		Dugme_Nazad.setBounds(30, 510, 184, 39);
		Panel_Branja.add(Dugme_Nazad);
		Dugme_Nazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TabbedPanel.setSelectedIndex(1);
				model_tabele_branje.setRowCount(0);
			}
		});
		Dugme_Nazad.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_Nazad.setBackground(new Color(153, 255, 153));

		JButton Dugme_izbrisi_branje = new JButton("Избриши селектовано брање");
		Dugme_izbrisi_branje.setForeground(Color.RED);
		Dugme_izbrisi_branje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// BRISANJE BRANJA
				////////////////////////////////////////////////////////////////////////////////////////////////////

				// provera da li je tabela prazna
				if (Tabela_branja.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Не можете обрисати брање, табела је празна !", "Грешка",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// provera da li je branje selektovano
				if (Tabela_branja.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Неуспешно брисање, брање није селектовано !", "Грешка",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// ako tabela nije prazna
				if (Tabela_branja.getSelectedRowCount() != 0) {

					int izbor = JOptionPane.showConfirmDialog(null, "Да ли желите да обришете селектовано брање ?",
							"Потврда", JOptionPane.YES_NO_OPTION);

					if (izbor == JOptionPane.YES_OPTION) {
						int selektovani_red = Tabela_branja.getSelectedRow();
						int kolona = 0;

						String id_branja = "" + Tabela_branja.getValueAt(selektovani_red, kolona);

						System.out.println("" + id_branja);

						// pozivanje metode za brisanje
						BazaBranja.brisanje_reda_branje(id_branja);

						model_tabele_branje.removeRow(Tabela_branja.getSelectedRow());
					}

				}

			}

		});

		////////////////////////////////////////////////////////////////////////////////////////////////////

		Dugme_izbrisi_branje.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_branje.setBounds(235, 510, 236, 39);
		Panel_Branja.add(Dugme_izbrisi_branje);
		Pocetni_Panel.setLayout(null);
		Dugme_izbrisi_branje.setBackground(Color.WHITE);

		JButton Dugme_Pocetak = new JButton("ПОЧЕТАК");
		Dugme_Pocetak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_Pocetak.setForeground(Color.black);
				Dugme_Pocetak.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Dugme_Pocetak.setForeground(Color.WHITE);
				Dugme_Pocetak.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

			}
		});
		Dugme_Pocetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabbedPanel.setSelectedIndex(1);
			}
		});
		Dugme_Pocetak.setForeground(Color.WHITE);
		Dugme_Pocetak.setContentAreaFilled(false);
		Dugme_Pocetak.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // postavljanje linije
		Dugme_Pocetak.setFont(new Font("Arial", Font.BOLD, 12));
		Dugme_Pocetak.setBounds(547, 366, 150, 40);
		Dugme_Pocetak.setFocusable(false);
		Pocetni_Panel.add(Dugme_Pocetak);

		JLabel Pozdrav = new JLabel("Добро дошли !");
		Pozdrav.setForeground(Color.WHITE);
		Pozdrav.setHorizontalAlignment(SwingConstants.CENTER);
		Pozdrav.setFont(new Font("Arial", Font.ITALIC, 24));
		Pozdrav.setBounds(460, 298, 325, 56);
		Pocetni_Panel.add(Pozdrav);

		JLabel Labela_Pozadina = new JLabel("");
		Labela_Pozadina.setBounds(0, 5, 1246, 654);
		Labela_Pozadina.setIcon(new ImageIcon(SistemGUI.class.getResource("/slike/malina_pozadina.png")));
		Pocetni_Panel.add(Labela_Pozadina);

		// PADAJUĆI MENI

		String imena[] = new String[500];
		imena = BazaProizvodjaci.prikaz_imena();

		///////////////////////////////////////////////////////////////////////////////////////

		JPanel Panel_Proizvodjaci = new JPanel();
		Panel_Proizvodjaci.setBackground(Color.WHITE);
		TabbedPanel.addTab("New tab", null, Panel_Proizvodjaci, null);
		Panel_Proizvodjaci.setLayout(null);

		JScrollPane scrollPanel2 = new JScrollPane();
		scrollPanel2.setBounds(29, 129, 661, 301);
		Panel_Proizvodjaci.add(scrollPanel2);

		// TABELA PROIZVOĐAČA

		Tabela_proizvodjaci = new JTable();
		Tabela_proizvodjaci.setShowVerticalLines(false);
		Tabela_proizvodjaci.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPanel2.setViewportView(Tabela_proizvodjaci);

		DefaultTableModel model_tabele_proiz = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Sve ćelije nisu editabilne
				return false;
			}
		};

		String[] kolone_proiz = { "Идентф. број", "Име", "Презиме", "Место", "Улица", "Број", "Укупан износ" };
		Object[] red_proiz = new Object[0];

		// postavljanje identifikatora na model
		model_tabele_proiz.setColumnIdentifiers(kolone_proiz);

		// postavljanje modela tabeli
		Tabela_proizvodjaci.setModel(model_tabele_proiz);

		// Postavljanje renderer-a za sve kolone
		for (int i = 0; i < Tabela_proizvodjaci.getColumnCount(); i++) {
			Tabela_proizvodjaci.getColumnModel().getColumn(i).setCellRenderer(centar_render);
		}

		Tabela_proizvodjaci.setBackground(Color.WHITE);

		JLabel Label_Naslov_PP1 = new JLabel("Преглед унетих произвођача");
		Label_Naslov_PP1.setFont(new Font("Arial", Font.PLAIN, 18));
		Label_Naslov_PP1.setBounds(29, 73, 349, 34);
		Panel_Proizvodjaci.add(Label_Naslov_PP1);

		JButton Dugme_izbrisi_pr = new JButton("Избриши произвођача");
		Dugme_izbrisi_pr.setForeground(Color.RED);
		Dugme_izbrisi_pr.setBackground(Color.WHITE);
		Dugme_izbrisi_pr.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// BRISANJE PROIZVOĐAČA

				// provera da li je tabela prazna
				if (Tabela_proizvodjaci.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Не можете обрисати произвођача, табела је празна !", "Грешка",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// ukoliko ništa nije selektovano
				if (Tabela_proizvodjaci.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Неуспешно брисање, произвођач није селектован !", "Грешка",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// ako tabela nije prazna
				if (Tabela_proizvodjaci.getSelectedRowCount() != 0) {

					int izbor = JOptionPane.showConfirmDialog(null,
							"Да ли желите да обришете селектованог произвођача ?", "Потврда",
							JOptionPane.YES_NO_OPTION);

					if (izbor == JOptionPane.YES_OPTION) {
						int selektovani_red = Tabela_proizvodjaci.getSelectedRow();
						int kolona = 0;

						int id_proizvodjaca = Integer
								.parseInt("" + Tabela_proizvodjaci.getValueAt(selektovani_red, kolona));

						System.out.println("" + id_proizvodjaca);

						// pozivanje metode za brisanje
						BazaProizvodjaci.brisanje_proizvodjaca(id_proizvodjaca);

						model_tabele_proiz.removeRow(Tabela_proizvodjaci.getSelectedRow());

						// ažuriranje kombo menija
						padajuci_proizvodjaci.removeAllItems();
						String imena2[] = BazaProizvodjaci.prikaz_imena();
						for (String item : imena2) {
							padajuci_proizvodjaci.addItem(item);
						}

					}
				}
			}

		});
		Dugme_izbrisi_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_pr.setBounds(255, 487, 194, 39);
		Panel_Proizvodjaci.add(Dugme_izbrisi_pr);

		JButton Dugme_nazad_pr = new JButton("Назад");
		Dugme_nazad_pr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabbedPanel.setSelectedIndex(1);
				model_tabele_proiz.setRowCount(0);
			}
		});
		Dugme_nazad_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_nazad_pr.setBounds(29, 487, 194, 39);
		Dugme_nazad_pr.setBackground(new Color(153, 255, 153));
		Panel_Proizvodjaci.add(Dugme_nazad_pr);

		JPanel Panel_novi_pr = new JPanel();
		Panel_novi_pr.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Panel_novi_pr.setBackground(Color.WHITE);
		Panel_novi_pr.setBounds(723, 129, 479, 304);
		Panel_Proizvodjaci.add(Panel_novi_pr);
		Panel_novi_pr.setLayout(null);

		JLabel Label_Ime_pr = new JLabel("Име :");
		Label_Ime_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_Ime_pr.setBounds(30, 38, 70, 24);
		Panel_novi_pr.add(Label_Ime_pr);

		JLabel Label_Prezime_pr = new JLabel("Презиме :");
		Label_Prezime_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_Prezime_pr.setBounds(30, 72, 70, 24);
		Panel_novi_pr.add(Label_Prezime_pr);

		textField_ime_pr = new JTextField();
		textField_ime_pr.setToolTipText("");
		textField_ime_pr.setBounds(150, 42, 104, 24);
		Panel_novi_pr.add(textField_ime_pr);
		textField_ime_pr.setColumns(10);

		textField_prezime_pr = new JTextField();
		textField_prezime_pr.setColumns(10);
		textField_prezime_pr.setBounds(150, 74, 104, 24);
		Panel_novi_pr.add(textField_prezime_pr);

		JButton Dugme_dodaj_pr = new JButton("Додај");
		Dugme_dodaj_pr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// DODAVANJE NOVOG PROIZVOĐAČA

				// Obrada kako bi program mogao da se pokrene iako nije povezan sa bazom
				if (KonektorBaze.kreirenje_konekcije() == null) {

					JOptionPane.showMessageDialog(null, "Неуспешно додавање, нема конекције са базом података !",
							"Грешка", JOptionPane.ERROR_MESSAGE);
					return;

				}

				/////////////////////////////////////////////////////////////////////////////////////////////////////////////

				// kupljenje podataka
				String ime = textField_ime_pr.getText();
				String prezime = textField_prezime_pr.getText();
				String mesto = textField_mesto_pr.getText();
				String ulica = textField_ulica_pr.getText();
				String broj = textField_broj_pr.getText();

				// Obrada ulaznih podataka za proizvođača
				if (ime.equals("") || prezime.equals("") || mesto.equals("") || ulica.equals("")) {
					JOptionPane.showMessageDialog(null, "Неуспешно додавање, сви подаци осим броја су неопходни !",
							"Грешка", JOptionPane.ERROR_MESSAGE);
					return;

				}

				// upis u bazu
				BazaProizvodjaci.upis_baza(ime, prezime, mesto, ulica, broj);
				// trenutni upis u tabelu
				String red[] = { null, ime, prezime, mesto, ulica, "" + broj, null };
				model_tabele_proiz.addRow(red);

				String imena[] = BazaProizvodjaci.prikaz_imena();
				// ažuriranje kombo menija
				padajuci_proizvodjaci.removeAllItems();
				String imena1[] = BazaProizvodjaci.prikaz_imena();
				for (String item : imena) {
					padajuci_proizvodjaci.addItem(item);
				}

				/////////////////////////////////////////////////////////////////////////////////////////////////////////////

			}
		});
		Dugme_dodaj_pr.setBackground(new Color(0, 194, 0));
		Dugme_dodaj_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_dodaj_pr.setBounds(318, 230, 139, 39);
		Panel_novi_pr.add(Dugme_dodaj_pr);

		JLabel Label_Mesto_pr = new JLabel("Место / Град :");
		Label_Mesto_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_Mesto_pr.setBounds(30, 169, 94, 24);
		Panel_novi_pr.add(Label_Mesto_pr);

		JLabel Label_Ulica_pr = new JLabel("Улица :");
		Label_Ulica_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_Ulica_pr.setBounds(30, 203, 94, 24);
		Panel_novi_pr.add(Label_Ulica_pr);

		JLabel Label_Broj_pr = new JLabel("Број улице :");
		Label_Broj_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_Broj_pr.setBounds(30, 237, 94, 24);
		Panel_novi_pr.add(Label_Broj_pr);

		textField_mesto_pr = new JTextField();
		textField_mesto_pr.setColumns(10);
		textField_mesto_pr.setBounds(150, 171, 104, 24);
		Panel_novi_pr.add(textField_mesto_pr);

		textField_ulica_pr = new JTextField();
		textField_ulica_pr.setColumns(10);
		textField_ulica_pr.setBounds(150, 203, 104, 24);
		Panel_novi_pr.add(textField_ulica_pr);

		textField_broj_pr = new JTextField();
		textField_broj_pr.setColumns(10);
		textField_broj_pr.setBounds(150, 237, 104, 24);
		Panel_novi_pr.add(textField_broj_pr);

		JLabel label = new JLabel("Адреса произвођача :");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 128, 175, 31);
		Panel_novi_pr.add(label);

		JButton Dugme_izbrisi_pr1 = new JButton("Избриши");
		Dugme_izbrisi_pr1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_ime_pr.setText(null);
				textField_prezime_pr.setText(null);
				textField_mesto_pr.setText(null);
				textField_ulica_pr.setText(null);
				textField_broj_pr.setText(null);

			}
		});
		Dugme_izbrisi_pr1.setForeground(Color.RED);
		Dugme_izbrisi_pr1.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_pr1.setBackground(Color.WHITE);
		Dugme_izbrisi_pr1.setBounds(318, 172, 139, 39);
		Panel_novi_pr.add(Dugme_izbrisi_pr1);

		JLabel Label_Naslov_PP2 = new JLabel("Унесите новог произвођача");
		Label_Naslov_PP2.setFont(new Font("Arial", Font.PLAIN, 18));
		Label_Naslov_PP2.setBounds(723, 73, 349, 34);
		Panel_Proizvodjaci.add(Label_Naslov_PP2);

		JPanel Panel_Proizvod = new JPanel();
		Panel_Proizvod.setLayout(null);
		Panel_Proizvod.setBackground(Color.WHITE);
		TabbedPanel.addTab("New tab", null, Panel_Proizvod, null);

		JLabel Label_Naslov_PP1_1 = new JLabel("Преглед унетих производа");
		Label_Naslov_PP1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		Label_Naslov_PP1_1.setBounds(29, 73, 349, 34);
		Panel_Proizvod.add(Label_Naslov_PP1_1);

		JButton Dugme_izbrisi_proizvod = new JButton("Избриши производ\r\n");

		Dugme_izbrisi_proizvod.setForeground(Color.RED);
		Dugme_izbrisi_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_proizvod.setBackground(Color.WHITE);
		Dugme_izbrisi_proizvod.setBounds(255, 487, 194, 39);
		Panel_Proizvod.add(Dugme_izbrisi_proizvod);

		////////////////////////////////////////////////////////////////////////////////////////////////////

		JScrollPane scrollPane_proizvod = new JScrollPane();
		scrollPane_proizvod.setBounds(31, 129, 508, 304);
		Panel_Proizvod.add(scrollPane_proizvod);

		// TABELA PROIZVOD

		Tabela_proizvod = new JTable();
		Tabela_proizvod.setFont(new Font("Arial", Font.PLAIN, 12));
		Tabela_proizvod.setShowVerticalLines(false);
		Tabela_proizvod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_proizvod.setViewportView(Tabela_proizvod);

		// kreiranje modela
		DefaultTableModel model_tabele_proizvod = new DefaultTableModel() {

			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		String[] kolone_proizvod = { "ИД производа", "Производ" };

		model_tabele_proizvod.setColumnIdentifiers(kolone_proizvod);

		// povezivanje sa modelom
		Tabela_proizvod.setModel(model_tabele_proizvod);

		// Postavljanje renderer-a za sve kolone
		for (int i = 0; i < Tabela_proizvod.getColumnCount(); i++) {
			Tabela_proizvod.getColumnModel().getColumn(i).setCellRenderer(centar_render);
		}
		;

		////////////////////////////////////////////////////////////////////////////////////////////////////

		Dugme_izbrisi_proizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// BRISANJE PROIZVODA
				////////////////////////////////////////////////////////////////////////////////////////////////////

				// ukoliko je tabela prazna
				if (Tabela_proizvod.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Не можете обрисати производ, табела је празна !", "Грешка",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// ukoliko ništa nije selektovano
				if (Tabela_proizvod.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, " Неуспешно брисање, производ није селектован !", "Грешка",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (Tabela_proizvod.getRowCount() != 0) {

					int izbor = JOptionPane.showConfirmDialog(null, "Да ли желите да обришете селектовани производ ?",
							"Потврда", JOptionPane.YES_NO_OPTION);

					if (izbor == JOptionPane.YES_OPTION) {
						int selektovani_red = Tabela_proizvod.getSelectedRow();
						int kolona = 0;

						String id_proizvodjaca = "" + Tabela_proizvod.getValueAt(selektovani_red, kolona);

						// pozivanje metode za brisanje
						BazaProizvod.brisanje_proizvoda(id_proizvodjaca);

						// trenutno brisanje reda
						model_tabele_proizvod.removeRow(Tabela_proizvod.getSelectedRow());

					}
				}

			}

		});

		////////////////////////////////////////////////////////////////////////////////////////////////////

		JButton Dugme_nazad_proizvod = new JButton("Назад");
		Dugme_nazad_proizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model_tabele_proizvod.setRowCount(0);

				TabbedPanel.setSelectedIndex(1);
			}
		});
		Dugme_nazad_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_nazad_proizvod.setBackground(new Color(153, 255, 153));
		Dugme_nazad_proizvod.setBounds(29, 487, 194, 39);
		Panel_Proizvod.add(Dugme_nazad_proizvod);

		JPanel Panel_novi_pr_1 = new JPanel();
		Panel_novi_pr_1.setLayout(null);
		Panel_novi_pr_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Panel_novi_pr_1.setBackground(Color.WHITE);
		Panel_novi_pr_1.setBounds(608, 129, 565, 215);
		Panel_Proizvod.add(Panel_novi_pr_1);

		JLabel Label_nazivProizvoda = new JLabel("Назив производа :");
		Label_nazivProizvoda.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_nazivProizvoda.setBounds(30, 51, 124, 24);
		Panel_novi_pr_1.add(Label_nazivProizvoda);

		textField_nazivProizvoda = new JTextField();
		textField_nazivProizvoda.setToolTipText("");
		textField_nazivProizvoda.setColumns(10);
		textField_nazivProizvoda.setBounds(177, 53, 104, 24);
		Panel_novi_pr_1.add(textField_nazivProizvoda);

		JButton Dugme_dodaj_proiz = new JButton("Додај");
		Dugme_dodaj_proiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// DODAVANJE NOVOG PROIZVODA

				// ukoliko program nije povezan sa bazom
				if (KonektorBaze.kreirenje_konekcije() == null) {
					JOptionPane.showMessageDialog(null, "Неуспешно додавање, нема конекције са базом података !",
							"Грешка", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String naziv = textField_nazivProizvoda.getText();
				String vrsta = textField_vrstaProizvoda.getText();

				// validacija
				if (naziv.equals("") || vrsta.equals("")) {
					JOptionPane.showMessageDialog(null, "Не можете унети производ, подаци су непотпуни !", "Грешка ",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// upis u bazu
				BazaProizvod.upis_baza(naziv, vrsta);

				// trenutan upis u tabelu
				String[] red = { null, naziv + " - " + vrsta };
				model_tabele_proizvod.addRow(red);

				// ažuriranje kombo menija
				padajuci_proizvod.removeAllItems();
				String[] proizvodi = new String[100];
				proizvodi = BazaProizvod.id_proizvod_baza();
				for (int i = 0; i < proizvodi.length; i++) {
					padajuci_proizvod.addItem(proizvodi[i]);
				}

			}
		});
		Dugme_dodaj_proiz.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_dodaj_proiz.setBackground(new Color(0, 194, 0));
		Dugme_dodaj_proiz.setBounds(367, 89, 139, 39);
		Panel_novi_pr_1.add(Dugme_dodaj_proiz);

		JButton Dugme_izbrisi_proiz = new JButton("Избриши");
		Dugme_izbrisi_proiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Izbriši - brisanje polja prilikom unosa proizvoda
				textField_nazivProizvoda.setText(null);
				textField_vrstaProizvoda.setText(null);

			}
		});
		Dugme_izbrisi_proiz.setForeground(Color.RED);
		Dugme_izbrisi_proiz.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_proiz.setBackground(Color.WHITE);
		Dugme_izbrisi_proiz.setBounds(367, 44, 139, 39);
		Panel_novi_pr_1.add(Dugme_izbrisi_proiz);

		JLabel Label_vrstaProizvoda = new JLabel("Врста производа :");
		Label_vrstaProizvoda.setFont(new Font("Arial", Font.PLAIN, 14));
		Label_vrstaProizvoda.setBounds(30, 85, 124, 24);
		Panel_novi_pr_1.add(Label_vrstaProizvoda);

		textField_vrstaProizvoda = new JTextField();
		textField_vrstaProizvoda.setToolTipText("");
		textField_vrstaProizvoda.setColumns(10);
		textField_vrstaProizvoda.setBounds(177, 87, 104, 24);
		Panel_novi_pr_1.add(textField_vrstaProizvoda);

		JLabel Label_Naslov_PP2_1 = new JLabel("Унесите нови производ");
		Label_Naslov_PP2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		Label_Naslov_PP2_1.setBounds(617, 73, 349, 34);
		Panel_Proizvod.add(Label_Naslov_PP2_1);

	}
}
