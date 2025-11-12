package org.example.Entita.Employee;

import org.example.Entita.Entita;

public class Employee extends Entita {
    private int id;
    private EmployeeType type;
    private String username;
    private String password;

    public Employee(String name, String lastName, int age, int id, EmployeeType type, String username, String password) {
        super(name, lastName, age);
        this.id = id;
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public void printDataEmployee(){
        System.out.println("Name: " + getName() + " LastName: " + getLastName() +
                " Age: " + getAge() + " Id: " + id + " Type: " + type);
    }

    public int getId() {
        return id;
    }

    public EmployeeType getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isManager() {
        return type == EmployeeType.MANAGER;
    }

    public boolean isAccountant() {
        return type == EmployeeType.ACCOUNTANT;
    }

    public boolean isLibrarian() {
        return type == EmployeeType.LIBRARIAN;
    }
}