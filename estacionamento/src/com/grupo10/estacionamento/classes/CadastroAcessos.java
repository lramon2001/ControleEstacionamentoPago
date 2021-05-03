/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import com.grupo10.estacionamento.interfaces.CadastroInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class CadastroAcessos implements CadastroInterface<Acesso> {
    /*
    1-Criar uma lista que guarde os objetos cadastros;
    2-Fazer um método que cadastre o objeto na lista;
    3-Fazer um método que liste os objetos da lista;
    4-Fazer um método que liste os objetos da lista;
    5-Fazer um método de busca passando o id por parametro;
    */
    
    private List<Acesso> acessos=new ArrayList<Acesso>();
    private List<Veiculo> veiculos = new ArrayList<Veiculo>();
    public CadastroAcessos() {
        this.veiculos=veiculos;
        acessos= new ArrayList<>();
    }
     /*
       1-Implementar a assinatura do metodo cadastrar;
       2-Adicionar o objeto proprietario passado por parâmetro na lista;
    */
  
    
    @Override
    public void cadastrar(Acesso a) {
        acessos.add(a);
    }
     /*
     1-Implementar a assinatura do metodo remover;
     2-Remover da lista o objeto que teve a posição na lista passada por parâmetro
    */

    @Override
    public void remover(int index) {
        acessos.remove(index);
    }

    @Override
    public void listar() {
         /*
        1- Criar uma string lista que contenha as informações do usuário;
        2- Varrer a lista capturando todos os atributos de todos os objetos referenciadoos na lista de proprietarios;
        3- Criar uma apresentação ao usuário
        */
        String lista="";
        for(Veiculo v: this.veiculos){
            v.mostraTodosAcessosDoVeiculo();
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Acesso buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
}
