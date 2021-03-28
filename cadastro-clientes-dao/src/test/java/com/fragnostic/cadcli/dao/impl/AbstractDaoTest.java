package com.fragnostic.cadcli.dao.impl;

import com.fragnostic.cadcli.dao.api.CadastroClientesDaoApi;
import com.fragnostic.cadcli.glue.ClienteCreateReq;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractDaoTest {

    static AbstractApplicationContext appCtx;
    static CadastroClientesDaoApi cadastroClientesDaoApi;

    @BeforeAll
    public static void beforeAll() {

        appCtx = new ClassPathXmlApplicationContext("app-ctx-cadastro-clientes-dao-test.xml");
        appCtx.registerShutdownHook();

        cadastroClientesDaoApi = appCtx.getBean(CadastroClientesDaoApi.class);
    }

    protected ClienteCreateReq newClienteCreateReq() {
        return new ClienteCreateReq.Builder() //
                .setName("Jack") //
                .setSurname("Travis") //
                .setAge((short) 35) //
                .setAddress("Haddock Lobo") //
                .setCity("São Paulo") //
                .setCountry("Brasil") //
                .setMobile("11951976773") //
                .setEmail("jacktravis@gmail.com") //
                .build();
    }

}
