package com.fragnostic.service.impl;

import com.fragnostic.cadcli.glue.ClienteCreateReq;
import com.fragnostic.cadcli.glue.ClienteCreateResp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroClienteServiceCreateTest extends AbstractServiceTest {

    @Test
    public void canCreate() {
        ClienteCreateReq clienteCreateReq = nextClienteCreateReq();
        ClienteCreateResp clienteCreateResp = cadastroClientesServiceApi.create(context, clienteCreateReq);
        assertTrue(clienteCreateResp.isSuccess());
        assertEquals(clienteCreateReq.getAge(), clienteCreateResp.getAge());
    }

    @Test
    public void canNotCreate() {
        ClienteCreateReq clienteCreateReq = nextClienteCreateReq();
        clienteCreateReq.setMobile("3423423423423423423421342343");
        ClienteCreateResp clienteCreateResp = cadastroClientesServiceApi.create(context, clienteCreateReq);
        assertFalse(clienteCreateResp.isSuccess());
    }

}
