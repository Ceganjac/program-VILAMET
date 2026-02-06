package pogled.paneli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import pogled.GradientPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NaziviPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNaziviN;

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	/**
	 * Create the panel.
	 */
	public NaziviPanel() {

		setPreferredSize(new Dimension(screenSirina - 300, 50));
		setBackground(Color.LIGHT_GRAY);

		JPanel pnlNazivi = new JPanel();
		pnlNazivi.setBorder(new EmptyBorder(0, 0, 1, 0));
		pnlNazivi.setBackground(Color.LIGHT_GRAY);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlNazivi, GroupLayout.PREFERRED_SIZE, screenSirina - 300, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlNazivi, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		// labela za naziv
		lblNaziviN = new JLabel("Откуп");
		lblNaziviN.setHorizontalAlignment(SwingConstants.LEFT);
		lblNaziviN.setFont(new Font("Arial", Font.PLAIN, 20));
		
		GroupLayout gl_pnlNazivi = new GroupLayout(pnlNazivi);
		gl_pnlNazivi.setHorizontalGroup(gl_pnlNazivi.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNazivi.createSequentialGroup().addGap(120)
						.addComponent(lblNaziviN, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(1147, Short.MAX_VALUE)));
		gl_pnlNazivi.setVerticalGroup(gl_pnlNazivi.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlNazivi.createSequentialGroup()
				.addGap(7).addComponent(lblNaziviN, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE).addGap(7)));
		pnlNazivi.setLayout(gl_pnlNazivi);
		setLayout(groupLayout);

	}

	public JLabel getLblNaziviN() {
		return lblNaziviN;
	}

	public void postaviNaziv(String naziv) {
		lblNaziviN.setText(naziv);
	}
}
