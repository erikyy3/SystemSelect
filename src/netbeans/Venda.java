/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netbeans;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Venda {

    private int id;
    
    private LocalDateTime data_venda;

    private Computador computador;
    
    private Usuario usuario;
    
    public LocalDateTime getData(){
        return data_venda;
    }
    
    public int getId(){
        return id;
    }
    
    public Computador getComputador(){
        return computador;
    }
    
    public Usuario getCliente(){
        return usuario;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setComputadorId(int id){
        this.computador = new Computador();
        this.computador.setId(id);
    }
    
    public void setClienteId(int id){
        this.usuario = new Usuario();
        this.usuario.setId(id);
    }
    
    public void setCliente(Usuario cliente){
        this.usuario = cliente;
    }

    public void setComputador(Computador computador){
        this.computador = computador;
    }
    
    public void setData(LocalDateTime data){
        this.data_venda = data;
    }

}
