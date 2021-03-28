package com.fragnostic.cadcli.dao.impl;

import com.fragnostic.cadcli.dao.api.CadastroClientesDaoException;
import org.junit.jupiter.api.Test;

public class CadastroClientesDaoCreateTest extends AbstractDaoTest {

    @Test
    public void canCreate() throws CadastroClientesDaoException {

        Long clienteId = cadastroClientesDaoApi.create(newClienteCreateReq());

    }
}
