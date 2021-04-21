import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CasaInteligente
{
    private String morada;
    private Map <String, SmartDevice> devices;
    private Map <String, List<String>> devicesPerDivision;
   
    
    public CasaInteligente()
    {
        this.morada = null;
        devices = new TreeMap<>();
        devicesPerDivision = new TreeMap();
        
    }
    
    public CasaInteligente(String morada, Map<String, SmartDevice> devices, Map<String, List<String>> devicesPerDivision){
       this.morada = morada;
       setDevices(devices);
       setDevicesPerDivision(devicesPerDivision);
       
    
    }
    
    public CasaInteligente(String morada){
        this.morada = morada;
        this.devices = new TreeMap<>();
        this.devicesPerDivision = new TreeMap<>();
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    public Map<String,SmartDevice> getDevices(){
        return devices.values().stream().collect(Collectors.toMap(d->d.getID(),d->d.clone()));
    }
    
    public void setDevices(Map<String,SmartDevice> devices){
        this.devices = new TreeMap<>();
        for(SmartDevice sd : devices.values())
            devices.put(sd.getID(),sd.clone());
        }
        
    public Map<String,List<String>> getDevicesPerDivision(){
        TreeMap<String,List<String>> ret = new TreeMap<>();
        for(Map.Entry<String,List<String>> dpd : devicesPerDivision.entrySet())
            ret.put(dpd.getKey(),new ArrayList<String>(dpd.getValue()));
        return ret;
    }
    
    public void setDevicesPerDivision(Map<String,List<String>> devicesPerDivision){
        this.devicesPerDivision = new TreeMap<>();
        for(Map.Entry<String,List<String>> dpd : devicesPerDivision.entrySet())
            this.devicesPerDivision.put(dpd.getKey(),new ArrayList<String>(dpd.getValue()));
        }
        
    public boolean existsDevice(String device){
        return devices.values().stream().anyMatch(d->d.getID() == device);
    }
    
    public void addDevice(SmartDevice device){
        devices.put(device.getID(), device.clone());
    }
    
    public SmartDevice getDevice(String device){
        return devices.get(device);
    }
    
    public void setAllOn(boolean status){
        for (SmartDevice sd : devices.values())
            sd.setOn(status);
        }
        
    public void addRoom(String room){
        this.devicesPerDivision.put(room, new ArrayList<>());
    }
    
    public boolean hasRoom(String room){
        return this.devicesPerDivision.containsKey(room);
    }
    
    public void addToRoom (String room, String device){
        if(this.devices.containsKey(device) && this.devicesPerDivision.containsKey(room))
            this.devicesPerDivision.get(room).add(device);
            
    }
    
    public boolean roomHasDevice(String room, String device){
        if(this.devicesPerDivision.containsKey(room))
            return this.devicesPerDivision.get(room).contains(device);
        return false;
    }
}
        
        
        
     
    
    
    
    

 
