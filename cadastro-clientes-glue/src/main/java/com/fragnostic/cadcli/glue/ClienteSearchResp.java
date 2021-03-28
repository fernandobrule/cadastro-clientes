package com.fragnostic.cadcli.glue;

import java.util.List;

public class ClienteSearchResp extends Response {

    private List<SearchItem<Long>> list;

    public ClienteSearchResp() {
    }

    public ClienteSearchResp(Boolean success, String message) {
        super(success, message);
    }

    public ClienteSearchResp(Boolean success, String message, List<SearchItem<Long>> list) {
        super(success, message);
        this.list = list;
    }

    public List<SearchItem<Long>> getList() {
        return list;
    }

    public void setList(List<SearchItem<Long>> list) {
        this.list = list;
    }

}
