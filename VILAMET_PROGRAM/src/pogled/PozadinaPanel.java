package pogled;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PozadinaPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image pozadina_slika;
    private float prozirnost = 0.8f; // 70% prozirnosti (možeš menjati vrednost)

    // bilo koja slika može da se prosledi putem njene putanje
    public PozadinaPanel(String putanja_slike) {
        pozadina_slika = new ImageIcon(getClass().getResource(putanja_slike)).getImage();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Postavljanje prozirnosti
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, prozirnost));
        g2d.drawImage(pozadina_slika, 0, 0, getWidth(), getHeight(), this);
    }
}
