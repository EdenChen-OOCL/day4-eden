package oo;

import java.util.Objects;

public class Person {


    protected int id;
    protected String name;
    protected int age;
    protected String role = "";

    public Person(int id, String name, int age) {
        this(id, name, age, "");
    }

    public Person(int id, String name, int age, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(obj instanceof Person anotherPerson) {
            return this.id == anotherPerson.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
