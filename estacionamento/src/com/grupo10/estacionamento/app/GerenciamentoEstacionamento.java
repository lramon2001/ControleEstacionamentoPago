
     

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.app;

import com.grupo10.estacionamento.classes.Acesso;
import com.grupo10.estacionamento.classes.AcessoPorMinuto;
import com.grupo10.estacionamento.classes.AcessoPorQuinze;
import com.grupo10.estacionamento.exceptions.PeriodoInvalidoException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Ramon
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
    public static int[] lerData(String input){
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
        int menosDeQuinze = quinzeMinutos.compareTo(duracaoDoAcesso);
        int menosDeUmaHora = umaHora.compareTo(duracaoDoAcesso);
        
        if (mesmoAno && mesmoMes && mesmoDia && menosDeQuinze == 1) {
            Acesso acessoPorMinuto = new AcessoPorMinuto();
            JOptionPane.showMessageDialog(null, "Você é o gênio da bola");            
            try{
                acessoPorMinuto.setEntrada(entrada.toLocalDate(), entrada.toLocalTime());
                acessoPorMinuto.setSaida(saida.toLocalDate(), saida.toLocalTime());
            }
            catch(PeriodoInvalidoException e){
               
            }
            Duration duracao =acessoPorMinuto.calculaDuracao();
            acessoPorMinuto.setDuracao(duracao);
            acessoPorMinuto.caculaPeriodo();
            double valor =acessoPorMinuto.calculaValor(duracao);
            acessoPorMinuto.setValor(valor);
            return acessoPorMinuto;
        }
       if(mesmoAno && mesmoMes && mesmoDia && (menosDeQuinze==-1 || menosDeQuinze == 0) && menosDeUmaHora == 1 ){
           
           Acesso acessoPorQuinze = new AcessoPorQuinze();
           try{
               acessoPorQuinze.setEntrada(entrada.toLocalDate(), entrada.toLocalTime());
               acessoPorQuinze.setSaida(saida.toLocalDate(), saida.toLocalTime());
           }
           catch(PeriodoInvalidoException e){
                JOptionPane.showMessageDialog(null, "Periodo Inválido");
           }
           Duration duracao =acessoPorQuinze.calculaDuracao();
            acessoPorQuinze.setDuracao(duracao);
            acessoPorQuinze.caculaPeriodo();
            double valor=acessoPorQuinze.calculaValor(duracao);
            acessoPorQuinze.setValor(valor);
            return acessoPorQuinze;
       }
       else{ 
           JOptionPane.showMessageDialog(null, "TCHÊ");
           return null;
       }
     }
}