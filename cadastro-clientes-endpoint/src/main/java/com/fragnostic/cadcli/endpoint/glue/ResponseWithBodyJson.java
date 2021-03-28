package com.fragnostic.cadcli.endpoint.glue;

public class ResponseWithBodyJson extends SimpleResponseJson {

    private Object body;

    public ResponseWithBodyJson(String message, Object body) {
        super(true, message);
        this.body = body;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
