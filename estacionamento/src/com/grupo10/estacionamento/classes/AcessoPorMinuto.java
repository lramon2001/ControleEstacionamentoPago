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
public class AcessoPorMinuto extends Acesso {

    public AcessoPorMinuto() {
        this.tarifa=0.5;
    }
    
    

    @Override
    public double calculaValor(Duration duracao) {
        double valor=duracao.toMinutes()*0.5;
        return valor;
    }
    
}
