/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import java.time.Duration;

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
     * @param duracao
     * @return
     */
    @Override
    public double calculaValor(Duration duracao) {
        return 0;
    }
    
    
    
}