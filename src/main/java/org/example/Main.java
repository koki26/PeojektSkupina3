package org.example;

import org.example.Entita.Employee.*;

public class Main {

    public static void main(String[] args) {


        // sef
        // +2 zaměstnanců
        // ukládání ()
        // vztup ()

        EmployeeManager manager = new EmployeeManager();

        Manager m = new Manager(1, "Petr", "Novák");
        Accountant a = new Accountant(2, "Lenka", "Kovářová");
        Librarian l = new Librarian(3, "Tomáš", "Hrubý");
        Technician t = new Technician(4, "Eva", "Svobodová");

        manager.addEmployee();
        manager.addEmployee();
        manager.addEmployee();
        manager.addEmployee();

        System.out.println("Zaměstnanci podle typů:");
        for (Employee e : manager.getAllEmployees()) {
            System.out.print(" - " + e.getClass().getSimpleName() + ": " + e);
        }


        Library library = new Library();
        library.loadBookData();
        library.printBookData();

        System.out.println();
        System.out.println();
        library.loadEmployeeData();
        library.printEmployeeData();


        System.out.println();
        System.out.println();
        library.loadCustomerData();
        library.printCustomerData();


    }
}