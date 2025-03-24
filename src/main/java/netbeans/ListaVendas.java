
package netbeans;

import java.util.ArrayList;
import java.util.List;

public class ListaVendas {
   private static final List<Venda> lista = new ArrayList<>(); 
   
       public static List<Venda> listarVendas(){
        return lista;
    }
       
       public static void adicionarVenda(Venda venda){
           lista.add(venda);
       }
       
       public static void removerVenda(Venda venda){
           lista.remove(venda);
       }
}
