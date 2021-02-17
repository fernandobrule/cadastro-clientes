package io.platformbuilders.cadcli.dao.impl;

import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoApi;
import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoException;
import io.platformbuilders.cadcli.dao.support.DaoSupport;
import io.platformbuilders.cadcli.glue.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class CadastroClientesDaoJdbcImpl implements CadastroClientesDaoApi, DaoSupport {

    private static final String CLIENTE_ID = "cliente_id";
    private static final String CLIENTE_NAME = "cliente_name";
    private static final String CLIENTE_SURNAME = "cliente_surname";
    private static final String CLIENTE_AGE = "cliente_age";
    private static final String CLIENTE_ADDRESS = "cliente_address";
    private static final String CLIENTE_CITY = "cliente_city";
    private static final String CLIENTE_COUNTRY = "cliente_country";
    private static final String CLIENTE_MOBILE = "cliente_mobile";
    private static final String CLIENTE_EMAIL = "cliente_email";

    private static final Map<String, String> columnsMap = new HashMap<>() {
        {
            put("id", CLIENTE_ID);
            put("name", CLIENTE_NAME);
            put("surname", CLIENTE_SURNAME);
            put("age", CLIENTE_AGE);
            put("address", CLIENTE_ADDRESS);
            put("city", CLIENTE_CITY);
            put("country", CLIENTE_COUNTRY);
            put("mobile", CLIENTE_MOBILE);
            put("email", CLIENTE_EMAIL);
        }
    };

    private JdbcTemplate jdbcTemplate;

    private String sqlClienteCreate;
    private String sqlClienteFindPage;
    private String sqlClienteSearch;
    private String sqlClienteUpdate;

    public CadastroClientesDaoJdbcImpl() {
    }

    public CadastroClientesDaoJdbcImpl(String sqlClienteCreate, String sqlClienteFindPage, String sqlClienteSearch,
            String sqlClienteUpdate, DataSource dataSource) {
        this.sqlClienteCreate = sqlClienteCreate;
        this.sqlClienteFindPage = sqlClienteFindPage;
        this.sqlClienteSearch = sqlClienteSearch;
        this.sqlClienteUpdate = sqlClienteUpdate;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setSqlClienteCreate(String sqlClienteCreate) {
        this.sqlClienteCreate = sqlClienteCreate;
    }

    public void setSqlClienteUpdate(String sqlClienteUpdate) {
        this.sqlClienteUpdate = sqlClienteUpdate;
    }

    public void setSqlClienteFindPage(String sqlClienteFindPage) {
        this.sqlClienteFindPage = sqlClienteFindPage;
    }

    public void setSqlClienteSearch(String sqlClienteSearch) {
        this.sqlClienteSearch = sqlClienteSearch;
    }

    private String newItemValue(final ResultSet rs, final List<String> selectItems) {
        return selectItems.stream().map(col -> {
            try {
                return String.format("%s: %s", col, rs.getString(columnsMap.get(col)));
            } catch (SQLException throwables) {
                return String.format("¿%s?", col);
            }
        }).collect(Collectors.joining(", "));
    }

    private final RowMapper<Cliente> newCliente = (rs, rowNum) -> new Cliente(//
            rs.getLong(CLIENTE_ID), //
            rs.getString(CLIENTE_NAME), //
            rs.getString(CLIENTE_SURNAME), //
            rs.getShort(CLIENTE_AGE), //
            rs.getString(CLIENTE_ADDRESS), //
            rs.getString(CLIENTE_CITY), //
            rs.getString(CLIENTE_COUNTRY), //
            rs.getString(CLIENTE_MOBILE), //
            rs.getString(CLIENTE_EMAIL));

    @Override
    public Long create(final ClienteCreateReq clienteCreateReq) throws CadastroClientesDaoException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                final PreparedStatement ps = connection.prepareStatement(sqlClienteCreate,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, clienteCreateReq.getName());
                ps.setString(2, clienteCreateReq.getSurname());
                ps.setShort(3, clienteCreateReq.getAge());
                ps.setString(4, clienteCreateReq.getAddress());
                ps.setString(5, clienteCreateReq.getCity());
                ps.setString(6, clienteCreateReq.getCountry());
                ps.setString(7, clienteCreateReq.getMobile());
                ps.setString(8, clienteCreateReq.getEmail());
                return ps;
            }, keyHolder);

            return getKey(keyHolder);

        } catch (DataAccessException dae) {
            log.error("create() - {}", dae.getMessage());
            throw new CadastroClientesDaoException("cadastro.dao.create.error");
        }
    }

    @Override
    public Page<Cliente> list(final ClientePageGetReq clientePageGetReq) throws CadastroClientesDaoException {
        try {
            List<Cliente> list = jdbcTemplate.query(//
                    applyOrderBy(sqlClienteFindPage, columnsMap, clientePageGetReq.getOrderBy()), //
                    newCliente, //
                    clientePageGetReq.getNumber(), //
                    clientePageGetReq.getSize());

            return new Page.Builder<Cliente>() //
                    .setNumber(clientePageGetReq.getNumber())//
                    .setSize(clientePageGetReq.getSize())//
                    .setOrderBy(clientePageGetReq.getOrderBy())//
                    .setRows(list)//
                    .build();
        } catch (DataAccessException dae) {
            log.error("list() - {}", dae.getMessage());
            throw new CadastroClientesDaoException("cadastro.dao.list.error");
        }
    }

    @Override
    public Integer update(final ClienteUpdateReq clienteUpdateReq) throws CadastroClientesDaoException {
        try {
            return jdbcTemplate.update(connection -> {
                final PreparedStatement ps = connection.prepareStatement(sqlClienteUpdate);
                ps.setString(1, clienteUpdateReq.getName());
                ps.setString(2, clienteUpdateReq.getSurname());
                ps.setShort(3, clienteUpdateReq.getAge());
                ps.setString(4, clienteUpdateReq.getAddress());
                ps.setString(5, clienteUpdateReq.getCity());
                ps.setString(6, clienteUpdateReq.getCountry());
                ps.setString(7, clienteUpdateReq.getMobile());
                ps.setString(8, clienteUpdateReq.getEmail());
                ps.setLong(9, clienteUpdateReq.getClienteId());
                return ps;
            });
        } catch (DataAccessException dae) {
            log.error("update() - {}", dae.getMessage());
            throw new CadastroClientesDaoException("cadastro.dao.update.error");
        }
    }

    @Override
    public List<SearchItem<Long>> search(final ClienteSearchReq clienteSearchReq) throws CadastroClientesDaoException {
        try {

            String sqlSearch = applySelectItems(sqlClienteSearch, addAge(clienteSearchReq.getSelectItems()),
                    columnsMap);
            sqlSearch = applyWhereItems(sqlSearch, clienteSearchReq.getWhereItems());
            sqlSearch = applyOrderByItems(sqlSearch, clienteSearchReq.getOrderByItems(), columnsMap);

            return jdbcTemplate.query(//
                    sqlSearch, //
                    (rs, rowNum) -> new SearchItem<Long>(//
                            rs.getLong(CLIENTE_ID), // List<String> selectItems
                            newItemValue(rs, clienteSearchReq.getSelectItems())));

        } catch (DataAccessException dae) {
            log.error("list() - {}", dae.getMessage());
            throw new CadastroClientesDaoException("cadastro.dao.search.error");
        }
    }

}
