import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class User{
    private String userId;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private boolean seller;
    private Cart cart;
    static int d=0;
    public  ArrayList<Product> productList;
    // Constructor
    public User(String userId, String username, String email, String password, String address, String phone, boolean seller){
        this.userId= userId;
        this.username=username;
        boolean isValid= false;
        // Check if email is valid or not
        if(checkMailAddress(email)) {
            this.email = email;
                isValid=true;
        }
        else {
            System.out.println("Invalid email address  ");
            System.exit(-1);
        }
        this.password=password;
        this.address=address;
        this.phone=phone;
        this.seller=seller;

        this.cart = new Cart(this.userId,this.userId);
    }
    public boolean checkMailAddress(String email){
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            return email.matches(regex);
    }
    // Pay cart
    public void payCart(){
        this.cart.getProductList().clear();
    }
    // Getters

    public Cart getCart() {
        return cart;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    // Setters
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        if(checkMailAddress(email))
            this.email = email;
        else {
            System.out.println("Invalid email");
            System.exit(-1);
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    // User object description

    public boolean isSeller() {
        return seller;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }

/*
 * Seller Methods
 *
 * */
    /**
     * Add product
     */
    public void addProduct() throws SQLException {
        if (!this.seller){
            System.out.println("You need to have seller role first change your role to seller to add new products");
            System.exit(-1);
        }
        Scanner kb = new Scanner(System.in);
        System.out.println ("product name");
        String name = kb.nextLine();

        System.out.println ("product description");
        String description = kb.nextLine();

        System.out.println ("product Price");
        double price = Double.parseDouble(kb.nextLine());

        System.out.println ("add an image link to your product");
        String photo = kb.nextLine();

        d++;
        String id=Integer.toString(d);
        Product p = new Product(id,name,description,price,photo,this.userId);
        ProductManagementQueries.addProduct(p);
        }
        /*
        * Delete a product
        * */
        public void deleteProduct() throws SQLException {
            if (!this.seller){
                System.out.println("You need to have seller role first change your role to seller to remove a products");
                System.exit(-1);
            }
            Scanner id = new Scanner(System.in);
            System.out.println ("enter product id that you want to remove");
            String idProduct = id.nextLine();
            Product pVerify = ProductManagementQueries.findProduct(idProduct);
            if(pVerify.getSellerID().equals(this.userId)){
                ProductManagementQueries.deleteProduct(idProduct);
            }else {
                System.out.println("You are not allowed");
                System.exit(-1);
            }
        }
        /*
        * update  My product*/
    public void updateProduct() throws SQLException{
        if (!this.seller){
            System.out.println("You need to have seller role first change your role to seller to update a products");
            System.exit(-1);
        }
        Scanner id = new Scanner(System.in);
        System.out.println ("enter product id that you want to update");
        String idProduct = id.nextLine();
        Product pVerify = ProductManagementQueries.findProduct(idProduct);
        if(pVerify.getSellerID().equals(this.userId)){
            //
            Scanner kb = new Scanner(System.in);
            System.out.println ("product name");
            String name = kb.nextLine();

            System.out.println ("product description");
            String description = kb.nextLine();

            System.out.println ("product Price");
            double price = Double.parseDouble(kb.nextLine());

            System.out.println ("add an image link to your product");
            String photo = kb.nextLine();
            pVerify.setName(name);
            pVerify.setDescription(description);
            pVerify.setPhotoId(photo);
            pVerify.setPrice(price);
            ProductManagementQueries.updateProduct(pVerify);
        }else {
            System.out.println("You are not allowed");
            System.exit(-1);
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", seller=" + seller +
                ", cart=" + cart +
                '}';
    }
}