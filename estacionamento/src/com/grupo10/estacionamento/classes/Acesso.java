/**
 *
 * @author Adrian Soares Lopes
 */
package com.grupo10.estacionamento.classes;

import java.time.LocalDateTime;
import java.time.LocalDate;
import com.grupo10.estacionamento.classes.Veiculo;
//import  com.grupo10.estacionamento.classes.ModoEstacionamento
public class Acesso {
//referências:
    private Veiculo v;
//atributos:
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private LocalDate data;
    private float valor;
//métodos:
    public Acesso (LocalDateTime horaEntrada, LocalDateTime horaSaida, LocalDate data, Veiculo v) {
        setHoraEntrada (horaEntrada);
        setHoraSaida (horaSaida);
        setData (data);
        this.v = v;
        //setValor (ModoEstacionamento.calcular(getHoraEntrada(), getHoraSaida()));
    }

    //getters ()
    public LocalDateTime getHoraEntrada () { return this.horaEntrada; }
    public LocalDateTime getHoraSaida () { return this.horaSaida; }
    public LocalDate getData () { return this.data; }
    public float getValor () { return this.valor; }
    // setters ()
    public void setHoraEntrada (LocalDateTime horaEntrada) { // throws DadosPessoaisIncompletosException (especificar)
        if (!horaEntrada.isNull()) this.horaEntrada = horaEntrada;
        //else throw new DadosPessoaisIncompletosException(); (instanciar)
    }
    public void setHoraSaida (LocalDateTime horaSaida) { // throws DadosPessoaisIncompletosException (especificar)
        if (!horaSaida.isNull()) this.horaSaida = horaSaida;
        //else throw new DadosPessoaisIncompletosException(); (instanciar)
    }
    public void setData (LocalDate data) { // throws DadosPessoaisIncompletosException (especificar)
        if (!data.isNull()) this.data = data;
        //else throw new DadosPessoaisIncompletosException(); (instanciar)
    }
}


