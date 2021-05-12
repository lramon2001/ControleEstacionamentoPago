/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.EstacionamentoFechadoException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * Classe <b>AcessoPorMinuto </b> </p>
 * <p>
 * Define a estrutura de um acesso de um usario rotativo por diaria na
 * Aplicação</p>
 * <p>
 * Herda atributo e métodos da classe abstrata Acesso</p>
 *
 * @author Paulo Henrique
 * @since may 2021
 * @version 1.0
 */
public class AcessoPorMinuto extends Acesso {

    /**
     * Construtor default da classe  <b>AcessoPorMinuto</b> <br><br>
     * <b> uso:</b> <br>
     * AcessoPorMinuto acesso = new AcessoPorMinuto();
     */
    public AcessoPorMinuto() {
        this.tarifa = 0.5;
    }

    /**
     *
     * <b>método</b> calculaValor<br>
     * <b>uso:</b> <br>
     * acessoPorMinuto.calculaValor();<br>
     * Este método calcula o custo de um acesso por minuto.
     *
     * @param duracao faz referência a duracao do acesso
     * @param tarifa faz referência a tarifa aplicada no calculo do custo
     * @return <b>double:</b> custo do acesso
     */
    @Override
    public double calculaValor(Duration duracao, double tarifa) {
        /*
            O método calculaValor da classe AcessoPorMinuto recebe uma duração 
            e a transforma em um valor inteiro. Guardando na variável valor, o
            produto feito entre número de minutos e a tarifa do estacionamento. 
        */
        double valor = duracao.toMinutes() * tarifa;
        return valor;
    }

    /**
     * Setter do atributo <b>entrada</b><br>
     * <b>uso:</b><br>
     * acesso.setEntrada(LocalDate dia, LocalTime hora);
     *
     * @param dia faz referência a data da entrada do acesso.
     * @param hora faz referência a hora da entrada do acesso.
     * @throws EstacionamentoFechadoException Não é possivel atribuir o mesmo
     * dia e hora da entrada a saida.
     */
    @Override
    public void setEntrada(LocalDate dia, LocalTime hora) throws EstacionamentoFechadoException {
        LocalDateTime entrada = LocalDateTime.of(dia, hora);
        if (entrada.getHour() >= 20 || entrada.getHour() < 6) {
            throw new EstacionamentoFechadoException();
        } else {
            this.entrada = entrada;
        }
    }
}
