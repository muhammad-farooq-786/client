package com.example.client.model;

import java.util.ArrayList;
import java.util.List;

public class PersonWrapper {

    private List<Person> personList;

    public PersonWrapper(){
        personList = new ArrayList<>();
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
