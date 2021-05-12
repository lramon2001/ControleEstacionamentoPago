/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.CadastroInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * <p>
 * Classe <b>CadastroAcessos</b> </p>
 * <p>
 * Define a estrutura de cadastros de acessos da aplicação</p>
 * <p>
 * Implementa a interface CadastroInterface</p>
 *
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 */
public class CadastroAcessos implements CadastroInterface<Acesso> {

    /*
    1-Criar uma lista que guarde os objetos cadastros;
    2-Fazer um método que cadastre o objeto na lista;
    3-Fazer um método que liste os objetos da lista;
    4-Fazer um método que liste os objetos da lista;
    5-Fazer um método de busca passando o id por parametro;
     */
    private List<Acesso> acessos = new ArrayList<Acesso>();
    private List<Veiculo> veiculos = new ArrayList<Veiculo>();

    /**
     * Construtor default da classe  <b>CadastroAcessos</b> <br><br>
     * <b> uso:</b> <br>
     * CadastoAcessos cadastoAcessos = new CadastroAcessos();
     */
    public CadastroAcessos() {
        this.veiculos = veiculos;
        acessos = new ArrayList<>();
    }

    /*
       1-Implementar a assinatura do metodo cadastrar;
       2-Adicionar o objeto proprietario passado por parâmetro na lista;
     */
    /**
     * <b>método</b> cadastrar<br>
     * <b>uso:</b> <br>
     * cadastoAcesos.cadastrar(Acesso a);<br>
     * Este método adicona um acesso a Lista de acessos.
     *
     * @param acesso faz referência ao acesso
     */
    @Override
    public void cadastrar(Acesso acesso) {
        acessos.add(acesso);
    }

    /*
     1-Implementar a assinatura do metodo remover;
     2-Remover da lista o objeto que teve a posição na lista passada por parâmetro
     */
    /**
     * <b>método</b> remover<br>
     * <b>uso:</b> <br>
     * cadastoAcesos.remover(int index);<br>
     * Este método remove um acesso da Lista de acessos.
     *
     * @param index faz refência a posição do acesso na lista.
     */
    @Override
    public void remover(int index) {
        acessos.remove(index);
    }

    /**
     * <b>método</b> listar<br>
     * <b>uso:</b> <br>
     * cadastoAcesos.listar();<br>
     * Este método exibe a Lista de acessos.
     */
    @Override
    public void listar() {
        /*
        1- Criar uma string lista que contenha as informações do usuário;
        2- Varrer a lista capturando todos os atributos de todos os objetos referenciadoos na lista de proprietarios;
        3- Criar uma apresentação ao usuário
         */
        String lista = "";
        for (Veiculo v : this.veiculos) {
            v.mostraTodosAcessosDoVeiculo();
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    @Override
    public Acesso buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Acesso> getAcessos() {
        return acessos;
    }
    
    

}
