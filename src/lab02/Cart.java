package lab02;

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
        System.out.println("The disc has been added.");
    }

    float totalCost() {
        float res = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            res += itemsOrdered[i].getCost();
        }
        return res;
    }

    void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if ()
    }
}
