
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    
    public static void main(){
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
        v.run();
        
        try{
            d.guardaEstado("estado.dat");
        }
        catch (IOException e){
            System.out.println("Nao foi possivel criar o ficheiro dat " + e.toString());
        }
    
       
    }
    
    
}
  
    

