import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManagementQueries extends DBConnector{
    public static User user;
    public static ArrayList<User> userList;
    public static Cart cart;
    public static Product product;
    //public static ArrayList<Product> productsList;
    public UserManagementQueries() throws SQLException, ClassNotFoundException{
        super();
    }
    /*
    * This Static method will return all users in the database
    * @Return Type User List
    * */
    public static ArrayList<User> findAllUsers()throws SQLException {
        PreparedStatement statement = C.prepareStatement("select * from user");
        userList= new ArrayList();
        try {
             res= statement.executeQuery();
            while (res.next()) userList.add(new User(res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),res.getString(5),
                    res.getString(6), res.getBoolean(7)));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }
    /*
    * This method will add a new user to the database
    * */
    // addComment(Product p, String com)
    public static void addUser(User u) throws SQLException{

        String req = "INSERT INTO user VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement = C.prepareStatement(req);
        statement.setString(1,u.getUserId());
        statement.setString(2,u.getUsername());
        statement.setString(3,u.getEmail());
        statement.setString(4,u.getPassword());
        statement.setString(5,u.getAddress());
        statement.setString(6,u.getPhone());
        statement.setBoolean(7,u.isSeller());
        System.out.println(statement);
                try{
                    int res= statement.executeUpdate();
                    System.out.println("user added .");
                }catch (SQLException e){
                    e.printStackTrace();
                }
    }
    /*
    * Get User by ID
    * @Return type User
    * */
    public static User getUserByEmail(String email)throws SQLException{
        User user = null;
        String req = "Select * from user where email=?";
        PreparedStatement statement=  C.prepareStatement(req);
        statement.setString(1,email);
        System.out.println(statement);
        try{
            res = statement.executeQuery();
            while (res.next())
                user = new User(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6), res.getBoolean(6));
            System.out.println(res);

        }catch (SQLException e){ e.printStackTrace();}
        return user;
    }
    /*
     * Update a user
     * */
    public static void updateUser(User u)throws SQLException{
        PreparedStatement statement = C.prepareStatement("UPDATE user set username=?, email=?, password=?, address=?, phone=? WHERE userId=?");
        statement.setString(1,u.getUsername());
        statement.setString(2,u.getEmail());
        statement.setString(3,u.getPassword());
        statement.setString(4,u.getAddress());
        statement.setString(5,u.getPhone());
        statement.setString(6,u.getUserId());
        System.out.println(statement);
        try {
            int res = statement.executeUpdate();
            System.out.println("User updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*
    * Deleting a user
    * */
    public static void deleteUser(String id)throws SQLException{
        PreparedStatement statement = C.prepareStatement("DELETE from user WHERE userId=?");
        statement.setString(1,id);
        try{
            int res = statement.executeUpdate();
            System.out.println("User deleted.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
