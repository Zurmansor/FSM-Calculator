package com.teamdev.nastya.shirokovskaya.console;

import com.google.common.base.*;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;

import java.util.Scanner;

public class Start {
    public static void main(String[] args){
        Scanner scanner = new Scanner( System.in);
        String mathExpression = scanner.nextLine();//считываем одну строку целиком

        while (!mathExpression.equals("exit")){
            final StateMachineCalculator calculator = new StateMachineCalculator();

            try {
                double result = calculator.start(mathExpression);
                System.out.println(result);
            } catch (EvaluationException e) {
                System.out.println(Strings.padStart((char)(8593)+"", e.getErrorIndex(), ' '));
                System.out.println("Calculation error: " + e.getMessage());
                System.out.println("at position " + e.getErrorIndex());
            }
            mathExpression = scanner.nextLine();
        }


    }
}
