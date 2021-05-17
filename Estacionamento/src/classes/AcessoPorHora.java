package classes;

import exceptions.EstacionamentoFechadoException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * Classe <b>AcessoPorHora </b> </p>
 * <p>
 * Define a estrutura de um acesso de um usario rotativo por hora na
 * Aplicação</p>
 * <p>
 * Herda atributo e métodos da classe abstrata Acesso</p>
 *
 * @author Lucas Ramon
 * @author Paulo Henrique
 * @since may 2021
 * @version 1.0
 */
public class AcessoPorHora extends Acesso {

    /**
     * <b>método</b> calculaValor<br>
     * <b>uso:</b> <br>
     * acessoPorHora.calculaValor();<br>
     * Este método calcula o custo de um acesso por hora.
     *
     * @param duracao faz referência a duracao do acesso
     * @param tarifa faz referência a tarifa aplicada no calculo do custo
     * @return <b>double:</b> custo do acesso
     */
    @Override
    public double calculaValor(Duration duracao, double tarifa) {
        /*
         * 1- instânciar um objeto da classe AcessoPorQuinze
         * 2- colocar o valor na variável preço o retorno da calculaValor do objeto da classe AcessoPorQuinze
         * 3- calcular um valor do desconto
         * 4- retornar o preço com desconto 
        */
        Acesso acesso = new AcessoPorQuinze();
        double preco = acesso.calculaValor(duracao, tarifa);

        Duration umaHora = Duration.ofMinutes(60);
        long nDescontos = (duracao.toMinutes()) / umaHora.toMinutes();

        return preco - nDescontos;

    }

    /**
     *
     * Setter do atributo <b>entrada</b><br>
     * <b>uso:</b><br>
     * acesso.setEntrada(LocalDate dia, LocalTime hora);
     *
     * @param dia faz referência a data da entrada do acesso.
     * @param hora faz referência a hora da entrada do acesso.
     * @throws EstacionamentoFechadoException Não é possivel acessar o
     * estacionamento como rotativo entre 20:00 hrs e 6:00 hrs.
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
