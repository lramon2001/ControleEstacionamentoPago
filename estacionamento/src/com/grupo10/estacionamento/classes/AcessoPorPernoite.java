
package com.grupo10.estacionamento.classes;

import java.time.Duration;
import java.time.LocalDateTime;


public class AcessoPorPernoite extends Acesso{

    public AcessoPorPernoite() {
        super();
	}
    @Override
	public double calculaValor (Duration d) {
        double valor = 0;

        LocalDateTime entrada = super.getEntrada();
        LocalDateTime saida = super.getSaida();

        long dias = Duration.between(entrada, saida).toDays();
        Duration total = Duration.between(entrada, saida);
        long dezHoras = Duration.ofHours(10).toHours();
        long horasPernoite = dias * dezHoras;
        long diaria = total.toHours() - horasPernoite;

        if (!entrada.toLocalDate().equals(saida.toLocalDate())) {

            valor = dias * 30;
        }
        valor += new AcessoPorDiaria().calculaValor(Duration.ofHours(diaria));
        return valor;
    }
}
