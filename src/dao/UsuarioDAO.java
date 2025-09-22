/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import conexao.ProvedorDeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import netbeans.Usuario;



public class UsuarioDAO implements AutenticadorDeUsuario {
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    
    
    public UsuarioDAO(ProvedorDeConexao provedor){
        this.conn = provedor.getConnection();
    }
    
        @Override
        public Usuario validarPorLogin(Usuario usuario){
        String sql = "Select * from Usuario u where u.email = ? and u.senha = ?";
        Usuario usuarioValido = null;
        try{
            prep = this.conn.prepareStatement(sql);
            prep.setString(1, usuario.getEmail());
            prep.setString(2, usuario.getSenha());
            resultset = prep.executeQuery();
            
            if(resultset.next()){
               usuarioValido = new Usuario();
               
               usuarioValido.setId(resultset.getInt("id"));
               usuarioValido.setNome(resultset.getString("nome"));
               usuarioValido.setSenha(resultset.getString("senha"));
               usuarioValido.setEmail(resultset.getString("email"));
               usuarioValido.setNumCartao(resultset.getString("numero_cartao"));
               usuarioValido.setTipo(resultset.getString("tipo"));
            }
            
            return usuarioValido;
        }
        
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
}
        
        public List<Usuario> listar(String nome){
            String sql = "select * from Usuario u where u.tipo = 'Cliente' and u.nome like ?";
            
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setString(1, "%" + (nome == null || nome.isEmpty() ? "" : nome) + "%");
                resultset  = prep.executeQuery();
                while(resultset.next()){
                    Usuario usuarioAtual = new Usuario();
                    
                    usuarioAtual.setId(resultset.getInt("id"));
                    usuarioAtual.setNome(resultset.getString("nome"));
                    usuarioAtual.setSenha(resultset.getString("senha"));
                    usuarioAtual.setEmail(resultset.getString("email"));
                    usuarioAtual.setNumCartao(resultset.getString("numero_cartao"));
                    usuarioAtual.setTipo(resultset.getString("tipo"));
                    usuarios.add(usuarioAtual);
                }
                return usuarios;
            }
            catch(Exception ex){
                return null;
            }
        }
        
        public boolean excluirUsuario(int id){
            String sql = "delete from Usuario where id = ?";
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setInt(1, id);
                prep.execute();
                return true;
            }    
            catch(Exception ex){
                System.out.println("Erro ao excluir usuário: " + ex.getMessage());
                return false;
            }
        }
        
        public Usuario encontrarUsuario(int id){
            String sql = "select * from Usuario where id = ?";
            
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setInt(1, id);
                resultset = prep.executeQuery();
                Usuario usuarioEncontrado = new Usuario();  
                if(resultset.next()){
                  usuarioEncontrado.setId(resultset.getInt("id"));
                  usuarioEncontrado.setNome(resultset.getString("nome"));
                  usuarioEncontrado.setSenha(resultset.getString("senha"));
                  usuarioEncontrado.setEmail(resultset.getString("email"));
                  usuarioEncontrado.setNumCartao(resultset.getString("numero_cartao"));
                  usuarioEncontrado.setTipo(resultset.getString("tipo"));
                }
                
                return usuarioEncontrado;
            }
            
            catch(Exception ex){
                System.out.println("Falha ao encontrar usuário, tente novamente. " + ex.getMessage());
                return null;
            }
        }
        
        public boolean atualizarUsuario(Usuario usuario){
            String sql = "update Usuario u set u.nome = ?, u.senha = ?, u.email = ?, u.numero_cartao = ?, u.tipo = ? where u.id = ?";
            
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setString(1, usuario.getNome());
                prep.setString(2, usuario.getSenha());
                prep.setString(3, usuario.getEmail());
                prep.setString(4, usuario.getNumCartao());
                prep.setString(5, usuario.getTipo());
                prep.setInt(6, usuario.getId());
                prep.executeUpdate();
                return true;
            }catch(Exception ex){
                System.out.println("Falha ao atulizar dados do usuário, tente novamente. " + ex.getMessage());
                return false;
        }
        }
        
        public boolean inserirUsuario(Usuario usuario){
           String sql = "insert into Usuario(nome, senha, email, numero_cartao, tipo) values(?, ?, ?, ?, ?)";
           
           try{
               prep = this.conn.prepareStatement(sql);
               prep.setString(1, usuario.getNome());
               prep.setString(2, usuario.getSenha());
               prep.setString(3, usuario.getEmail());
               prep.setString(4, usuario.getNumCartao());
               prep.setString(5, usuario.getTipo());
               prep.execute();
               return true;
           }catch(Exception ex){
               System.out.println("Falha ao inserir dados, tente novamente. " + ex.getMessage());
               return false;
           }
        }
}
