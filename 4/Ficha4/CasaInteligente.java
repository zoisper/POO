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
        setLampadas(lampadas);
    }
    
    public CasaInteligente(CasaInteligente ci){
        setLampadas(ci.getLampadas());
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
        if(lampadas.size() > index){
            Lampada l = lampadas.get(index);
            l.lampON();
            lampadas.set(index, l);
        }
    }
    
    public void ligaLampadaEco(int index){
        if(lampadas.size() > index){
            Lampada l = lampadas.get(index);
            l.lampECO();
            lampadas.set(index, l);
        }
    }
    
    public int qtEmEco(){
        return (int)lampadas.stream().filter(l->l.getState()==State.ECO).count();
    }
    
    public void removeLampada(int index){
        if(lampadas.size()>index)
            lampadas.remove(index);
    }
    
    public void ligaTodasEco(){
        lampadas.forEach(l->l.lampECO());
    }
    
    public void ligaTodasMax(){
        lampadas.forEach(l->l.lampON());
    }
    
    /*
    public double consumoTotal(){
        return lampadas.stream().mapToDouble(l->l.totalConsumo()).sum();
    
    }*/
    /*
    public void reset(){
        lampadas.forEach(l->l.reset());
    }*/
        
        
        
        
        
        
    
}
