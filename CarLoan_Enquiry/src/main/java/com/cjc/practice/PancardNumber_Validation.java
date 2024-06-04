package com.cjc.practice;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PancardNumber_Validation {

	static final String PAN_PATTERN = "^[A-Z]{5}[0-9]{4}[A-Z]$";

	public void validate(String panCardNumber) throws InvalidPANCardException {
		while (true) {
			Pattern pattern = Pattern.compile(PAN_PATTERN);
			Matcher matcher = pattern.matcher(panCardNumber);
			if (!matcher.matches()) {
				throw new InvalidPANCardException("Invalid PAN Card Number: " + panCardNumber);
			}
			// If you want to exit the loop after one validation, you can break here.
			break;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PAN card number:");
		String pancardNo = sc.nextLine();

		PancardNumber_Validation validator = new PancardNumber_Validation();

		try {
			validator.validate(pancardNo);
			System.out.println("PAN Card Number is valid.");
		} catch (InvalidPANCardException e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
}