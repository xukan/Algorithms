package com.xk;

public class Solution {
	public int climbStairs(int n) {
		int f1 = 1;
		int f2 = 2;
		if(n==1)
			return f1;
		if(n==2)
			return f2;
		int fn=0;
		for(int i=3;i<=n;i++){
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
		}
		return fn;
    } 
	
	/*
	 * recursion : timeout
	public int climbStairs(int n) {
        
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return climbStairs(n-1)+climbStairs(n-2);
            
    }*/
	
	
	public static void main(String[] args){
		int n = 10;
		Solution s = new Solution();
		int res = s.climbStairs(n);
		System.out.println(res);
	}
}
