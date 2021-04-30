/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class CadastroProprietarios {
    
    /*
    1-Criar uma lista que guarde os objetos proprietarios
    2-Fazer um método que cadastre o objeto na lista
    */
    private List<Proprietario> proprietarios = new ArrayList<Proprietario>();

    public CadastroProprietarios() {
        proprietarios=new ArrayList<>();
    }
    
    public void cadastrarProprietario (Proprietario p){
        proprietarios.add(p);
    }
    
    public void remover(int index){
        proprietarios.remove(index);
    }
    
    public void listar(){
        String lista =" Proprietarios cadastrados\n";
        int i=0;
        for(Proprietario p: proprietarios){
            lista+="Proprietario "+(i+1)+":\n"+"Nome: "+p.getNome()+"\nCNH: "+p.getCnh()+"\nTelefone Celular: "+p.getnCelular()+"\nTelefone Residencial: "+p.getnResidencial()+"\nEndereço: "+p.getEndereco();
            i++;
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    
    public Proprietario buscar(String cnh){
         /*
        1-Percorrer uma lista de proprietarios comparando a CNH;
        2-Quando a CNH for encontrada retorna o Proprietario;
        3-Se não for encontrada retorna um veiculo nulo e informa que não encontrou o veiculo;
        4-Se encontrar mais de um veiculo retorna excecao;
         */
        Proprietario proprietarioProcurado =null;
        int frequencia=0;
        for(int i=0;i<proprietarios.size();i++){
            if(proprietarios.get(i).getCnh().equals(cnh)){
                proprietarioProcurado = proprietarios.get(i);
                frequencia++;
            }
        }
        if(frequencia==1){
            return proprietarioProcurado;
        }
        else{
            if(frequencia>1){
                JOptionPane.showMessageDialog(null, "O proprietário já foi cadastrado");
            }
            return null;
        }
    }
         
}
