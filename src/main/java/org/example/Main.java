package org.example;

public class Main {

    public static void main(String[] args) {
        // sef
        // +2 zakaznicy
        // ukládání ()
        // vztup ()
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