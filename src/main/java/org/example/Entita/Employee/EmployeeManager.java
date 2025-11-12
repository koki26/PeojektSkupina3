package org.example.Entita.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> employeeArrayList;
    private Boss boss;

    public EmployeeManager() {
        this.employeeArrayList = new ArrayList<>();
    }

    public void loadEmployeeData(){
        String csvSoubor = "/Users/stehlik.petr08/Documents/untitled folder 5/src/main/java/org/example/Data/employee.csv";
        String radek;

        try (BufferedReader br = new BufferedReader(new FileReader(csvSoubor))) {
            br.readLine();
            while ((radek = br.readLine()) != null) {
                String[] hodnoty = radek.split(",");
                String jmeno = hodnoty[0];
                String lastName = hodnoty[1];
                int age = Integer.parseInt(hodnoty[2]);
                int id = Integer.parseInt(hodnoty[3]);

                employeeArrayList.add(new Employee(jmeno,lastName,age,id));
            }
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru: " + e.getMessage());
        }
    }

    public void printEmployeeData(){
        for (Employee x: employeeArrayList){
            x.printDataCustomer();
        }
    }


    public void addEmployee() {
    }

    public Employee[] getAllEmployees() {
        return new Employee[0];
    }
}
