
package Services;

import conexao.ConexaoPadrao;
import dao.ComputadorDAO;
import java.util.List;
import netbeans.Computador;

public class ComputadorService {
    private ComputadorDAO dao;
    
    public ComputadorService(){
        ConexaoPadrao conexaoPadrao = new ConexaoPadrao();
        this.dao = new ComputadorDAO(conexaoPadrao);
    }
    
    public List<Computador> listarItens(String nome, String marca, String valorInicial, String valorFinal){
        return dao.listar(nome, marca, valorInicial, valorFinal);
    }
    
    public boolean excluirItem(int id){
        return dao.excluirItem(id);
    }
    
    public boolean cadastrarItem(Computador computador){
        return dao.cadastrarItem(computador);
    }
    
    public Computador encontrarItem(int id){
        return dao.encontrarItem(id);
    }
    
    public boolean atualizarItem(Computador computador){
        return dao.atualizarItem(computador);
    }
}
