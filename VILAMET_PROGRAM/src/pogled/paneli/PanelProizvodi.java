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
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelProizvodi extends JPanel {

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PanelProizvodi() {

		JPanel Panel_Proizvod = new JPanel();
		Panel_Proizvod.setBackground(Color.WHITE);
		Panel_Proizvod.setPreferredSize(new Dimension(screenSirina-300,screenVisina));
		add(Panel_Proizvod);

		JLabel Label_Naslov_PP1_1 = new JLabel("Преглед унетих производа");
		Label_Naslov_PP1_1.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel Label_Naslov_PP2_1 = new JLabel("Унесите нови производ");
		Label_Naslov_PP2_1.setFont(new Font("Arial", Font.PLAIN, 18));

		JScrollPane scrollPane_proizvod = new JScrollPane();

		JPanel Panel_novi_pr_1 = new JPanel();
		Panel_novi_pr_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Panel_novi_pr_1.setBackground(Color.WHITE);

		JLabel Label_nazivProizvoda = new JLabel("Назив производа :");
		Label_nazivProizvoda.setFont(new Font("Arial", Font.PLAIN, 14));

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);

		JButton Dugme_izbrisi_proiz = new JButton("Избриши");
		Dugme_izbrisi_proiz.setForeground(Color.RED);
		Dugme_izbrisi_proiz.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_proiz.setBackground(Color.WHITE);

		JLabel Label_vrstaProizvoda = new JLabel("Врста производа :");
		Label_vrstaProizvoda.setFont(new Font("Arial", Font.PLAIN, 14));

		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);

		JButton Dugme_dodaj_proiz = new JButton("Додај");
		Dugme_dodaj_proiz.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_dodaj_proiz.setBackground(new Color(0, 194, 0));
		GroupLayout gl_Panel_novi_pr_1 = new GroupLayout(Panel_novi_pr_1);
		gl_Panel_novi_pr_1.setHorizontalGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 565, Short.MAX_VALUE)
				.addGroup(gl_Panel_novi_pr_1.createSequentialGroup().addGap(28)
						.addGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING).addGroup(gl_Panel_novi_pr_1
								.createSequentialGroup().addComponent(Label_nazivProizvoda).addGap(23)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(86).addComponent(Dugme_izbrisi_proiz, GroupLayout.PREFERRED_SIZE, 139,
										GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
										.addComponent(Label_vrstaProizvoda, GroupLayout.PREFERRED_SIZE, 124,
												GroupLayout.PREFERRED_SIZE)
										.addGap(23)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE)
										.addGap(86).addComponent(Dugme_dodaj_proiz, GroupLayout.PREFERRED_SIZE, 139,
												GroupLayout.PREFERRED_SIZE)))));
		gl_Panel_novi_pr_1.setVerticalGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_Panel_novi_pr_1.createSequentialGroup().addGap(42).addGroup(gl_Panel_novi_pr_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup().addGap(7).addComponent(
								Label_nazivProizvoda, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup().addGap(9).addComponent(textField,
								GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(Dugme_izbrisi_proiz, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGap(2)
						.addGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_vrstaProizvoda, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Panel_novi_pr_1.createSequentialGroup().addGap(2).addComponent(textField_1,
										GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel_novi_pr_1.createSequentialGroup().addGap(4).addComponent(
										Dugme_dodaj_proiz, GroupLayout.PREFERRED_SIZE, 39,
										GroupLayout.PREFERRED_SIZE)))));
		Panel_novi_pr_1.setLayout(gl_Panel_novi_pr_1);

		JButton Dugme_nazad_proizvod = new JButton("Назад");
		Dugme_nazad_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_nazad_proizvod.setBackground(new Color(153, 255, 153));

		JButton Dugme_izbrisi_proizvod = new JButton("Избриши производ\r\n");
		Dugme_izbrisi_proizvod.setForeground(Color.RED);
		Dugme_izbrisi_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_proizvod.setBackground(Color.WHITE);
		GroupLayout gl_Panel_Proizvod = new GroupLayout(Panel_Proizvod);
		gl_Panel_Proizvod.setHorizontalGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Proizvod.createSequentialGroup().addContainerGap(108, Short.MAX_VALUE)
						.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_Naslov_PP1_1, GroupLayout.PREFERRED_SIZE, 349,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_Panel_Proizvod.createSequentialGroup()
												.addComponent(Dugme_nazad_proizvod, GroupLayout.PREFERRED_SIZE, 194,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(Dugme_izbrisi_proizvod, GroupLayout.PREFERRED_SIZE, 194,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(scrollPane_proizvod, GroupLayout.PREFERRED_SIZE, 512,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(36)
						.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_Naslov_PP2_1, GroupLayout.PREFERRED_SIZE, 349,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(Panel_novi_pr_1, GroupLayout.PREFERRED_SIZE, 565,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(289, Short.MAX_VALUE)));
		gl_Panel_Proizvod.setVerticalGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Proizvod.createSequentialGroup().addGap(69)
						.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.BASELINE)
								.addComponent(Label_Naslov_PP2_1, GroupLayout.PREFERRED_SIZE, 34,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(Label_Naslov_PP1_1, GroupLayout.PREFERRED_SIZE, 34,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane_proizvod)
								.addComponent(Panel_novi_pr_1, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.BASELINE)
								.addComponent(Dugme_izbrisi_proizvod, GroupLayout.PREFERRED_SIZE, 39,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(Dugme_nazad_proizvod, GroupLayout.PREFERRED_SIZE, 39,
										GroupLayout.PREFERRED_SIZE))));
		gl_Panel_Proizvod.setAutoCreateGaps(true);
		gl_Panel_Proizvod.setAutoCreateContainerGaps(true);
		Panel_Proizvod.setLayout(gl_Panel_Proizvod);

	}

}
