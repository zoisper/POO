import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Write a description of class TesteLinhaEncomenda here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TesteEncEficiente
{
   public static void main(){
       
       LinhaEncomenda le1 = new LinhaEncomenda("1","Consola",200,2,0.6,0);
       LinhaEncomenda le2 = new LinhaEncomenda("2","Livro",10.0,1,0.23,0.10);
       LinhaEncomenda le3 = new LinhaEncomenda("3","Brinquedo",50,4,0.23,0.10);
       ArrayList<LinhaEncomenda> encomendas = new ArrayList<LinhaEncomenda>();
       EncEficiente ef1 = new EncEficiente("Tiago",1000,"Gualtar", 123, LocalDate.now(), encomendas);
       ef1.adicionaLinha(le1);
       ef1.adicionaLinha(le2);
       ef1.adicionaLinha(le3);
       
       System.out.println(ef1);
       
       System.out.println("Total: " + ef1.calculaValorTotal());
       System.out.println("Total Desconto: " + ef1.calculaValorDesconto());
       System.out.println("Numero de Produtos: " + ef1.numeroTotalProdutos());
       System.out.println("Existe Produto com Referencia: " + le3.getReferencia() + "\nResposta: "+ ef1.existeProdutoEncomenda(le3.getReferencia()));
       
       ef1.removeProduto("2");
       System.out.println();
       System.out.println(ef1);
       
       
    }
}
