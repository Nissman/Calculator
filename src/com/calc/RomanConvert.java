package com.calc;

class RomanConvert {
    public static String convertArabToRoman(int number) {
        String romanNumber = "";
        int integC = number / 100;
        int remC = number % 100;
        int integL = remC / 50;
        int remL = remC % 50;
        int integX = remL / 10;
        int remX = remL % 10;
        if (integC > 0) {
            romanNumber += C(integC);
        }
        if (integL > 0) {
            romanNumber += L(integL);
        }
        if (integX > 0) {
            romanNumber += X(integX);
        }
        if (remX > 0) {
            romanNumber += basic(remX);
        }
        return romanNumber;
    }

    private static String C(int number) {
        if ((number != 0) && (number < 4)) {
            String romanNumber = "";
            int i = 0;
            while (i < number) {
                romanNumber += "C";
                i++;
            }
            return romanNumber;
        } else return "";
    }

    private static String L(int number) {
        if (number == 4) return "XC";
        return "L";
    }

    private static String X(int number) {
        if (number == 4) return "XL";
        else if ((number != 0) && (number < 4)) {
            String romanNumber = "";
            int i = 0;
            while (i < number) {
                romanNumber += "X";
                i++;
            }
            return romanNumber;
        } else return "";
    }

    private static String basic(int number) {
        String num = Integer.toString(number);
        return Roman.getRomeByArabian(num);
    }
}
