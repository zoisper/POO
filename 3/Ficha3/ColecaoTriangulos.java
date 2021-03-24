import java.util.ArrayList;
import java.util.Iterator;

public class ColecaoTriangulos
{
    private ArrayList<Triangulo> triangulos;
    
    public ColecaoTriangulos(){
        triangulos = new ArrayList<>();
    }
    
    public ColecaoTriangulos (ArrayList<Triangulo> newTriangulos){
        this.setTriangulos(newTriangulos);
    }
    
    public ColecaoTriangulos(ColecaoTriangulos ct){
        this.setTriangulos(ct.getTriangulos());
    }
    
    public void setTriangulos(ArrayList<Triangulo> newTriangulos){
        //this.triangulos = new ArrayList<> (newTriangulos.triangulos);
        this.triangulos = new ArrayList<>();
        for(Triangulo t : newTriangulos)
            this.triangulos.add(t.clone());
    }
    
    public ArrayList<Triangulo> getTriangulos(){
        ArrayList<Triangulo> ret = new ArrayList<Triangulo>();
        for(Triangulo t: this.triangulos)
            ret.add(t.clone());
            return ret;
        }
        
    public void insere (Triangulo t){
        this.triangulos.add(t.clone());
    }
    
    public Triangulo maiorArea(){
        Triangulo r = triangulos.get(0);
        
        for(Triangulo t: triangulos)
            if (t.calculaAreaTriangulo() > r.calculaAreaTriangulo())
                r = t;
         return r.clone();
    }
    
    public boolean triaguloPertence(Triangulo nt){
        boolean found = false;
        Iterator <Triangulo> it = triangulos.iterator();
        
        while(!found && it.hasNext()){
            Triangulo t = it.next();
            if (t.equals(nt))
                found = true;
            }
            return found;
        }
        
    
    
    
}
