/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import netbeans.Computador;
import netbeans.SessaoUsuario;
import netbeans.Usuario;
import netbeans.Venda;
import persistencia.JPAUtil;

/**
 *
 * @author butuk
 */
public class ComputadorDAO {
    
    public List<Computador> listar(String nome, String marca, String valorInicial, String valorFinal){
    EntityManager em = JPAUtil.getEntityManager();
      try{
          
          Query consulta = em.createQuery("select c from Computador c where c.nome like :nome and (:valorInicial is null or c.preco >=:valorInicial) and (:valorFinal is null or c.preco <= :valorFinal) and c.marca like :marca", Computador.class);
          consulta.setParameter("nome", "%" + nome + "%");
          consulta.setParameter("marca", "%" + marca + "%");
          
          Double precoInicial = (valorInicial != null && !valorInicial.trim().isEmpty())
                  ? Double.parseDouble(valorInicial)
                  : null;
          
          Double precoFinal = (valorFinal != null && !valorFinal.trim().isEmpty())
                  ? Double.parseDouble(valorFinal)
                  : null;
          
          consulta.setParameter("valorInicial", precoInicial);
          consulta.setParameter("valorFinal", precoFinal);
          List<Computador> computadores = consulta.getResultList();
          return computadores;
      }finally{
          JPAUtil.closeEntityManager();
      }
    }
    
            public void ExcluirItem(int id){
            EntityManager em = JPAUtil.getEntityManager();
            
            try{
                int confirmacao = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir este Item?", "Confirmação", JOptionPane.YES_NO_OPTION);
                
                if(confirmacao == JOptionPane.YES_OPTION){
                    
                
                Computador c = em.find(Computador.class, id);
                if(c != null){
                    em.getTransaction().begin();
                    em.remove(c);
                    em.getTransaction().commit();
                }
                
                if(c == null){
                    JOptionPane.showMessageDialog(null, "Item não encontrado, tente novamente.");
                }
                
                } else{
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                }    
            }catch(Exception ex){
                em.getTransaction().rollback();
                JOptionPane.showMessageDialog(null, "Falha ao excluir Item, tente novamente.");
            }
            
            finally{
                JPAUtil.closeEntityManager();
            }
        }
            
        public void cadastrarItem(Computador computador){
            EntityManager em = JPAUtil.getEntityManager();
            
            try{
                em.getTransaction().begin();
                em.persist(computador);
                em.getTransaction().commit();
            }
            catch(Exception ex){
                em.getTransaction().rollback();
                JOptionPane.showMessageDialog(null, "Falha ao inserir dados, tente novamente.");
            }
            finally{
                JPAUtil.closeEntityManager();
            }
        }
        
        public Computador encontrarItem(int id){
            EntityManager em = JPAUtil.getEntityManager();
            
            try{
                Query consulta = em.createQuery("select c from Computador c where c.id = :id");
                consulta.setParameter("id", id);
                Computador computadorEncontrado = (Computador) consulta.getSingleResult();
                return computadorEncontrado;
                
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falha ao encontrar item, tente novamente.");
                return null;
            }
            finally{
                JPAUtil.closeEntityManager();
            }
        }
        
        public void atualizarItem(Computador computador){
            EntityManager em = JPAUtil.getEntityManager();
            
            try{
                em.getTransaction().begin();
                
                Query consulta = em.createQuery("update Computador c set c.nome = :nome, c.marca = :marca, c.preco = :preco, c.quantidade = :quantidade, c.tipo = :tipo, c.descricao = :descricao where c.id = :id");
                consulta.setParameter("nome", computador.getNome());
                consulta.setParameter("marca", computador.getMarca());
                consulta.setParameter("preco", computador.getPreco());
                consulta.setParameter("quantidade", computador.getQuantidade());
                consulta.setParameter("tipo", computador.getTipo());
                consulta.setParameter("descricao", computador.getDescricao());
                consulta.setParameter("id", computador.getId());
                consulta.executeUpdate();
                em.getTransaction().commit();
                
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falha ao atulizar dados do item, tente novamente.");
                em.getTransaction().rollback();
            }
            finally{
                JPAUtil.closeEntityManager();
            }
        }
    
}
