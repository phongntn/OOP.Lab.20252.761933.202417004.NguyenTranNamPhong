package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.Arrays;

public class Cart {
    int qtyOrdered;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("A disc has been added.");
    }

//    void addDigitalVideoDisc(hust.soict.dsai.aims.disc.DigitalVideoDisc[] dvdList) {
//        for (hust.soict.dsai.aims.disc.DigitalVideoDisc disc : dvdList) {
//            addDigitalVideoDisc(disc);
//        }
//    }

    void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public float totalCost() {
        float res = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            res += itemsOrdered[i].getCost();
        }
        return res;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Disc not found.");
            return;
        }
        DigitalVideoDisc[] tmp = new DigitalVideoDisc[qtyOrdered - 1];
        System.arraycopy(itemsOrdered, 0, tmp, 0, index);
        System.arraycopy(itemsOrdered, index + 1, tmp, index, qtyOrdered - index - 1);
        qtyOrdered--;
        System.arraycopy(tmp, 0, itemsOrdered, 0, qtyOrdered);
        System.out.println("Disc has been removed.");
    }

    public void searchById(int id) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Search result:");
                System.out.println(itemsOrdered[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;

        System.out.println("Search result:");

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println(itemsOrdered[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i]);
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    @Override
    public String toString() {
        return "hust.soict.dsai.aims.cart.Cart{" +
                "qtyOrdered=" + qtyOrdered +
                ", itemsOrdered=" + Arrays.toString(itemsOrdered) +
                '}';
    }
}
