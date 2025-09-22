/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoPadrao implements ProvedorDeConexao {
    
    @Override
    public Connection getConnection(){
        Connection conn = null;
        
        try{
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/system_select_db?user=root&password=erickholtz2018@");
            return conn;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Falha ao conectar");
            return null;
        }
    }
    
}
