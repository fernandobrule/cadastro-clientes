package io.platformbuilders.cadcli.dao.impl;

import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoException;
import org.junit.jupiter.api.Test;

public class CadastroClientesDaoCreateTest extends AbstractDaoTest {

    @Test
    public void canCreate() throws CadastroClientesDaoException {

        Long clienteId = cadastroClientesDaoApi.create(newClienteCreateReq());

    }
}
