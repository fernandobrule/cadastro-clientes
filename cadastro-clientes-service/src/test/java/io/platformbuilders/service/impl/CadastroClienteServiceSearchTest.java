package io.platformbuilders.service.impl;

import io.platformbuilders.cadcli.glue.ClienteSearchReq;
import io.platformbuilders.cadcli.glue.ClienteSearchResp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroClienteServiceSearchTest extends AbstractServiceTest {

    @Test
    public void canSearch() {

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

        ClienteSearchReq searchReq = new ClienteSearchReq.Build() //
                .setSelectItems(selectItems) //
                .setWhereItems(whereItems) //
                .setOrderByItems(orderByItems) //
                .build();

        ClienteSearchResp searchResp = cadastroClientesServiceApi.search(context, searchReq);
        assertTrue(searchResp.isSuccess());
        assertFalse(searchResp.getList().isEmpty());

        assertTrue(searchResp.getList().get(0).getItemValue().indexOf("age") > 0);

    }

    @Test
    public void canNotSearch() {

        List<String> selectItems = new ArrayList<>() {
            {
                add("name");
                add("favoritesong");
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

        ClienteSearchReq searchReq = new ClienteSearchReq.Build() //
                .setSelectItems(selectItems) //
                .setWhereItems(whereItems) //
                .setOrderByItems(orderByItems) //
                .build();

        ClienteSearchResp searchResp = cadastroClientesServiceApi.search(context, searchReq);
        assertFalse(searchResp.isSuccess());

    }

}
