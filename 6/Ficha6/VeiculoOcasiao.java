import java.util.ArrayList;

public class VeiculoOcasiao extends Veiculo
{
    private boolean promo;
    
    public VeiculoOcasiao()
    {
        super();
        this.promo = false;
    }

    public VeiculoOcasiao(String marca, String modelo, String matricula,int ano, double velociademedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, boolean promo){
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
    this.promo = promo;
}

    public VeiculoOcasiao(VeiculoOcasiao vo){
        super(vo.getMarca(), vo.getModelo(), vo.getMatricula(), vo.getAno(), vo.getVelociademedia(), vo.getPrecokm(), vo.getClassificacao(), vo.getKms(),
        vo.getKmsUltimo());
        this.promo = vo.getPromo(); 
    }
    
    public boolean getPromo(){
        return this.promo;
    }
    
    public void setPromo(boolean promo){
        this.promo = promo;
    }
    
    public double custoRealKM(){
        double valor = getPrecokm()*1.1;
        if(this.promo)
            valor*= 0.75;
        return valor;
}
    
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        VeiculoOcasiao vo = (VeiculoOcasiao) o;
        return super.equals(vo) && this.promo == vo.promo;
    }
    
    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" Em promoçao: ").append(this.promo);
        return sb.toString();
    }
  }
        
