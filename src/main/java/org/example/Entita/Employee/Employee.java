package org.example.Entita.Employee;

import org.example.Entita.Entita;

public class Employee extends Entita {
    private int id;


    public Employee(String name, String lastName, int age, int id) {
        super(name, lastName, age);
        this.id = id;
    }

    public void printDataCustomer(){
        System.out.println("Name: " + getName() + " LastName: " + getLastName() + " Age: " + getAge() + " Id: " + id);
    }


}
