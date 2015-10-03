package com.xk;

public class Solution {
	public static int reverse(int x) {
		int num=Math.abs(x);
        int carry = 0, res=0;
        while(num!=0){
        	carry = num%10;
        	num= num/10;
        	res = res*10+carry;
        }
        if(res>Integer.MAX_VALUE)
            return 0;
        return (x>0)?res:-res;
    }
	
	public static void main(String[] args){
		int input = -1234;
		int rev = reverse(input);
		System.out.println(rev);
	}
}
