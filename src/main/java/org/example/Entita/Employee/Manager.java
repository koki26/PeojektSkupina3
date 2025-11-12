package org.example.Entita.Employee;

public class Manager extends Employee {


    public Manager(Object id, Object firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Manager(String name, String lastName, int age, int id) {
        super(name, lastName, age, id);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                '}';
    }
}
