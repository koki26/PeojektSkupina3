package org.example.Books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookManager {
    private ArrayList<Book> bookArrayList;

    public BookManager() {
        this.bookArrayList = new ArrayList<>();
    }

    public void loadBookData(){
        String csvSoubor = "C:\\Users\\SkalickýAleš_4wrtv7e\\Downloads\\PVA-Library\\src\\main\\java\\org\\example\\Data\\book.csv";
        String radek;

        try (BufferedReader br = new BufferedReader(new FileReader(csvSoubor))) {
            br.readLine();
            while ((radek = br.readLine()) != null) {
                String[] hodnoty = radek.split(",");
                String jmeno = hodnoty[0];
                int id = Integer.parseInt(hodnoty[1]);

                bookArrayList.add(new Book(jmeno, id));
            }
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru: " + e.getMessage());
        }
    }

    public void printBookData(){
        for (Book x: bookArrayList){
            System.out.println(x);
        }
    }

}
