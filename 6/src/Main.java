
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    
    public static void main(String[] args){
        
        Veiculo v = new VeiculoPremium();
        System.out.println(v instanceof Veiculo);
        System.out.println(v instanceof BonificaKms);
        System.out.println(v instanceof VeiculoPremium);
        System.out.println(v.getClass().getSimpleName());
        System.out.println();
        BonificaKms b = new VeiculoPremium();
        System.out.println(b instanceof Veiculo);
        System.out.println(b instanceof BonificaKms);
        System.out.println(b instanceof VeiculoPremium);
        System.out.println(b.getClass().getSimpleName());
        
        System.out.println();
        VeiculoOcasiao vo = new VeiculoOcasiao();
        System.out.println(vo instanceof Veiculo);
        System.out.println(vo instanceof BonificaKms);
        
        System.out.println(vo.getClass().getSimpleName());
        
        /*
        DriveIt d;
        try{
            d = DriveIt.carregaEstado("estado.dat");
            System.out.println("Estado carregado com sucesso");
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Nao foi possivel ler o ficheiro do estado!");
            d = new DriveIt();
        }
        Controller c = new Controller(d);
        View v = new View(c);
        //v.run();
        
        try{
            d.guardaEstado("estado.dat");
        }
        catch (IOException e){
            System.out.println("Nao foi possivel criar o ficheiro dat " + e.toString());
        }*/
    
       
    }
    
    
}
  
    

