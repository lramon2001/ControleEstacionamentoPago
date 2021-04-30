/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import com.grupo10.estacionamento.exceptions.DadosVeiculosIncompletosException;

/**
 *
 * @author USER
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
    
    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, String numeroPlaca) {
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
}
