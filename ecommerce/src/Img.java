public class Img {
    private String link;
    private String alt;
    public Img(){}
    public Img(String link, String alt){
        this.link = link;
        this.alt = alt;
    }
// Getters and setters
    public String getAlt() {
        return alt;
    }
    public  void setAlt(String alt){
        this.alt = alt;
    }
    public String getLink(){
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
