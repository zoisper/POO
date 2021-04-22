import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class DriveIt
{
    Map<String, Veiculo> veiculos;
    
    
    public DriveIt(){
        veiculos = new HashMap<>();
        
    }
    
    public DriveIt(Map<String, Veiculo> veiculos){
        setViaturas(veiculos);
        
    }
    
    public DriveIt(DriveIt di){
        setViaturas(di.getViaturas());
    }
    
    public Map<String, Veiculo> getViaturas(){
        return this.veiculos.values().stream().collect(Collectors.toMap(v->v.getMatricula(), v->v.clone()));
    }
    
    public void setViaturas(Map<String, Veiculo> veiculos){
        this.veiculos = new HashMap<>();
        for(Veiculo v : veiculos.values())
            this.veiculos.put(v.getMatricula(), v.clone());
        }
        
   
    public DriveIt clone(){
        return new DriveIt(this);
    }
    
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DriveIt di = (DriveIt) o;
        return this.veiculos.equals(di.getVeiculos());
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Veiculos: ");
        for(Veiculo v : this.veiculos.values())
            sb.append(v).append(" ");
        return sb.toString();
    }
    
    
    public boolean existeVeiculo(String cod){
        return veiculos.containsKey(cod);
    }
    
    public int quantos(){
        return veiculos.size();
    }
    
    public int quantos(String marca){
        return (int) veiculos.values().stream().filter(v->v.getMarca().equals(marca)).count();
        
    }
    
    public Veiculo getVeiculo(String cod){
        if(veiculos.containsKey(cod))
            return veiculos.get(cod).clone();
        else
            return null;
    }
    
    public void adiciona(Veiculo v){
        //veiculos.put(v.getMatricula(), v.clone());
        veiculos.putIfAbsent(v.getMatricula(), v.clone());
    }
    
    /*
    public List<Veiculo> getVeiculos(){
        return this.veiculos.values().stream().collect(Collectors.toList());
    }*/
    
   public List<Veiculo> getVeiculos(){
       List<Veiculo> r = new ArrayList<>();
       for(Map.Entry<String, Veiculo> e : this.veiculos.entrySet())
        r.add(e.getValue().clone());
        return r;
       
    }
    
   public void adiciona(Set<Veiculo> vs){
       for(Veiculo v : vs)
           this.adiciona(v);
    }
    
    
    
    
        
    
    
    
        
    
    
}
