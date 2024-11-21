package oo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Klass {
    private final int number;

    private Student leader;

    private final Set<Person> subscribers = new HashSet<>();

    public Klass(int number) {
        this.number = number;
    }

    public void assignLeader(Student targetStudent) {
        if (!targetStudent.isIn(this)) {
            System.out.println("It is not one of us.");
            return;
        }
        this.leader = targetStudent;

        processAfterAssign(this.number, targetStudent.name);
    }

    private void processAfterAssign(int classNumber, String leaderName) {
        subscribers.forEach(subscriber -> {
            String confirmString = subscriber.getConfirmAfterAssginLeader(classNumber, leaderName);
            System.out.println(confirmString);
        });
    }

    public boolean isLeader(Student student) {
        return Objects.equals(leader, student);
    }

    public void attach(Person subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    public int getNumber() {
        return number;
    }
}
