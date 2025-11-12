package org.example.Entita.Custumer;

import org.example.Entita.Employee.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerManager {
    private ArrayList<Customer> customerArrayList;

    public CustomerManager() {
        this.customerArrayList = new ArrayList<>();
    }

    public void loadCustomerData(){
        String csvSoubor = "C:\\Users\\koki26\\IdeaProjects\\PeojektSkupina3\\src\\main\\java\\org\\example\\Data\\customer.csv";
        String radek;

        try (BufferedReader br = new BufferedReader(new FileReader(csvSoubor))) {
            br.readLine();
            while ((radek = br.readLine()) != null) {
                String[] hodnoty = radek.split(",");
                String jmeno = hodnoty[0];
                String lastName = hodnoty[1];
                int age = Integer.parseInt(hodnoty[2]);
                int id = Integer.parseInt(hodnoty[3]);

                customerArrayList.add(new Customer(jmeno,lastName,age,0,id));
            }
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru: " + e.getMessage());
        }
    }


    public void printCustomerData(){
        for (Customer x: customerArrayList){
            x.printDataCustomer();
        }
    }

}
