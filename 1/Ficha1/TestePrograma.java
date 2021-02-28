import java.util.Scanner;
public class TestePrograma
{
    public static void main (String [] args){
    Scanner sc = new Scanner(System.in);
    Ficha1 f =  new Ficha1();
    
    //Exercio 1
    
    System.out.println("Insira um valor em graus");
    double graus = sc.nextDouble();
    double convertido = f.celsiusParaFarenheit(graus);
    System.out.println("Esse valor em Farenheit e " + convertido);
    
   
   System.out.println("Insira dois valores");
   int a = sc.nextInt();
   int b = sc.nextInt();
   System.out.println("O maior valor entre " + a + " e " + b + " e " + f.maximoNumeros( a, b));
   
  
  System.out.println("Insira valor em euros: ");
  double valor = sc.nextDouble();
  System.out.println("Insira Taxa de Convercao: ");
  double taxa = sc.nextDouble();
  System.out.println("Valor em libras: " + f.eurosParaLibras(valor, taxa));
  
 
 System.out.println("Insira dois valores ");
    a = sc.nextInt();
    b = sc.nextInt();
    System.out.println( f.ordMedia(a,b));
   
  
  int x = Integer.parseInt(args[0]);
  System.out.println("Factorial de: " + x + " = " + f.factorial(x));
  
  System.out.println("Tempo de Execucao de factorial(5000) = " + f.tempoGasto());
  
  sc.close();
  
  
    
    
    
     }
    
}
