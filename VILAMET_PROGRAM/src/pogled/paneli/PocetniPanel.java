package pogled.paneli;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import pogled.GradientPanel;
import pogled.PozadinaPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PocetniPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	/**
	 * Create the panel.
	 */
	public PocetniPanel(CardLayout cl, JPanel contentPane) {
		setBackground(Color.WHITE);
		setPreferredSize(screenSize);

		JPanel pnlPocetni = new PozadinaPanel("/pogled/slike/pozadina1.png");
		pnlPocetni.setBackground(Color.WHITE);
		pnlPocetni.setPreferredSize(screenSize);

		JPanel pnlPocetniDd = new GradientPanel();
		pnlPocetniDd.setOpaque(false);
		JLabel lblDdDobro = new JLabel("Добро дошли !");
		lblDdDobro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDdDobro.setForeground(Color.WHITE);
		lblDdDobro.setFont(new Font("Arial", Font.ITALIC, 24));

		JButton btnDdPocetak = new JButton("ПОЧЕТАК");

		// ZA HOVER

		btnDdPocetak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDdPocetak.setBackground(Color.black);
				btnDdPocetak.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDdPocetak.setBackground(Color.white);
				btnDdPocetak.setForeground(Color.black);

			}
		});

		btnDdPocetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "glavni"); // na contentPane(panel) prikaži glavni (panel)
			}
		});
		btnDdPocetak.setForeground(Color.BLACK);
		btnDdPocetak.setFont(new Font("Arial", Font.BOLD, 12));
		btnDdPocetak.setBorder(null);
		btnDdPocetak.setFocusable(false);
		btnDdPocetak.setBackground(Color.WHITE);

		JLabel lblCentarLogo = new JLabel("");
		lblCentarLogo.setIcon(new ImageIcon(PocetniPanel.class.getResource("/pogled/slike/logo crveni.png")));
		lblCentarLogo.setBackground(Color.BLACK);

		GroupLayout gl_pnlPocetniDd = new GroupLayout(pnlPocetniDd);
		gl_pnlPocetniDd.setHorizontalGroup(gl_pnlPocetniDd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPocetniDd.createSequentialGroup().addGroup(gl_pnlPocetniDd
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlPocetniDd.createSequentialGroup().addGap(165).addComponent(lblDdDobro,
								GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlPocetniDd.createSequentialGroup().addGap(181).addComponent(btnDdPocetak,
								GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlPocetniDd.createSequentialGroup().addGap(180).addComponent(lblCentarLogo)))
						.addContainerGap(164, Short.MAX_VALUE)));
		gl_pnlPocetniDd.setVerticalGroup(gl_pnlPocetniDd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPocetniDd.createSequentialGroup().addGap(330)
						.addComponent(lblDdDobro, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE).addGap(37)
						.addComponent(btnDdPocetak, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(88).addComponent(lblCentarLogo).addContainerGap(95, Short.MAX_VALUE)));
		pnlPocetniDd.setLayout(gl_pnlPocetniDd);
		GroupLayout gl_pnlPocetni = new GroupLayout(pnlPocetni);

		// Kako bi panel pnlPocetniDd bio centriran horizontalno
		gl_pnlPocetni.setHorizontalGroup(gl_pnlPocetni.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
				.addComponent(pnlPocetniDd, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 0, Short.MAX_VALUE));

		gl_pnlPocetni.setVerticalGroup(gl_pnlPocetni.createParallelGroup(Alignment.LEADING).addComponent(pnlPocetniDd,
				GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE));

		pnlPocetni.revalidate();
		pnlPocetni.repaint();
		pnlPocetni.setLayout(gl_pnlPocetni);
		GroupLayout groupLayout = new GroupLayout(this);

		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlPocetni,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(pnlPocetni,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		setLayout(groupLayout);

	}
}
