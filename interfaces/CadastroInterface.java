/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.interfaces;

/**
 *
 * @author Lucas
 */
public interface CadastroInterface<E>{
    
public void cadastrar (E entidade);
public void remover(int index);
public void listar();
public Object buscar(String busca);

}
