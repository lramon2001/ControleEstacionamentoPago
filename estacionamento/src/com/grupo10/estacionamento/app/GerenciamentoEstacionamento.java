/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.app;

/**
 *
 * @author Adrian Soares
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GerenciamentoEstacionamento {
    //Formato de tempo
    private static final DateTimeFormatter FORMATO_T = DateTimeFormatter.ofPattern("HH:mm");
    //Formato data
    private static final DateTimeFormatter FORMATO_D = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    /*
    O método lerHora() é utilizado para obter um formato especial de Hora. Uma
    String do tipo(DD/MM/AAAA) é recebida como parâmetro e é retornado um objeto local time com
    a formatação FORMATO_T = HH:MM
    */

    public static LocalTime lerHora(String input) {
        LocalTime output = LocalTime.parse(input, FORMATO_T);
        return output;
    }

    /*
    O método lerData() é utilizado para obter um formato especial de Hora. Uma
    String do tipo(dd/MM/yyyy) é recebida como parâmetro e é retornado um objeto data
    da classe LocalDate com a devida formatação
    */


    public static LocalDate lerData(String input) {
        LocalDate output = LocalDate.parse(input, FORMATO_D);
        return output;
    }
}

