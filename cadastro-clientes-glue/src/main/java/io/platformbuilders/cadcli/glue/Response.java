package io.platformbuilders.cadcli.glue;

public abstract class Response {

    private Boolean success;
    private String message;

    public Response() {
    }

    public Response(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
