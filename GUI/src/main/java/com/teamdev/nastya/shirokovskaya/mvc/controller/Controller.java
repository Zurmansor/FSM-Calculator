package com.teamdev.nastya.shirokovskaya.mvc.controller;


import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.mvc.model.Model;
import com.teamdev.nastya.shirokovskaya.mvc.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

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
                calculateButtonEvent();
            }
        };
        calculateBtn.addActionListener(actionListener);


        JTextArea expressionField = view.getExpressionField();

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // если нажата комбинация CTRL+ENTER, отправляем выражение как по кнопке Calculate
                if ((e.getKeyCode() == KeyEvent.VK_ENTER) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    calculateButtonEvent();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        expressionField.addKeyListener(keyListener);
    }

    public void calculateButtonEvent(){
        String mathExpression = view.getExpression();
//        double result = 0;
        HashMap<String, Double> result = null;
        try {
            result = model.calcExpression(mathExpression);
            view.setResult(result);
        } catch (EvaluationException e) {
            view.setError(e.getMessage(), e.getErrorIndex());
        }
    }


}
