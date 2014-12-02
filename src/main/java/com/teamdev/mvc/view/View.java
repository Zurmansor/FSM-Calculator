package com.teamdev.mvc.view;

import javax.swing.*;
import java.awt.*;

public class View {
    final private int FORM_WIDTH = 450;
    final private int FORM_HEIGHT = 120;

    private JPanel fieldsPanel;
    private JPanel errorPanel;
    private JButton calculateBtn;
    private JTextField expressionField;
    private JLabel solutionLabel;
    private JLabel errorLabel;

    public View() {
        JFrame frame = new JFrame("Calculator");
        fieldsPanel = new JPanel();
        errorPanel = new JPanel();
        calculateBtn = new JButton("Calculate");
        expressionField = new JTextField(20);
        solutionLabel = new JLabel();
        errorLabel = new JLabel("error");

        frame.setSize(FORM_WIDTH, FORM_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        fieldsPanel.add(expressionField);
        fieldsPanel.add(solutionLabel);

        errorPanel.add(fieldsPanel,BorderLayout.NORTH);
        errorPanel.add(errorLabel, BorderLayout.CENTER);

        frame.add(calculateBtn, BorderLayout.SOUTH);
        frame.add(errorPanel,BorderLayout.CENTER);

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
