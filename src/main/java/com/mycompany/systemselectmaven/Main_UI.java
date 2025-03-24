
package com.mycompany.systemselectmaven;

import Views.TelaLogin;
import netbeans.Usuario;
import netbeans.Administracao;
import netbeans.Computador;
import netbeans.Venda;

public class Main_UI {
    
    public static void main(String[] args){
    Administracao admin = new Administracao();
    Usuario Administrador = new Usuario("Erick", "Erick@gmail.com", "Erick123", "Administrador");
    Usuario cliente1 = new Usuario("Pedro", "Pedro@gmail.com", "Pedro123", "Cliente");
    Usuario cliente2 = new Usuario("Paulo", "Paulo@hotmail.com", "Paulo123", "Cliente");
    Usuario cliente3 = new Usuario("Vitor", "Vitor@gmail.com", "Vitor123", "Cliente");       
    
    admin.cadastrarUsuario(cliente1);
    admin.cadastrarUsuario(cliente2);
    admin.cadastrarUsuario(cliente3);
    admin.cadastrarUsuario(Administrador);
    
    Computador computador = new Computador("Notebook Asus 2002", "Asus", "Notebook", 2400, 20);
    Computador computador2 = new Computador("Ntech 2040", "Nvidia", "Desktop", 2100, 10);
    Computador computador3 = new Computador("Samsung T40", "Samsung", "Notebook", 1100, 9);
    
    admin.cadastrarComputador(computador);
    admin.cadastrarComputador(computador2);
    admin.cadastrarComputador(computador3);
    
    Venda vendaPedro1 = new Venda("17/04/2025", cliente1, computador);
    Venda vendaPedro2 = new Venda("10/05/2025", cliente1, computador3);
    Venda vendaPedro3 = new Venda("11/08/2025", cliente1, computador2);
    
    admin.cadastrarVenda(vendaPedro1);
    admin.cadastrarVenda(vendaPedro2);
    admin.cadastrarVenda(vendaPedro3);
    
    Venda vendaPaulo1 = new Venda("10/10/2025", cliente2, computador);
    Venda vendaPaulo2 = new Venda("10/10/2025", cliente2, computador);
    Venda vendaPaulo3 = new Venda("12/12/2025", cliente2, computador3);
    
    admin.cadastrarVenda(vendaPaulo1);
    admin.cadastrarVenda(vendaPaulo2);
    admin.cadastrarVenda(vendaPaulo3);
    
    Venda vendaVitor1 = new Venda("07/02/2025", cliente3, computador2);
    Venda vendaVitor2 = new Venda("17/10/2025", cliente3, computador);
    Venda vendaVitor3 = new Venda("03/05/2025", cliente3, computador3);
    
    admin.cadastrarVenda(vendaVitor1);
    admin.cadastrarVenda(vendaVitor2);
    admin.cadastrarVenda(vendaVitor3);
    
    TelaLogin telaLogin = new TelaLogin();
    telaLogin.setVisible(true);
    }
}
