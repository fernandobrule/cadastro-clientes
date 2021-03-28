package com.fragnostic.cadcli.glue;

import java.io.Serializable;

public class ClienteUpdateReq implements Serializable {

    private Long clienteId;
    private String name;
    private String surname;
    private Short age;
    private String address;
    private String city;
    private String country;
    private String mobile;
    private String email;

    public ClienteUpdateReq() {
    }

    public ClienteUpdateReq(Builder builder) {
        this.clienteId = builder.clienteId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.address = builder.address;
        this.city = builder.city;
        this.country = builder.country;
        this.mobile = builder.mobile;
        this.email = builder.email;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {

        private Long clienteId;
        private String name;
        private String surname;
        private Short age;
        private String address;
        private String city;
        private String country;
        private String mobile;
        private String email;

        public Builder setClienteId(final Long clienteId) {
            this.clienteId = clienteId;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(final String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setAge(final Short age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(final String city) {
            this.city = city;
            return this;
        }

        public Builder setCountry(final String country) {
            this.country = country;
            return this;
        }

        public Builder setMobile(final String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setEmail(final String email) {
            this.email = email;
            return this;
        }

        public ClienteUpdateReq build() {
            return new ClienteUpdateReq(this);
        }

    }
}
