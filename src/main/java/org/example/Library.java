package org.example;
import org.example.Books.Book;
import org.example.Books.BookManager;
import org.example.Entita.Custumer.CustomerManager;
import org.example.Entita.Employee.Employee;
import org.example.Entita.Employee.EmployeeManager;
import org.example.Entita.Employee.EmployeeType;

import java.util.Scanner;

public class Library {
    private BookManager bookManager;
    private EmployeeManager employeeManager;
    private CustomerManager customerManager;
    private Scanner scanner;
    private Employee currentUser;

    public Library() {
        this.bookManager = new BookManager();
        this.employeeManager = new EmployeeManager();
        this.customerManager = new CustomerManager();
        this.scanner = new Scanner(System.in);
        this.currentUser = null;
    }

    public void loadAllData() {
        bookManager.loadBookData();
        employeeManager.loadEmployeeData();
        customerManager.loadCustomerData();
    }

    public void start() {
        loadAllData();
        showMainMenu();
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n=== KNIHOVNA SYSTEM ===");
            System.out.println("1. Přihlásit se");
            System.out.println("2. Zobrazit knihy");
            System.out.println("3. Zobrazit zaměstnance");
            System.out.println("4. Zobrazit zákazníky");
            System.out.println("5. Ukončit");
            System.out.print("Volba: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    printBookData();
                    break;
                case 3:
                    printEmployeeData();
                    break;
                case 4:
                    printCustomerData();
                    break;
                case 5:
                    System.out.println("Ukončování systému...");
                    return;
                default:
                    System.out.println("Neplatná volba!");
            }
        }
    }

    private void login() {
        System.out.print("Uživatelské jméno: ");
        String username = scanner.nextLine();
        System.out.print("Heslo: ");
        String password = scanner.nextLine();

        currentUser = employeeManager.login(username, password);

        if (currentUser != null) {
            System.out.println("Úspěšně přihlášen: " + currentUser.getName() + " " + currentUser.getLastName());
            showUserMenu();
        } else {
            System.out.println("Neplatné přihlašovací údaje!");
        }
    }

    private void showUserMenu() {
        while (currentUser != null) {
            System.out.println("\n=== " + currentUser.getType() + " PANEL ===");
            System.out.println("Přihlášen: " + currentUser.getName() + " " + currentUser.getLastName());

            if (currentUser.isManager()) {
                showManagerMenu();
            } else if (currentUser.isAccountant()) {
                showAccountantMenu();
            } else if (currentUser.isLibrarian()) {
                showLibrarianMenu();
            }

            System.out.println("9. Odhlásit se");
            System.out.print("Volba: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 9) {
                currentUser = null;
                System.out.println("Odhlášení úspěšné.");
                break;
            }
        }
    }

    private void showManagerMenu() {
        System.out.println("1. Spravovat knihy");
        System.out.println("2. Spravovat zaměstnance");
        System.out.println("3. Zobrazit všechny záznamy");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                manageBooks();
                break;
            case 2:
                manageEmployees();
                break;
            case 3:
                showAllRecords();
                break;
        }
    }

    private void showAccountantMenu() {
        System.out.println("1. Zobrazit finanční přehled");
        System.out.println("2. Zobrazit statistiky");
        // Další funkce pro účetního
    }

    private void showLibrarianMenu() {
        System.out.println("1. Půjčit knihu");
        System.out.println("2. Vrátit knihu");
        System.out.println("3. Vyhledat knihu");
        // Další funkce pro knihovníka
    }

    private void manageBooks() {
        System.out.println("\n=== SPRÁVA KNIH ===");
        System.out.println("1. Přidat knihu");
        System.out.println("2. Odstranit knihu");
        System.out.println("3. Zobrazit všechny knihy");
        System.out.println("4. Zpět");
        System.out.print("Volba: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                printBookData();
                break;
        }
    }

    private void addBook() {
        System.out.print("Název knihy: ");
        String name = scanner.nextLine();
        System.out.print("ID knihy: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(name, id);
        bookManager.addBook(book);
        System.out.println("Kniha přidána úspěšně!");
    }

    private void removeBook() {
        System.out.print("ID knihy k odstranění: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book book = bookManager.findBookById(id);
        if (book != null) {
            bookManager.removeBook(id);
            System.out.println("Kniha odstraněna úspěšně!");
        } else {
            System.out.println("Kniha s ID " + id + " nebyla nalezena!");
        }
    }

    private void manageEmployees() {
        System.out.println("\n=== SPRÁVA ZAMĚSTNANCŮ ===");
        System.out.println("1. Přidat zaměstnance");
        System.out.println("2. Zobrazit všechny zaměstnance");
        System.out.println("3. Zpět");
        System.out.print("Volba: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                printEmployeeData();
                break;
        }
    }

    private void addEmployee() {
        System.out.print("Jméno: ");
        String name = scanner.nextLine();
        System.out.print("Příjmení: ");
        String lastName = scanner.nextLine();
        System.out.print("Věk: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Typ zaměstnance:");
        System.out.println("1. Manager");
        System.out.println("2. Accountant");
        System.out.println("3. Librarian");
        System.out.print("Volba: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        EmployeeType type;
        switch (typeChoice) {
            case 1: type = EmployeeType.MANAGER; break;
            case 2: type = EmployeeType.ACCOUNTANT; break;
            case 3: type = EmployeeType.LIBRARIAN; break;
            default:
                System.out.println("Neplatná volba, nastaven jako Librarian");
                type = EmployeeType.LIBRARIAN;
        }

        System.out.print("Uživatelské jméno: ");
        String username = scanner.nextLine();
        System.out.print("Heslo: ");
        String password = scanner.nextLine();

        Employee employee = new Employee(name, lastName, age, id, type, username, password);
        employeeManager.addEmployee(employee);
        System.out.println("Zaměstnanec přidán úspěšně!");
    }

    private void showAllRecords() {
        System.out.println("\n=== VŠECHNY ZÁZNAMY ===");
        System.out.println("--- KNIHY ---");
        printBookData();
        System.out.println("\n--- ZAMĚSTNANCI ---");
        printEmployeeData();
        System.out.println("\n--- ZÁKAZNÍCI ---");
        printCustomerData();
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