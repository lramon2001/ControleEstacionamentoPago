package classes;

import exceptions.EstacionamentoFechadoException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * Classe <b>AcessoPorPernoite </b> </p>
 * <p>
 * Define a estrutura de um acesso de um usario rotativo por pernoite na
 * Aplicação</p>
 * <p>
 * Herda atributo e métodos da classe abstrata Acesso</p>
 *
 * @author Lucas Ramon
 * @author Paulo Henrique
 * @since may 2021
 * @version 1.0
 */
public class AcessoPorPernoite extends Acesso {

    /**
     * Construtor default da classe  <b>AcessoPorPernoite</b> <br><br>
     * <b> uso:</b> <br>
     * AcessoPorPernoite acesso = new AcessoPorPernoite();
     */
    public AcessoPorPernoite() {

    }

    /**
     *
     * <b>método</b> calculaValor<br>
     * <b>uso:</b> <br>
     * acessoPorPernoite.calculaValor();<br>
     * Este método calcula o custo de um acesso por pernoite.
     *
     * @param duracao faz referência a duracao do acesso
     * @param tarifa faz referência a tarifa aplicada no calculo do custo
     * @return <b>double:</b> custo do acesso
     */
    @Override
    public double calculaValor(Duration duracao, double tarifa) {
        double preco = 30;
        Duration dezenoveHoras = Duration.ofHours(19);
        int menorQueDezenoveHoras = duracao.compareTo(dezenoveHoras);
        if (menorQueDezenoveHoras == -1 || menorQueDezenoveHoras == 0) {
            Duration restante = duracao.minus(Duration.ofHours(10));
            Acesso acesso = new AcessoPorHora();
            preco += acesso.calculaValor(restante, 0.5);
        } else {
            Duration restante = duracao.minus(Duration.ofHours(10));
            Acesso acesso = new AcessoPorDiaria();
            preco += acesso.calculaValor(restante, 0.2);
        }

        return preco;
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
