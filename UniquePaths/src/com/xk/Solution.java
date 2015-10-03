package com.xk;

public class Solution {
	public int uniquePaths(int m, int n) {
		int small= 0, large = 0;
		if(m<n){
			small = m-1;
			large = n-1;
		}else{
			small = n-1;
			large = m-1;
		}
		long denom =1, numer =1;
		for(int i=1;i<=small;i++){
			denom *= i;
			numer *= (large+i);
		}
		int result = (int) (numer/denom);
		return result;
	}
	public static void main(String[] args){
		int m = 8, n=5;
		Solution s = new Solution();
		int res = s.uniquePaths(m, n);
		System.out.println(res);
	}
}
