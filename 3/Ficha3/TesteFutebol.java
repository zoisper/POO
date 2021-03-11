
/**
 * Write a description of class TesteFutebol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TesteFutebol
{
    // instance variables - replace the example below with your own
    public static void main(){
        Futebol jogo1 = new Futebol(0,1,1);
        System.out.println(jogo1);
        Futebol jogo2 = jogo1.clone();
        Futebol jogo3 = new Futebol(1,1,1);
        System.out.println(jogo1.equals(jogo2));
        System.out.println(jogo1.equals(jogo3));
        System.out.println(jogo2);
        jogo2.startGame();
        System.out.println(jogo2);
        jogo2.goloVisitante();
        jogo2.goloVisitado();
        System.out.println(jogo2);
        jogo2.endGame();
        jogo3.endGame();
        System.out.println(jogo2);
        System.out.println(jogo1.equals(jogo2));
        System.out.println(jogo2.equals(jogo3));
}
}
