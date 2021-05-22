public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    // TODO: Change Img photo with photo id and then the user select a photo
    private String photoId;
    public Product(String id, String name, String description, Double price, String photo){
        this.id = id;
        this.name = name;
        this.description= description;
        this.price = price;
        this.photoId = photo;
    }
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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +"\n"+
                ", name='" + name + '\'' +"\n"+
                ", description='" + description + '\'' +"\n"+
                ", price=" + price +" Dinars"+"\n"+
                ", photo=" + photoId +"\n"+
                '}';
    }
}
