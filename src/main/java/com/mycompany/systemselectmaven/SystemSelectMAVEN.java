/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.systemselectmaven;

import java.util.Scanner;
import netbeans.Administracao;
import netbeans.Computador;
import netbeans.Usuario;
import netbeans.Venda;


public class SystemSelectMAVEN {

    public static void main(String[] args) {
        Administracao dono = new Administracao();
        Usuario cliente1 = new Usuario("Carlos", "CarlosMiguel123");
        
        int entrada = 0;
        
        while(entrada != 4){
            

        System.out.println("====System Select====");
        System.out.println("====SEJA BEM VINDO===");
        System.out.println("Escolha que item deseja gerenciar:");
        System.out.println("1- Usuários");
        System.out.println("2- Estoque");
        System.out.println("3- Vendas");
        System.out.println("4- Sair");
        
        Scanner scanner = new Scanner(System.in);
        entrada = scanner.nextInt();
        
        switch(entrada){
            case 1:
                System.out.println("==Gerenciador de Usuários==");
                System.out.println("Selecione uma operação:");
                System.out.println("1- Cadastrar um Usuário");
                System.out.println("2- Listar todos os Usuários");
                System.out.println("3- Editar um Usuário");
                System.out.println("4- Excluir um Usuário");
                
                int entradaUsuario = scanner.nextInt();
                
                switch(entradaUsuario){
                    case 1:
                        System.out.println("Informe o nome completo do Usuário:");
                        String nome = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe a senha que o Usuário deseja utilizar:");
                        String senha = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe o email que o Usuário deseja utilizar:");
                        String email = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("O Usuário deseja cadastrar o cartão[S/N]?");
                        String opcao = scanner.next();
                        
                        String numCartao = null;
                        if(opcao.equals("S") || opcao.equals("s")){
                            System.out.println("Informe o número do cartão:");
                            numCartao = scanner.next();   
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            numCartao = "null";
                        }
                        
                        scanner.nextLine();
                        
                        System.out.println("O Usuário é um Administrador?[S/N]");
                        opcao = scanner.nextLine();
                        String tipo = null;
                        if(opcao.equals("S") || opcao.equals("s")){
                            tipo = "Administrador";
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            tipo = "Cliente";
                        }
                        
                        Usuario novoUsuario = new Usuario(nome, senha, email, numCartao, tipo);
                        dono.cadastrarUsuario(novoUsuario);
                        break;
                        
                    case 2:
                        dono.consultarUsuarios();
                        break;
                        
                    case 3:
                        System.out.println("Informe o nome do Usuário que deseja atualizar os dados:");
                        String nomePesquisa = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe o novo nome para o usuário:");
                        nome = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe a nova senha para o usuário:");
                        senha = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe o novo email para o usuário:");
                        email = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Deseja atualizar o número do cartão[S/N]?");
                        opcao = scanner.next();
                        
                        numCartao = null;
                        if(opcao.equals("S") || opcao.equals("s")){
                            System.out.println("Informe o novo número de cartão do usuário:");
                            numCartao = scanner.next();   
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            numCartao = "null";
                        }
                        
                        scanner.nextLine();
                        
                        System.out.println("O Usuário é um Administrador?[S/N]");
                        opcao = scanner.nextLine();
                        tipo = null;
                        if(opcao.equals("S") || opcao.equals("s")){
                            tipo = "Administrador";
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            tipo = "Cliente";
                        }
                        
                        Usuario usuario = new Usuario(nome, senha, email, numCartao, tipo);
                        dono.atualizarUsuario(usuario, nomePesquisa);
                        break;
                        
                    case 4:
                        System.out.println("Informe o nome do Usuário que deseja deletar:");
                        nomePesquisa = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Tem certeza que deseja remover este usuário[S/N]?");
                        opcao = scanner.next();
                        scanner.nextLine();
                        
                        if(opcao.equals("S") || opcao.equals("s")){
                            dono.removerUsuario(nomePesquisa);
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            System.out.println("Operação Cancelada!");
                        }
                        break;
                }
                
                break;
                
            case 2:
                System.out.println("==Gerenciador de Estoque==");
                System.out.println("Selecione uma operação:");
                System.out.println("1- Cadastrar um Item");
                System.out.println("2- Listar todos os Item");
                System.out.println("3- Editar um Item");
                System.out.println("4- Excluir um Item");
                
                int entradaEstoque = scanner.nextInt();
                
                switch(entradaEstoque){
                    
                    case 1:
                        System.out.println("Informe o nome do item:");
                        String nome = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe a marca do item:");
                        String marca = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("O item é Desktop ou Notebook[D/N]?");
                        String opcao = scanner.next();
                        String tipo = null;
                        
                        if(opcao.equals("D") || opcao.equals("d")){
                            tipo = "Desktop";
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            tipo = "Notebook";
                        }
                        
                        double preco = 0;
                        
                        
                        while(preco <= 0 ){
                           System.out.println("Informe o preço do item: [ex: 1200.00]");
                           preco = scanner.nextDouble();
                           
                           if(preco <= 0){
                               System.out.println("Valor inválido, tente novamente.");
                           }
                        }
                        
                        int quantidade = 0;
                        
                        while(quantidade <= 0){
                            System.out.println("Informe a quantidade de itens:");
                            quantidade = scanner.nextInt();
                            
                            if(quantidade <= 0){
                                System.out.println("Valor inválido, tente novamente.");
                            }
                        }
                        
                        Computador novoComputador = new Computador(nome, marca, tipo, preco, quantidade);
                        dono.cadastrarComputador(novoComputador);
                        break;
                    
                    case 2:
                        dono.consultarComputadores();
                        break;
                        
                    case 3:
                        System.out.println("Informe o nome do Item que deseja editar:");
                        String nomePesquisa = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe o novo nome do Item:");
                        nome = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe a nova marca do Item:");
                        marca = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("O item é Desktop ou Notebook[D/N]?");
                        opcao = scanner.next();
                        tipo = null;
                        
                        
                        if(opcao.equals("D") || opcao.equals("d")){
                            tipo = "Desktop";
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            tipo = "Notebook";
                        }
                            preco = 0;
                        
                        while(preco <= 0 ){
                           System.out.println("Informe o novo preço do item: [ex: 1200.00]");
                           preco = scanner.nextDouble();
                           
                           if(preco <= 0){
                               System.out.println("Valor inválido, tente novamente.");
                           }
                        }
                        
                        quantidade = 0;
                           
                        while(quantidade <= 0){
                            System.out.println("Informe a nova quantidade de itens:");
                            quantidade = scanner.nextInt();
                            
                            if(quantidade <= 0){
                                System.out.println("Valor inválido, tente novamente.");
                            }
                        }
                        
                        Computador computador = new Computador(nome, marca, tipo, preco, quantidade);
                        dono.atualizarComputador(computador, nome);
                        break;
                        
                    case 4:
                        System.out.println("Informe o nome do Item que deseja deletar:");
                        nomePesquisa = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Tem certeza que deseja remover este item[S/N]?");
                        opcao = scanner.next();
                        scanner.nextLine();
                        
                        if(opcao.equals("S") || opcao.equals("s")){
                            dono.removerUsuario(nomePesquisa);
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            System.out.println("Operação Cancelada!");
                        }
                        break; 
                        
                }
                break;
                
            case 3:
                System.out.println("==Gerenciador de Vendas==");
                System.out.println("Selecione uma operação:");
                System.out.println("1- Cadastrar um Venda");
                System.out.println("2- Listar todas as Vendas");
                System.out.println("3- Editar um Venda");
                System.out.println("4- Excluir um Venda");
                
                int entradaVendas = scanner.nextInt();
                
                switch(entradaVendas){
                    case 1:
                        System.out.println("Informe a data da venda:");
                        String dataVenda = scanner.next();
                        scanner.nextLine();  
                        
                        System.out.println("Informe o nome do cliente que efetuou a compra:");
                        String nomeCliente = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe o nome do item que o cliente comprou:");
                        String nomeItem = scanner.next();
                        scanner.nextLine();
                        
                        Usuario usuario = dono.encontrarUsuario(nomeCliente);
                        Computador item = dono.encontrarComputador(nomeItem);
                        Venda novaVenda = new Venda(dataVenda, usuario, item);
                        dono.cadastrarVenda(novaVenda);
                    break;
                    
                    case 2:
                        dono.consultarVendas();
                        break;
                        
                    case 3:
                        int idVenda = 0;
                        
                        while(idVenda <= 0){
                        System.out.println("Informe o Id da venda que deseja atualizar");
                        idVenda = scanner.nextInt();
                        scanner.nextLine();
                        
                        if(idVenda <= 0){
                            System.out.println("Valor inválido, tente novamente");
                        }
                        }
                        System.out.println("Informe o nome do novo usuário que efetuou a compra");
                        nomeCliente = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe o nome do novo item que o usuário comprou");
                        nomeItem = scanner.next();
                        scanner.nextLine();
                        
                        System.out.println("Informe a nova data da venda:");
                        String data = scanner.next();
                        scanner.nextLine();
                        
                        Usuario encontrarCliente = dono.encontrarUsuario(nomeCliente);
                        Computador encontrarItem = dono.encontrarComputador(nomeItem);
                        Venda venda = new Venda(data, encontrarCliente, encontrarItem);
                        
                        idVenda = idVenda-1;
                        
                        dono.atualizarVenda(venda, idVenda);
                        
                        break;
                        
                    case 4:
                        System.out.println("Informe o ID da Venda que deseja deletar:");
                        idVenda = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Tem certeza que deseja remover esta venda[S/N]?");
                        String opcao = scanner.next();
                        scanner.nextLine();
                        
                        if(opcao.equals("S") || opcao.equals("s")){
                            idVenda = idVenda-1;
                            dono.removerVenda(idVenda);
                        }
                        
                        if(opcao.equals("N") || opcao.equals("n")){
                            System.out.println("Operação Cancelada!");
                        }
                        
                }
                
                break;
        }
        
                }
        System.out.println("Saindo do programa... Obrigado por utilizar o nosso sistema!");
        
        
    }
}
