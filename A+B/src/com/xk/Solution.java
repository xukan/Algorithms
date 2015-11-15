package com.xk;
/*
 * Write a function that add two numbers A and B. You should not use + or any arithmetic operators.
 * 
 * Clarification
 * Are a and b both 32-bit integers?
 * Yes.
 * Can I use bit operation?
 * Sure you can
 * */
public class Solution {
	public static int aplusb(int a, int b) {
		while(b!=0){
			int carry = a&b;
			a = a^b;// plus
			b = carry<<1;//carry
		}
		return a;
	}
	
	public static void main(String[] args) {
		int res = aplusb(100, -105);
		System.out.println(res);
	}
}
