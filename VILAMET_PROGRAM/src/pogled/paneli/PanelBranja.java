package pogled.paneli;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelBranja extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelBranja() {
		
		JPanel Panel_Branja = new JPanel();
		Panel_Branja.setBackground(Color.WHITE);
		add(Panel_Branja);
		
		JButton Dugme_Nazad = new JButton("Назад");
		Dugme_Nazad.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_Nazad.setBackground(new Color(153, 255, 153));
		
		JButton Dugme_izbrisi_branje = new JButton("Избриши селектовано брање");
		Dugme_izbrisi_branje.setForeground(Color.RED);
		Dugme_izbrisi_branje.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_branje.setBackground(Color.WHITE);
		
		JScrollPane scrollPanel1 = new JScrollPane();
		
		JLabel Label_Naslov_TB = new JLabel("Преглед сачуваних брања");
		Label_Naslov_TB.setHorizontalAlignment(SwingConstants.LEFT);
		Label_Naslov_TB.setFont(new Font("Arial", Font.PLAIN, 20));
		GroupLayout gl_Panel_Branja = new GroupLayout(Panel_Branja);
		gl_Panel_Branja.setHorizontalGroup(
			gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1530, Short.MAX_VALUE)
				.addGroup(gl_Panel_Branja.createSequentialGroup()
					.addGroup(gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Branja.createSequentialGroup()
							.addGap(30)
							.addComponent(Dugme_Nazad, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(Dugme_izbrisi_branje, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_Branja.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPanel1, GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
								.addComponent(Label_Naslov_TB, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))))
					.addGap(250))
		);
		gl_Panel_Branja.setVerticalGroup(
			gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
				.addGap(0, 835, Short.MAX_VALUE)
				.addGroup(gl_Panel_Branja.createSequentialGroup()
					.addGap(74)
					.addComponent(Label_Naslov_TB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(scrollPanel1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
						.addComponent(Dugme_Nazad, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dugme_izbrisi_branje, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
		);
		gl_Panel_Branja.setAutoCreateGaps(true);
		gl_Panel_Branja.setAutoCreateContainerGaps(true);
		Panel_Branja.setLayout(gl_Panel_Branja);

	}

}
