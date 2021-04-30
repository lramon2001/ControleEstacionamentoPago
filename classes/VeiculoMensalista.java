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
public class VeiculoMensalista extends Veiculo {

    private Proprietario proprietario;

    public VeiculoMensalista(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public VeiculoMensalista(Proprietario proprietario, String marca, String modelo, String numeroPlaca) {
        super(marca, modelo, numeroPlaca);
        this.proprietario = proprietario;
    }

    public VeiculoMensalista() {
   
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

}
