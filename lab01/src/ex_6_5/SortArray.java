package ex_6_5;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = kb.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element number " + i + ": ");
            a[i] = kb.nextInt();
            sum += a[i];
        }
        Arrays.sort(a);
        System.out.println("The sorted array is: " + Arrays.toString(a));
        System.out.println("The sum of the array is: " + sum);
        System.out.println("The average of the array is: " + (double)sum / n);
    }
}
