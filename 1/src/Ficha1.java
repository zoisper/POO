import java.time.LocalDateTime;


public class Ficha1
{
  public double celsiusParaFarenheit(double graus){
    double r = (graus * (9/5) + 32);
    return r;
    }

    public int maximoNumeros( int a, int b){
        return Math.max(a,b);
    
    
    }
    
    public int minimoNumeros( int a, int b){
    return Math.min(a,b);
    
    }
    
     public double mediaNumeros( int a, int b){
        return (a+b)/2.0;
    
    }
    

    
  public String criaDescricaoConta( String nome, double saldo){
    return "Nome: " + nome + ", saldo: " + saldo; 
    
    }
    
    public double eurosParaLibras( double valor, double taxaConversao){
    return valor * taxaConversao;
    
    }
    
    public String ordMedia(int a,int b){

       if (a > b) return a + ","+ b + "; Media: " + ((a+b)/2.0);

       else return b + "," + a + "; Media: " + ((a+b)/2.0);
    }
    
    public long factorial( int num){
    if (num == 0)
        return 1;
    else
        return num * factorial(num-1);
    }
    
    public long tempoGasto(){
    
        
        long before = System.currentTimeMillis();
        factorial(500);
        long after = System.currentTimeMillis();
        return after - before;
    
    }
 
}
