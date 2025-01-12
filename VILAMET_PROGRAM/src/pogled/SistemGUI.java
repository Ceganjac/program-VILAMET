
package pogled;

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

import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
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
import javax.swing.GroupLayout.Alignment;

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
					//frame.setExtendedState(frame.MAXIMIZED_BOTH);

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
		setResizable(true);
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

		JTabbedPane TabbedPanel = new JTabbedPane(JTabbedPane.TOP);

		JPanel Pocetni_Panel = new JPanel();
		TabbedPanel.addTab("New tab", null, Pocetni_Panel, null);

		JPanel Panel_NB = new JPanel();
		Panel_NB.setBackground(Color.WHITE);
		TabbedPanel.addTab("New tab", null, Panel_NB, null);
		
		// Sakrivanje trake sa karticama
        /*TabbedPanel.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int runCount, int maxTabHeight) {
                return 0; // Postavlja visinu trake na 0
            }
        });*/

		padajuci_proizvodjaci.setBackground(Color.WHITE);
		padajuci_proizvodjaci.setFont(new Font("Arial", Font.PLAIN, 12));

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
		Meni_Panel_NB.setBackground(Color.WHITE);

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
		Dugme_pregled_branja.setContentAreaFilled(false); // uklanjanje pozadine
		Dugme_pregled_branja.setBorderPainted(false); // uklanjanje ivica
		Dugme_pregled_branja.setFocusable(false); // uklanjanje fokusiranja
		ImageIcon ikonuca_pb = new ImageIcon(getClass().getResource("/slike/lista.png"));
		Dugme_pregled_branja.setHorizontalTextPosition(SwingConstants.RIGHT);
		Dugme_pregled_branja.setIconTextGap(20);

		Dugme_pregled_branja.setIcon(ikonuca_pb);

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
		Dugme_proizvodjaci.setContentAreaFilled(false);
		Dugme_proizvodjaci.setBorderPainted(false);
		Dugme_proizvodjaci.setFocusable(false);
		ImageIcon ikonica_proizvodjaci = new ImageIcon(getClass().getResource("/slike/ljudi.png"));
		Dugme_proizvodjaci.setIcon(ikonica_proizvodjaci);
		Dugme_proizvodjaci.setIconTextGap(30);

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
		Dugme_proizvod.setIconTextGap(50);

		JLabel Label_Naslov_NB = new JLabel("Ново Брање");
		Label_Naslov_NB.setFont(new Font("Arial", Font.PLAIN, 24));

		JLabel Label_Tekst_NB = new JLabel("Унесите параметре брања са леве стране");
		Label_Tekst_NB.setFont(new Font("Arial", Font.PLAIN, 14));

		JPanel Panel_Ulazni = new JPanel();
		Panel_Ulazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Ulazni.setBackground(Color.WHITE);

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

		bg.add(Radio_1);
		bg.add(Radio_2);
		bg.add(Radio_3);

		JLabel Label_ = new JLabel("Број гајбица од 0.4 kg :");
		Label_.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel Label_Ulaz_1_1_2 = new JLabel("Број гајбица од 0.5 kg :");
		Label_Ulaz_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

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

		JLabel Label_Bruto = new JLabel("Бруто  :");
		Label_Bruto.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel Label_Cena = new JLabel("Цена  :");
		Label_Cena.setFont(new Font("Tahoma", Font.PLAIN, 14));

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

		JLabel Label_proizvod = new JLabel("Производ :");
		Label_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));

		padajuci_proizvod.setBackground(Color.WHITE);
		padajuci_proizvod.setFont(new Font("Arial", Font.PLAIN, 12));

		JPanel Panel_Izlazni = new JPanel();
		Panel_Izlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Izlazni.setBackground(Color.WHITE);

		JLabel Label_Tara = new JLabel("Тара :");
		Label_Tara.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Tara.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel Label_Neto = new JLabel("Нето :");
		Label_Neto.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Neto.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel Label_Iznos = new JLabel("Износ брања :");
		Label_Iznos.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Iznos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField_Tara = new JTextField();
		textField_Tara.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Tara.setEditable(false);
		textField_Tara.setColumns(10);

		textField_Neto = new JTextField();
		textField_Neto.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Neto.setEditable(false);
		textField_Neto.setColumns(10);

		textField_Iznos = new JTextField();
		textField_Iznos.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Iznos.setEditable(false);
		textField_Iznos.setColumns(10);

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
		Dugme_Sacuvaj.setFocusable(false);

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
		Dugme_Izbrisi.setFocusable(false);

		JLabel Label_proizvodjac = new JLabel("Произвођач :");
		Label_proizvodjac.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel Label_Datum = new JLabel("Датум :");
		Label_Datum.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// KREIRANJE Date Chooser-a

		datum = new JDateChooser();

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
		GroupLayout gl_Panel_NB = new GroupLayout(Panel_NB);
		gl_Panel_NB.setHorizontalGroup(
			gl_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_NB.createSequentialGroup()
					.addComponent(Meni_Panel_NB, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Naslov_NB, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addGap(50)
							.addComponent(Label_Tekst_NB, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addGap(50)
							.addComponent(Label_Datum, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(datum, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_proizvodjac, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Panel_NB.createSequentialGroup()
									.addGap(106)
									.addComponent(padajuci_proizvodjaci, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addGap(50)
							.addComponent(Panel_Ulazni, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
							.addGap(95)
							.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
								.addComponent(Panel_Izlazni, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Panel_NB.createSequentialGroup()
									.addGap(91)
									.addComponent(Dugme_Izracunaj, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel_NB.createSequentialGroup()
									.addGap(91)
									.addComponent(Dugme_Sacuvaj, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel_NB.createSequentialGroup()
									.addGap(91)
									.addComponent(Dugme_Izbrisi, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))))))
		);
		gl_Panel_NB.setVerticalGroup(
			gl_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_NB.createSequentialGroup()
					.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addGap(50)
							.addComponent(Label_Naslov_NB, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(Label_Tekst_NB, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_Datum, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(datum, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_proizvodjac, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Panel_NB.createSequentialGroup()
									.addGap(1)
									.addComponent(padajuci_proizvodjaci, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGap(23)
							.addComponent(Panel_Ulazni, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addGap(231)
							.addComponent(Panel_Izlazni, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(Dugme_Izracunaj, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(Dugme_Sacuvaj, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(Dugme_Izbrisi, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addContainerGap()
							.addComponent(Meni_Panel_NB, GroupLayout.PREFERRED_SIZE, 767, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_Panel_NB.setAutoCreateContainerGaps(true);
		gl_Panel_NB.setAutoCreateGaps(true);
		GroupLayout gl_Meni_Panel_NB = new GroupLayout(Meni_Panel_NB);
		gl_Meni_Panel_NB.setHorizontalGroup(
			gl_Meni_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addComponent(Dugme_pregled_branja, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
				.addComponent(Dugme_proizvodjaci, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
				.addComponent(Dugme_proizvod, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
		);
		gl_Meni_Panel_NB.setVerticalGroup(
			gl_Meni_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Meni_Panel_NB.createSequentialGroup()
					.addGap(130)
					.addComponent(Dugme_pregled_branja, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(Dugme_proizvodjaci, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(Dugme_proizvod, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);
		Meni_Panel_NB.setLayout(gl_Meni_Panel_NB);
		GroupLayout gl_Panel_Izlazni = new GroupLayout(Panel_Izlazni);
		gl_Panel_Izlazni.setHorizontalGroup(
			gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Izlazni.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addComponent(Label_Tara, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(textField_Tara, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addComponent(Label_Neto, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(textField_Neto, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addComponent(Label_Iznos, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(textField_Iznos, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))))
		);
		gl_Panel_Izlazni.setVerticalGroup(
			gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Izlazni.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Tara, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_Tara, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addGroup(gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Neto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_Neto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(17)
					.addGroup(gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Iznos, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addGap(5)
							.addComponent(textField_Iznos, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
		);
		Panel_Izlazni.setLayout(gl_Panel_Izlazni);
		GroupLayout gl_Panel_Ulazni = new GroupLayout(Panel_Ulazni);
		gl_Panel_Ulazni.setHorizontalGroup(
			gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_proizvod, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addGap(97)
							.addComponent(padajuci_proizvod, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(20)
					.addComponent(Radio_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Radio_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addGap(98)
							.addComponent(Radio_3, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(20)
					.addComponent(Label_, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(textField_ulaz1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(20)
					.addComponent(Label_Ulaz_1_1_2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(textField_ulaz2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(20)
					.addComponent(Label_Bruto, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(textField_Bruto, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(20)
					.addComponent(Label_Cena, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(textField_Cena, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
		);
		gl_Panel_Ulazni.setVerticalGroup(
			gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_proizvod, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addGap(1)
							.addComponent(padajuci_proizvod, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(24)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Radio_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(Radio_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(Radio_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_ulaz1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Ulaz_1_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_ulaz2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Bruto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_Bruto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Cena, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addGap(3)
							.addComponent(textField_Cena, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
		);
		Panel_Ulazni.setLayout(gl_Panel_Ulazni);
		Panel_NB.setLayout(gl_Panel_NB);

		JPanel Panel_Branja = new JPanel();
		Panel_Branja.setBackground(Color.WHITE);
		TabbedPanel.addTab("New tab", null, Panel_Branja, null);

		JScrollPane scrollPanel1 = new JScrollPane();

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

		JButton Dugme_Nazad = new JButton("Назад");
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
		Dugme_izbrisi_branje.setBackground(Color.WHITE);
		GroupLayout gl_Panel_Branja = new GroupLayout(Panel_Branja);
		gl_Panel_Branja.setAutoCreateGaps(true);
		gl_Panel_Branja.setAutoCreateContainerGaps(true);
		gl_Panel_Branja.setHorizontalGroup(
			gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Branja.createSequentialGroup()
					.addGap(29)
					.addComponent(Label_Naslov_TB, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_Branja.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPanel1, GroupLayout.PREFERRED_SIZE, 1181, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_Branja.createSequentialGroup()
					.addGap(30)
					.addComponent(Dugme_Nazad, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(Dugme_izbrisi_branje, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
		);
		gl_Panel_Branja.setVerticalGroup(
			gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Branja.createSequentialGroup()
					.addGap(73)
					.addComponent(Label_Naslov_TB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(scrollPanel1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
						.addComponent(Dugme_Nazad, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dugme_izbrisi_branje, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
		);
		Panel_Branja.setLayout(gl_Panel_Branja);

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
		Dugme_Pocetak.setFocusable(false);

		JLabel Pozdrav = new JLabel("Добро дошли !");
		Pozdrav.setForeground(Color.WHITE);
		Pozdrav.setHorizontalAlignment(SwingConstants.CENTER);
		Pozdrav.setFont(new Font("Arial", Font.ITALIC, 24));

		JLabel Labela_Pozadina = new JLabel("");
		Labela_Pozadina.setIcon(new ImageIcon(SistemGUI.class.getResource("/slike/malina_pozadina.png")));
		GroupLayout gl_Pocetni_Panel = new GroupLayout(Pocetni_Panel);
		gl_Pocetni_Panel.setHorizontalGroup(
			gl_Pocetni_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Pocetni_Panel.createSequentialGroup()
					.addGap(460)
					.addComponent(Pozdrav, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Pocetni_Panel.createSequentialGroup()
					.addGap(547)
					.addComponent(Dugme_Pocetak, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				.addComponent(Labela_Pozadina, GroupLayout.PREFERRED_SIZE, 1266, Short.MAX_VALUE)
		);
		gl_Pocetni_Panel.setVerticalGroup(
			gl_Pocetni_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Pocetni_Panel.createSequentialGroup()
					.addGroup(gl_Pocetni_Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Pocetni_Panel.createSequentialGroup()
							.addGap(323)
							.addComponent(Pozdrav, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Pocetni_Panel.createSequentialGroup()
							.addGap(391)
							.addComponent(Dugme_Pocetak, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(Labela_Pozadina, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_Pocetni_Panel.setAutoCreateGaps(true);
		gl_Pocetni_Panel.setAutoCreateContainerGaps(true);
		Pocetni_Panel.setLayout(gl_Pocetni_Panel);

		// PADAJUĆI MENI

		String imena[] = new String[500];
		imena = BazaProizvodjaci.prikaz_imena();

		///////////////////////////////////////////////////////////////////////////////////////

		JPanel Panel_Proizvodjaci = new JPanel();
		Panel_Proizvodjaci.setBackground(Color.WHITE);
		TabbedPanel.addTab("New tab", null, Panel_Proizvodjaci, null);

		JScrollPane scrollPanel2 = new JScrollPane();

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

		JButton Dugme_nazad_pr = new JButton("Назад");
		Dugme_nazad_pr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabbedPanel.setSelectedIndex(1);
				model_tabele_proiz.setRowCount(0);
			}
		});
		Dugme_nazad_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_nazad_pr.setBackground(new Color(153, 255, 153));

		JPanel Panel_novi_pr = new JPanel();
		Panel_novi_pr.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Panel_novi_pr.setBackground(Color.WHITE);

		JLabel Label_Ime_pr = new JLabel("Име :");
		Label_Ime_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel Label_Prezime_pr = new JLabel("Презиме :");
		Label_Prezime_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		textField_ime_pr = new JTextField();
		textField_ime_pr.setToolTipText("");
		textField_ime_pr.setColumns(10);

		textField_prezime_pr = new JTextField();
		textField_prezime_pr.setColumns(10);

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

		JLabel Label_Mesto_pr = new JLabel("Место / Град :");
		Label_Mesto_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel Label_Ulica_pr = new JLabel("Улица :");
		Label_Ulica_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel Label_Broj_pr = new JLabel("Број улице :");
		Label_Broj_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		textField_mesto_pr = new JTextField();
		textField_mesto_pr.setColumns(10);

		textField_ulica_pr = new JTextField();
		textField_ulica_pr.setColumns(10);

		textField_broj_pr = new JTextField();
		textField_broj_pr.setColumns(10);

		JLabel label = new JLabel("Адреса произвођача :");
		label.setFont(new Font("Arial", Font.PLAIN, 14));

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

		JLabel Label_Naslov_PP2 = new JLabel("Унесите новог произвођача");
		Label_Naslov_PP2.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout gl_Panel_Proizvodjaci = new GroupLayout(Panel_Proizvodjaci);
		gl_Panel_Proizvodjaci.setAutoCreateGaps(true);
		gl_Panel_Proizvodjaci.setAutoCreateContainerGaps(true);
		gl_Panel_Proizvodjaci.setHorizontalGroup(
			gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup()
							.addComponent(Label_Naslov_PP1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(345)
							.addComponent(Label_Naslov_PP2, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup()
							.addComponent(scrollPanel2, GroupLayout.PREFERRED_SIZE, 661, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(Panel_novi_pr, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup()
							.addComponent(Dugme_nazad_pr, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(Dugme_izbrisi_pr, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
		);
		gl_Panel_Proizvodjaci.setVerticalGroup(
			gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Naslov_PP1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(Label_Naslov_PP2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPanel2, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
						.addComponent(Panel_novi_pr, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
						.addComponent(Dugme_nazad_pr, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dugme_izbrisi_pr, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
		);
		GroupLayout gl_Panel_novi_pr = new GroupLayout(Panel_novi_pr);
		gl_Panel_novi_pr.setHorizontalGroup(
			gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_novi_pr.createSequentialGroup()
					.addGap(28)
					.addComponent(Label_Ime_pr, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(textField_ime_pr, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_novi_pr.createSequentialGroup()
					.addGap(28)
					.addComponent(Label_Prezime_pr, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(textField_prezime_pr, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_novi_pr.createSequentialGroup()
					.addGap(8)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_novi_pr.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Mesto_pr)
						.addComponent(Label_Ulica_pr, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_mesto_pr, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_ulica_pr, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addComponent(Dugme_izbrisi_pr1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_novi_pr.createSequentialGroup()
					.addGap(28)
					.addComponent(Label_Broj_pr, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(textField_broj_pr, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(Dugme_dodaj_pr, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
		);
		gl_Panel_novi_pr.setVerticalGroup(
			gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_novi_pr.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Ime_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_novi_pr.createSequentialGroup()
							.addGap(4)
							.addComponent(textField_ime_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Prezime_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_novi_pr.createSequentialGroup()
							.addGap(2)
							.addComponent(textField_prezime_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_novi_pr.createSequentialGroup()
							.addComponent(Label_Mesto_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(Label_Ulica_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr.createSequentialGroup()
							.addGap(2)
							.addComponent(textField_mesto_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(textField_ulica_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr.createSequentialGroup()
							.addGap(3)
							.addComponent(Dugme_izbrisi_pr1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_novi_pr.createSequentialGroup()
							.addGap(7)
							.addComponent(Label_Broj_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr.createSequentialGroup()
							.addGap(7)
							.addComponent(textField_broj_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(Dugme_dodaj_pr, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
		);
		Panel_novi_pr.setLayout(gl_Panel_novi_pr);
		Panel_Proizvodjaci.setLayout(gl_Panel_Proizvodjaci);

		JPanel Panel_Proizvod = new JPanel();
		Panel_Proizvod.setBackground(Color.WHITE);
		TabbedPanel.addTab("New tab", null, Panel_Proizvod, null);

		JLabel Label_Naslov_PP1_1 = new JLabel("Преглед унетих производа");
		Label_Naslov_PP1_1.setFont(new Font("Arial", Font.PLAIN, 18));

		JButton Dugme_izbrisi_proizvod = new JButton("Избриши производ\r\n");

		Dugme_izbrisi_proizvod.setForeground(Color.RED);
		Dugme_izbrisi_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_proizvod.setBackground(Color.WHITE);

		////////////////////////////////////////////////////////////////////////////////////////////////////

		JScrollPane scrollPane_proizvod = new JScrollPane();

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

		JPanel Panel_novi_pr_1 = new JPanel();
		Panel_novi_pr_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Panel_novi_pr_1.setBackground(Color.WHITE);

		JLabel Label_nazivProizvoda = new JLabel("Назив производа :");
		Label_nazivProizvoda.setFont(new Font("Arial", Font.PLAIN, 14));

		textField_nazivProizvoda = new JTextField();
		textField_nazivProizvoda.setToolTipText("");
		textField_nazivProizvoda.setColumns(10);

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

		JLabel Label_vrstaProizvoda = new JLabel("Врста производа :");
		Label_vrstaProizvoda.setFont(new Font("Arial", Font.PLAIN, 14));

		textField_vrstaProizvoda = new JTextField();
		textField_vrstaProizvoda.setToolTipText("");
		textField_vrstaProizvoda.setColumns(10);

		JLabel Label_Naslov_PP2_1 = new JLabel("Унесите нови производ");
		Label_Naslov_PP2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout gl_Panel_Proizvod = new GroupLayout(Panel_Proizvod);
		gl_Panel_Proizvod.setAutoCreateGaps(true);
		gl_Panel_Proizvod.setAutoCreateContainerGaps(true);
		gl_Panel_Proizvod.setHorizontalGroup(
			gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Proizvod.createSequentialGroup()
					.addGap(29)
					.addComponent(Label_Naslov_PP1_1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addGap(239)
					.addComponent(Label_Naslov_PP2_1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_Proizvod.createSequentialGroup()
					.addGap(31)
					.addComponent(scrollPane_proizvod, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(Panel_novi_pr_1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_Panel_Proizvod.createSequentialGroup()
					.addGap(29)
					.addComponent(Dugme_nazad_proizvod, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(Dugme_izbrisi_proizvod, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
		);
		gl_Panel_Proizvod.setVerticalGroup(
			gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Proizvod.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Naslov_PP1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(Label_Naslov_PP2_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_proizvod, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
						.addComponent(Panel_novi_pr_1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
						.addComponent(Dugme_nazad_proizvod, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dugme_izbrisi_proizvod, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
		);
		GroupLayout gl_Panel_novi_pr_1 = new GroupLayout(Panel_novi_pr_1);
		gl_Panel_novi_pr_1.setHorizontalGroup(
			gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addComponent(Label_nazivProizvoda)
							.addGap(23)
							.addComponent(textField_nazivProizvoda, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addComponent(Dugme_izbrisi_proiz, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addComponent(Label_vrstaProizvoda, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(textField_vrstaProizvoda, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addComponent(Dugme_dodaj_proiz, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
		);
		gl_Panel_novi_pr_1.setVerticalGroup(
			gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addGap(7)
							.addComponent(Label_nazivProizvoda, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addGap(9)
							.addComponent(textField_nazivProizvoda, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(Dugme_izbrisi_proiz, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_vrstaProizvoda, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addGap(2)
							.addComponent(textField_vrstaProizvoda, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addGap(4)
							.addComponent(Dugme_dodaj_proiz, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
		);
		Panel_novi_pr_1.setLayout(gl_Panel_novi_pr_1);
		Panel_Proizvod.setLayout(gl_Panel_Proizvod);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(TabbedPanel, GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(TabbedPanel, GroupLayout.PREFERRED_SIZE, 814, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setAutoCreateGaps(true);
		gl_contentPane.setAutoCreateContainerGaps(true);
		contentPane.setLayout(gl_contentPane);

	}
}
