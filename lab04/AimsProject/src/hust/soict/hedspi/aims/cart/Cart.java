package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_COST_TITLE;
import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_TITLE_COST;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("Too many items!");
            return;
        }

        itemsOrdered.add(media);
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public float totalCost() {
        float cost = 0;
        for (Media item : itemsOrdered) {
            cost += item.getCost();
        }
        return cost;
    }

    public Media searchById(int id) {

        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public Media searchByTitle(String title) {

        for (Media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }

        return null;
    }

    public void clearCart() {
        itemsOrdered.clear();
    }

    public void sortByTitle() {
        itemsOrdered.sort(COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        itemsOrdered.sort(COMPARE_BY_COST_TITLE);
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (Media item : itemsOrdered) {
            System.out.println(item.getId() + ". " +
                    item.getTitle() + ": " + item.getCost());
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

}
