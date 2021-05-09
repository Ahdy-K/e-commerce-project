public class Main {
    public static void main(String[] args){
        Product p1= new Product( "1","PC","Ryzen 5 GTX 1650ti",2770.0, null);
        Product p2 = new Product( "2","PS4","Sony PS4",1200.0, null);
        Product p3 = new Product( "3","PS5","Sony PS5",2100.0, null);
        /*Cart c1 = new Cart("1","1");
        c1.addProduct(p1);
        c1.addProduct(p2);
        c1.addProduct(p1);
        c1.addProduct(p1);
        System.out.println(c1);*/
        User user1 = new User("1","ahdy","ahdy@gmail.com","1123","a","2360");
        User user2 = new User("2","user 2","azerty@mail.com","123","adr","2360");
        user1.getCart().addProduct(p1);
        //user1.getCart().addProduct(p2);
        System.out.println(user1);
        user1.setEmail("ah");
        System.out.println(user1);
    }
}
