package com.fragnostic.service.impl;

import com.fragnostic.cadcli.glue.ClientePageGetReq;
import com.fragnostic.cadcli.glue.ClientePageGetResp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroClienteServiceListTest extends AbstractServiceTest {

    @Test
    public void canList() {

        ClientePageGetReq pageGetReq = new ClientePageGetReq.Builder()//
                .setNumber(1)//
                .setSize(10)//
                .setOrderBy("name")//
                .build();

        ClientePageGetResp clientePageGetResp = cadastroClientesServiceApi.list(context, pageGetReq);
        assertTrue(clientePageGetResp.isSuccess());
    }

    @Test
    public void canNotList() {

        ClientePageGetReq pageGetReq = new ClientePageGetReq.Builder()//
                .setNumber(-1)//
                .setSize(10)//
                .setOrderBy("favoritesong")//
                .build();

        ClientePageGetResp clientePageGetResp = cadastroClientesServiceApi.list(context, pageGetReq);
        assertFalse(clientePageGetResp.isSuccess());
    }

}
