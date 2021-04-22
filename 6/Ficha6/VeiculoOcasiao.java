import java.util.ArrayList;
public class VeiculoOcasiao extends Veiculo
{
    private boolean promo;
    
    public VeiculoOcasiao()
    {
        super();
        this.promo = false;
    }

    public VeiculoOcasiao(String marca, String modelo, String matricula,
                   int ano, double velociademedia, double precokm,
                   ArrayList<Integer> classificacao,
                   int kms, int kmsUltimo, boolean promo){
    super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
    this.promo = promo;
}
}
