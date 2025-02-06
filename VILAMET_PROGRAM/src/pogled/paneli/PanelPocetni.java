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

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class PanelPocetni extends JPanel {

	private static final long serialVersionUID = 1L;

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	/**
	 * Create the panel.
	 */
	public PanelPocetni(CardLayout cl, JPanel contentPane) {
		setBackground(Color.WHITE);
		setPreferredSize(screenSize);

		JPanel panelPocetni = new JPanel();
		panelPocetni.setBackground(Color.LIGHT_GRAY);
		panelPocetni.setPreferredSize(screenSize);
		add(panelPocetni);
		

		JPanel panelPocetniDd = new GradientPanel();
		

		// DODAVANJE SVG SLIKE
		//JSVGCanvas canvas = new JSVGCanvas();
		//canvas.setURI(getClass().getResource("/pogled/slike/logo_crveni.svg").toString());
		//canvas.setSize(250, 250);
		//Panel_dd.add(canvas);

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
		GroupLayout gl_panelPocetniDd = new GroupLayout(panelPocetniDd);
		gl_panelPocetniDd.setHorizontalGroup(
			gl_panelPocetniDd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPocetniDd.createSequentialGroup()
					.addGroup(gl_panelPocetniDd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPocetniDd.createSequentialGroup()
							.addGap(84)
							.addComponent(lblDdDobro))
						.addGroup(gl_panelPocetniDd.createSequentialGroup()
							.addGap(47)
							.addComponent(btnDdPocetak, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_panelPocetniDd.setVerticalGroup(
			gl_panelPocetniDd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPocetniDd.createSequentialGroup()
					.addGap(317)
					.addComponent(lblDdDobro)
					.addGap(31)
					.addComponent(btnDdPocetak, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(435, Short.MAX_VALUE))
		);
		panelPocetniDd.setLayout(gl_panelPocetniDd);
		
		JLabel lblPocetniLogo = new JLabel("");
		lblPocetniLogo.setIcon(new ImageIcon(PanelPocetni.class.getResource("/pogled/slike/logo_crveni.png")));
		lblPocetniLogo.setBackground(Color.WHITE);
		GroupLayout gl_panelPocetni = new GroupLayout(panelPocetni);
		gl_panelPocetni.setHorizontalGroup(
			gl_panelPocetni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPocetni.createSequentialGroup()
					.addGap(120)
					.addComponent(panelPocetniDd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(196)
					.addComponent(lblPocetniLogo)
					.addGap(648))
		);
		gl_panelPocetni.setVerticalGroup(
			gl_panelPocetni.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPocetni.createSequentialGroup()
					.addGroup(gl_panelPocetni.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPocetniDd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelPocetni.createSequentialGroup()
							.addGap(287)
							.addComponent(lblPocetniLogo)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		panelPocetni.setLayout(gl_panelPocetni);

	}
}
