package ru.netology;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Введите name (имя)!");
        } else this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Введите surname (фамилию)!");
        } else this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age > 0 && age <= 250) {
            this.age = age;
            return this;
        }
        throw new IllegalArgumentException("Введён некорректный возраст!");
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null) throw new IllegalStateException("Не заполнено поле 'name' (имя)");
        else if (surname == null) throw new IllegalStateException("Не заполнено поле 'surname' (фамилия)");
        else {
            if (age <= 0) {
                return new Person(name, surname);
            } else {
                if (address == null) return new Person(name, surname, age);
                else return new Person(name, surname, age, address);
            }
        }
    }
}
