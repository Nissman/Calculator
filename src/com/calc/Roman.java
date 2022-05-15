package com.calc;

import java.util.HashMap;
import java.util.Map;

enum Roman {

    I("1", 1),
    II("2", 2),
    III("3", 3),
    IV("4", 4),
    V("5", 5),
    VI("6", 6),
    VII("7", 7),
    VIII("8", 8),
    IX("9", 9),
    X("10", 10);

    private int number;
    private String strNumber;

    Roman(String strNumber, int number) {
        this.strNumber = strNumber;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private static Map<String, Roman> map = new HashMap<>();

    static {
        for (Roman roman : Roman.values()) {
            map.put(roman.strNumber, roman);
        }
    }

    public static String getRomeByArabian(String number) {
        return map.get(number).toString();
    }
}

