/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import classes.Acesso;
import classes.AcessoPorDiaria;
import classes.AcessoPorHora;
import classes.AcessoPorMinuto;
import classes.AcessoPorPernoite;
import classes.AcessoPorQuinze;
import exceptions.EstacionamentoFechadoException;
import exceptions.PeriodoInvalidoException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 * <p>
 * Classe <b>GerenciamentoEstacionamento</b> Recebe métodos de leitura,validação
 * e filtragem da aplicação</p>
 *
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 */
public class GerenciamentoEstacionamento {

    /*
    O método lerData() é utilizado para obter um formato especial de Hora. Uma 
    String do tipo(DD/MM/AAAA) é recebida como parâmetro e é retornado um array 
    de inteiros no formato especifico para o setter. 
    Retorno do método: int[] output = [DD,MM,AA]
    Sendo o output[0]= DD;
            output[1]=MM;
            output[2]=AA;
     */
    /**
     * O método lerHora() é utilizado para obter um formato especial de Hora.
     * Uma String do tipo(HH:MM) é recebida como parâmetro e é retornado um
     * array de inteiros no formato especifico para o setter.
     * <b>uso:</b> <br>
     * GerenciamentoEstacionamento.lerHora();<br>
     *
     * @param input faz referência a hora no formato textual
     * @return <b>int[]</b> array de inteiro com duas posições para settar a
     * hora
     */
    public static int[] lerHora(String input) {

        String[] temp = input.split(":");
        int[] output = new int[2];

        for (int i = 0; i < 2; i++) {
            output[i] = Integer.parseInt(temp[i]);
        }
        return output;
    }

    /*
    O método lerHora() é utilizado para obter um formato especial de Hora. Uma 
    String do tipo(HH:MM) é recebida como parâmetro e é retornado um array 
    de inteiros no formato especifico para o setter. 
    Retorno do método: int[] output = [HH,MM]
    Sendo o output[0]= HH;
            output[1]=MM;
     */
    /**
     * O método lerData() é utilizado para obter um formato especial de Hora.
     * Uma String do tipo(DD/MM/AAAA) é recebida como parâmetro e é retornado um
     * array de inteiros no formato especifico para o setter. Retorno do método:
     * int[] output = [DD,MM,AA] Sendo o output[0]= DD; output[1]=MM;
     * output[2]=AA;
     *  * <b>uso:</b> <br>
     * GerenciamentoEstacionamento.lerData();<br>
     *
     * @param input faz referência a data no formato textual
     * @return <b>int[]</b> array de inteiro com três posições para settar a
     * data
     */
    public static int[] lerData(String input) {
        String[] temp = input.split("/");
        int[] output = new int[3];

        for (int i = 0; i < 3; i++) {
            output[i] = Integer.parseInt(temp[i]);
        }
        return output;
    }

    public static Acesso classificaAcesso(LocalDateTime entrada, LocalDateTime saida) {

        boolean mesmoAno = entrada.getYear() == saida.getYear();
        boolean mesmoMes = entrada.getMonthValue() == saida.getMonthValue();
        boolean mesmoDia = entrada.getDayOfMonth() == saida.getDayOfMonth();
        Duration duracaoDoAcesso = Duration.between(entrada, saida);
        Duration quinzeMinutos = Duration.ofMinutes(15);
        Duration umaHora = Duration.ofHours(1);
        Duration umaDiaria = Duration.ofHours(9);
        Duration umaMadrugada = Duration.ofHours(12);
        int menosDeQuinze = quinzeMinutos.compareTo(duracaoDoAcesso);
        int menosDeUmaHora = umaHora.compareTo(duracaoDoAcesso);
        int menosDeUmaDiaria = umaDiaria.compareTo(duracaoDoAcesso);
        int menosDeUmaMadrugada = umaMadrugada.compareTo(duracaoDoAcesso);

        if (mesmoAno && mesmoMes && mesmoDia && menosDeQuinze == 1) {
            Acesso acessoPorMinuto = new AcessoPorMinuto();
            try {
                acessoPorMinuto.setEntrada(entrada.toLocalDate(), entrada.toLocalTime());
                acessoPorMinuto.setSaida(saida.toLocalDate(), saida.toLocalTime());
            } catch (PeriodoInvalidoException erroDePeriodoInvalido) {
                System.out.println(erroDePeriodoInvalido.getMessage());
                JOptionPane.showMessageDialog(null, "Periodo Inválido.");
            } catch (EstacionamentoFechadoException erroDeEstacionamentoFechado) {
                System.out.println(erroDeEstacionamentoFechado.getMessage());
                JOptionPane.showMessageDialog(null, "Estacionamento Fechado.");
            }

            Duration duracao = acessoPorMinuto.calculaDuracao();
            acessoPorMinuto.setDuracao(duracao);
            acessoPorMinuto.caculaPeriodo();
            double valor = acessoPorMinuto.calculaValor(duracao, 0.5);
            acessoPorMinuto.setValor(valor);
            return acessoPorMinuto;
        }
        if (mesmoAno && mesmoMes && mesmoDia && (menosDeQuinze == -1 || menosDeQuinze == 0) && menosDeUmaHora == 1) {

            Acesso acessoPorQuinze = new AcessoPorQuinze();
            try {
                acessoPorQuinze.setEntrada(entrada.toLocalDate(), entrada.toLocalTime());
                acessoPorQuinze.setSaida(saida.toLocalDate(), saida.toLocalTime());
            } catch (PeriodoInvalidoException erroDePeriodoInvalido) {
                System.out.println(erroDePeriodoInvalido.getMessage());
                JOptionPane.showMessageDialog(null, "Periodo Inválido.");
            } catch (EstacionamentoFechadoException erroDeEstacionamentoFechado) {
                System.out.println(erroDeEstacionamentoFechado.getMessage());
                System.out.println(erroDeEstacionamentoFechado.getMessage());
                JOptionPane.showMessageDialog(null, "Estacionamento Fechado.");
            }
            Duration duracao = acessoPorQuinze.calculaDuracao();
            acessoPorQuinze.setDuracao(duracao);
            acessoPorQuinze.caculaPeriodo();
            double valor = acessoPorQuinze.calculaValor(duracao, 0.5);
            acessoPorQuinze.setValor(valor);
            return acessoPorQuinze;
        }
        if (mesmoAno && mesmoMes && mesmoDia && (menosDeUmaHora == -1 || menosDeUmaHora == 0) && menosDeUmaDiaria == 1) {
            Acesso acessoPorHora = new AcessoPorHora();
            try {
                acessoPorHora.setEntrada(entrada.toLocalDate(), entrada.toLocalTime());
                acessoPorHora.setSaida(saida.toLocalDate(), saida.toLocalTime());
            } catch (PeriodoInvalidoException erroDePeriodoInvalido) {
                System.out.println(erroDePeriodoInvalido.getMessage());
                JOptionPane.showMessageDialog(null, "Periodo Inválido.");
            } catch (EstacionamentoFechadoException erroDeEstacionamentoFechado) {
                System.out.println(erroDeEstacionamentoFechado.getMessage());
                JOptionPane.showMessageDialog(null, "Estacionamento Fechado.");
            }
            Duration duracao = acessoPorHora.calculaDuracao();
            acessoPorHora.setDuracao(duracao);
            acessoPorHora.caculaPeriodo();
            double valor = acessoPorHora.calculaValor(duracao, 0.5);
            acessoPorHora.setValor(valor);
            return acessoPorHora;
        }
        if (mesmoDia && mesmoMes && mesmoAno && (menosDeUmaDiaria == -1 || menosDeUmaDiaria == 0)) {
            Acesso acessoPorDiaria = new AcessoPorDiaria();
            try {
                acessoPorDiaria.setEntrada(entrada.toLocalDate(), entrada.toLocalTime());
                acessoPorDiaria.setSaida(saida.toLocalDate(), saida.toLocalTime());
            } catch (EstacionamentoFechadoException erroDeEstacionamentoFechado) {
                System.out.println(erroDeEstacionamentoFechado.getMessage());
                JOptionPane.showMessageDialog(null, "Estacionamento Fechado.");
            } catch (PeriodoInvalidoException erroDePeriodoInvalido) {
                System.out.println(erroDePeriodoInvalido.getMessage());
                JOptionPane.showMessageDialog(null, "Periodo Inválido.");
            }
            Duration duracao = acessoPorDiaria.calculaDuracao();
            acessoPorDiaria.setDuracao(duracao);
            acessoPorDiaria.caculaPeriodo();
            double valor = acessoPorDiaria.calculaValor(duracao, 0.5);
            acessoPorDiaria.setValor(valor);
            return acessoPorDiaria;
        }
        if (!mesmoDia && mesmoMes && mesmoAno) {
            Acesso acessoPorPernoite = new AcessoPorPernoite();
            try {
                acessoPorPernoite.setEntrada(entrada.toLocalDate(), entrada.toLocalTime());
                acessoPorPernoite.setSaida(saida.toLocalDate(), saida.toLocalTime());
            } catch (PeriodoInvalidoException erroDePeriodoInvalido) {
                System.out.println(erroDePeriodoInvalido.getMessage());
                JOptionPane.showMessageDialog(null, "Periodo Inválido.");
            } catch (EstacionamentoFechadoException erroDeEstacionamentoFechado) {
                System.out.println(erroDeEstacionamentoFechado.getMessage());
                JOptionPane.showMessageDialog(null, "Estacionamento Fechado.");
            }
            Duration duracao = acessoPorPernoite.calculaDuracao();
            acessoPorPernoite.setDuracao(duracao);
            acessoPorPernoite.caculaPeriodo();
            double valor = acessoPorPernoite.calculaValor(duracao, 0.5);
            acessoPorPernoite.setValor(valor);
            return acessoPorPernoite;
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Acesso inválido");
            return null;
        }
    }
}
