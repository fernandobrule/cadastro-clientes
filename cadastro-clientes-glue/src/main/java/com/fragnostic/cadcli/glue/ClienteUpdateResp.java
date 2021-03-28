package com.fragnostic.cadcli.glue;

public class ClienteUpdateResp extends Response {

    private Short age;

    public ClienteUpdateResp() {
    }

    public ClienteUpdateResp(Boolean success, String message) {
        super(success, message);
    }

    public ClienteUpdateResp(Boolean success, String message, Short age) {
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
