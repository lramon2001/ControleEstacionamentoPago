/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.app;

import com.grupo10.estacionamento.classes.CadastroVeiculos;
import com.grupo10.estacionamento.classes.Veiculo;
// import com.grupo10.estacionamento.classes.VeiculoMensalista;
// import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas 
 */
public class Main {

    
    static CadastroVeiculos veiculos =new CadastroVeiculos(); 
     
     
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
                     Veiculo v = new Veiculo();
                     
                     String strMarca=JOptionPane.showInputDialog("Digte a marca do veículo:");
                     v.setMarca(strMarca);
                     
                     String strModelo=JOptionPane.showInputDialog("Digte o modelo do veículo:");
                     v.setModelo(strModelo);
                     
                     String strPlaca=JOptionPane.showInputDialog("Digte a placa do veículo:");
                     v.setNumeroPlaca(strPlaca);
                     
                     veiculos.cadastrar(v);
                     
                     
                    break;
                case 2:
                    /*
                    1-Criar o objeto veiculo mensalista;
                    2-Criar o objeto proprietario;
                    3-Setar marca,modelo,placa e proprietário;
                    4-Guardar no cadastro de veiculos.
                    5-Guardar no registro de funcionarios
                    */
                    // VeiculoMensalista vm=new VeiculoMensalista();
             
                     
                    //  String strMarca2=JOptionPane.showInputDialog("Digte a marca do veículo:");
//                     vm.setMarca(strMarca2);
                     
                    //  String strModelo2=JOptionPane.showInputDialog("Digte o modelo do veículo:");
//                     vm.setModelo(strModelo2);
                     
                    //  String strPlaca2=JOptionPane.showInputDialog("Digte a placa do veículo:");
//                     vm.setNumeroPlaca(strPlaca2); 
                     
                    //  String strProprietario=JOptionPane.showInputDialog("Digite");
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
    
}