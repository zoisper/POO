import java.io.Serializable;

public class Exercicio implements Serializable {
    private Actividade actividade ;
    private String professor ;
    private String codExercicio;
    
    public Exercicio(){
        this.actividade = null;
        this.professor = "";
        this.codExercicio = "";
    }
    
    public Exercicio(Actividade act, String prof, String codE){
        this.actividade = act.clone();
        this.professor = prof;
        this.codExercicio = codE;
    }
    
    public Exercicio(Exercicio e){
        this.actividade = e.getActividade();
        this.professor = e.getProfessor();
        this.codExercicio = e.getCodExercicio();
    }
    
    
    public Actividade getActividade(){
        if (actividade != null)
            return this.actividade.clone();
        return null;
    }
    
    public String getProfessor(){
        return this.professor;
    }
    
    public String getCodExercicio(){
        return this.codExercicio;
    }
    
    public void setActividade(Actividade a){
        this.actividade = a.clone();
    }
    
    public void setProfessor(String prof){
        this.professor = professor;
    }
    
    public void setCodExercicio(String codE){
        this.codExercicio = codE;
    }
    
    public Exercicio clone(){
        return new Exercicio(this);
    }
    
    public double caloriasGastas(){
        return this.actividade.caloriasGastas();
    }
    
    

}
