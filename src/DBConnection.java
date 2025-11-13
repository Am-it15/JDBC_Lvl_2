import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con=null;
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String pswd = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pswd);
        } catch (Exception e) {
            System.out.println("Connection Error :: " + e.getMessage());
        }
        return con;
    }

}
