/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.app;

import com.grupo10.estacionamento.classes.CadastroVeiculos;
import com.grupo10.estacionamento.classes.Veiculo;
import com.grupo10.estacionamento.classes.VeiculoMensalista;
//import com.grupo10.estacionamento.classes.CadastroProprietarios; (Importar)
//import com.grupo10.estacionamento.classes.CadastroAcessos; (Importar)
import com.grupo10.estacionamento.classes.Acesso;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas 
 */
public class Main {

    
    static CadastroVeiculos veiculos =new CadastroVeiculos();
    static CadastroProprietarios proprietarios =new CadastroProprietarios();
    //Formatador de Data:
    static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
     
        public static void main(String[] args) {
            menu();
        }
        public static void menu(){

            int x;
            do{

                String menu="Digite\n"+
                    "1-Cadastrar veículo rotativo;\n"+
                    "2-Cadastrar veiculo mensalista;\n"+
                    "3-Registrar acesso de usuário rotativo;\n"+
                    "4-Registrar acesso de usuário mensalista;\n"+
                    "5-Exibir veiculos cadastrados;\n"+
                    "6-Exibir proprietarios;\n"+
                    "7-Exibir listas de acessos;\n"+
                    "8-Exibir faturamento\n";
                String strx=JOptionPane.showInputDialog(null, menu);
                x=Integer.parseInt(strx);
                switch(x){
                    case 1:
                        /*
                        1-Criar o objeto veiculo rotativo;
                        2-Setar marca,modelo e placa;
                        3-Guardar no cadastro de veiculos.
                        */

                        cadastrarVeiculo();

                        break;
                    case 2:
                        /*
                        1-Criar o objeto veiculo mensalista;
                        2-Criar o objeto proprietario;
                        3-Setar marca,modelo,placa e proprietário;
                        4-Guardar no cadastro de veiculos.
                        5-Guardar no registro de funcionarios
                        */
                        VeiculoMensalista vm = new VeiculoMensalista();
                        Proprietario p;

                        String strMarca2=JOptionPane.showInputDialog("Digte a marca do veículo:");
    //                    vm.setMarca(strMarca2);

                        String strModelo2=JOptionPane.showInputDialog("Digte o modelo do veículo:");
    //                    vm.setModelo(strModelo2);

                        String strPlaca2=JOptionPane.showInputDialog("Digte a placa do veículo:");
    //                    vm.setNumeroPlaca(strPlaca2);

    //              Dados do proprietário:
                        String strProprietario = JOptionPane.showInputDialog("Digite o Nome Completo do Proprietário");
                        String strEndereco = JOptionPane.showInputDialog("Digite o Endereço do Prorpietário");
                        String nCelular = JOptionPane.showInputDialog("Digite o celular do Prorpietário");
                        String nResidencial = JOptionPane.showInputDialog("Digite o telefone residencial do Prorpietário");
                        String cnh = JOptionPane.showInputDialog("Digite a CNH do Prorpietário");

    //                    p = new Proprietario(strProprietario, strEndereco, nCelular, nResidencial, cnh);
    //                    proprietarios.cadastrar(p);

                         /*
                         -Criar o objeto proprietário para setar no veiculo vm;
                         -Atualizar a lista;
                         */

    //                     veiculos.cadastrar(vm);

                        break;
                    case 3:
                        /*
                        Implementar a model de acesso rotativo,assim como a classe cadastro de acessos;
                        */
                    //Dados Acesso:
                        strPlaca = JOptionPane.showInputDialog("Digite a placa do Veículo");
                        entrada = JOptionPane.showInputDialog("Horário de Entrada: (HH:mm)");
                        saida = JOptionPane.showInputDialog("Horário de Saída: (HH:mm)");
                        data = JOptionPane.showInputDialog("Data: (dd/MM/yyyy)");
                    //Processando Datas:
                        dataFull1 = entrada + " " + data;
                        dataFull2 = saida + " " + data;

                        LocalDateTime formatado1 = LocalDateTime.parse(dataFull1, FORMATO_DATA); //hora entrada
                        LocalDateTime formatado2 = LocalDateTime.parse(dataFull2, FORMATO_DATA); //hora saída
                        LocalDate dt = LocalDate.parse(data, FORMATO_DATA);

                        /* Modelo de acesso
                        vAcesso =  veiculos.buscar(strPLaca);
                        if (vAcesso.isNull()) vAcesso = cadastrarVeiculo();

                        Acesso ac = new Acesso(formatado1, formatado2, dt, vAcesso);
                        acessos.cadastrar(ac);
                        */
                        break;
                    case 4:
                     /*
                        Implementar a model de acesso mensal,assim como a classe cadastro de acessos;
                        */
                        break;
                    case 5:
                        veiculos.listarVeiculos();
                        break;
                    case 6:
                        /*
                        Implementar listas de proprietários;
                        */
                        break;
                    case 7:
                        /*
                        Implementar
                        */
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Obrigado por usar nosso software\n");
                        x=0;
                        break;
                }
        }
       while(x!=0);

    }
    static Veiculo cadastrarVeiculo() {
        Veiculo v = new Veiculo();

        String strMarca=JOptionPane.showInputDialog("Digte a marca do veículo:");
        v.setMarca(strMarca);

        String strModelo=JOptionPane.showInputDialog("Digte o modelo do veículo:");
        v.setModelo(strModelo);

        String strPlaca=JOptionPane.showInputDialog("Digte a placa do veículo:");
        v.setNumeroPlaca(strPlaca);

        veiculos.cadastrar(v);

        return v;
    }




}