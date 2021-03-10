
/**
 * Write a description of class TesteCirculo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TesteCirculo
{
    public static void main(){
        Circulo c1 = new Circulo();
        Circulo c2 = new Circulo(3,3,3);
        Circulo c3 = new Circulo(c2);
        Circulo c4 = c3.clone();
        System.out.println(c4);
        System.out.println(c4.calculaArea());
        System.out.println(c4.calculaPerimetro());
        System.out.println(c2.equals(c3));
        System.out.println(c3.equals(c3));
        System.out.println(c2.equals(c4));
        System.out.println(c3.equals(c4));
        System.out.println(c1.equals(c4));
        
    }
        
        
    
}
