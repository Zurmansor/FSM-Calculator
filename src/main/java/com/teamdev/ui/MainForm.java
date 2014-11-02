package com.teamdev.ui;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.impl.StateMachineCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainForm {
    final private int FORM_WIDTH = 500;
    final private int FORM_HEIGHT = 250;
    private JButton calculateBtn;
    private JTextField expressionField;
    private JLabel solutionLabel;

    public MainForm() {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(FORM_WIDTH, FORM_HEIGHT);
        frame.setResizable(false);

        calculateBtn = new JButton("Calculate");
        frame.add(calculateBtn, BorderLayout.SOUTH);

        expressionField = new JTextField("Enter the expression");
        frame.add(expressionField, BorderLayout.PAGE_START);

        solutionLabel = new JLabel();
        frame.add(solutionLabel, BorderLayout.CENTER);

       calculateBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               // EVENT FOR THE CALC BUTTON
               final StateMachineCalculator calculator = new StateMachineCalculator();
               String mathExpression;
               mathExpression = expressionField.getText();
               try {
                   System.out.println(mathExpression);
                   final double result = calculator.evaluate(mathExpression);
                   mathExpression = "" + result;
                   System.out.println("result = " + result);
                   solutionLabel.setText("result = " + result);
               } catch (EvaluationException e) {
                   solutionLabel.setText("Calculation error: " + e.getMessage() + " Position: " + e.getErrorIndex());
               }
           }
       });
        frame.setVisible(true);
    }
}
