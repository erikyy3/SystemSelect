
package Services;

import conexao.ConexaoPadrao;
import dao.VendaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import netbeans.SessaoUsuario;
import netbeans.Usuario;
import netbeans.Venda;


public class VendaService {
    private VendaDAO dao;
    
    public VendaService(){
        ConexaoPadrao conexaoPadrao = new ConexaoPadrao();
        this.dao = new VendaDAO(conexaoPadrao);
    }
    
    public List<Venda> listarComprasDoUsuarioLogado(String dataIni, String dataFim){
        Usuario usuario = SessaoUsuario.getUsuario();
        return dao.listarComprasDoUsuario(usuario.getId(), dataIni, dataFim);
    };
    
    public List<Venda> listarTodasVendas(){
        return dao.listarTodasVendas();
    }
    
    public List<Venda> listarTodasVendasDATA(String dataIni, String dataFim){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dataHoraInicial = null;
        LocalDateTime dataHoraFinal = null;
        
    try{

        
        if(!dataIni.isEmpty()){
            dataHoraInicial = LocalDate.parse(dataIni, dateFormatter).atTime(00, 00, 00);
        }
        
        if(!dataFim.isEmpty()){
            dataHoraFinal = LocalDate.parse(dataFim, dateFormatter).atTime(23, 59, 59);
        }
    }catch(DateTimeParseException e){
        return null;
    }    
    
        return dao.listarTodasVendasDATA(dataHoraInicial, dataHoraFinal);
    }
    
    public boolean excluirVenda(int id){
        return dao.excluirVenda(id);
    }
    
    public Venda encontrarVenda(int id){
        Venda venda = dao.encontrarVenda(id);
        return venda;
    }
    
    public boolean inserirVenda(Venda venda, int idCliente, int idItem){
        return dao.inserirVenda(venda, idCliente, idItem);
    }
    
    public boolean atualizarVenda(Venda venda, int idCliente, int idItem){
        return dao.atualizarVenda(venda, idCliente, idCliente);
    }
    
}
