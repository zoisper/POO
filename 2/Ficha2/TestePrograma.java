import java.util.Scanner;
import java.util.Arrays;



public class TestePrograma
{
    private static Scanner sc;
    
    public static void main ()
    {
    
        
        Ficha2 f = new Ficha2();
        sc = new Scanner(System.in);
        /*System.out.println("Insira quanto valores quer ler: ");
        int nValores = sc.nextInt();
        int[] valores = new int[nValores];
        for(int i =0; i<nValores; i++){
            System.out.println("Insira Valor: ");
            valores[i] = sc.nextInt();
        }
        
        int minValor = f.minimo_Array(valores);
        System.out.println("Minimo = " + minValor);
        
        System.out.println("Indique o indice inicical a partir do qual copiar");
        int inicio = sc.nextInt();
        System.out.println("Indique o indice final a partir do qual copiar");
        int fim = sc.nextInt();
        int[] copiado = f.arrayEntre(valores, inicio,fim);*/
        
        int[] c = lerArray();
        System.out.println("Array antes: " + Arrays.toString(c));
        f.sort(c);
        System.out.println("Array depois: " + Arrays.toString(c));
        System.out.println("Insira um valor a procurar");
        int aProcurar =  sc.nextInt();
        int indice = f.binarySearch(c,aProcurar);
        System.out.println("Indice no qual o valor foi encontrado: " + indice);
        f.sort(c);
        
        sc.close();
        
    }
    
        public static int[] lerArray(){
        System.out.println("Insira quantos valores quer ler");
        int nValores = sc.nextInt();
        int[] valores = new int[nValores];
        for(int i=0; i<valores.length; i++){
            System.out.println("Insira valor");
            valores[i] = sc.nextInt();
        }
        
        return valores;
        
    }
    
    
    
    
}
