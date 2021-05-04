/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import com.grupo10.estacionamento.exceptions.DadosVeiculosIncompletosException;

import java.time.LocalDateTime;
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
        StringBuilder lista= new StringBuilder();
        for (Acesso acesso : acessos) {
            LocalDateTime entrada = acesso.getEntrada();
            LocalDateTime saida = acesso.getSaida();
            lista.append("Entrada: Dia: " + entrada.toLocalDate().toString() + " Hora: " + entrada.toLocalTime().toString() + "\n")
                    .append("Saída: Dia: " + saida.toLocalDate().toString() + " Hora: " + saida.toLocalTime().toString() + "\n")
                    .append("Tempo de permanênicia: ").append(acesso.calculaDuracao().toString()).append("\n\n");
            //Implementar Cálculo de Valor!!!
            //       .append("Valor a ser cobrado: "+acessos.get(i).getValor()+" R$\n\n");.llll;

        }
        return lista.toString();
    }
     
}
