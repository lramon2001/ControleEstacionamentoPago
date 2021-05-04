package com.grupo10.estacionamento.classes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import com.grupo10.estacionamento.exceptions.PeriodoInvalidoException;

public class Acesso {

    protected LocalDateTime entrada;
    protected LocalDateTime saida;
    protected Duration duracao;
    protected Period periodo;
    protected double tarifa;
    protected double valor;

    public Acesso() {
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate dia, LocalTime hora) throws PeriodoInvalidoException{
        LocalDateTime entrada = LocalDateTime.of(dia, hora);
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDate dia, LocalTime hora) throws PeriodoInvalidoException {
        LocalDateTime saida = LocalDateTime.of(dia, hora);
        this.saida = saida;
    }

    public Period calculaPeriodo() {
        int anoEntrada = this.entrada.getYear();
        int mesEntrada = this.entrada.getMonthValue();
        int diaEntrada = this.entrada.getDayOfMonth();

        LocalDate entrada = LocalDate.of(anoEntrada, mesEntrada, diaEntrada);

        int anoSaida = this.saida.getYear();
        int mesSaida = this.saida.getMonthValue();
        int diaSaida = this.saida.getDayOfMonth();

        LocalDate saida = LocalDate.of(anoSaida, mesSaida, diaSaida);

        this.periodo = Period.between(entrada, saida);
        return this.periodo;
    }

    public final Duration calculaDuracao() {
        this.duracao = Duration.between(this.entrada, this.saida);
        return this.duracao;
    }
/*  Implementar cálculo de valor!!!
    public abstract double calculaValor();
*/
}