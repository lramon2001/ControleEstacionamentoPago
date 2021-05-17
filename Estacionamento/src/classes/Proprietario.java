/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.DadosPessoaisIncompletosException;

/**
 * <p>
 * Classe <b>Veiculo </b> </p>
 * <p>
 * Define a estrutura de um veículo na Aplicação</p>
 *
 * @author Adrian Soares
 * @since may 2021
 * @version 1.0
 *
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

    /**
     * Getter do atributo <b>nome</b><br>
     * <b>uso:</b><br>
     * proprietatio.getNome();
     *
     * @return <b>String: </b> estado do atributo nome.
     *
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter do atributo <b>nome</b><br>
     * <b> uso:</b><br>
     * veiculo.setNome(String nome);
     *
     * @param nome: <b>String</b>
     * @throws DadosPessoaisIncompletosException <br>
     * Não é possível atribuir <b>null</b> ao parâmetro.
     */
    public void setNome(String nome) throws DadosPessoaisIncompletosException {
        if (nome.isEmpty()) {
            throw new DadosPessoaisIncompletosException();
        } else {
            this.nome = nome;
        }
    }

    /**
     * Getter do atributo <b>endereco</b><br>
     * <b>uso:</b><br>
     * proprietario.getEndereco();
     *
     * @return <b>String: </b> estado do atributo endereco
     *
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Setter do atributo <b>endereco</b><br>
     * <b> uso:</b><br>
     * veiculo.setEndereco(String endereco);
     *
     * @param endereco: <b>String</b>
     * @throws DadosPessoaisIncompletosException <br>
     * Não é possível atribuir <b>null</b> ao parâmetro.
     */
    public void setEndereco(String endereco) throws DadosPessoaisIncompletosException {
        if (endereco.isEmpty()) {
            throw new DadosPessoaisIncompletosException();
        } else {
            this.endereco = endereco;
        }
    }

    /**
     * Getter do atributo <b>nCelular</b><br>
     * <b>uso:</b><br>
     * proprietario.getnCelular();
     *
     * @return <b>String: </b> estado do atributo nCelular
     *
     */
    public String getnCelular() {
        return nCelular;
    }

    /**
     * Setter do atributo <b>nCelular</b><br>
     * <b> uso:</b><br>
     * proprietario.setnCelulara(String numeroDaPlaca);
     *
     * @param nCelular: <b>String</b>
     * @throws DadosPessoaisIncompletosException <br>
     * Não é possível atribuir <b>null</b> ao parâmetro.
     */
    public void setnCelular(String nCelular) throws DadosPessoaisIncompletosException {
        if (nCelular.isEmpty()) {
            throw new DadosPessoaisIncompletosException();
        } else {
            this.nCelular = nCelular;
        }

    }

    /**
     * /**
     * Getter do atributo <b>nResidencial</b><br>
     * <b>uso:</b><br>
     * proprietario.getnResidencial();
     *
     * @return <b>String: </b> estado do atributo nResidencial
     *
     */
    public String getnResidencial() {
        return nResidencial;
    }

    /**
     * Setter do atributo <b>nResidencial</b><br>
     * <b> uso:</b><br>
     * proprietario.setnResidencial(String nResidencial);
     *
     * @param nResidencial: <b>String</b>
     *
     *
     */
    public void setnResidencial(String nResidencial) {
        if (nResidencial.isEmpty()) {
            this.nResidencial = "**Não cadastrado**";
        }
        this.nResidencial = nResidencial;
    }

    /**
     * Getter do atributo <b>cnh</b><br>
     * <b>uso:</b><br>
     * veiculo.getCnh();
     *
     * @return <b>String: </b> estado do atributo cnh
     *
     */
    public String getCnh() {
        return cnh;
    }

    /**
     *
     * Setter do atributo <b>cnh</b><br>
     * <b> uso:</b><br>
     * proprietario.setCnh(String cnh);
     *
     * @param cnh: <b>String</b>
     * @throws DadosPessoaisIncompletosException <br>
     * Não é possível atribuir <b>null</b> ao parâmetro.
     */
    public void setCnh(String cnh) throws DadosPessoaisIncompletosException {
        if (cnh.isEmpty()) {
            throw new DadosPessoaisIncompletosException();
        } else {
            this.cnh = cnh;
        }

    }

}
