package com.fragnostic.cadcli.endpoint.glue;

import java.io.Serializable;

public class SimpleResponseJson implements Serializable {

    private Boolean success;
    private String message;

    public SimpleResponseJson(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
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
