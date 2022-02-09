import java.util.ArrayList;

public class VeiculoPremium extends Veiculo implements BonificaKms{
    
    
    private double taxaLuxo;
    private double pontosPorKm;
    private double pontosAcumulados;
    
    public VeiculoPremium(){
        super();
        this.taxaLuxo = 0;
        this.pontosPorKm = 10;
        this.pontosAcumulados = 0;
    }
    
    public VeiculoPremium(String marca, String modelo, String matricula,
                   int ano, double velociademedia, double precokm,
                   ArrayList<Integer> classificacao,
                   int kms, int kmsUltimo, double taxaLuxo, double pontosPorKm, double pontosAcumulados){
    
                       super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
                       this.taxaLuxo = taxaLuxo;
                       this.pontosPorKm = pontosPorKm;
                       this.pontosAcumulados = pontosAcumulados;
                       
    }
    
    public VeiculoPremium(VeiculoPremium vo){
        super(vo.getMarca(), vo.getModelo(), vo.getMatricula(), vo.getAno(), vo.getVelociademedia(),vo.getVelociademedia(), vo.getClassificacao(), vo.getKms(), vo.getKmsUltimo());
        this.taxaLuxo = vo.getTaxaLuxo();
        this.pontosPorKm = vo.getPontosPorKm();
        this.pontosAcumulados = vo.getPontosAcumulados();
        
    }
    
    
    
    public double custoRealKM(){
        return  getPrecokm()*1.1;
    }
    
    public VeiculoPremium clone(){
        return new VeiculoPremium(this);
    }
    
    public void setTaxaLuxo(double taxaLuxo){
        this.taxaLuxo = taxaLuxo ;
    }
    
    public double getTaxaLuxo(){
        return this.taxaLuxo;
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
    
    public void addViagem(int nkms){
        super.addViagem(nkms);
        this.pontosAcumulados += nkms * this.pontosPorKm;
    }
        
    
    
   
}
