/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * <p>
 * Classe <b>EstacionamentoFechadoException</b> </p>
 * <p>
 * Define a estrutura da exception EstacionamentoFechado</p>
 * <p>
 * Herda atributo e métodos da classe Exception</p>
 *
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 */
public class EstacionamentoFechadoException extends Exception {

    public EstacionamentoFechadoException() {
        super("Exception in thread:com.grupo10.estacionamento.exceptions.DadosPessoaisIncompletosException");
    }

}
