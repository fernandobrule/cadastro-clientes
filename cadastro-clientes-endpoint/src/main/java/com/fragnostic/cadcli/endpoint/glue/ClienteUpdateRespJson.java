package com.fragnostic.cadcli.endpoint.glue;

public class ClienteUpdateRespJson extends SimpleResponseJson {

    private Short age;

    public ClienteUpdateRespJson(Boolean success, String message, Short age) {
        super(success, message);
        this.age = age;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
}
