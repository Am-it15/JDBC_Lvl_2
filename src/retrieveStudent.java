import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class retrieveStudent {
    public static void retrieve(Scanner scan) {
        try {
            System.out.println("\n================ Retrieve Student Data ================");
            System.out.println("1 : Individual Student");
            System.out.println("2 : Retrieve all Students");
            System.out.print("Enter your choice :: ");
            int rChoice= scan.nextInt();

            Connection con=DBConnection.getConnection();
            Statement stmt= con.createStatement();
            switch (rChoice) {
                case 1 -> indiStd(con, stmt, scan);
                case 2 -> allStd(con, stmt);
                default -> System.out.println("Enter valid input.....");
            }

        } catch (Exception e) {
            System.out.println("\nRetrieve Error :: "+e.getMessage());
        }
    }

    private static void allStd(Connection con, Statement stmt) {
        try {
            String allStdQuery="SELECT * FROM students";
            ResultSet alRs= stmt.executeQuery(allStdQuery);

            // ==== Table Header ====
            System.out.println("\n================ All Student Records ================");
            System.out.printf("%-12s %-20s %-12s %-25s %-20s %-12s %-15s %-10s\n",
                    "Enroll No","Name","D.O.B","Email","Address","Phone","Dept","Adm.Year");

            System.out.println("----------------------------------------------------------------------------------------------------------------");

            // ==== Table Rows ====
            while (alRs.next()) {
                System.out.printf("%-12d %-20s %-12s %-25s %-20s %-12d %-15s %-10d\n",
                        alRs.getLong("senroll"),
                        alRs.getString("sname"),
                        alRs.getString("sdob"),
                        alRs.getString("semail"),
                        alRs.getString("saddress"),
                        alRs.getLong("sphone"),
                        alRs.getString("sdept"),
                        alRs.getInt("adyear")
                );
            }

        } catch (Exception e) {
            System.out.println("Error :: "+e.getMessage());
        }
    }

    private static void indiStd(Connection con, Statement stmt, Scanner scan) {
        try {
            System.out.print("Enter Student Enroll. no :: ");
            long rEnroll= scan.nextLong();

            // fixed numeric query (removed quotes)
            String rtrIndQuery="SELECT * FROM students WHERE senroll=" + rEnroll;

            ResultSet rs= stmt.executeQuery(rtrIndQuery);

            if(rs.next()) {
                System.out.println("\n================ Student Details ================");
                System.out.println("Enrollment No :: " + rs.getLong("senroll"));
                System.out.println("Name          :: " + rs.getString("sname"));
                System.out.println("D.O.B         :: " + rs.getString("sdob"));
                System.out.println("Email         :: " + rs.getString("semail"));
                System.out.println("Address       :: " + rs.getString("saddress"));
                System.out.println("Phone no      :: " + rs.getLong("sphone"));
                System.out.println("Department    :: " + rs.getString("sdept"));
                System.out.println("Admission Yr  :: " + rs.getInt("adyear"));
            } else {
                System.out.print("\nStudent not found or Not Exists.");
            }

        } catch (Exception e) {
            System.out.println("Error :: "+e.getMessage());
        }
    }
}
