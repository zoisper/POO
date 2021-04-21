
public class SmartSpeaker extends SmartDevice
{
    public static int MAX = 20;
    
    private String channel;
    private int volume;
    
    public SmartSpeaker()
    {
        super();
        this.channel = "";
        this.volume = 0;
        
    }
    
    public SmartSpeaker(String id){
        super(id);
        this.channel = "";
        this.volume = 0;
    }
    
    public SmartSpeaker(String id, String channel, int volume ){
        super(id);
        this.channel = channel;
        setVolume(volume);
    }
    
    public SmartSpeaker(SmartSpeaker sp){
        super(sp.getID(), sp.getOn());
        this.setChannel(sp.getChannel());
        this.setVolume(sp.getVolume());
    }
    
    public int getVolume(){
        return this.volume;
    }
    
    public void setVolume(int volume){
        if(volume > MAX)
            this.volume = MAX;
        else if (volume <0)
            this.volume = 0;
        else
            this.volume = volume;
    }
    
    public void volumeUp(){
        setVolume(getVolume() +1);
    }
    
    public void volumeDown(){
        setVolume(getVolume() -1);
    }
    
    public String getChannel(){
        return this.channel;
    }
    
    public void setChannel(String channel){
        this.channel = channel;
    }
    
    public boolean equals(Object o){
      if (this == o) return true;
      if (o==null || this.getClass() != o.getClass()) return false;
      SmartSpeaker sp =  (SmartSpeaker) o;
      return super.equals(sp) && this.channel == sp.getChannel() && this.volume == sp.getVolume();
    }
        
        
    
    

}
