package com.company;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        son.happyBirthday();

        System.out.println("У " + mom + " есть сын, " + son);

        Person vasya = new PersonBuilder()
                .setName("Вася")
                .setSurname("Петров")
                .build();
        vasya.happyBirthday();
        System.out.println(vasya);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
