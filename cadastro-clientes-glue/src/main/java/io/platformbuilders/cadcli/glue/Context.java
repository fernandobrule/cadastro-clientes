package io.platformbuilders.cadcli.glue;

import java.io.Serializable;
import java.util.Locale;

public class Context implements Serializable {

    private Locale locale;

    public Context() {
    }

    public Context(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
