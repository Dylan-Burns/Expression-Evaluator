package edu.csc413.calculator.evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private final JTextField expressionTextField = new JTextField();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // buttonText[] array contains the text for corresponding buttons
    private static final String[] buttonText = {
        "7", "8", "9", "+",
        "4", "5", "6", "-", 
        "1", "2", "3", "*", 
        "(", "0", ")", "/", 
        "C", "CE", "=", "^"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private final JButton[] buttons = new JButton[buttonText.length];

    public static void main(String[] args) {
        new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.expressionTextField.setPreferredSize(new Dimension(600, 50));
        this.expressionTextField.setFont(new Font("Courier", Font.BOLD, 24));
        this.expressionTextField.setHorizontalAlignment(JTextField.CENTER);

        add(expressionTextField, BorderLayout.NORTH);
        expressionTextField.setEditable(false);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in buttonText[] array
        JButton tempButtonReference;
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            tempButtonReference = new JButton(buttonText[i]);
            tempButtonReference.setFont(new Font("Courier", Font.BOLD, 24));
            buttons[i] = tempButtonReference;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This function is triggered anytime a button is pressed
     * on our Calculator GUI.
     * @param actionEventObject Event object generated when a
     *                    button is pressed.
     */
    public void actionPerformed(ActionEvent actionEventObject) {
        if(actionEventObject.getSource()==buttons[0]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[0]);
        }

        if(actionEventObject.getSource()==buttons[1]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[1]);
        }

        if(actionEventObject.getSource()==buttons[2]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[2]);
        }

        if(actionEventObject.getSource()==buttons[3]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[3]);
        }

        if(actionEventObject.getSource()==buttons[4]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[4]);
        }

        if(actionEventObject.getSource()==buttons[5]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[5]);
        }

        if(actionEventObject.getSource()==buttons[6]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[6]);
        }

        if(actionEventObject.getSource()==buttons[7]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[7]);
        }

        if(actionEventObject.getSource()==buttons[8]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[8]);
        }

        if(actionEventObject.getSource()==buttons[9]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[9]);
        }

        if(actionEventObject.getSource()==buttons[10]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[10]);
        }

        if(actionEventObject.getSource()==buttons[11]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[11]);
        }

        if(actionEventObject.getSource()==buttons[12]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[12]);
        }

        if(actionEventObject.getSource()==buttons[13]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[13]);
        }

        if(actionEventObject.getSource()==buttons[14]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[14]);
        }

        if(actionEventObject.getSource()==buttons[15]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[15]);
        }

        if(actionEventObject.getSource()==buttons[16]){
            expressionTextField.setText("" + expressionTextField.getText().substring(0, expressionTextField.getText ().length() - 1));
        }

        if(actionEventObject.getSource()==buttons[17]){
            expressionTextField.setText("");
        }

        if(actionEventObject.getSource()==buttons[18]){
            Evaluator calc = new Evaluator();
            try {
                expressionTextField.setText(Integer.toString(calc.evaluateExpression(expressionTextField.getText())));
            } catch (InvalidTokenException e) {
                e.printStackTrace();
            }
        }

        if(actionEventObject.getSource()==buttons[19]){
            expressionTextField.setText(expressionTextField.getText() + buttonText[19]);
        }

    }
}
