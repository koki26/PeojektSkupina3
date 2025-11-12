package org.example.Entita.Employee.Boss;

import org.example.Entita.Employee.Employee;
import java.util.Random;

public class Boss extends Employee {
    public Boss(String name, String lastName, int age, int id) {
        super(name, lastName, age, id);
    }

    public void printProductivity() {
        Random random = new Random();

        System.out.println();
        for (String name: Employee) {
            int productivity = random.nextInt(101);
            System.out.println(name + "má produktivitu: " + productivity + "%");
        }
        Boss boss = new Boss();
        boss.printProductivity();
    }
}
