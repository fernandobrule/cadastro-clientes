package io.platformbuilders.cadcli.service.impl;

import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoApi;
import io.platformbuilders.cadcli.dao.api.CadastroClientesDaoException;
import io.platformbuilders.cadcli.glue.*;
import io.platformbuilders.cadcli.service.api.CadastroClientesServiceApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CadastroClientesServiceImpl implements CadastroClientesServiceApi {

    private CadastroClientesDaoApi cadastroClientesDaoApi;

    public CadastroClientesServiceImpl() {
    }

    public CadastroClientesServiceImpl(CadastroClientesDaoApi cadastroClientesDaoApi) {
        this.cadastroClientesDaoApi = cadastroClientesDaoApi;
    }

    public void setCadastroClientesDaoApi(CadastroClientesDaoApi cadastroClientesDaoApi) {
        this.cadastroClientesDaoApi = cadastroClientesDaoApi;
    }

    @Override
    public ClienteCreateResp create(final Context context, final ClienteCreateReq clienteCreateReq) {
        try {
            Long clienteId = cadastroClientesDaoApi.create(clienteCreateReq);
            return new ClienteCreateResp(true, "cadastro.clientes.service.create.success", clienteId,
                    clienteCreateReq.getAge());
        } catch (CadastroClientesDaoException e) {
            log.error("create() - {}", e.getMessage());
            return new ClienteCreateResp(false, "cadastro.clientes.service.create.error");
        }
    }

    @Override
    public ClienteUpdateResp update(final Context context, final ClienteUpdateReq clienteUpdateReq) {
        try {
            int affectedRows = cadastroClientesDaoApi.update(clienteUpdateReq);
            if (1 == affectedRows) {
                return new ClienteUpdateResp(true, "cadastro.clientes.service.update.success",
                        clienteUpdateReq.getAge());
            } else {
                return new ClienteUpdateResp(false, "cadastro.clientes.service.update.error.no.update.was.done");
            }
        } catch (CadastroClientesDaoException e) {
            log.error("update() - {}", e.getMessage());
            return new ClienteUpdateResp(false, "cadastro.clientes.service.update.error");
        }
    }

    @Override
    public ClientePageGetResp list(final Context context, final ClientePageGetReq pageGetReq) {
        try {
            return new ClientePageGetResp(true, "cadastro.clientes.service.list.success",
                    cadastroClientesDaoApi.list(pageGetReq));
        } catch (CadastroClientesDaoException e) {
            log.error("list() - {}", e.getMessage());
            return new ClientePageGetResp(false, "cadastro.clientes.service.list.error");
        }
    }

    @Override
    public ClienteSearchResp search(Context context, ClienteSearchReq searchReq) {
        try {
            return new ClienteSearchResp(true, "cadastro.clientes.service.search.success",
                    cadastroClientesDaoApi.search(searchReq));
        } catch (CadastroClientesDaoException e) {
            log.error("search() - {}", e.getMessage());
            return new ClienteSearchResp(false, "cadastro.clientes.service.search.error");
        }
    }

}
