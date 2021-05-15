public class Corrida extends Actividade implements ComDistancia 
{
    private double kmsPercorridos ;
    private double elevacao ;
    private double velocidade ;
    
    public Corrida(){
        super();
        this.kmsPercorridos = 0;
        this.elevacao = 0;
        this.velocidade = 0;
    }
    
    public Corrida(String des, double cal, double kms, double ele, double vel){
        super(des, cal);
        this.kmsPercorridos = kms;
        this.elevacao = ele;
        this.velocidade =vel;
    }
    
    public Corrida(Corrida c){
        super(c);
        this.kmsPercorridos = c.getKmsPercorridos();
        this.elevacao = c.getElevacao();
        this.velocidade =c.getVelocidade();
    }
    
    public double getKmsPercorridos(){
        return this.kmsPercorridos;
    }
    
     public double getElevacao(){
        return this.elevacao;
    }
    
    public double getVelocidade(){
        return this.velocidade;
    }
    
    public Corrida clone(){
        return new Corrida(this);
    }
    
  
    
    
    
    public double caloriasGastas(){
        double result = this.kmsPercorridos * this.getCaloriasPorUnidadeTreino();
        result += this.elevacao * 0.25 * result;
        return result;
    }
    
    

}
