package com.cjc.practice;

import java.util.Scanner;

public class MobileN {
	
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Mobile Number");
		String number=sc.next();
	
		if(number.length()!=10)
		{
			System.out.println("Invalid Mobile Number");
		}
		for(int i=0;i<=number.length();i++)
		{
			if(!Character.isDigit(number.charAt(i)))
			{
				System.err.println("Invalid Number");
			}
		}
	}
	
}
