import java.sql.*;
import java.util.Scanner;

public class addStudent {
    public static void add() {
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("\n====================== Enter Student Details ======================");
            System.out.print("\nName :: ");
            String name = scan.nextLine();

            System.out.print("D.O.B (DD/MM/YYYY) :: ");
            String date = scan.nextLine();

            System.out.print("Email :: ");
            String email = scan.nextLine();

            System.out.print("Address :: ");
            String address = scan.nextLine();

            System.out.print("Phone no. :: ");
            long phone = scan.nextLong();
            scan.nextLine(); // consume newline

            System.out.print("Department :: ");
            String dept = scan.nextLine();

            System.out.print("Admission year :: ");
            int adYear = scan.nextInt();


            String addQuery = "INSERT INTO students (sname, sdob, semail, saddress, sphone, sdept, adyear) " +
                    "VALUES ('" + name + "', '" + date + "', '" + email + "', '" + address + "', " + phone + ", '" + dept + "', " + adYear + ")";

            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            int ur = stmt.executeUpdate(addQuery);

            if (ur > 0) {
                System.out.println(name + " Added successfully.");


                String adEnroll = "SELECT senroll FROM students WHERE sphone = " + phone + " AND semail = '" + email + "'";
                ResultSet rs = stmt.executeQuery(adEnroll);

                while (rs.next()) {
                    long enroll = rs.getLong("senroll");
                    System.out.println("\nHere is your Enrollment number :: " + enroll);
                }
            } else {
                System.out.println(name + " not added.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
