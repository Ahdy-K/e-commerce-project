import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Connect to Database
        DBConnector test = new DBConnector();
        // testing some objects
        Product p1= new Product( "1","PC","Ryzen 5 GTX 1650ti",2770.0, null);
        Product p2 = new Product( "2","PS4","Sony PS4",1200.0, null);
        Product p3 = new Product( "3","PS5","Sony PS5",2100.0, null);
        /*Cart c1 = new Cart("1","1");
        c1.addProduct(p1);
        c1.addProduct(p2);
        c1.addProduct(p1);
        c1.addProduct(p1);
        System.out.println(c1);
        User user1 = new User("1","ahdy","ahdy@gmail.com","1123","a","2360");
        User user2 = new User("2","user 2","azerty@mail.com","123","adr","2360");
        user1.getCart().addProduct(p1);
        //user1.getCart().addProduct(p2);
        System.out.println(user1);
        user1.setEmail("ah");
        System.out.println(user1);*/

        //ArrayList<User>userList=UserManagementQueries.findAllUsers();
        /*for (User user:UserManagementQueries.findAllUsers()){
            System.out.println(user);
        }*/
        // INSERT INTO user VALUES("28","test28","test28@gmail.com","12020","address","12356")
        /*User user1 = new User("10","test1","test1@gmail.com","testpass","somewhere in the world","123123");
        //serManagementQueries.addUser(user1);
        User UserToFind=UserManagementQueries.getUserById("1");
        System.out.println(UserToFind);
        UserToFind.setAddress("Tn");
        UserManagementQueries.updateUser(UserToFind);
        UserManagementQueries.deleteUser("2");*/
        // test produit db
        ArrayList<Product> produits =  ProductManagementQueries.findAllProducts();
        for (Product produit:ProductManagementQueries.findAllProducts()){
            System.out.println(produit);
        }


        Product pupdate= new Product("1","PC ASUS A15 TUF GAMMING","CPU Ryzen 5, GPU GTX 1650Ti, RAM 8Go",3000.0,"https://www.google.fr/url?sa=i&url=https%3A%2F%2Fwww.laptopmag.com%2Freviews%2Fasus-tuf-gaming-a15-hands-on-review-amd-meets-nvidia&psig=AOvVaw0pc9RYkyY8xDWF6vxR7mQY&ust=1621774364251000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCkpcWq3fACFQAAAAAdAAAAABAD");
        ProductManagementQueries.updateProduct(pupdate);
        Product pa=ProductManagementQueries.findProduct("1");
        //System.out.println(pa);
        Product newProduct= new Product("3","Samsung S10","CPU Snapdragon,, RAM 6Go",1200.0,"https://www.google.fr/url?sa=i&url=https%3A%2F%2Fwww.laptopmag.com%2Freviews%2Fasus-tuf-gaming-a15-hands-on-review-amd-meets-nvidia&psig=AOvVaw0pc9RYkyY8xDWF6vxR7mQY&ust=1621774364251000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCkpcWq3fACFQAAAAAdAAAAABAD");

        ProductManagementQueries.addProduct(newProduct);
        ProductManagementQueries.deleteProduct("3");
    }


}
