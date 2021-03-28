package com.fragnostic.cadcli.glue;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

    private Integer number;
    private Integer size;
    private String orderBy;
    private List<T> rows;

    public Page() {
    }

    public Page(Builder<T> builder) {
        this.number = builder.number;
        this.size = builder.size;
        this.orderBy = builder.orderBy;
        this.rows = builder.rows;
    }

    public Boolean isEmpty() {
        return rows == null || rows.isEmpty();
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

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public static class Builder<T> {

        private Integer number;
        private Integer size;
        private String orderBy;
        private List<T> rows;

        public Builder<T> setNumber(final Integer number) {
            this.number = number;
            return this;
        }

        public Builder<T> setSize(final Integer size) {
            this.size = size;
            return this;
        }

        public Builder<T> setOrderBy(final String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public Builder<T> setRows(final List<T> rows) {
            this.rows = rows;
            return this;
        }

        public Page<T> build() {
            return new Page<>(this);
        }
    }
}
