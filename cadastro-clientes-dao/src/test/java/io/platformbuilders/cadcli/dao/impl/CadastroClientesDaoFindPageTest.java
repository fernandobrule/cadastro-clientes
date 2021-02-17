package io.platformbuilders.cadcli.dao.impl;

import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoException;
import io.platformbuilders.cadcli.glue.Cliente;
import io.platformbuilders.cadcli.glue.ClientePageGetReq;
import io.platformbuilders.cadcli.glue.Page;
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
