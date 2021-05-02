import java.util.ArrayList;

// this class contains an arrats & can y of producmanipulate them -> price(), addProduct, removeProduct, etc
public class Cart {
    private String id;
    private String clientID;
    private double price;
    private ArrayList<Product> productList = new ArrayList<Product>();
    public  Cart(String id, String clientID){
        this.id = id;
        this.clientID= clientID;
        this.price=0;
        //this.productList=null;
    }
    // add a product to the shopping cart
    public void addProduct(Product product){
        productList.add(product);
        this.price+= product.getPrice();
    }
    // Remove a product from the shopping cart
    public void removeProduct(String idProd2Remove){
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==idProd2Remove){
                this.price= this.price - productList.get(i).getPrice();
                productList.remove(i);
            }
        }
    }
    // Getters
    public String getId() {
        return id;
    }

    public String getClientID() {
        return clientID;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    // Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    // ToString
    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", clientID='" + clientID + '\'' +"\n"+
                ", price=" + price +" Dinars \n"+
                ", productList=" + productList +"\n"+
                '}';
    }
}
