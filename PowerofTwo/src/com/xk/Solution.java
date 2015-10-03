package com.xk;

public class Solution {
	public static boolean isPowerOfTwo(int n) {
		if(n<=0)
            return false;
        int remain = 0;
        while(n>=2){
            remain = n%2;
            if(remain!=0)
                return false;
            n/=2;
        }
        return true;
    }
	
	public static void main(String[] args){
		boolean res = isPowerOfTwo(5);
		System.out.println(res);
	}
}
