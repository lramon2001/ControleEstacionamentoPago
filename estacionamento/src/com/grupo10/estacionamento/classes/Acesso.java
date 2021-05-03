package com.grupo10.estacionamento.classes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public abstract class Acesso {
    
    protected LocalDateTime entrada;
    protected LocalDateTime saida;
    protected Duration duracao;
    protected Period periodo;
    protected double tarifa;
    protected double valor;
    
    public Acesso(){   
    }

    public LocalDateTime getEntrada(){
        return entrada;   
    }

    public void setEntrada(LocalDate dia, LocalTime hora){
           LocalDateTime entrada = LocalDateTime.of(dia, hora);
           this.entrada = entrada;
    }

    public LocalDateTime getSaida(){
        return saida;
    }

    public void setSaida(LocalDate dia, LocalTime hora){
            LocalDateTime saida = LocalDateTime.of(dia, hora);
            this.saida = saida;
    }

    public void calculaPeriod(){
            LocalDateTime anoEntrada = this.entrada;
            
    }

 
    
}
