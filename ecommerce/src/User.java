public class User{
    private String userId;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Cart cart;
    // Constructor
    public User(String userId, String username, String email, String password, String address, String phone){
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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", cart=" + cart +
                '}';
    }
}