import java.util.ArrayList;
import java.util.List;

public class PolyAsList implements Poly{

    private List<Double> polinomio;


    public PolyAsList(){
        this.polinomio = new ArrayList<>();
    }

    public PolyAsList (ArrayList<Double> lista){
        this.polinomio = new ArrayList<>(lista);

    }


    public void addMonomio ( int grau , double coef ) {
        if (this.polinomio.size()<= grau) {
            for (int i = this.polinomio.size(); i < grau; i++) {
                polinomio.add(0.0);
            }
            this.polinomio.add(coef);
        }
        else this.polinomio.set(grau, coef);
    }
    public double calcula ( double x ){
        double result = 0;
        for(int i = 0; i<this.polinomio.size(); i++)
            result += polinomio.get(i) * Math.pow(x,i);
        return result;
    }
    public int grau (){
        return this.polinomio.size();
    }
    public PolyAsList derivada (){
        ArrayList<Double> r =  new ArrayList();
        for (int i=1; i<this.polinomio.size(); i++)
            r.add(this.polinomio.get(i)*i);
        return new PolyAsList(r);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = polinomio.size()-1; i>=0; i--){
            sb.append(polinomio.get(i)).append("x^").append(i);
            if (i>0)
                sb.append(" + ");
        }
        return  sb.toString();
    }

}
