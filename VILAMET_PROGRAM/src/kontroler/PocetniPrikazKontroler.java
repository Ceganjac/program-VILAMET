package kontroler;

import java.awt.Dimension;
import java.awt.Toolkit;

import pogled.OkvirPrikaza;
import pogled.paneli.PocetniPanel;

public class PocetniPrikazKontroler {
	
	public void pocetniPrikaz() {
		
		System.setProperty("sun.java2d.uiScale", "1.0");

		
		Dimension velicinaEkran = Toolkit.getDefaultToolkit().getScreenSize();
		int screenSirina = velicinaEkran.width;
		int screenVisina = velicinaEkran.height;
		OkvirPrikaza op = new OkvirPrikaza();
		op.setSize(screenSirina-150,screenVisina-200);
		PocetniPanel pp = new PocetniPanel(op.getCLPaneli(), op.getContentPane());
		
		op.add(pp);
		op.setLocationRelativeTo(pp);
		op.setVisible(true);
		
	}
	
	

}
