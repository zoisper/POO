import java.util.ArrayList;

public class AutocarroInteligente extends Veiculo implements BonificaKms{
    
    private boolean promocao;
    private double pontosPorKm;
    private double pontosAcumulados;
    
    public AutocarroInteligente(){
        super();
        this.pontosPorKm = 10;
        this.pontosAcumulados = 0;
        this.promocao = false;
    }
    
    public AutocarroInteligente(String marca, String modelo, String matricula,
                   int ano, double velociademedia, double precokm,
                   ArrayList<Integer> classificacao,
                   int kms, int kmsUltimo, boolean promocao, double pontosPorKm, double pontosAcumulados){
    
                       super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
                       this.promocao = promocao;
                       this.pontosPorKm = pontosPorKm;
                       this.pontosAcumulados = pontosAcumulados;
    }
    
    public AutocarroInteligente(AutocarroInteligente vo){
        super(vo);
        this.pontosPorKm = vo.getPontosPorKm();
        this.pontosAcumulados = vo.getPontosAcumulados();
        this.promocao = vo.getPromocao();
    }
    
    public boolean getPromocao(){
        return this.promocao;
    }
    
    public void setPromocao(boolean p){
        this.promocao = p;
    }
    
    
    public double custoRealKM(){
        return getPrecokm()*1.1;
}

    public AutocarroInteligente clone (){
        return new AutocarroInteligente(this);
    }
    
    public void setPontosPorKm(double x){
        this.pontosPorKm = x;
    }
    
    public double getPontosPorKm(){
        return this.pontosPorKm ;
    }
    
    public double getPontosAcumulados(){
        return this.pontosAcumulados;
    }
   
}
