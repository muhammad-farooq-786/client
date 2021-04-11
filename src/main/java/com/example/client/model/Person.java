package com.example.client.model;


public class Person {


    private String ID;
    private String name;
    private String email;
    private String address;

    public Person() {
    }

    public Person(String ID, String name, String email, String address) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Model{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
