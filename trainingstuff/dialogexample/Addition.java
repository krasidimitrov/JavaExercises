package dialogexample;

import javax.swing.*;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/22/11
 * Time: 4:22 PM
 */
public class Addition {
    public static void main(String[] args) {

        //obtain user input from JOptionPane input dialogs
        String firstNumber = JOptionPane.showInputDialog("Enter first Integer");
        String secondNumber = JOptionPane.showInputDialog("Enter second Integer");

        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondNumber);

        int sum = number1+number2;

        JOptionPane.showMessageDialog(null, "The sum is "+sum, "Sum of two integers", JOptionPane.INFORMATION_MESSAGE);
    }
}
