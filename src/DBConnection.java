import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    String url="jdbc:mysql://localhost:3306/test";
    String user="root";
    String pswd="";
    void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url, user, pswd);
        } catch (Exception e) {
            System.out.println("Connection Error :: "+e.getMessage());
        }
    }
}
