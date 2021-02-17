package io.platformbuilders.cadcli.endpoint.glue;

public class ClienteCreateRespJson extends SimpleResponseJson {
    private Long clienteId;
    private Short age;

    public ClienteCreateRespJson(Boolean success, String message, Long clienteId, Short age) {
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
