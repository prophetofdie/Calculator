class Calculator {
    String mainLine;
    int answer;
    int[] Arab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    String[] Rom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    int[] arg = {0, 0};

    public Calculator(String input) {
        if (input == null) throw new Error("throws Exception //т.к. строка имеет значение null");
        mainLine = input.replaceAll(" ", "");
    }

    String calculate() {
        char operator_String = find_operator();

        String[] argString = mainLine.split("[+-/*]");

        if (argString.length != 2)
            throw new Error("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда типа int и один оператор (+, -, /, *)");

        int roman = 0;
        for (int i = 0; i < arg.length; i++) {
            arg[i] = to_arab(argString[i]);
            if (arg[i] == -1) arg[i] = Integer.parseInt(argString[i]);
            else roman++;
        }

        answer = do_operator(arg[0], arg[1], operator_String);
        if (roman == arg.length) return to_roman(answer);
        else if (roman == 0) return String.valueOf(answer);
        else throw new Error("throws Exception //т.к. используются одновременно разные системы счисления");
        // Amir mouse and Lesya not mouse
    }

    char find_operator() {
        if (mainLine.indexOf('*') != -1) return '*';
        if (mainLine.indexOf('+') != -1) return '+';
        if (mainLine.indexOf('-') != -1) return '-';
        if (mainLine.indexOf('/') != -1) return '/';
        else throw new Error("throws Exception //т.к. строка не является математической операцией");
    }

    String to_roman(int num) {
        if (num < 1) throw new Error("throws Exception //т.к. в римской системе только положительные числа");
        String res = "";
        int I = num % 10;
        int X = num - I;
        for (int i = 0; i < Arab.length; ++i) {
            if (X == Arab[i]) {
                res += Rom[i];
                break;
            }
        }
        for (int i = 0; i < Arab.length; ++i) {
            if (I == Arab[i]) {
                res += Rom[i];
                break;
            }
        }
        return res;
    }

    int to_arab(String text) {
        text = text.toUpperCase();
        for (int i = 0; i < Rom.length; ++i) {
            if (text.equals(Rom[i]))
                return Arab[i];
        }
        return -1;
    }

    int do_operator(int arg1, int arg2, char operation) {
        if (arg1 > 10 || arg2 > 10) throw new Error("throws Exception //т.к. используются число больше 10");
        switch (operation) {
            case ('+'):
                return arg1 + arg2;
            case ('-'):
                return arg1 - arg2;
            case ('*'):
                return arg1 * arg2;
            case ('/'):
                if (arg2 == 0) throw new Error("throws Exception //т.к деление на ноль не определено");
                return arg1 / arg2;
            default:
                throw new Error("throws Exception //никогда не сработает");
        }
    }
}