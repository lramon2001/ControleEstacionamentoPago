/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 * <p>
 * Interface <b>CadastroInterface</b> </p>
 * <p>
 * Define a estrutura da interface para cadastros na aplicação</p>
 *
 * @author Lucas Ramon
 * @since may 2021
 * @version 1.0
 * @author Lucas
 * @param <E> Entidade 
 */
public interface CadastroInterface<E> {

    public void cadastrar(E entidade);

    public void remover(int index);

    public void listar();

    public E buscar(String busca);

}
