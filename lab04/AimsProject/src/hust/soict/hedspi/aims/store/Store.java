package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    public static int NUMBER_OF_ITEMS = 0;

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media item){
        if (itemsInStore.contains(item)) {
            System.out.println("Item already exists!");
            return;
        }
        if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
            System.out.println("Too many items!");
            return;
        }
        itemsInStore.add(item);
        NUMBER_OF_ITEMS++;
        item.setId(NUMBER_OF_ITEMS);
    }

    public void removeMedia(Media item){
        if (!itemsInStore.contains(item)) {
            System.out.println("Item does not exists!");
            return;
        }
        itemsInStore.remove(item);
    }

    public Media searchById(int id) {

        for (Media item : itemsInStore) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public Media searchByTitle(String title) {

        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }

        return null;
    }


    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Number of items in store: " + itemsInStore.size());

        for (Media item : itemsInStore) {
            System.out.println(item.getId() + ". " +
                    item.getTitle() + ": " + item.getCost());
        }

        System.out.println("***************************************************");
    }
}