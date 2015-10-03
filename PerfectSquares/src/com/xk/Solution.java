package com.xk;
//https://leetcode.com/discuss/56982/o-sqrt-n-in-ruby-and-c
//Lagrange ��ƽ������ �κ�һ�������������Ա�ʾ�ɲ������ĸ�������ƽ��֮�͡�
/*Fermat's theorem on sums of two squares:
 *һ��������p�ܱ�ʾΪ��������ƽ���ͣ�p = x^2 + y^2,���p ��1(mod 4).
 * 
*/
/*
 * Legendre's three-square theorem
 * a natural number can be represented as the sum of three squares of integers:
 * n = x^2 + y^2 + z^2, 
 * if and only if n is not of the form n = 4^a(8b + 7) for integers a and b. 
 * */
public class Solution {
	public static int numSquares(int n) {
		int temp = n;
        while(temp%4==0)
        	temp/=4;
        if(temp%8==7)
        	return 4;
        for(int a =0;a*a<=n;a++){
        	int b = (int)Math.sqrt(n-a*a);
        	if(a*a+b*b == n)
        		return (a==0)?1:2;
        }
        return 3;
    }
	
	public static void main(String[] args) {
		int n = 10;
		int num = numSquares(n);
		System.out.println(num);
	}
}
