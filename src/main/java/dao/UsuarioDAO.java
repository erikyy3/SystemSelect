/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;
import netbeans.Usuario;
import persistencia.JPAUtil;


public class UsuarioDAO {
        public static Usuario validarUsuario(Usuario usuario){
        EntityManager em = JPAUtil.getEntityManager();
        
        try{
            Query consulta = em.createQuery("Select u from Usuario u where u.email like :email and u.senha = :senha", Usuario.class);
            consulta.setParameter("email", usuario.getEmail());
            consulta.setParameter("senha", usuario.getSenha());
            
            Usuario usuarioValido = (Usuario) consulta.getSingleResult();
            
            return usuarioValido;
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro de autenticação, tente informar os dados corretos.");
            return null;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
}
        
        public List<Usuario> listar(String nome){
            EntityManager em = JPAUtil.getEntityManager();
            
            try{
                Query consulta = em.createQuery("select u from Usuario u where u.tipo = 'Cliente' and u.nome like :nome" );
                consulta.setParameter("nome","%" + nome + "%");
                List<Usuario> usuarios = consulta.getResultList();
                return usuarios;
            }
            finally{
                JPAUtil.closeEntityManager();
            }
        }
        
        public void ExcluirUsuario(int id){
            EntityManager em = JPAUtil.getEntityManager();
            
            try{
                int confirmacao = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir o usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);
                
                if(confirmacao == JOptionPane.YES_OPTION){
                    
                
                Usuario u = em.find(Usuario.class, id);
                if(u != null){
                    em.getTransaction().begin();
                    em.remove(u);
                    em.getTransaction().commit();
                }
                
                if(u == null){
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado, tente novamente.");
                }
                
                } else{
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                }    
            }catch(Exception ex){
                em.getTransaction().rollback();
                JOptionPane.showMessageDialog(null, "Falha ao excluir Usuário, tente novamente.");
            }
            
            finally{
                JPAUtil.closeEntityManager();
            }
        }
        
        public Usuario encontrarUsuario(int id){
            EntityManager em = JPAUtil.getEntityManager();
            
            try{
                Query consulta = em.createQuery("select u from Usuario u where u.id = :id");
                consulta.setParameter("id", id);
                Usuario usuarioEncontrado = (Usuario) consulta.getSingleResult();
                return usuarioEncontrado;
            }
            
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falha ao encontrar usuário, tente novamente.");
                return null;
            }
            finally{
                JPAUtil.closeEntityManager();
            }
        }
        
        public void atualizarUsuario(Usuario usuario){
            EntityManager em = JPAUtil.getEntityManager();
            
            try{
                em.getTransaction().begin();
                
                Query consulta = em.createQuery("update Usuario u set u.nome = :nome, u.senha = :senha, u.email = :email, u.numero_cartao = :numero_cartao, u.tipo = :tipo where u.id = :id");
                consulta.setParameter("nome", usuario.getNome());
                consulta.setParameter("senha", usuario.getSenha());
                consulta.setParameter("email", usuario.getEmail());
                consulta.setParameter("numero_cartao", usuario.getNumCartao());
                consulta.setParameter("tipo", usuario.getTipo());
                consulta.setParameter("id", usuario.getId());
                
                consulta.executeUpdate();
                
                em.getTransaction().commit();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falha ao atulizar dados do usuário, tente novamente.");
                System.out.println(ex.getMessage());
                em.getTransaction().rollback();
            }finally{
                JPAUtil.closeEntityManager();
            }
        }
        
        public void inserirUsuario(Usuario usuario){
           EntityManager em = JPAUtil.getEntityManager();
           
           try{
               em.getTransaction().begin();
               em.persist(usuario);
               em.getTransaction().commit();
           }catch(Exception ex){
               em.getTransaction().rollback();
               JOptionPane.showMessageDialog(null, "Falha ao inserir os dados, tente novamente.");
           }
           finally{
               JPAUtil.closeEntityManager();
           }
        }
}
