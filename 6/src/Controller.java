import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class Controller
{
    DriveIt d;
    public Controller(DriveIt d){
        this.d = d;
    }
    
    public boolean existeVeiculo(String matricula){
        return d.existeVeiculo(matricula);
    }
    
    public Veiculo getVeiculo(String matricula) throws VeiculoInexistenteException {
        return d.getVeiculo(matricula);
        
    }
    
    public void guardaEstado(String filename) throws IOException{
        d.guardaEstado(filename);
    }
    
    public void carregaEstado(String filename) throws ClassNotFoundException, IOException{
        d = DriveIt.carregaEstado(filename);
        
    }
    
    public List <String> getMatriculas(){
        return new ArrayList<>(d.getViaturas().keySet());
        
    }
    
    
    

}
