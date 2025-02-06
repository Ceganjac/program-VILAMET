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

		JPanel Pocetni_Panel = new JPanel();
		Pocetni_Panel.setBackground(Color.LIGHT_GRAY);
		Pocetni_Panel.setPreferredSize(screenSize);
		add(Pocetni_Panel);
		

		JPanel Panel_dd = new GradientPanel();
		

		// DODAVANJE SVG SLIKE
		//JSVGCanvas canvas = new JSVGCanvas();
		//canvas.setURI(getClass().getResource("/pogled/slike/logo_crveni.svg").toString());
		//canvas.setSize(250, 250);
		//Panel_dd.add(canvas);

		JLabel Pozdrav = new JLabel("Добро дошли !");
		Pozdrav.setHorizontalAlignment(SwingConstants.CENTER);
		Pozdrav.setForeground(Color.WHITE);
		Pozdrav.setFont(new Font("Arial", Font.ITALIC, 24));

		JButton Dugme_Pocetak = new JButton("ПОЧЕТАК");

		// ZA HOVER

		Dugme_Pocetak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Dugme_Pocetak.setBackground(Color.black);
				Dugme_Pocetak.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Dugme_Pocetak.setBackground(Color.white);
				Dugme_Pocetak.setForeground(Color.black);

			}
		});

		Dugme_Pocetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "glavni"); // na contentPane(panel) prikaži glavni (panel)
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
				.addGroup(gl_Panel_dd.createSequentialGroup()
					.addGap(317)
					.addComponent(Pozdrav)
					.addGap(31)
					.addComponent(Dugme_Pocetak, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(435, Short.MAX_VALUE))
		);
		Panel_dd.setLayout(gl_Panel_dd);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelPocetni.class.getResource("/pogled/slike/logo_crveni.png")));
		lblLogo.setBackground(Color.WHITE);
		GroupLayout gl_Pocetni_Panel = new GroupLayout(Pocetni_Panel);
		gl_Pocetni_Panel.setHorizontalGroup(
			gl_Pocetni_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Pocetni_Panel.createSequentialGroup()
					.addGap(120)
					.addComponent(Panel_dd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(196)
					.addComponent(lblLogo)
					.addGap(648))
		);
		gl_Pocetni_Panel.setVerticalGroup(
			gl_Pocetni_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Pocetni_Panel.createSequentialGroup()
					.addGroup(gl_Pocetni_Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(Panel_dd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Pocetni_Panel.createSequentialGroup()
							.addGap(287)
							.addComponent(lblLogo)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		Pocetni_Panel.setLayout(gl_Pocetni_Panel);

	}
}
