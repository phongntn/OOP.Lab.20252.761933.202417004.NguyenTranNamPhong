package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Sample data
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                124,
                24.95f
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin",
                "Animation",
                "John Musker",
                90,
                18.99f
        );

        Book book1 = new Book(
                "Java Programming",
                "Education",
                15.50f

        );

        CompactDisc cd1 = new CompactDisc(
                "Greatest Hits",
                "Music",
                12.99f,
                "Queen"
        );

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(cd1);

        int choice;

        do {
            showMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    viewStore(store, cart);
                    break;

                case 2:
                    updateStore(store);
                    break;

                case 3:
                    viewCart(cart);
                    break;

                case 0:
                    System.out.println("Exit AIMS. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }
    public static void showMenu() {

        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

    }
    public static void storeMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

    }

    private static void viewStore(Store store, Cart cart) {
        int choice;

        do {
            store.printStore();
            storeMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    seeMediaDetails(store, cart);
                    break;

                case 2:
                    addMediaFromStoreToCart(store, cart);
                    break;

                case 3:
                    playMediaFromStore(store);
                    break;

                case 4:
                    viewCart(cart);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private static void seeMediaDetails(Store store, Cart cart) {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found in store.");
            return;
        }

        System.out.println("Media details: ");
        System.out.println(media);

        int choice;

        do {
            mediaDetailsMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                    break;

                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private static void addMediaFromStoreToCart(Store store, Cart cart) {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found in store.");
            return;
        }

        cart.addMedia(media);
        System.out.println("Media added to cart.");
    }

    private static void playMediaFromStore(Store store) {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found in store.");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void updateStore(Store store) {
        System.out.println("Update Store:");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Choose: ");

        int choice = readInt();

        switch (choice) {
            case 1:
                addMediaToStore(store);
                break;

            case 2:
                removeMediaFromStore(store);
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addMediaToStore(Store store) {
        System.out.println("Choose media type:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.print("Choose: ");

        int type = readInt();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter cost: ");
        float cost = readFloat();

        Media media = null;

        switch (type) {
            case 1:
                media = new Book(title, category, cost);
                break;

            case 2:
                System.out.print("Enter director: ");
                String dvdDirector = scanner.nextLine();

                System.out.print("Enter length: ");
                int dvdLength = readInt();

                media = new DigitalVideoDisc(title, category, dvdDirector, dvdLength, cost);
                break;

            case 3:
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();

                media = new CompactDisc(title, category, cost, artist);
                break;

            default:
                System.out.println("Invalid media type.");
                return;
        }

        store.addMedia(media);
        System.out.println("Media added to store successfully.");
    }

    private static void removeMediaFromStore(Store store) {
        System.out.print("Enter title of media to remove: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found in store.");
            return;
        }

        store.removeMedia(media);
        System.out.println("Media removed from store.");
    }

    private static void viewCart(Cart cart) {
        int choice;

        do {
            cart.printCart();
            cartMenu();

            choice = readInt();

            switch (choice) {
                case 1:
                    filterCart(cart);
                    break;

                case 2:
                    sortCart(cart);
                    break;

                case 3:
                    removeMediaFromCart(cart);
                    break;

                case 4:
                    playMediaFromCart(cart);
                    break;

                case 5:
                    placeOrder(cart);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private static void filterCart(Cart cart) {
        System.out.println("Filter medias in cart:");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.print("Choose: ");

        int choice = readInt();

        switch (choice) {
            case 1:
                System.out.print("Enter id: ");
                int id = readInt();
                if (cart.searchById(id) == null) {
                    System.out.println("No item found.");
                    break;
                }
                System.out.println(cart.searchById(id));
                break;

            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                if (cart.searchByTitle(title) == null) {
                    System.out.println("No item found.");
                    break;
                }
                System.out.println(cart.searchByTitle(title));
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void sortCart(Cart cart) {
        System.out.println("Sort medias in cart:");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.print("Choose: ");

        int choice = readInt();

        switch (choice) {
            case 1:
                cart.sortByTitle();
                System.out.println("Cart sorted by title.");
                cart.printCart();
                break;

            case 2:
                cart.sortByCost();
                System.out.println("Cart sorted by cost.");
                cart.printCart();
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void removeMediaFromCart(Cart cart) {
        System.out.print("Enter title of media to remove from cart: ");
        String title = scanner.nextLine();

        Media media = cart.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found in cart.");
            return;
        }

        cart.removeMedia(media);
        System.out.println("Media removed from cart.");
    }

    private static void playMediaFromCart(Cart cart) {
        System.out.print("Enter title of media to play: ");
        String title = scanner.nextLine();

        Media media = cart.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found in cart.");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void placeOrder(Cart cart) {
        System.out.println("An order has been created successfully.");
        cart.clearCart();
        System.out.println("Current cart is now empty.");
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.nextLine();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static float readFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.nextLine();
        }

        float value = scanner.nextFloat();
        scanner.nextLine();
        return value;
    }
}
