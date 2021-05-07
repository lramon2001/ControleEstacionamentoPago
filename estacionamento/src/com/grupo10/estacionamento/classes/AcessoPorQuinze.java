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
public class AcessoPorQuinze extends Acesso{

    @Override
    public double calculaValor(Duration duracao) {
        Acesso acesso=new AcessoPorMinuto();
        double preco=acesso.calculaValor(duracao);
        Duration quinzeMinutos =Duration.ofMinutes(15);
        long  nDescontos = (duracao.toMinutes())/ quinzeMinutos.toMinutes() ;
        return preco- nDescontos*0.5;
                //]-(nDescontos*0.5);
    }
    
}
