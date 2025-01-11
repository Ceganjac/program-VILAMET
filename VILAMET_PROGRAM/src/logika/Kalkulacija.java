

package logika;


/**
 *
 * @author Aleksandar
 */
public class Kalkulacija {
   
    private double tara = 0;
    private double tara1 = 0;
    private double tara2 = 0;
    private double neto = 0;
    private double iznos = 0;
    
    // sistem za računanje kada imamo i gajbice 0.4 i 0.5 istovremeno
    // ulaz1 -  broj gajbica od 0.4 kg
    // ulaz2 - broj gajbica od 0.5 kg
    
     
    
    public void kalkulacija1 (int ulaz, double bruto, double cena){
        
        tara = ulaz * 0.4d;
        neto = bruto - tara;
        iznos = neto *(double) cena;
        
    }
    
    public void kalkulacija2 (int ulaz, double bruto, double cena){
        
        tara = ulaz *0.5d;
        neto = bruto - tara;
        iznos = neto * cena;
        
    }

     public void kalkulacija3 (int ulaz1, int ulaz2, double bruto, double cena){
        
       tara1 = ulaz1 *  0.4d;
       tara2 = ulaz2 *  0.5d;
       tara = tara1 + tara2;
       
       neto = bruto - tara;
       iznos = neto *(double) cena;
       
    }

    
    public double getTara(){
       return tara;
    }
    
    public double getNeto(){
        return neto;
    }
    
    public double getIznos(){
        return iznos;
    }
}

