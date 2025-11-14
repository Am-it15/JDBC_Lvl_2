import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        addStudent aStudent=new addStudent();
        updateStudent uStudent=new updateStudent();
        retrieveStudent rStudent=new retrieveStudent();
        dltStudent dStudent=new dltStudent();

        boolean t=true;
        System.out.println("=============================== JBCD LEVEL 2 ===============================\n");
        while (t) {
            System.out.println("================ STUDENT CRUD MENU ================");
            System.out.println("1: Add New Student");
            System.out.println("2: Retrieve Student Information");
            System.out.println("3: Update Student");
            System.out.println("4: Remove Student");
            System.out.println("5: Exit");
            System.out.println("\n> Enter you choice :: ");
            int choice= scan.nextInt();

            switch (choice) {
                case 1 -> addStudent.add();
                case 2 -> retrieveStudent.retrieve();
                case 3 -> updateStudent.update();
                case 4 -> dltStudent.delete();
                case 5 -> exitMenu();
                default -> System.out.println("\nEnter Valid input from menu......");
            }
        }

    }

    private static void exitMenu() {
        System.out.println("\nThank you for Using are Services.");
        System.exit(0);
    }
}
