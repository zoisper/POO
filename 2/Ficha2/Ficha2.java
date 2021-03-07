import java.util.Arrays;

public class Ficha2
{
    public int minimo_Array(int[] a){
    
      int min = a[0];
      for(int i =1; i<a.length; i++)
          if(a[i] < min)
              min = a[i];
        
    return min;
    }
    
    public int[] arrayEntre(int[] a, int b, int c)
    {
        int [] result = new int[c-b+1];
        for(int i=0; i<(c-b+1); i++)
            result[i] = a[b+i];
        
            return result;
    }
    
    public int[] comuns(int[] a, int[] b){
        int[] res = new int[Math.min(a.length, b.length)];
        int indice = 0;
        for(int va :a ){
            for(int vb : b){
                if(va == vb && pertence(va, res))
                    res[indice++] = va;
            }
        }
        int[] resCortado = new int[indice];
        System.arraycopy(res, 0, resCortado, 0, indice);
        return resCortado;
    }
    
    private boolean pertence (int x, int[] a){
    boolean r = false;
    for(int i =0; i<a.length && !r; i++)
        if (a[i] == x)
            r = true;
    return r;
    }
    
    public void sort(int[] v){
        Arrays.sort(v);
        
    }
    
    public int binarySearch (int[] v, int x){
        return Arrays.binarySearch(v, x);
    }
    
    
    
   
}
