
package netbeans;




public class Computador {
    private int id;
    
    private String nome;
    
    private String descricao;
    
    private String tipo;
    
    private String marca;
    
    private double preco;
    
    private int quantidade;
    
    public int getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public Double getPreco(){
        return preco;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setPreco(Double preco){
        this.preco = preco;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}
