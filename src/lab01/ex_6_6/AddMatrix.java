package lab01.ex_6_6;

import java.util.Scanner;

public class AddMatrix {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter matrix size: ");
        int n = kb.nextInt();
        int[][] mtr1 = new int[n][n];
        int[][] mtr2 = new int[n][n];
        int[][] mtrRes = new int[n][n];

        System.out.println("Enter matrix 1: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mtr1[i][j] = kb.nextInt();
            }
        }

        System.out.println("Enter matrix 2: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mtr2[i][j] = kb.nextInt();
                mtrRes[i][j] = mtr1[i][j] + mtr2[i][j];
            }
        }
        System.out.println("Result: \n");
        for (int i = 0; i < mtrRes.length; i++) {
            for (int j = 0; j < mtrRes[i].length; j++) {
                System.out.print(mtrRes[i][j] + " ");
            }
            System.out.println();
        }
    }
}
