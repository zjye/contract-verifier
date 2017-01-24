package com.zjye.consumer.command;

import com.zjye.consumer.model.Person;

public class BeerCommand {
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
