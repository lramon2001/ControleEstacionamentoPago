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
 * Classe <b>AcessoPorQuinze </b> </p>
 * <p>
 * Define a estrutura de um acesso de um usario rotativo por frações de quinze
 * minutos na Aplicação</p>
 * <p>
 * Herda atributo e métodos da classe abstrata Acesso</p>
 *
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 */
public class AcessoPorQuinze extends Acesso {

    /**
     *
     * <b>método</b> calculaValor<br>
     * <b>uso:</b> <br>
     * acessoPorQuinze.calculaValor();<br>
     * Este método calcula o custo de um acesso por fraçôes de quinze minutos.
     *
     * @param duracao faz referência a duração do acesso
     * @param tarifa faz referência a tarifa aplicada no calculo do custo
     * @return <b>double:</b> custo do acesso
     */
    @Override
    public double calculaValor(Duration duracao, double tarifa) {
        /*
         * 1- instânciar um objeto da classe AcessoPorMinuto
         * 2- colocar o valor na variável preço o retorno da calculaValor do objeto da classe AcessoPorMinuto
         * 3- calcular um valor do desconto
         * 4- retornar o preço com desconto
        */
        Acesso acesso = new AcessoPorMinuto();
        double preco = acesso.calculaValor(duracao, tarifa);
        Duration quinzeMinutos = Duration.ofMinutes(15);
        long nDescontos = (duracao.toMinutes()) / quinzeMinutos.toMinutes();
        return preco - nDescontos * 0.5;
    }

    /**
     *
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
