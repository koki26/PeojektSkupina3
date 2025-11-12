package org.example.Entita.Employee;

import java.io.*;
import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> employeeArrayList;

    public EmployeeManager() {
        this.employeeArrayList = new ArrayList<>();
    }

    public void loadEmployeeData(){
        String csvSoubor = "C:\\Users\\koki26\\IdeaProjects\\PeojektSkupina3\\src\\main\\java\\org\\example\\Data\\employee.csv";
        String radek;

        try (BufferedReader br = new BufferedReader(new FileReader(csvSoubor))) {
            br.readLine();
            while ((radek = br.readLine()) != null) {
                String[] hodnoty = radek.split(",");
                String jmeno = hodnoty[0];
                String lastName = hodnoty[1];
                int age = Integer.parseInt(hodnoty[2]);
                int id = Integer.parseInt(hodnoty[3]);
                EmployeeType type = EmployeeType.valueOf(hodnoty[4]);
                String username = hodnoty[5];
                String password = hodnoty[6];

                employeeArrayList.add(new Employee(jmeno, lastName, age, id, type, username, password));
            }
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru: " + e.getMessage());
        }
    }

    public void saveEmployeeData(){
        String csvSoubor = "C:\\Users\\koki26\\IdeaProjects\\PeojektSkupina3\\src\\main\\java\\org\\example\\Data\\employee.csv";

        try (PrintWriter pw = new PrintWriter(new FileWriter(csvSoubor))) {
            pw.println("name,lastName,age,id,type,username,password");
            for (Employee employee : employeeArrayList) {
                pw.println(employee.getName() + "," +
                        employee.getLastName() + "," +
                        employee.getAge() + "," +
                        employee.getId() + "," +
                        employee.getType() + "," +
                        employee.getUsername() + "," +
                        employee.getPassword());
            }
        } catch (IOException e) {
            System.out.println("Chyba při zápisu souboru: " + e.getMessage());
        }
    }

    public void printEmployeeData(){
        for (Employee x: employeeArrayList){
            x.printDataEmployee();
        }
    }

    public Employee login(String username, String password) {
        for (Employee employee : employeeArrayList) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getEmployees() {
        return employeeArrayList;
    }

    public void addEmployee(Employee employee) {
        employeeArrayList.add(employee);
        saveEmployeeData();
    }
}