package io.platformbuilders.service.impl;

import io.platformbuilders.cadcli.glue.ClienteCreateReq;
import io.platformbuilders.cadcli.glue.Context;
import io.platformbuilders.cadcli.service.api.CadastroClientesServiceApi;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public abstract class AbstractServiceTest {

    static AbstractApplicationContext appCtx;
    static CadastroClientesServiceApi cadastroClientesServiceApi;

    private final Locale locale = new Locale.Builder()//
            .setRegion("BR")//
            .setLanguage("pt")//
            .build();

    protected Context context = new Context(locale);

    @BeforeAll
    public static void beforeAll() {

        appCtx = new ClassPathXmlApplicationContext("app-ctx-cadastro-clientes-service.xml");
        appCtx.registerShutdownHook();

        cadastroClientesServiceApi = appCtx.getBean(CadastroClientesServiceApi.class);
    }

    public ClienteCreateReq nextClienteCreateReq() {
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
