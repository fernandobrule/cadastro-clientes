package com.fragnostic.cadcli.endpoint.controller;

import com.fragnostic.cadcli.endpoint.glue.*;
import com.fragnostic.cadcli.glue.*;
import com.fragnostic.cadcli.service.api.CadastroClientesServiceApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Slf4j
@Api(value = "CadastroClientesAPI", tags = { "Cadastro Clientes API" })
@RestController
@RequestMapping("/cadcli")
public class CadastroClientesController {

    private Context newContext(final String region, final String language) {
        return new Context(//
                new Locale.Builder()//
                        .setRegion(region)//
                        .setLanguage(language)//
                        .build());
    }

    @Autowired
    private CadastroClientesServiceApi cadastroClientesServiceApi;

    @ApiOperation(value = "Create a Cliente")
    @PostMapping(value = "/", produces = { "application/json" })
    public SimpleResponseJson create( //
                                      @ApiParam(value = "[Value/Format] [Remarks] BR | CL | US", example = "BR", required = true) //
            @RequestHeader(value = "X-Region", required = true) final String region, //
                                      @ApiParam(value = "[Value/Format] [Remarks] pt | es | en", example = "pt", required = true) //
            @RequestHeader(value = "X-Language", required = true) final String language, //
                                      @RequestBody ClienteCreateReq clienteCreateReq) {

        if (log.isInfoEnabled()) {
            log.info("create() - enter");
        }

        ClienteCreateResp clienteCreateResp = cadastroClientesServiceApi.create(newContext(region, language),
                clienteCreateReq);

        if (clienteCreateResp.isSuccess()) {
            return new ClienteCreateRespJson(true, clienteCreateResp.getMessage(), clienteCreateResp.getClienteId(),
                    clienteCreateResp.getAge());
        } else {
            return new FailResponseJson(clienteCreateResp.getMessage());
        }
    }

    @ApiOperation(value = "List Clientes")
    @GetMapping(value = "/", produces = { "application/json" })
    public SimpleResponseJson list( //
            @ApiParam(value = "[Value/Format] [Remarks] BR | CL | US", example = "BR", required = true) //
            @RequestHeader(value = "X-Region", required = true) final String region, //
            @ApiParam(value = "[Value/Format] [Remarks] pt | es | en", example = "pt", required = true) //
            @RequestHeader(value = "X-Language", required = true) final String language, //
            @RequestBody ClientePageGetReq clientePageGetReq) {

        if (log.isInfoEnabled()) {
            log.info("list() - enter");
        }

        ClientePageGetResp clientePageGetResp = cadastroClientesServiceApi.list(newContext(region, language),
                clientePageGetReq);

        if (clientePageGetResp.isSuccess()) {
            return new ResponseWithBodyJson(clientePageGetResp.getMessage(), clientePageGetResp.getPage());
        } else {
            return new FailResponseJson(clientePageGetResp.getMessage());
        }
    }

    @ApiOperation(value = "Search Clientes")
    @GetMapping(value = "/search", produces = { "application/json" })
    public SimpleResponseJson search( //
            @ApiParam(value = "[Value/Format] [Remarks] BR | CL | US", example = "BR", required = true) //
            @RequestHeader(value = "X-Region", required = true) final String region, //
            @ApiParam(value = "[Value/Format] [Remarks] pt | es | en", example = "pt", required = true) //
            @RequestHeader(value = "X-Language", required = true) final String language, //
            @RequestBody ClienteSearchReq clienteSearchReq) {

        if (log.isInfoEnabled()) {
            log.info("search() - enter");
        }

        ClienteSearchResp clienteSearchResp = cadastroClientesServiceApi.search(newContext(region, language),
                clienteSearchReq);

        if (clienteSearchResp.isSuccess()) {
            return new ResponseWithBodyJson(clienteSearchResp.getMessage(), clienteSearchResp.getList());
        } else {
            return new FailResponseJson(clienteSearchResp.getMessage());
        }
    }

    @ApiOperation(value = "Update Cliente")
    @PatchMapping(value = "/", produces = { "application/json" })
    public SimpleResponseJson update(
            @ApiParam(value = "[Value/Format] [Remarks] BR | CL | US", example = "BR", required = true) @RequestHeader(value = "X-Region", required = true) final String region,
            @ApiParam(value = "[Value/Format] [Remarks] pt | es | en", example = "pt", required = true) @RequestHeader(value = "X-Language", required = true) final String language,
            @RequestBody ClienteUpdateReq clienteUpdateReq) {

        if (log.isInfoEnabled()) {
            log.info("update() - enter");
        }

        ClienteUpdateResp clienteUpdateResp = cadastroClientesServiceApi.update(newContext(region, language),
                clienteUpdateReq);

        if (clienteUpdateResp.isSuccess()) {
            return new ClienteUpdateRespJson(true, clienteUpdateResp.getMessage(), clienteUpdateResp.getAge());
        } else {
            return new FailResponseJson(clienteUpdateResp.getMessage());
        }
    }

}
