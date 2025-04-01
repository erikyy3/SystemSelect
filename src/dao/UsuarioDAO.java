/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import netbeans.Usuario;
import conexao.conexao;



public class UsuarioDAO {
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public UsuarioDAO(){
        this.conn = new conexao().getConnection();
    }
    
        public Usuario validarUsuario(Usuario usuario){
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
            JOptionPane.showMessageDialog(null, "Erro de autenticação, tente informar os dados corretos.");
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
        
        public void ExcluirUsuario(int id){
            String sql = "delete from Usuario where id = ?";
            
            try{
                int confirmacao = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir o usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);
                
                if(confirmacao == JOptionPane.YES_OPTION){
                    
                
                prep = this.conn.prepareStatement(sql);
                prep.setInt(1, id);
                prep.execute();

                
                } else{
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                }    
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falha ao excluir Usuário, tente novamente.");
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
                JOptionPane.showMessageDialog(null, "Falha ao encontrar usuário, tente novamente.");
                return null;
            }
        }
        
        public void atualizarUsuario(Usuario usuario){
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

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falha ao atulizar dados do usuário, tente novamente.");
        }
        }
        
        public void inserirUsuario(Usuario usuario){
           String sql = "insert into Usuario(nome, senha, email, numero_cartao, tipo) values(?, ?, ?, ?, ?)";
           
           try{
               prep = this.conn.prepareStatement(sql);
               prep.setString(1, usuario.getNome());
               prep.setString(2, usuario.getSenha());
               prep.setString(3, usuario.getEmail());
               prep.setString(4, usuario.getNumCartao());
               prep.setString(5, usuario.getTipo());
               prep.execute();
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Falha ao inserir os dados, tente novamente.");
           }
        }
}
