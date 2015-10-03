package com.xk;

public class Solution {
	public int maxProduct(int[] A) {
	    if(A==null || A.length==0)  
	        return 0;  
	    
	    int maxLocal = A[0];  
	    int minLocal = A[0];  
	    int global = A[0];  
	 
	    for(int i=1; i<A.length; i++){  
	        int temp = maxLocal;  
	        maxLocal = Math.max(Math.max(A[i]*maxLocal, A[i]), A[i]*minLocal);  
	        minLocal = Math.min(Math.min(A[i]*temp, A[i]), A[i]*minLocal);  
	        global = Math.max(global, maxLocal);  
	    }  
	    return global;
	}
<<<<<<< HEAD
	 
=======
	
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	public static void main(String[] args){
		int[] input = {2,3,-2,4,-6};
		Solution s = new Solution();
		int res = s.maxProduct(input);
		System.out.println(res);
	}
}
