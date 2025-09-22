/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import conexao.ProvedorDeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import netbeans.Usuario;

/**
 *
 * @author butuk
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of listar method, of class UsuarioDAO.
     */
    @Test
    public void testListar() {
        
    }

    @Test
    public void testEncontrarUsuario() throws Exception {
        Connection mockConn = Mockito.mock(Connection.class);
        PreparedStatement mockStmt = Mockito.mock(PreparedStatement.class);
        ResultSet mockResult = Mockito.mock(ResultSet.class);

        Mockito.when(mockConn.prepareStatement(Mockito.anyString())).thenReturn(mockStmt);
        Mockito.when(mockStmt.executeQuery()).thenReturn(mockResult);
        Mockito.when(mockResult.next()).thenReturn(true);
        Mockito.when(mockResult.getString("nome")).thenReturn("Erick");
        Mockito.when(mockResult.getString("senha")).thenReturn("Erick123");

        ProvedorDeConexao provedor = () -> mockConn;
        UsuarioDAO dao = new UsuarioDAO(provedor);

        Usuario u = dao.encontrarUsuario(1);

        assertEquals("Erick", u.getNome());
        assertEquals("Erick123", u.getSenha());
    }
}


