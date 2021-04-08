import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class EncEficiente here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EncEficiente
{
    // instance variables - replace the example below with your own
    private String nomeCliente;
    private int nif;
    private String morada;
    private int numEncomenda;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> encomendas;
    
    public EncEficiente(){
        this.nomeCliente = null;
        this.nif = -1;
        this.morada = null;
        this.numEncomenda = -1;
        this.data = LocalDate.now();
        this.encomendas = new ArrayList<LinhaEncomenda>();
    }
    
    public EncEficiente(String nomeCliente, int nif, String morada, int numEncomenda, LocalDate data, ArrayList<LinhaEncomenda> encomendas){
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.numEncomenda = numEncomenda;
        this.data = data;
        setEncomendas(encomendas);
    }
    
    public EncEficiente(EncEficiente enc){
        this.nomeCliente = enc.getNomeCliente();
        this.nif = enc.getNif();
        this.morada = enc.getMorada();
        this.numEncomenda = enc.getNumEncomenda();
        this.data = enc.getData();
        this.encomendas = enc.getEncomendas();
    }
    
    public String getNomeCliente(){
        return this.nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public int getNif(){
        return this.nif;
    }
    
    public void setNif(int nif){
        this.nif = nif;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    public int getNumEncomenda(){
        return this.numEncomenda;
    }
    
    public void setNumEncomenda(int numEncomenda){
        this.numEncomenda = numEncomenda;
    }
    
    public LocalDate getData(){
        return this.data;
    }
    
    public void setData (LocalDate data){
        this.data = data;
    }
    
    public ArrayList<LinhaEncomenda> getEncomendas(){
        Iterator<LinhaEncomenda> it = this.encomendas.iterator();
        ArrayList<LinhaEncomenda> ret = new ArrayList<LinhaEncomenda>();
        LinhaEncomenda le;
        while(it.hasNext()){
            le = it.next();
            ret.add(le.clone());
        }
        return ret;
    }
        
    
    public void setEncomendas(ArrayList<LinhaEncomenda> encomendas){
        Iterator<LinhaEncomenda> it = encomendas.iterator();
        this.encomendas = new ArrayList<LinhaEncomenda>();
        LinhaEncomenda le;
        while(it.hasNext()){
            le = it.next();
            this.encomendas.add(le.clone());
        }
        
    }
    
    public EncEficiente clone(){
        return new EncEficiente(this);
    }
    
    public boolean equals(Object o){
        if (o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        EncEficiente ef = (EncEficiente) o;
        return ef.getNomeCliente() == this.nomeCliente && ef.getNif() == this.nif && ef.getMorada() == this.morada 
               && ef.getNumEncomenda() == this.numEncomenda && ef.getData() == this.data && ef.getEncomendas().equals(encomendas);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Cliente: ").append(this.nomeCliente ).append(" | Nif: ").append(this.nif).append(" | Morada: ").append(this.morada);
        sb.append(" | Numero da Encomenda: ").append(this.numEncomenda).append(" | Data: ").append(this.data).append("\nLinhas da Encomenda:");
 
        for(LinhaEncomenda le : this.encomendas)
            sb.append("\n").append(le);
        return sb.toString();
    }
    
    public double calculaValorTotal(){
        return encomendas.stream().mapToDouble(e->e.calculaValorLinhaEnc()).sum();
    }
    
    public double calculaValorDesconto(){
        return encomendas.stream().mapToDouble(e->e.calculaValorDesconto()).sum();
    }
    
    public int numeroTotalProdutos(){
        return encomendas.stream().mapToInt(e->e.getQuantidade()).sum();
    }
    
    public boolean existeProdutoEncomenda(String refProduto){
        return encomendas.stream().anyMatch(e->e.getReferencia() == refProduto);
    }
    
    public void adicionaLinha(LinhaEncomenda linha){
        this.encomendas.add(linha.clone());
    }
    
    public void removeProduto(String codProd){
        this.encomendas.removeIf(e->e.getReferencia() == codProd);
    }
        
        
    
    
        

    
}
