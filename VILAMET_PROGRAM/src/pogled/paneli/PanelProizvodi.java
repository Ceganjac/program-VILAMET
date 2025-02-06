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
		Panel_Proizvod.setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
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
		
		gl_Panel_novi_pr_1.setHorizontalGroup(
			gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
						.addComponent(Dugme_izbrisi_proiz, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dugme_dodaj_proiz, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addComponent(Label_nazivProizvoda)
							.addGap(23)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addComponent(Label_vrstaProizvoda, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addGap(57))
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
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_Panel_novi_pr_1.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_vrstaProizvoda, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
							.addGap(2)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addComponent(Dugme_izbrisi_proiz, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addGroup(gl_Panel_novi_pr_1.createSequentialGroup()
						.addGap(4)
						.addComponent(Dugme_dodaj_proiz, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		Panel_novi_pr_1.setLayout(gl_Panel_novi_pr_1);

		JButton Dugme_izbrisi_proizvod = new JButton("Избриши производ\r\n");
		Dugme_izbrisi_proizvod.setForeground(Color.RED);
		Dugme_izbrisi_proizvod.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_proizvod.setBackground(Color.WHITE);

		GroupLayout gl_Panel_Proizvod = new GroupLayout(Panel_Proizvod);
		gl_Panel_Proizvod.setHorizontalGroup(
			gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Proizvod.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
						.addComponent(Dugme_izbrisi_proizvod, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_Proizvod.createSequentialGroup()
							.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_Naslov_PP1_1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_proizvod, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Panel_novi_pr_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Label_Naslov_PP2_1, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
							.addGap(216)))
					.addContainerGap())
		);
		gl_Panel_Proizvod.setVerticalGroup(
			gl_Panel_Proizvod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Proizvod.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.BASELINE)
						.addComponent(Label_Naslov_PP2_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(Label_Naslov_PP1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_Panel_Proizvod.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_proizvod, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(Panel_novi_pr_1, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
					.addGap(20)
					.addComponent(Dugme_izbrisi_proizvod, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(352))
		);
		gl_Panel_Proizvod.setAutoCreateGaps(true);
		gl_Panel_Proizvod.setAutoCreateContainerGaps(true);
		Panel_Proizvod.setLayout(gl_Panel_Proizvod);

	}

}
