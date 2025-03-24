<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netbeans;


public class Usuario {
    private String nome;
    private String senha;
    private String email;
    private String numero_cartao;
    private String tipo;
    
    public Usuario(String nome, String senha, String email, String numero_cartao, String tipo){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.numero_cartao = numero_cartao;
        this.tipo = tipo;
    }
    
<<<<<<< HEAD
    
    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(String nome, String email, String senha, String tipo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
=======
    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
    }
    
=======

package netbeans;

import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    
    private String senha;
    
    private String email;
    
    private String numero_cartao;
    
    private String tipo;
    
    public int getId(){
        return id;
    }

>>>>>>> e9ad854 (Integração do banco de dados)
    public String getNome(){
        return nome;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getNumCartao(){
        return numero_cartao;
    }
    
    public String getTipo(){
        return tipo;
    }
    
<<<<<<< HEAD
=======
    public void setId(int id){
        this.id = id;
    }
    
>>>>>>> e9ad854 (Integração do banco de dados)
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setNumCartao(String numCartao){
        this.numero_cartao = numCartao;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
