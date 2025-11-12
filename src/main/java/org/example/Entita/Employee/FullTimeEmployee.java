package org.example.Entita.Employee;

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, String lastName, int age, int id) {
        super(name, lastName, age, id);
    }

    public FullTimeEmployee(Employee e) {
        super(e.getId(), e.getFirstName(), e.getLastName());
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "id=" + getId() +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                '}';
    }
}


