package pogled.paneli;

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
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;

public class PanelNB extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenSirina = screenSize.width;
    int screenVisina = screenSize.height;
	
	public PanelNB( ) {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		
		JPanel Panel_NB = new JPanel();
		Panel_NB.setBackground(Color.WHITE);
		Panel_NB.setPreferredSize(new Dimension(screenSirina-300,screenVisina));
		add(Panel_NB);
		
		JLabel Label_Tekst_NB = new JLabel("Унесите параметре брања са леве стране");
		Label_Tekst_NB.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JPanel Panel_Ulazni = new JPanel();
		Panel_Ulazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Ulazni.setBackground(Color.WHITE);
		
		JRadioButton Radio_2 = new JRadioButton("0.5 kg");
		Radio_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Radio_2.setBackground(Color.WHITE);
		
		JRadioButton Radio_3 = new JRadioButton("0.4 и 0.5 kg");
		Radio_3.setToolTipText("Izaberi");
		Radio_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Radio_3.setBackground(Color.WHITE);
		
		JRadioButton Radio_1 = new JRadioButton("0.4 kg");
		Radio_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Radio_1.setBackground(Color.WHITE);
		
		JLabel Label_proizvod = new JLabel("Производ :");
		Label_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JComboBox<String> padajuci_proizvod = new JComboBox<String>();
		padajuci_proizvod.setFont(new Font("Arial", Font.PLAIN, 12));
		padajuci_proizvod.setBackground(Color.WHITE);
		
		JLabel Label_Cena = new JLabel("Цена  :");
		Label_Cena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		
		JLabel Label_ = new JLabel("Број гајбица од 0.4 kg :");
		Label_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JLabel Label_Ulaz_1_1_2 = new JLabel("Број гајбица од 0.5 kg :");
		Label_Ulaz_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JLabel Label_Bruto = new JLabel("Бруто  :");
		Label_Bruto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		GroupLayout gl_Panel_Ulazni = new GroupLayout(Panel_Ulazni);
		gl_Panel_Ulazni.setHorizontalGroup(
			gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
				.addGap(0, 504, Short.MAX_VALUE)
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addComponent(Radio_2, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
							.addGap(296))
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addComponent(Radio_3, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addGap(278))
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addComponent(Radio_1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
							.addGap(308))
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addComponent(Label_proizvod, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(padajuci_proizvod, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(98))
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addComponent(Label_Cena, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addComponent(Label_, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addComponent(Label_Ulaz_1_1_2, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addComponent(Label_Bruto, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
					.addGap(68))
		);
		gl_Panel_Ulazni.setVerticalGroup(
			gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
				.addGap(0, 377, Short.MAX_VALUE)
				.addGroup(gl_Panel_Ulazni.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(Label_proizvod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(padajuci_proizvod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Radio_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Radio_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Radio_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(Label_, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addGap(13)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_Ulazni.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Label_Ulaz_1_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(Label_Bruto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_Panel_Ulazni.createParallelGroup(Alignment.BASELINE)
						.addComponent(Label_Cena, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(50))
		);
		Panel_Ulazni.setLayout(gl_Panel_Ulazni);
		
		JButton Dugme_Izracunaj = new JButton("ИЗРАЧУНАЈ");
		Dugme_Izracunaj.setForeground(Color.BLACK);
		Dugme_Izracunaj.setFont(new Font("Arial", Font.PLAIN, 12));
		Dugme_Izracunaj.setFocusable(false);
		Dugme_Izracunaj.setBackground(new Color(153, 255, 153));
		
		JPanel Panel_Izlazni = new JPanel();
		Panel_Izlazni.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panel_Izlazni.setBackground(Color.WHITE);
		
		JLabel Label_Tara = new JLabel("Тара :");
		Label_Tara.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Tara.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		JLabel Label_Neto = new JLabel("Нето :");
		Label_Neto.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Neto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		JLabel Label_Iznos = new JLabel("Износ брања :");
		Label_Iznos.setHorizontalAlignment(SwingConstants.RIGHT);
		Label_Iznos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		
		GroupLayout gl_Panel_Izlazni = new GroupLayout(Panel_Izlazni);
		gl_Panel_Izlazni.setHorizontalGroup(
			gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
				.addGap(0, 371, Short.MAX_VALUE)
				.addGroup(gl_Panel_Izlazni.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addGap(4)
							.addComponent(Label_Tara, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addComponent(Label_Neto, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addGap(22)
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addComponent(Label_Iznos, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addGap(22)
							.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
					.addGap(60))
		);
		gl_Panel_Izlazni.setVerticalGroup(
			gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGroup(gl_Panel_Izlazni.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addComponent(Label_Tara, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(Label_Neto, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(20)
					.addGroup(gl_Panel_Izlazni.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addComponent(Label_Iznos, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_Panel_Izlazni.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(68))
		);
		Panel_Izlazni.setLayout(gl_Panel_Izlazni);
		
		JButton Dugme_Sacuvaj = new JButton("САЧУВАЈ");
		Dugme_Sacuvaj.setForeground(Color.BLACK);
		Dugme_Sacuvaj.setFont(new Font("Arial", Font.PLAIN, 12));
		Dugme_Sacuvaj.setFocusable(false);
		Dugme_Sacuvaj.setBackground(new Color(0, 194, 0));
		
		JButton Dugme_Izbrisi = new JButton("ИЗБРИШИ");
		Dugme_Izbrisi.setForeground(Color.RED);
		Dugme_Izbrisi.setFont(new Font("Arial", Font.BOLD, 12));
		Dugme_Izbrisi.setFocusable(false);
		Dugme_Izbrisi.setBackground(Color.WHITE);
		
		JLabel Label_Naslov_NB = new JLabel("Ново Брање");
		Label_Naslov_NB.setFont(new Font("Arial", Font.PLAIN, 24));
		
		JLabel Label_Datum = new JLabel("Датум :");
		Label_Datum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel Label_proizvodjac = new JLabel("Произвођач :");
		Label_proizvodjac.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JDateChooser datum = new JDateChooser();
		datum.getCalendarButton().setBackground(Color.WHITE);
		datum.setBackground(Color.WHITE);
		
		JComboBox<String> padajuci_proizvodjaci = new JComboBox<String>();
		padajuci_proizvodjaci.setFont(new Font("Arial", Font.PLAIN, 12));
		padajuci_proizvodjaci.setBackground(Color.WHITE);
		
		GroupLayout gl_Panel_NB = new GroupLayout(Panel_NB);
		gl_Panel_NB.setHorizontalGroup(
			gl_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_NB.createSequentialGroup()
					.addGap(120) // 120px razmaka sa leve strane
					.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_Naslov_NB, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addComponent(Panel_Ulazni, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Panel_NB.createSequentialGroup()
									.addGap(114)
									.addComponent(Dugme_Izracunaj, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel_NB.createSequentialGroup()
									.addGap(32)
									.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING, false)
										.addComponent(Dugme_Sacuvaj, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Panel_Izlazni, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)))
								.addGroup(gl_Panel_NB.createSequentialGroup()
									.addGap(112)
									.addComponent(Dugme_Izbrisi, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Panel_NB.createSequentialGroup()
							.addGroup(gl_Panel_NB.createParallelGroup(Alignment.TRAILING)
								.addComponent(Label_Datum, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(Label_proizvodjac, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_Panel_NB.createParallelGroup(Alignment.LEADING)
								.addComponent(datum, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(padajuci_proizvodjaci, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
						.addComponent(Label_Tekst_NB))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		gl_Panel_NB.setVerticalGroup(
			gl_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_NB.createSequentialGroup()
					.addGap(30)
					.addComponent(Label_Naslov_NB, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Label_Tekst_NB)
					.addGap(46)
					.addGroup(gl_Panel_NB.createParallelGroup(Alignment.TRAILING)
						.addComponent(datum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(Label_Datum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Panel_NB.createParallelGroup(Alignment.BASELINE)
						.addComponent(padajuci_proizvodjaci, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(Label_proizvodjac, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Panel_NB.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_Panel_NB.createSequentialGroup()
							.addComponent(Panel_Izlazni, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(Dugme_Izracunaj, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Dugme_Sacuvaj, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Dugme_Izbrisi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(Panel_Ulazni, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(220, Short.MAX_VALUE))
		);
		Panel_NB.setLayout(gl_Panel_NB);

	}

}
