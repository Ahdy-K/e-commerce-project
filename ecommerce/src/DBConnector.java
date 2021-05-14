import java.sql.*;

public class DBConnector {
    public static Connection C;
    public static Statement stmt;
    static ResultSet res;

    public DBConnector() throws SQLException, ClassNotFoundException{
        try {
            // Connection driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // establish connection
            C=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","");
            stmt= C.createStatement();
            System.out.println("==> Connection established");
        }catch(Exception e){
            System.out.println("Error : can't connect to database");
            e.printStackTrace();
        }
    }
}
