package org.example.Entita.Employee;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, String lastName, int age, int id) {
        super(name, lastName, age, id);
    }

    public PartTimeEmployee(Employee e) {
        super(e.getId(), e.getFirstName(), e.getLastName());
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "id=" + getId() +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                '}';
    }
}
