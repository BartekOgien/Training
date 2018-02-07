package com.examples.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    // task from:
    // https://www.codewars.com/kata/calculator

    public Double evaluate(String expression) {

        String[] splitExpression = expression.split(" ");
        if(splitExpression.length > 1) {

            List<String> expressionList = Arrays.stream(splitExpression)
                                        .collect(Collectors.toList());
            int mathExpressionIndex = 0;
            int mathExpressionIndexMultiply = 0;
            int mathExpressionIndexDivide = 0;
            boolean isMultipply = false;
            double result = 0;
            String tempString = "";

            while(expressionList.contains("*") || expressionList.contains("/")) {
                mathExpressionIndexMultiply = expressionList.indexOf("*");
                mathExpressionIndexDivide = expressionList.indexOf("/");
                if(mathExpressionIndexMultiply > 0 && mathExpressionIndexDivide > 0) {
                    if(mathExpressionIndexMultiply >  mathExpressionIndexDivide) {
                        mathExpressionIndex = mathExpressionIndexDivide;
                        isMultipply = false;
                    }
                    else {
                        mathExpressionIndex = mathExpressionIndexMultiply;
                        isMultipply = true;
                    }
                }
                else {
                    if (expressionList.contains("*")) {
                        mathExpressionIndex = mathExpressionIndexMultiply;
                        isMultipply = true;
                    }
                    else {
                        mathExpressionIndex = mathExpressionIndexDivide;
                        isMultipply = false;
                    }
                }

                if(isMultipply) {
                    result = Double.valueOf(expressionList.get(mathExpressionIndex - 1)) * Double.valueOf(expressionList.get(mathExpressionIndex + 1));
                }
                else {
                    result = Double.valueOf(expressionList.get(mathExpressionIndex - 1)) / Double.valueOf(expressionList.get(mathExpressionIndex + 1));
                }

                expressionList.add(mathExpressionIndex + 2, String.valueOf(result));
                for(int i = 0; i <= 2; i++) {
                    expressionList.remove(mathExpressionIndex - 1);
                }
            }

            while(expressionList.contains("+")) {
                mathExpressionIndex = expressionList.indexOf("+");
                result = Double.valueOf(expressionList.get(mathExpressionIndex - 1)) + Double.valueOf(expressionList.get(mathExpressionIndex + 1));
                expressionList.add(mathExpressionIndex + 2, String.valueOf(result));

                for(int i = 0; i <= 2; i++) {
                    expressionList.remove(mathExpressionIndex - 1);
                }
            }

            while(expressionList.contains("-")) {
                mathExpressionIndex = expressionList.indexOf("-");
                result = Double.valueOf(expressionList.get(mathExpressionIndex - 1)) - Double.valueOf(expressionList.get(mathExpressionIndex + 1));
                expressionList.add(mathExpressionIndex + 2, String.valueOf(result));

                for(int i = 0; i <= 2; i++) {
                    expressionList.remove(mathExpressionIndex - 1);
                }
            }

           return result;
        }
        else {
            return Double.valueOf(expression);
        }
    }
}
