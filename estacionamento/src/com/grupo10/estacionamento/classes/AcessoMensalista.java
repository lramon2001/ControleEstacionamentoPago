/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import com.grupo10.estacionamento.exceptions.PeriodoInvalidoException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

/**
 *
 * @Lucas Ramon
 */
public class AcessoMensalista extends Acesso{
    
    protected LocalDateTime entrada;
    protected LocalDateTime saida;
    protected Duration duracao;
    protected Period periodo;
    protected int id;
    protected double tarifa;
    protected double valor;

    public AcessoMensalista() {}

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate dia,LocalTime hora) {
        LocalDateTime entrada= LocalDateTime.of(dia, hora);
        this.entrada= entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDate dia, LocalTime hora) throws PeriodoInvalidoException {  
        
        LocalDateTime saida = LocalDateTime.of(dia, hora);
        if(saida.equals(this.entrada)){
            throw new PeriodoInvalidoException();
        }
        else{
             this.saida = saida;
        }
       
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Duration getDuracao() {
        return duracao;
    }
    
    public Period getPeriodo() {
        return periodo;
    }

    public void caculaPeriodo() {
        int anoEntrada=this.entrada.getYear();
        int mesEntrada=this.entrada.getMonthValue();
        int diaEntrada=this.entrada.getDayOfMonth();
        
        LocalDate entrada = LocalDate.of(anoEntrada, mesEntrada, diaEntrada);
        
        int anoSaida=this.saida.getYear();
        int mesSaida=this.saida.getMonthValue();
        int diaSaida=this.saida.getDayOfMonth();
        
        LocalDate saida = LocalDate.of(anoSaida, mesSaida, diaSaida);
        
        Period periodo = Period.between(entrada, saida);
        
        this.periodo = periodo;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public double calculaValor(Duration duracao) {
        return 0;
    }
   
    
    
}