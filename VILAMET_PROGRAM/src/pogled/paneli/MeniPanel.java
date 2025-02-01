package pogled.paneli;

import javax.swing.JPanel;
import pogled.GradientPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MeniPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MeniPanel() {

		GradientPanel MeniPanel = new GradientPanel();
		MeniPanel.setBackground(Color.WHITE);

		JButton Dugme_pregled_branja = new JButton("Преглед брања");
		Dugme_pregled_branja.setIconTextGap(20);
		Dugme_pregled_branja.setIcon(new ImageIcon(MeniPanel.class.getResource("/slike/lista.png")));
		Dugme_pregled_branja.setHorizontalTextPosition(SwingConstants.RIGHT);
		Dugme_pregled_branja.setForeground(Color.BLACK);
		Dugme_pregled_branja.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_pregled_branja.setFocusable(false);
		Dugme_pregled_branja.setContentAreaFilled(false);
		Dugme_pregled_branja.setBorderPainted(false);
		Dugme_pregled_branja.setBackground(Color.WHITE);

		JButton Dugme_proizvodjaci = new JButton("Произвођачи");
		Dugme_proizvodjaci.setIconTextGap(30);
		Dugme_proizvodjaci.setIcon(new ImageIcon(MeniPanel.class.getResource("/slike/ljudi.png")));
		Dugme_proizvodjaci.setForeground(Color.BLACK);
		Dugme_proizvodjaci.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_proizvodjaci.setFocusable(false);
		Dugme_proizvodjaci.setContentAreaFilled(false);
		Dugme_proizvodjaci.setBorderPainted(false);
		Dugme_proizvodjaci.setBackground(Color.WHITE);

		JButton Dugme_proizvod = new JButton("Производи");
		Dugme_proizvod.setIconTextGap(50);
		Dugme_proizvod.setIcon(new ImageIcon(MeniPanel.class.getResource("/slike/proizvod.png")));
		Dugme_proizvod.setForeground(Color.BLACK);
		Dugme_proizvod.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		Dugme_proizvod.setFocusable(false);
		Dugme_proizvod.setContentAreaFilled(false);
		Dugme_proizvod.setBorderPainted(false);
		GroupLayout gl_Meni_Panel_NB = new GroupLayout(MeniPanel);
		gl_Meni_Panel_NB.setHorizontalGroup(
				gl_Meni_Panel_NB.createParallelGroup(Alignment.LEADING).addGap(0, 276, Short.MAX_VALUE)
						.addComponent(Dugme_pregled_branja, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dugme_proizvodjaci, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dugme_proizvod, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE));
		gl_Meni_Panel_NB.setVerticalGroup(gl_Meni_Panel_NB.createParallelGroup(Alignment.LEADING)
				.addGap(0, 805, Short.MAX_VALUE)
				.addGroup(gl_Meni_Panel_NB.createSequentialGroup().addGap(130)
						.addComponent(Dugme_pregled_branja, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(Dugme_proizvodjaci, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(Dugme_proizvod, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)));
		MeniPanel.setLayout(gl_Meni_Panel_NB);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout
						.createSequentialGroup().addComponent(MeniPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(705, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout
						.createSequentialGroup().addComponent(MeniPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(61, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}

}
