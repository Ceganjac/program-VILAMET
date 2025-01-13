package pogled;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PozadinaPanel extends JPanel {

	private Image pozadina_slika;

	// bilo koja slika može da se prosledi putem njene putanje
	public PozadinaPanel(String putanja_slike) {
		pozadina_slika = new ImageIcon(getClass().getResource(putanja_slike)).getImage();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pozadina_slika, 0, 0, getWidth(), getHeight(), this);

	}

}
