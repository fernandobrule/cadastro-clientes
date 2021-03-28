package com.fragnostic.cadcli.glue;

public class ClientePageGetResp extends Response {

    private Page<Cliente> page;

    public ClientePageGetResp() {
    }

    public ClientePageGetResp(Boolean success, String message) {
        super(success, message);
    }

    public ClientePageGetResp(Boolean success, String message, Page<Cliente> page) {
        super(success, message);
        this.page = page;
    }

    public Page<Cliente> getPage() {
        return page;
    }

    public void setPage(Page<Cliente> page) {
        this.page = page;
    }
}
