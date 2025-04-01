
package netbeans;




public class Usuario {

    private int id;
    
    private String nome;
    
    private String senha;
    
    private String email;
    
    private String numero_cartao;
    
    private String tipo;
    
    public int getId(){
        return id;
    }

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
    
    public void setId(int id){
        this.id = id;
    }
    
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
