

/**
 * Classe que implementa um circulo
 */
public class Circulo
{
    // variaveis de instancia
    private double x;
    private double y;
    private double raio;
    
    /**
     * Construtores da classe Circulo
     */

    /**
     * Construtor por omissao
     */
    public Circulo(){
        // initialise instance variables
        this.x = 0;
        this.y = 0;
        this.raio =0;
    }
    
    /**
     * Construtor parametrizado
     */
    public Circulo(double x, double y, double raio){
        
        this.x = x;
        this.y = y;
        this.raio = raio;
    }
    
    /**
     * Construtor de copia
     */
    public Circulo(Circulo c){
        
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }
    /**
     * Metodos de instancia
     */
    
    /**
     * Devolve o valor da coordenada em x do centro
     * 
     * @return valor da coordenada em x do centro
     */
    public double getX(){
        return this.x;
    }
    
    /**
     * Devolve o valor da coordenada em y do centro
     * 
     * @return valor da coordenada em y do centro
     */
    public double getY(){
        return this.y;
    }
    
    /**
     * Devolve o valor do raio
     * 
     * @return valor do raio
     */
    public double getRaio(){
        return this.raio;
    }
    
    /**
     * Atualiza o valor da coordenada em x do centro
     * 
     * @param x novo valor da coordenada em x do centro
     */
    public void setX(double x){
        this.x = x;
    }
    
     /**
     * Atualiza o valor da coordenada em y do centro
     * 
     * @param y novo valor da coordenada em y do centro
     */
    public void setY(double y){
        this.y = y;
    }
    
    /**
     * Atualiza o valor do raio
     * 
     * @param raio novo valor do raio
     */
    public void setRaio(double raio){
        this.raio = raio;
    }
    
    /**
     * Metodo que altera o valor das coordenadas x e y do centro
     * 
     * @param x novo valor da coordenada em x do centro
     * @param y novo valor da coordenada em y do centro
     */
    public void alteraCentro (double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Metodo que calcula a area do circulo
     * 
     * @return a area do circulo calculada
     */
    public double calculaArea(){
        return Math.PI * Math.pow(this.raio,2);
    }
    
    /**
     * Metodo que calcula o perimetro do circulo
     * 
     * @return o perimetro do circulo calculado
     */
    public double calculaPerimetro(){
        return Math.PI * this.raio * 2;
    }
    
    /**
     * Reescrita do metodo equals que todos os objectos possuem
     * 
     * @param o objecto que e comparado com o recetor da mensagem
     * @return boolean o resultado da compracao entre os dois objectos 
     */
    public boolean equals(Object o){
        if(this == o)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        Circulo c = (Circulo) o;
        return (this.x == c.x && this.y == c.y && this.raio == c.raio);
    }
    
    /**
     * Metodo que devolve a representacao em String do Circulo
     * 
     * @return String com as coordenadas x, y e raio 
     */
    public String toString(){
        return "Cx = " + this.x + "  Cy = " + this.y + "  Raio = " + this.raio;
    }
    
    /**
     * Metodo que cria uma copia do objeto circulo
     * 
     * @return Circulo clone do Circulo que recebe a mensagem
     */
    public Circulo clone(){
        return new Circulo (this);
    }
        

    
}
