package com.teamdev.nastya.shirokovskaya.mvc.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class View {
    final private int FORM_WIDTH = 480;
    final private int FORM_HEIGHT = 250;
    private final JFrame frame;

    private JLabel expressionLabel;
    private JTextArea expressionField;
    private JLabel resultLabel;
    private JLabel resultField;
    private JButton calculateBtn;
    private JLabel calculateLabel;

    public View() {
        frame = new JFrame("Calculator");
        calculateBtn = new JButton("Calculate");
        calculateLabel = new JLabel("Ctrl + Enter");
//        expressionField = new JTextField(20);
        expressionField = new JTextArea();

        expressionLabel = new JLabel("Enter the expression:");
        resultLabel = new JLabel("Result:");
        resultField = new JLabel("");

        JScrollPane expressionPanel = new JScrollPane(expressionField);
        JScrollPane resultPanel = new JScrollPane(resultField);

        frame.setSize(FORM_WIDTH, FORM_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        expressionLabel.setHorizontalAlignment(SwingConstants.RIGHT);

//        resultField.setBackground(Color.RED);
        calculateLabel.setForeground(Color.GRAY);

        expressionLabel.setBounds(10, 10, 130, 20);



        resultLabel.setBounds(10, 100, 130, 20);

        expressionPanel.setBounds(150, 10, 300, 70);
        expressionField.setBounds(0, 0, 300, 70);

        resultPanel.setBounds(150, 100, 300, 70);
        resultField.setBounds(0, 0, 300, 20);
        resultField.setVerticalAlignment(SwingConstants.TOP);

        calculateBtn.setBounds(150, 190, 150, 20);
        calculateLabel.setBounds(310, 190, 150, 20);

//        JTextArea ta = new JTextArea();

        frame.add(expressionLabel);
        frame.add(expressionPanel);
        frame.add(resultLabel);
        frame.add(resultPanel);
        frame.add(calculateBtn);
        frame.add(calculateLabel);

        frame.setVisible(true);
    }

    public String getExpression(){
        return expressionField.getText();
    }

    public JButton getCalculateBtn() {
        return calculateBtn;
    }

    public JTextArea getExpressionField() {
        return expressionField;
    }

    public void setResult (HashMap<String, Double> result) {
        resultField.setForeground(Color.BLACK);

        String resultText = "";

        // if simple calculator operation
        if (result.size() == 1 && result.containsKey(null)) {
            resultText = String.valueOf(result.get(null));
        } else {
            for (String variable : result.keySet()) {
                if (variable == null) {
                    continue;
                }
                resultText = variable + " = " + result.get(variable) + "<br/>" + resultText;
            }

            resultText = "<html><body>" + resultText + "</body></html>";
        }
        resultField.setText(resultText);
        resultField.setSize(resultField.getPreferredSize());
    }

    public void setError (String error, int position) {
        resultField.setForeground(Color.RED);
        resultField.setText(error + " at position " + position);
        expressionField.setCaretPosition(position);
        expressionField.requestFocus();
    }
}
