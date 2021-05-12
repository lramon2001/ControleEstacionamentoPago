package classes;

import exceptions.EstacionamentoFechadoException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * Classe <b>AcessoPorDiaria </b> </p>
 * <p>
 * Define a estrutura de um acesso de um usario rotativo por diaria na
 * Aplicação</p>
 * <p>
 * Herda atributo e métodos da classe abstrata Acesso</p>
 *
 * @author Lucas Ramon
 * @author Paulo Henrique
 * @since may 2021
 * @version 1.0
 */
public class AcessoPorDiaria extends Acesso {

    /**
     * Construtor default da classe  <b>AcessoPorDiaria</b> <br><br>
     * <b> uso:</b> <br>
     * AcessoPorDiaria acesso = new AcessoPorDiaria();
     */
    public AcessoPorDiaria() {

    }

    /**
     *
     * <b>método</b> calculaValor<br>
     * <b>uso:</b> <br>
     * acessoPorDiaria.calculaValor();<br>
     * Este método calcula o custo de um acesso por diária.
     *
     * @param duracao faz referência a duracao do acesso
     * @param tarifa faz referência a tarifa aplicada no calculo do custo
     * @return <b>double:</b> custo do acesso
     */
    @Override
    public double calculaValor(Duration duracao, double tarifa) {
        Acesso acesso = new AcessoPorMinuto();
        double preco = 110;
        Duration restante = duracao.minusHours(9);
        preco += acesso.calculaValor(restante, 0.2);
        return preco;
    }

    /**
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
