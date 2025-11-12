package org.example;

import org.example.Books.BookManager;
import org.example.Entita.Custumer.Customer;
import org.example.Entita.Custumer.CustomerManager;
import org.example.Entita.Employee.EmployeeManager;

public class Library {

    private BookManager bookManager;
    private EmployeeManager employeeManager;
    private CustomerManager customerManager;

    public Library() {
        this.bookManager = new BookManager();
        this.employeeManager = new EmployeeManager();
        this.customerManager = new CustomerManager();
    }


    public void loadBookData(){
        bookManager.loadBookData();
    }

    public void printBookData(){
        bookManager.printBookData();
    }

    public void loadEmployeeData(){
        employeeManager.loadEmployeeData();
    }

    public void printEmployeeData(){
        employeeManager.printEmployeeData();
    }

    public void loadCustomerData(){
        customerManager.loadCustomerData();
    }

    public void printCustomerData(){
        customerManager.printCustomerData();
    }









}
