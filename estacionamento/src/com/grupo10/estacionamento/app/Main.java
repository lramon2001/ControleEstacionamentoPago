package com.grupo10.estacionamento.app;

import com.grupo10.estacionamento.classes.Acesso;
import com.grupo10.estacionamento.classes.AcessoMensalista;
import com.grupo10.estacionamento.classes.CadastroAcessos;
import com.grupo10.estacionamento.classes.CadastroProprietarios;
import com.grupo10.estacionamento.classes.CadastroVeiculos;
import com.grupo10.estacionamento.classes.Proprietario;
import com.grupo10.estacionamento.classes.Veiculo;
import com.grupo10.estacionamento.classes.VeiculoMensalista;
import com.grupo10.estacionamento.exceptions.DadosPessoaisIncompletosException;
import com.grupo10.estacionamento.exceptions.DadosVeiculosIncompletosException;
import com.grupo10.estacionamento.exceptions.EstacionamentoFechadoException;
import com.grupo10.estacionamento.exceptions.PeriodoInvalidoException;
import java.time.Duration;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <p>
 * Classe <b>Main</b> Recebe o método main que é o runner de toda a
 * aplicação</p>
 *
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static CadastroVeiculos veiculos = new CadastroVeiculos();
    static CadastroProprietarios proprietarios = new CadastroProprietarios();
    static CadastroAcessos acessos = new CadastroAcessos();

    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() {
        int x;
        do {
            /*
            1-Fazer um menu textual para que o usuário possa escolher qual operação
            deseja realizar;
            2-Implementar os casos no switch case
             */
            String menu
                    = "Digite\n"
                    + "1-Cadastrar veículo rotativo;\n"
                    + "2-Cadastrar veiculo mensalista;\n"
                    + "3-Registrar acesso de usuário rotativo;\n"
                    + "4-Registrar acesso de usuário mensalista;\n"
                    + "5-Exibir veiculos cadastrados;\n"
                    + "6-Exibir proprietarios;\n"
                    + "7-Exibir listas de acessos;\n"
                    + "8-Exibir faturamento\n"
                    + "0-Sair";
            /*
              1-Passar a string menu como parâmetro para o JOptionPane;
              2-Ler a opção do usuário
             */
            String strx = JOptionPane.showInputDialog(null, menu);
            x = Integer.parseInt(strx);
            /*
              A string indisponivel será utilizada temporariamente para reportar 
              indisponibilidade de alguma funcionalidade;
             */
            String indisponivel = "Funcionalidade não implementada";
            switch (x) {
                case 1:

                    /*
                    Criando um novo registro de veiculo.
                    1-Instanciar um novo veiculo;
                    2-Setar todos os atributos do veiculo;
                    3-Se o carro já estiver registrado, lançar a exception veiculo já cadastrado;
                    4-Enviar uma mensagem de sucesso,caso seja bem sucedido.
                     */
                    Veiculo veiculo = new Veiculo();

                    try {
                        String strMarca = JOptionPane.showInputDialog("Digte a marca do veículo:");
                        veiculo.setMarca(strMarca);

                        String strModelo = JOptionPane.showInputDialog("Digte o modelo do veículo:");
                        veiculo.setModelo(strModelo);

                        String strPlaca = JOptionPane.showInputDialog("Digte a placa do veículo:");
                        veiculo.setNumeroPlaca(strPlaca);

                        if (veiculos.buscar(strPlaca) == null) {
                            veiculos.cadastrar(veiculo);
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
                   
                  
                    try {
                    Proprietario p = new Proprietario();
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
                    Veiculo vm = new VeiculoMensalista(p);

                    String strMarcaMensalista = JOptionPane.showInputDialog("Digte a marca do veículo:");
                    vm.setMarca(strMarcaMensalista);

                    String strModeloMensalista = JOptionPane.showInputDialog("Digte o modelo do veículo:");
                    vm.setModelo(strModeloMensalista);

                    String strPlacaMensalista = JOptionPane.showInputDialog("Digte a placa do veículo:");
                    vm.setNumeroPlaca(strPlacaMensalista);

                    if (veiculos.buscar(strPlacaMensalista) == null) {
                        veiculos.cadastrar(vm);
                    }

                } catch (DadosPessoaisIncompletosException erroDadosProprietarioIncompleto) {
                    System.out.println(erroDadosProprietarioIncompleto.getMessage());
                    JOptionPane.showMessageDialog(null, "Proprietario com dados Pessoais incompletos");
                } catch (DadosVeiculosIncompletosException erroDadosVeiculosIncompleto) {
                    System.out.println(erroDadosVeiculosIncompleto.getMessage());
                    JOptionPane.showMessageDialog(null, "Veiculo com dados incompletos");
                }

                break;
                case 3:
                    /*
                    1-Buscar a referencia de veiculo pela placa;
                    2-Setar a hora e data de entrada do veiculo;
                    3-Verificar o tipo de acesso;
                    4-Realizar o cálculo do valor a ser pago;
                    5-adicionar o acesso a lista de acessos;
                    6-Adicionar o custo do acesso a lista de faturamento;
                     */
                    String strPlacaRotativo = JOptionPane.showInputDialog("Digite o numero da placa");
                    Veiculo veiculoRotativo = veiculos.buscar(strPlacaRotativo);

                    String strDataEntradaRotativo = JOptionPane.showInputDialog(null, "Digte a data da entrada");
                    int[] inputDataEntradaRotativo = GerenciamentoEstacionamento.lerData(strDataEntradaRotativo);
                    LocalDate dataEntradaRotativo = LocalDate.of(inputDataEntradaRotativo[2], inputDataEntradaRotativo[1], inputDataEntradaRotativo[0]);

                    String strHoraEntradaRotativo = JOptionPane.showInputDialog("Digite a hora da entrada");
                    int[] inputHoraEntradaRotativo = GerenciamentoEstacionamento.lerHora(strHoraEntradaRotativo);
                    LocalTime horaEntradaRotativo = LocalTime.of(inputHoraEntradaRotativo[0], inputHoraEntradaRotativo[1]);

                    String strDataSaidaRotativo = JOptionPane.showInputDialog(null, "Digte a data da saída");
                    int[] inputDataSaidaRotativo = GerenciamentoEstacionamento.lerData(strDataSaidaRotativo);
                    LocalDate dataSaidaRotativo = LocalDate.of(inputDataSaidaRotativo[2], inputDataSaidaRotativo[1], inputDataSaidaRotativo[0]);

                    String strHoraSaidaRotativo = JOptionPane.showInputDialog("Digite a hora da saída");
                    int[] inputHoraSaidaRotativo = GerenciamentoEstacionamento.lerHora(strHoraSaidaRotativo);
                    LocalTime horaSaidaRotativo = LocalTime.of(inputHoraSaidaRotativo[0], inputHoraSaidaRotativo[1]);

                    LocalDateTime entradaRotativo = LocalDateTime.of(dataEntradaRotativo, horaEntradaRotativo);
                    LocalDateTime saidaRotativo = LocalDateTime.of(dataSaidaRotativo, horaSaidaRotativo);
                    try{
                    Acesso acessoRotativo = GerenciamentoEstacionamento.classificaAcesso(entradaRotativo, saidaRotativo);
                    acessos.cadastrar(acessoRotativo);
                    veiculoRotativo.setAcesso(acessoRotativo);
                    }
                    catch(NullPointerException nullPointerException){
                        JOptionPane.showMessageDialog(null,"Veiculo não encontrado.}");
                    }
                    break;
                case 4:
                    /*
                    1-Perguntar para o usuario qual é a placa do veiculo;
                    2-Colocar em uma variável local o retorno da consulta feita;
                    3-Instanciar um acesso de acordo com o tempo de permanênica 
                    no estacionamento (acesso: minuto,por 15 minutos,por hora,por diaria,pernoite);
                    4-Setar atributos do acesso;
                    3-Colocar o acesso na referencia de acessos de veiculo;
                     */
 /*
                    1-O método buscar procura na lista de veículos a referência pela a placa,atribuindo como resultado
                    da busca o objeto procurado haja vista que o retorno do metódo é capaz de retornar um veículo;
                     */
                    String strPlaca = JOptionPane.showInputDialog("Digite o numero da placa:");
                    Veiculo vm = veiculos.buscar(strPlaca);
                    /*
                    A instâcia "acesso" será utilizada para compor o acesso ao veículo;
                     */
                    Acesso acesso = new AcessoMensalista();

                    /*
                    O método lerData é utlizado para quebrar a String que é retornada pelo JOptionPane.showInputDialog;
                    Ele basicamente retorna um vetor de inteiros de três posições(inputDataEntrada) que é utilizado para 
                    setar a data no Objeto dataEntrada;
                     */
                    String strDataEntrada = JOptionPane.showInputDialog(null, "Digite a data da entrada");
                    int[] inputDataEntrada = GerenciamentoEstacionamento.lerData(strDataEntrada);
                    LocalDate dataEntrada = LocalDate.of(inputDataEntrada[2], inputDataEntrada[1], inputDataEntrada[0]);

                    /*
                    O método lerHora é utilizado para quebrar a String que é retornada pelo JOptionPane.showInputDialog;
                    Ele basicamente retorna um vetor de inteiros de duas posições(inputHoraEntrada) que é utlizado para
                    setar a hora no Objeto horaEntrada;
                     */
                    String strHoraEntrada = JOptionPane.showInputDialog("Digite a hora da entrada");
                    int[] inputHoraEntrada = GerenciamentoEstacionamento.lerHora(strHoraEntrada);
                    LocalTime horaEntrada = LocalTime.of(inputHoraEntrada[0], inputHoraEntrada[1]);

                    /*
                    O método setEntrada utiliza uma data e uma hora para setar a entrada; 
                    Esta data e hora foram obtidas pelo processos descritos acima.
                     */
                    String strDataSaida = JOptionPane.showInputDialog(null, "Digite a data da saída");
                    int[] inputDataSaida = GerenciamentoEstacionamento.lerData(strDataSaida);
                    LocalDate dataSaida = LocalDate.of(inputDataSaida[2], inputDataSaida[1], inputDataSaida[0]);

                    String strHoraSaida = JOptionPane.showInputDialog("Digite a hora da saída");
                    int inputHoraSaida[] = GerenciamentoEstacionamento.lerHora(strHoraSaida);
                    LocalTime horaSaida = LocalTime.of(inputHoraSaida[0], inputHoraSaida[1]);

                    try {
                        acesso.setEntrada(dataEntrada, horaEntrada);
                        acesso.setSaida(dataSaida, horaSaida);
                    } catch (PeriodoInvalidoException erroDePeriodoInvalido) {
                        System.out.println(erroDePeriodoInvalido.getMessage());
                        JOptionPane.showMessageDialog(null, "Erro: Periodo Inválido.");
                    } catch (EstacionamentoFechadoException erroDeEstacionamentoFechado) {
                        System.out.println(erroDeEstacionamentoFechado.getMessage());
                        JOptionPane.showMessageDialog(null, "Estacionamento Fechado.");
                    }
                    catch (NullPointerException nullPointerException){
                        JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
                    }

                    /*
                    O processo de setar a saída é exatamente igual ao de setar a entrada  
                     */
                    acesso.calculaDuracao();
                    /*
                    O método calculaDuracao é basicamente um setter especial. Ele utiliza os atributos entrada e saída
                    para calcular a duração e setar no atributo duracao do objeto acesso
                     */

 /*
                    O calculaPeriodo é basciamente um setter especial. Ele utiliza os atributos entrada e saída para calcular
                    
                     */
                    acesso.caculaPeriodo();

                    vm.setAcesso(acesso);

                    acessos.cadastrar(acesso);

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
                    veiculos.listarAcessos();
                    break;
                case 8:
                    exibeFaturamento();
                    break;
                case 0:
                    /*
                     1-Exibir mensagem de despedida amigável ao usuário;
                     */
                    JOptionPane.showMessageDialog(null, " UNB License © GRUPO10"
                            + "\n"
                            + "\n"
                            + "\nLucas- Paulo- Adrian- Arthur");
                    x = 0;
                    break;
            }
        } while (x != 0);

    }

    public static void exibeFaturamento() {
        String listaFaturamento = "Faturamento;\n\n";
        double total = 0;

        for (int i = 0; i < proprietarios.getProprietarios().size(); i++) {
            listaFaturamento += "Mensalista: " + proprietarios.getProprietarios().get(i).getNome()
                    + "\n" + "CNH:" + proprietarios.getProprietarios().get(i).getCnh() + "\n"
                    + "Valor:  500 R$\n";
            total += 500;
        }
        for (int i = 0; i < acessos.getAcessos().size(); i++) {
            listaFaturamento += "Acesso Rotativo \n" + "Tempo de permanência: " + acessos.getAcessos().get(i).getDuracao().toHoursPart() + "h "
                    + acessos.getAcessos().get(i).getDuracao().toMinutesPart() + "min"
                    + "\n Valor: " + acessos.getAcessos().get(i).getValor() + " R$";
            total += acessos.getAcessos().get(i).getValor();
        }
        listaFaturamento += "\n\nFaturamento Total: " + total + "R$";
        JOptionPane.showMessageDialog(null, listaFaturamento);
    }
}
