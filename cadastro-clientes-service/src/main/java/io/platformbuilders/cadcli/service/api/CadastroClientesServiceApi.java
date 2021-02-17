package io.platformbuilders.cadcli.service.api;

import io.platformbuilders.cadcli.glue.*;

public interface CadastroClientesServiceApi {

    ClienteCreateResp create(Context context, ClienteCreateReq clienteCreateReq);

    ClienteUpdateResp update(Context context, ClienteUpdateReq clienteUpdateReq);

    ClientePageGetResp list(Context context, ClientePageGetReq pageGetReq);

    ClienteSearchResp search(Context context, ClienteSearchReq searchReq);

}
