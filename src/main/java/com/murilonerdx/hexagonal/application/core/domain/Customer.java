package com.murilonerdx.hexagonal.application.core.domain;


public class Customer {
    private String id;
    private String name;
    private Address address;
    private String suid;
    private Boolean isValidCpf;

    public Customer(String id, String name, Address address, String suid, Boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.suid = suid;
        this.isValidCpf = isValidCpf;
    }

    public Customer() {
        this.isValidCpf = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }
}
