package pogled.paneli;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import pogled.PozadinaPanel;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPocetni extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelPocetni(CardLayout cl, JPanel contentPane) {
		
		PozadinaPanel Pocetni_Panel = new PozadinaPanel("/pogled/slike/maline_pozadina.png");
		add(Pocetni_Panel);
		
		JPanel Panel_dd = new JPanel();
		Panel_dd.setBackground(new Color(255, 0, 0, 100));
		
		JLabel Pozdrav = new JLabel("Добро дошли !");
		Pozdrav.setHorizontalAlignment(SwingConstants.CENTER);
		Pozdrav.setForeground(Color.WHITE);
		Pozdrav.setFont(new Font("Arial", Font.ITALIC, 24));
		
		JButton Dugme_Pocetak = new JButton("ПОЧЕТАК");
		Dugme_Pocetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane,"pnb");
			}
		});
		Dugme_Pocetak.setForeground(Color.BLACK);
		Dugme_Pocetak.setFont(new Font("Arial", Font.BOLD, 12));
		Dugme_Pocetak.setFocusable(false);
		Dugme_Pocetak.setBorder(null);
		Dugme_Pocetak.setBackground(Color.WHITE);
		GroupLayout gl_Panel_dd = new GroupLayout(Panel_dd);
		gl_Panel_dd.setHorizontalGroup(
			gl_Panel_dd.createParallelGroup(Alignment.LEADING)
				.addGap(0, 332, Short.MAX_VALUE)
				.addGroup(gl_Panel_dd.createSequentialGroup()
					.addGroup(gl_Panel_dd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_dd.createSequentialGroup()
							.addGap(84)
							.addComponent(Pozdrav))
						.addGroup(gl_Panel_dd.createSequentialGroup()
							.addGap(47)
							.addComponent(Dugme_Pocetak, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_Panel_dd.setVerticalGroup(
			gl_Panel_dd.createParallelGroup(Alignment.LEADING)
				.addGap(0, 835, Short.MAX_VALUE)
				.addGroup(gl_Panel_dd.createSequentialGroup()
					.addGap(263)
					.addComponent(Pozdrav)
					.addGap(18)
					.addComponent(Dugme_Pocetak, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(483, Short.MAX_VALUE))
		);
		Panel_dd.setLayout(gl_Panel_dd);
		GroupLayout gl_Pocetni_Panel = new GroupLayout(Pocetni_Panel);
		gl_Pocetni_Panel.setHorizontalGroup(
			gl_Pocetni_Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1530, Short.MAX_VALUE)
				.addGroup(gl_Pocetni_Panel.createSequentialGroup()
					.addGap(193)
					.addComponent(Panel_dd, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
					.addGap(1005))
		);
		gl_Pocetni_Panel.setVerticalGroup(
			gl_Pocetni_Panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 835, Short.MAX_VALUE)
				.addGroup(gl_Pocetni_Panel.createSequentialGroup()
					.addGap(0)
					.addComponent(Panel_dd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_Pocetni_Panel.setAutoCreateGaps(true);
		gl_Pocetni_Panel.setAutoCreateContainerGaps(true);
		Pocetni_Panel.setLayout(gl_Pocetni_Panel);

	}

}
