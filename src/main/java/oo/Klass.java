package oo;

import java.util.Objects;

public class Klass {
    private final int number;

    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public void assignLeader(Student targetStudent) {
        if (!targetStudent.isIn(this)) {
            System.out.println("It is not one of us.");
            return;
        }
        this.leader = targetStudent;
    }

    public boolean isLeader(Student student) {
        return Objects.equals(leader, student);
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
