/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import netbeans.Computador;
import netbeans.SessaoUsuario;
import netbeans.Usuario;
import netbeans.Venda;
import persistencia.JPAUtil;

public class VendaDAO {
    
    public List<Venda> listarApenasUsuario(String dataIni, String dataFim){
    EntityManager em = JPAUtil.getEntityManager();
      try{
          
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          
          Query consulta = em.createQuery("select v from Venda v where v.usuario.nome = :nome and (:dataInicial is null or v.data_venda >=:dataInicial) and (:dataFinal is null or v.data_venda <= :dataFinal)", Venda.class);
          consulta.setParameter("nome", SessaoUsuario.getUsuario().getNome());
          consulta.setParameter("dataInicial", dataIni.isEmpty() ? null : LocalDateTime.parse(dataIni, formatter));
          consulta.setParameter("dataFinal", dataFim.isEmpty() ? null : LocalDateTime.parse(dataFim, formatter));
          List<Venda> vendas = consulta.getResultList();
          return vendas;
      }finally{
          JPAUtil.closeEntityManager();
      }
    }
    
    public List<Venda> listarTodasVendasDataUsuario(LocalDateTime dataIni, LocalDateTime dataFim){
        EntityManager em = JPAUtil.getEntityManager();
      try{
          
          
          
          Query consulta = em.createQuery("select v from Venda v where v.usuario.nome = :nome and :dataInicial is null OR v.data_venda >= :dataInicial and :dataFinal is null OR v.data_venda <= :dataFinal order by v.data_venda ASC", Venda.class);
          consulta.setParameter("nome", SessaoUsuario.getUsuario().getNome());
          consulta.setParameter("dataInicial", dataIni);
          consulta.setParameter("dataFinal", dataFim);
          List<Venda> vendas = consulta.getResultList();
          return vendas;
      }finally{
          JPAUtil.closeEntityManager();
      }
    }
    
    public List<Venda> listarTodasVendasData(LocalDateTime dataIni, LocalDateTime dataFim){
        EntityManager em = JPAUtil.getEntityManager();
      try{
          
          
          
          Query consulta = em.createQuery("select v from Venda v where :dataInicial is null OR v.data_venda >= :dataInicial and :dataFinal is null OR v.data_venda <= :dataFinal order by v.data_venda ASC", Venda.class);
          consulta.setParameter("dataInicial", dataIni);
          consulta.setParameter("dataFinal", dataFim);
          List<Venda> vendas = consulta.getResultList();
          return vendas;
      }finally{
          JPAUtil.closeEntityManager();
      }
    }
    

    
    public List<Venda> listarTodasVendas(){
        EntityManager em = JPAUtil.getEntityManager();
      try{
          
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          
          Query consulta = em.createQuery("select v from Venda v order by v.data_venda DESC", Venda.class);
          List<Venda> vendas = consulta.getResultList();
          return vendas;
      }finally{
          JPAUtil.closeEntityManager();
      }
    }
    
    
    public void atualizarVenda(Venda venda, int idCliente, int idComputador){
        EntityManager em = JPAUtil.getEntityManager();
        
        try{
            em.getTransaction().begin();
            
            Usuario cliente = em.find(Usuario.class, idCliente);
            Computador computador = em.find(Computador.class, idComputador);
            
            if(cliente == null || computador == null){
               JOptionPane.showMessageDialog(null, "Cliente ou Item não encontrados.");
               return; 
            }
            
            Query consulta = em.createQuery("update Venda v set v.data_venda = :data, v.usuario = :idCliente, v.computador = :idComputador where v.id = :id");
            consulta.setParameter("data", venda.getData());
            consulta.setParameter("idCliente", cliente);
            consulta.setParameter("idComputador", computador);
            consulta.setParameter("id", venda.getId());
            
            consulta.executeUpdate();
            
            em.getTransaction().commit();
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falha ao atulizar dados do usuário, tente novamente.");
                em.getTransaction().rollback();
    }
        finally{
            JPAUtil.closeEntityManager();
        }
}
    
    public Venda encontrarVenda(int id){
        EntityManager em = JPAUtil.getEntityManager();
            
            try{
                Query consulta = em.createQuery("select v from Venda v where v.id = :id");
                consulta.setParameter("id", id);
                Venda vendaEncontrada = (Venda) consulta.getSingleResult();
                return vendaEncontrada;
            }
            
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Falha ao encontrar venda, tente novamente.");
                return null;
            }
            finally{
                JPAUtil.closeEntityManager();
            }
    }
    
    public void inserirVenda(Venda venda, int idCliente, int idItem){
        EntityManager em = JPAUtil.getEntityManager();
        
        try{
            Usuario cliente = em.find(Usuario.class, idCliente);
            Computador item = em.find(Computador.class, idItem);
            
            if(cliente == null || item == null){
               JOptionPane.showMessageDialog(null, "Cliente ou Item não encontrados.");
               return; 
            }
            
            venda.setCliente(cliente);
            venda.setComputador(item);
            
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Falha ao inserir dados, tente novamente.");
            em.getTransaction().rollback();
        }finally{
            JPAUtil.closeEntityManager();
        }
        
    }
    
    public void excluirVenda(int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
        int confirmacao = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir esta venda?", "Confirmação", JOptionPane.YES_NO_OPTION);
                
        if(confirmacao == JOptionPane.YES_OPTION){
            
            Venda v = em.find(Venda.class, id);
            if(v != null){
                em.getTransaction().begin();
                em.remove(v);
                em.getTransaction().commit();
            }
            
            if(v == null){
                JOptionPane.showMessageDialog(null, "Venda não encontrado, tente novamente.");
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
            
        }
        }catch(Exception ex){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Falha ao excluir Venda, tente novamente.");
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
}
