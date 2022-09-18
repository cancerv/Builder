package com.company;

import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name != null && !name.isBlank()) {
            this.name = name;
            return this;
        }

        throw new IllegalArgumentException("Некорректное имя");
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname != null && !surname.isBlank()) {
            this.surname = surname;
            return this;
        }

        throw new IllegalArgumentException("Некорректная фамилия");
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age > -1) {
            this.age = OptionalInt.of(age);
            return this;
        }

        throw new IllegalArgumentException("Некорректный возраст");
    }

    public PersonBuilder setAddress(String address) throws IllegalArgumentException {
        if (address != null && !address.isBlank()) {
            this.address = address;
            return this;
        }

        throw new IllegalArgumentException("Некорректный адрес");
    }

    public Person build() throws IllegalStateException {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Имя или фамилия не указаны");
        }

        return new Person(this.name, this.surname, this.age, this.address);
    }

}

