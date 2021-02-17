package io.platformbuilders.cadcli.dao.impl;

import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoException;
import io.platformbuilders.cadcli.glue.ClienteUpdateReq;
import org.junit.jupiter.api.Test;

public class CadastroClientesDaoUpdateTest extends AbstractDaoTest {

    @Test
    public void canUpdate() throws CadastroClientesDaoException {

        Long clienteId = cadastroClientesDaoApi.create(newClienteCreateReq());

        ClienteUpdateReq clienteUpdateReq = new ClienteUpdateReq.Builder() //
                .setClienteId(clienteId) //
                .setName("Jack") //
                .setAge((short) 35) //
                .setSurname("Travis") //
                .setAddress("Haddock Lobo") //
                .setCity("São Paulo") //
                .setCountry("Brasil") //
                .setMobile("11951976773") //
                .setEmail("jacktravis@gmail.com") //
                .build();

        Integer affectedRows = cadastroClientesDaoApi.update(clienteUpdateReq);

    }
}
