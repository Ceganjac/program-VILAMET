package pogled.paneli;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelBranja extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// UZIMANJE DIMENZIJA EKRANA
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    int screenSirina = screenSize.width;
		    int screenVisina = screenSize.height;

	/**
	 * Create the panel.
	 */
	public PanelBranja() {
		
		JPanel Panel_Branja = new JPanel();
		Panel_Branja.setBackground(Color.WHITE);
		Panel_Branja.setPreferredSize(new Dimension(screenSirina-300, screenVisina));
		
		add(Panel_Branja);
		
		JButton Dugme_izbrisi_branje = new JButton("Избриши брање");
		Dugme_izbrisi_branje.setForeground(Color.RED);
		Dugme_izbrisi_branje.setFont(new Font("Arial", Font.PLAIN, 14));
		Dugme_izbrisi_branje.setBackground(Color.WHITE);
		
		JScrollPane scrollPanel1 = new JScrollPane();
		
		JLabel Label_Naslov_TB = new JLabel("Преглед сачуваних брања");
		Label_Naslov_TB.setHorizontalAlignment(SwingConstants.LEFT);
		Label_Naslov_TB.setFont(new Font("Arial", Font.PLAIN, 18));
		
		GroupLayout gl_Panel_Branja = new GroupLayout(Panel_Branja);
		gl_Panel_Branja.setHorizontalGroup(
			gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Branja.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_Branja.createSequentialGroup()
							.addComponent(Dugme_izbrisi_branje, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_Panel_Branja.createSequentialGroup()
							.addGroup(gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPanel1, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
								.addComponent(Label_Naslov_TB, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
							.addGap(250))))
		);
		gl_Panel_Branja.setVerticalGroup(
			gl_Panel_Branja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Branja.createSequentialGroup()
					.addGap(70)
					.addComponent(Label_Naslov_TB, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(scrollPanel1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(Dugme_izbrisi_branje, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(341))
		);
		//gl_Panel_Branja.setAutoCreateGaps(true);
		//gl_Panel_Branja.setAutoCreateContainerGaps(true);
		Panel_Branja.setLayout(gl_Panel_Branja);

	}

}
