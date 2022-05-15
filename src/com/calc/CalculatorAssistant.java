package com.calc;

class CalculatorAssistant {

    public static void checkSeparator(String[] operands) throws Exception {
        if (operands[0].contains(".") || operands[0].contains(",") ||
                operands[1].contains(".") || operands[1].contains(",")) {
            throw new Exception("В арифметической записи не должно быть разделителей дробных частей");
        }
    }

    public static boolean checkRoman(String[] operands) throws Exception {
        boolean firstOperandIsRomanian = false;
        boolean secondOperandIsRomanian = false;
        for (Roman value : Roman.values()) {
            if (operands[0].contains(value.toString())) {
                firstOperandIsRomanian = true;
            }
            if (operands[1].contains(value.toString())) {
                secondOperandIsRomanian = true;
            }
        }
        if (!firstOperandIsRomanian && secondOperandIsRomanian) {
            parseToInt(operands[0]);
            throw new Exception("Используются одновременно разные системы счисления");
        } else if (!secondOperandIsRomanian && firstOperandIsRomanian) {
            parseToInt(operands[1]);
            throw new Exception("Используются одновременно разные системы счисления");
        }

        return firstOperandIsRomanian && secondOperandIsRomanian;
    }

    public static int parseToInt(String operand) throws Exception {
        int number = Integer.parseInt(operand);
        if (number < 1 || number > 10) {
            throw new Exception("Входные данные не удовлетворяют условию \"на вход числа от 1 до 10\"");
        }
        return number;
    }

    public static ArithmeticOperation getOperator(String input) {
        ArithmeticOperation operator = null;
        for (int i = 0; i < ArithmeticOperation.values().length; i++) {
            if (getIndex(input, ArithmeticOperation.values()[i]) != -1) {
                operator = ArithmeticOperation.values()[i];
            }
        }
        return operator;
    }

    public static int getIndex(String input, ArithmeticOperation operation) {
        return input.indexOf(operation.getOperation());
    }

    public static int getIndex(String input, ArithmeticOperation operation, Boolean b) {
        int i = getIndex(input, operation);
        return input.indexOf(operation.getOperation(), i + 1);
    }

    public static void inputCheck(String input) throws Exception {
        int count = 0;
        for (int i = 0; i < ArithmeticOperation.values().length; i++) {
            if (getIndex(input, ArithmeticOperation.values()[i]) != -1) {
                count++;
                if (getIndex(input, ArithmeticOperation.values()[i], true) != -1 || count > 1) {
                    throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
            }
        }
        if (count == 0) {
            throw new Exception("Строка не является математической операцией!");
        }
    }

    public static int parseRomanToArab(String operand) {
        return Roman.valueOf(operand).getNumber();
    }

    public static void checkNegativeAndZeroResult(int firstOperand, int secondOperand, String operation) throws Exception {
        if (firstOperand <= secondOperand && operation.equals("-") || firstOperand < secondOperand && operation.equals("/")) {
            throw new Exception("Выполнение арифметической операции невозможно. В римской системе нет ноля и отрицательных чисел.");
        }
    }
}
