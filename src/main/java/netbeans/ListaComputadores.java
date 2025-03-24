
package netbeans;

import java.util.ArrayList;
import java.util.List;

public class ListaComputadores {
    private static final List<Computador> lista = new ArrayList<>();
    
    public static List<Computador> listarComputadores(){
        return lista;
    }
    
    public static void adicionarComputador(Computador computador){
        lista.add(computador);
    }
    
    public static void removerComputador(Computador computador){
        lista.remove(computador);
    }
    
}
