package org.example.Entita.Employee;

public class Accountant extends Employee {

    public Accountant(String name, String lastName, int age, int id) {
        super(name, lastName, age, id);
    }

    public Accountant(Object id, Object firstName, String lastName) {
        super(id, firstName, lastName);
    }
    @Override
    public String toString() {
        return "Accontant{" +
                "id=" + getId() +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                '}';
    }
}
