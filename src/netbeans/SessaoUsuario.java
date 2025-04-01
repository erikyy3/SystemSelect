
package netbeans;

public class SessaoUsuario {
    private static Usuario usuario;
    
    public static Usuario getUsuario(){
        return usuario;
    }
    
    public static void setUsuario(Usuario usuario){
        SessaoUsuario.usuario = usuario;
    }
}
