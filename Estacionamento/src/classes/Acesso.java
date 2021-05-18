/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.EstacionamentoFechadoException;
import exceptions.PeriodoInvalidoException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

/**
 *
 * <p>
 * Classe abstrata<b>Acesso </b> </p>
 * <p>
 * Define a estrutura de um veículo na Aplicação</p>
 *
 * @author Paulo Henrique
 * @since may 2021
 * @version 1.0
 */
public abstract class Acesso {

    protected LocalDateTime entrada;
    protected LocalDateTime saida;
    protected Duration duracao;
    protected Period periodo;
    protected int id;
    protected double tarifa;
    protected double valor;

    /**
     * Construtor default da classe  <b>Acesso</b> <br><br>
     * <b> uso:</b> <br>
     * Acesso acesso = new Acesso();
     */
    public Acesso() {
    }

    /**
     * Construtor sobrecarregado da classe <b>Veiculo</b> <br> <br>
     * <b>uso (exemplo):</b><br>
     * Acesso acesso= new Acesso (LocalDateTime entrada, LocalDateTime saida
     * ,0.5,27);<br> <br>
     * <b>onde:</b> <br>
     *
     * @param entrada faz referência ao momento da entrada do acesso.
     * @param saida faz referência ao momento da saída do acesso.
     * @param tarifa faz referência a tarifa utilizada para o cálculo
     * @param valor faz referência ao valor a ser cobrado pelo acesso
     */
    public Acesso(LocalDateTime entrada, LocalDateTime saida, double tarifa, double valor) {
        this.entrada = entrada;
        this.saida = saida;
        this.tarifa = tarifa;
        this.valor = valor;
    }

    /**
     * Getter do atributo <b>entrada</b><br>
     * <b>uso:</b><br>
     * acesso.getEntrada();
     *
     * @return <b>LocalDateTime: </b> estado do atributo entrada
     *
     */
    public LocalDateTime getEntrada() {
        return entrada;
    }

    /**
     * Getter do atributo <b>saida</b><br>
     * <b>uso:</b><br>
     * acesso.getSaida();
     *
     * @return <b>LocalDateTime: </b> estado do atributo saida
     */
    public LocalDateTime getSaida() {
        return saida;
    }

    /**
     * Setter do atributo <b>saida</b><br>
     * <b>uso:</b><br>
     * acesso.setSaida(LocalDate dia, LocalTime hora);
     *
     * @param dia faz referência a data da saída do acesso.
     * @param hora faz referência a hora da saída do acesso.
     * @throws PeriodoInvalidoException Não é possivel atribuir o mesmo dia e
     * hora da entrada a saida.
     */
    public void setSaida(LocalDate dia, LocalTime hora) throws PeriodoInvalidoException {

        LocalDateTime saida = LocalDateTime.of(dia, hora);
        if (saida.isEqual(this.getEntrada()) || saida.isBefore(this.getEntrada())) {
            throw new PeriodoInvalidoException();
        } else {
            this.saida = saida;
        }

    }

    /**
     * Getter do atributo <b>tarifa</b><br>
     * <b>uso:</b><br>
     * acesso.getTarifa();
     *
     * @return <b>double: </b> valor da tarifa
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Setter do atributo <b>tarifa</b> <br>
     * <b> uso:</b><br>
     * acesso.setTarifa(double tarifa);
     *
     * @param tarifa: <b>double</b>
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Getter do atributo <b>valor</b><br>
     * <b>uso:</b><br>
     * acesso.getValot();
     *
     * @return <b>double: </b> valor a ser cobrado pelo acesso
     */
    public double getValor() {
        return valor;
    }

    /**
     * Setter do atributo <b>valor</b> <br>
     * <b> uso:</b><br>
     * acesso.setValor(double valor);
     *
     * @param valor: <b>double</b>
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Getter do atributo <b>duracao</b><br>
     * <b>uso:</b><br>
     * acesso.getDuracao();
     *
     * @return <b>Duration: </b> tempo de permanênica do veículo no
     * estacionamento
     */
    public Duration getDuracao() {
        return duracao;
    }

    /**
     * Getter do atributo <b>periodo</b><br>
     * <b>uso:</b><br>
     * acesso.getPeriodo();
     *
     * @return <b>Duration: </b> Periodo de permanênica do veículo no
     * estacionamento
     */
    public Period getPeriodo() {
        return periodo;
    }

    /**
     * <b>método</b> calculaPeriodo<br>
     * <b>uso:</b> <br>
     * acesso.calculaPeriodo();<br>
     * Este método calcula o período do acesso em dias,meses e anos.
     *
     * @return <b>Period:</b> período do acesso;
     */
    public Period caculaPeriodo() {
        int anoEntrada = this.entrada.getYear();
        int mesEntrada = this.entrada.getMonthValue();
        int diaEntrada = this.entrada.getDayOfMonth();

        LocalDate entrada = LocalDate.of(anoEntrada, mesEntrada, diaEntrada);

        int anoSaida = this.saida.getYear();
        int mesSaida = this.saida.getMonthValue();
        int diaSaida = this.saida.getDayOfMonth();

        LocalDate saida = LocalDate.of(anoSaida, mesSaida, diaSaida);

        Period periodo = Period.between(entrada, saida);

        this.periodo = periodo;
        return periodo;
    }

    /**
     * Setter do atributo <b>duracao</b> <br>
     * <b> uso:</b><br>
     * acesso.setDuracao(Duration duracao);
     *
     * @param duracao: <b>Duration</b>
     */
    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * <b>método</b> calculaDuracao<br>
     * <b>uso:</b> <br>
     * acesso.calculaDuracao();<br>
     * Este método calcula a duração do acesso em horas,minutos e segundos.
     *
     * @return <b>Duration:</b> duração do acesso;
     */
    public final Duration calculaDuracao() {
        duracao = Duration.between(this.entrada, this.saida);
        return this.duracao;
    }
    

    public abstract double calculaValor(Duration duracao, double tarifa);

    public abstract void setEntrada(LocalDate dia, LocalTime hora) throws EstacionamentoFechadoException;

}
