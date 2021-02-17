package io.platformbuilders.service.impl;

import io.platformbuilders.cadcli.glue.ClienteCreateResp;
import io.platformbuilders.cadcli.glue.ClienteUpdateReq;
import io.platformbuilders.cadcli.glue.ClienteUpdateResp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroClienteServiceUpdateTest extends AbstractServiceTest {

    @Test
    public void canUpdate() {

        ClienteCreateResp clienteCreateResp = cadastroClientesServiceApi.create(context, nextClienteCreateReq());

        ClienteUpdateReq clienteUpdateReq = new ClienteUpdateReq.Builder() //
                .setClienteId(clienteCreateResp.getClienteId()) //
                .setName("Jack") //
                .setAge((short) 35) //
                .setSurname("Travis") //
                .setAddress("Haddock Lobo") //
                .setCity("São Paulo") //
                .setCountry("Brasil") //
                .setMobile("11951976773") //
                .setEmail("jacktravis@gmail.com") //
                .build();

        ClienteUpdateResp clienteUpdateResp = cadastroClientesServiceApi.update(context, clienteUpdateReq);
        assertTrue(clienteCreateResp.isSuccess());

        assertEquals(clienteUpdateReq.getAge(), clienteUpdateResp.getAge());

    }

    @Test
    public void canNotUpdateWithWrongClientId() {

        ClienteUpdateReq clienteUpdateReq = new ClienteUpdateReq.Builder() //
                .setClienteId(1235454l) //
                .setName("JACK") //
                .setSurname("TRAVIS") //
                .setAge((short) 35) //
                .setAddress("Haddock Lobo") //
                .setCity("São Paulo") //
                .setCountry("Brasil") //
                .setMobile("11951976773") //
                .setEmail("jacktravis@gmail.com") //
                .build();

        ClienteUpdateResp clienteUpdateResp = cadastroClientesServiceApi.update(context, clienteUpdateReq);
        assertEquals("cadastro.clientes.service.update.error.no.update.was.done", clienteUpdateResp.getMessage());
        assertFalse(clienteUpdateResp.isSuccess());
    }

    @Test
    public void canNotUpdateWithWronMobile() {

        ClienteCreateResp clienteCreateResp = cadastroClientesServiceApi.create(context, nextClienteCreateReq());

        ClienteUpdateReq clienteUpdateReq = new ClienteUpdateReq.Builder() //
                .setClienteId(clienteCreateResp.getClienteId()) //
                .setName("JACK") //
                .setSurname("TRAVIS") //
                .setAge((short) 35) //
                .setAddress("Haddock Lobo") //
                .setCity("São Paulo") //
                .setCountry("Brasil") //
                .setMobile("4564356456456645456") //
                .setEmail("jacktravis@gmail.com") //
                .build();

        ClienteUpdateResp clienteUpdateResp = cadastroClientesServiceApi.update(context, clienteUpdateReq);
        assertEquals("cadastro.clientes.service.update.error", clienteUpdateResp.getMessage());
        assertFalse(clienteUpdateResp.isSuccess());
    }

}
