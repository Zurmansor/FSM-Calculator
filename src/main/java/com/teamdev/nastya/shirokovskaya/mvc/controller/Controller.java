package com.teamdev.nastya.shirokovskaya.mvc.controller;


import com.teamdev.nastya.shirokovskaya.calculator.EvaluationException;
import com.teamdev.nastya.shirokovskaya.mvc.model.Model;
import com.teamdev.nastya.shirokovskaya.mvc.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void control(){
        JButton calculateBtn = view.getCalculateBtn();
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                buttonEvent();
            }
        };
        calculateBtn.addActionListener(actionListener);


        JTextField expressionField = view.getExpressionField();

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // если нажа ENTER, отправляем выражение как по кнопке Calculate
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    buttonEvent();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        expressionField.addKeyListener(keyListener);
    }

    public void buttonEvent(){
        String mathExpression = view.getExpression();
        double result = 0;
        try {
            result = model.calcExpression(mathExpression);
            view.setResult(result);
        } catch (EvaluationException e) {
            view.setError(e.getMessage(), e.getErrorIndex());
        }
    }


}
