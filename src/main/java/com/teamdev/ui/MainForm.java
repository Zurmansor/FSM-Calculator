package com.teamdev.ui;

import com.teamdev.calculator.EvaluationException;
import com.teamdev.calculator.impl.StateMachineCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainForm {
    final private int FORM_WIDTH = 300;
    final private int FORM_HEIGHT = 250;

    private JPanel fieldsPanel;
    private JButton calculateBtn;
    private JTextField expressionField;
    private JLabel solutionLabel;
    private JLabel errorLabel;

//    public Font MAIN_FONT = new Font("Tahoma", Font.PLAIN, 14);

    public MainForm() {
        JFrame frame = new JFrame("Calculator");
        fieldsPanel = new JPanel(new BorderLayout());
        calculateBtn = new JButton("Calculate");
        expressionField = new JTextField("2+2");
        solutionLabel = new JLabel("label");
        errorLabel = new JLabel("error");

        frame.setSize(FORM_WIDTH, FORM_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        fieldsPanel.add(expressionField, BorderLayout.LINE_START);
        fieldsPanel.add(solutionLabel, BorderLayout.LINE_END);
        fieldsPanel.add(errorLabel, BorderLayout.SOUTH);

        frame.add(calculateBtn, BorderLayout.SOUTH);
        frame.add(fieldsPanel,BorderLayout.CENTER);


        addListeners();

        frame.setVisible(true);
    }

    private void addListeners () {
        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // EVENT FOR THE CALC BUTTON
                final StateMachineCalculator calculator = new StateMachineCalculator();
                String mathExpression;
                mathExpression = expressionField.getText();
                calculator.start(mathExpression);
            }
        });
    }

    public void setResult (double result) {
        solutionLabel.setText(String.valueOf(result));
        errorLabel.setVisible(false);
        errorLabel.setText("");
    }

    public void setError (String error, int position) {
        solutionLabel.setText("err");
        errorLabel.setText(error + " at position " + position);
        errorLabel.setVisible(true);
        expressionField.setCaretPosition(position);
        expressionField.requestFocus();
    }
}
