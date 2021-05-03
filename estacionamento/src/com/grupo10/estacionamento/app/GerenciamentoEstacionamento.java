/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.app;

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
}
