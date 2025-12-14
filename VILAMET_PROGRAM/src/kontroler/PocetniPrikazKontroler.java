package kontroler;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import pogled.OkvirPrikaza;
import pogled.paneli.OtkupPanel;
import pogled.paneli.PocetniPanel;

public class PocetniPrikazKontroler {
	
	public void pocetniPrikaz() {
		
		System.setProperty("sun.java2d.uiScale", "1.0");

		Dimension velicinaEkran = Toolkit.getDefaultToolkit().getScreenSize();
		int ekranSirina = velicinaEkran.width;
		int ekranVisina = velicinaEkran.height;
		PocetniPanel pocetniPanel = new PocetniPanel();

		// kreiranje frejma
		OkvirPrikaza op = new OkvirPrikaza(pocetniPanel);
		op.setSize(ekranSirina-150,ekranVisina-200);
		op.setLocationRelativeTo(null);
		op.setVisible(true);
		
	}
	
	

}
