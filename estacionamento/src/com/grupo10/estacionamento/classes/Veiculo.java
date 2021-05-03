/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import com.grupo10.estacionamento.exceptions.DadosVeiculosIncompletosException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Ramon
 */
public class Veiculo {
    /*
    1-Criar atributos marca,modelo e numero da Placa;
    2-Criar os métodos getters e setters.
    3-Implementar construtores.
    */
    private String marca;
    private String modelo;
    private String numeroPlaca;
    private java.util.List<Acesso> acessos=new ArrayList<Acesso>();
    
    public Veiculo() {
        acessos=new ArrayList<>();
    }

    public Veiculo(String marca, String modelo, String numeroPlaca) {
        acessos=new ArrayList<>();
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPlaca = numeroPlaca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String nome) throws DadosVeiculosIncompletosException{
        if(nome.length()==0){
            throw new DadosVeiculosIncompletosException();
        }
        else{
            this.marca = nome;
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws DadosVeiculosIncompletosException {
        if(modelo.length()==0){
          throw new DadosVeiculosIncompletosException();
        }
        else{
            this.modelo = modelo;
        }
        
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) throws DadosVeiculosIncompletosException {
        if(numeroPlaca.length()==0){
            throw new DadosVeiculosIncompletosException();
        }
        this.numeroPlaca = numeroPlaca;
    }
    
     public void setAcesso(Acesso a){
        acessos.add(a);
    }

    public List<Acesso> getAcessos() {
        return acessos;
    }
    
    public String mostraTodosAcessosDoVeiculo(){
        String lista="";
        for(int i=0;i<acessos.size();i++){
        lista+="Entrada: "+acessos.get(i).getEntrada()+"\n"+
                "Saída: "+acessos.get(i).getSaida()+"\n"+
                "Tempo de permanênicia:"+acessos.get(i).getDuracao()+"\n"+
                "Valor a ser cobrado:"+acessos.get(i).getValor()+" R$\n\n";
                
        }
        return lista;
    }
     
}
