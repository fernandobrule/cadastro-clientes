package io.platformbuilders.cadcli.dao.api;

import io.platformbuilders.cadcli.glue.*;

import java.util.List;

public interface CadastroClientesDaoApi {

    /**
     * Criação de novos clientes
     * 
     * @param clienteCreateReq
     * 
     * @return
     * 
     * @throws CadastroClientesDaoException
     */
    Long create(ClienteCreateReq clienteCreateReq) throws CadastroClientesDaoException;

    /**
     * Atualização de clientes existentes
     * 
     * @param clienteUpdateReq
     * 
     * @return
     * 
     * @throws CadastroClientesDaoException
     */
    Integer update(ClienteUpdateReq clienteUpdateReq) throws CadastroClientesDaoException;

    /**
     * Listar os Clientes de forma paginada
     * 
     * @param clientePageGetReq
     * 
     * @return
     * 
     * @throws CadastroClientesDaoException
     */
    Page<Cliente> list(ClientePageGetReq clientePageGetReq) throws CadastroClientesDaoException;;

    /**
     * Buscas por atributos cadastrais do cliente
     * 
     * @param clienteSearchReq
     * 
     * @return
     * 
     * @throws CadastroClientesDaoException
     */
    List<SearchItem<Long>> search(ClienteSearchReq clienteSearchReq) throws CadastroClientesDaoException;

}
