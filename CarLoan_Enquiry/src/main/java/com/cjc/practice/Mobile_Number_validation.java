package com.cjc.practice;

import java.util.Scanner;

public class Mobile_Number_validation {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter mobile number: ");
	        String mobileNumber = scanner.nextLine();
	        
	        if (isValidMobileNumber(mobileNumber)) {
	            System.out.println("Valid mobile number");
	        } else {
	            System.out.println("Enter a valid mobile number");
	        }
	        
	        scanner.close();
	    }

	    public static boolean isValidMobileNumber(String mobileNumber) {
	        // Check if the length is 10 and all characters are digits
	        return mobileNumber.length() == 10 && mobileNumber.matches("\\d{10}");
	    }
	

}
