package com.xk;

public class Solution {
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res =0;
        for(int i=0;i<32;i++){
        	//res每次都要左移一位
            res <<=1;
            if( (n & 1) !=0){
                res += 1;
            }
            n>>=1;
        }
        return res;
    }
    
    public static void main(String[] args) {
		int input = 8;
		int res = reverseBits(input);
		System.out.println(res);
	}
}
