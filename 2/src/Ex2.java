
public class Ex2
{
    private int[][] notasTurma;
    
    public Ex2()
    {
        this.notasTurma = new int[5][5];
        
    }
    
    
    
    public void atualizaNota(int[] notasAluno, int pos)
    {
        System.arraycopy(notasAluno, 0, this.notasTurma[pos],0,notasAluno.length);
        
    }
    
    public void atualizaPauta(int [][] notasAlunos)
    {
        for(int i =0; i<notasAlunos.length; i++)
            atualizaNota( notasAlunos[i], i);
       }
       
    public int[][] getNotasTurma()
    {
        
        return this.notasTurma.clone();
    }
    
 
    
    public double mediaAluno(int pos)
    {
        int soma =0;
        for(int nota : notasTurma[pos])
            soma += nota;
        return 1.0*soma/notasTurma[pos].length;
    }
    
    public double mediaUC(int pos){
        int soma = 0;
        for (int[] aluno : notasTurma)
            soma += aluno[pos];
        return 1.0*soma/notasTurma.length;
    }
    
    public int notaMaisAlta (int uc){
    int result = 0;
    for(int[] aluno : notasTurma)
        if (aluno[uc] > result)
            result = aluno[uc];
    return result;
        
    }
    
    public int[] notasMaisAltas ()
    {
        int [] result = new int[notasTurma.length];
        for(int i=0; i<notasTurma.length; i++)
            result[i] = notaMaisAlta(i);
        return result;
    }
    
    public int notaMaisBaixa (int uc){
    int result = 20;
    for(int[] aluno : notasTurma)
        if (aluno[uc] < result)
            result = aluno[uc];
    return result;
        
    }
    
     public int[] notasMaisBaixas ()
    {
        int [] result = new int[notasTurma.length];
        for(int i=0; i<notasTurma.length; i++)
            result[i] = notaMaisBaixa(i);
        return result;
    }
    
    public int[] notasAcimaDeAluno(int valor, int uc)
    {
        int[] aux = new int[notasTurma[uc].length];
        int quantos = 0;
        for(int nota : notasTurma[uc])
        
            if (nota > valor)
            {
                aux[quantos] = nota;
                quantos++;
            }
        
        int[] result = new int[quantos];
        System.arraycopy(aux,0,result,0,quantos);
        return result;     
        
    }
    
    public int[] notasAcimaDe(int valor)
    {
        int[][] aux =  new int[notasTurma.length][];
        int quantos = 0;
        for(int i=0; i<notasTurma.length; i++)
        {
            aux[i] = notasAcimaDeAluno(valor, i);
            quantos += aux[i].length;
        }
        
        int[] result = new int[quantos];
        int inicio = 0;
        for(int i =0; i<aux.length; i++)
        {
            System.arraycopy(aux[i],0,result,inicio,aux[i].length);
            inicio += aux[i].length;
        }
        
        return result;
    
        
    }
    
    public int ucMediaMaisAlta()
    {
        int result = 0;
        double media = mediaUC(0);
        for (int i =1; i<notasTurma.length; i++)
            if (mediaUC(i) > media)
            {
                media = mediaUC(i);
                result = i;
            }
        return result;
    
    }
    
       public String toString(){
        String result = "";
        for (int i=0; i<notasTurma.length; i++)
        {
            result += "Aluno " + (i+1) + ": ";
            for(int j=0; j<notasTurma[i].length; j++)
                result += padNum(notasTurma[i][j],2) + " ";
            result += "\n";
                
        }
        
        return result;
    
    }
    
    private String padNum(int x, int spaces) // funçao que serve para a impressao das notas ficar formatada
    {
        String result = "";
        int numDigitos, aux = x;
        for(numDigitos = 1; aux / 10 !=0; numDigitos++)
            aux /=10;
        aux = spaces - numDigitos;
        for(int i=0; i<aux; i++)
            result += " ";
        result += x;
        return result;
       
        
        
        
    }
    
    
    
    
   
}
