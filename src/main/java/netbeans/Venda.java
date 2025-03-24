<<<<<<< HEAD

package netbeans;


public class Venda {
    private Usuario usuario;
    private Computador computador;
    private String data_venda;
    
    public Venda(String data, Usuario usuario, Computador computador){
        this.data_venda = data;
        this.usuario = usuario;
        this.computador = computador;
    }
    
    
    public Usuario getUsuario(){
        return usuario;
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netbeans;

import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;
  import jakarta.persistence.JoinColumn;
  import jakarta.persistence.ManyToOne;
  import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private LocalDateTime data_venda;
    
    @ManyToOne
    @JoinColumn(name="fk_idComputador")
    private Computador computador;
    
    @ManyToOne
    @JoinColumn(name="fk_idCliente")
    private Usuario usuario;
    
    public LocalDateTime getData(){
        return data_venda;
    }
    
    public int getId(){
        return id;
>>>>>>> e9ad854 (Integração do banco de dados)
    }
    
    public Computador getComputador(){
        return computador;
    }
    
<<<<<<< HEAD
    public String getDataVenda(){
        return data_venda;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
=======
    public Usuario getCliente(){
        return usuario;
    }
    
    public void setId(int id){
        this.id = id;
>>>>>>> e9ad854 (Integração do banco de dados)
    }
    
    public void setComputador(Computador computador){
        this.computador = computador;
    }
    
<<<<<<< HEAD
    public void setDataVenda(String data){
        this.data_venda = data;
    }
    
    
  
    
=======
    public void setCliente(Usuario cliente){
        this.usuario = cliente;
    }
    
    public void setData(LocalDateTime data){
        this.data_venda = data;
    }

>>>>>>> e9ad854 (Integração do banco de dados)
}
