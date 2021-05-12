/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.DadosPessoaisIncompletosException;
import interfaces.CadastroInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * <p>
 * Classe <b>CadastroProprietarios</b> </p>
 * <p>
 * Define a estrutura de cadastros de proprietários da aplicação</p>
 * <p>
 * Implementa a interface CadastroInterface</p>
 *
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 */
public class CadastroProprietarios implements CadastroInterface<Proprietario> {

    /*
    1-Criar uma lista que guarde os objetos proprietarios;
    2-Fazer um método que cadastre o objeto na lista;
    3-Fazer um método que remova o objeto da lista;
    4-Fazer um método que liste os objetos da lista;
    5-Fazer um método de busca passando a cnh por parâmetro;
    6-Implementar construtores.
     */
    private List<Proprietario> proprietarios = new ArrayList<Proprietario>();

    /*
      1-Criar um construtor que ao instanciar a classe ele já crie a referencia da lista;
     */
    /**
     * Construtor default da classe  <b>CadastroProprietarios</b> <br><br>
     * <b> uso:</b> <br>
     * CadastoProprietarios cadastoProprietarios = new CadastroProprietarios();
     */
    public CadastroProprietarios() {
        proprietarios = new ArrayList<>();
    }

    /*
       1-Implementar a assinatura do metodo cadastrar;
       2-Adicionar o objeto proprietario passado por parâmetro na lista;
     */
    /**
     * <b>método</b> cadastrar<br>
     * <b>uso:</b> <br>
     * cadastoProprietarios.cadastrar(Proprietario proprietario);<br>
     * Este método adicona um acesso a Lista de proprietarios.
     *
     * @param proprietario faz referência ao proprietario
     */
    @Override
    public void cadastrar(Proprietario proprietario) {
        proprietarios.add(proprietario);
    }

    /*
     1-Implementar a assinatura do metodo remover;
     2-Remover da lista o objeto que teve a posição na lista passada por parâmetro
     */
    /**
     * <b>método</b> remover<br>
     * <b>uso:</b> <br>
     * cadastoProprietarios.remover(int index);<br>
     * Este método remove um acesso da Lista de proprietarios.
     *
     * @param index faz refência a posição do proprietario na lista.
     */
    @Override
    public void remover(int index) {
        proprietarios.remove(index);
    }

    /**
     * <b>método</b> listar<br>
     * <b>uso:</b> <br>
     * cadastoProprietarios.listar();<br>
     * Este método exibe a Lista de proprietarios.
     */
    @Override
    public void listar() {
        /*
        1- Criar uma string lista que contenha as informações do usuário;
        2- Varrer a lista capturando todos os atributos de todos os objetos referenciadoos na lista de proprietarios;
        3- Criar uma apresentação ao usuário
         */
        String lista = " Proprietarios cadastrados\n";
        int i = 0;
        for (Proprietario p : proprietarios) {
            lista += "Proprietario " + (i+1) + ":\n" + "Nome: " + p.getNome() + "\nCNH: " + p.getCnh() + "\nTelefone Celular: " + p.getnCelular() + "\nTelefone Residencial: " + p.getnResidencial() + "\nEndereço: " + p.getEndereco()+"\n";
            i++;
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    /**
     * <b>método</b> buscar<br>
     * <b>uso:</b> <br>
     * cadastoProprietarios.buscar( String cnh);<br>
     * Este método procura o objeto proprietario na lista e retorna a busca. Se
     * não houver algum proprietario com a cnh passada por paramentro, o método
     * retorna nulo.
     *
     * @param cnh faz referência a CNH do proprietario
     * @return <b>Proprietario:</b> proprietario procurado
     */
    @Override
    public Proprietario buscar(String cnh) {
        /*
        1-Percorrer uma lista de proprietarios comparando a CNH;
        2-Quando a CNH for encontrada retorna o proprietario;
        3-Se não for encontrada retorna um Proprietario nulo e informa que não encontrou o proprietario;
         */
        Proprietario proprietarioProcurado = null;
        int frequencia = 0;
        for (int i = 0; i < proprietarios.size(); i++) {
            if (proprietarios.get(i).getCnh().equals(cnh)) {
                proprietarioProcurado = proprietarios.get(i);
                frequencia++;
            }
        }

        if (proprietarioProcurado != null) {
            return proprietarioProcurado;
        } else {
            return null;
        }
    }

    public List<Proprietario> getProprietarios() {
        return proprietarios;
    }
    
}
