/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import com.grupo10.estacionamento.exceptions.DadosPessoaisIncompletosException;

/**
 *
 * @author Lucas Ramon
 */
public class Proprietario {
    /*
    1-Criar atributos nome,endereco,numero do celular,numero do telefone residencial e cnh;
    2-Criar os métodos getters e setters.
    3-Implementar construtores.
    */
    private String nome;
    private String endereco;
    private String nCelular;
    private String nResidencial;
    private String cnh;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws DadosPessoaisIncompletosException {
        if (nome.isEmpty()) {
            throw new DadosPessoaisIncompletosException();
        } else {
            this.nome = nome;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws DadosPessoaisIncompletosException{
        if(endereco.isEmpty()){
              throw new DadosPessoaisIncompletosException();
        }
        else{
            this.endereco = endereco;
        }
    }

    public String getnCelular() {
        return nCelular;
    }

    public void setnCelular(String nCelular) throws DadosPessoaisIncompletosException {
        if (nCelular.isEmpty()) {
            throw new DadosPessoaisIncompletosException();
        } else {
            this.nCelular = nCelular;
        }

    }

    public String getnResidencial() {
        return nResidencial;
    }

    public void setnResidencial(String nResidencial) {
        if (nResidencial.isEmpty()) this.nResidencial = "**Não cadastrado**";
        this.nResidencial = nResidencial;
    }
    

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) throws DadosPessoaisIncompletosException {
        if (cnh.isEmpty()) {
            throw new DadosPessoaisIncompletosException();
        } else {
            this.cnh = cnh;
        }

    }
    
    
}