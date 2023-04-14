package com.example;

import java.util.*;

public class NumAlphaDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = sc.nextInt();
		
		for(int i=num;i<=26;i++) {
			System.out.println(i);
			for(int j=i;j<=i;j++) {
				j=j+64;
				System.out.println((char)j);
			}
		}
	}
}
