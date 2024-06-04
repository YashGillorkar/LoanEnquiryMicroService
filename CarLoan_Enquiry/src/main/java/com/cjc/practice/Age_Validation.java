package com.cjc.practice;

import java.util.Scanner;

public class Age_Validation {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter customer age");
		int age =sc.nextInt();
		
		System.out.println("Enter customer age"+age);
		if (age >= 21 && age <= 75) 
		{
            System.out.println("Valid age. You are " + age+ " years old.");
        } else {
            System.out.println("Invalid age. Age must be between 21 and 75 years.");
        }
	}

}
