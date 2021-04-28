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
public class Veiculo {
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

    public void setMarca(String nome) {
        this.marca = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }
}