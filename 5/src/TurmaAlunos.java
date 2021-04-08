import java.util.Map;
import java.util.TreeMap;

public class TurmaAlunos {

    private String nome;
    private String uc;
    private Map<String, Aluno> alunos;

    public TurmaAlunos(){
        this.uc = "Sem Nome";
        this.nome = "Sem Nome";
        this.alunos = new TreeMap<>();
    }

    public TurmaAlunos(String nome, String uc, Map<String, Aluno> alunos){
        this.nome = nome;
        this.uc = uc;
        setAlunos(alunos);
    }

    public TurmaAlunos(TurmaAlunos t){
        this.nome = t.getNome();
        this.uc = t.getUC();
        setAlunos(t.getAlunos());
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUC(){
        return this.uc;
    }

    public void setUC(String uc){
        this.uc = uc;
    }

    public Map<String, Aluno> getAlunos(){
        TreeMap<String, Aluno> ret = new TreeMap<>();
        for(Map.Entry<String, Aluno> a : alunos.entrySet()) {
            ret.put(a.getKey(), a.getValue().clone());
        }
        return ret;

    }







}
