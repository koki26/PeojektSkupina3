package org.example.Entita.Employee;

public class Technician extends Employee {
    public Technician(String name, String lastName, int age, int id) {
        super(name, lastName, age, id);
    }

    public Technician(Object id, Object firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + getId() +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                '}';
    }
}
