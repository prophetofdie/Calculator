import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(calc(scan.nextLine()));
    }

    public static String calc(String input) {
        Calculator object = new Calculator(input);
        return object.calculate();
    }
}
