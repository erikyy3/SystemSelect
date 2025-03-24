
package netbeans;

<<<<<<< HEAD

public class Computador {
    private String nome;
    private String marca;
    private String tipo;
    private double preco;
    private int quantidade;
    
    public Computador(String nome, String marca, String tipo, double preco, int quantidade){
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;

@Entity
public class Computador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    
    private String descricao;
    
    private String tipo;
    
    private String marca;
    
    private double preco;
    
    private int quantidade;
    
    public int getId(){
        return id;
>>>>>>> e9ad854 (Integração do banco de dados)
    }
    
    public String getNome(){
        return nome;
    }
    
<<<<<<< HEAD
    public String getMarca(){
        return marca;
=======
    public String getDescricao(){
        return descricao;
>>>>>>> e9ad854 (Integração do banco de dados)
    }
    
    public String getTipo(){
        return tipo;
    }
    
<<<<<<< HEAD
=======
    public String getMarca(){
        return marca;
    }
    
>>>>>>> e9ad854 (Integração do banco de dados)
    public Double getPreco(){
        return preco;
    }
    
    public int getQuantidade(){
        return quantidade;
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
    
<<<<<<< HEAD
    public void setMarca(String marca){
        this.marca = marca;
=======
    public void setDescricao(String descricao){
        this.descricao = descricao;
>>>>>>> e9ad854 (Integração do banco de dados)
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
<<<<<<< HEAD
=======
    public void setMarca(String marca){
        this.marca = marca;
    }
    
>>>>>>> e9ad854 (Integração do banco de dados)
    public void setPreco(Double preco){
        this.preco = preco;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
<<<<<<< HEAD
    
=======
>>>>>>> e9ad854 (Integração do banco de dados)
}
