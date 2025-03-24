
package netbeans;

<<<<<<< HEAD

public class SessaoUsuario {
    private static Usuario usuario;
    
    public static void setUsuario(Usuario usuario){
        SessaoUsuario.usuario = usuario;
    }
    
    public static Usuario getUsuario(){
        return usuario;
    }
=======
public class SessaoUsuario {
    private static Usuario usuario;
    
    public static Usuario getUsuario(){
        return usuario;
    }
    
    public static void setUsuario(Usuario usuario){
        SessaoUsuario.usuario = usuario;
    }
>>>>>>> e9ad854 (Integração do banco de dados)
}
