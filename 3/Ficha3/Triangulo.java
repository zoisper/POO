
public class Triangulo
{
    
    private Ponto2D a;
    private Ponto2D b;
    private Ponto2D c;
    
    public Triangulo(){
        this.a = new Ponto2D(0,0);
        this.b = new Ponto2D(1,0);
        this.c = new Ponto2D(0,1);
    }
    
    public Triangulo(Ponto2D a, Ponto2D b, Ponto2D c){
        this.a = a.clone();
        this.b = b.clone();
        this.c = c.clone();
    }
    
    /*
    public Triangulo(int a1, int a2, int b1, int b2, int c1, int c2){
        this.a = new Ponto2D(a1,a2);
        this.b = new Ponto2D(b1,b2);
        this.c = new Ponto2D(c1,c2);
    }*/
    
    public Triangulo(Triangulo t){
        this.a = t.getA();
        this.b = t.getB();
        this.c = t.getC();
    }
    
    public Ponto2D getA(){
        return this.a.clone();
    }
    
    public Ponto2D getB(){
        return this.b.clone();
    }
    
    public Ponto2D getC(){
        return this.c.clone();
    }
    
    public void setA(Ponto2D a){
        this.a = a.clone();
    }
    
    public void setB(Ponto2D b){
        this.b = b.clone();
    }
    
    public void setC(Ponto2D c){
        this.c = c.clone();
    }
    
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Triangulo t = (Triangulo) o;
        return this.a.equals(t.getA()) && this.b.equals(t.getB()) && this.c.equals(t.getC());
    }
    
    public Triangulo clone(){
        return new Triangulo(this);
    }
    
    public String toString (){
        return "A: " + this.getA() + "B: " + this.getB() + "C: " + this.getC();
    }
    
    public double calculaAreaTriangulo(){
        
        double l1 = a.distancia(b);
        double l2 = b.distancia(c);
        double l3 = c.distancia(a);
        double s = (l1+l2+l3)/2;
        double res = Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));
        return res;
    }
    
    public double calculaPerimetroTriangulo(){
        double l1 = a.distancia(b);
        double l2 = b.distancia(c);
        double l3 = c.distancia(a);
        return l1+l2+l3;
    }
    
    public int altura(){
        int min = Math.min(a.getY(),Math.min(b.getY(), c.getY()));
        int max = Math.max(a.getY(),Math.max(b.getY(), c.getY()));
        
        return max - min;
    }
        
        
        
    
        
        
}
