import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
public class GestaoEncomenda {

 private Map<Integer, EncEficiente> encomendas;

 public GestaoEncomenda(){
     encomendas = new TreeMap<>();

 }

 public GestaoEncomenda(Map<Integer, EncEficiente> e) {
     encomendas = new TreeMap<>();
     for (EncEficiente enc : e.values()) {
         encomendas.put(enc.getNumEncomenda(), enc.clone());
     }
 }

 public GestaoEncomenda(GestaoEncomenda ge){
     encomendas = new TreeMap<>();
     for(Map.Entry<Integer, EncEficiente> enc : ge.getEncomendas().entrySet()) {
         encomendas.put(enc.getKey(), enc.getValue().clone());
     }
 }

 public Map<Integer, EncEficiente> getEncomendas(){
     return encomendas.values().stream().collect(Collectors.toMap(e->e.getNumEncomenda(), e->e.clone()));
 }

 public void setEncomendas(Map<Integer, EncEficiente>e) {
     encomendas = new TreeMap<Integer, EncEficiente>();
     for (EncEficiente enc : e.values())
         encomendas.put(enc.getNumEncomenda(), enc.clone());
 }

 public boolean equals(Object o){
     if(this ==o) return true;
     if(o==null || this.getClass() != o.getClass()) return false;
     GestaoEncomenda ge = (GestaoEncomenda) o;
     return this.encomendas.equals(ge.getEncomendas());

 }

 public GestaoEncomenda clone(){
     return  new GestaoEncomenda(this);
 }

 public String toString(){
     StringBuilder sb = new StringBuilder();
     for(EncEficiente e : encomendas.values())
         sb.append(e.toString()).append("\n");
     return sb.toString();
 }

 //ex1

    public  Set<Integer> todosCodigosEnc(){
     Set<Integer> ret =  encomendas.keySet();
     return new TreeSet<Integer>(ret);
    }
    // ex2

    public void addEncomenda(EncEficiente enc){
     encomendas.put(enc.getNumEncomenda(), enc.clone());
    }
    //ex3
    public EncEficiente getEncomenda(Integer codEnc){
        EncEficiente ret =  encomendas.get(codEnc);
     if(ret != null) ret = ret.clone();
     return ret;
    }
//ex4

    public void removeEncomenda(Integer codEnc){
     encomendas.remove(codEnc);
    }

    //ex5

    public int encomendaComMaisProdutos(){
        Comparator<EncEficiente> comparador = (e1, e2) -> e1.numeroTotalProdutos() - e2.numeroTotalProdutos();
        TreeSet<EncEficiente> ordena = new TreeSet<EncEficiente>(comparador);
        for(EncEficiente enc : encomendas.values())
            ordena.add(enc);
        return ordena.last().getNumEncomenda();
    }

    //ex6

    public Set<Integer> encomendasComProduto(String codProduto){
     return encomendas.values()
             .stream()
             .filter(e->e.existeProdutoEncomenda(codProduto))
             .map(EncEficiente::getNumEncomenda)
             .collect(Collectors.toSet());
    }

    public Set<Integer> encomendasAposData(LocalDate d) {
        return encomendas.values().
                stream().
                filter(e -> e.getData().isAfter(d))
                .map(EncEficiente::getNumEncomenda)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<EncEficiente> encomendasValorDecrescente(){
     Comparator<EncEficiente> comparator = (e1,e2) -> (int) (100* e2.calculaValorTotal() - e1.calculaValorTotal());
     TreeSet<EncEficiente> ordena = new TreeSet<EncEficiente>(comparator);
     for(EncEficiente enc : encomendas.values())
         ordena.add(enc.clone());
     return ordena;

    }



}

