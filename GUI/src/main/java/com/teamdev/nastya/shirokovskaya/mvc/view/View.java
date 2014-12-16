package com.teamdev.nastya.shirokovskaya.mvc.view;

import javax.swing.*;
import java.awt.*;

public class View {
    final private int FORM_WIDTH = 450;
    final private int FORM_HEIGHT = 130;

    private JLabel expressionLabel;
    private JTextField expressionField;
    private JLabel resultLabel;
    private JLabel resultField;
    private JButton calculateBtn;

    public View() {
        JFrame frame = new JFrame("Calculator");
        calculateBtn = new JButton("Calculate");
        expressionField = new JTextField(20);

        expressionLabel = new JLabel("Enter the expression:");
        resultLabel = new JLabel("Result:");
        resultField = new JLabel("");

        frame.setSize(FORM_WIDTH, FORM_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        expressionLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        resultField.setBackground(Color.RED);

        expressionLabel.setBounds(10, 10, 130, 20);
        resultLabel.setBounds(10, 35, 130, 20);

        expressionField.setBounds(150, 10, 280, 20);
        resultField.setBounds(150, 35, 280, 20);

        calculateBtn.setBounds(150, 70, 150, 20);

        frame.add(expressionLabel);
        frame.add(expressionField);
        frame.add(resultLabel);
        frame.add(resultField);
        frame.add(calculateBtn);

        frame.setVisible(true);
    }

    public String getExpression(){
        return expressionField.getText();
    }

    public JButton getCalculateBtn() {
        return calculateBtn;
    }

    public JTextField getExpressionField() {
        return expressionField;
    }

    public void setResult (double result) {
        resultField.setForeground(Color.BLACK);
        resultField.setText(String.valueOf(result));
    }

    public void setError (String error, int position) {
        resultField.setForeground(Color.RED);
        resultField.setText(error + " at position " + position);
        expressionField.setCaretPosition(position);
        expressionField.requestFocus();
    }
}
