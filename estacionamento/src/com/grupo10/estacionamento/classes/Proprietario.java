/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo10.estacionamento.classes;

import com.grupo10.estacionamento.exceptions.DadosPessoaisIncompletosException;

/**
 *
 * @author Adrian Soares
 */
public class Proprietario {
    /*
    1-Criar atributos nome,endereco,numero do celular,numero do telefone residencial e cnh;
    2-Criar os métodos getters e setters.
    3-Implementar construtores.
    */
    //Atributos:
    private String nome;
    private String endereco;
    private String nCelular;
    private String nResidencial;
    private String cnh;
    //Métodos:
    public Proprietario (){}
    /*
    Métodos de cadastro e o construtor geram exceções para
    casos em que cadastro é mal realizado (DadosPessoaisIncompletosException)
    o telefone residencial é opcional e portanto não gera
    */
//Iniciação com telefone residencial
    public Proprietario (String nome, String endereco, String nCelular, String nResidencial, String cnh) throws DadosPessoaisIncompletosException {
        setNome (nome);
        setEndereco (endereco);
        setnCelular (nCelular);
        setnResidencial (nResidencial);
        setCnh (cnh);
    }
    //Telefone Residencial opcional
    public Proprietario (String nome, String endereco, String nCelular, String cnh) throws DadosPessoaisIncompletosException {
        setNome (nome);
        setEndereco (endereco);
        setnCelular (nCelular);
        setnResidencial ("**Não cadastrado**\n");
        setCnh (cnh);
    }
    // getters ()
    public String getNome () { return this.nome; }
    public String getEndereco () { return this.endereco; }
    public String getnCelular () { return this.nCelular; }
    public String getnResidencial () { return this.nResidencial; }
    public String getCnh () { return this.cnh; }

    // setters ()
    public void setNome (String nome) throws DadosPessoaisIncompletosException {
        if (!nome.isBlank()) this.nome = nome;
        else throw new DadosPessoaisIncompletosException();
    }

    public void setEndereco (String endereco) throws DadosPessoaisIncompletosException{
        if (!endereco.isBlank()) this.endereco = endereco;
        else throw new DadosPessoaisIncompletosException();
    }

    public void setnCelular (String celular) throws DadosPessoaisIncompletosException {
        if (!celular.isBlank()) this.nCelular = celular;
        else throw new DadosPessoaisIncompletosException();
    }
    public void setnResidencial (String nResidencial) {
        if (nResidencial.isBlank()) this.nResidencial = "**Não cadastrado**";
        else this.nResidencial = nResidencial;
    }
    public void setCnh (String cnh) throws DadosPessoaisIncompletosException{
        if (!cnh.isBlank()) this.cnh = cnh;
        else throw new DadosPessoaisIncompletosException();
    }

    
    
}
