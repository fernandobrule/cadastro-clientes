package io.platformbuilders.cadcli.glue;

import java.io.Serializable;
import java.util.List;

public class ClienteSearchReq implements Serializable {

    private List<String> selectItems;

    private List<String> whereItems;

    private List<String> orderByItems;

    public ClienteSearchReq() {
    }

    public ClienteSearchReq(Build build) {
        this.selectItems = build.selectItems;
        this.whereItems = build.whereItems;
        this.orderByItems = build.orderByItems;
    }

    public List<String> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<String> selectItems) {
        this.selectItems = selectItems;
    }

    public List<String> getWhereItems() {
        return whereItems;
    }

    public void setWhereItems(List<String> whereItems) {
        this.whereItems = whereItems;
    }

    public List<String> getOrderByItems() {
        return orderByItems;
    }

    public void setOrderByItems(List<String> orderByItems) {
        this.orderByItems = orderByItems;
    }

    public static class Build {

        private List<String> selectItems;

        private List<String> whereItems;

        private List<String> orderByItems;

        public Build setSelectItems(final List<String> selectItems) {
            this.selectItems = selectItems;
            return this;
        }

        public Build setWhereItems(final List<String> whereItems) {
            this.whereItems = whereItems;
            return this;
        }

        public Build setOrderByItems(final List<String> orderByItems) {
            this.orderByItems = orderByItems;
            return this;
        }

        public ClienteSearchReq build() {
            return new ClienteSearchReq(this);
        }

    }
}
