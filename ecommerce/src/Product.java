public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Img photo;
    public Product(String id, String name, String description, Double price, Img photo){
        this.id = id;
        this.name = name;
        this.description= description;
        this.price = price;
        this.photo = photo;
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

    public Img getPhoto() {
        return photo;
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

    public void setPhoto(Img photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +"\n"+
                ", name='" + name + '\'' +"\n"+
                ", description='" + description + '\'' +"\n"+
                ", price=" + price +" Dinars"+"\n"+
                ", photo=" + photo +"\n"+
                '}';
    }
}
