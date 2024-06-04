package com.cjc.practice;

import java.util.Scanner;

public class NameValidation {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        if (isValidFirstName(firstName)) {
            System.out.println("Valid first name: " + firstName);
        } else {
            System.out.println("Invalid first name. Please enter only letters without spaces, special characters, or numbers.");
        }

		}
    

    private static boolean isValidFirstName(String firstName) {
        // Regular expression to match only letters
        return firstName.matches("[a-zA-Z]+");
    }
		
		
		
	}

