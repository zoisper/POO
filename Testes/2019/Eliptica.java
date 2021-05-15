public class Eliptica extends Actividade implements ComDistancia {
    private double kmsPercorridos ;
    private double nivelEsforco ;
    private double minutos ;
    
    public Eliptica(){
        super();
        this.kmsPercorridos = 0;
        this.nivelEsforco = 0;
        this.minutos = 0;
    }
    
    public Eliptica(String des, double cal, double kms, double niv, double min){
        super(des, cal);
        this.kmsPercorridos = kms;
        this.nivelEsforco = niv;
        this.minutos = min;
    }
    
    public Eliptica(Eliptica e){
        super(e);
        this.kmsPercorridos = e.getKmsPercorridos();
        this.nivelEsforco = e.getNivelEsforco();
        this.minutos = e.getMinutos();
    }
    
    public double getKmsPercorridos(){
        return this.kmsPercorridos;
    }
    
     public double getNivelEsforco(){
        return this.nivelEsforco;
    }
    
    public double getMinutos(){
        return this.minutos;
    }
    
    public Eliptica clone(){
        return new Eliptica(this);
    }
    
  
    
    public double caloriasGastas(){
        double result = this.kmsPercorridos * this.getCaloriasPorUnidadeTreino();
        result += this.minutos * 0.20 * result;
        if(nivelEsforco >4)
            result += this.minutos * 0.5 * result * (nivelEsforco-4);
            
        return result;
    }

}
