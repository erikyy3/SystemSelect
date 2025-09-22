/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import conexao.ConexaoPadrao;
import dao.UsuarioDAO;
import java.util.List;
import netbeans.Usuario;

public class UsuarioService {
    private UsuarioDAO dao;
    
    public UsuarioService(){
        ConexaoPadrao conexaoPadrao = new ConexaoPadrao();
        this.dao = new UsuarioDAO(conexaoPadrao);
    }
    
    public Usuario autenticar(String email, String senha){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return dao.validarPorLogin(usuario);
    }
    
    public List<Usuario> listarClientesPorNome(String nome){
        return dao.listar(nome);
    }
    
    public boolean excluirUsuario(int id){
        return dao.excluirUsuario(id);
    }
    
    public Usuario encontrarUsuario(int id){
        return dao.encontrarUsuario(id);
    }
    
    public boolean atualizarUsuario(Usuario usuario){
        return dao.atualizarUsuario(usuario);
    }
    
    public boolean inserirUsuario(Usuario usuario){
        return dao.inserirUsuario(usuario);
    }
}
