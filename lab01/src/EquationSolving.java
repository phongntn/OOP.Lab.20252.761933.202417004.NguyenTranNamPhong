import javax.swing.*;

import static java.lang.Math.sqrt;

public class EquationSolving {
    public  static void main(String args[]) {
        String equation;
        equation = JOptionPane.showInputDialog(null,
                "Pick a number from 1 to 3:" +
                        "\n 1. First-degree equation with one variable." +
                        "\n 2. First-degree equation with two variable." +
                        "\n 3. Second-degree equation with one variable.",
                "Choose equation",
                JOptionPane.INFORMATION_MESSAGE);

        if (equation.equals("1")) {
            String strA;
            String strB;
            String strC;

            strA = JOptionPane.showInputDialog(null,
                    "Enter a: ");
            strB = JOptionPane.showInputDialog(null,
                    "Enter b: ");
            strC = JOptionPane.showInputDialog(null,
                    "Enter c: ");

            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            double c = Double.parseDouble(strC);

            if (a == 0) {
                if (b!=c) {
                    JOptionPane.showMessageDialog(null,
                            "No solution");
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "The equation is infinite");
                }
            }
            else {
                String res = String.valueOf((c-b)/a);
                JOptionPane.showMessageDialog(null,
                        "The result is: " + res);
            }
        }

        else if (equation.equals("2")) {
            double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
            double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
            double b1  = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));

            double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
            double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
            double b2  = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));

            double D  = a11 * a22 - a21 * a12;
            double Dx = b1 * a22 - b2 * a12;
            double Dy = a11 * b2 - a21 * b1;

            String result;

            if (D != 0) {
                double x = Dx / D;
                double y = Dy / D;
                result = "Unique solution:\n x = " + x + "\n y = " + y;
            } else {
                if (Dx == 0 && Dy == 0) {
                    result = "Infinite solutions";
                } else {
                    result = "No solution";
                }
            }
            JOptionPane.showMessageDialog(null, result);
        }
        else if (equation.equals("3")) {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));
            double d = Double.parseDouble(JOptionPane.showInputDialog("Enter d:"));

            double delta = b*b - 4*a*(c-d);

            String result;

            if (a == 0 && b == 0 &&  c != d) {
                result = "No solution";
            }
            else if (delta < 0) {
                result = "No solution";
            }

            else if (delta == 0) {
                result = "Unique solution: " + String.valueOf(-b/2*a);
            }
            else {
                result = "Two solutions:\n" +
                        "x1 = " + String.valueOf((-b + sqrt(delta))/2*a) +
                "\n x2 = " + String.valueOf((-b - sqrt(delta))/2*a);
            }
            JOptionPane.showMessageDialog(null, result);
        }

        System.exit(0);
    }
}
