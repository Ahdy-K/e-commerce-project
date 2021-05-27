public class Product {
    private  String id;
    private String name;
    private String description;
    private Double price;
    // TODO: Change Img photo with photo id and then the user select a photo
    private String photoId;
    private String sellerID;
    public Product(String id, String name, String description, Double price, String photo, String sellerID){
        //int d = Integer.parseInt(id)+1;
        //id=Integer.toString(d);
        this.id=id;
        this.name = name;
        this.description= description;
        this.price = price;
        this.photoId = photo;
        this.sellerID=sellerID;
    }

    /*public Product(String name, String description, double price, String photo, String userId) {
        int d = Integer.parseInt(id)+1;
        id=Integer.toString(d);
        this.name = name;
        this.description= description;
        this.price = price;
        this.photoId = photo;
    }*/

    // Getters and Setters.
    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getPhoto() {
        return photoId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", photoId='" + photoId + '\'' +
                ", sellerID='" + sellerID + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPhoto(String photo) {
        this.photoId = photo;
    }

    public String getPhotoId() {
        return photoId;
    }

    public String getSellerID() {
        return sellerID;
    }

}
