package io.platformbuilders.cadcli.endpoint;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoApi;
import io.platformbuilders.cadcli.dao.impl.CadastroClientesDaoJdbcImpl;
import io.platformbuilders.cadcli.service.api.CadastroClientesServiceApi;
import io.platformbuilders.cadcli.service.impl.CadastroClientesServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.net.UnknownHostException;
import java.util.Properties;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class })
public class CadastroClientesEndpointApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadastroClientesEndpointApplication.class, args);
    }

    @Value("${sql.cliente.create}")
    private String sqlClienteCreate;

    @Value("${sql.cliente.findpage}")
    private String sqlClienteFindPage;

    @Value("${sql.cliente.search}")
    private String sqlClienteSearch;

    @Value("${sql.cliente.update}")
    private String sqlClienteUpdate;

    @Value("${hikari.config.poolname}")
    private String hikariDsPoolName;

    @Value("${hikari.config.testquery}")
    private String hikariDsConnectionTestQuery;

    @Value("${hikari.config.dsclassname}")
    private String hikariDsClassName;

    @Value("${hikari.config.maximumpoolsize}")
    private int hikariDsMaxPoolSize;

    @Value("${hikari.config.idletimeout}")
    private long hikariDsIdleTimeoutMs;

    @Value("${hikari.ds.url}")
    private String hikariDsUrl;

    @Value("${hikari.ds.usr}")
    private String hikariDsUsr;

    @Value("${hikari.ds.psw}")
    private String hikariDsPsw;

    private Properties newDataSourceProperties() {
        Properties properties = new Properties();
        properties.put("url", hikariDsUrl);
        properties.put("user", hikariDsUsr);
        properties.put("password", hikariDsPsw);
        return properties;
    }

    private HikariDataSource newHikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName(hikariDsPoolName);
        hikariConfig.setConnectionTestQuery(hikariDsConnectionTestQuery);
        hikariConfig.setDataSourceClassName(hikariDsClassName);
        hikariConfig.setMaximumPoolSize(hikariDsMaxPoolSize);
        hikariConfig.setIdleTimeout(hikariDsIdleTimeoutMs);
        hikariConfig.setDataSourceProperties(newDataSourceProperties());
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public CadastroClientesServiceApi newCadastroClientesServiceApi() {

        final CadastroClientesDaoApi cadastroClientesDaoApi = new CadastroClientesDaoJdbcImpl(//
                sqlClienteCreate, //
                sqlClienteFindPage, //
                sqlClienteSearch, //
                sqlClienteUpdate, //
                newHikariDataSource());

        return new CadastroClientesServiceImpl(cadastroClientesDaoApi);
    }

}
