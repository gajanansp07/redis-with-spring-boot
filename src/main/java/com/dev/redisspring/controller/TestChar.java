package com.dev.redisspring.controller;

public class TestChar {
	
	public static void main(String[] args) {
		char num = '5';
        int number = Character.getNumericValue(num);
        System.out.println("Number: "+fact(number));
	}

	private static int fact(int num) {
		if(num<=0 || num ==1) {
			return num;
		}
		return num*fact(--num);
	}

}
