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

    public String getConfirmAfterAssginLeader(int classNumber, String leaderName) {
        return String.format("I am %s, %s of Class %d. I know %s become Leader.", name, role, classNumber, leaderName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id && Objects.equals(role, person.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }
}
