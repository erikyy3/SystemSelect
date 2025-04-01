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
    
    public void setComputador(Computador computador){
        this.computador = computador;
    }
    
    public void setCliente(Usuario cliente){
        this.usuario = cliente;
    }
    
    public void setData(LocalDateTime data){
        this.data_venda = data;
    }

}
