//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String creditCardNumber;
        do {
            System.out.printf("%nPlease enter a credit card number: ");
            creditCardNumber = scanner.nextLine();
            if (!creditCardNumber.matches("\\d+")) {
                System.out.printf("Invalid input. Please enter numeric values only.%n");
            }
        } while(!creditCardNumber.matches("\\d+"));

        if (isValidPrefix(creditCardNumber) && isValidLength(creditCardNumber)) {
            if (isLuhnValid(creditCardNumber)) {
                System.out.println(creditCardNumber + " is a valid credit card number.");
            } else {
                System.out.println(creditCardNumber + " is an invalid credit card number.");
            }
        } else {
            System.out.println(creditCardNumber + " is an invalid credit card number.");
        }

        scanner.close();
    }

    public static boolean isValidPrefix(String number) {
        boolean result = number.startsWith("4") || number.startsWith("5") || number.startsWith("37") || number.startsWith("6");
        return result;
    }

    public static boolean isValidLength(String number) {
        int length = number.length();
        return length >= 13 && length <= 16;
    }

    public static boolean isLuhnValid(String number) {
        int totalSum = 0;
        boolean doubleDigit = false;

        for(int i = number.length() - 1; i >= 0; --i) {
            int digit = Character.getNumericValue(number.charAt(i));
            if (doubleDigit) {
                digit = digit * 2 > 9 ? digit * 2 - 9 : digit * 2;
            }

            totalSum += digit;
            doubleDigit = !doubleDigit;
        }

        boolean result = totalSum % 10 == 0;
        return result;
    }
}
