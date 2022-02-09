import java.io.Serializable;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GrowingArrayOfActividade implements Serializable {
// variáveis de inst^a ncia
    private Actividade [] lista ;
    private int tamanho ;
    
    public GrowingArrayOfActividade(){
        this.lista = new Actividade[10];
        this.tamanho = 0;
    }
    
    
    public Actividade get(int indice) throws Exception{
    
        if (lista.length <=indice)
            throw new Exception("Limites Ultrapassdos");
        return lista[indice].clone();
    }
    
    public void add(Actividade a){
        if(tamanho == lista.length){
            
        Actividade[] novo = new Actividade[lista.length*2];
        System.arraycopy(lista,0, novo,0,this.tamanho);
        this.lista = novo;
        }
        this.lista[tamanho] = a.clone();
        this.tamanho += 1;
        
    }
    
    public Actividade[] getLista(){
        Actividade[] result = new Actividade[lista.length];
        for (int i = 0; i<this.tamanho; i++)
            result[i] = lista[i].clone();
        return result;
    }
    
    public static GrowingArrayOfActividade leGrowingArrayOfActividade(String fich) throws ClassNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(fich);
        ObjectInputStream ois = new ObjectInputStream(fis);
        GrowingArrayOfActividade g = (GrowingArrayOfActividade) ois.readObject();
        ois.close();
        return g;
        
    }
    
    
  
}