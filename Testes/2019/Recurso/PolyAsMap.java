import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public class PolyAsMap implements Poly
{
   private Map<Integer, Double> monomios;

    
    public PolyAsMap()
    {
        Comparator<Integer> comparador = (x,y) -> y-x;
        monomios = new TreeMap<>(comparador);
    }
    
    
    public void addMonomio ( int grau , double coeficiente ){
        this.monomios.put(grau, coeficiente);
    }
    
    public double calcula(double x){
        double result = 0;
        for(Map.Entry<Integer, Double> e : monomios.entrySet())
            result += (Math.pow(x,e.getKey()) * e.getValue());
        return result;

    }
    
    public String toString (){
        StringBuilder sb = new StringBuilder();
        Iterator<Entry<Integer, Double>> it = monomios.entrySet().iterator();
        Entry<Integer, Double> e;
        while(it.hasNext()){
            e = it.next();
            sb.append(e.getValue()).append("x^").append(e.getKey());
            if(it.hasNext())
                sb.append(" ");
            else
                sb.append('.');
        }
        return sb.toString();
    }
    

  
}
