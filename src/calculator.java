import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String e = sc.nextLine();
        System.out.println(calc(e));
    }

    public static String calc(String input) {
        String[] str = input.split(" ");
        if (str.length < 3) {
            throw new RuntimeException("Строка не является математической оперцией");
        }
        if (str.length > 3) {
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String first = str[0];
        String second = str[2];
        int a = 0;
        int b = 0;
        int res;
        String result = "";
        String operator = str[1];
        String[] rom = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
                "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
                "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
                "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
                "91", "92", "93", "94", "95", "96", "97", "98", "99", "100",};
        if (Character.isDigit(first.charAt(0)) && Character.isLetter(second.charAt(0)) || Character.isDigit(second.charAt(0)) && Character.isLetter(first.charAt(0))) {
            throw new RuntimeException("Используются одновременно разные системы счисления");
        }
        if (Character.isDigit(first.charAt(0)) && Character.isDigit(second.charAt(0))) {
            a = Integer.parseInt(first);
            b = Integer.parseInt(second);
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new RuntimeException("Калькулятор умеет работать только с числами от 1 до 10");
            }
            switch (operator) {
                case "+":
                    res = a + b;
                    result = Integer.toString(res);
                    break;
                case "-":
                    res = a - b;
                    result = Integer.toString(res);
                    break;
                case "*":
                    res = a * b;
                    result = Integer.toString(res);
                    break;
                case "/":
                    res = a / b;
                    result = Integer.toString(res);
                    break;
                default:
                    throw new RuntimeException("Калькулятор умеет только складывать, вычитать, умножать и делить");
            }
        }
        if (Character.isLetter(first.charAt(0)) && Character.isLetter(second.charAt(0))) {
            for (int i = 0; i < 100; i++) {
                if (first.contentEquals(rom[i])) {
                    a = Integer.parseInt(arab[i]);
                }
                if (second.contentEquals(rom[i])) {
                    b = Integer.parseInt(arab[i]);
                }
            }
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new RuntimeException("Калькулятор умеет работать только с числами от I до X");
            }
            switch (operator) {
                case "+":
                    res = a + b;
                    result = Integer.toString(res);
                    break;
                case "-":
                    res = a - b;
                    if (res < 0) {
                        throw new RuntimeException("В римской системе нет отрицательных чисел");
                    }
                    result = Integer.toString(res);
                    break;
                case "*":
                    res = a * b;
                    result = Integer.toString(res);
                    break;
                case "/":
                    res = a / b;
                    result = Integer.toString(res);
                    break;
                default:
                    throw new RuntimeException("Калькулятор умеет только складывать, вычитать, умножать и делить");
            }
            for (int i = 0; i < 100; i++) {
                if (result.contentEquals(arab[i])) {
                    result = rom[i];
                    break;
                }
            }
        }
        return result;
    }
}
