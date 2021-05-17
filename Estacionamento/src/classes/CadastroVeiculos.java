/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 */
import interfaces.CadastroInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * <p>
 * Classe <b>CadastroVeiculos</b> </p>
 * <p>
 * Define a estrutura de cadastros de veiculos da aplicação</p>
 * <p>
 * Implementa a interface CadastroInterface</p>
 *
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 */
public class CadastroVeiculos implements CadastroInterface<Veiculo> {

    /*
    1-Criar uma lista que guarde os objetos veiculos;
    2-Fazer um método que cadastre o objeto na lista;
    3-Fazer um método que remova o objeto da lista;
    4-Fazer um método que liste os objetos da lista;
    5-Fazer um método de busca passando a placa por parâmetro;
    6-Implementar construtores.
     */
    private List<Veiculo> veiculos = new ArrayList<Veiculo>();

    /*
      1-Criar um construtor que ao instanciar a classe ele já crie a referencia da lista;
     */
    /**
     * Construtor sobrecarregado da classe  <b>CadastroVeiculos</b> <br><br>
     * <b> uso:</b> <br>
     * CadastoVeiculos cadastoVeiculos= new CadastroVeiculos(List veiculos);
     *
     * @param veiculos faz referência a lista de veiculos
     */
    public CadastroVeiculos(List<Veiculo> veiculos) {
        veiculos = new ArrayList<>();
    }

    /**
     *
     * Construtor default da classe  <b>CadastroVeiculos</b> <br><br>
     * <b> uso:</b> <br>
     * CadastoVeiculos cadastoVeiculos= new CadastroVeiculos();
     */
    public CadastroVeiculos() {
        veiculos = new ArrayList<>();
    }

    /*
       1-Implementar a assinatura do metodo cadastrar;
       2-Adicionar o objeto proprietario passado por parâmetro na lista;
     */
    /**
     * <b>método</b> cadastrar<br>
     * <b>uso:</b> <br>
     * cadastoVeiculos.cadastrar(Veiculo veiculo);<br>
     * Este método adicona um veiculo a Lista de veiculos.
     *
     * @param veiculo faz referência ao veiculo que será adcionado a lista
     */
    @Override
    public void cadastrar(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    /**
     * <b>método</b> cadastrar<br>
     * <b>uso:</b> <br>
     * cadastoVeiculos.cadastrar(VeiculoMensalista veiculoMensalista);<br>
     * Este método adicona um veiculo mensalista a Lista de veiculos.
     *
     * @param veiculoMensalista faz referência ao Veiculo mensalista que será
     * adcionado a lista
     */
    public void Cadastrar(VeiculoMensalista veiculoMensalista) {
        veiculos.add(veiculoMensalista);
    }

    /*
     1-Implementar a assinatura do metodo remover;
     2-Remover da lista o objeto que teve a posição na lista passada por parâmetro
     */
    /**
     * <b>método</b> remover<br>
     * <b>uso:</b> <br>
     * cadastoVeiculos.remover(int index);<br>
     * Este método remove um veiculo da Lista de veiculos.
     *
     * @param index faz refência a posição do veiculo na lista.
     */
    @Override
    public void remover(int index) {
        veiculos.remove(index);
    }

    /**
     * <b>método</b> buscar<br>
     * <b>uso:</b> <br>
     * cadastoVeiculos.buscar( String placa);<br>
     * Este método procura o objeto veiculo na lista e retorna a busca. Se não
     * houver algum veiculo com a placa passada por paramentro, o método retorna
     * nulo.
     *
     * @param placa faz referência a placa do veiculo
     * @return <b>Veiculo:</b> veiculo procurado
     */
    @Override
    public Veiculo buscar(String placa) {
        /*
        1-Percorrer uma lista de veiculos comparando a placa;
        2-Quando a placa for encontrada retorna o veiculo
        3-Se não for encontrada retorna um veiculo nulo e informa que não encontrou o veiculo;
        4-Se encontrar mais de um veiculo retorna excecao;
         */
        Veiculo veiculoProcurado = null;
        int frequencia = 0;
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getNumeroPlaca().equalsIgnoreCase(placa)) {
                veiculoProcurado = veiculos.get(i);

                frequencia++;
            }
        }
        if (frequencia == 1) {
            return veiculoProcurado;
        } else {
            if (frequencia > 1) {
                JOptionPane.showMessageDialog(null, "O veiculo já foi cadastrado");
            }
          
            return null;
        }
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * <b>método</b> listar<br>
     * <b>uso:</b> <br>
     * cadastoVeiculoos.listar();<br>
     * Este método exibe a Lista de veiculos.
     */
    @Override
    public void listar() {
        /*
        1- Criar uma string lista que contenha as informações do veículo;
        2- Varrer a lista capturando todos os atributos de todos os objetos referenciadoos na lista de veiculos;
        3- Criar uma apresentação ao usuário.
         */
        String lista = "Veículos cadastrados\n";
        int i = 0;
        for (Veiculo v : veiculos) {

            lista += "Veiculo " + (i) + ":\n" + "Marca: " + v.getMarca() + "\n" + "Modelo: " + v.getModelo() + "\n" + "Placa: " + v.getNumeroPlaca() + "\n";
            i++;
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    /**
     * <b>método</b> listar<br>
     * <b>uso:</b> <br>
     * cadastoVeiculos.listar();<br>
     * Este método exibe a Lista de acessos.
     */
    public void listarAcessos() {
    	String lista = "Acessos\n\n";
        int i = 0;
        for (Veiculo v : veiculos) {
            if (v.mostraTodosAcessosDoVeiculo().length() > 0) {
                lista += "Acessos do veículo nº " + (i + 1) +" do cadastro de veículos. "+"\nPlaca do veículo nº "+(i+1) +": "+ v.getNumeroPlaca() + "\nModelo do veículo nº "+(i+1) +": "+ v.getModelo() + "\n" + v.mostraTodosAcessosDoVeiculo();
                i++;
            }

        }
        JOptionPane.showMessageDialog(null, lista);
    }

}
