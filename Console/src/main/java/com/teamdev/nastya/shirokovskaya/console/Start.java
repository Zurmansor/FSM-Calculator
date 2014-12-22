package com.teamdev.nastya.shirokovskaya.console;

import com.google.common.base.*;
import com.teamdev.nastya.shirokovskaya.core.EvaluationException;
import com.teamdev.nastya.shirokovskaya.core.impl.StateMachineCalculator;

import java.util.HashMap;
import java.util.Scanner;


public class Start {
    public static void main(String[] args){
        Scanner scanner = new Scanner( System.in);
        String mathExpression = scanner.nextLine();//считываем одну строку целиком

        while (!mathExpression.equals("exit")){
            final StateMachineCalculator calculator = new StateMachineCalculator();

            try {
                HashMap<String, Double> result = calculator.evaluate(mathExpression);

                String resultText = "";
                if (result.size() == 1 && result.containsKey(null)) {
                    resultText = String.valueOf(result.get(null));
                } else {
                    for (String variable : result.keySet()) {
                        if (variable == null) {
                            continue;
                        }
                        resultText = variable + " = " + result.get(variable) + "\n" + resultText;
                    }
                }

                System.out.println(resultText);
            } catch (EvaluationException e) {
                System.out.println(Strings.padStart((char)(8593)+"", e.getErrorIndex(), ' '));
                System.out.println("Calculation error: " + e.getMessage());
                System.out.println("at position " + e.getErrorIndex());
            }
            mathExpression = scanner.nextLine();
        }

    }
}
