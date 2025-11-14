import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class dltStudent {
    public static void delete(Scanner sc) {
        try {
            System.out.println("\nEnter Enrollment number :: ");
            long dltEnroll=sc.nextLong();
            sc.nextLine();

            String dltQuery="DELETE FROM students WHERE senroll="+dltEnroll;

            Connection con=DBConnection.getConnection();
            Statement dltSmt= con.createStatement();
            int dltRow=dltSmt.executeUpdate(dltQuery);

            if(dltRow>0) {
                System.out.println(dltEnroll+" Deleted successfully");
            } else {
                System.out.println(dltEnroll+" not deleted.....");
            }
        } catch (Exception e) {
            System.out.println("Error :: "+e.getMessage());
        }
    }
}
