package com.clouway.networkingandgui.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for the calculator
 * Created by Krasimir Dimitrov
 * Date: 11/22/11
 * Time: 2:41 PM
 */
public class Calculator extends JFrame {

    private JButton JButtons[];    //array from buttons for the digits 0-9 and . and =
    private JButton clearButton;
    private JButton backButton;
    private JButton operationButtons[];
    private JTextField calculationLine;
    String currentNumber = "";
    String previousNumber = "";
    Operation operation;
    private OperationHolder operationHolder;

    public Calculator(OperationHolder operationHolder) {
        this.operationHolder = operationHolder;

        calculationLine = new JTextField("");
        calculationLine.setEnabled(false);
        calculationLine.setDisabledTextColor(Color.blue);
        calculationLine.setBounds(0, 0, 276, 30);
        calculationLine.setHorizontalAlignment(JTextField.RIGHT);
        calculationLine.setVisible(true);
        add(calculationLine);

        JPanel digitsPanel = new JPanel(new GridLayout(4, 3, 2, 2));
        digitsPanel.setBackground(Color.getHSBColor(0, 0, 0));
        digitsPanel.setBounds(5, 35, 140, 216);
        add(digitsPanel);
        DigitsHandler handler = new DigitsHandler();
        JButtons = new JButton[20];
        String buttons = "7894561230.=";
        for (int i = 0; i < 12; i++) {
            JButtons[i] = new JButton(buttons.substring(i, i + 1));
            if (i < 9)
                JButtons[i].addActionListener(handler);
            digitsPanel.add(JButtons[i]);
        }

        ZeroHandler zeroHandler = new ZeroHandler();
        JButtons[9].addActionListener(zeroHandler);
        FloatingPointHandler floatingPointHandler = new FloatingPointHandler();
        JButtons[10].addActionListener(floatingPointHandler);
        EqualHandler equalHandler = new EqualHandler();
        JButtons[11].addActionListener(equalHandler);

        JPanel clearAndBackPanel = new JPanel(new GridLayout(2, 1, 2, 2));
        clearAndBackPanel.setBackground(Color.getHSBColor(0, 0, 0));
        clearAndBackPanel.setBounds(150, 35, 120, 106);
        add(clearAndBackPanel);

        clearButton = new JButton("✖");
        clearButton.setFont(new Font("Serif", Font.PLAIN, 24));
        clearAndBackPanel.add(clearButton);

        ClearHandler clearHandler = new ClearHandler();
        clearButton.addActionListener(clearHandler);

        backButton = new JButton("←");
        backButton.setFont(new Font("Serif", Font.PLAIN, 24));
        clearAndBackPanel.add(backButton);

        BackHandler backHandler = new BackHandler();
        backButton.addActionListener(backHandler);

        JPanel operationPanel = new JPanel(new GridLayout(2, 2, 2, 2));
        operationPanel.setBackground(Color.getHSBColor(0, 0, 0));
        operationPanel.setBounds(150, 143, 120, 106);
        add(operationPanel);
        String operationText = "*/+-";
        operationButtons = new JButton[4];
        OperationHandler operationHandler = new OperationHandler();
        for (int i = 0; i < 4; i++) {
            operationButtons[i] = new JButton(operationText.substring(i, i + 1));
            operationButtons[i].addActionListener(operationHandler);
            operationPanel.add(operationButtons[i]);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.getHSBColor(0, 0, 0));   //100, 200, 500 for the previous color
        setSize(290, 290);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Event handler for the 0
     */
    private class ZeroHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (!checkIfEmpty(currentNumber)) {
                currentNumber = currentNumber + event.getActionCommand();
            }
            calculationLine.setText(currentNumber);
        }
    }

    /**
     * Event handler for the .
     */
    private class FloatingPointHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (!currentNumber.contains(".")) {
                if (checkIfEmpty(currentNumber))
                    currentNumber = "0" + ".";
                else currentNumber = currentNumber + ".";
            }
            calculationLine.setText(currentNumber);
        }
    }

    /**
     * Event handler for the back button
     */
    private class BackHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (!checkIfEmpty(currentNumber)) {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                calculationLine.setText(currentNumber);
            }
        }
    }

    /**
     * Event handler for the clear all button
     */
    private class ClearHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            currentNumber = "";
            previousNumber = "";
            operation = null;
            calculationLine.setText(currentNumber);
        }
    }

    /**
     * Event Handler for =
     */
    private class EqualHandler implements ActionListener {
        double number1;
        double number2;

        public void actionPerformed(ActionEvent event) {
            if (!checkIfEmpty(currentNumber) && !checkIfEmpty(previousNumber) && operation != null) {
                number1 = Double.parseDouble(previousNumber);
                number2 = Double.parseDouble(currentNumber);
                currentNumber = Double.toString(operation.calculate(number1, number2));
                operation = null;
            }
            calculationLine.setText(currentNumber);
        }
    }

    /**
     * Event handler for the operations + - * /
     */
    private class OperationHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (!checkIfEmpty(currentNumber) && operation == null) {
                operation = operationHolder.useOperation(event.getActionCommand());
                previousNumber = currentNumber;
                currentNumber = "";
            }
        }
    }

    /**
     * Event handler for the digits 1 to 9
     */
    private class DigitsHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            currentNumber = currentNumber + event.getActionCommand();

            calculationLine.setText(currentNumber);
        }
    }

    /**
     * Check if a string is empty
     * @param string the string that we are going to check if it is empty
     * @return  true if the string is empty false if it is not
     */
    private boolean checkIfEmpty(String string){
        return string.equals("");
    }
}
