package org.example.Entita.Employee;

import org.example.Entita.Entita;

public class Employee extends Entita {
    private int id;
    private String email;
    private String position;

    public Employee(String name, String lastName, int age, int id) {
        super(name, lastName, age);
        this.id = id;

    }

    public Employee(Object id, Object firstName, String lastName) {
        super();
    }

    public void printDataCustomer(){
        System.out.println("Name: " + getName() + " LastName: " + getLastName() + " Age: " + getAge() + " Id: " + id);
    }


    protected Object getFirstName() {
        return null;
    }

    protected Object getId() {
        return null;
    }
}
