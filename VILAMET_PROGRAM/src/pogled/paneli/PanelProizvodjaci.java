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
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelProizvodjaci extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PanelProizvodjaci() {

		JPanel Panel_Proizvodjaci = new JPanel();
		Panel_Proizvodjaci.setBackground(Color.WHITE);
		Panel_Proizvodjaci.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		add(Panel_Proizvodjaci);

		JLabel Label_Naslov_PP1 = new JLabel("Преглед унетих произвођача");
		Label_Naslov_PP1.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel Label_Naslov_PP2 = new JLabel("Унесите новог произвођача");
		Label_Naslov_PP2.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane scrollPanel2 = new JScrollPane();

		JPanel Panel_novi_pr = new JPanel();
		Panel_novi_pr.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Panel_novi_pr.setBackground(Color.WHITE);

		JLabel Label_Ime_pr = new JLabel("Име :");
		Label_Ime_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);

		JLabel Label_Prezime_pr = new JLabel("Презиме :");
		Label_Prezime_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel label = new JLabel("Адреса произвођача :");
		label.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel Label_Mesto_pr = new JLabel("Место / Град :");
		Label_Mesto_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel Label_Ulica_pr = new JLabel("Улица :");
		Label_Ulica_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JButton Dugme_izbrisi_pr1 = new JButton("Избриши");
		Dugme_izbrisi_pr1.setForeground(Color.RED);
		Dugme_izbrisi_pr1.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_pr1.setBackground(Color.WHITE);

		JLabel Label_Broj_pr = new JLabel("Број улице :");
		Label_Broj_pr.setFont(new Font("Arial", Font.PLAIN, 14));

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JButton Dugme_dodaj_pr = new JButton("Додај");
		Dugme_dodaj_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_dodaj_pr.setBackground(new Color(0, 194, 0));
		GroupLayout gl_Panel_novi_pr = new GroupLayout(Panel_novi_pr);
		gl_Panel_novi_pr.setHorizontalGroup(
				gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING).addGap(0, 479, Short.MAX_VALUE)
						.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(28)
								.addComponent(Label_Ime_pr, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGap(50)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(28)
								.addComponent(Label_Prezime_pr, GroupLayout.PREFERRED_SIZE, 70,
										GroupLayout.PREFERRED_SIZE)
								.addGap(50)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr
								.createSequentialGroup().addGap(8)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_Panel_novi_pr.createSequentialGroup().addGap(28)
										.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
												.addComponent(Label_Mesto_pr).addComponent(Label_Ulica_pr,
														GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
										.addGap(26)
										.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 104,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 104,
														GroupLayout.PREFERRED_SIZE))
										.addGap(64).addComponent(Dugme_izbrisi_pr1, GroupLayout.PREFERRED_SIZE, 139,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(28)
								.addComponent(Label_Broj_pr, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(64).addComponent(Dugme_dodaj_pr, GroupLayout.PREFERRED_SIZE, 139,
										GroupLayout.PREFERRED_SIZE)));
		gl_Panel_novi_pr.setVerticalGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(36)
						.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_Ime_pr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(4).addComponent(textField,
										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addGap(6)
						.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_Prezime_pr, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(2).addComponent(textField_1,
										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addGap(30).addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Panel_novi_pr.createSequentialGroup()
										.addComponent(Label_Mesto_pr, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(Label_Ulica_pr, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(2)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addGap(8).addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(3).addComponent(
										Dugme_izbrisi_pr1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
						.addGap(3)
						.addGroup(gl_Panel_novi_pr.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(7).addComponent(Label_Broj_pr,
										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel_novi_pr.createSequentialGroup().addGap(7).addComponent(textField_4,
										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(Dugme_dodaj_pr, GroupLayout.PREFERRED_SIZE, 39,
										GroupLayout.PREFERRED_SIZE))));
		Panel_novi_pr.setLayout(gl_Panel_novi_pr);

		JButton Dugme_nazad_pr = new JButton("Назад");
		Dugme_nazad_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_nazad_pr.setBackground(new Color(153, 255, 153));

		JButton Dugme_izbrisi_pr = new JButton("Избриши произвођача");
		Dugme_izbrisi_pr.setForeground(Color.RED);
		Dugme_izbrisi_pr.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_pr.setBackground(Color.WHITE);
		GroupLayout gl_Panel_Proizvodjaci = new GroupLayout(Panel_Proizvodjaci);
		gl_Panel_Proizvodjaci.setHorizontalGroup(gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1530, Short.MAX_VALUE)
				.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup().addGap(29).addGroup(gl_Panel_Proizvodjaci
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup()
								.addComponent(Label_Naslov_PP1, GroupLayout.PREFERRED_SIZE, 349,
										GroupLayout.PREFERRED_SIZE)
								.addGap(345).addComponent(Label_Naslov_PP2, GroupLayout.PREFERRED_SIZE, 349,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup()
								.addComponent(scrollPanel2, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE).addGap(33)
								.addComponent(Panel_novi_pr, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
						.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup()
								.addComponent(Dugme_nazad_pr, GroupLayout.PREFERRED_SIZE, 194,
										GroupLayout.PREFERRED_SIZE)
								.addGap(32).addComponent(Dugme_izbrisi_pr, GroupLayout.PREFERRED_SIZE, 194,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(328)));
		gl_Panel_Proizvodjaci.setVerticalGroup(
				gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING).addGap(0, 835, Short.MAX_VALUE)
						.addGroup(gl_Panel_Proizvodjaci.createSequentialGroup().addGap(73)
								.addGroup(gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
										.addComponent(Label_Naslov_PP1, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(Label_Naslov_PP2, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE))
								.addGap(22)
								.addGroup(gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING, false)
										.addComponent(scrollPanel2, 0, 0, Short.MAX_VALUE)
										.addComponent(Panel_novi_pr, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
								.addGap(54)
								.addGroup(gl_Panel_Proizvodjaci.createParallelGroup(Alignment.LEADING)
										.addComponent(Dugme_nazad_pr, GroupLayout.PREFERRED_SIZE, 39,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(Dugme_izbrisi_pr, GroupLayout.PREFERRED_SIZE, 39,
												GroupLayout.PREFERRED_SIZE))));
		gl_Panel_Proizvodjaci.setAutoCreateGaps(true);
		gl_Panel_Proizvodjaci.setAutoCreateContainerGaps(true);
		Panel_Proizvodjaci.setLayout(gl_Panel_Proizvodjaci);

	}

}
