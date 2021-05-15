
public class Abdominais extends Actividade {
    private int numeroRepeticoes ;
    private String tipoExercicio ;
    
    
    public Abdominais(){
        super();
        this.numeroRepeticoes = 0;
        this.tipoExercicio = "";
    }
    
    public Abdominais (String des, double cal, int numR, String te){
        super(des, cal);
        this.numeroRepeticoes = numR;
        this.tipoExercicio = te;
    }
    
    public Abdominais(Abdominais a){
        super(a);
        this.numeroRepeticoes = a.getNumeroRepeticoes();
        this.tipoExercicio = a.getTipoExercicio();
    }
    
    public int getNumeroRepeticoes(){
        return this.numeroRepeticoes;
    }
    
     public String getTipoExercicio(){
        return this.tipoExercicio;
    }
    
    public Abdominais clone(){
        return new Abdominais(this);
    }
    
    public double caloriasGastas(){
        return this.numeroRepeticoes * getCaloriasPorUnidadeTreino();
    }
    
    

}
