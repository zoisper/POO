import java.io.Serializable;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.time.LocalDate;


public class GinasioPOO implements Serializable {
    private Map < String , Cliente > clientes ;
    
    public GinasioPOO(){
        this.clientes = new TreeMap<>();
    }
    
    public GinasioPOO(Map < String , Cliente > c){
        this.setClientes(c);
    }
    
    public GinasioPOO(GinasioPOO g){
        this.setClientes(g.getClientes());
    }
    
    public Map < String , Cliente > getClientes(){
        return clientes.values().stream().collect(Collectors.toMap(c->c.getNome(), c->c.clone()));
    }
    
    public void setClientes(Map < String , Cliente > c){
        this.clientes = new TreeMap<>();
        for(Map.Entry<String, Cliente> e : c.entrySet())
            this.clientes.put(e.getKey(), e.getValue().clone());
    }
    
    public double valorTotalCaloriasGastas(String codCliente) throws ClienteNaoExiste{
        if (!clientes.containsKey(codCliente))
            throw new ClienteNaoExiste("Cliente Nao Existe");
        return clientes.get(codCliente).caloriasGastas();
        
    }
    
    public double totalKmsCliente ( String codCliente , LocalDate dataExercicio ) throws ClienteNaoExiste , ExercicioInexistente{
        if(!clientes.containsKey(codCliente))
            throw new ClienteNaoExiste("Cliente Nao Existe");
        Cliente cliente = clientes.get(codCliente);
        if (!cliente.getMeusExercicios().containsKey(dataExercicio))
            throw new ExercicioInexistente("Exercicio Nao Existe");
        List<Exercicio> exercicios = cliente.getMeusExercicios().get(dataExercicio);
        double result = 0;
        for (Exercicio e : exercicios){
            if(e.getActividade() instanceof ComDistancia ){
                ComDistancia cd = (ComDistancia) e.getActividade();
                result += cd.getKmsPercorridos();
            }
        }
        return result;
          
        
    }
    
    public boolean existeProfessor(String prof){
        for (Cliente cliente : clientes.values()){
            for(List<Exercicio> exercicios : cliente.getMeusExercicios().values()){   
                for (Exercicio exercicio : exercicios)
                    if (exercicio.getProfessor().equals(prof))
                        return true;
            }
    }
    return false;
}

    public String professorMaisExigente(){
        TreeMap<String,Double> caloriasPorProf = new TreeMap<>();
        for (Cliente cliente : clientes.values()){
            for(Map.Entry<String,List<Exercicio>> epf: cliente.exerciciosPorProf().entrySet()){
                if (!caloriasPorProf.containsKey(epf.getKey()))
                    caloriasPorProf.put(epf.getKey(),0.0);
                double calorias = epf.getValue().stream().mapToDouble(e->e.caloriasGastas()).sum();
                double anterior = caloriasPorProf.get(epf.getKey());
                caloriasPorProf.put(epf.getKey(), calorias + anterior);
        }
           
    }
    String result = null;
    double maior = 0.0;
    for(Map.Entry<String, Double> cpf : caloriasPorProf.entrySet()){
        if (cpf.getValue() > maior){
            maior = cpf.getValue();
            result = cpf.getKey();
        }
    }
    
    return result;
}
}
