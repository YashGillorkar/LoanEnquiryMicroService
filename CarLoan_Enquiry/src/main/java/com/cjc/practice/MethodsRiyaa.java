package com.cjc.practice;

import java.util.Scanner;

public class MethodsRiyaa {
	
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Email ID");
		String e=sc.next();
		if(e.endsWith("@gmail.com"))
		{
			System.out.println("You are Good to go");
		}
		else
		{
			System.out.println("InvalidEmailException");
		}
	}
	
	
}
