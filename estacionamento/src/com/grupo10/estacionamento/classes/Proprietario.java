/**
 *
 * @author Adrian Soares Lopes
 */
package com.grupo10.estacionamento.classes;
//import com.grupo10.estacionamento.exceptions.DadosPessoaisIncompletosException; (importar)

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
        setNCelular (nCelular);
        setNResidencial (nResidencial);
        setCnh (cnh);
    }
    //Telefone Residencial opcional
    public Proprietario (String nome, String endereco, String nCelular, String cnh) {
        setNome (nome);
        setEndereco (endereco);
        setNCelular (nCelular);
        setNResidencial ("**Não cadastrado**\n");
        setCnh (cnh);
    }
    // getters ()
    public String getNome () { return this.nome; }
    public String getEndereco () { return this.endereco; }
    public String getNCelular () { return this.nCelular; }
    public String getNResidencial () { return this.nResidencial; }
    public String getCnh () { return this.cnh; }
    // setters ()
    public void setNome (String nome) { // throws DadosPessoaisIncompletosException (especificar)
        if (!nome.isNull() && !nome.isEmpty()) this.nome = nome;
        //else throw new DadosPessoaisIncompletosException(); (instanciar)
    }

    public void setEndereco (String endereco) { // throws DadosPessoaisIncompletosException (especificar)
        if (!endereco.isNull() && !endereco.isEmpty()) this.endereco = endereco;
        //else throw new DadosPessoaisIncompletosException(); (instanciar)
    }

    public void setNCelular (String celular) { // throws DadosPessoaisIncompletosException (especificar)
        if (!celular.isNull() && !celular.isEmpty()) this.nCelular = celular;
        //else throw new DadosPessoaisIncompletosException(); (instanciar)
    }
    public void setNResidencial (String nResidencial) { // throws DadosPessoaisIncompletosException (especificar)
        if (nResidencial.isEmpty()) this.nResidencial = "**Não cadastrado**";
        else this.nResidencial = nResidencial;
    }
    public void setCnh (String cnh) { // throws DadosPessoaisIncompletosException (especificar)
        if (!cnh.isNull() && !cnh.isEmpty()) this.cnh = cnh;
        //else throw new DadosPessoaisIncompletosException(); (instanciar)
    }
}