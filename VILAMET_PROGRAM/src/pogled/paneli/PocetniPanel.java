package pogled.paneli;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import pogled.GradientPanel;
import pogled.PozadinaPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PocetniPanel extends PozadinaPanel {

	private static final long serialVersionUID = 1L;

	// UZIMANJE DIMENZIJA EKRANA
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenSirina = screenSize.width;
	int screenVisina = screenSize.height;

	public PocetniPanel(CardLayout cl, JPanel contentPane) {
		super("/pogled/slike/pozadina1.png");  // Postavlja se pozadinska slika

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(screenSirina - 200, screenVisina - 150));

		JPanel pnlPocetni = new GradientPanel();
		pnlPocetni.setOpaque(false);

		JLabel lblPocetniDobro = new JLabel("Добро дошли !");
		lblPocetniDobro.setHorizontalAlignment(SwingConstants.CENTER);
		lblPocetniDobro.setForeground(Color.WHITE);
		lblPocetniDobro.setFont(new Font("Arial", Font.ITALIC, 24));

		JButton btnPocetniPocetak = new JButton("ПОЧЕТАК");
		btnPocetniPocetak.setForeground(Color.BLACK);
		btnPocetniPocetak.setFont(new Font("Arial", Font.BOLD, 12));
		btnPocetniPocetak.setBorder(null);
		btnPocetniPocetak.setFocusable(false);
		btnPocetniPocetak.setBackground(Color.WHITE);

		btnPocetniPocetak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPocetniPocetak.setBackground(Color.black);
				btnPocetniPocetak.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPocetniPocetak.setBackground(Color.white);
				btnPocetniPocetak.setForeground(Color.black);
			}
		});

		btnPocetniPocetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "glavni");
			}
		});

		JLabel lblPocetniLogo = new JLabel("");
		lblPocetniLogo.setIcon(new ImageIcon(PocetniPanel.class.getResource("/pogled/slike/logo crveni.png")));
		lblPocetniLogo.setBackground(Color.BLACK);

		// Layout za pnlPocetni
		GroupLayout gl_pnlPocetni = new GroupLayout(pnlPocetni);
		gl_pnlPocetni.setHorizontalGroup(
			gl_pnlPocetni.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_pnlPocetni.createSequentialGroup()
					.addGap(0, 124, Short.MAX_VALUE)
					.addGroup(gl_pnlPocetni.createParallelGroup(Alignment.CENTER)
						.addComponent(lblPocetniDobro, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPocetniPocetak, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPocetniLogo))
					.addGap(0, 125, Short.MAX_VALUE))
		);

		gl_pnlPocetni.setVerticalGroup(
			gl_pnlPocetni.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlPocetni.createSequentialGroup()
					.addContainerGap(330, Short.MAX_VALUE)
					.addComponent(lblPocetniDobro, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnPocetniPocetak, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addComponent(lblPocetniLogo)
					.addGap(121))
		);

		pnlPocetni.setLayout(gl_pnlPocetni);

		// Layout za this panel
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(600)
					.addComponent(pnlPocetni, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
					.addGap(600))
		);

		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlPocetni, GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
		);

		setLayout(groupLayout);
	}
}
