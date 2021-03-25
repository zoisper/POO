
/**
 * Write a description of class TesteCasaInteligente here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TesteCasaInteligente
{
    // instance variables - replace the example below with your own
    public static void main(){
        Lampada l1 = new Lampada(5, 2, State.ON );
        Lampada l2 = new Lampada(10, 3, State.OFF );
        CasaInteligente ci = new CasaInteligente();
        ci.addLampada(l1);
        ci.addLampada(l2);
        System.out.println(ci);
        
        ci.ligaLampadaNormal(0);
        ci.ligaLampadaEco(1);
        System.out.println(ci);
        
        ci.ligaTodasEco();
        System.out.println(ci);
        System.out.println(ci.qtEmEco());
        
        ci.ligaTodasMax();
        System.out.println(ci);
        System.out.println(ci.qtEmEco());
        
        ci.removeLampada(0);
        System.out.println(ci);
        
    }
}
