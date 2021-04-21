
/**
 * Write a description of class SmartDevice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SmartDevice
{
    private String id;
    private boolean status;
    
  public SmartDevice(){
      this.id = "";
      this.status = false;
  }
  
  public SmartDevice(String id){
      this.id = id;
      this.status = false;
  }
  
  public SmartDevice(String id, Boolean status){
      this.id = id;
      this.status = status;
  }
  
  public SmartDevice (SmartDevice sd){
      this.id = sd.getID();
      this.status = sd.getOn();
    }
  
  public String getID(){
      return this.id;
  }
  
  public void setID(String nome){
      this.id = id;
  }
  
  public boolean getOn(){
      return this.status;
  }
  
  public void setOn(Boolean status){
      this.status = status;
  }
  
  public SmartDevice clone(){
      return new SmartDevice(this);
    }
    
  public boolean equals (Object o){
      if (this == o) return true;
      if (o==null || this.getClass() != o.getClass()) return false;
      SmartDevice sd =  (SmartDevice) o;
      return (sd.getID() == this.id && sd.getOn() == this.status);
    }
    
    
    
 
  
    
    
  
      
      
      

   
}
