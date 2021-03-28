package com.fragnostic.cadcli.glue;

public class ClienteCreateResp extends Response {

    private Long clienteId;
    private Short age;

    public ClienteCreateResp() {
    }

    public ClienteCreateResp(Boolean success, String message) {
        super(success, message);
    }

    public ClienteCreateResp(Boolean success, String message, Long clienteId, Short age) {
        super(success, message);
        this.clienteId = clienteId;
        this.age = age;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
}
