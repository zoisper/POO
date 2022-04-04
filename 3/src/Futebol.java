

/**
 * Write a description of class Futebol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Futebol
{
    // instance variables - replace the example below with your own
    private int estado;
    private int scoreHome;
    private int scoreAway;
    
    public Futebol(){
        this.estado = 0;
        this.scoreHome = 0;
        this.scoreAway = 0;
    }
    
    public Futebol(int estado, int scoreH, int scoreA){
        this.estado = estado;
        if(estado == 1){
            this.scoreHome = scoreH;
            this.scoreAway = scoreA;
        }
    }
    
    public Futebol(Futebol jogo){
        this(jogo.getEstado(), jogo.getScoreHome(), jogo.getScoreAway());
    }
    
    public int getEstado(){
        return this.estado;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public int getScoreHome(){
        return this.scoreHome;
    }
    
    public void setScoreHome(int score){
        this.scoreHome = score;
    }
    
    public int getScoreAway(){
        return this.scoreAway;
    }
    public void setScoreAway(int score){
        this.scoreAway = score;
    }
    
    public String toString(){
        String aux;
        switch(this.estado){
            case 0: aux = "Por Iniciar.";
                    break;
            case 1: aux = "A Decorrer.";
                    break;
            case 2: aux = "Terminado.";
                    break;
            default: aux = "Estado Invalido";
        }
        if(this.estado == 0)
            return aux;
        else
            return aux +  " Resultado: "+ this.getScoreHome() + " - " + this.getScoreAway();
    }
    
    public Futebol clone(){
        return new Futebol(this);
    }
    
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Futebol f = (Futebol) o;
        return (this.estado == f.getEstado() && this.scoreHome == f.getScoreHome() && this.scoreAway == f.getScoreAway());
    }
            
    
    public void startGame(){
        if(this.estado == 0)
            this.setEstado(1);
    }
    
    public void endGame(){
        if(this.estado == 1)
            this.setEstado(2);
    }
    
    public void goloVisitado(){
        if(this.estado == 1)
            this.scoreHome +=1;
    }
    
    public void goloVisitante(){
        if(this.estado == 1)
            this.scoreAway +=1;
    }
    
    public String resultadoActual(){
        return "Visitado: " + this.getScoreHome() + "Visitante: " + this.getScoreAway();
    }
    
    
    
    
    
            
    
}

