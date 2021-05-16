import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.time.LocalDate;
import java.util.Arrays;

public class Teste
{
    public static void main(){
        Corrida c = new Corrida("Corrida",4,5,1,1);
        Eliptica e = new Eliptica("Eliptica", 4,5,1,1);
        /*Exercicio e1 = new Exercicio(c, "Paul", "1");
        Exercicio e2 = new Exercicio(e, "Paul", "1");
        ArrayList <Exercicio> a = new ArrayList<>();
        a.add(e1);
        a.add(e2);
        LocalDate ld = LocalDate.now();
        LocalDate l1 = LocalDate.now();
        TreeMap< LocalDate , List <Exercicio> > tm = new TreeMap<>();
        tm.put(ld,a);
        Cliente cliente = new Cliente("Tiago", "1", tm);
        TreeMap< String , Cliente > mg = new TreeMap<>();
        System.out.println(cliente.getExerciciosData(l1));
        
        
        mg.put(cliente.getCodCliente(),cliente.clone());
        GinasioPOO gym = new GinasioPOO(mg);
        try{    
            System.out.println(gym.totalKmsCliente(cliente.getCodCliente(),ld));
        }catch(ClienteNaoExiste | ExercicioInexistente exc){
            System.out.println(exc.getMessage());
        }
        
        //System.out.println(gym.existeProfessor("Paul"));
        //System.out.println(cliente.exerciciosPorProf());
        System.out.println(gym.professorMaisExigente());
        */
       
       GrowingArrayOfActividade gaa = new GrowingArrayOfActividade();
       gaa.add(c);
       gaa.add(e);
       //System.out.println(gaa.getLista()[0]);
       //System.out.println(gaa.getLista()[1]);
       //System.out.println(gaa.getLista()[2]);
       Actividade [] a = gaa.getLista();
       System.out.println(a);
       Arrays.binarySearch(a,c);
       
        
        
    }
}
