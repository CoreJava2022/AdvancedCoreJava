package com.example.jarcreate;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello Jar File is created.....");
		
		HelloJava hello = new HelloJava();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Name: ");
		String n = sc.nextLine();
		
		hello.setName(n);
	System.out.println("My name is: "+hello.getName());	
	}

}
