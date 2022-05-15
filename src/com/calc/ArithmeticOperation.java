package com.calc;

enum ArithmeticOperation {

    ADD("+") {
        public int action(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        public int action(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        public int action(int x, int y) {
            return x * y;
        }
    },
    DIVISION("/") {
        public int action(int x, int y) {
            return x / y;
        }
    };
    private String operation;

    ArithmeticOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public abstract int action(int x, int y);
}

