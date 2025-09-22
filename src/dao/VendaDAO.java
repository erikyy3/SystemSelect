/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.ConexaoPadrao;
import conexao.ProvedorDeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import netbeans.Computador;
import netbeans.Usuario;
import netbeans.Venda;


public class VendaDAO {
    
Connection conn;
PreparedStatement prep;
ResultSet resultset;
ArrayList<Usuario> vendas = new ArrayList<>();
ProvedorDeConexao provedor = new ConexaoPadrao();

public VendaDAO(ProvedorDeConexao provedor){
    this.conn = provedor.getConnection();
}

    public List<Venda> listarComprasDoUsuario(int idUsuario, String dataIni, String dataFim){
    String sql = "select * from Venda v where v.usuario.id = ? and (? is null or v.data_venda >=?) and (? is null or v.data_venda <=?)";
      try{
          
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          prep = this.conn.prepareStatement(sql);
          prep.setInt(1, idUsuario);
          if (dataIni == null || dataIni.isEmpty()) {
            prep.setNull(2, java.sql.Types.TIMESTAMP); 
            prep.setNull(3, java.sql.Types.TIMESTAMP);
          } 
          else {
            LocalDateTime dataInicial = LocalDateTime.parse(dataIni, formatter); 
            prep.setTimestamp(2, java.sql.Timestamp.valueOf(dataInicial)); 
            prep.setTimestamp(3, java.sql.Timestamp.valueOf(dataInicial));
          }
          
          if (dataFim == null || dataFim.isEmpty()) {
            prep.setNull(4, java.sql.Types.TIMESTAMP);
            prep.setNull(5, java.sql.Types.TIMESTAMP);
          }
          else {
            LocalDateTime dataFinal = LocalDateTime.parse(dataFim, formatter);
            prep.setTimestamp(4, java.sql.Timestamp.valueOf(dataFinal));
            prep.setTimestamp(5, java.sql.Timestamp.valueOf(dataFinal));
          }
          resultset = prep.executeQuery();
          List<Venda> vendasCliente = new ArrayList();
          ComputadorDAO daoComputador = new ComputadorDAO(provedor);
          UsuarioDAO daoUsuario = new UsuarioDAO(provedor);
          while(resultset.next()){
              Venda vendaAtual = new Venda();
              vendaAtual.setId(resultset.getInt("id"));
              vendaAtual.setData(resultset.getTimestamp("data_venda").toLocalDateTime());
              int ClienteId = resultset.getInt("fk_idCliente");
              Usuario usuario = daoUsuario.encontrarUsuario(ClienteId);
              int ItemId = resultset.getInt("fk_idComputador");
              Computador comp = daoComputador.encontrarItem(ItemId);
              vendaAtual.setCliente(usuario);
              vendaAtual.setComputador(comp);
              vendasCliente.add(vendaAtual);
          }
          

          
          return vendasCliente;
      }
      catch(Exception ex){
          return null;
      }
    }
    
    
    public List<Venda> listarTodasVendasDATA(LocalDateTime dataIni, LocalDateTime dataFim){
        String sql = "select * from Venda v where (? is null OR v.data_venda >= ?) and (? is null OR v.data_venda <= ?) order by v.data_venda DESC";
      try{
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          prep = this.conn.prepareStatement(sql);
          if(dataIni == null){
              prep.setNull(1, java.sql.Types.TIMESTAMP);
              prep.setNull(2, java.sql.Types.TIMESTAMP);
          }
          else{
              prep.setTimestamp(1, java.sql.Timestamp.valueOf(dataIni));
              prep.setTimestamp(2, java.sql.Timestamp.valueOf(dataIni));
          }
          if(dataFim == null){
              prep.setNull(3, java.sql.Types.TIMESTAMP);
              prep.setNull(4, java.sql.Types.TIMESTAMP);
          }
          else{
              prep.setTimestamp(3, java.sql.Timestamp.valueOf(dataFim));
              prep.setTimestamp(4, java.sql.Timestamp.valueOf(dataFim));
          }
          resultset = prep.executeQuery();
          List<Venda> vendas = new ArrayList();
          UsuarioDAO daoUsuario = new UsuarioDAO(provedor);
          ComputadorDAO daoComputador = new ComputadorDAO(provedor);
          while(resultset.next()){
              Venda vendaAtual = new Venda();
              vendaAtual.setId(resultset.getInt("id"));
              vendaAtual.setData(resultset.getTimestamp("data_venda").toLocalDateTime());
              
              int idCliente = resultset.getInt("fk_idCliente");
              
              Usuario usuarioVenda = daoUsuario.encontrarUsuario(idCliente);
              
              int idComputador = resultset.getInt("fk_idComputador");
              
              Computador computadorVenda = daoComputador.encontrarItem(idComputador);
              
              vendaAtual.setCliente(usuarioVenda);
              vendaAtual.setComputador(computadorVenda);
              vendas.add(vendaAtual);
          }
          return vendas;
      }catch(Exception ex){
          System.out.println(ex.getMessage());
          return null;
      }
    }
    
        public List<Venda> listarTodasVendas(){
        String sql = "select * from Venda";
      try{
          prep = this.conn.prepareStatement(sql);
          resultset = prep.executeQuery();
          List<Venda> vendas = new ArrayList();
          
          while(resultset.next()){
              Venda vendaAtual = new Venda();
              vendaAtual.setId(resultset.getInt("id"));
              vendaAtual.setData(resultset.getTimestamp("data_venda").toLocalDateTime());
              
              int idCliente = resultset.getInt("fk_idCliente");
              UsuarioDAO daoUsuario = new UsuarioDAO(provedor);
              Usuario usuarioVenda = daoUsuario.encontrarUsuario(idCliente);
              
              int idComputador = resultset.getInt("fk_idComputador");
              ComputadorDAO daoComputador = new ComputadorDAO(provedor);
              Computador computadorVenda = daoComputador.encontrarItem(idComputador);
              
              vendaAtual.setCliente(usuarioVenda);
              vendaAtual.setComputador(computadorVenda);
              vendas.add(vendaAtual);
          }
          return vendas;
      }catch(Exception ex){
          return null;
      }
    }
    
    
    public boolean atualizarVenda(Venda venda, int idCliente, int idComputador){
        String sql = "update Venda set data_venda = ?, fk_idCliente = ?, fk_idComputador = ? where id = ?";
        
        try{
            prep = this.conn.prepareStatement(sql);
            prep.setTimestamp(1, java.sql.Timestamp.valueOf(venda.getData()));
            
            UsuarioDAO daoUsuario = new UsuarioDAO(provedor);
            Usuario cliente = daoUsuario.encontrarUsuario(idCliente);
            
            ComputadorDAO compDAO = new ComputadorDAO(provedor);
            Computador computador = compDAO.encontrarItem(idComputador);
            if(cliente == null || computador == null){
                System.out.println("Cliente ou Item não encontrados."); 
                return false;
            }
            
            prep.setInt(2, cliente.getId());
            prep.setInt(3, computador.getId());
            prep.setInt(4, venda.getId());
            prep.executeUpdate();
            
            return true;
            
        }catch(Exception ex){
                System.out.println("Falha ao atulizar dados do usuário, tente novamente.");
                return false;
    }
}
    
    public Venda encontrarVenda(int id){
        String sql = "select * from Venda where id = ?";
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setInt(1, id);
                resultset = prep.executeQuery();
                Venda vendaEncontrada = new Venda();
                while(resultset.next()){
                    vendaEncontrada.setId(resultset.getInt("id"));
                    vendaEncontrada.setData(resultset.getTimestamp("data_venda").toLocalDateTime());
                    
                    int idCliente = resultset.getInt("fk_idCliente");
                    UsuarioDAO daoUsuario = new UsuarioDAO(provedor);
                    Usuario Cliente = daoUsuario.encontrarUsuario(idCliente);
                    
                    vendaEncontrada.setCliente(Cliente);
                    
                    int idComputador = resultset.getInt("fk_idComputador");
                    ComputadorDAO daoComputador = new ComputadorDAO(provedor);
                    Computador item = daoComputador.encontrarItem(idComputador);
                    
                    vendaEncontrada.setComputador(item);  
                }
                
                return vendaEncontrada;
            }
            
            catch(Exception ex){
                return null;
            }
    }
    
    public boolean inserirVenda(Venda venda, int idCliente, int idItem){
        String sql = "insert into Venda(data_venda, fk_idComputador, fk_idCliente) values (?, ?, ?)";
        
        try{
            prep = this.conn.prepareStatement(sql);
            UsuarioDAO daoUsuario = new UsuarioDAO(provedor);
            ComputadorDAO daoComp = new ComputadorDAO(provedor);
            
            Usuario cliente = daoUsuario.encontrarUsuario(idCliente);
            Computador item = daoComp.encontrarItem(idItem);
            
            if(cliente == null || item == null){
                System.out.println("Cliente ou Item não encontrados.");
               return false; 
            }
            
            venda.setCliente(cliente);
            venda.setComputador(item);
            
            prep.setTimestamp(1, java.sql.Timestamp.valueOf(venda.getData()));
            prep.setInt(2, idItem);
            prep.setInt(3, idCliente);
            prep.execute();
            return true;
        }catch(Exception ex){
            System.out.println("Falha ao inserir dados, tente novamente.");
            return false;
    }
    }
    
    public boolean excluirVenda(int id){
        String sql = "delete from Venda where id = ?";
        try{
            prep = this.conn.prepareStatement(sql);
            prep.setInt(1, id);
            prep.execute();
            return true;
        }catch(Exception ex){
            System.out.println("Falha ao excluir Venda, tente novamente.");
            return false;
        }
    }
}
