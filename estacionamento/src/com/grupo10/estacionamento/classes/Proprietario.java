package com.grupo10.estacionamento.classes;

public class Proprietario {
    //Atributos:
    private String nome;
    private String endereco;
    private String nCelular;
    private String nResidencial;
    private String cnh;

    //Métodos:
//Iniciação com telefone residencial
    public Proprietario (String nome, String endereco, String nCelular, String nResidencial, String cnh) {
        setNome (nome);
        setEndereco (endereco);
        setEndereco (nCelular);
        setNResidencial (nResidencial);
        setCnh (cnh);
    }
    //Telefone Residencial opcional
    public Proprietario (String nome, String endereco, String nCelular, String cnh) {
        setNome (nome);
        setEndereco (endereco);
        setEndereco (nCelular);
        setNResidencial ("**Não cadastrado**\n");
        setCnh (cnh);
    }
    // getters ()
    public String getNome () { return this.nome; }
    public String getEndereco () { return this.endereco; }
    public String getnCelular () { return this.nCelular; }
    public String getnResidencial () { return this.nResidencial; }
    public String getCnh () { return this.cnh; }
    // setters ()
    public void setNome (String nome) { this.nome = nome; }
    public void setEndereco (String endereco) { this.endereco = endereco; }
    public void setNCelular (String celular) { this.nCelular = celular; }
    public void setNResidencial (String nResidencial) { this.nResidencial = nResidencial; }
    public void setCnh (String cnh) { this.cnh = cnh; }
}