package io.platformbuilders.cadcli.glue;

import java.io.Serializable;

public class ClientePageGetReq implements Serializable {

    private Integer number;
    private Integer size;
    private String orderBy;

    public ClientePageGetReq() {
    }

    public ClientePageGetReq(Builder builder) {
        this.number = builder.number;
        this.size = builder.size;
        this.orderBy = builder.orderBy;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public static class Builder {

        private Integer number;
        private Integer size;
        private String orderBy;

        public Builder setNumber(final Integer number) {
            this.number = number;
            return this;
        }

        public Builder setSize(final Integer size) {
            this.size = size;
            return this;
        }

        public Builder setOrderBy(final String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public ClientePageGetReq build() {
            return new ClientePageGetReq(this);
        }
    }
}
