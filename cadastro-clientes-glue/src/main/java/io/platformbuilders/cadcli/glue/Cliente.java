package io.platformbuilders.cadcli.glue;

import java.io.Serializable;

public class Cliente implements Serializable {

    private Long clienteId;
    private String name;
    private String surname;
    private Short age;
    private String address;
    private String city;
    private String country;
    private String mobile;
    private String email;

    public Cliente() {
    }

    public Cliente(Long clienteId, String name, String surname, Short age, String address, String city, String country,
            String mobile, String email) {
        this.clienteId = clienteId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.city = city;
        this.country = country;
        this.mobile = mobile;
        this.email = email;
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

    @Override
    public String toString() {
        return "Cliente{" + "clienteId=" + clienteId + ", name='" + name + '\'' + ", surname='" + surname + '\''
                + ", age=" + age + ", address='" + address + '\'' + ", city='" + city + '\'' + ", country='" + country
                + '\'' + ", mobile='" + mobile + '\'' + ", email='" + email + '\'' + '}';
    }
}
