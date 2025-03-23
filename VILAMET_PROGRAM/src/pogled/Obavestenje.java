package pogled;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Obavestenje {

	// KLASA JE NAMENJENA KREIRANJU OBAVEŠTENJA(PORUKA) BILO KOG TIPA KOJA SE
	// DOBIJAJU NAKON NEKE AKCIJE KORISNIKA

	public static int prikaziPoruku(String poruka, TipObavestenja tip) {
		
		// Prilagođavanje izgleda poruke: boje, font ...
		 UIManager.put("OptionPane.background", new Color(153,255,153));
		 UIManager.put("Panel.background", new Color(153,255,153));
		 UIManager.put("Button.background",Color.white);
		 UIManager.put("Button.foreground", Color.black);
		 UIManager.put("Button.focusable", false);

		
		int tipBr;
		String tipTxt = null;
		// Tekst koji će bit na dugmadima
		String[] opcije = new String[2];
		opcije[0]="Затвори";
		
		switch (tip) {
		case USPEH:
			tipBr = JOptionPane.INFORMATION_MESSAGE;
			tipTxt = "ИНФРМАЦИЈА";
			break;
		case GRESKA:
			tipBr = JOptionPane.ERROR_MESSAGE;
			tipTxt = "ГРЕШКА";
			break;
		case UPOZORENJE:
			tipBr = JOptionPane.WARNING_MESSAGE;
			tipTxt = "УПОЗОРЕЊЕ";
			break;
		case UPITNIK:
			tipBr = JOptionPane.QUESTION_MESSAGE;
			tipTxt = "УПИТНИК";
			opcije[0]="Да";
			opcije[1]="Не";
			break;
		default:
			tipBr = JOptionPane.PLAIN_MESSAGE;
		}
		

        // Pozivanje JOptionPane sa prilagođenim dugmadi, ali ignorišemo povratnu vrednost
      return   JOptionPane.showOptionDialog(
                null, 
                poruka, 
                tipTxt, 
                JOptionPane.YES_NO_OPTION, 
                tipBr, 
                null, 
                opcije, 
                opcije[0] // Predefinisano dugme
        );
	}

	
}
