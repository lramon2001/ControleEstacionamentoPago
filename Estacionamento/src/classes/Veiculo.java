/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.DadosVeiculosIncompletosException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Classe <b>Veiculo </b> </p>
 * <p>
 * Define a estrutura de um veículo na Aplicação</p>
 *
 * @author Adrian Soares
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 *
 */
public class Veiculo {

    /*
    1-Criar atributos marca,modelo e numero da Placa;
    2-Criar os métodos getters e setters.
    3-Implementar construtores.
     */
    private String marca;
    private String modelo;
    private String numeroPlaca;
    private java.util.List<Acesso> acessos = new ArrayList<Acesso>();

    /**
     * Construtor default da classe  <b>Veiculo</b> <br><br>
     * <b> uso:</b> <br>
     * Veiculo veiculo = new Veiculo(); <br>
     * O objeto inicia-se com um ArrayList do tipo  <b>Acesso</b> para receber os
     * acessos.
     */
    public Veiculo() {
        acessos = new ArrayList<>();
    }

    /**
     * Construtor sobrecarregado da classe <b>Veiculo</b> <br> <br>
     * <b>uso:</b><br>
     * Veiculo veiculo= new Veiculo ("marca","modelo","numeroDaPlaca");<br> <br>
     * <b>onde:</b> <br>
     *
     * @param marca faz referência a marca do carro.
     * @param modelo faz referênica ao modelo do carro.
     * @param numeroPlaca faz referência a placa do carro.
     */
    public Veiculo(String marca, String modelo, String numeroPlaca) {
        acessos = new ArrayList<>();
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Getter do atributo <b>marca</b><br>
     * <b>uso:</b><br>
     * veiculo.getMarca();
     *
     * @return <b>String: </b> estado do atributo marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Setter do atributo <b>marca</b> <br>
     * <b> uso:</b><br>
     * veiculo.setMarca(String marca);
     *
     * @param marca: <b>String</b>
     * @throws DadosVeiculosIncompletosException Não é possível atribuir
     * <b>null</b> ao parâmetro.
     */
    public void setMarca(String marca) throws DadosVeiculosIncompletosException {
        if (marca.isEmpty()) {
            throw new DadosVeiculosIncompletosException();
        } else {
            this.marca = marca;
        }
    }

    /**
     * Getter do atributo <b>modelo</b><br>
     * <b>uso:</b><br>
     * veiculo.getModelo();
     *
     * @return <b>String: </b> estado do atributo marca
     *
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter do atributo <b>modelo</b><br>
     * <b> uso:</b><br>
     * veiculo.setModelo(String modelo);
     *
     * @param modelo: <b>String</b>
     * @throws DadosVeiculosIncompletosException <br>
     * Não é possível atribuir <b>null</b> ao parâmetro.
     *
     */
    public void setModelo(String modelo) throws DadosVeiculosIncompletosException {
        if (modelo.isEmpty()) {
            throw new DadosVeiculosIncompletosException();
        } else {
            this.modelo = modelo;
        }

    }

    /**
     * Getter do atributo <b>numeroPlaca</b><br>
     * <b>uso:</b><br>
     * veiculo.getNumeroPlaca();
     *
     * @return <b>String: </b> estado do atributo numero da placa
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     *
     * Setter do atributo <b>numeroPlaca</b><br>
     * <b> uso:</b><br>
     * veiculo.setNumeroPlaca(String numeroDaPlaca);
     *
     * @param numeroPlaca: <b>String</b>
     * @throws DadosVeiculosIncompletosException <br>
     * Não é possível atribuir <b>null</b> ao parâmetro.
     */
    public void setNumeroPlaca(String numeroPlaca) throws DadosVeiculosIncompletosException {
        if (numeroPlaca.isEmpty()) {
            throw new DadosVeiculosIncompletosException();
        }
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Setter do atributo <b>acessos</b> que é um ArrayList de <b> Acesso</b>
     * <br>
     * <b> uso:</b><br>
     * veiculo.setAcesso(Acesso acesso);
     *
     * @param acesso: <b>Acesso</b>
     */
    public void setAcesso(Acesso acesso) {
        acessos.add(acesso);
    }

    /**
     * Getter do atributo <b>acessos</b><br>
     * <b>uso:</b><br>
     * veiculo.getAcessos();
     *
     * @return <b>List(Acesso): </b> lista com todos os acessos do Veiculo
     */
    public List<Acesso> getAcessos() {
        return acessos;
    }

    /**
     * <b>método</b> mostraTodosAcessosDoVeiculo<br>
     * <b>uso:</b> <br>
     * veiculo.mostraTodosAcessosDoVeiculo();<br>
     * Este método varre a lista de acessos e retorna todos o acessos com a
     * informações recorrentes . Utiliza-se da Classe StringBuilder que é útil
     * para otimização de alocação de memória, pois ao concatenar as Strings não
     * são gerados novos endereços de memória.
     *
     * @return <b>String:</b> Informações de todos os acessos;
     */
    public String mostraTodosAcessosDoVeiculo() {
        StringBuilder lista = new StringBuilder();
        int i =0;
        lista.append("\nNúmero de acessos realizados pelo veículo: "+(acessos.size())+"\n");
        for (Acesso acesso : acessos) {
            if (!acessos.isEmpty()) {
                LocalDateTime entrada = acesso.getEntrada();
                LocalDateTime saida = acesso.getSaida();
                lista.append("Acesso nº "+(i+1)).append("\nEntrada                          |    Saída    \n")
                	.append("Dia: "+entrada.getDayOfMonth()+"/"+entrada.getMonthValue()+"/"+entrada.getYear())
                	.append("                 |    Dia:"+saida.getDayOfMonth()+"/"+saida.getMonthValue()+"/"+saida.getYear())
                	.append("\nHora: "+entrada.toLocalTime().toString())
                	.append("                    |    Hora:"+saida.toLocalTime().toString())
                	.append("\nTempo de permanência: ").append(acesso.duracao.toHoursPart() + "h " + acesso.duracao.toMinutesPart() + "min")
                	.append("\nValor a ser cobrado: ").append(acesso.getValor() + "R$\n\n");
                i++;
            }
        }
        return lista.toString();

    }

}
