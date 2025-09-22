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
import java.util.ArrayList;
import java.util.List;
import netbeans.Computador;


public class ComputadorDAO {
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<Computador> computadores = new ArrayList<>();
    
    public ComputadorDAO(ProvedorDeConexao provedor){
        this.conn = provedor.getConnection();
    }
    
    public List<Computador> listar(String nome, String marca, String valorInicial, String valorFinal){
    
      try{
          String sql = "select * from Computador c where c.nome like ? and (? is null or c.preco >=?) and (? is null or c.preco <= ?) and c.marca like ?";
          prep = this.conn.prepareStatement(sql);
          prep.setString(1, "%" + (nome == null || nome.isEmpty() ? "" : nome) + "%");
          if (valorInicial == null || valorInicial.isEmpty()) {
            prep.setNull(2, java.sql.Types.DOUBLE);
            prep.setNull(3, java.sql.Types.DOUBLE);
          }
          else{
            prep.setDouble(2, Double.parseDouble(valorInicial));
            prep.setDouble(3, Double.parseDouble(valorInicial)); 
          }
          
          if (valorFinal == null || valorFinal.isEmpty()) {
            prep.setNull(4, java.sql.Types.DOUBLE);
            prep.setNull(5, java.sql.Types.DOUBLE);
 
          }
          else{
            prep.setDouble(4, Double.parseDouble(valorFinal));
            prep.setDouble(5, Double.parseDouble(valorFinal));
          }

          prep.setString(6, "%" + (marca == null || marca.isEmpty() ? "" : marca) + "%");
          resultset  = prep.executeQuery();
          
          while(resultset.next()){
              Computador computadorAtual = new Computador();
              
              computadorAtual.setId(resultset.getInt("id"));
              computadorAtual.setNome(resultset.getString("nome"));
              computadorAtual.setDescricao(resultset.getString("descricao"));
              computadorAtual.setTipo(resultset.getString("tipo"));
              computadorAtual.setMarca(resultset.getString("marca"));
              computadorAtual.setPreco(resultset.getDouble("preco"));
              computadorAtual.setQuantidade(resultset.getInt("quantidade"));
              computadores.add(computadorAtual);
          }
          return computadores;
          
    }catch(Exception ex){
        return null;
    }
    }
    
            public boolean excluirItem(int id){
            String sql = "delete from Computador where id = ?";
            
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setInt(1, id);
                prep.execute();
                return true;
            }catch(Exception ex){
                System.out.println("Falha ao excluir Item, tente novamente.");
                return false;
            }
        }
            
        public boolean cadastrarItem(Computador computador){
            String sql = "insert into Computador(nome, descricao, tipo, marca, preco, quantidade) values (?, ?, ?, ?, ?, ?)";
            
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setString(1, computador.getNome());
                prep.setString(2, computador.getDescricao());
                prep.setString(3, computador.getTipo());
                prep.setString(4, computador.getMarca());
                prep.setDouble(5, computador.getPreco());
                prep.setInt(6, computador.getQuantidade());
                prep.execute();
                return true;
            }
            catch(Exception ex){
                System.out.println("Falha ao inserir dados, tente novamente.");
                return false;
            }
        }
        
        public Computador encontrarItem(int id){
            String sql = "select * from Computador where id = ?";
            
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setInt(1, id);
                resultset = prep.executeQuery();
                if(resultset.next()){
                    Computador computadorEncontrado = new Computador();
                    computadorEncontrado.setId(resultset.getInt("id"));
                    computadorEncontrado.setNome(resultset.getString("nome"));
                    computadorEncontrado.setDescricao(resultset.getString("descricao"));
                    computadorEncontrado.setTipo(resultset.getString("tipo"));
                    computadorEncontrado.setMarca(resultset.getString("marca"));
                    computadorEncontrado.setPreco(resultset.getDouble("preco"));
                    computadorEncontrado.setQuantidade(resultset.getInt("quantidade"));
                    return computadorEncontrado;
                }
                else{
                    System.out.println("Falha ao encontrar item, tente novamente.");
                    return null;
                }
                
            }
            catch(Exception ex){
                return null;
            }
        }
        
        public boolean atualizarItem(Computador computador){
            String sql = "update Computador c set c.nome = ?, c.marca = ?, c.preco = ?, c.quantidade = ?, c.tipo = ?, c.descricao = ? where c.id = ?";
            
            try{
                prep = this.conn.prepareStatement(sql);
                prep.setString(1, computador.getNome());
                prep.setString(2, computador.getMarca());
                prep.setDouble(3, computador.getPreco());
                prep.setInt(4, computador.getQuantidade());
                prep.setString(5, computador.getTipo());
                prep.setString(6, computador.getDescricao());
                prep.setInt(7, computador.getId());
                prep.executeUpdate();
                return true;
            }
            catch(Exception ex){
                System.out.println("Falha ao atulizar dados do item, tente novamente.");
                return false;
            }
        }
    
}
