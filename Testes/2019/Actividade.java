import java.io.Serializable;

public abstract class Actividade implements Serializable, Comparable<Actividade>
{
    private String designacao ;
    private double caloriasPorUnidadeTreino ; // calorias por unidade de treino
    
    
    public Actividade(){
        this.designacao = "";
        this.caloriasPorUnidadeTreino = 1;
    }
    
    public Actividade(String des, double cal){
        this.designacao = des;
        this.caloriasPorUnidadeTreino = cal;
    }
    
    public Actividade(Actividade a){
        this.designacao = a.getDesignacao();
        this.caloriasPorUnidadeTreino = a.getCaloriasPorUnidadeTreino();
    }
    
    public String getDesignacao(){
        return this.designacao;
    }
    
    public double getCaloriasPorUnidadeTreino(){
        return this.caloriasPorUnidadeTreino;
    }
    
    public void setDesignacao(String des){
        this.designacao = des;
    }
    
    public void setCaloriasPorUnidadeTreino(double cpt){
        this.caloriasPorUnidadeTreino = cpt;
    }
    
    public abstract Actividade clone();
    
    public int compareTo(Actividade a){
       return  (int) (this.caloriasGastas() - a.caloriasGastas());
    }
    
    
    
    public abstract double caloriasGastas (); // o consumo de calorias depende de cada actividade especı́fica
}
