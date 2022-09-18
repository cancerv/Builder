package com.company;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age == null ? OptionalInt.empty() : age;
        this.address = address;
    }

    public boolean hasAge() {
        return this.age.isPresent();
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getAge() {
        return this.age.getAsInt();
    }


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age = OptionalInt.of(this.getAge() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getName());
        stringBuffer.append(" ");
        stringBuffer.append(this.getSurname());
        stringBuffer.append(" ");
        stringBuffer.append(this.hasAge() ? this.getAge() : "возраст не указан");
        stringBuffer.append(" ");
        stringBuffer.append(this.getAddress());
        return stringBuffer.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname);
    }
}
