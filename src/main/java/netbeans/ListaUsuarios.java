/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netbeans;

import java.util.ArrayList;
import java.util.List;


public class ListaUsuarios {
    private static final List<Usuario> lista = new ArrayList<>();
    
    public static List<Usuario> listar(){
        return lista;
    }
    
    public static void adicionarUsuario(Usuario usuario){
        lista.add(usuario);
    }
    
    public static void removerUsuario(Usuario usuario){
        lista.remove(usuario);
    }
}
