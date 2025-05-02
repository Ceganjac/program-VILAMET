package pogled.paneli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import pogled.GradientPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class NaziviPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	/**
	 * Create the panel.
	 */
	public NaziviPanel() {

		setPreferredSize(new Dimension(screenSirina,50));
		setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Наслов");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(307)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1262, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

		JPanel pnlNazivi = new GradientPanel();
		pnlNazivi.setPreferredSize(new Dimension(screenSirina, 50));

	}

}
