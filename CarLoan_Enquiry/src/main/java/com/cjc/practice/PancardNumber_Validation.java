package com.cjc.practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PancardNumber_Validation {

    private static final String PAN_PATTERN = "^[A-Z]{5}[0-9]{4}[A-Z]$";

    public static boolean isValidPAN(String panCardNumber) {
        return Pattern.matches(PAN_PATTERN, panCardNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter PAN card number:");
        String pancardNo = scanner.nextLine();

        if (isValidPAN(pancardNo)) {
            System.out.println("PAN Card Number is valid.");
        } else {
            System.err.println("Invalid PAN Card Number: " + pancardNo);
        }

        scanner.close();
    }
}
