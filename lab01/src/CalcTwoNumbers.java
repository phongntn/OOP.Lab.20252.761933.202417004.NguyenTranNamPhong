import javax.swing.*;

public class CalcTwoNumbers {
    public  static void main(String args[]) {
        String strNum1, strNum2;
        String strSum = "Sum of two numbers: ";
        String strDiff = "Difference of two numbers: ";
        String strProduct =  "Product of two numbers: ";
        String strQuotient = "Quotient of two numbers: ";

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ",
                "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ",
                "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        double num1q = Double.parseDouble(strNum1);
        double num2q = Double.parseDouble(strNum2);

        strSum += String.valueOf(num1 + num2);
        strDiff += String.valueOf(num1 - num2);
        strProduct += String.valueOf(num1 * num2);


        JOptionPane.showMessageDialog(null, strSum,
                "Sum of two numbers",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strDiff,
                "Difference of two numbers",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strProduct,
                "Product of two numbers",
                JOptionPane.INFORMATION_MESSAGE);

        if (num2q != 0) {
            strQuotient += String.valueOf(num1q / num2q);
            JOptionPane.showMessageDialog(null, strQuotient,
                    "Quotient of two numbers",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        else {
            JOptionPane.showMessageDialog(null,
                    "No solution", "Quotient of two numbers",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        System.exit(0);
    }
}
