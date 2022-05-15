package com.calc;

import java.util.Scanner;

import static com.calc.CalculatorAssistant.*;
import static com.calc.RomanConvert.convertArabToRoman;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию с двумя целыми арабскими или римскими числами от 1 до 10 и от I до X соответственно");
        String input = in.nextLine();
        in.close();
        if (input.isEmpty()) {
            System.out.println("Введена пустая строка! Результата нет.");
        } else {
            String result = calc(input);
            if (result != null) {
                System.out.printf("Результат вычислений: %s", result);
            }
        }
    }

    public static String calc(String input) {
        input = input.replaceAll("\\s", "");
        String result = null;
        try {
            inputCheck(input);
            ArithmeticOperation operator = getOperator(input);
            String[] operands = input.split("[" + operator.getOperation() + "]");
            checkSeparator(operands);
            if (checkRoman(operands)) {
                int x = parseRomanToArab(operands[0]);
                int y = parseRomanToArab(operands[1]);
                checkNegativeAndZeroResult(x, y, operator.getOperation());
                result = convertArabToRoman(operator.action(x, y));
            } else {
                result = Integer.toString(operator.action(parseToInt(operands[0]), parseToInt(operands[1])));
            }
        } catch (NumberFormatException e) {
            System.out.println("Входные данные не удовлетворяют условию \"на вход числа от 1 до 10 и от I до X\"");
        } catch (IllegalArgumentException e) {
            System.out.println("Входные данные не удовлетворяют условию \"на вход числа от 1 до 10 и от I до X\"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}