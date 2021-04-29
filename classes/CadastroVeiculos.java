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
    public void cadastrarRotativo(Veiculo v){
        veiculos.add(v);
    }
    public void CadastrarMensalista(VeiculoMensalista vm){
        veiculos.add(vm);    
    }
    public void remover(int index){
        veiculos.remove(index);
    }
    public void listar(){
       String lista = "Veículos cadastrados\n"; ;
       int i=0;
       for(Veiculo v: veiculos){
           
           lista+= "Veiculo "+(i+1)+":\n"+"Marca: "+v.getMarca()+"\n"+"Modelo"+v.getModelo()+"\n"+"Placa:"+v.getNumeroPlaca()+"\n";
           i++;
       }
        JOptionPane.showMessageDialog(null, lista);
    }
    public Veiculo buscar(String placa) {
        /*
        1-Percorrer uma lista de veiculos comparando a placa;
        2-Quando a placa for encontrada retorna o veiculo
        3-Se não for encontrada retorna um veiculo nulo e informa que não encontrou o veiculo;
        4-Se encontrar mais de um veiculo retorna excecao;
         */
        Veiculo veiculoProcurado = null;
        int frequencia=0;
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getNumeroPlaca().equals(placa)) {
                veiculoProcurado = veiculos.get(i);
                 
                 frequencia++;
            }
        }
        if(frequencia==1){
            return  veiculoProcurado;
        }
        else{
            if(frequencia>1){
                 JOptionPane.showMessageDialog(null, "O veiculo já foi cadastrado");
            }
            return null;
        }
    }
}
