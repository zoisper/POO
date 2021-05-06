
import java.util.ArrayList;
import java.io.IOException;

public class Main
{
    public static void main(){
        
        DriveIt d = new DriveIt();
        Veiculo v1 = new VeiculoPremium("Ford","Focus", "11-BB-11", 1999, 40.0, 10.0,
                    new ArrayList<>(), 50000, 100, 2.0, 5.0, 37000);
        Veiculo v2 = new VeiculoPremium("Opel","Corsa", "00-AA-00", 1999, 40.0, 10.0,
                    new ArrayList<>(), 50000, 100, 2.0, 5.0, 37000);
        
                    d.adiciona(v1);
                    d.adiciona(v2);
        try{
            d.toCSV("veiculos.csv");
    }
    catch (IOException e){
        System.out.println("Nao foi possivel criar o ficheiro csv");
    }
    
    try{
            d.guardaEstado("estado.dat");
    }
    catch (IOException e){
        System.out.println("Nao foi possivel criar o ficheiro dat " + e.toString());
    }
    
    try{
        DriveIt d2 = DriveIt.carregaEstado("estado.dat");
        System.out.println(d2);
    }
    catch (IOException | ClassNotFoundException e){
        System.out.println("Nao foi ler o ficheiro dat " + e.toString());
    }
    
        
    
    
    
}
}
