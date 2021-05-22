import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductManagementQueries extends DBConnector {
    public static User user;
    public static ArrayList<Product> productList;
    public static Cart cart;
    public static Product product;

    //public static ArrayList<Product> productsList;
    public ProductManagementQueries() throws SQLException, ClassNotFoundException {
        super();
    }
    /*
    * Find All Products
    * @Return type ArrayList<Product>*/
    public static ArrayList<Product> findAllProducts() throws SQLException {
        PreparedStatement statement = C.prepareStatement("select * from product");
        productList = new ArrayList();
        try {
            res = statement.executeQuery();
            while (res.next()) productList.add(new Product(res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getDouble(4),
                    res.getString(5)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    /*
     * Get Product by ID
     * @Return type Product
     * */
    public static Product findProduct(String id) throws SQLException {
        Product product = null;
        PreparedStatement statement = C.prepareStatement("select * from product where id=?");
        statement.setString(1,id);
        System.out.println(statement);
        //product = new Product();
        try {
            res = statement.executeQuery();
            while (res.next()){
                product = new Product(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getString(5));
                System.out.println(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return product;
    }
    /*
    * Create/ ADD Product
    * */
    public static void addProduct(Product p) throws SQLException{
       PreparedStatement statement = C.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?)");
       statement.setString(1,p.getId());
       statement.setString(2,p.getName());
       statement.setString(3,p.getDescription());
       statement.setDouble(4,p.getPrice());
       statement.setString(5,p.getPhoto());
       try {
           int res = statement.executeUpdate();
           System.out.println("Product Added");
       }catch (SQLException e){
           e.printStackTrace();
       }
    }
    /*
     * Update a Product
     * */
    public static void updateProduct(Product p)throws SQLException{
        PreparedStatement statement = C.prepareStatement(
                "UPDATE product set name=?, description=?, price=?, photoId=? WHERE id=?");
        statement.setString(1,p.getName());
        statement.setString(2,p.getDescription());
        statement.setDouble(3,p.getPrice());
        statement.setString(4,p.getPhoto());
        statement.setString(5,p.getId());

        System.out.println(statement);
        try {
            int res = statement.executeUpdate();
            System.out.println("Product updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*
    * Delete a Product
    * */
    public static void deleteProduct(String id)throws SQLException{
        //roduct p = null;
        PreparedStatement statement = C.prepareStatement("DELETE from product WHERE id=?");
        statement.setString(1,id);
        try {
            int res = statement.executeUpdate();
            System.out.println("Product deleted");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}