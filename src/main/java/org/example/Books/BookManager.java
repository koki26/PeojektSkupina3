package org.example.Books;
import java.io.*;
import java.util.ArrayList;

public class BookManager {
    private ArrayList<Book> bookArrayList;

    public BookManager() {
        this.bookArrayList = new ArrayList<>();
    }

    public void loadBookData(){
        String csvSoubor = "C:\\Users\\koki26\\IdeaProjects\\PeojektSkupina3\\src\\main\\java\\org\\example\\Data\\book.csv";
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

    public void saveBookData(){
        String csvSoubor = "C:\\Users\\koki26\\IdeaProjects\\PeojektSkupina3\\src\\main\\java\\org\\example\\Data\\book.csv";

        try (PrintWriter pw = new PrintWriter(new FileWriter(csvSoubor))) {
            pw.println("jmeno,id");
            for (Book book : bookArrayList) {
                pw.println(book.getName() + "," + book.getId());
            }
        } catch (IOException e) {
            System.out.println("Chyba při zápisu souboru: " + e.getMessage());
        }
    }

    public void printBookData(){
        for (Book x: bookArrayList){
            System.out.println(x);
        }
    }

    public void addBook(Book book) {
        bookArrayList.add(book);
        saveBookData();
    }

    public void removeBook(int bookId) {
        bookArrayList.removeIf(book -> book.getId() == bookId);
        saveBookData();
    }

    public ArrayList<Book> getBooks() {
        return bookArrayList;
    }

    public Book findBookById(int id) {
        for (Book book : bookArrayList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}