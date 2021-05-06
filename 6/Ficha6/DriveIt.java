import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class DriveIt implements Serializable
{
    private Map<String, Veiculo> veiculos;
    private Map<String, Comparator<Veiculo>> comparadores;
    
    
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
    
    public Set<Veiculo> ordenarVeiculos(){
        Set<Veiculo> ret = new TreeSet<Veiculo>();
        for(Veiculo v: veiculos.values()){
            ret.add(v.clone());
        }
        
        return ret; 
    }
    
    public List<Veiculo> ordenarVeiculosL(){
        return veiculos.values().stream().map(Veiculo::clone).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
    
    /* ou
    public List<Veiculo> ordenarVeiculosL(){
        Set<Veiculo> s = veiculos.values().stream().map(v->v.clone()).collect(Collectors.toCollection(TreeSet::new));
        List<Veiculo> ret = new ArrayList<>(s);
        return ret; 
    }*/
    
    /* ou
    public List<Veiculo> ordenarVeiculosL(){
        return new ArrayList<Veiculo>(ordenarVeiculos()); 
    }*/
    
    /* ou
    public List<Veiculo> ordenarVeiculosL(){
        List<Veiculo> r = new ArrayList<>();
        for (Veiculo v : veiculos.values())
            r.add(v.clone());
        r.sort(Comparator.naturalOrder());    
        return r; 
    }*/
    
    
    
    public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c){
        return veiculos.values().stream().map(Veiculo::clone).collect(Collectors.toCollection(()-> new TreeSet<>(c)));
    }
    
    /* ou
    public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c){
        Set<Veiculo> ret = new TreeSet<Veiculo>(c);
        for(Veiculo v: veiculos.values()){
            ret.add(v.clone());
        }
        
        return ret; 
    }*/
    
    public Comparator<Veiculo> compNumKms(){
        Comparator<Veiculo> c = (v1, v2) -> v1.getKms() - v2.getKms();
        return c;
        
    }
    
    
    
    public Iterator<Veiculo> ordenarVeiculo(String criterio){
        Comparator <Veiculo> c;
        if (comparadores.containsKey(criterio))
            c = comparadores.get(criterio); 
        else
            c = Comparator.naturalOrder();
        Set<Veiculo> ordenados = this.ordenarVeiculos(c);
        
        return ordenados.iterator();
    }
    
    public void exemploUsoIterators(){
        Iterator<Veiculo> it = ordenarVeiculo("criterio1");
        boolean found = false;
        while(it.hasNext() && !found){
            Veiculo v = it.next();
            if(v.getMarca().equals("Audi")) found = true;
        }
    }
    
    public Veiculo veiculoComMenosKm(){
        Veiculo v =  veiculos.values().stream().sorted((v1, v2) ->  v1.getKms() - v2.getKms()).findFirst().orElse(null);
        if(v!= null) v = v.clone();
        return v;
    }
    
    public Map<String,List<Veiculo>> agrupadosPorMarca(){
        Map<String, List<Veiculo>> r = new HashMap<>();
        for(Veiculo v : veiculos.values()){
            r.putIfAbsent(v.getMarca(), new ArrayList<>());
            r.get(v.getMarca()).add(v.clone());
        }
        for(List<Veiculo> l : r.values()){
            l.sort((v1,v2) -> v1.getKms() - v2.getKms());
        }
        return r;
            
        
    }
    
    /*
    public List<BonificaKms> daoPontos(){
        List<BonificaKms> r = new ArrayList<>();
        for(Veiculo v : veiculos.values()){
            if(v instanceof BonificaKms)
                r.add((BonificaKms) v.clone());   
        }
        return r;  
    }*/
    
    public List<BonificaKms> daoPontos(){
        return veiculos.values().stream().filter(v -> v instanceof BonificaKms).map(v-> (BonificaKms) v.clone()).collect(Collectors.toList());
        
    }
    
    
    
    public void toCSV(String filename) throws IOException{
        PrintWriter fich = new PrintWriter(filename);
        for(Veiculo v : veiculos.values())
            fich.println(v.toString());
            
       fich.flush();
       fich.close();
        
    }
    
   public void guardaEstado(String filename) throws IOException{
       FileOutputStream fos = new FileOutputStream(filename);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       oos.writeObject(this);
       oos.flush();
       oos.close();
 
       
    }
    
    public static DriveIt carregaEstado(String filename) throws IOException, ClassNotFoundException{
        FileInputStream fs = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fs);
        DriveIt d = (DriveIt) ois.readObject();
        ois.close();
        return d;
    }
    
    
    
    
    
        
    
    
    
        
    
    
}
