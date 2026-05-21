package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addMedia(dvd3);


        // Test printCart method
        cart.printCart();

        // Test search by ID
        System.out.println("\nSearch by ID:");
        cart.searchById(dvd1.getId());
        cart.searchById(999);

        // Test search by title
        System.out.println("\nSearch by title:");
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Unknown DVD");

    }
}