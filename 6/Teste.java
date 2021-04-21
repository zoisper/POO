
/**
 * Write a description of class Teste here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teste
{
    public static void main(){
        
        
        CasaInteligente casaInte1 = new CasaInteligente("Gualtar");
        SmartBulb smartBul1 = new SmartBulb("b1");
        SmartSpeaker smartSpe1 = new SmartSpeaker("s1");
        SmartSpeaker smartSpe2 = new SmartSpeaker("s2");
        casaInte1.addDevice(smartBul1);
        casaInte1.addDevice(smartSpe1);
        casaInte1.addDevice(smartSpe2);
        casaInte1.addRoom("sala");
        casaInte1.addRoom("quarto");
        casaInte1.addToRoom("sala", "b1");
        casaInte1.addToRoom("sala", "s1");
        casaInte1.addToRoom("quarto", "s2");
        
        
        System.out.println(casaInte1);
        
        CasaInteligente x =  casaInte1.clone();
        System.out.println(x);
        System.out.println(x.equals(casaInte1));
        
        
    }
}
