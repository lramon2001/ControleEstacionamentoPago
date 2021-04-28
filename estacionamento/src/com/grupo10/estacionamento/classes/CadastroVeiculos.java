/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class CadastroVeiculos {
    private List<Veiculo>veiculos=new ArrayList<Veiculo>();

    public CadastroVeiculos(List<Veiculo>veiculos) {
       veiculos=new ArrayList<>();    
    }
     public CadastroVeiculos() {
       veiculos=new ArrayList<>();    
    }
    public void cadastrar(Veiculo v){
        veiculos.add(v);
    }
    public void remover(int index){
        veiculos.remove(index);
    }
    public void listarVeiculos(){
       String lista = "Veículos cadastrados\n"; ;
       int i=0;
       for(Veiculo v: veiculos){
           
           lista+= "Veiculo "+(i+1)+":\n"+"Marca: "+v.getMarca()+"\n"+"Modelo: "+v.getModelo()+"\n"+"Placa:"+v.getNumeroPlaca()+"\n";
           i++;
       }
        JOptionPane.showMessageDialog(null, lista);
    }
}