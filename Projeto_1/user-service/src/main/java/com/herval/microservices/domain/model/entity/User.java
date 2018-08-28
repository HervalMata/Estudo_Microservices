package com.herval.microservices.domain.model.entity;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
public class User extends BaseEntity<String> {

    private String address;
    private String city;
    private String phoneNo;


    public User(String id, String name, String address, String city, String phoneNo) {
        super(id, name);
        this.address = address;
        this.city = city;
        this.phoneNo = phoneNo;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return String.format("{id: %s, name: %s, address: %s, city: %s, phoneNo: %s}", id, name, address, city, phoneNo);
    }
}
