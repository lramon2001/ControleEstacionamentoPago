package com.grupo10.estacionamento.classes;
import java.time.Duration;

public class AcessoPorHora extends Acesso {

    @Override
    public double calculaValor (Duration duracao) {
        Acesso acesso = new AcessoPorQuinze();
        double preco = acesso.calculaValor(duracao);

        Duration umaHora = Duration.ofMinutes(60);
        long nDescontos = (duracao.toMinutes()) % 15;

        return preco - nDescontos * 1;

    }
}
