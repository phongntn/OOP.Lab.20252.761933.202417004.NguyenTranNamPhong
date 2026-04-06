package lab01.ex_6_4;

import java.util.Scanner;

public class DayNumberCount {
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter year: ");
        int year = kb.nextInt();
        kb.nextLine();
        if (year < 1000 || year > 9999) {
            System.out.println("Invalid year");
            return;
        }
        System.out.println("Enter month: ");
        String strMonth = kb.nextLine().trim();

        int month = switch (strMonth) {
            case "1", "Jan", "Jan.", "January" -> 1;
            case "2", "Feb", "Feb.", "February" -> 2;
            case "3", "Mar", "Mar.", "March" -> 3;
            case "4", "Apr", "Apr.", "April" -> 4;
            case "5", "May", "May." -> 5;
            case "6", "Jun", "Jun.", "June" -> 6;
            case "7", "Jul", "Jul.", "July" -> 7;
            case "8", "Aug", "Aug.", "August" -> 8;
            case "9", "Sep", "Sep.", "September" -> 9;
            case "10", "Oct", "Oct.", "October" -> 10;
            case "11", "Nov", "Nov.", "November" -> 11;
            case "12", "Dec", "Dec.", "December" -> 12;
            default -> -1;
        };
        if (month == -1) {
            System.out.println("Invalid month");
            return;
        }
        int days;
        switch(month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    days = 29;
                }
                else {
                    days = 28;
                }
                break;
            default:
                days = -1;
        }
        System.out.println("Month " + month + "/" + year + " has " +
                days + " days");
    }
}
