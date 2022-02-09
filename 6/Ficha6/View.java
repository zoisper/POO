import java.util.Scanner;
import java.io.IOException;
import java.util.List;
public class View
{
    private Controller c;
    
    public View(Controller c){
        this.c = c;
    }
    
    public void run(){
        Menu m = new Menu(new String[]{"Adicionar um veiculo ao sistema", "Verificar se um veiculo esta no sistema", "Ler veiculos disponiveis", "Gravar Estado", "Ler Estado"});
        int op;
        do {
            m.executa();
            op = m.getOpcao();
            switch (op){
                case 1 : 
                    System.out.println("Nao Implementado");
                    break;
                case 2:
                    verificaVeiculoExiste();
                    break;
                case 3:
                    System.out.println("Nao Implementado");
                    break;
                case 4:
                    System.out.println("Nao Implementado");
                    break;
                case 5:
                    System.out.println("Nao Implementado");
                    break;
                default:
                    System.out.println("Ate ja");
                    break;
                }
                    
            
        } while(op != 0);
        
    }
    
    private void verificaVeiculoExiste(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a matricula do veiculo a verificar");
        String matricula = sc.next();
        boolean existe = c.existeVeiculo(matricula);
        try{    
            if(existe) System.out.println("Veiculo esta no sistema - " + c.getVeiculo(matricula).toString());
            else System.out.println("Veiculo nao esta no sistema");
        } catch(VeiculoInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void guardaEstado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome do ficheiro");
        String filename = sc.next();
        try{
            c.guardaEstado(filename);
        }
        catch(IOException e){
            System.out.println("Nao foi possivel guardar o estado");
        }
    }
    
    public void carregaEstado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome do ficheiro");
        String filename = sc.next();
        try{
            c.carregaEstado(filename);
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Nao foi possivel carregar o estado");
        }
    }
    
    public void listaVeiculos() throws Exception{
        List<String> matriculas = c.getMatriculas();
        if(matriculas.isEmpty())
            System.out.println("Nao ha veiculos no sistema");
        else{
            Menu m = new Menu(matriculas);
            m.executa();
            int op = m.getOpcao();
            String matriculaEscolhida = matriculas.get(op-1);
            Veiculo v = c.getVeiculo(matriculaEscolhida);
            System.out.println("Detalhes do veicule da matricula" + matriculaEscolhida + ":");
            System.out.println(v.toString());
            
        }
    }
    
    
}
