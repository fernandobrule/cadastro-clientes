package io.platformbuilders.cadcli.dao.impl;

import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoException;
import io.platformbuilders.cadcli.glue.ClienteSearchReq;
import io.platformbuilders.cadcli.glue.SearchItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CadastroClientesDaoSearchTest extends AbstractDaoTest {

    @Test
    public void canSearch() throws CadastroClientesDaoException {

        List<String> selectItems = new ArrayList<>() {
            {
                add("name");
                add("surname");
                add("email");
            }
        };

        List<String> whereItems = new ArrayList<>() {
            {
            }
        };

        List<String> orderByItems = new ArrayList<>() {
            {
                add("name");
            }
        };

        ClienteSearchReq clienteSearchReq = new ClienteSearchReq.Build() //
                .setSelectItems(selectItems) //
                .setWhereItems(whereItems) //
                .setOrderByItems(orderByItems) //
                .build();

        List<SearchItem<Long>> list = cadastroClientesDaoApi.search(clienteSearchReq);

        assertFalse(list.isEmpty());

    }

}
