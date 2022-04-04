import java.util.Scanner;
import java.util.Arrays;



public class TestePrograma
{
    private static Scanner sc;
    
    public static void main ()
    {
    
        sc = new Scanner(System.in);
        
        
        //Exercicio 1
        /*Ex1 f = new Ex1();
        
        System.out.println("Insira quanto valores quer ler: ");
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
        int[] copiado = f.arrayEntre(valores, inicio,fim);
        
        int[] c = lerArray();
        System.out.println("Array antes: " + Arrays.toString(c));
        f.sort(c);
        System.out.println("Array depois: " + Arrays.toString(c));
        System.out.println("Insira um valor a procurar");
        int aProcurar =  sc.nextInt();
        int indice = f.binarySearch(c,aProcurar);
        System.out.println("Indice no qual o valor foi encontrado: " + indice);
        f.sort(c);*/
        
        Ex2 ex2 = new Ex2 ();
        
        int [][] notasTurma = {
                                {20,18,15,16,14},
                                { 7, 5, 14,17,19},
                                {12,10,15,17, 4},
                                {20,19,17,18,19},
                                { 3,15, 7, 8,13}
                            };
                            
        //showPauta(notasTurma);
        
        //Exercicio 2
        ex2.atualizaPauta(notasTurma);
        
        System.out.println(ex2);
        
        System.out.println(ex2.mediaAluno(1));
        System.out.println(ex2.mediaUC(1));
        System.out.println(ex2.notaMaisAlta(1));
        showArray(ex2.notasMaisAltas());
        System.out.println();
        System.out.println(ex2.notaMaisBaixa(1));
        showArray(ex2.notasMaisBaixas());
        System.out.println();
        showArray(ex2.notasAcimaDeAluno(12,2));
        System.out.println();
        showArray(ex2.notasAcimaDe(19));
        System.out.println();
        System.out.println(ex2.ucMediaMaisAlta());
        
        
        
       
                                
                         
        
        
        
        
        
        
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
    
    public static void showArray(int[] a)
    {
        for(int x : a)
            System.out.print(x + " ");
    }
    
    public static void showPauta (int pauta[][])
    {
        for (int i =0; i< pauta.length; i++)
        {
            for(int j =0; j<pauta[i].length; j++)
                System.out.print(pauta[i][j] + " ");
            
            System.out.println();
            
        }
    
    }
    
    
    
}
