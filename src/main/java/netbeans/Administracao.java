
package netbeans;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import javax.swing.JOptionPane;
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0


public class Administracao {
    private String nome;
    private String senha;
    private String tipo;
    
    public String getNome(){
        return nome;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
<<<<<<< HEAD
    public Usuario validarUsuario(String email, String senha){
        List<Usuario> consulta = ListaUsuarios.listar();
        boolean validarConsulta = false;
        Usuario consultaUsuario = null;
        
        for(int i = 0; i < consulta.size(); i++){
            Usuario usuario = consulta.get(i);
            if(email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())){
                validarConsulta = true;
                consultaUsuario = consulta.get(i);
                break;
            }
        }
        
        if(validarConsulta == true){
            return consultaUsuario;
        }
        
        else{
            return null;
        }
    }
    
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
    public void cadastrarUsuario(Usuario usuario){
        ListaUsuarios.adicionarUsuario(usuario);
        System.out.println("Cadastro de " + usuario.getNome() + " efetuado com sucesso!");
    }
    
    public void consultarUsuarios(){
        List<Usuario> consulta = ListaUsuarios.listar();
        
        if(consulta != null){
        for(int i = 0; i < consulta.size(); i++){
            Usuario usuario = consulta.get(i);
            System.out.println("=================================");
            System.out.println("Usuário #" + (i + 1));
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Senha: " + usuario.getSenha());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Num. Cartão: " + usuario.getNumCartao());
            System.out.println("Tipo: " + usuario.getTipo());
            System.out.println("=================================");
        }
        }
        
        else{
            System.out.println("A lista de Usuários está vazia.");
        }
    }
    
    public void removerUsuario(String nome){
        List<Usuario> consulta = ListaUsuarios.listar();
        
        boolean validarConsulta = false;
        Usuario usuario = null;
        for(int i = 0; i < consulta.size(); i++){
            Usuario validacaoUsuario = consulta.get(i);
            if(nome.equals(validacaoUsuario.getNome())){
                validarConsulta = true;
                usuario = consulta.get(i);
<<<<<<< HEAD
                break;
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
            }
        }
        
        if(validarConsulta == true){
            ListaUsuarios.removerUsuario(usuario);
            System.out.println("Usuário removido com sucesso!");
        }
        
        if(validarConsulta == false){
            System.out.println("Cadastro de cliente não encontrado.");
        }       
    }
    
    public Usuario encontrarUsuario(String nome){
        List<Usuario> consulta = ListaUsuarios.listar();
        
        boolean validarConsulta = false;
        Usuario usuario = null;
        for(int i = 0; i < consulta.size(); i++){
            Usuario validacaoUsuario = consulta.get(i);
            if(nome.equals(validacaoUsuario.getNome())){
                validarConsulta = true;
                usuario = consulta.get(i);
<<<<<<< HEAD
                break;
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
            }
        }
        
        if(validarConsulta == true){
            return usuario;
        }
        
        else{
            return null;
        }
    }
    
    public void atualizarUsuario(Usuario usuario, String nome){
        List<Usuario> consulta = ListaUsuarios.listar();
        boolean validarConsulta = false;
        
        for(int i = 0; i < consulta.size(); i++){
            Usuario validacaoUsuario = consulta.get(i);
            if(nome.equals(validacaoUsuario.getNome())){
                validacaoUsuario.setNome(usuario.getNome());
                validacaoUsuario.setSenha(usuario.getSenha());
                validacaoUsuario.setEmail(usuario.getEmail());
                validacaoUsuario.setNumCartao(usuario.getNumCartao());
                validacaoUsuario.setTipo(usuario.getTipo());
                validarConsulta = true;
                break;
            }
        
        }
        
        if(!validarConsulta == true){
            System.out.println("Usuário não encontrado.");
        }
        else{
            System.out.println("Dados do usuário atualizados com sucesso!");
        }
        
    }
    
<<<<<<< HEAD
    public void atualizarUsuarioPorId(Usuario usuario, int id){
        List<Usuario> consulta = ListaUsuarios.listar();
        boolean validarConsulta = false;
        
        for(int i = 0; i < consulta.size(); i++){
            Usuario validacaoUsuario = consulta.get(i);
            if(i == id){
                validacaoUsuario.setNome(usuario.getNome());
                validacaoUsuario.setSenha(usuario.getSenha());
                validacaoUsuario.setEmail(usuario.getEmail());
                validacaoUsuario.setNumCartao(usuario.getNumCartao());
                validacaoUsuario.setTipo(usuario.getTipo());
                validarConsulta = true;
                break;
            }
    }
        
        if(!validarConsulta == true){
            System.out.println("Usuário não encontrado.");
        }
        
        else{
            System.out.println("Dados do usuário atualizados com sucesso!");
        }
    }
    
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
    public void cadastrarComputador(Computador computador){
        ListaComputadores.adicionarComputador(computador);
        System.out.println("Item cadastrado com sucesso!");
    }
    
    public void consultarComputadores(){
        List<Computador> consulta = ListaComputadores.listarComputadores();
        
        if(consulta != null){
        for(int i = 0; i < consulta.size(); i++){
            Computador item = consulta.get(i);
            System.out.println("=================================");
            System.out.println("Item #" + (i + 1));
            System.out.println("Nome: " + item.getNome());
            System.out.println("Marca: " + item.getMarca());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Preço: " + item.getPreco());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("=================================");
        }
    }
        
        else{
            System.out.println("A lista de itens está vazia.");
        }
}
    
    public void atualizarComputador(Computador computador, String nome){
        List<Computador> consulta = ListaComputadores.listarComputadores();
        boolean validarConsulta = false;
        
        for(int i = 0; i < consulta.size(); i++){
            Computador validacaoComputador = consulta.get(i);
            if(nome.equals(validacaoComputador.getNome())){
                validacaoComputador.setNome(computador.getNome());
                validacaoComputador.setMarca(computador.getMarca());
                validacaoComputador.setTipo(computador.getTipo());
                validacaoComputador.setPreco(computador.getPreco());
                validacaoComputador.setQuantidade(computador.getQuantidade());
                validarConsulta = true;
                break;
            }
        }
        
        
        if(!validarConsulta == true){
            System.out.println("Item não encontrado.");
        }
        
        else{
            System.out.println("Dados do item atualizados com sucesso!");
        }
    }
    
<<<<<<< HEAD
    public void atualizarComputadorPorId(Computador computador, int id){
        List<Computador> consulta = ListaComputadores.listarComputadores();
        boolean validarConsulta = false;
        
        for(int i = 0; i < consulta.size(); i++){
            Computador validarComputador = consulta.get(i);
            if(i == id){
                validarComputador.setNome(computador.getNome());
                validarComputador.setMarca(computador.getMarca());
                validarComputador.setTipo(computador.getTipo());
                validarComputador.setPreco(computador.getPreco());
                validarComputador.setQuantidade(computador.getQuantidade());
                validarConsulta = true;
                break;
            }   
        }
        
        if(!validarConsulta == true){
            JOptionPane.showMessageDialog(null, "Item não encontrado.");
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Dados do item atualizados com sucesso!");
        }
    }
    
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
    public void removerComputador(String nome){
        List<Computador> consulta = ListaComputadores.listarComputadores();
        
        boolean validarConsulta = false;
        Computador computador = null;
        
        for(int i = 0; i < consulta.size(); i++){
        Computador validacaoComputador = consulta.get(i);
        if(nome.equals(validacaoComputador.getNome())){
            validarConsulta = true;
            computador = consulta.get(i);
<<<<<<< HEAD
            break;
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
        }
    }
        
        if(validarConsulta == true){
            ListaComputadores.removerComputador(computador);
            System.out.println("Item removido com sucesso!");
        }
        
        else{
            System.out.println("Cadastro de item não encontrado.");
        }
    }
    
<<<<<<< HEAD
    
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
    public Computador encontrarComputador(String nome){
        List<Computador> consulta = ListaComputadores.listarComputadores();
        
        boolean validarConsulta = false;
        Computador computador = null;
        for(int i = 0; i < consulta.size(); i++){
            Computador validacaoComputador = consulta.get(i);
            if(nome.equals(validacaoComputador.getNome())){
                validarConsulta = true;
                computador = consulta.get(i);
<<<<<<< HEAD
                break;
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
            }
        }
        
        if(validarConsulta == true){
            return computador;
        }
        
        else{
            return null;
        }
    }
    
<<<<<<< HEAD
    public Computador encontrarComputadorPorId(int id){
        List<Computador> consulta = ListaComputadores.listarComputadores();
        
        Computador computador = null;
        for(int i = 0; i < consulta.size(); i++){
            if(i == id){
                computador = consulta.get(i);
                break;
            }
        }
        return computador;
    }
    
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
    public void cadastrarVenda(Venda venda){
        ListaVendas.adicionarVenda(venda);
        System.out.println("Venda cadastrada com sucesso!");
    }
    
    public void atualizarVenda(Venda venda, int idVenda){
        List<Venda> consulta = ListaVendas.listarVendas();
        boolean validarConsulta = false;
        
        for(int i = 0; i < consulta.size(); i++){
            Venda validacaoVenda = consulta.get(i);
            if(i == idVenda){
                validacaoVenda.setDataVenda(venda.getDataVenda());
                validacaoVenda.setComputador(venda.getComputador());
                validacaoVenda.setUsuario(venda.getUsuario());
                validarConsulta = true;
                break;
            }
        }
        
        if(!validarConsulta == true){
            System.out.println("Venda não encontrada.");
        }
        
        else{
            System.out.println("Dados da venda atualizados com sucesso!");
        }
    }
    
    public void removerVenda(int idVenda){
        List<Venda> consulta = ListaVendas.listarVendas();
        
        boolean validarConsulta = false;
        Venda venda = null;
        
        for(int i = 0; i < consulta.size(); i++){
            Venda validacaoVenda = consulta.get(i);
            if(i == idVenda){
                validarConsulta = true;
<<<<<<< HEAD
                venda = validacaoVenda;
                break;
=======
                venda = consulta.get(i);
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
            }
        }
        
        if(validarConsulta == true){
            ListaVendas.removerVenda(venda);
            System.out.println("Venda removida com sucesso!");
        }
        
        else{
            System.out.println("Cadastro de venda não encontrado.");
        }
    }
    
        public void consultarVendas(){
        List<Venda> consulta = ListaVendas.listarVendas();
        
        if(consulta != null){
        for(int i = 0; i < consulta.size(); i++){
            Venda venda = consulta.get(i);
            System.out.println("=================================");
            System.out.println("Venda #" + (i + 1));
            System.out.println("Cliente: " + venda.getUsuario().getNome());
            System.out.println("Item: " + venda.getComputador().getNome());
            System.out.println("Data da Venda: " + venda.getDataVenda()); 
            System.out.println("=================================");
        }
    }
        
        else{
            System.out.println("A lista de vendas está vazia.");
        }
}
<<<<<<< HEAD
        public Venda encontrarVenda(int id){
            List<Venda> consulta = ListaVendas.listarVendas();
            Venda venda = null;
            
            for(int i = 0; i < consulta.size(); i++){
                Venda validarVenda = consulta.get(i);
                if(i == id){
                    venda = validarVenda;
                    break;
                }
            }
            return venda;
        }
        
        public boolean validarSenha(String senha){
            List<Usuario> consulta = ListaUsuarios.listar();
            boolean validacaoSenha = false;
            
            for(int i = 0; i < consulta.size(); i++){
                Usuario usuario = consulta.get(i);
                if(senha.equals(usuario.getSenha())){
                    validacaoSenha = true;
                    break;
                }
            }
            
            return validacaoSenha;
        }
        
        public List<Venda> listarVendasFiltrado(String nome){
            List<Venda> consulta = ListaVendas.listarVendas();
            List<Venda> listaFiltrada = new ArrayList();
            
            for(int i = 0; i < consulta.size(); i++){
                Venda venda = consulta.get(i);
                if(nome.equals(venda.getUsuario().getNome())){
                    listaFiltrada.add(venda);
                } 
            }
            
            return listaFiltrada;
        }
        
        public List<Usuario> listarClientes(){
            List<Usuario> consulta = ListaUsuarios.listar();
            List<Usuario> listaFiltrada = new ArrayList();
            
            for(int i = 0; i < consulta.size(); i++){
                Usuario usuario = consulta.get(i);
                if(usuario.getTipo().equals("Cliente")){
                    listaFiltrada.add(usuario);
                }
            }
            return listaFiltrada;
        }
=======
>>>>>>> b7d3430d11ed07e2dec4f80232e22b95ee77fdf0
    
}
