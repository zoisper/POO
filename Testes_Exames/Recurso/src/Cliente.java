import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Cliente implements Serializable {
    private String nome;
    private String codCliente;
    private Map < LocalDate , List <Exercicio> > meusExercicios;
    
    public Cliente(){
        this.nome = "";
        this.codCliente = "";
        this.meusExercicios = new TreeMap<>();
    }
                                                                    
    public Cliente(String nome, String cod, Map < LocalDate , List <Exercicio> > meusExercicios){
        this.nome = nome;
        this.codCliente = cod;
        setMeusExercicios(meusExercicios);
    }
    
    public Cliente(Cliente c){
        this.nome = c.getNome();
        this.codCliente = c.getCodCliente();
        setMeusExercicios(c.getMeusExercicios());
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCodCliente(){
        return this.codCliente;
    }
    
    public List<Exercicio> getExerciciosData(LocalDate ld){
       if(meusExercicios.containsKey(ld))
            return meusExercicios.get(ld).stream().map(e->e.clone()).collect(Collectors.toList());
       
       return null;
    }
    
    public Map <LocalDate, List <Exercicio>> getMeusExercicios(){
        TreeMap <LocalDate, List<Exercicio>> ret = new TreeMap<>();
        for(Map.Entry<LocalDate, List<Exercicio>> e : meusExercicios.entrySet())
            ret.put(e.getKey(),getExerciciosData(e.getKey())); 
        return ret;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCodCliente(String codCliente){
        this.codCliente = codCliente;
    }
    
    public void setMeusExercicios(Map < LocalDate , List <Exercicio>> me){
        this.meusExercicios = new TreeMap<LocalDate, List<Exercicio>>();
        for(Map.Entry<LocalDate, List<Exercicio>> e : me.entrySet()){
            this.meusExercicios.put(e.getKey(),new ArrayList<>(e.getValue()));
            //this.meusExercicios.put(e.getKey(),getExerciciosData(e.getKey()));
        }
            
        
    }
    
    public double caloriasGastas(){
        double result = 0;
        for (Map.Entry<LocalDate,List <Exercicio>> me: meusExercicios.entrySet())
            result += me.getValue().stream().mapToDouble(e->e.caloriasGastas()).sum();
        return result;
    }
    
    public Cliente clone(){
        return new Cliente(this);
    }
    
    public Map<String, List<Exercicio>> exerciciosPorProf(){
        Map<String, List<Exercicio>> ret = new TreeMap<>();
        for(List<Exercicio> exercicios : meusExercicios.values()){
            for(Exercicio exercicio : exercicios){
                if(!ret.containsKey(exercicio.getProfessor()))
                    ret.put(exercicio.getProfessor(), new ArrayList<Exercicio>());
               ret.get(exercicio.getProfessor()).add(exercicio.clone());
            }
        }
        return ret;
    }
    
    
    
    

}
