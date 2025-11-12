package org.example.Entita.Custumer;

import org.example.Books.Book;
import org.example.Entita.Entita;

import java.util.ArrayList;

public class Customer extends Entita {
    private double money;
    private int id;
    private ArrayList<Book> bookArrayList;

    public Customer(String name, String lastName, int age, double money, int id) {
        super(name, lastName, age);
        this.money = money;
        this.id = id;
        this.bookArrayList = new ArrayList<>();
    }

    public void printDataCustomer(){
        System.out.println("Name: " + getName() + " LastName " + getLastName() + " Age: " + getAge() +" Money: " + money + " Id:" + id);
    }
}
