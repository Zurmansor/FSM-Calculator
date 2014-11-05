package com.teamdev.ui;

import com.teamdev.calculator.impl.StateMachineCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainForm {
    final private int FORM_WIDTH = 450;
    final private int FORM_HEIGHT = 120;

    private JPanel fieldsPanel;
    private JPanel errorPanel;
    private JButton calculateBtn;
    private JTextField expressionField;
    private JLabel solutionLabel;
    private JLabel errorLabel;

    public MainForm() {
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

        addListeners();

        frame.setVisible(true);
    }

    private void addListeners () {
        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                pushExpression();
            }
        });


        expressionField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // если нажа ENTER, отправляем выражение как по кнопке Calculate
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    pushExpression();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    private void pushExpression () {
        // EVENT FOR THE CALC BUTTON
        final StateMachineCalculator calculator = new StateMachineCalculator();
        String mathExpression;
        mathExpression = expressionField.getText();
        calculator.start(mathExpression);
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
