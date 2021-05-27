import java.sql.SQLException;
import java.util.Scanner;

public class LoginRegister {

        public static void Register() throws SQLException {

            Scanner kb = new Scanner(System.in);
            System.out.println ("Enter a userid");
            String userid = kb.nextLine(  );

            System.out.println ("Enter a Password");
            String pass1 = kb.nextLine(  );

            Scanner kb3 = new Scanner( System.in);
            System.out.println ("Enter your e-mail address");
            String email = kb.nextLine(  );

            Scanner kb4 = new Scanner( System.in);
            System.out.println ("Enter your name");
            String username = kb.nextLine(  );

            Scanner kb5 = new Scanner( System.in);
            System.out.println ("Enter your address");
            String address = kb.nextLine(  );

            Scanner kb9sdf = new Scanner( System.in);
            System.out.println ("Enter your phone number");
            String phone = kb.nextLine(  );

            Scanner role = new Scanner( System.in);
            System.out.println ("If you want to have a seller role enter true");
            boolean seller = role.nextBoolean( );

            User user1 = new User(userid,username,email,pass1,address,phone,seller);
            UserManagementQueries.addUser(user1);

    }
    public static User login(String email, String password) throws SQLException{
            User user= UserManagementQueries.getUserByEmail(email);
            if(user==null){
                System.out.println("Invalid user");
            }else{
                if(user.getPassword().equals(password)){
                    return user;
                }else System.out.println("Incorrect password");
            }
            return user;
    }
    public static User logOut(User user){
            user=null;
            return user;

    }



}
