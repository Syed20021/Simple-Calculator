// Syed Hassnat Ali
// Student ID: 100835471
// Professor: Mohammad Shamas
// Date: 2023-04-19
// Description: This program asks the user for two 
// inputs than the user can either multipy, subtract, add, or divide. 

package assignment5;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;


public class assignment5 extends JFrame implements ActionListener {
	public static void main(String[] args) {
	    new assignment5();
	}

	private static final long serialVersionUID = 1L;
	

    private JLabel labelNum1, labelNum2, labelResult;
    private JTextField textFieldNum1, textFieldNum2;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    
    public assignment5() {
        setTitle("Basic Calculator App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        
        // Initialize UI elements
        labelNum1 = new JLabel("Enter first number:");
        labelNum1.setBounds(20, 20, 150, 20);
        add(labelNum1);
        
        textFieldNum1 = new JTextField();
        textFieldNum1.setBounds(180, 20, 150, 20);
        add(textFieldNum1);
        
        labelNum2 = new JLabel("Enter second number:");
        labelNum2.setBounds(20, 60, 150, 20);
        add(labelNum2);
        
        textFieldNum2 = new JTextField();
        textFieldNum2.setBounds(180, 60, 150, 20);
        add(textFieldNum2);
        
        addButton = new JButton("+");
        addButton.setBounds(20, 100, 70, 40);
        addButton.addActionListener(this);
        add(addButton);
        
        subtractButton = new JButton("-");
        subtractButton.setBounds(100, 100, 70, 40);
        subtractButton.addActionListener(this);
        add(subtractButton);
        
        multiplyButton = new JButton("*");
        multiplyButton.setBounds(180, 100, 70, 40);
        multiplyButton.addActionListener(this);
        add(multiplyButton);
        
        divideButton = new JButton("/");
        divideButton.setBounds(260, 100, 70, 40);
        divideButton.addActionListener(this);
        add(divideButton);
        
        labelResult = new JLabel("Result:");
        labelResult.setBounds(20, 160, 150, 20);
        add(labelResult);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            performCalculation("+");
        } else if (e.getSource() == subtractButton) {
            performCalculation("-");
        } else if (e.getSource() == multiplyButton) {
            performCalculation("*");
        } else if (e.getSource() == divideButton) {
            performCalculation("/");
        }
    }
    
    private void performCalculation(String operation) {
        String num1String = textFieldNum1.getText();
        String num2String = textFieldNum2.getText();
        
        if (num1String.isEmpty() || num2String.isEmpty()) {
            labelResult.setForeground(Color.RED);
            labelResult.setText("Please enter two numbers.");
            return;
        }
        
        try {
            double num1 = Double.parseDouble(textFieldNum1.getText());
            double num2 = Double.parseDouble(textFieldNum2.getText());
            char operator = operation.charAt(0);
            
            double result = 0;
            
            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    labelResult.setForeground(Color.RED);
                    labelResult.setText("Invalid operator. Please enter a valid operator (+, -, *, /).");
                    return;
            }
            
            labelResult.setForeground(Color.GREEN);
            labelResult.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
            labelResult.setForeground(Color.RED);
            labelResult.setText("Invalid input. Please enter numbers only.");
        }
    }
}
