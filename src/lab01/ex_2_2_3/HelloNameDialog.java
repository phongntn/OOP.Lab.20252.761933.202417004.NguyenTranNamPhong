package lab01.ex_2_2_3;

import javax.swing.*;

public class HelloNameDialog {
    public  static void main(String args[]) {
        String result;
        result = JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, "Hi " + result + "!");
        System.exit(0);
    }
}
