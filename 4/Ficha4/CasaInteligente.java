import java.util.ArrayList;
/**
 * Write a description of class CasaInteligente here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CasaInteligente
{
    // instance variables - replace the example below with your own
    private ArrayList<Lampada> lampadas;

    public CasaInteligente (){
        this.lampadas = new ArrayList<Lampada>();
    }
    
    public CasaInteligente (ArrayList<Lampada> lampadas){
        this.setLampadas(lampadas);
    }
    
    public CasaInteligente(CasaInteligente ci){
        this.setLampadas(ci.getLampadas());
    }
    
    public ArrayList<Lampada> getLampadas(){
      ArrayList<Lampada> ret =  new ArrayList<Lampada>();
      for(Lampada l : lampadas)
        ret.add(l.clone());
      return ret;
    }
    
    public void setLampadas(ArrayList<Lampada> lamps){
        this.lampadas = new ArrayList<Lampada>();
        for(Lampada l : lamps)
            this.lampadas.add(l.clone());
    }
    
    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }
    
    public boolean equals(Object o){
        if (o==this) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        CasaInteligente ci = (CasaInteligente) o;
        return ci.getLampadas().equals(this.lampadas);
    }
        
    public String toString (){
        StringBuilder sb = new StringBuilder();
        for(Lampada l : lampadas)
            sb.append(l).append("\n");
        return sb.toString();
    }
    
    public void addLampada(Lampada l){
        this.lampadas.add(l.clone());
    }
    
    public void ligaLampadaNormal(int index){
        if(lampadas.size() > index && index >=0)
            this.lampadas.get(index).lampON(); 
    }
    
    public void ligaLampadaEco(int index){
        if(lampadas.size() > index && index >=0)
            this.lampadas.get(index).lampECO(); 
    }
    
    
    public int qtEmEco(){
        return (int)lampadas.stream().filter(l->l.getModo()==Modo.ECO).count();
        //ou
        //return lampadas.stream().mapToInt(l->{if(l.getModo() == Modo.ECO) return 1; else return 0;}).sum();
    }
    
    public void removeLampada(int index){
        if(lampadas.size()>index && index >=0)
            lampadas.remove(index);
    }
    
    public void ligaTodasEco(){
        lampadas.forEach(l->l.lampECO());
    }
    
    public void ligaTodasMax(){
        lampadas.forEach(l->l.lampON());
    }
    
    
    public double consumoTotal(){
        return lampadas.stream().mapToDouble(l->l.totalConsumo()).sum();
    
    }
    
    public void reset(){
        lampadas.forEach(l->l.setConsumoTotal(0));
    }
        
        
        
        
        
        
    
}
