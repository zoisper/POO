import java.util.*;
import java.util.stream.Collectors;

public class Grafo {

    private Map<String, Set<String >> adj;

    public Grafo (){
        this.adj = new HashMap<>();
    }

    public Grafo(Map<String, Set<String >> adj){
        this.adj = adj.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->new HashSet<>(e.getValue())));
    }

    public void addArco(String vOrig, String vDest){
        this.adj.putIfAbsent(vOrig, new HashSet<>());
        this.adj.putIfAbsent(vDest, new HashSet<>());
        this.adj.get(vOrig).add(vDest);
    }

    public boolean isSink(String v){
        return this.adj.containsKey(v) && this.adj.get(v).isEmpty();

    }

    public int size(){
        int result = 0;
        for(Map.Entry<String, Set<String >> me : adj.entrySet())
            result += 1 + me.getValue().size();
        return  result;
    }

    public int sizeComStream(){
        return this.adj.size() + this.adj.values().stream().mapToInt(v->v.size()).sum();
    }

    public boolean haCaminhoAux(String vOrig, String vDest, List<String> visitados){
        visitados.add(vOrig);
        if(vOrig.equals(vDest)) return true;
        for(String o : adj.get(vOrig)){
            if(!visitados.contains(o) && (haCaminho(o, vDest)))
                    return true;
        }
        return false;
    }

    public boolean haCaminho(String vOrig, String vDest) {
        if (!this.adj.containsKey(vOrig)) return false;
        return haCaminhoAux(vOrig, vDest, new ArrayList<String>());
    }

    public Set<Map.Entry<String, String>> fanOut (String v){
        HashSet<Map.Entry<String, String>> ret = new HashSet<>();
        for (String dest : this.adj.get(v))
            ret.add(new AbstractMap.SimpleEntry<>(v,dest));

        return ret;

    }

}
