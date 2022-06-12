package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    public Person(String name, String surname, int age) {
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    public Person(String name, String surname, int age, String address) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setAddress(address);
    }

    public boolean hasAge() {
        return age > 0;
    }

    public void setAge(int age) {
        if (!hasAge()) this.age = age;
    }

    public boolean hasAddress() {
        return getAddress() != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (getName() == null) this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (getSurname() == null) this.surname = surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!hasAddress()) this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) this.age++;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", surname=" + surname +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
