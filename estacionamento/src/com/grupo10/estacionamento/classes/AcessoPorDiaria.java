
package com.grupo10.estacionamento.classes;

import java.time.Duration;

public class AcessoPorDiaria extends Acesso {
    double tarifaHora = 110.0;

	public AcessoPorDiaria() {
	    super();
    }

    public double calculaValor(Duration d) {
	    long horas = d.toHours();
	    Duration noveHoras = Duration.ofHours(9);
	    long pastNove = horas - noveHoras.toHours();

	    Acesso minutosPastNove = new AcessoPorMinuto();
	    double valorMinutos = minutosPastNove.calculaValor(Duration.ofHours(pastNove));

		double valor;

	    if(pastNove > 0) {
			valor = this.tarifaHora + valorMinutos;
		}
	    else valor = new AcessoPorHora().calculaValor(d);

	    return valor;
    }
    
}
