/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

/**
 *
 * @author Lucas Ramon
 */
import com.grupo10.estacionamento.interfaces.CadastroInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class CadastroVeiculos implements CadastroInterface<Veiculo>{
      /*
    1-Criar uma lista que guarde os objetos veiculos;
    2-Fazer um método que cadastre o objeto na lista;
    3-Fazer um método que remova o objeto da lista;
    4-Fazer um método que liste os objetos da lista;
    5-Fazer um método de busca passando a placa por parâmetro;
    6-Implementar construtores.

    */
    private List<Veiculo>veiculos=new ArrayList<Veiculo>();
 /*
      1-Criar um construtor que ao instanciar a classe ele já crie a referencia da lista;
    */

    public CadastroVeiculos(List<Veiculo>veiculos) {
       veiculos=new ArrayList<>();    
    }
     public CadastroVeiculos() {
       veiculos=new ArrayList<>();    
    }
     /*
       1-Implementar a assinatura do metodo cadastrar;
       2-Adicionar o objeto proprietario passado por parâmetro na lista;
    */

    @Override
    public void cadastrar(Veiculo v){
        veiculos.add(v);
    }
    
    public void Cadastrar(VeiculoMensalista vm){
        veiculos.add(vm);    
    }
        /*
     1-Implementar a assinatura do metodo remover;
     2-Remover da lista o objeto que teve a posição na lista passada por parâmetro
    */

    @Override
    public void remover(int index){
        veiculos.remove(index);
    }

    
    @Override
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

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    @Override
    public void listar() {
          /*
        1- Criar uma string lista que contenha as informações do veículo;
        2- Varrer a lista capturando todos os atributos de todos os objetos referenciadoos na lista de veiculos;
        3- Criar uma apresentação ao usuário.
        */
       String lista = "Veículos cadastrados\n"; 
       int i=0;
       for(Veiculo v: veiculos){
           
           lista+= "Veiculo "+(i)+":\n"+"Marca: "+v.getMarca()+"\n"+"Modelo: "+v.getModelo()+"\n"+"Placa: "+v.getNumeroPlaca()+"\n";
           i++;
       }
        JOptionPane.showMessageDialog(null, lista);
    }
    
    public void listarAcessos(){
        
        String lista="Acessos\n";
        int i=0;
        for(Veiculo v:veiculos){
      
            lista+="Placa: "+v.getNumeroPlaca()+"\nModelo: "+v.getModelo()+"\n"+v.mostraTodosAcessosDoVeiculo();
             
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    
    
}
