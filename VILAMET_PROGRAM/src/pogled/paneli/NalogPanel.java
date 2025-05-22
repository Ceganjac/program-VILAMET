package pogled.paneli;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public  class NalogPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */

	// UZIMANJE DIMENZIJA EKRANA
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	public NalogPanel() {
		setPreferredSize(new Dimension(screenSirina - 300, screenVisina));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 1620, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 1081, Short.MAX_VALUE));
		setLayout(groupLayout);

	}

	

}
