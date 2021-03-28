package com.fragnostic.cadcli.endpoint.glue;

public class FailResponseJson extends SimpleResponseJson {

    public FailResponseJson(String message) {
        super(false, message);
    }

}
