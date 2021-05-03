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
public class AcessoMensalista extends Acesso {

    public AcessoMensalista() {
        this.valor=0;
        this.tarifa=500;        
    }

    /**
     *
     * @return
     */
    @Override
    public double calculaValor() {
        return 0;
    }
    
    
    
}
