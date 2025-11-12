package org.example.Entita.Employee;

public class Librarian extends Employee {

    public Librarian(String name, String lastName, int age, int id) {
        super(name, lastName, age, id);
    }

    public Librarian(Object id, Object firstName, String lastName) {
        super(id, firstName, lastName);
    }
    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + getId() +
                ", name='" + getFirstName() + " " + getLastName() + '\'' +
                '}';
    }
}
