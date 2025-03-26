package pogled;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

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

		JPanel pnlPocetni = new JPanel();
		pnlPocetni.setBackground(Color.WHITE);
		pnlPocetni.setPreferredSize(screenSize);
		add(pnlPocetni);

		JPanel pnlPocetniDd = new GradientPanel();

		// DODAVANJE SVG SLIKE
		// JSVGCanvas canvas = new JSVGCanvas();
		// canvas.setURI(getClass().getResource("/pogled/slike/logo_crveni.svg").toString());
		// canvas.setSize(250, 250);
		// Panel_dd.add(canvas);

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
		btnDdPocetak.setFocusable(false);
		btnDdPocetak.setBorder(null);
		btnDdPocetak.setBackground(Color.WHITE);
		GroupLayout gl_pnlPocetniDd = new GroupLayout(pnlPocetniDd);
		gl_pnlPocetniDd.setHorizontalGroup(gl_pnlPocetniDd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPocetniDd.createSequentialGroup()
						.addGroup(gl_pnlPocetniDd.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlPocetniDd.createSequentialGroup().addGap(84).addComponent(lblDdDobro))
								.addGroup(gl_pnlPocetniDd.createSequentialGroup().addGap(47).addComponent(btnDdPocetak,
										GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(47, Short.MAX_VALUE)));
		gl_pnlPocetniDd.setVerticalGroup(gl_pnlPocetniDd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPocetniDd.createSequentialGroup().addGap(317).addComponent(lblDdDobro).addGap(31)
						.addComponent(btnDdPocetak, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(435, Short.MAX_VALUE)));
		pnlPocetniDd.setLayout(gl_pnlPocetniDd);

		JPanel pnlPocetniCentar = new JPanel();
		pnlPocetniCentar.setBackground(Color.WHITE);
		GroupLayout gl_pnlPocetni = new GroupLayout(pnlPocetni);
		gl_pnlPocetni.setHorizontalGroup(gl_pnlPocetni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPocetni.createSequentialGroup().addGap(120)
						.addComponent(pnlPocetniDd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnlPocetniCentar, GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)));
		gl_pnlPocetni.setVerticalGroup(gl_pnlPocetni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPocetni.createSequentialGroup()
						.addGroup(gl_pnlPocetni.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnlPocetniCentar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlPocetniDd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(10, Short.MAX_VALUE)));
		pnlPocetniCentar.setLayout(null);

		JLabel lblCentarLogo = new JLabel("");
		lblCentarLogo.setIcon(new ImageIcon(PocetniPanel.class.getResource("/pogled/slike/logo_crveni.png")));
		pnlPocetni.revalidate();
		pnlPocetni.repaint();
		lblCentarLogo.setBounds(419, 223, 240, 240);
		pnlPocetniCentar.add(lblCentarLogo);

		lblCentarLogo.setBackground(Color.BLACK);
		pnlPocetni.setLayout(gl_pnlPocetni);

	}
}
