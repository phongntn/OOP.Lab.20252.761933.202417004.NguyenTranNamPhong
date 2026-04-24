import java.util.Arrays;

public class Cart {
    int qtyOrdered;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("A disc has been added.");
    }

//    void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//        for (DigitalVideoDisc disc : dvdList) {
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

    float totalCost() {
        float res = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            res += itemsOrdered[i].getCost();
        }
        return res;
    }

    void removeDigitalVideoDisc(DigitalVideoDisc disc) {
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

    @Override
    public String toString() {
        return "Cart{" +
                "qtyOrdered=" + qtyOrdered +
                ", itemsOrdered=" + Arrays.toString(itemsOrdered) +
                '}';
    }
}
