
public class SmartBulb extends SmartDevice
{
    
    
    public static final int COLD = 0;
    public static final int NEUTRAL = 1;
    public static final int WARM = 2;
    
    private int hue;
   
    public SmartBulb()
    {
        super();
        this.hue = NEUTRAL;
    }
    
    public SmartBulb(String id){
        super(id);
        this.hue = NEUTRAL;
    }
    
    public SmartBulb(String id, int h){
        super(id);
        setTone(h);
    }
    
    
    public SmartBulb(String id, boolean status, int h){
        super(id, status);
        setTone(h);
    }
    
    public SmartBulb(SmartBulb sb){
        super(sb.getID(), sb.getOn());
        this.setTone(sb.getTone());
    }
    
    public int getTone(){
        return this.hue;
    }
    
    public void setTone(int h){
        if(h ==1)
            this.hue = NEUTRAL;
        else if (h>1)
            this.hue = WARM;
        else
            this.hue = COLD;
    }
    
    public SmartBulb clone(){
        return new SmartBulb(this);
    }
    
    public boolean equals(Object o){
      if (this == o) return true;
      if (o==null || this.getClass() != o.getClass()) return false;
      SmartBulb sb = (SmartBulb) o;
      return super.equals(sb) && this.hue == sb.getTone();
    }
    
    public String toString(){
        String h;
        if (this.hue == COLD) h = "Frio";
        else if(this.hue == NEUTRAL) h = "Neutro";
        else h = "Quente";
        
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\nTonalidade: ").append(h);
        return sb.toString();
    }
        
    
    
    
    

    
}
