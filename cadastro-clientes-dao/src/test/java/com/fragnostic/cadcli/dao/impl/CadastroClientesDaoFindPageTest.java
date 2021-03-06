package com.fragnostic.cadcli.dao.impl;

import com.fragnostic.cadcli.dao.api.CadastroClientesDaoException;
import com.fragnostic.cadcli.glue.Cliente;
import com.fragnostic.cadcli.glue.ClientePageGetReq;
import com.fragnostic.cadcli.glue.Page;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CadastroClientesDaoFindPageTest extends AbstractDaoTest {

    @Test
    public void canGetPage() throws CadastroClientesDaoException {

        ClientePageGetReq paginaGetReq = new ClientePageGetReq.Builder()//
                .setNumber(0) //
                .setSize(10) //
                .setOrderBy("name")//
                .build();

        Page<Cliente> pagina = cadastroClientesDaoApi.list(paginaGetReq);

        assertFalse(pagina.isEmpty());

    }
}
