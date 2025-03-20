package pogled;

import javax.swing.JPanel;

import pogled.AkcijePanel;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AkcijePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnIzbrisi;
	private JButton btnPrikazi;
	private JButton btnIzmeni;

	/**
	 * Create the panel.
	 */

	public AkcijePanel() {

		setSize(75, 25);

		btnIzbrisi = new JButton("");
		btnIzbrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIzbrisi.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnIzbrisi.setBackground(Color.white);

			}
		});
		btnIzbrisi.setBounds(50, 0, 25, 25);
		btnIzbrisi.setBackground(Color.WHITE);
		btnIzbrisi.setIcon(new ImageIcon(AkcijePanel.class.getResource("/pogled/slike/bin.png")));
		btnIzbrisi.setOpaque(false);
		btnIzbrisi.setBorder(null);

		btnPrikazi = new JButton("");
		btnPrikazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPrikazi.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPrikazi.setBackground(Color.white);
			}
		});
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrikazi.setBounds(25, 0, 25, 25);
		btnPrikazi.setBackground(Color.WHITE);
		btnPrikazi.setIcon(new ImageIcon(AkcijePanel.class.getResource("/pogled/slike/search-file.png")));
		btnPrikazi.setOpaque(false);
		btnPrikazi.setBorder(null);


		btnIzmeni = new JButton("");
		btnIzmeni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIzmeni.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnIzmeni.setBackground(Color.white);

			}
		});
		btnIzmeni.setBounds(0, 0, 25, 25);
		btnIzmeni.setBackground(Color.WHITE);
		btnIzmeni.setIcon(new ImageIcon(AkcijePanel.class.getResource("/pogled/slike/pen.png")));
		btnIzmeni.setOpaque(false);
		btnIzmeni.setBorder(null);


		setLayout(null);
		add(btnIzbrisi);
		add(btnPrikazi);
		add(btnIzmeni);

	}

	// Vraćanje dugmadi

	public JButton getBtnIzbrisi() {
		return btnIzbrisi;
	}

	public JButton getBtnPrikazi() {
		return btnPrikazi;
	}

	public JButton getBtnIzmeni() {
		return btnIzmeni;
	}

}
