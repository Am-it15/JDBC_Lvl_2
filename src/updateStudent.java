import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class updateStudent {
    public static void update(Scanner scan) {

        try {

            Connection connection = DBConnection.getConnection();
            Statement updStmt = connection.createStatement();

            System.out.println("===========================X Here is Update menu X===========================");
            System.out.println("1: Address");
            System.out.println("2: Phone number");
            System.out.println("3: Email");
            System.out.print("Enter your choice :: ");
            int updChoice = scan.nextInt();
            scan.nextLine(); // FIXED

            switch (updChoice) {
                case 1 -> updAddress(scan, updStmt);
                case 2 -> updPhone(scan, updStmt);
                case 3 -> updEmail(scan, updStmt);
                default -> System.out.println("Enter valid Update choice....");
            }

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void updEmail(Scanner scan, Statement updStmt) {
        try {
            System.out.println("<< For update your email >>");
            System.out.print("Enter Enrollment no. :: ");
            long updEnroll = scan.nextLong();
            scan.nextLine();

            System.out.print("Enter new email :: ");
            String updEmail = scan.nextLine();

            String updEmailQuery = "UPDATE students SET semail='" + updEmail + "' WHERE senroll=" + updEnroll;

            int updRow = updStmt.executeUpdate(updEmailQuery);

            if (updRow > 0) {
                System.out.println(updEnroll + " updated successfully");
            } else {
                System.out.println(updEnroll + " email updation failed");
            }

        } catch (Exception e) {
            System.out.println("Error :: " + e.getMessage());
        }
    }

    private static void updPhone(Scanner scan, Statement updStmt) {
        try {
            System.out.println("<< For update your phone number >>");
            System.out.print("Enter Enrollment no. :: ");
            long updEnroll = scan.nextLong();

            System.out.print("Enter new phone number :: ");
            long updPhone = scan.nextLong();
            scan.nextLine();

            String updPhoneQuery = "UPDATE students SET sphone=" + updPhone + " WHERE senroll=" + updEnroll;

            int updRow = updStmt.executeUpdate(updPhoneQuery);

            if (updRow > 0) {
                System.out.println(updEnroll + " updated successfully");
            } else {
                System.out.println(updEnroll + " phone updation failed");
            }
        } catch (Exception e) {
            System.out.println("Error :: " + e.getMessage());
        }
    }

    private static void updAddress(Scanner scan, Statement updStmt) {
        try {
            System.out.println("<< For update your address >>");
            System.out.print("Enter Enrollment no. :: ");
            long updEnroll = scan.nextLong();
            scan.nextLine();

            System.out.print("Enter new address :: ");
            String updAdd = scan.nextLine();

            String updAddQuery = "UPDATE students SET saddress='" + updAdd + "' WHERE senroll=" + updEnroll;

            int updRow = updStmt.executeUpdate(updAddQuery);

            if (updRow > 0) {
                System.out.println(updEnroll + " address updated successfully");
            } else {
                System.out.println(updEnroll + " address updation failed");
            }
        } catch (Exception e) {
            System.out.println("Error :: " + e.getMessage());
        }
    }
}
