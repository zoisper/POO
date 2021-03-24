
import java.util.ArrayList;
public class Stack
{
    private ArrayList<String> valores;
    
    public Stack(){
        valores = new ArrayList<String>();
    }
    
    public Stack(int n){
        valores = new ArrayList<String>(n);
    }
    
    public Stack(Stack s){
        this.valores = new ArrayList<String>();
        /*for(int i = 0; i<s.valores.size(); i++){
            valores.set(i, s.valores.get(i));*/
    for(String str : s.valores){
        this.valores.add(str);
    }
    //ou this.valores = new ArrayList<String>(s.valores);
}

public ArrayList<String> getValores(){
    ArrayList<String> ret = new ArrayList<String>();
    for(String str : this.valores){
        ret.add(str);
    }
    return ret;
}

public void setValores (ArrayList<String> newValores){
    this.valores = new ArrayList<String>();
    for(String str : newValores){
        this.valores.add(str);
    }
}

public Stack clone(){
    return new Stack(this);
}

public boolean equals (Object o){
    if (o == this)
        return true;
    if (o==null || this.getClass() != o.getClass())
        return false;
    Stack s = (Stack) o;
    return this.valores.equals(s.getValores());
}

public String toString(){
    return "Stack: " + this.valores.toString();
}

public int length(){
    return this.valores.size();
}

public boolean empty(){
    return this.valores.isEmpty();
}

public String top(){
    return this.valores.get(this.valores.size()-1);
}

public void push(String s){
    this.valores.add(s);
}

public void pop(){
    if (!empty())
    this.valores.remove(this.valores.size()-1);
}

public String popR(){
    String r = null;
    if (!empty()){
        int indice = this.valores.size()-1;
        r = this.valores.get(indice);
        this.valores.remove(indice);
    }
    return r;
}
    
        

    
    
    
    
    
}
