package com.grupo10.estacionamento.app;


import com.grupo10.estacionamento.classes.CadastroProprietarios;
import com.grupo10.estacionamento.classes.CadastroVeiculos;
import com.grupo10.estacionamento.classes.Proprietario;
import com.grupo10.estacionamento.classes.Veiculo;
import com.grupo10.estacionamento.classes.VeiculoMensalista;
import com.grupo10.estacionamento.exceptions.DadosPessoaisIncompletosException;
import com.grupo10.estacionamento.exceptions.DadosVeiculosIncompletosException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static CadastroVeiculos veiculos =new CadastroVeiculos(); 
    static CadastroProprietarios proprietarios=new CadastroProprietarios();
    public static void main(String[] args) throws Exception {
         menu();
    }
    public static void menu(){
 
        int x;
        do{
            /*
            1-Fazer um menu textual para que o usuário possa escolher qual operação
            deseja realizar;
            2-Implementar os casos no switch case
            */
            String menu=
                "Digite\n"+
                "1-Cadastrar veículo rotativo;\n"+
                "2-Cadastrar veiculo mensalista;\n"+
                "3-Registrar acesso de usuário rotativo;\n"+
                "4-Registrar acesso de usuário mensalista;\n"+
                "5-Exibir veiculos cadastrados;\n"+
                "6-Exibir proprietarios;\n"+
                "7-Exibir listas de acessos;\n"+
                "8-Exibir faturamento\n"+
                "0-Sair"
                ;
            /*
              1-Passar a string menu como parâmetro para o JOptionPane;
              2-Ler a opção do usuário
            */
            String strx=JOptionPane.showInputDialog(null, menu);
            x=Integer.parseInt(strx);
            /*
              A string indisponivel será utilizada temporariamente para reportar 
              indisponibilidade de alguma funcionalidade;
            */
            String indisponivel="Funcionalidade não implementada";
            switch (x) {
                case 1:
                    
                    /*
                    Criando um novo registro de veiculo.
                    1-Instanciar um novo veiculo;
                    2-Setar todos os atributos do veiculo;
                    3-Se o carro já estiver registrado, lançar a exception veiculo já cadastrado;
                    4-Enviar uma mensagem de sucesso,caso seja bem sucedido.
                     */
                    Veiculo v = new Veiculo();
                    
                    try {
                        String strMarca = JOptionPane.showInputDialog("Digte a marca do veículo:");
                        v.setMarca(strMarca);

                        String strModelo = JOptionPane.showInputDialog("Digte o modelo do veículo:");
                        v.setModelo(strModelo);

                        String strPlaca = JOptionPane.showInputDialog("Digte a placa do veículo:");
                        v.setNumeroPlaca(strPlaca);

                        if (veiculos.buscar(strPlaca) == null) {
                            veiculos.cadastrar(v);
                        }
                    } catch (DadosVeiculosIncompletosException erroDadosVeiculosIncompleto) {
                        System.out.println(erroDadosVeiculosIncompleto.getMessage());
                        JOptionPane.showMessageDialog(null, "Veiculo com dados incompletos");
                    }
                    

                    break;
                case 2:
                    /*
                    Criando um novo registro de veiculo mensalista
                    1-Instaciar um novo veiculo mensalista;
                    2-Setar tudo referente ao veiculo;
                    3-Se o veiculo já estiver registrado,lançar a exception veiculo já cadastrado;
                    4-Adicionar veiculo a lista;
                    5-Criar um objeto Proprietario;
                    6-Setar tudo do proprietario e adicionar vincular o veiculo
                    */
                   
                  
                    try{
                    Proprietario p =new Proprietario();
                    String strNome = JOptionPane.showInputDialog("Digte o nome do proprietario:");
                    p.setNome(strNome);
                    
                     
                    String strCnh = JOptionPane.showInputDialog("Digte o numero da CNH:");
                    p.setCnh(strCnh);

                    String strEndereco = JOptionPane.showInputDialog("Digte o endereço do proprietario:");
                    p.setEndereco(strEndereco);

                    String strNcelular = JOptionPane.showInputDialog("Digte o telefone celular:");
                    p.setnCelular(strNcelular);
                    
                    String strNresidencial = JOptionPane.showInputDialog("Digte o telefone residencial:");
                    p.setnResidencial(strNresidencial);
                    System.out.println("com.grupo10.estacionamento.app.Main.menu()");
                    System.out.println(strCnh);
                    proprietarios.cadastrar(p);
                    /*
                    -Instanciando o Veiculo com o método de substuição de Liskov;
                    -Polimorfismo;
                    */
                    Veiculo vm= new VeiculoMensalista(p);
                    
                    String strMarcaMensalista = JOptionPane.showInputDialog("Digte a marca do veículo:");
                    vm.setMarca(strMarcaMensalista);

                    String strModeloMensalista = JOptionPane.showInputDialog("Digte o modelo do veículo:");
                    vm.setModelo(strModeloMensalista);

                    String strPlacaMensalista = JOptionPane.showInputDialog("Digte a placa do veículo:");
                    vm.setNumeroPlaca(strPlacaMensalista);
                     
                    if(veiculos.buscar(strPlacaMensalista)==null){
                         veiculos.cadastrar(vm);
                    }
                    
                    }
                    catch (DadosPessoaisIncompletosException erroDadosProprietarioIncompleto){
                     System.out.println(erroDadosProprietarioIncompleto.getMessage());
                     JOptionPane.showMessageDialog(null,"Proprietario com dados Pessoais incompletos");
                    }
                    catch (DadosVeiculosIncompletosException erroDadosVeiculosIncompleto) {
                        JOptionPane.showMessageDialog(null, "Veiculo com dados incompletos");
                    }
                    
                                    
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, indisponivel);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, indisponivel);
                    break;
                case 5:
                    /* 1-Chamar o método listar do atributo veiculos
                         que é uma lista guarda objetos da classe Veiculo
                         por meio desta referênica;                        
                    */
                    veiculos.listar();
                    break;
                case 6:
                  
                    /* 1-Chamar o método listar do atributo proprietarios
                         que é uma lista guarda objetos da classe Proprietario
                         por meio desta referênica;                        
                    */
                   
                      proprietarios.listar();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, indisponivel);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, indisponivel);
                    break;
                case 0:
                    /*
                     1-Exibir mensagem de despedida amigável ao usuário;
                    */
                    JOptionPane.showMessageDialog(null, "Obrigado por usar nosso software\n");
                    x = 0;
                    break;
            }
        } while (x != 0);
    
}
    
}
