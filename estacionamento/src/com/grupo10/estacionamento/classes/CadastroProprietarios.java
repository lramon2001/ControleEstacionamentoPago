/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import com.grupo10.estacionamento.exceptions.DadosPessoaisIncompletosException;
import com.grupo10.estacionamento.interfaces.CadastroInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Ramon
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
    public CadastroProprietarios() {
        proprietarios=new ArrayList<>();
    }
    /*
       1-Implementar a assinatura do metodo cadastrar;
       2-Adicionar o objeto proprietario passado por parâmetro na lista;
    */

    /**
     *
     * @param p
     */
    @Override
    public void cadastrar(Proprietario p) {
        proprietarios.add(p);
    }
    
    /*
     1-Implementar a assinatura do metodo remover;
     2-Remover da lista o objeto que teve a posição na lista passada por parâmetro
    */
    @Override
    public void remover(int index){
        proprietarios.remove(index);
    }
    
    @Override
    public void listar(){
        /*
        1- Criar uma string lista que contenha as informações do usuário;
        2- Varrer a lista capturando todos os atributos de todos os objetos referenciadoos na lista de proprietarios;
        3- Criar uma apresentação ao usuário
        */
        String lista =" Proprietarios cadastrados\n";
        int i=0;
        for(Proprietario p: proprietarios){
            lista+="Proprietario "+(i)+":\n"+"Nome: "+p.getNome()+"\nCNH: "+p.getCnh()+"\nTelefone Celular: "+p.getnCelular()+"\nTelefone Residencial: "+p.getnResidencial()+"\nEndereço: "+p.getEndereco();
            i++;
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    
    @Override
    public Proprietario buscar(String cnh){
         /*
        1-Percorrer uma lista de proprietarios comparando a CNH;
        2-Quando a CNH for encontrada retorna o proprietario;
        3-Se não for encontrada retorna um Proprietario nulo e informa que não encontrou o proprietario;
         */
        Proprietario proprietarioProcurado =null;
        int frequencia=0;
        for(int i=0;i<proprietarios.size();i++){
            if(proprietarios.get(i).getCnh().equals(cnh)){
                proprietarioProcurado = proprietarios.get(i);
                frequencia++;
            }
        }
        
        if(proprietarioProcurado!=null){
            return proprietarioProcurado;
        }
        else{
            return null;
        }
    }

    

    

   
         
}
